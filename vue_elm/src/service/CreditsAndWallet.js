
import axios from 'axios';
export function getCreditsById(userId) {
    return axios.post(`http://localhost:14000/CreditsWalletController/getCreditsById/${userId}`);
}
export function creditsDeduct(userId, amount) {
    return axios.post(`http://localhost:14000/CreditsWalletController/creditsDeduct/${userId}/${amount}`);
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
export function virtualWalletTopUp(userId, amount) {
    return axios.post(`http://localhost:14000/VirtualWalletController/virtualWalletTopUp/${userId}/${amount}`);
}
export function virtualWalletWithdraw(userId, amount) {
    return axios.post(`http://localhost:14000/VirtualWalletController/virtualWalletWithdraw/${userId}/${amount}`);
}