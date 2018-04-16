<template>
    <v-container>
        <v-card class="mt-3">
            <v-card-title>
                <v-flex align-center>
                    <div>{{ $t('settings.show_hide') }}</div>
                </v-flex>
            </v-card-title>
            <v-card-actions>
                <v-list>
                    <v-list-tile v-for="settingUnit in settings.settingUnits" :key="settingUnit.name">
                        <v-list-tile-content>
                            <v-list-tile-title> {{ $t(settingUnit.name) }}</v-list-tile-title>
                        </v-list-tile-content>
                        <v-list-tile-action class="ml-5">
                            <v-checkbox v-model="settingUnit.value" color="primary"/>
                        </v-list-tile-action>
                        <v-list-tile-avatar/>
                    </v-list-tile>
                </v-list>
            </v-card-actions>
        </v-card>
        <v-card class="mt-3">
            <v-card-title>
                <div>{{ $t('settings.switch_language') }}</div>
            </v-card-title>
            <v-card-actions>
                <v-flex xs12 sm6 class="text-xs-center">
                    <v-select
                        v-if="settings != null && settings.availableLanguages != null"
                        @change="switchLanguage"
                        :items="$t(settings.availableLanguages)"
                        item-text="name"
                        :label="$t('settings.switch_language')"
                        max-height="auto"/>
                </v-flex>
            </v-card-actions>
        </v-card>
        <v-card class="mt-3">
            <v-card-title>
                <v-flex>
                    <div>{{ $t('settings.delete_account') }}</div>
                </v-flex>
            </v-card-title>
            <v-flex class="text-xs-center">
                <v-btn color="error" @click="showDeleteMessage = !showDeleteMessage" v-if="!showDeleteMessage">
                    <h3> Delete Profile </h3>
                </v-btn>
                <v-card-actions>
                    <v-text-field label="Enter DELETE ACCOUNT to confirm" id="testing" v-show="showDeleteMessage"/>
                    <v-btn color="primary" @click="showDeleteMessage = !showDeleteMessage" v-if="showDeleteMessage">
                        Cancel
                    </v-btn>
                    <v-btn color="error" v-if="showDeleteMessage">
                        Confirm
                    </v-btn>
                </v-card-actions>
            </v-flex>
        </v-card>

    </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
    name: 'Settings',
    data() {
        return {
            showDeleteMessage: false
        };
    },
    computed: {
        ...mapState('settings', [
            'settings'
        ])
    },
    mounted() {
        this.getSettings();
    },
    methods: {
        async getUserSettings() {
        },
        switchLanguage() {
        },
        ...mapActions('settings', [
            'getSettings'
        ])
    }
};
</script>

<style scoped>

</style>
