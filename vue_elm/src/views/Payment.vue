<template>
	<div class="wrapper">
		<!-- header部分 -->
	<header>
		<p>在线支付</p>
	</header>
	
	<!-- 订单信息部分 -->
	<h3>订单信息：</h3>
	<div class="order-info">
		<p>
			{{this.orders.business.businessName}}
			<i class="fa fa-caret-down" @click="detailetShow"></i>
		</p>
		<p>&#165;{{orders.orderTotal}}</p>
	</div>
	<!-- 订单明细部分 -->
	<ul class="order-detailed" v-show="isShowDetailet">
		<li v-for="item in orders.list">
			<p>{{item.food.foodName}} * {{item.quantity}}</p>
			<p>&#165;{{item.food.foodPrice*item.quantity}}</p>
		</li>
		<li>
			<p>配送费</p>
			<p>&#165;{{orders.business.deliveryPrice}}</p>
		</li>
	</ul>
	
	<!-- 支付方式部分 -->
	<ul class="payment-type">
		<li>
			<img src="../assets/alipay.png">
			<i class="fa fa-check-circle"></i>
		</li>
		<li>
			<img src="../assets/wechat.png">
		</li>
	</ul>
	<div class="payment-button" @click="payForOrder">
		<button>确认支付</button>
	</div>
	
	<Footer></Footer>
	</div>
</template>

<script>
	import { getOrdersById } from '@/service/Order';
	import { payByWallet } from '@/service/CreditsAndWallet';
import Footer from '../components/Footer.vue';
	export default{
		inject:['reload'],
		name:'Payment',
		data(){
			return{
				orderId:this.$route.query.orderId,
				user:{},
				orders:{
					business:{}
				},
				isShowDetailet:false
			}
		},
		created() {
			this.user = this.$getSessionStorage('user');
			// this.$axios.post('OrdersController/getOrdersById', this.$qs.stringify({
			// 	orderId: this.orderId
			// }))
			
			getOrdersById(this.orderId).then(response => {
				this.orders = response.data.result;
			}).catch(error => {
				console.error(error);
			});
		},
		components:{
			Footer
		},
		methods:{
			detailetShow(){
				this.isShowDetailet = !this.isShowDetailet;
			},
			payForOrder(){
				// this.$axios.post('VirtualWalletController/payByWallet',this.$qs.stringify({
				// 	userId:this.user.userId,
				// 	orderId:this.orderId
				// })).then(response=>{
				// 	// alert(Math.trunc(this.orders.orderTotal));
				// 	if(response.data>0){
				// 		this.$router.push({path:'/orderList'});	
				// 	}else{
				// 		alert('支付失败!');
				// 	}
				// }).catch(error=>{
				// 	console.error(error);
				// });
					payByWallet(this.orderId,this.user.userId).then(response => {
						if(response.data.result>0){
							this.$router.push({path:'/orderList'});	
						}else{
							alert('支付失败!');
						}
					}).catch(error => {
						console.error(error);
					});
			}
			
		 },
		mounted(){
			//先将当前路由添加到history对象中
			history.pushState(null,null,document.URL);
			//popstate事件监听history的变化
			window.onpopstate = () =>{
				this.$router.push({path:'/index'});
			}
		},
		destroyed(){
			window.onpopstate = null;
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
	.wrapper h3{
		margin-top: 12vw;
		box-sizing: border-box;
		padding: 4vw 4vw 0;
		
		font-size: 4vw;
		font-weight: 300;
		color: #999;
	}
	.wrapper .order-info{
		box-sizing: border-box;
		padding: 4vw;
		font-size: 4vw;
		color: #666;
		
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.wrapper .order-info p:last-child{
		color: orangered;
	}
	/* 订单明细 */
	.wrapper .order-detailed{
		width: 100%;
		
	}
	.wrapper .order-detailed li{
		box-sizing: border-box;
		padding: 1vw 4vw;
		
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.wrapper .order-detailed li p{
		font-size: 3vw;
		color: #666;
	}
	
	/* 支付方式 */
	.wrapper .payment-type{
		width: 100%;
	}
	.wrapper .payment-type li{
		width: 100%;
		box-sizing: border-box;
		padding: 4vw;
		
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.wrapper .payment-type li img{
		width: 33vw;
		height: 8.9vw;
	}
	.wrapper .payment-type li .fa-check-circle{
		font-size: 5vw;
		column-rule-color: #38ca73;
	}
	.wrapper .payment-button{
		width: 100%;
		box-sizing: border-box;
		padding: 4vw;
	}
	.wrapper .payment-button button{
		width: 100%;
		height: 10vw;
		border: none;
		outline: none;
		border-radius: 4px;
		background-color: #38ca73;
		color: white;
	}
	
	
	
</style>