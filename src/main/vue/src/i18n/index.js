import Vue from 'vue';
import VueI18n from 'vue-i18n';
import en from '@/i18n/locales/en';
import ru from '@/i18n/locales/ru';
import enDateFormat from '@/i18n/dateformats/date-format.en';
import ruDateFormat from '@/i18n/dateformats/date-format.ru';

Vue.use(VueI18n);

export default new VueI18n({
    locale: localStorage.getItem('language') ? localStorage.getItem('language') : 'en',
    messages: {
        en,
        ru
    },
    dateTimeFormats: {
        en: enDateFormat,
        ru: ruDateFormat
    }
});
