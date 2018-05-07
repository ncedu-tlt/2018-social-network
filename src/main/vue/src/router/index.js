import Vue from 'vue';
import Router from 'vue-router';
import AuthPage from '@/components/AuthPage';
import ProjectsPage from '@/components/ProjectsPage';
import FeedPage from '@/components/FeedPage';
import ChatPage from '@/components/ChatPage';
import ProfilePage from '@/components/ProfilePage';
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
            path: '/projects',
            name: 'ProjectsPage',
            component: ProjectsPage
        },
        {
            path: '/feed',
            name: 'FeedPage',
            component: FeedPage
        },
        {
            path: '/chat/:id?',
            name: 'ChatPage',
            component: ChatPage,
            props: true
        },
        {
            path: '/user/name',
            name: 'ProfilePage',
            component: ProfilePage
        },
        {
            path: '/',
            redirect: '/feed',
            name: 'Root'
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
