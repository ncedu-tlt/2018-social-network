<template>
    <v-container>
        <v-card>
            <v-layout row wrap class="ml-3">
                <v-icon x-large class="search_icon">search</v-icon>
                <v-flex d-flex class="ml-3 mr-5">
                    <v-text-field v-model="nameFilter" label="Начните вводить имя друга!"/>
                </v-flex>
            </v-layout>
        </v-card>
        <v-card v-for="friend in filterFriends(computedFriends, nameFilter)" :key="friend.id" class="mt-1">
            <v-container>
                <v-layout row wrap>
                    <v-badge right overlap bottom color="transparent">
                        <v-avatar slot="badge" size="15" v-if="friend.online">
                            <img src="../assets/online-indicator.png">
                        </v-avatar>
                        <v-avatar size="75">
                            <img :src="friend.avatar">
                        </v-avatar>
                    </v-badge>
                    <v-layout justify-space-between>
                        <v-flex xs4 inline-flex>
                            <v-card-title class="body-2">{{ friend.name }}</v-card-title>
                        </v-flex>
                        <v-flex d-flex xs1>
                            <v-card-actions>
                                <v-menu open-on-hover offset-y>
                                    <v-icon large slot="activator">more_horiz</v-icon>
                                    <v-card>
                                        <v-list>
                                            <v-list-tile>
                                                <v-btn flat color="primary">
                                                    <v-icon class="pr-2">message</v-icon>
                                                    написать
                                                </v-btn>
                                                <v-btn flat color="error">
                                                    <v-icon class="pr-2">delete</v-icon>
                                                    удалить
                                                </v-btn>
                                            </v-list-tile>
                                        </v-list>
                                    </v-card>
                                </v-menu>
                            </v-card-actions>
                        </v-flex>
                    </v-layout>
                </v-layout>
            </v-container>
        </v-card>
    </v-container>
</template>

<script>
/* eslint-disable eqeqeq */

export default {
    name: 'Friend',
    data() {
        return {
            friends: this.$store.state.friends.friends,
            nameFilter: '',
            searchVisible: false
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
    },
    methods: {
        filterFriends(computedFriends, nameFilter) {
            return computedFriends.filter(function (friend) {
                if (nameFilter) {
                    return friend.name.toLowerCase().includes(nameFilter);
                } else {
                    return friend;
                }
            });
        }
    }
};
</script>

<style scoped>
</style>
