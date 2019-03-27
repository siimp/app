<template>
    <select v-show="isDataLoaded" v-model="value" @change='setValue($event.target.value)'>
      <option v-if="!isDataLoaded">loading countries</option>
      <option v-if="isDataLoaded" value="">{{value}}Choose...</option>
      <option
        v-for='(country) in countries'
        v-bind:key='country.id'
        :value='country.id'
      >{{country.name}}</option>
    </select>
</template>

<script lang='ts'>
import { Component, Vue, Prop } from 'vue-property-decorator';
import axios from 'axios';
import { mapActions, mapState } from 'vuex';

@Component({
  computed: {
    ...mapState(['countries']),
  },
  methods: {
    ...mapActions(['loadCountries']),
    setValue(value) {
      this.$emit('input', value);
    },
  },
  data: () => {
    return {
      isDataLoaded: false,
    };
  },
})
export default class CountrySelect extends Vue {
  @Prop() public value?: number;

  public mounted() {
    const promise: Promise<void> = (this as any).loadCountries();
    promise.then(() => {
      (this as any).isDataLoaded = true;
    });
  }
}
</script>