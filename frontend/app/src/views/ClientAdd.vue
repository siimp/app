<template>
  <div v-if="user.id" class="container">
      <div class="py-5 text-center">
        <h2>Add Client</h2>
      </div>

      <div class="row">
        <div class="col-md-12 order-md-1">
          <form class="needs-validation" @submit.prevent="addClient" novalidate>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" v-model="form.firstName" placeholder="" value="">
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" v-model="form.lastName" placeholder="" value="">
              </div>
            </div>

            <div class="mb-3">
              <label for="username">Username</label>
              <div class="input-group">
                <input type="text" class="form-control" id="username" v-model="form.username" placeholder="Username">
              </div>
            </div>

            <div class="mb-3">
              <label for="email">Email <span class="text-muted">(Optional)</span></label>
              <input type="email" class="form-control" id="email" v-model="form.email" placeholder="you@example.com">

            </div>

            <div class="mb-3">
              <label for="address">Address</label>
              <input type="text" class="form-control" id="address" v-model="form.address" placeholder="1234 Main St">
            </div>

            <div class="mb-3">
              <label for="country">Country</label>
                <select class="custom-select d-block w-100" id="country" v-model="form.country">
                  <option value="">Choose...</option>
                  <option>Estonia</option>
                  <option>Latvia</option>
                  <option>Lithuania</option>
                  <option>Finland</option>
                  <option>Sweden</option>
                </select>
            </div>
            <hr class="mb-4">
			
			        <button class="btn btn-primary btn-lg btn-block" type="submit">Add Client</button>
          </form>
        </div>
      </div>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';
import axios from 'axios';
import { Client, ClientAddForm, User } from '@/types';
import { mapState, mapGetters, mapActions } from 'vuex';

@Component({
  computed: {
    ...mapState([
        'API_URL',
        'user',
    ]),
  },
  methods: {
    ...mapActions([
      'loadUser',
    ]),
  },
})
export default class ClientView extends Vue {

    private form?: ClientAddForm;

    private API_URL?: string;

    public mounted() {
      (this as any).loadUser();
    }

    public addClient() {
      const user: User = (this as any).user;

      axios.post(this.API_URL + '/user/' + user.id + '/client', this.form)
      .then((response) => {
        this.$router.push('/');
      })
      .catch((errorResponse) => {
        if (errorResponse.response.data && Array.isArray(errorResponse.response.data.errors)) {
          errorResponse.response.data.errors.forEach((error: any) => {
            console.log(error.field, error.defaultMessage);
          });
        }
      });
    }

    public data() {
      return {
        form: {
          firstName: '',
          lastName: '',
          username: '',
          email: '',
          address: '',
          country: 0,
        } as ClientAddForm,
      };
    }
}
</script>
