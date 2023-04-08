
import axios from 'axios';
export function getCreditsById(userId) {
    return axios.post(`http://localhost:14000/CreditsWalletController/getCreditsById/${userId}`);
}
export function creditsDeduct(amount,userId) {
    return axios.post(`http://localhost:14000/CreditsWalletController/creditsDeduct/${amount}/${userId}`);
}
export function getCreditsRecordById(userId) {
    return axios.post(`http://localhost:14000/CreditsWalletController/getCreditsRecordById/${userId}`);
}
export function listTransByUserId(userId) {
    return axios.post(`http://localhost:14000/VirtualWalletController/listTransByUserId/${userId}`);
}
export function getVirtualWalletBalance(userId) {
    return axios.post(`http://localhost:14000/VirtualWalletController/getVirtualWalletBalance/${userId}`);
}
export function virtualWalletTopUp(userId, amount, walletOutId) {
    return axios.post(`http://localhost:14000/VirtualWalletController/virtualWalletTopUp/${amount}/${userId}/${walletOutId}`);
}
export function virtualWalletWithdraw(userId, amount, walletInId) {
    return axios.post(`http://localhost:14000/VirtualWalletController/virtualWalletWithdraw/${amount}/${userId}/${walletInId}`);
}
export function payByWallet(orderId,userId){
	return axios.post(`http://localhost:14000/VirtualWalletController/payByWallet/${orderId}/${userId}`);
}