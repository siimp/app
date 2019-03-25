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
            <tr>
            <th scope="row">1</th>
            <td>John</td>
            <td>Smith</td>
            <td>User1</td>
            <td>
                <a href="client.html" class="btn btn-primary">Edit client</a>
            </td>
            </tr>
            <tr>
            <th scope="row">2</th>
            <td>Bob</td>
            <td>Smith</td>
            <td>User2</td>
            <td>
                <a href="client.html" class="btn btn-primary">Edit client</a>
            </td>
            </tr>
            <tr>
            <th scope="row">3</th>
            <td>Billy</td>
            <td>Smith</td>
            <td>User3</td>
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

@Component
export default class HelloWorld extends Vue {
  @Prop() private msg!: string;
}
</script>