<template>
    <select v-show="isDataLoaded" :value="value" @input="$emit('input', $event.target.value)">
      <option v-if="!isDataLoaded">loading countries</option>
      <option v-if="isDataLoaded" value="">Choose...</option>
      <option
        v-for='(country) in countries'
        v-bind:key='country.id'
        :value='country.id'
      >{{country.name}}</option>
    </select>
</template>

<script lang='ts'>
import { Component, Vue } from 'vue-property-decorator';
import axios from 'axios';
import { mapActions, mapState } from 'vuex';

@Component({
  computed: {
    ...mapState(['countries']),
  },
  methods: {
    ...mapActions(['loadCountries']),
  },
  props: ['value'],
})
export default class CountrySelect extends Vue {

  public mounted() {
    const promise: Promise<void> = (this as any).loadCountries();
    promise.then(() => {
      (this as any).isDataLoaded = true;
    });
  }

  public data() {
    return {
      isDataLoaded: false,
    };
  }
}
</script>