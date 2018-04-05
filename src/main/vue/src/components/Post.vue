<template>
    <v-container>
        <v-card class="mx-auto">
            <v-layout>
                <v-avatar :size="70" class="primary">
                    <img :src="post.user.avatar">
                </v-avatar>
                <v-flex>
                    <v-card-title class="post__title">
                        <span class="title primary--text"> {{ post.user.name }} </span>
                        <v-spacer/>
                        <v-chip color="primary" text-color="white" small>
                            {{ post.type }}
                        </v-chip>
                    </v-card-title>
                    <v-card-title>
                        <span class="grey--text">{{ $d(post.date, 'long') }}</span>
                    </v-card-title>
                    <v-card-title>
                        {{ post.content }}
                    </v-card-title>
                    <v-card-title>
                        <v-spacer/>
                        <v-btn @click="likeClicked" flat icon color="black">
                            <v-icon color="black" v-if="!likeShow">
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
            <div v-if="commentsShow">
                <v-flex v-for="comment in post.comments" :key="comment.id">
                    <Comment :post-id="post.id" :comment="comment"/>
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
            likeShow: false,
            commentsShow: false,
            date: new Date()
        };
    },
    methods: {
        commentClicked() {
            this.commentsShow = !this.commentsShow;
        },
        likeClicked() {
            this.likeShow = !this.likeShow;
            const like = {
                postId: this.post.id,
                isLiked: this.likeShow
            };
            this.setLike(like);
        },
        ...mapActions('feed', [
            'setLike'
        ])
    }
};
</script>

<style scoped>
    .card {
        max-width: 600px;
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
        height: 35px;
        align-items: normal;
    }
    .title {
        padding-top: 10px;
    }
</style>
