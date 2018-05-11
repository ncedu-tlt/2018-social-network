import Vue from 'vue';
import Vuex from 'vuex';
import auth from '@/store/modules/auth';
import projects from '@/store/modules/projects';
import feed from '@/store/modules/feed';
import chats from '@/store/modules/chats';
import friends from '@/store/modules/friends';
import settings from '@/store/modules/settings';

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== 'production';

export default new Vuex.Store({
    modules: {
        projects,
        auth,
        feed,
        chats,
        friends,
        settings
    },
    strict: debug
});
