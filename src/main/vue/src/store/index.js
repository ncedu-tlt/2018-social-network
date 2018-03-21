import Vue from 'vue';
import Vuex from 'vuex';
import chat from '@/store/modules/chat';
import auth from '@/store/modules/auth';
import projects from '@/store/modules/projects';

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== 'production';

export default new Vuex.Store({
    modules: {
        chat,
        auth,
        projects
    },
    strict: debug
});
