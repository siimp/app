<template>
  <div>
    <Clients v-if="user.id"/>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Clients from '@/components/Clients.vue';
import CommonComponent from '@/components/CommonComponent.vue';
import axios from 'axios';

@Component({
  components: {
    Clients,
  },
})
export default class Home extends CommonComponent {

}
</script>
