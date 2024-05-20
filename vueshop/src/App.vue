<template>
  <div id="app">
   <Header></Header>
   <router-view></router-view>
  </div>
</template>

<script>
import Header from './components/HeaderInfo/HeaderInfo.vue'

export default {
  name: 'App',
  components: {
    Header
  }
}
</script>

<style>
</style>