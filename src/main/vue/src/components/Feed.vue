<template>
    <v-container>
        <Post v-for="post in posts" :key="post.id_post" :post="post"/>
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

<style scoped>

</style>
