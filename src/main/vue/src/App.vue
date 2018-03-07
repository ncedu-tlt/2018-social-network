<template>
    <v-app>
        <NavBar @OpenDrawer="switchDrawerVisible"/>
        <Drawer :is-drawer-visible-desktop.sync="isDrawerVisibleDesktop" :is-drawer-visible-mobile="isDrawerVisibleMobile"/>
        <v-content>
            <div>{{ isDrawerVisibleMobile }}</div>
            <div>{{ isDrawerVisibleDesktop }}</div>
            <router-view/>
        </v-content>
    </v-app>
</template>

<script>
import NavBar from './components/NavBar.vue';
import Drawer from './components/Drawer';

function isMobile() {
    return window.innerWidth < 1264;
}
export default {
    name: 'App',
    components: {
        Drawer,
        NavBar
    },
    data() {
        return {
            isDrawerVisibleDesktop: true,
            isDrawerVisibleMobile: false
        };
    },
    methods: {
        switchDrawerVisible() {
            let mobileVersion = isMobile();
            if (!mobileVersion) {
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
