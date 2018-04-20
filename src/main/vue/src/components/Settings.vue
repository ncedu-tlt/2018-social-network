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
                    <v-list-tile v-for="setting in computedSettings" :key="setting.name">
                        <v-list-tile-title>
                            {{ $t(setting.name) }}
                        </v-list-tile-title>
                        <v-list-tile-action class="ml-5">
                            <v-checkbox @change="onCheckboxChange(setting)" v-model="setting.value" color="primary"/>
                        </v-list-tile-action>
                        <v-list-tile-avatar/>
                    </v-list-tile>
                    <div>{{ computedSettings }}</div>
                    <div>{{ messages }}</div>
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
                    <v-btn color="error" v-if="showDeleteMessage">
                        Confirm
                    </v-btn>
                </v-card-actions>
            </v-flex>
            <v-btn @click="testMethod"/>
        </v-card>
    </v-container>
</template>

<script>
import { mapState } from 'vuex';
import { setSettings } from '../api/rest/settings.api';

export default {
    name: 'Settings',
    data() {
        return {
            showDeleteMessage: false,
            currentLanguage: this.$store.locale,
            messages: []
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
        },
        computedSettings() {
            if (this.settings && this.settings.availableLanguages) {
                return this.settings.settingUnits.map(function (setting) {
                    return {
                        name: setting.name,
                        value: setting.value === 'true'
                    };
                });
            }
        }
    },
    mounted() {
        this.$store.dispatch('settings/getSettings');
    },
    methods: {
        async getUserSettings() {
        },
        switchLanguage() {
            this.$i18n.locale = this.currentLanguage;
        },
        testMethod() {
            setSettings(this.settings);
        },
        onCheckboxChange(setting) {
            this.$store.commit('settings/changeSetting', setting);
            this.messages.push('Изменена настройка ' + setting.name);
        }
    }
};
</script>

<style scoped>

</style>
