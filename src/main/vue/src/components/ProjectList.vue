<template>
    <v-container fill-height>
        <v-layout row wrap align-center>
            <v-flex align-content-center>
                <v-card>
                    <v-toolbar card color="white">
                        <v-toolbar-title class="primary--text">
                            {{ $t('projects') }}
                            <span class="secondary--text">({{ projects.length }})</span>
                        </v-toolbar-title>
                        <v-spacer/>
                        <v-btn v-if="projects.length > 0" icon>
                            <v-icon>search</v-icon>
                        </v-btn>
                    </v-toolbar>
                    <div
                        v-for="project in projects"
                        :key="project.id">

                        <v-container fluid grid-list-lg>
                            <v-layout row>
                                <v-flex xs5>
                                    <div>
                                        <div class="headline">
                                            <a target="_blank" :href="project.html_url">
                                                {{ project.name }}
                                            </a>
                                            <span class="fork pa-2" v-if="project.fork">
                                                <v-icon>repeat</v-icon>
                                            </span>
                                        </div>
                                        <div>{{ project.description }}</div>
                                    </div>
                                </v-flex>
                                <v-flex xs3 text-xs-center>
                                    <v-card-text>
                                        {{ project.language }}
                                    </v-card-text>
                                </v-flex>
                                <v-flex xs4 text-xs-center>
                                    <v-card-text>
                                        <span class="group pa-2">
                                            <v-icon>stars</v-icon>
                                            {{ project.stargazers_count }}
                                        </span>
                                    </v-card-text>
                                </v-flex>
                            </v-layout>
                        </v-container>
                    </div>
                </v-card>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex';

export default {
    name: 'ProjectList',
    props: {
        userName: {
            type: String,
            required: false,
            default: ''
        }
    },
    computed: {
        ...mapState('projects', [
            'projects'
        ])
    },
    mounted() {
        this.updateProjects(this.userName);
    },
    methods: {
        ...mapActions('projects', [
            'updateProjects'
        ])
    }
};

</script>

<style scoped>

</style>
