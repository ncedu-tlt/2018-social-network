import Vue from 'vue';
import Vuetify from 'vuetify';
import App from '@/App';
import store from '@/store';
import router from '@/router';
import i18n from '@/i18n';

import 'vuetify/dist/vuetify.min.css';

Vue.config.productionTip = false;

Vue.use(Vuetify);

/* eslint-disable no-new */
new Vue({
    el: '#app',
    i18n,
    store,
    router,
    render: h => h(App)
});
