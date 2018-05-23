import { getCurrentUser } from '@/api/rest/user.api';

const state = {
    chats: [],
    participants: []
};

const getters = {
    getChatsByParticipantId: (state) => (id) => {
        return state.chats.filter(chat => chat.participantsId.toString() === id.toString());
    },
    getChatById: (state) => (id) => {
        return state.chats.find(chat => chat.id.toString() === id);
    },
    getParticipantById: (state) => (id) => {
        return state.participants.find(p => p.id === id);
    }
};

const mutations = {
    updateChats(state, updatedChats) {
        state.chats = updatedChats;
    },
    updateParticipants(state, updatedParticipants) {
        state.participants = updatedParticipants;
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
            avatar: 'https://octodex.github.com/images/electrocat.png',
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
    },
    async updateParticipants({ commit }) {
        const updatedParticipants = boilerplate.getParticipants();
        commit('updateParticipants', updatedParticipants);
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
                avatar: 'https://octodex.github.com/images/electrocat.png',
                name: 'Andrey Zorin',
                messages: boilerplate.getMessages(100),
                dateMsg: new Date(),
                type: 'dialog',
                participantsId: [1]
            },
            {
                id: 2,
                avatar: 'https://octodex.github.com/images/electrocat.png',
                name: 'Conference name',
                messages: [],
                dateMsg: new Date(),
                type: 'conference',
                participantsId: [1, 2]
            },
            {
                id: 3,
                avatar: 'https://octodex.github.com/images/Robotocat.png',
                name: 'Project name',
                messages: [],
                dateMsg: new Date(),
                type: 'project',
                participantsId: [2, 3]
            }
        ];
        return chat;
    },
    getParticipants() {
        return [
            {
                id: 1,
                name: 'Andrey Zorin',
                login: 'zorin',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 9,
                name: 'Artem Kozlov',
                login: 'tadoma',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 3,
                name: 'Michail Fedoseev',
                login: 'fedoseev',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: false
            },
            {
                id: 4,
                name: 'Nikolai Petrov',
                login: 'login1',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 5,
                name: 'Alexandra Sotnikova',
                login: 'login2',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 6,
                name: 'Ilya Bokov',
                login: 'login3',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 7,
                name: 'Ira Raush',
                login: 'login4',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            },
            {
                id: 8,
                name: 'Katya Eliseeva',
                login: 'login5',
                avatar: 'https://octodex.github.com/images/electrocat.png',
                online: true
            }
        ];
    }
};

export default {
    namespaced: true,
    getters,
    state,
    mutations,
    actions
};
