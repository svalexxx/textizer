<template>
  <div>
    <h1>Content List</h1>
    <div v-if="loading">Loading...</div>
    <ul v-else>
      <li v-for="item in content" :key="item.id">
        <h2>{{ item.title }}</h2>
        <p>{{ item.mainText }}</p>
        <p><strong>Author:</strong> {{ item.author }}</p>
      </li>
    </ul>
    <button v-if="hasNext" @click="loadMore">Load More</button>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      content: [],
      page: 0,
      size: 30,
      hasNext: false,
      loading: false,
      errorMessage: ''
    }
  },
  methods: {
    async fetchContent() {
      this.loading = true
      this.errorMessage = ''
      try {
        const basicAuth = localStorage.getItem('authToken')
        const backendUrl = process.env.VUE_APP_BACKEND_URL || 'https://ac06-46-199-94-53.ngrok-free.app'

        const response = await axios.get(`${backendUrl}/api/content`, {
          params: { page: this.page, size: this.size },
          headers: { Authorization: basicAuth }
        })

        this.content = [...this.content, ...response.data.content]
        this.hasNext = response.data.hasNext
      } catch (error) {
        console.error('Error fetching content:', error)
        this.errorMessage = 'Failed to fetch content. Please try again.'
      } finally {
        this.loading = false
      }
    },
    loadMore() {
      this.page += 1
      this.fetchContent()
    }
  },
  mounted() {
    this.fetchContent()
  }
}
</script>

<style scoped>
.error {
  color: red;
  margin-top: 10px;
}
button {
  margin-top: 20px;
}
</style>