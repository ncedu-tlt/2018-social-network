<template>
    <v-layout column>
        <v-flex class="mx-auto">
            <v-btn color="primary ma-3" round @click.native.stop="createPostClicked">Create post</v-btn>
            <v-dialog v-model="dialog" persistent max-width="600">
                <PostCreate @cancelClicked="cancelClicked"/>
            </v-dialog>
        </v-flex>
        <v-flex class="mx-auto" v-for="post in computedPosts" :key="post.id">
            <Post :post="post" :comments="comments"/>
        </v-flex>
    </v-layout>
</template>
<script>
import Post from '@/components/Post';
import PostCreate from '@/components/PostCreate';
import {mapState} from 'vuex';

export default {
    name: 'Feed',
    components: {
        Post,
        PostCreate
    },
    data() {
        return {
            dialog: false
        };
    },
    computed: {
        ...mapState('feed', [
            'posts',
            'comments'
        ]),
        computedPosts() {
            return this.posts.filter(function (el) {
                return el;
            }).sort(function (first, second) {
                if (first.date < second.date) return 1;
                else return 0;
            });
        }
    },
    mounted() {
        this.$store.dispatch('feed/getPosts');
        this.$store.dispatch('feed/getComments');
    },
    methods: {
        cancelClicked() {
            this.dialog = false;
        },
        createPostClicked() {
            this.dialog = true;
        }
    }
};
</script>
