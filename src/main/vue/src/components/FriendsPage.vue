<template>
    <v-container>
        <friend :friends="friends"/>
        <v-btn @click="addFriend" >Добавить друга</v-btn>
    </v-container>
</template>

<script>

import Friend from './FriendsList';

export default {
    name: 'FriendsPage',
    components: {Friend},
    data() {
        return {
            friendDelete: this.isDelete
        };
    },
    computed: {
        friends() {
            return this.$store.state.friends.friends;
        }
    },
    mounted() {
        this.$store.dispatch('friends/getFriends');
    },
    methods: {
        addFriend() {
            let testMan = {
                userId: 2,
                name: 'IvanNeplokhov'
            };
            this.$store.dispatch('friends/addFriend', testMan);
        }
    }
};
</script>

<style scoped>

</style>
