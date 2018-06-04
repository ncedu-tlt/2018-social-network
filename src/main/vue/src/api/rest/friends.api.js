import client from '@/api/rest/client';

export function getFriends() {
    return client.get('/friends');
}
export function addFriend(friend) {
    return client.post(`/friends/${friend.login}`, friend.login);
}
export function removeFriend(friend) {
    return client.delete(`friends/${friend.userId}`, friend);
}
