import Vue from 'vue';
import Vuex from 'vuex';
import { User } from '@/types';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {} as User,
    API_URL: 'http://localhost:8080',
  },
  mutations: {
    setUser: (state, user: User) => {
      state.user.id = user.id;
      state.user.username = user.username;
    },
  },
  getters: {
    getUser: (state) => {
      return state.user;
    },
  },
  actions: {

  },
});
