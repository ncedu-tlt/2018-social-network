import client from '@/api/rest/client';

export function getChats() {
    return client.get('/chat');
}

export function getChat(id) {
    return client.get(`/chat/${id}`);
}

export function addChat(chat) {
    return client.post('/chat', chat);
}
