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
                {{ $t('settings.switch_language') }}
            </v-card-title>
            <v-divider/>
            <v-card-actions>
                <v-flex class="ml-3" xs5>
                    <v-select
                        v-if="settings != null && settings.availableLanguages != null"
                        :items="createLanguagesObject"
                        item-text="name"
                        item-value="value"
                        color="primary"
                        v-model="computedLanguage"
                        auto/>
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
            <v-card-actions class="pb-4 pt-4">
                <v-flex class="text-xs-center">
                    <v-btn color="error" @click="showDeleteMessage = !showDeleteMessage" v-if="!showDeleteMessage">
                        <h3>{{ $t('settings.delete_account') }}</h3>
                    </v-btn>
                </v-flex>
                <v-flex v-if="showDeleteMessage" xs10>
                    <v-text-field
                        :label="$t('settings.confirm_delete_account')"
                        v-model="confirmDeleteAccount"
                        :rules="[rules.confirm(confirmDeleteAccount)]"
                        color="primary"
                    />
                </v-flex>
                <v-flex v-if="showDeleteMessage" xs6>
                    <v-btn color="primary" @click="showDeleteMessage = !showDeleteMessage">
                        {{ $t('cancel') }}
                    </v-btn>
                    <v-btn color="error" v-if="confirmDeleteAccount === 'DELETE ACCOUNT'" @click="deleteAccount">
                        {{ $t('confirm') }}
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
            confirmDeleteAccount: '',
            rules: {
                confirm: (value) => {
                    return !value.includes('DELETE ACCOUNT') || this.$t('immersible_action');
                }
            },
            userName: this.$store.state.auth.userName
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
                        id: currentId
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
                        name: setting.settingsId.name,
                        value: setting.value === 'true'
                    };
                }).sort(function (first, second) {
                    if (first.name < second.name) return -1;
                    if (first.name > second.name) return 1;
                    return 0;
                });
            }
        },
        computedLanguage: {
            get() {
                let language = this.settings.settingUnits.filter(language => language.settingsId.name === 'settings.language');
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
        },
        deleteAccount() {
            this.$store.dispatch('settings/deleteUser', this.userName).then(() => {
                this.$store.dispatch('auth/logout');
                this.$store.commit('auth/setRemove');
                this.$router.push('/auth');
            });
        }
    }
};
</script>

<style scoped>

</style>
