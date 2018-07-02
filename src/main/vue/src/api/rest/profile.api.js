import client from '@/api/rest/client';

/**
 *Returns the user profile
 *@return {UserProfile}
*/
export function getProfile() {
    return client.get('/profile');
}
