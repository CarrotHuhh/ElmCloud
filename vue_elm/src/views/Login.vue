<template>
	<div class="wrapper">
		<!-- header部分 -->
	<header>
		<p>用户登录</p>
	</header>
	
	<!-- 表单部分部分 -->
	<ul class="form-box">
		<li>
			<div class="title">
				手机号码：
			</div>
			<div class="content">
				<input type="text" v-model="userId" placeholder="手机号码">
			</div>
		</li>
		<li>
			<div class="title">
				密码：
			</div>
			<div class="content">
				<input type="password" v-model="password" placeholder="密码">
			</div>
		</li>
	</ul>
	
	<div class="button-login">
		<button @click="login">登录</button>
	</div>
	<div class="button-register" >
		<button @click="register">去注册</button>
	</div>
	
	<Footer></Footer>
	</div>
</template>

<script>
	import { getUserByIdByPass } from '@/service/User';
import Footer from '../components/Footer.vue';
	
	export default{
		name:'Login',
		data(){
			return{
				userId:'',
				password:''
			}
		},
		components:{
			Footer
		},
		methods:{
			login(){
				if(this.userId==''){
					alert('手机号码不能为空');
					return;
				}
				if(this.password==''){
					alert('密码不能为空');
					return;
				}
				
				// this.$axios.post('UserController/getUserByIdByPass',this.$qs.stringify({
				// 	userId:this.userId,
				// 	password:this.password
				// }))
				
				getUserByIdByPass(this.userId,this.password).then(response=>{
					let user = response.data.result;
					if(user==null){
						alert('用户名或密码不正确');
					}else{
						user.userImg='';
						this.$setSessionStorage('user',user);
						this.$router.go(-1);
					}
					}).catch(error=>{
						console.error(error);
				})
			},
			register(){
				this.$router.push({path:'/register'});
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
	
	/* 表单 */
	.wrapper .form-box{
		width: 100%;
		margin-top: 12vw;
	}
	.wrapper .form-box li{
		box-sizing: border-box;
		padding: 4vw 3vw 0 3vw;
		display: flex;
		align-items: center;
	}
	.wrapper .form-box li .title{
		flex: 0 0 18vw;
		font-size: 3vw;
		font-weight: 700;
		color: #666;
	}
	.wrapper .form-box li .content{
		flex: 1;
	}
	.wrapper .form-box li .content input{
		border: none;
		outline: none;
		width: 100%;
		font-size: 3vw;
	}
	.wrapper .button-login{
		width: 100%;
		box-sizing: border-box;
		padding: 4vw 3vw 0 3vw;
	}
	.wrapper .button-login button{
		width: 100%;
		height: 10vw;
		font-size: 3.8vw;
		font-size: 700;
		color: white;
		background-color: #38ca73;
		
		border: none;
		outline: none;
		border-radius: 4px;
	}
	.wrapper .button-register{
		width: 100%;
		box-sizing: border-box;
		padding: 4vw 3vw 0 3vw;
	}
	.wrapper .button-register button{
		width: 100%;
		height: 10vw;
		font-size: 3.8vw;
		font-size: 700;
		color: #666;
		background-color: #eee;
		
		border: none;
		outline: none;
		border-radius: 4px;
	}
</style>