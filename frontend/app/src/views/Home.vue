<template>
  <div>
    <Clients v-if="hasUserInfo"/>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator';
import Clients from '@/components/Clients.vue';
import axios from 'axios';
import { mapState, mapMutations } from 'vuex';
import { User } from '@/types';

@Component({
  components: {
    Clients,
  },
  computed: mapState([
    'API_URL',
  ]),
  methods: mapMutations([
    'setUser',
  ]),
})
export default class Home extends Vue {

  private API_URL?: string;
  private hasUserInfo = false;

  public mounted() {
    axios
      .get(this.API_URL + '/user')
      .then((response) => {
        const newUser: User = response.data;
        (this as any).setUser(newUser);
        this.hasUserInfo = true;
      })
      .catch((errorResponse) => {
        console.log(errorResponse);
      });
  }
}
</script>
