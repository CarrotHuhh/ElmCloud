<template>
	<div class="wrapper">
		<!-- header部分 -->
		<header>
			<p>我的</p>
		</header>
		
		<div class="views">
			<div class="personal-information">
				<div class="personal-information-name">姓名: {{user.userName}}</div>
				<div class="personal-information-tel">电话号码: {{user.userId}}</div>
			</div>
			<div class="addition">
				<div class="addition-wallet" @click="toWallet">钱包</div>
				<div class="addition-score" @click="toCredits">积分</div>
			</div>
		</div>
		
		<Footer></Footer>
	</div>
</template>

<script>
	import Footer from '../components/Footer.vue';
	export default{
		name:'MyPage',
		data() {
			return{
				
			}
			
		},
		created() {
			this.user = this.$getSessionStorage('user');
			
		},
		components:{
			Footer
		},
		methods:{
			toWallet(){
				this.$router.push({
					path: '/wallet'
				});
			},
			toCredits(){
			this.$router.push({
				path: '/credits'
			});
		},
		
		},
		
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
	
	
	.wrapper .views .personal-information div{
		margin-bottom: 5vw;
		font-size: 6vw;
		color: #666;
	}
	
	/* .wrapper .views .personal-information .personal-information-tel{
		margin-bottom: 10vw;
		font-size: 6vw;
		color: #666;
	} */
	
	.wrapper .views .addition{
		margin-top: 10vw;
		display: flex;
		justify-content: space-around;
		align-items: center;
	}
	
	.wrapper .views .addition div{
		border: 1px solid gray;
		padding: 3vw 15vw;
		border-radius: 10vw;
		background-color: #0097ff;
		color: #fff;
		font-size: 5vw;
	}
	
</style>