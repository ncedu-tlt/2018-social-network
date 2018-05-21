<template>
    <v-container>
        <v-card>
            <v-text-field class="px-5"/>
        </v-card>
        <v-card class="mt-2" v-for="friend in computedFriends" :key="friend.id">
            <v-container>
                <v-layout row>
                    <v-flex xs2>
                        <v-badge right overlap bottom color="transparent">
                            <v-avatar slot="badge" size="15" v-if="friend.online">
                                <img src="../assets/online-indicator.png">
                            </v-avatar>
                            <v-avatar size="75">
                                <img :src="friend.avatar">
                            </v-avatar>
                        </v-badge>
                    </v-flex>
                    <v-flex xs8>
                        <v-card-title class="body-2">{{ friend.name }}</v-card-title>
                    </v-flex>
                    <v-flex xs5>
                        <v-card-actions>
                            <v-btn flat color="primary">написать</v-btn>
                            <v-btn flat color="error">удалить</v-btn>
                        </v-card-actions>
                    </v-flex>
                    <v-flex>
                        <v-btn flat icon>
                            <v-icon click="">settings</v-icon>
                        </v-btn>
                    </v-flex>
                </v-layout>
            </v-container>
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
