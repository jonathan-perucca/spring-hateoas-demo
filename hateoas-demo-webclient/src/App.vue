<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <articles :articles="articles"/>
  </div>
</template>

<script>
  import Articles from "./components/Articles";
  import ArticleRepository from './repository/ArticleRepository'

  export default {
    name: 'App',
    components: {
      Articles,
    },
    data() {
      return {
        articles: []
      }
    },
    created() {
      ArticleRepository.getAll().then(articles => this.articles = articles)
    }
  }
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
