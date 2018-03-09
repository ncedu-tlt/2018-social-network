<template>
    <v-app>
        <NavBar @clickOnHamburgerButton="switchDrawerVisible"/>
        <Drawer :is-drawer-visible.sync="isDrawerVisible"/>
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
            isDrawerVisible: true
        };
    },
    methods: {
        switchDrawerVisible() {
            this.isDrawerVisible = !this.isDrawerVisible;
        }
    }
};
</script>
