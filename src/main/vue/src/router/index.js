import Vue from 'vue';
import Router from 'vue-router';
import HelloWorld from '@/components/HelloWorld';

Vue.use(Router);

export default new Router({
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

router.beforeEach((to, from, next) => {
    if (store.state.auth.authed || to.name === 'AuthPage') {
        next();
    } else {
        next('/auth');
    }
});

export default router;
