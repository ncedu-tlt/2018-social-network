<template>
    <div>
        <v-card class="mt-4">
            <v-layout>
                <v-avatar :size="70" class="primary ma-2">
                    <img :src="post.user.imagePath">
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
                        <span class="grey--text">
                            {{ $d(new Date(post.date), 'long') }}
                        </span>
                    </v-card-title>
                    <v-card-title class="pt-0 pl-1 pb-0 pr-1">
                        {{ post.content }}
                    </v-card-title>
                    <v-card-title class="pt-0 pl-1 pb-0 pr-1">
                        <v-spacer/>
                        <v-btn
                            flat
                            icon
                            @click="likeClicked"
                            color="black">
                            <v-icon color="primary" v-if="searchLike">
                                favorite
                            </v-icon>
                            <v-icon color="black" v-else>
                                favorite_border
                            </v-icon>
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
                <v-flex v-for="comment in comments" :key="comment.id">
                    <Comment v-if="comment.postId === post.id" :comment="comment"/>
                </v-flex>
                <CommentAdd :post-id="post.id"/>
            </div>
        </v-slide-y-transition>
    </div>
</template>

<script>
import Comment from '@/components/Comment';
import CommentAdd from '@/components/CommentAdd';

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
        },
        comments: {
            type: Array,
            required: true
        }
    },
    data() {
        return {
            showComments: false,
            userName: this.$store.state.auth.userName,
            userId: this.$store.state.auth.userId
        };
    },
    computed: {
        searchLike: {
            get() {
                let foundLike = this.post.likes.find(o => {
                    if (o.user.login === this.userName) {
                        return true;
                    }
                });
                return !!foundLike;
            }
        }
    },
    methods: {
        commentClicked() {
            this.showComments = !this.showComments;
        },
        likeClicked() {
            const like = {
                userId: this.userId,
                postId: this.post.id,
                likeValue: !this.searchLike
            };
            this.$store.dispatch('feed/setLikePost', like);
        }
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
