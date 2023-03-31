import axios from 'axios';
import qs from 'qs';
export function getUserByIdByPass(userId,password){
	return axios.get(`http://localhost:10100/UserController/getUserByIdByPass/${userId}/${password}`);
}

export function getUserById(userId){
	return axios.get(`http://localhost:10100/UserController/getUserById/${userId}`);
}

export function saveUser(userId,password,userName,userSex){
	return axios.post(`http://localhost:10100/UserController/saveUser/${userId}/${password}/${userName}/${userSex}`);
}