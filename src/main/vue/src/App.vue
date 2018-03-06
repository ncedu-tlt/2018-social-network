<template>
    <v-app>
        <NavBar @ClickOnHamburgerButton="changeDrawerVisible"/>
        <Drawer :is-drawer-visible.sync="drawerVisible"/>
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
            drawerVisible: false
        };
    },
    methods: {
        changeDrawerVisible() {
            this.drawerVisible = !this.drawerVisible;
        }
    }
};
</script>
