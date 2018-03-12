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

router.beforeEach(async (to, from, next) => {
    await store.dispatch('auth/checkAuth');
    if (store.state.auth.isAuthed || to.name === 'AuthPage') {
        next();
    } else {
        next('/auth');
    }
});

export default router;
