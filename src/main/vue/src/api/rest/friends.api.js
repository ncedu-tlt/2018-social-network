import client from '@/api/rest/client';

export function getFriends() {
    return client.get('/friends');
}
export function addFriend(friend) {
    return client.post(`/friends/${friend.name}`, friend);
}
export function removeFriend(friend) {
    return client.delete(`friends/${friend.Id}`, friend.Id);
}
