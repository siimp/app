import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/client',
      name: 'client',
      component: () => import('./views/ClientAdd.vue'),
    },
    {
      path: '/client/:id',
      name: 'clientEdit',
      component: () => import('./views/ClientEdit.vue'),
    },
  ],
});
