<template>
    <v-container>
        <v-card class="mt-3">
            <v-card-title class="title">
                <v-flex xs10 offset-xs1>
                    {{ $t('settings.show_hide') }}
                </v-flex>
            </v-card-title>
            <v-card-actions>
                <v-list>
                    <v-list-tile v-for="setting in computedSettings" :key="setting.name" v-if="setting.value !== null">
                        <v-list-tile-title>
                            {{ $t(setting.name) }}
                        </v-list-tile-title>
                        <v-list-tile-action class="pl-5">
                            <v-checkbox @change="onCheckboxChange(setting)" v-model="setting.value" color="primary"/>
                        </v-list-tile-action>
                        <v-list-tile-avatar/>
                    </v-list-tile>
                    <v-btn @click="testButton = !testButton" color="error"> DANGER!!! DONT CLICK THIS!</v-btn>
                    <v-container v-if="testButton">
                        <v-flex>{{ computedSettings }}</v-flex>
                        <v-flex>{{ settings.settingUnits }}</v-flex>>
                    </v-container>
                </v-list>
            </v-card-actions>
        </v-card>
        <v-card class="mt-3">
            <v-card-title class="title">
                <v-flex xs10 offset-xs1>
                    {{ $t('settings.switch_language') }}
                </v-flex>
            </v-card-title >
            <v-card-actions>
                <v-layout xs12 sm6 class="text-xs-center">
                    <v-select
                        v-if="settings != null && settings.availableLanguages != null"
                        @input="switchLanguage"
                        :items="createLanguagesObject"
                        item-text="name"
                        item-avatar="img"
                        :label="$t('settings.switch_language')"
                        v-model="currentLanguage"/>
                </v-layout>
            </v-card-actions>
        </v-card>
        <v-card class="mt-3">
            <v-card-title class="title">
                <v-flex xs10 offset-xs1>
                    {{ $t('settings.delete_account') }}
                </v-flex>
            </v-card-title>
            <v-card-actions>
                <v-flex class="text-xs-center">
                    <v-btn color="error" @click="showDeleteMessage = !showDeleteMessage" v-if="!showDeleteMessage">
                        <h3> Delete Profile </h3>
                    </v-btn>
                </v-flex>
                <v-layout v-if="showDeleteMessage">
                    <v-text-field label="Enter DELETE ACCOUNT to confirm"/>
                </v-layout>
                <v-flex v-if="showDeleteMessage">
                    <v-btn color="primary" @click="showDeleteMessage = !showDeleteMessage">
                        Cancel
                    </v-btn>
                    <v-btn color="error">
                        Confirm
                    </v-btn>
                </v-flex>
            </v-card-actions>
        </v-card>
    </v-container>
</template>

<script>
import { mapState } from 'vuex';

export default {
    name: 'Settings',
    data() {
        return {
            showDeleteMessage: false,
            currentLanguage: this.$store.locale,
            messages: [],
            testButton: false
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
                return this.settings.settingUnits.filter(function (setting) {
                    return setting.value === 'true' || setting.value === 'false';
                }).map(function (setting) {
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
        onCheckboxChange(setting) {
            this.$store.commit('settings/changeSetting', setting);
            this.messages.push('Изменена настройка ' + setting.name);
        }
    }
};
</script>

<style scoped>

</style>
