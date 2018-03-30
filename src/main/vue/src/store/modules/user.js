import {getCurrentUser} from '@/api/rest/user.api';

const state = {
    authorizedUser: {}
};

const actions = {
    getAuthorizedUser(context) {
        getCurrentUser().then((response) => {
            context.commit('SET_AUTHORIZED_USER', response.data);
        }
        );
    }
};

const mutations = {
    SET_AUTHORIZED_USER(user) {
        state.user = user;
    }
};

export default {
    namespaced: true,
    state,
    actions,
    mutations
};
