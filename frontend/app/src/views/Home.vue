<template>
  <div>
    <Clients v-if="getUser.id"/>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator';
import Clients from '@/components/Clients.vue';
import axios from 'axios';
import { mapState, mapMutations, mapGetters, mapActions } from 'vuex';
import { User } from '@/types';

@Component({
  components: {
    Clients,
  },
  computed: {
    ...mapGetters([
        'getUser',
    ]),
  },
  methods: {
    ...mapActions([
      'loadUser',
    ]),
  },
})
export default class Home extends Vue {
  public mounted() {
    (this as any).loadUser();
  }
}
</script>
