import Vue from 'vue';
import Router from 'vue-router';
import HelloWorld from '@/components/HelloWorld';
import AuthPage from '@/components/AuthPage';
import Dispatcher from '@/components/Dispatcher';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/helloworld',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/welcome',
            name: 'AuthPage',
            component: AuthPage
        },
        {
            path: '/',
            name: 'Dispatcher',
            component: Dispatcher
        }
    ]
});
