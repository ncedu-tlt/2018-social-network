<template>
    <v-app id="app">
        <v-toolbar color="red darken-4" dark fixed app>
            <v-toolbar-title>DevComrades</v-toolbar-title>
            <v-spacer/>
            <v-avatar class="grey lighten-4">
                <img src="./assets/logo.png">
            </v-avatar>
        </v-toolbar>
        <v-content>
            <router-view/>
        </v-content>
    </v-app>
</template>

<script>
export default {
    name: 'App'
};
</script>

<style>
#app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
