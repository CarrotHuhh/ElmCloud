<template>
	<div class="wrapper">
		<!-- header部分 -->
		<header>
			<p>我的积分</p>
		</header>
		
		<div class="views">
			<div class="balance">
				<div class="balance-head">尊敬的{{user.userName}}{{user.userSex==1?'先生':'女士'}},您的积分余额为：</div>
				<div class="balance-content">
					<div class="balance-content-top">
						{{this.credits.toFixed(0)}}
					</div>
					</div>
			</div>
			<div class="function">
				<div class="function-recharge" @click="toCreditsMall">积分商城</div>
				<div class="function-withdrawal" @click="toCreditsTransactionFlow">查询流水</div>
			</div>
		
		</div>
		
		<Footer></Footer>
	</div>
</template>

<script>
	import { getCreditsById } from '@/service/CreditsAndWallet';
import Footer from '../components/Footer.vue';
	export default{
		name:'Credits',
		data() {
			return{
				credits:0
			}
		},
		created() {
			this.user = this.$getSessionStorage('user');
			// this.$axios.post('CreditsWalletController/getCreditsById',this.$qs.stringify({
			// 		userId:this.user.userId
			// 	}))
				
				getCreditsById(this.user.userId).then(response=>{
					this.credits=response.data.result;
				}).catch(error=>{
					console.error(error);
				});
		},
		components:{
			Footer
		},
		methods:{
			toCreditsMall(){
				this.$router.push({
					path: '/creditsMall'
				});
			},
			toCreditsTransactionFlow(){
				this.$router.push({
					path: '/creditsTransactionFlow'
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
		font-size: 20vw;
		color: #555;
	}
	
	.wrapper .views .function{
		display: flex;
		justify-content: space-around;
		align-items: center;
	}
	
	.wrapper .views .function .function-recharge{
		border: 1px solid gray;
		padding: 3vw 10vw;
		border-radius: 10vw;
		background-color: #0097ff;
		color: #fff;
	}
	
	.wrapper .views .function .function-withdrawal{
		border: 1px solid gray;
		padding: 3vw 10vw;
		border-radius: 10vw;
		background-color: #0097ff;
		color: #fff;
	}
</style>