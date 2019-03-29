<template>
    <div class="container">
    <div class="py-5 text-center">
        <h2>Clients</h2>
    </div>
    <div class="row">
        <router-link to="/client" class="btn btn-primary">Add client</router-link>
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
                    <router-link :to="'/client/' + client.id" class="btn btn-primary">Edit client</router-link>
                </td>
            </tr>
        </tbody>
        </table>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import axios from 'axios';
import { Client, User } from '@/types';
import CommonComponent from '@/components/CommonComponent.vue';

@Component
export default class Clients extends CommonComponent {
    private clients: Client[] = [];

    private API_URL?: string;

    public mounted() {
        const promise: Promise<User> = (this as any).loadUser();
        promise.then((user: User) => {
            axios
            .get(this.API_URL + '/user/' + user.id + '/client')
            .then((response) => {
                response.data.forEach((client: Client) => {
                    this.clients.push(client);
                });
            })
            .catch((errorResponse) => {
                console.log(errorResponse);
            });
        });
    }
}
</script>