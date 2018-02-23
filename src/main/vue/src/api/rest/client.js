import axios from 'axios';

const client = axios.create({
    // Put axios common config here
    baseURL: '/api'
});

/**
 * Redirecting to login page, when trying to perform unauthorized call.
 */
client.interceptors.response.use(null, error => {
    if (error.status === 401 || error.status === 403) {
        window.location.href = '/login';
    }
    return Promise.reject(error);
});

export default client;
