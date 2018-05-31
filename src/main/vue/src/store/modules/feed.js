import {
    addComment,
    createPost,
    getComments,
    getPosts,
    updateCommentLike,
    updatePostLike
} from '../../api/rest/feed.api';

const state = {
    posts: [],
    comments: []
};

const mutations = {
    updatePosts(state, posts) {
        state.posts = posts;
    },
    updateComments(state, comment) {
        state.comments = comment;
    }
};

const actions = {
    async sendComment({commit}, comment) {
        await addComment(comment);
        const response = await getComments();
        commit('updateComments', response.data);
    },
    async setLikePost({commit}, like) {
        await updatePostLike(like);
        const response = await getPosts();
        commit('updatePosts', response.data);
    },
    async setLikeComment({commit}, like) {
        await updateCommentLike(like);
        const response = await getComments();
        commit('updateComments', response.data);
    },
    async getPosts({commit}) {
        const response = await getPosts();
        commit('updatePosts', response.data);
    },
    async getComments({commit}) {
        const response = await getComments();
        commit('updateComments', response.data);
    },
    async createPost({commit}, post) {
        await createPost(post);
        const response = await getPosts();
        commit('updatePosts', response.data);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
