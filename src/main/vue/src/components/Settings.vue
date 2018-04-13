<template>
    <v-container>
        <v-card class="mt-3">
            <v-card-title>
                <div>
                    <h3>Show/hide</h3>
                </div>
            </v-card-title>
            <v-divider/>
            <v-card-title>
                <v-btn color="primary" text-color="white" @click="switchLanguage = !switchLanguage">
                    <h3> Switch Language </h3>
                </v-btn>
            </v-card-title>
            <v-select v-show="switchLanguage" auto min-width="100" :items="languages" />
            <v-divider/>
            <v-card-title>
                <v-btn color="error" @click="deleteVisible = !deleteVisible">
                    <h3> Delete Profile </h3>
                </v-btn>
            </v-card-title>
            <v-card-actions>
                <v-text-field name="input-1" label="Enter DELETE ACCOUNT to confirm" id="testing" v-show="deleteVisible">
                    ss
                </v-text-field>
            </v-card-actions>
        </v-card>
        <v-btn @click="getUserSettings"> ss </v-btn>

    </v-container>
</template>

<script>
import {getSettings} from '@/api/rest/user.api';

export default {
    name: 'Settings',
    data() {
        return {
            deleteVisible: false,
            switchLanguage: false,
            languages: []
        };
    },
    async created() {
        let settings = await getSettings();
        console.log(settings);
        this.languages = settings.data.availableLanguages;
    },
    methods: {
        async getUserSettings() {
            console.log(await getSettings());
        }
    }
};
</script>

<style scoped>

</style>
