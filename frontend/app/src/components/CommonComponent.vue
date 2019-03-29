<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { mapActions, mapState } from 'vuex';

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
export default class CommonComponent extends Vue {
    public mounted() {
      (this as any).loadUser();
    }
}
</script>
