import axios from 'axios';
import qs from 'qs';
export function listDeliveryAddressByUserId(userId){
	return axios.get(`http://localhost:10500/DeliveryAddressController/listDeliveryAddressByUserId/${userId}`);
}

export function getDeliveryAddressById(daId){
	return axios.get(`http://localhost:10500/DeliveryAddressController/getDeliveryAddressById/${daId}`);
}

export function saveDeliveryAddress(contactName,contactSex,contactTel,address,userId){
	return axios.post(`http://localhost:10500/DeliveryAddressController/saveDeliveryAddress/${contactName}/${contactSex}/${contactTel}/${address}/${userId}`);
}

export function updateDeliveryAddress(daId,contactName,contactSex,contactTel,address){
	return axios.put(`http://localhost:10500/DeliveryAddressController/updateDeliveryAddress/${daId}/${contactName}/${contactSex}/${contactTel}/${address}`);
}

export function removeDeliveryAddress(daId){
	return axios.delete(`http://localhost:10500/DeliveryAddressController/removeDeliveryAddress/${daId}`);
}