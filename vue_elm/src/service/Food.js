import axios from 'axios';
import qs from 'qs';
export function listFoodByBusinessId(businessId){
	return axios.get(`http://localhost:10200/FoodController/listFoodByBusinessId/${businessId}`);
}