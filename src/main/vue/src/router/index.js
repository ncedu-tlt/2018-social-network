import Vue from 'vue';
import Router from 'vue-router';
import AuthPage from '@/components/AuthPage';
import Feed from '@/components/Feed';
import store from '@/store';

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/auth',
            name: 'AuthPage',
            component: AuthPage,
            beforeEnter: async (to, from, next) => {
                await store.dispatch('auth/checkAuth');
                if (store.state.auth.authed) {
                    next('/feed');
                } else {
                    next();
                }
            }
        },
        {
            path: '/',
            redirect: '/feed',
            name: 'Root'
        },
        {
            path: '/feed',
            name: Feed,
            component: Feed
        }
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
