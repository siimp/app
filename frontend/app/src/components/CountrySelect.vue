<template>
  <select @change='setValue($event.target.value)'>
    <option value="">Choose...</option>
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
    ...mapState(['countries'])
  },
  methods: {
    ...mapActions(['loadCountries']),
    setValue(value) {
      this.$emit('input', value);
    }
  }
})
export default class CountrySelect extends Vue {
  public mounted() {
    (this as any).loadCountries();
  }
}
</script>