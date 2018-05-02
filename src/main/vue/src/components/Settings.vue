<template>
    <v-container>
        <v-card class="mt-4">
            <v-card-title class="title">
                <v-flex>
                    {{ $t('settings.show_hide') }}
                </v-flex>
            </v-card-title>
            <v-divider/>
            <v-card-actions>
                <v-flex xs12>
                    <v-list>
                        <v-list-tile v-for="setting in computedSettings" :key="setting.name" v-if="setting.value !== null">
                            <v-list-tile-title>
                                {{ $t(setting.name) }}
                            </v-list-tile-title>
                            <v-list-tile-action class="pl-2">
                                <v-checkbox @change="onCheckboxChange(setting)" v-model="setting.value" color="primary"/>
                            </v-list-tile-action>
                        </v-list-tile>
                    </v-list>
                </v-flex>
            </v-card-actions>
        </v-card>
        <v-card class="mt-4">
            <v-card-title class="title">
                <v-flex>
                    {{ $t('settings.switch_language') }}
                </v-flex>
            </v-card-title >
            <v-divider/>
            <v-card-actions>
                <v-flex xs6>
                    <v-select
                        v-if="settings != null && settings.availableLanguages != null"
                        :items="createLanguagesObject"
                        item-text="name"
                        item-value="value"
                        v-model="computedLanguage">
                        <v-list-tile-avatar>
                            <img :src="createLanguagesObject.img">
                        </v-list-tile-avatar>
                    </v-select>
                </v-flex>
            </v-card-actions>
        </v-card>
        <v-card class="mt-4">
            <v-card-title class="title">
                <v-flex>
                    {{ $t('settings.delete_account') }}
                </v-flex>
            </v-card-title>
            <v-divider/>
            <v-card-actions>
                <v-container>
                    <v-flex class="text-xs-center">
                        <v-btn color="error" @click="showDeleteMessage = !showDeleteMessage" v-if="!showDeleteMessage">
                            <h3>{{ $t('settings.delete_account') }}</h3>
                        </v-btn>
                    </v-flex>
                    <v-flex v-if="showDeleteMessage" xs12 sm6>
                        <v-text-field :label="$t('settings.confirm_delete_account')"/>
                        <v-btn color="primary" @click="showDeleteMessage = !showDeleteMessage">
                            {{ $t('cancel') }}
                        </v-btn>
                        <v-btn color="error">
                            {{ $t('confirm') }}
                        </v-btn>
                    </v-flex>
                </v-container>
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
            showDeleteMessage: false
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
                        img: '../assets/logo_' + current + '.png'
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
        },
        computedLanguage: {
            get() {
                let language = this.settings.settingUnits.filter(language => language.name === 'settings.language');
                return language[0].value;
            },
            set(language) {
                this.$i18n.locale = language;
                this.$store.commit('settings/setLanguage', language);
            }
        }
    },
    mounted() {
        this.$store.dispatch('settings/getSettings');
    },
    methods: {
        onCheckboxChange(setting) {
            this.$store.commit('settings/changeSetting', setting);
        }
    }
};
</script>

<style scoped>

</style>
