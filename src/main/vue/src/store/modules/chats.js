import { getCurrentUser, getUser } from '@/api/rest/user.api';
import { addChat, getChats } from '@/api/rest/chat.api';

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
        return state.participants.find(p => p.userId === id);
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
        const authResponse = await getChats();
        const updatedChats = authResponse.data;
        commit('updateChats', updatedChats);
    },
    async addChat({ commit }, people) {
        const response = await getCurrentUser();
        const userId = response.data.userId;
        let chat = {
            participantsId: people.map(p => p.id)
        };
        chat.participantsId.push(userId);
        await addChat(chat);
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
    async updateParticipants({ commit }, payload) {
        let participants = [];
        let participantId;
        for (participantId of payload) {
            const response = await getUser(participantId);
            participants.push(response.data);
        }
        commit('updateParticipants', participants);
    }
};

export default {
    namespaced: true,
    getters,
    state,
    mutations,
    actions
};
