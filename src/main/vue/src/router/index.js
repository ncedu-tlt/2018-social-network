import Vue from 'vue';
import Router from 'vue-router';
import AuthPage from '@/components/AuthPage';
import store from '@/store';

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/auth',
            name: 'AuthPage',
            component: AuthPage
        },
        { path: '/', redirect: '/feed' }
    ]
});

router.beforeEach((to, from, next) => {
    if (store.state.auth.authed || to.name === 'AuthPage') {
        next();
    } else {
        next('/auth');
    }
});

export default router;
