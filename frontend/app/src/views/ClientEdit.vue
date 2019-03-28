<template>
  <div v-if="user.id && form.version >= 0" class="container">
      <div class="py-5 text-center">
        <h2>Edit Client</h2>
      </div>

      <div class="row">
        <div class="col-md-12 order-md-1">
          <form class="needs-validation" @submit.prevent="saveClient" novalidate>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" v-bind:class="{ 'is-invalid' : !!errors.firstName }" 
                  id="firstName" v-model="form.firstName" placeholder="" value="">
                <div v-if="!!errors.firstName" class="invalid-feedback">
                  {{errors.firstName.defaultMessage}}
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" v-bind:class="{ 'is-invalid' : !!errors.lastName }" 
                  id="lastName" v-model="form.lastName" placeholder="" value="">
                <div v-if="!!errors.lastName" class="invalid-feedback">
                  {{errors.lastName.defaultMessage}}
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="username">Username</label>
              <div class="input-group">
                <input type="text" class="form-control" v-bind:class="{ 'is-invalid' : !!errors.username }"
                  id="username" v-model="form.username" placeholder="Username">
                <div v-if="!!errors.username" class="invalid-feedback">
                  {{errors.username.defaultMessage}}
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="email">Email <span class="text-muted">(Optional)</span></label>
              <input type="email" class="form-control" v-bind:class="{ 'is-invalid' : !!errors.email }" 
                id="email" v-model="form.email" placeholder="you@example.com">
              <div v-if="!!errors.email" class="invalid-feedback">
                  {{errors.email.defaultMessage}}
              </div>
            </div>

            <div class="mb-3">
              <label for="address">Address</label>
              <input type="text" class="form-control" v-bind:class="{ 'is-invalid' : !!errors.address }"
                id="address" v-model="form.address" placeholder="1234 Main St">
              <div v-if="!!errors.address" class="invalid-feedback">
                {{errors.address.defaultMessage}}
              </div>
            </div>

            <div class="mb-3">
              <label for="country">Country</label>
                <CountrySelect class="custom-select d-block w-100" v-bind:class="{ 'is-invalid' : !!errors.country }" 
                  id="country" v-model="form.country" />
                <div v-if="!!errors.country" class="invalid-feedback">
                  {{errors.country.defaultMessage}}
                </div>
            </div>
            <hr class="mb-4">
			        <button class="btn btn-primary btn-lg btn-block" type="submit">Save Client</button>
          </form>
        </div>
      </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator';
import axios from 'axios';
import { Client, ClientEditForm, User } from '@/types';
import { mapState, mapGetters, mapActions } from 'vuex';
import CountrySelect from '@/components/CountrySelect.vue';

@Component({
  components: {
    CountrySelect,
  },
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
export default class ClientAdd extends Vue {

    private form: ClientEditForm = {} as ClientEditForm;
    private errors?: any;
    private API_URL?: string;

    public mounted() {
      const promise: Promise<User> = (this as any).loadUser();
      promise.then((user: User) => {
        axios
          .get(this.API_URL + '/user/' + user.id + '/client/' + this.$route.params.id)
          .then((response) => {
            const client: ClientEditForm = response.data;
            this.form = client;
          })
          .catch((errorResponse) => {
            console.log(errorResponse);
          });
      });
    }

    public saveClient() {
      const user: User = (this as any).user;

      axios.post(this.API_URL + '/user/' + user.id + '/client/' + this.$route.params.id, this.form)
      .then((response) => {
        this.$router.push('/');
      })
      .catch((errorResponse) => {
        const newErrors = {} as any;
        if (errorResponse.response.data && Array.isArray(errorResponse.response.data.errors)) {
          errorResponse.response.data.errors.forEach((error: any) => {
            newErrors[error.field] = {
              defaultMessage: error.defaultMessage,
            };
          });
          this.errors = newErrors;
        }
      });
    }

    public data() {
      return {
        form: {} as ClientEditForm,
        errors: {},
      };
    }
}
</script>
