<template>
	<div class="wrapper">
		<!-- header部分 -->
		<header>
			<p>积分商城</p>
		</header>
		
		<div class="views">
			<ul>
				<li>
					<div @click="changeCredits(100)">
						<p class="p1">玩具</p>
						<p class="p2">100</p>
					</div>
				</li>
				<li>
					<div @click="changeCredits(200)">
						<p class="p1">一箱水果</p>
						<p class="p2">200</p>
					</div>
				</li>
				<li>
					<div @click="changeCredits(300)">
						<p class="p1">手办</p>
						<p class="p2">300</p>
					</div>
				</li>
				<li>
					<div @click="changeCredits(400)">
						<p class="p1">高级手表</p>
						<p class="p2">400</p>
					</div>
				</li>
				<li>
					<div @click="changeCredits(500)">
						<p class="p1">电饭煲</p>
						<p class="p2">500</p>
					</div>
				</li>
				<li>
					<div @click="changeCredits(1000)">
						<p class="p1">电冰箱</p>
						<p class="p2">1000</p>
					</div>
				</li>
			</ul>
			<div class="credits-pay" @click="payCredits">支付积分</div>
		</div>
		
		<Footer></Footer>
	</div>
</template>

<script>
import { creditsDeduct } from '@/service/CreditsAndWallet';
	import Footer from '../components/Footer.vue';
	export default{
		name:'creditsMall',
		data() {
			return{
				credits:0
			}
		},
		created() {
			this.user = this.$getSessionStorage('user');
		},
		components:{
			Footer
		},
		methods:{
			changeCredits(credits){
				this.credits = credits;
			},
			payCredits(){
				// this.$axios.post('CreditsWalletController/creditsDeduct',this.$qs.stringify({
				// 		userId:this.user.userId,
				// 		amount:this.credits
				// 	}))
					
					creditsDeduct(this.credits,this.user.userId).then(response=>{
						if(response.data.result == 0){
							alert('积分不足！');
							this.$router.push({
								path: '/credits'
							});
						}else{
							alert('支付成功！');
							this.$router.push({
								path: '/credits'
							});
						}
					}).catch(error=>{
						console.error(error);
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
		padding-top: 20vw;
	}
	.wrapper .views ul{
		overflow: hidden;
	}
	
	.wrapper .views ul li div{
		float: left;
		margin-left: 6vw;
		margin-bottom: 10vw;
		width: 25vw;
		height: 25vw;
		/* background-color: rgba(132, 133, 135, 0.3); */
		text-align: center;
		font-size: 3vw;
		border: 1px solid #0097ff;
		border-radius: 5vw;
		color: #0097ff;
	}
	.wrapper .views ul li div:hover{
		background-color: #0097ff;
		color: #fff;
	}
	
	.wrapper .views ul li div .p1{
		font-size: 5vw;
		margin-top: 6vw;
	}
	
	.wrapper .views ul li div .p2{
		font-size: 4vw;
	}
	
	.wrapper .views .credits-pay{
		margin: 0 auto;
		width: 50vw;
		height: 10vw;
		font-size: 5vw;
		text-align: center;
		line-height: 10vw;
		background-color: #0097ff;
		border-radius: 5vw;
		color: #fff;
	}
	
</style>