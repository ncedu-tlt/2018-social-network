import client from '@/api/rest/client';

// It's an example API file with some fake calls.
// TODO: Remove, when the project build will start.

const coreUrl = window.location.origin.toString();

/**
 * Returns currently authenticated user info.
 * @returns {AxiosPromise<any>}
 */
export function isAuthorized() {
    return client.get('/user/authorized')
        .then(r => {
            return r.data;
        });
}

export function getCurrentUser() {
    return client.get('/user');
}

export function logout() {
    return client.post(coreUrl + '/logout');
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
