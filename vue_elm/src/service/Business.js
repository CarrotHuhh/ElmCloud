import axios from 'axios';
import qs from 'qs';
export function listBusinessByOrderTypeId(orderTypeId){
	return axios.get(`http://localhost:10300/BusinessController/listBusinessByOrderTypeId/${orderTypeId}`);
}
export function getBusinessById(businessId){
	return axios.get(`http://localhost:10300/BusinessController/getBusinessById/${businessId}`);
}