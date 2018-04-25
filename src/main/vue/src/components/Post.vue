<template>
    <div>
        <v-card class="mx-auto mt-4">
            <v-layout>
                <v-avatar :size="70" class="primary ma-2">
                    <img :src="post.user.avatar">
                </v-avatar>
                <v-flex>
                    <div class="post__title pt-2 pr-1">
                        <span class="title primary--text pt-0 pl-1 pb-0 pr-1"> {{ post.user.name }} </span>
                        <v-spacer/>
                        <v-chip
                            color="primary"
                            text-color="white"
                            small
                            disabled>
                            <template v-if="post.type === 'Post'">
                                {{ $t('post.type.post') }}
                            </template>
                            <template v-else-if="post.type === 'Commit'">
                                {{ $t('post.type.commit') }}
                            </template>
                            <template v-else-if="post.type === 'Merge Request'">
                                {{ $t('post.type.mergeRequest') }}
                            </template>
                            <template v-else>
                                {{ $t('post.type.issue') }}
                            </template>
                        </v-chip>
                    </div>
                    <v-card-title class="pt-0 pl-1 pb-1 pr-1">
                        <span class="grey--text">{{ post.date }}</span>
                    </v-card-title>
                    <v-card-title class="pt-0 pl-1 pb-0 pr-1">
                        {{ post.content }}
                    </v-card-title>
                    <v-card-title class="pt-0 pl-1 pb-0 pr-1">
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
    </div>
</template>

<script>
import Comment from '@/components/Comment';
import CommentAdd from '@/components/CommentAdd';
import { mapActions } from 'vuex';

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
            'setLikePost',
            'updatePosts'
        ])
    }
};
</script>

<style scoped>
    .card {
        width: 600px;
        max-width: 100%;
    }
    .avatar {
        width: 100px;
    }
    .post__title {
        align-items: center;
        display: flex;
    }
</style>
