<template>
	<div class="wrapper">
		<!-- header部分 -->
		<header>
			<p>交易流水</p>
		</header>
		
		<ul>
			<li v-for="(item,index) in transactionFlowArr">
				<div class="transaction-flow-item" @click="toBusinessInfo(item.transactionType,item.walletInId)">
					<div class="type">{{item.transactionType==1?'支付':item.transactionType==2?'提现':'充值'}}</div>
					<div class="from">{{item.businessName==null?'银行':item.businessName}}<span v-show="item.transactionType==1">&gt;</span></div>
					<div class="amount">&#165;{{item.amount.toFixed(1)}}</div>
					<div class="trading-time">交易时间:{{item.transactionDate}}</div>
					
				</div>
			</li>
		</ul>
	</div>
</template>

<script>
	export default{
		name:'TransactionFlow',
		data(){
			return{
				transactionFlowArr:[]
			}
		},
		created(){
			this.user = this.$getSessionStorage('user');
			
			this.$axios.post('VirtualWalletController/listTransByUserId ',this.$qs.stringify({
				userId:this.user.userId
			})).then(response=>{
				this.transactionFlowArr=response.data;
			}).catch(error=>{
				console.error(error);
			});
		},
		methods:{
			toBusinessInfo(transactionType,walletInId){
				if(transactionType==1){
					this.$router.push({
						path:'/businessInfo',
						query:{
							businessId:walletInId
						}
					})
				}
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
	
	.wrapper ul{
		padding: 15vw 4vw 0 4vw;
	}
	
	.wrapper ul li{
		margin-bottom: 10vw;
		color: #666;
	
	}
	.wrapper ul li .transaction-flow-item{
		height: 30vw;
		position: relative;
		border: 1px solid #DCDCDC;
		background-color: whitesmoke;
		border-radius: 10px;
		box-sizing: border-box;
		box-shadow: 1px 1px 3vw #DCDCDC;
	}
	
	
	.wrapper ul li .transaction-flow-item .type{
		position: absolute;
		top: 14vw;	
		left: 5vw;
		height: 5vw;
		line-height: 5vw;
		font-size: 5vw;
	}
	
	.wrapper ul li .transaction-flow-item .from{
		position: absolute;
		top: 3vw;
		left: 5vw;
		height: 5vw;
		line-height: 5vw;
		font-size: 5vw;
	}
	.wrapper ul li .transaction-flow-item .amount{
		position: absolute;
		top: 10vw;
		right: 5vw;
		font-size: 6vw;
		font-weight: 600;
	}
	.wrapper ul li .transaction-flow-item .trading-time{
		position: absolute;
		bottom: 2vw;
		right: 5vw;
		font-size: 4vw;
	}
</style>