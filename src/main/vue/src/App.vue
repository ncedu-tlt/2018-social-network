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
            opened: {
                desktop: false,
                mobile: false
            }
        };
    },
    methods: {
        switchDrawerVisible() {
            if (!this.$vuetify.breakpoint.mdAndDown) {
                this.opened.desktop = !this.opened.desktop;
            } else {
                this.opened.mobile = !this.opened.mobile;
            }
        }
    }
};
</script>
<style>
    html{
        overflow: hidden;
    }
</style>
