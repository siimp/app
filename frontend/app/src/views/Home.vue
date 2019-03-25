<template>
  <div>
    <Clients />
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import Clients from '@/components/Clients.vue'; // @ is an alias to /src

@Component({
  components: {
    Clients,
  },
})
export default class Home extends Vue {}
</script>
