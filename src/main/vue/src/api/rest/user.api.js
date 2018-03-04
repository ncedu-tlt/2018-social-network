import client from '@/api/rest/client';

// It's an example API file with some fake calls.
// TODO: Remove, when the project build will start.

const protocol = window.location.protocol;
const host = window.location.host;
const coreUrl = protocol + '//' + host;

/**
 * Returns currently authenticated user info.
 * @returns {AxiosPromise<any>}
 */
export function getCurrentUser() {
    return client.get('/user');
}

export function logout() {
    return client.post(coreUrl + '/logout')
        .then(window.location.href = '/');
}

/**
 * Updates name of the specified user.
 * @param id User ID
 * @param name New name
 * @returns {AxiosPromise<any>}
 */
export function updateName(id, name) {
    return client.put(`/user/${id}`, { name });
}
