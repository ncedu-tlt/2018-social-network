import { getCurrentUser, getUser } from '@/api/rest/user.api';
import { addChat, getChats } from '@/api/rest/chat.api';

const state = {
    chats: [],
    participants: []
};

const getters = {
    getChatsByParticipantId: (state) => (id) => {
        if (state.chats.length === 0) {
            return [];
        } else {
            let participantsChat = state.chats.reduce(
                (accumulator, current) => [...accumulator, [current.participants.map(p => p.userId), current.id]], 0);
            return participantsChat.filter(item => item[0].toString() === id.toString());
        }
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
    async addChat({ commit, dispatch }, people) {
        const response = await getCurrentUser();
        const userId = response.data.userId;
        let chat = {
            participantsId: people.map(p => p.userId)
        };
        chat.participantsId.push(userId);
        await addChat(chat);
        await dispatch('updateChats');
        return state.chats[state.chats.length - 1];
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
        for (let participant of payload) {
            const response = await getUser(participant.userId);
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
