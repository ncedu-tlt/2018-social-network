<template>
    <v-card class="mx-auto mt-1" flat>
        <v-layout>
            <v-avatar :size="70" class="primary ma-2">
                <img :src="comment.user.imagePath">
            </v-avatar>
            <v-flex>
                <div class="pt-2 pr-1">
                    <span class="title primary--text pt-0 pl-1 pb-0 pr-1"> {{ comment.user.name }} </span>
                </div>
                <v-card-title class="pt-0 pl-1 pb-0 pr-1">
                    {{ comment.content }}
                </v-card-title>
                <v-card-title class="comment__bottom pt-0 pl-1 pb-0 pr-1">
                    <span class="grey--text">{{ $d(new Date(comment.date), 'long') }}</span>
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
                </v-card-title>
            </v-flex>
        </v-layout>
    </v-card>
</template>

<script>
import {mapActions} from 'vuex';

export default {
    name: 'Comment',
    props: {
        comment: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            userName: this.$store.state.auth.userName
        };
    },
    computed: {
        searchLike: {
            get() {
                let foundLike = this.comment.likes.find(o => {
                    if (o.user.login === this.userName) {
                        return true;
                    }
                });
                return !!foundLike;
            }
        }
    },
    methods: {
        likeClicked() {
            const like = {
                commentId: this.comment.id,
                likeValue: !this.searchLike
            };
            this.setLikeComment(like);
        },
        ...mapActions('feed', [
            'setLikeComment'
        ])
    }
};
</script>

<style scoped>
    .card {
        width: 600px;
        min-width: 100%;
    }
    .avatar {
        width: 100px;
    }
    .comment__bottom {
        align-items: center;
    }
</style>
