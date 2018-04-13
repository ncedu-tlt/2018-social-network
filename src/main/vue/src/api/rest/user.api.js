import client from '@/api/rest/client';

// It's an example API file with some fake calls.
// TODO: Remove, when the project build will start.

const coreUrl = window.location.origin.toString();

/**
 * Returns indicator whether the user authorized
 * @returns {AxiosPromise<any>}
 */

export function getProjects(userName) {
    return client.get(`/user/${userName}/repos`);
}
/**
 * Returns currently authenticated user info.
 * @returns {AxiosPromise<any>}
 */
export function getCurrentUser() {
    return client.get('/user');
}
/**
 * Returns nothing, call for destroying current auth session
 * @returns {AxiosPromise<any>}
 */
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

/**
* Returns user settings
* @returns {UserSettings<settings>}
*/

export function getSettings() {
    return client.get(`/settings`);
}
