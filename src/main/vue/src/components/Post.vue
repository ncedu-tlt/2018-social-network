<template>
    <v-container>
        <v-card class="mx-auto">
            <v-layout>
                <v-avatar :size="70" class="primary">
                    <img :src="post.user.avatar">
                </v-avatar>
                <v-flex>
                    <div class="post__title">
                        <span class="title primary--text"> {{ post.user.name }} </span>
                        <v-spacer/>
                        <v-chip
                            v-if="post.type === 'Post'"
                            color="primary"
                            text-color="white"
                            small
                            disabled>
                            {{ $t('post.type.post') }}
                        </v-chip>
                        <v-chip
                            v-else
                            color="primary"
                            text-color="white"
                            small
                            disabled>
                            {{ $t('post.type.commit') }}
                        </v-chip>
                    </div>
                    <v-card-title>
                        <span class="grey--text">{{ $d(post.date, 'long') }}</span>
                    </v-card-title>
                    <v-card-title>
                        {{ post.content }}
                    </v-card-title>
                    <v-card-title>
                        <v-spacer/>
                        <v-btn @click="likeClicked" flat icon color="black">
                            <v-icon color="black" v-if="!post.like">
                                favorite_border
                            </v-icon>
                            <v-icon color="primary" v-else>favorite</v-icon>
                        </v-btn>
                        <v-btn flat icon color="black" @click="commentClicked">
                            <v-icon>comment</v-icon>
                        </v-btn>
                        <v-btn flat icon color="black">
                            <v-icon>share</v-icon>
                        </v-btn>
                    </v-card-title>
                </v-flex>
            </v-layout>
        </v-card>
        <v-slide-y-transition>
            <div v-if="showComments">
                <v-flex v-for="comment in post.comments" :key="comment.id">
                    <Comment :comment="comment"/>
                </v-flex>
                <CommentAdd :post-id="post.id"/>
            </div>
        </v-slide-y-transition>
    </v-container>
</template>

<script>
import Comment from '@/components/Comment';
import CommentAdd from '@/components/CommentAdd';
import {mapActions} from 'vuex';

export default {
    name: 'Post',
    components: {
        Comment,
        CommentAdd
    },
    props: {
        post: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            showComments: false
        };
    },
    methods: {
        commentClicked() {
            this.showComments = !this.showComments;
        },
        likeClicked() {
            const like = {
                postId: this.post.id,
                updateLike: !this.post.like
            };
            this.setLikePost(like);
        },
        ...mapActions('feed', [
            'setLikePost'
        ])
    }
};
</script>

<style scoped>
    .card {
        max-width: 600px;
        min-width: 350px;
        min-height: 100px;
    }
    .avatar {
        margin: 10px 10px 10px;
        width: 100px;
    }
    .card__title {
        padding: 2px;
    }
    .post__title {
        align-items: center;
        display: flex;
        padding-top: 10px;
    }
</style>
