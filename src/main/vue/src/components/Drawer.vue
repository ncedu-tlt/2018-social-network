<template>
    <v-navigation-drawer
        fixed
        :clipped="$vuetify.breakpoint.mdAndUp"
        app
        :mini-variant.sync="sw"
        v-model="drawer"
    >
        <v-toolbar flat class="transparent">
            <v-list class="pa-0">
                <v-list-tile avatar>
                    <v-list-tile-avatar>
                        <img src="https://randomuser.me/api/portraits/men/85.jpg">
                    </v-list-tile-avatar>
                    <v-list-tile-content>
                        <v-list-tile-title>John Leider</v-list-tile-title>
                    </v-list-tile-content>
                    <v-list-tile-action/>
                </v-list-tile>
            </v-list>
        </v-toolbar>
        <v-list class="pt-0" dense>
            <v-divider/>
            <v-list-tile v-for="item in items" :key="item.title" @click="item">
                <v-list-tile-action>
                    <v-icon>{{ item.icon }}</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
export default {
    name: 'Drawer',
    props: {
        sw: {
            type: Boolean,
            required: true
        }
    },
    data() {
        return {
            drawer: true,
            items: [
                { title: 'Профиль', icon: 'dashboard' },
                { title: 'Проекты', icon: 'work' },
                { title: 'Сообщения', icon: 'message' },
                { title: 'История', icon: 'history' },
                { title: 'Настройки', icon: 'settings' },
                { title: 'Список контактов', icon: 'contacts' }
            ],
            right: null
        };
    }
};
</script>
