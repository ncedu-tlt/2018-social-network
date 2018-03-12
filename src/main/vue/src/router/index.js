import Vue from 'vue';
import Router from 'vue-router';
import HelloWorld from '@/components/HelloWorld';
import ProfileInfoArea from '@/components/ProfileInfo';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },

        {
            path: '/user/id',
            name: 'ProfileInfoArea',
            component: ProfileInfoArea
        }
    ]
});
