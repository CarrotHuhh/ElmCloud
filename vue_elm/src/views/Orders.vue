<template>
	<div class="wrapper">
		
		<!-- header部分 -->
		<header>
			<p>确认订单</p>
		</header>
		
		<!-- 订单信息部分 -->
		<div class="order-info">
			<h5>订单配送至：</h5>
			<div class="order-info-address" @click="toUserAddress">
				<p>{{deliveryAddress!=null?deliveryAddress.address:'请选择送货地址'}}</p>
				<i class="fa fa-angle-right"></i>
			</div>
			<p>{{deliveryAddress!=null?deliveryAddress.contactName:user.userName}}{{deliveryAddress!=null?deliveryAddress.contactSex:user.userSex | sexFilter}} {{deliveryAddress!=null?deliveryAddress.contactTel:user.userId}}</p>
		</div>
		<h3>{{business.businessName}}</h3>
		
		<!-- 订单明细部分 -->
		<ul class="order-detailed">
			<li v-for="item in cartArr">
				<div class="order-detailed-left">
					<img :src="item.food.foodImg">
					<p>{{item.food.foodName}}*{{item.quantity}}</p>
				</div>
				<p>&#165;{{(item.food.foodPrice*item.quantity).toFixed(1)}}</p>
				
			</li>
		</ul>
		<div class="order-deliveryfee">
			<p>配送费</p>
			<p>&#165;{{business.deliveryPrice}}</p>
		</div>
		
		<!-- 合计部分 -->
		<div class="total">
			<div class="total-left">
				&#165;{{totalPrice}}
			</div>
			<div class="total-right" @click="toPayment">
				去支付
			</div>
		</div>
	</div>
</template>

<script>
	import { getBusinessById } from '@/service/Business';
import { listcart } from '@/service/Cart';
import { createOrders } from '@/service/Order';
import Footer from '../components/Footer.vue';
	export default{
		name:'Orders',
		data(){
			return{
				businessId:this.$route.query.businessId,
				business:{},
				user:{},
				cartArr:[],
				deliveryAddress:{}
			}
		},
		created(){
			this.user = this.$getSessionStorage('user');
			this.deliveryAddress = this.$getLocalStorage(this.user.userId);
			
			//根据businessId查询商家信息
			// this.$axios.post('BusinessController/getBusinessById',this.$qs.stringify({
			// 	businessId:this.businessId
			// }))
			
			getBusinessById(this.businessId).then(response=>{
				this.business=response.data.result;
			}).catch(error=>{
				console.error(error);
			});
			
			
			// this.$axios.post('CartController/listCart',this.$qs.stringify({
			// 	businessId:this.businessId,
			// 	userId:this.user.userId
			// }))
			
			listcart(this.user.userId,this.businessId).then(response=>{
				this.cartArr=response.data.result;
				console.log(this.businessId)
			}).catch(error=>{
				console.error(error);
			});
		},
		computed:{
			totalPrice(){
				let totalPrice = 0;
				for(let cartItem of this.cartArr){
					totalPrice += cartItem.food.foodPrice*cartItem.quantity;
				}
				totalPrice += this.business.deliveryPrice;
				return totalPrice.toFixed(1);
			}
		},
		filters:{
			sexFilter(value){
				return value==1?'先生':'女士';
			}
		},
		methods:{
			toUserAddress() {
				this.$router.push({
					path: '/userAddress',
					query: {
						businessId: this.businessId
					}
				});
			},
			toPayment(){
				if(this.deliveryAddress==null){
					alert("请选择送货地址");
					return;
				}
				// this.$axios.post('OrdersController/createOrders',this.$qs.stringify({
				// 	userId:this.user.userId,
				// 	businessId:this.businessId,
				// 	daId:this.deliveryAddress.daId,
				// 	orderTotal:this.totalPrice
				// }))
				
				createOrders(this.user.userId,this.businessId,this.deliveryAddress.daId,this.totalPrice).then(response=>{
					let orderId = response.data.result;
					if(orderId>0){
						this.$router.push({path:'/payment',query:{orderId:orderId}});
					}else{
						alert("创建订单失败");
					}
				}).catch(error=>{
					console.error(error);
				})
			}
		}
	}
</script>

<style scoped> 
	.wrapper{
		width: 100%;
		height: 100%;
	}
	.wrapper header{
		width: 100%;
		height: 12vw;
		background-color: #0097ff;
		color: #fff;
		font-size: 4.8vw;
		
		position: fixed;
		left: 0;
		top: 0;
		z-index: 1000;
		
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	/* 订单信息 */
	.wrapper .order-info{
		width: 100%;
		margin-top: 12vw;
		background-color: #0097ef;
		color: #fff;
		box-sizing: border-box;
		padding: 2vw;
	}
	.wrapper .order-info h5{
		font-size: 3vw;
		font-weight: 300;
	}
	.wrapper .order-info .order-info-address{
		width: 100%;
		display: flex;
		justify-content: space-between;
		align-items: center;
		
		font-weight: 700;
		user-select: none;
		cursor: pointer;
		margin: 1vw 0;
	}
	.wrapper .order-info .order-info-address p{
		font-size: 5vw;
		width: 90%;
	}
	.wrapper .order-info .order-info-address i{
		font-size: 6vw;
	}
	.wrapper .order-info p{
		font-size: 3vw;
	}
	.wrapper h3{
		box-sizing: border-box;
		padding: 3vw;
		font-size: 4vw;
		color: #666;
		border-bottom: solid 1px #ddd;
	}
	
	/* 订单明细 */
	.wrapper .order-detailed{
		width: 100%;
	}
	.wrapper .order-detailed li{
		width: 100%;
		height: 16vw;
		box-sizing: border-box;
		padding: 3vw;
		color: #666;
		
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.wrapper .order-detailed li .order-detailed-left{
		display: flex;
		align-items: center;
	}
	.wrapper .order-detailed li .order-detailed-left img{
		width: 10vw;
		height: 10vw;
	}
	.wrapper .order-detailed li .order-detailed-left p{
		font-size: 3.5vw;
		margin-left: 3vw;
	}
	.wrapper .order-detailed li p{
		font-size: 3.5vw;
	}
	.wrapper .order-deliveryfee{
		width: 100%;
		height: 16vw;
		box-sizing: border-box;
		padding: 3vw;
		color: #666;
		display: flex;
		justify-content: space-between;
		align-items: center;
		font-size: 3.5vw;
	}
	
	/* 订单合计 */
	.wrapper .total{
		width: 100%;
		height: 14vw;
		
		position: fixed;
		left: 0;
		bottom: 0;
		
		display: flex;
	}
	.wrapper .total .total-left{
		flex: 2;
		background-color: #505051;
		font-size: 4.5vw;
		font-weight: 700;
		color: white;
		user-select: none;
		
		display: flex;
		justify-content: center;
		align-items: center;
		
	}
	.wrapper .total .total-right{
		flex: 1;
		background-color: #38ca73;
		color: white;
		font-size: 4.5vw;
		font-weight: 700;
		user-select: none;
		
		display: flex;
		justify-content: center;
		align-items: center;
	}
</style>