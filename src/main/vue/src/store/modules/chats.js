import { getCurrentUser } from '@/api/rest/user.api';

const state = {
    chats: []
};

const getters = {
    getChatsByParticipantId: (state) => (id) => {
        return state.chats.filter(chat => chat.participantsId.toString() === id.toString());
    },
    getChatById: (state) => (id) => {
        return state.chats.filter(chat => chat.id.toString() === id.toString())[0];
    }
};

const mutations = {
    updateChats(state, updatedChats) {
        state.chats = updatedChats;
    },
    addChat(state, chat) {
        state.chats.push(chat);
    },
    addMessage(state, payload) {
        payload.chat.messages.push(payload.msg);
    }
};

const actions = {
    async updateChats({ commit }) {
        const updatedChats = boilerplate.getChats();
        commit('updateChats', updatedChats);
    },
    async addChat({ commit }, people) {
        let chat = {
            id: state.chats.length + 1,
            avatar: 'http://googledino.ru/assets/googe_dino.png',
            name: people.map(p => p.name).join(', '),
            messages: [],
            dateMsg: new Date(),
            participantsId: people.map(p => p.id)
        };
        if (people.length > 1) {
            chat.type = 'conference';
        } else {
            chat.type = 'dialog';
        };
        commit('addChat', chat);
        return chat;
    },
    async addMessage({ commit }, payload) {
        const response = await getCurrentUser();
        const userId = response.data.userId;
        let message = {
            id: payload.chat.messages.length + 1,
            body: payload.newMsg,
            dateMsg: new Date(),
            fromId: userId
        };
        commit('addMessage', { chat: payload.chat, msg: message });
    }
};

const boilerplate = {
    getMessages(count) {
        let messages = [];
        for (let i = 1; i < count; i++) {
            messages.push({
                id: i,
                body: `Message no.${i}`,
                dateMsg: new Date(),
                fromId: 1
            });
        }
        return messages;
    },
    getChats() {
        let chat = [
            {
                id: 1,
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                name: 'Andrey Zorin',
                messages: boilerplate.getMessages(100),
                dateMsg: new Date(),
                type: 'dialog',
                participantsId: [1]
            },
            {
                id: 2,
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                name: 'Conference name',
                messages: [],
                dateMsg: new Date(),
                type: 'conference',
                participantsId: [1, 2]
            },
            {
                id: 3,
                avatar: 'http://googledino.ru/assets/googe_dino.png',
                name: 'Project name',
                messages: [],
                dateMsg: new Date(),
                type: 'project',
                participantsId: [2, 3]
            }
        ];
        return chat;
    }
};

export default {
    namespaced: true,
    getters,
    state,
    mutations,
    actions
};
