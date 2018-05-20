<template>
    <v-container>
        <v-card>
            <v-text-field class="px-5"/>
        </v-card>
        <v-card class="mt-4" v-for="friend in computedFriends" :key="friend.id">
            <v-list>
                <v-list-tile>
                    <v-list-tile-avatar>
                        <img :src="friend.avatar">
                    </v-list-tile-avatar>
                    <v-list-tile-title>{{ friend.name }}</v-list-tile-title>
                    <v-list-tile-action class="font-primary">Добавить</v-list-tile-action>
                </v-list-tile>
            </v-list>
        </v-card>
    </v-container>
</template>

<script>
export default {
    name: 'Friend',
    data() {
        return {
            id: 1,
            friends: this.$store.state.friends.friends
        };
    },
    computed: {
        computedFriends() {
            return this.friends.map(function (friend) {
                return {
                    id: friend.id,
                    name: friend.name,
                    avatar: friend.avatar,
                    login: friend.login,
                    online: friend.online
                };
            });
        }
    },
    mounted() {
        this.$store.dispatch('friends/updateFriends');
    }
};
</script>

<style scoped>

</style>
