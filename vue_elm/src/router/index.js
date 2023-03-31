import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import BusinessList from '../views/BusinessList.vue'
import BusinessInfo from '../views/BusinessInfo.vue'
import Login from '../views/Login.vue'
import Orders from '../views/Orders.vue'
import UserAddress from '../views/UserAddress.vue'
import Payment from '../views/Payment.vue'
import OrderList from '../views/OrderList.vue'
import AddUserAddress from '../views/AddUserAddress.vue'
import EditUserAddress from '../views/EditUserAddress.vue'
import Register from '../views/Register.vue'
import MyPage from '../views/MyPage.vue'
import Wallet from '../views/Wallet.vue'
import TransactionFlow from '../views/TransactionFlow.vue'
import CreditsMall from '../views/CreditsMall.vue'
import Credits from '../views/Credits.vue'
import CreditsTransactionFlow from '../views/CreditsTransactionFlow.vue'
Vue.use(VueRouter)
const routes = [{
		path: '/',
		name: 'Home',
		component: Index
	}, {
		path: '/index',
		name: 'Index',
		component: Index
	}, {
		path: '/businessList',
		name: 'BusinessList',
		component: BusinessList
	}, {
		path: '/businessInfo',
		name: 'BusinessInfo',
		component: BusinessInfo
	}, {
		path: '/login',
		name: 'Login',
		component: Login
	}, {
		path: '/orders',
		name: 'Orders',
		component: Orders
	}, {
		path: '/userAddress',
		name: 'UserAddress',
		component: UserAddress
	}, {
		path: '/payment',
		name: 'Payment',
		component: Payment
	}, {
		path: '/orderList',
		name: 'OrderList',
		component: OrderList
	}, {
		path: '/addUserAddress',
		name: 'AddUserAddress',
		component: AddUserAddress
	}, {
		path: '/editUserAddress',
		name: 'EditUserAddress',
		component: EditUserAddress
	}, {
		path: '/register',
		name: 'Register',
		component: Register
	}, {
		path: '/myPage',
		name: 'MyPage',
		component: MyPage
	}, {
		path: '/wallet',
		name: 'Wallet',
		component: Wallet
	}, {
		path: '/transactionFlow',
		name: 'TransactionFlow',
		component: TransactionFlow
	}, {
		path: '/creditsMall',
		name: 'CreditsMall',
		component: CreditsMall
	}, {
		path: '/credits',
		name: 'Credits',
		component: Credits
	}, {
		path: '/creditsTransactionFlow',
		name: 'CreditsTransactionFlow',
		component: CreditsTransactionFlow
	}
]
//解决重复路由报异常问题
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})
export default router
