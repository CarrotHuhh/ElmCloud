<template>
	<div class="wrapper">
		<!-- header部分 -->
		<header>
			<p>我的钱包</p>
		</header>
		
		<div class="views">
			<div class="balance">
				<div class="balance-head">尊敬的{{user.userName}}{{user.userSex==1?'先生':'女士'}},您的钱包余额为：</div>
				<div class="balance-content">
					<div class="balance-content-top">
						{{this.balance.toFixed(1)}}
					</div>
					<div class="balance-content-yuan">元</div>
					</div>
			</div>
			<div class="function">
				<div class="function-recharge" @click="showRecharge">充值</div>
				<div class="function-withdrawal" @click="showWithdraw">提现</div>
			</div>
			<div class="to-transaction-flow" @click="toTransactionFlow">查询交易流水</div>
			<div class="recharge-or-withdraw" v-show="this.isShow==true">
				<input type="text" v-model.number="sumOfMoney" placeholder="请输入金额">
				<button @click="clickButton">{{rechargeOrWithdraw}}</button>
			</div>
		</div>
		
		<Footer></Footer>
	</div>
</template>

<script>
import { getVirtualWalletBalance, virtualWalletTopUp, virtualWalletWithdraw } from '@/service/CreditsAndWallet';
	import Footer from '../components/Footer.vue';
	export default{
		inject:['reload'],
		name:'Wallet',
		data(){
			return{
				balance:0,
				isShow:false,
				rechargeOrWithdraw:'充值',
				sumOfMoney:null
			}
		},
		created() {
			this.user = this.$getSessionStorage('user');
			// this.$axios.post('VirtualWalletController/getVirtualWalletBalance',this.$qs.stringify({
			// 		userId:this.user.userId
			// 	}))
				
				getVirtualWalletBalance(this.user.userId).then(response=>{
					this.balance=response.data.result;
				}).catch(error=>{
					console.error(error);
				});
		},
		components:{
			Footer
		},
		methods:{
			showRecharge(){
				this.isShow=true;
				this.rechargeOrWithdraw = '充值';
			},
			showWithdraw(){
				this.isShow=true;
				this.rechargeOrWithdraw = '提现';
			},
			clickButton(){
				this.isShow=false;
				
				if(typeof this.sumOfMoney == 'string' || this.sumOfMoney == null){
					alert('请输入正确数据！');
				}else{
					if(this.rechargeOrWithdraw == '充值'){
						// this.$axios.post('VirtualWalletController/virtualWalletTopUp',this.$qs.stringify({
						// 	userId:this.user.userId,
						// 	amount:parseFloat(this.sumOfMoney)
						// }))
						
						virtualWalletTopUp(this.user.userId,parseFloat(this.sumOfMoney),'000001').then(response=>{
							if(response.data.result>0){
								this.reload();
							}else{
								alert("操作失败")
							}
						}).catch(error=>{
							console.error(error);
						});
					}else if(this.rechargeOrWithdraw == '提现'){
						// this.$axios.post('VirtualWalletController/virtualWalletWithdraw',this.$qs.stringify({
						// 	userId:this.user.userId,
						// 	amount:parseFloat(this.sumOfMoney)
						// }))
						
						virtualWalletWithdraw(this.user.userId,parseFloat(this.sumOfMoney),'000001').then(response=>{
							if(response.data.result>0){
								this.reload();
							}else{
								alert("操作失败")
							}
						}).catch(error=>{
							console.error(error);
						});
					}
				} 
			},
			toTransactionFlow(){
				this.$router.push({
					path: '/transactionFlow'
				});
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
	
	.wrapper .views{
		padding: 20vw 4vw 0 4vw;
	}
	
	.wrapper .views .balance .balance-head{
		color: #666;
	}
	
	.wrapper .views .balance .balance-content{
		margin-top: 10vw;
		display: flex;
		align-items: center;
		justify-content: center;
		margin-bottom: 10vw;
		
		
	}
	
	.wrapper .views .balance .balance-content .balance-content-top{
		font-size: 18vw;
		color: #555;
	}
	
	.wrapper .views .balance .balance-content .balance-content-yuan{
		position: relative;
		top: 5vw;
	}
	
	.wrapper .views .function{
		display: flex;
		justify-content: space-around;
		align-items: center;
	}
	
	.wrapper .views .function div{
		border: 1px solid gray;
		padding: 3vw 15vw;
		border-radius: 10vw;
		background-color: #0097ff;
		color: #fff;
		font-size: 5vw;
	}
	
	.wrapper .views .to-transaction-flow{
		margin: 10vw auto;
		width: 45vw;
		border: 1px solid gray;
		padding: 3vw 15vw;
		border-radius: 10vw;
		background-color: #0097ff;
		color: #fff;
		font-size: 5vw;
		text-align: center;
	}
	
	
	
	.wrapper .views .recharge-or-withdraw{
		margin-top: 50px;
	}
	.wrapper .views .recharge-or-withdraw input{
		display: block;
		width: 100%;
		height: 10vw;
		font-size: 5vw;
		border-radius: 5px;	
		border-color: #555;
		color: #555;
	}
	
	.wrapper .views .recharge-or-withdraw button{
		display: block;
		width: 20vw;
		height: 10vw;
		margin: 10vw 36vw;
		font-size: 5vw;
	}
	
</style>