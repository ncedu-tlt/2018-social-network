<template>
    <v-app>
        <NavBar @OpenDrawer="switchDrawerVisible"/>
        <Drawer :is-drawer-visible-desktop.sync="isDrawerVisibleDesktop" :is-drawer-visible-mobile="isDrawerVisibleMobile"/>
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
            isDrawerVisibleDesktop: true,
            isDrawerVisibleMobile: false,
            mobile: window.innerWidth <= 1264
        };
    },
    methods: {
        switchDrawerVisible() {
            if (this.mobile === false) {
                this.isDrawerVisibleMobile = false;
                this.isDrawerVisibleDesktop = !this.isDrawerVisibleDesktop;
            } else {
                this.isDrawerVisibleDesktop = false;
                this.isDrawerVisibleMobile = !this.isDrawerVisibleMobile;
            }
        }
    }
};
</script>
