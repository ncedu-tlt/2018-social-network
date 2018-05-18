import axios from 'axios';
import router from '@/router';

const client = axios.create({
    // Put axios common config here
    baseURL: '/api',
    xsrfCookieName: 'XSRF-TOKEN',
    xsrfHeaderName: 'X-XSRF-TOKEN',
    headers: {'X-XSRF-TOKEN': 'XSRF-TOKEN'}
});

/**
 * Redirecting to login page, when trying to perform unauthorized call.
 */
client.interceptors.response.use(null, error => {
    if (error.response.status === 401 || error.response.status === 403) {
        router.push('/auth');
    }
    return Promise.reject(error);
});

export default client;
