import axios from 'axios';
import qs from 'qs';
export function listcart1(userId) {
	return axios.get(`http://localhost:14000/CartController/listCart/${userId}`);
}

export function listcart(userId, businessId) {
	return axios.get(`http://localhost:14000/CartController/listCart/${userId}/${businessId}`);
}
export function savecart(userId, businessId, foodId) {
	return axios.post(`http://localhost:14000/CartController/saveCart/${userId}/${businessId}/${foodId}`);
}

export function updatecart(userId, businessId, foodId, quantity) {
	return axios.put(`http://localhost:14000/CartController/updateCart/${userId}/${businessId}/${foodId}/${quantity}`);
}

export function removecart(userId, businessId, foodId) {
	return axios.delete(`http://localhost:14000/CartController/removeCart/${userId}/${businessId}/${foodId}`);
}