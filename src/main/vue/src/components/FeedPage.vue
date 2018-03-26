<template>
    <v-layout>
        <v-flex offset-md3>
            <Feed :posts="posts"/>
        </v-flex>
    </v-layout>
</template>

<script>
import Feed from '@/components/Feed';

export default {
    name: 'FeedPage',
    components: {
        Feed
    },
    computed: {
        posts() {
            return this.$store.state.feed.posts;
        }
    }
};
</script>
