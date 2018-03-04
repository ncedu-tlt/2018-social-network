<template>
    <v-app>
        <NavBar @ClickHamburgerMenu="switchDrawer"/>
        <Drawer :sw="swDrawer"/>
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
            swDrawer: true
        };
    },
    methods: {
        switchDrawer() {
            this.swDrawer = !this.swDrawer;
        }
    }
};
</script>
