<template>
    <v-layout column>
        <v-flex class="mx-auto">
            <v-btn color="primary ma-3" round @click.native.stop="createPostClicked">Create post</v-btn>
            <v-dialog v-model="dialog" persistent max-width="600">
                <PostCreate @cancelClicked="cancelClicked"/>
            </v-dialog>
        </v-flex>
        <v-flex class="mx-auto" v-for="post in posts" :key="post.id">
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
        ])
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
