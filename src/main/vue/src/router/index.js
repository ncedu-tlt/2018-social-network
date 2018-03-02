import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import NavBar from '@/components/NavBar'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/login',
            name: 'Auth',
            component: NavBar
        }
    ]
});
