<template>
    <div class="container">
    <div class="py-5 text-center">
        <h2>Clients</h2>
    </div>
    <div class="row">
        <a href="client.html" class="btn btn-primary">Add client</a>
        <table class="table">
        <thead>
            <tr>
            <th scope="col">#</th>
            <th scope="col">First</th>
            <th scope="col">Last</th>
            <th scope="col">Username</th>
            <th></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(client, index) in clients" v-bind:key="client.id">
                <th scope="row">{{index + 1}}</th>
                <td>{{client.firstName}}</td>
                <td>{{client.lastName}}</td>
                <td>{{client.username}}</td>
                <td>
                    <a href="client.html" class="btn btn-primary">Edit client</a>
                </td>
            </tr>
        </tbody>
        </table>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Prop, Vue } from 'vue-property-decorator';
import axios from 'axios';
import { Client, User } from '@/types';
import { mapState, mapGetters } from 'vuex';

@Component({
  computed: {
    ...mapState([
        'API_URL',
    ]),
    ...mapGetters([
        'getUser',
    ]),
  },
})
export default class Clients extends Vue {
    private clients: Client[] = [];

    private API_URL?: string;

    public mounted() {
        const user: User = (this as any).getUser;
        axios
            .get(this.API_URL + '/user/' + user.id + '/client')
            .then((response) => {
                console.log(response.data);
                response.data.forEach((client: Client) => {
                    this.clients.push(client);
                });
            })
            .catch((errorResponse) => {
                console.log(errorResponse);
            });
    }
}
</script>