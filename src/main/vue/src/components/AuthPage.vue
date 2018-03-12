<template>
    <v-container grid-list-xl text-xs-center>
        <v-layout row wrap>
            <v-flex>
                <div class="welcome logo">
                    <!--TODO logo-->
                    <!--<svg/>-->
                    <img src="../assets/logo.png" alt="Dev Comrades">
                </div>
            </v-flex>
            <v-flex>
                <div class="welcome message">
                    <div class="welcome text">
                        <p class="primary--text">Welcome to social network <br> for geeks!</p>
                    </div>
                    <div v-if="isAuthed" class="button logout">
                        <v-btn
                            large
                            dark
                            color="primary"
                            @click="logout"
                            :key="+isAuthed">{{ $t('auth.logout') }}</v-btn>
                    </div>
                    <div v-else class="button login">
                        <v-btn
                            large
                            dark
                            color="primary"
                            href="/login">{{ $t('auth.login') }}</v-btn>
                    </div>
                </div>
            </v-flex>
        </v-layout>
    </v-container>
</template>
<script>
import { mapActions, mapState } from 'vuex';

export default {name: 'AuthPage',
    computed: {
        ...mapState('auth', [
            'isAuthed'
        ])
    },
    watch: {
        isAuthed: function () {
            if (window.localStorage) {
                localStorage.setItem('isAuthed', this.isAuthed); // type of value - string
            }
        }
    },
    beforeMount() {
        this.checkAuth();
    },
    methods: {
        ...mapActions('auth', [
            'checkAuth',
            'logout'
        ])
    }};
</script>
<style scoped>
    .welcome{
        margin-top: 10%;
    }
    .text{
        font: bold 2em Roboto, sans-serif;
    }
    .button{
        margin-top: 5%;
    }
</style>
