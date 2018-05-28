<template>
    <v-container>
        <friend :friends="friends"/>
        <v-btn @click="addFriend" color="success">Добавить друга</v-btn>
        <v-snackbar right :timeout="5000" v-model="isRemoved" color="error">
            <strong>{{ $t('friend_remove') }} </strong>
        </v-snackbar>
    </v-container>
</template>

<script>

import Friend from './FriendsList';

export default {
    name: 'FriendsPage',
    components: {Friend},
    data() {
        return {
            friendDelete: this.$store.state.friends.isRemoved
        };
    },
    computed: {
        friends() {
            return this.$store.state.friends.friends;
        },
        isRemoved: {
            get() {
                return this.$store.state.friends.isRemoved;
            },
            set() {
                this.$store.commit('friends/setRemoved');
            }
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
