<template>
  <div id="app">
    <div id="nav">
      <a href="/logout">Log out</a>
    </div>
    <router-view/>

    <footer class="my-5 pt-5 text-muted text-center text-small">
      <p class="mb-1">&copy; 2018 Company Name</p>
    </footer>
  </div>
</template>

<style>
#nav {
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
  text-align: right;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}
</style>
