import {addComment, createPost, getPosts, updateCommentLike, updatePostLike} from '../../api/rest/feed.api';

const state = {
    posts: []
};

const mutations = {
    sendComment(state, comment) {
        const post = state.posts.find(p => p.id === comment.postId);
        if (post) {
            addComment(comment);
        }
    },
    setLikePost(state, like) {
        const updateLike = state.posts.find(p => p.id === like.postId);
        if (updateLike) {
            updateLike.likeValue = like.updateLike;
            updateLike.postId = like.postId;
            updatePostLike(updateLike);
        }
    },
    setLikeComment(state, like) {
        state.posts.forEach(function (item) {
            item.comments.forEach(function (c) {
                if (c.id === like.commentId) {
                    c.likeComment = like.updateLike;
                    updateCommentLike(c);
                }
            });
        });
    },
    updatePosts(state, post) {
        state.posts = post;
    }
};

const actions = {
    sendComment({commit}, comment) {
        commit('sendComment', comment);
    },
    setLikePost({commit}, like) {
        commit('setLikePost', like);
    },
    setLikeComment({commit}, like) {
        commit('setLikeComment', like);
    },
    async getPosts({commit}) {
        const response = await getPosts();
        const updatePosts = response.data;
        commit('updatePosts', updatePosts);
    },
    async createPost({commit}, post) {
        await createPost(post);
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions
};
