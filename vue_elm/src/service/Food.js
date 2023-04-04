import axios from 'axios';
import qs from 'qs';
export function listFoodByBusinessId(businessId){
	return axios.get(`http://localhost:14000/FoodController/listFoodByBusinessId/${businessId}`);
}