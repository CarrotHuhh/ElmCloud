import axios from 'axios';
import qs from 'qs';
export function createOrders(userId,businessId,daId,orderTotal){
	return axios.post(`http://localhost:10600/OrdersController/createOrders/${userId}/${businessId}/${daId}/${orderTotal}`);
}

export function getOrdersById(orderId){
	return axios.get(`http://localhost:10600/OrdersController/getOrdersById/${orderId}`);
}

export function listOrdersByUserId(userId){
	return axios.get(`http://localhost:10600/OrdersController/listOrdersByUserId/${userId}`);
}