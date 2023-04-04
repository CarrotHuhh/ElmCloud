import axios from 'axios';
import qs from 'qs';
export function getUserByIdByPass(userId,password){
	return axios.get(`http://localhost:14000/UserController/getUserByIdByPass/${userId}/${password}`);
}

export function getUserById(userId){
	return axios.get(`http://localhost:14000/UserController/getUserById/${userId}`);
}

export function saveUser(userId,password,userName,userSex){
	return axios.post(`http://localhost:14000/UserController/saveUser/${userId}/${password}/${userName}/${userSex}`);
}