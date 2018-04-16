<template>
    <v-container class="pt-2">
        <v-layout column>
            <v-flex v-for="post in posts" :key="post.id">
                <Post :post="post" />
            </v-flex>
        </v-layout>
    </v-container>
</template>
<script>
import Post from '@/components/Post';

export default {
    name: 'Feed',
    components: {
        Post
    },
    computed: {
        posts() {
            return this.$store.state.feed.posts;
        }
    }
};
</script>
