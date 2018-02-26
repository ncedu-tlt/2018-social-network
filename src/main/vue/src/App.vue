<template>
    <v-app>
        <nav-bar>Nav-bar</nav-bar>
        <v-content class="form-content">
            <router-view/>
        </v-content>
    </v-app>
</template>

<script>
import NavBar from './components/NavBar.vue';
export default {
    components: {NavBar}
};
</script>

<style>
.form-content {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
