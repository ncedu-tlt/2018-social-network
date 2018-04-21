import Vue from 'vue';
import Vuex from 'vuex';
import chat from '@/store/modules/chat';
import auth from '@/store/modules/auth';
import projects from '@/store/modules/projects';
import feed from '@/store/modules/feed';
import chats from '@/store/modules/chats';
import friends from '@/store/modules/friends';

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== 'production';

export default new Vuex.Store({
    modules: {
        chat,
        projects,
        auth,
        feed,
        chats,
        friends
    },
    strict: debug
});
