import Vue from 'vue';
import Router from 'vue-router';
import AuthPage from '@/components/AuthPage';
import ProjectsPage from '@/components/ProjectsPage';
import store from '@/store';
import Settings from '@/components/Settings';

Vue.use(Router);

const router = new Router({
    routes: [
        {
            path: '/auth',
            name: 'AuthPage',
            component: AuthPage,
            beforeEnter: async (to, from, next) => {
                await store.dispatch('auth/checkAuth');
                if (store.state.auth.userName) {
                    next('/feed');
                } else {
                    next();
                }
            }
        },
        {
            path: '/projects',
            name: 'ProjectsPage',
            component: ProjectsPage
        },
        {
            path: '/',
            redirect: '/feed',
            name: 'Root'
        },
        {
            path: '/settings',
            name: 'Settings',
            component: Settings
        }
    ]
});

router.beforeEach((to, from, next) => {
    if (store.state.auth.userName || to.name === 'AuthPage') {
        next();
    } else {
        next('/auth');
    }
});

export default router;
