import Vue from 'vue';
import Router from 'vue-router';
import store from '@/store';
import AuthPage from '@/components/AuthPage';
import ProjectsPage from '@/components/ProjectsPage';
import Settings from '@/components/Settings';
import FeedPage from '@/components/FeedPage';
import ChatPage from '@/components/ChatPage';
import ProfilePage from '@/components/ProfilePage';

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
        },
        {
            path: '/chat/:id?',
            name: 'ChatPage',
            component: ChatPage,
            props: true
        },
        {
            path: '/feed',
            name: 'FeedPage',
            component: FeedPage
        },
        {
            path: '/user/name',
            name: 'ProfilePage',
            component: ProfilePage
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
