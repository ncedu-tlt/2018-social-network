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
                    <v-list-tile v-for="settingUnit in checkboxesViewModel" :key="settingUnit.name">
                        <v-list-tile-content>
                            <v-list-tile-title> {{ $t(settingUnit.name) }}</v-list-tile-title>
                        </v-list-tile-content>
                        <v-list-tile-action class="ml-5">
                            <v-checkbox v-model="settingUnit.value" :checked="settingUnit.value" color="primary"/>
                        </v-list-tile-action>
                        <v-list-tile-avatar/>
                    </v-list-tile>
                    <div>{{ checkboxesViewModel }}</div>
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
                        @input="switchLanguage"
                        :items="createLanguagesObject"
                        item-text="name"
                        item-avatar="img"
                        :label="$t('settings.switch_language')"
                        v-model="currentLanguage"/>
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
                    <v-btn color="error" v-if="showDeleteMessage" @click="deleteConfirm">
                        Confirm
                    </v-btn>
                </v-card-actions>
            </v-flex>
            <v-btn @click="testMethod"/>
        </v-card>
    </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex';
import { setSettings } from '../api/rest/settings.api';

export default {
    name: 'Settings',
    data() {
        return {
            showDeleteMessage: false,
            currentLanguage: this.$store.locale,
            showSettings: [],
            checkboxes: [{name: 'vasya', value: true, id: 1},
                {name: 'petya', value: false, id: 2}
            ],
            checkboxesViewModel: []
        };
    },
    computed: {
        ...mapState('settings', [
            'settings'
        ]),
        createLanguagesObject() {
            if (this.settings && this.settings.availableLanguages) {
                let languagesViewModels = [];
                this.settings.availableLanguages.forEach((current, currentId) =>
                    languagesViewModels.push({
                        name: this.$t('system.language.' + current),
                        value: current,
                        id: currentId,
                        img: '../assets/logo' + current + '.png'
                    })
                );
                return languagesViewModels;
            }
        }
    },
    mounted() {
        this.getSettings();
        this.checkboxProcessing();
    },
    methods: {
        async getUserSettings() {
        },
        switchLanguage() {
            this.$i18n.locale = this.currentLanguage;
        },
        ...mapActions('settings', [
            'getSettings'
        ]),
        checkboxProcessing() {
            let hook = this;
            if (this.settings && this.settings.settingUnits) {
                this.settings.settingUnits.forEach(function (current) {
                    switch (current.value) {
                        case 'true':
                            hook.checkboxesViewModel.push({name: current.name, value: true});
                            break;
                        case 'false':
                            hook.checkboxesViewModel.push({name: current.name, value: false});
                            break;
                    }
                });
            }
        },
        testMethod() {
            setSettings(this.settings);
        }
    }
};
</script>

<style scoped>

</style>
