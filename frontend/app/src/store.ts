import Vue from 'vue';
import Vuex from 'vuex';
import { User, Country } from '@/types';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {} as User,
    countries: [] as Country[],
    API_URL: '',
  },
  mutations: {
    setUser: (state, user: User) => {
      state.user = user;
    },
    setCountries: (state, countries: Country[]) => {
      state.countries = countries;
    },
  },
  getters: {
    getUser: (state) => {
      return state.user;
    },
    getCountries: (state) => {
      return state.countries;
    },
  },
  actions: {
    loadUser: (context) => {
      return new Promise<User>((resolve, reject) => {
        if (!context.getters.getUser.id) {
          axios
          .get(context.state.API_URL + '/user')
          .then((response) => {
            const newUser: User = response.data;
            context.commit('setUser', newUser);
            resolve(newUser);
          })
          .catch((errorResponse) => {
            console.log(errorResponse);
            reject();
          });
        } else {
          resolve(context.getters.getUser);
        }
      });
    },
    loadCountries: (context) => {
      return new Promise((resolve, reject) => {
        if (!Array.isArray(context.getters.getCountries) || context.getters.getCountries.length === 0) {
          axios
          .get(context.state.API_URL + '/country')
          .then((response) => {
            const countries: any[] = response.data;
            context.commit('setCountries', countries);
            resolve();
          })
          .catch((errorResponse) => {
            console.log(errorResponse);
            reject();
          });
        } else {
          resolve();
        }
      });
    },
  },
});
