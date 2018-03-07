import Vue from 'vue';
import Vuetify from 'vuetify';
import App from '@/App';
import store from '@/store';
import router from '@/router';
import i18n from '@/i18n';
import colors from 'vuetify/es5/util/colors';
import 'vuetify/dist/vuetify.min.css';

Vue.config.productionTip = false;

Vue.use(Vuetify, {
    theme: {
        primary: colors.deepPurple.base,
        secondary: colors.purple.lighten5,
        accent: colors.pink.accent2,
        error: colors.red.accent2,
        info: colors.lightBlue.base,
        success: colors.green.base,
        warning: colors.amber.base
    }
});

/* eslint-disable no-new */
new Vue({
    el: '#app',
    i18n,
    store,
    router,
    render: h => h(App)
});
