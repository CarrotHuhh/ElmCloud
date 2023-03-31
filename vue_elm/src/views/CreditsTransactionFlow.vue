<template>
	<div class="wrapper">
		<!-- header部分 -->
		<header>
			<p>积分流水</p>
		</header>
		
		<ul>
			<li v-for="(item) in transactionFlow">
				<div class="transaction-flow-item">
					<p class="amount">{{item.credits}}</p>
					<p class="trading-time">交易时间:{{item.addDate}}</p>
				</div>
			</li>
		</ul>
		
	</div>
</template>

<script>
	export default{
		name:'CreditsTransactionFlow',
		data() {
			return{
				transactionFlow:[]
			}
		},
		created() {
			this.user = this.$getSessionStorage('user');
			this.$axios.post('CreditsWalletController/getCreditsRecordById',this.$qs.stringify({
					userId:this.user.userId
				})).then(response=>{
					this.transactionFlow=response.data;
				}).catch(error=>{
					console.error(error);
				});
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
	
	.wrapper ul{
		padding: 15vw 4vw 0 4vw;
	}
	
	.wrapper ul li{
		margin-bottom: 7vw;
		color: #666;
	
	}
	.wrapper ul li .transaction-flow-item{
		margin-bottom: 7vw;
		position: relative;
		height: 20vw;
		border: 1px solid #DCDCDC;
		background-color: whitesmoke;
		border-radius: 10px;
		box-sizing: border-box;
		box-shadow: 1px 1px 3vw #DCDCDC;
	}
	
	.wrapper ul li .transaction-flow-item .amount{
		position: absolute;
		top: 0.5vw;
		left: 5vw;
		font-size: 6vw;
		font-weight: 600;
	}
	.wrapper ul li .transaction-flow-item .trading-time{
		position: absolute;
		bottom: 3vw;
		left: 5vw;
		font-size: 4vw;
	}
</style>