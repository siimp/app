import Vue from 'vue';
import Vuex from 'vuex';
import { User } from '@/types';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {} as User,
    API_URL: 'http://localhost:8080',
  },
  mutations: {
    setUser: (state, user: User) => {
      state.user = user;
    },
  },
  getters: {
    getUser: (state) => {
      return state.user;
    },
  },
  actions: {
    loadUser: (context) => {
      if (!context.getters.getUser.id) {
        axios
        .get(context.state.API_URL + '/user')
        .then((response) => {
          const newUser: User = response.data;
          context.commit('setUser', newUser);
        })
        .catch((errorResponse) => {
          console.log(errorResponse);
        });
      }
    },
  },
});
