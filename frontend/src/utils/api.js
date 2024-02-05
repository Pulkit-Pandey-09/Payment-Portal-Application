import axios from 'axios'

// creating an instance of axios with base URL
const instance = axios.create({
    baseURL: 'http://localhost:8080'
});

// Defining interceptors which modify the request or response before they are handled by axios.
// Request interceptor checks for a token in the local storage and adds it to the Authorization header if present. 
instance.interceptors.request.use((request)=> {
    const token = localStorage.getItem('token')
    if (token)
        request.headers.Authorization = 'Bearer ' + token
    return request;
}, function (error) {
    return Promise.reject(error);
});

// the axios instance is then used to make HTTP requests in httpRequest method and other methods like GET,POST
// Promise - fundamental concept in asynchronous programming. It mainly handles asynchronous HTTP call operations
// and then resolves it. (READ MORE ABOUT IT)
const httpRequest = (method, url, request) => {
    return new Promise((resolve, reject) => {
      instance[method](url, request)
      .then(response => {
          resolve(response)
        })
      .catch(error => {
          reject(error)
        })
    })
}


// HTPP methods
const getAPI = (url, request) =>{
    return httpRequest('get', url, request)
}

const postAPI = (url, request) =>{
    return httpRequest('post', url, request)
}

export {getAPI,postAPI}