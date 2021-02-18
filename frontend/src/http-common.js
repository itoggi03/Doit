import axios from 'axios';
import { api, response } from './api/index'
import account from './store/modules/account'

const http = axios.create({
    baseURL: 'http://i4c108.p.ssafy.io/api/',
    headers: {
        'Content-type': 'application/json',
    },
})


http.interceptors.response.use(function (response) {
    return response;
  }, function (error) {
        if (error.response.status == response.UNAUTHORIZED)
            api.onUnauthorized();
        else if (error.response.status == response.FOBBIDEN)
            api.onFobbiden();
        else {
            console.log(error)
        }
});

http.interceptors.request.use(function (config) {
    if(account.state.accessToken)
        config.headers.accessToken = account.state.accessToken;
    return config;
}, function (error) {
    return Promise.reject(error);
});


export default http;