<template>
    <v-app>
        <NavBar @hamburgerClick="switchDrawerVisible"/>
        <Drawer :visible.sync="opened"/>
        <v-content>
            <router-view/>
        </v-content>
    </v-app>
</template>

<script>
import NavBar from './components/NavBar.vue';
import Drawer from './components/Drawer';

export default {
    name: 'App',
    components: {
        Drawer,
        NavBar
    },
    data() {
        return {
            opened: true
        };
    },
    mounted() {
        this.$i18n.locale = localStorage.getItem('language');
    },
    methods: {
        switchDrawerVisible() {
            this.opened = !this.opened;
        }
    }
};
</script>
