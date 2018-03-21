<template>
    <v-container>
        <v-layout row>
            <v-flex xs12>
                <ProjectList :user-name="userName"/>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import ProjectList from './ProjectList';
import { mapState } from 'vuex';

export default {
    name: 'ProjectsPage',
    components: {
        ProjectList
    },
    computed: {
        ...mapState('auth', [
            'userName'
        ])
    }
};
</script>

<style scoped>

</style>
