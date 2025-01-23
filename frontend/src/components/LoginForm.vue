<template>
  <div class="login-form">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div>
        <label for="username">Username:</label>
        <input v-model="username" id="username" type="text" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input v-model="password" id="password" type="password" required />
      </div>
      <button type="submit">Login</button>
    </form>
    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      username: '',
      password: '',
      errorMessage: ''
    }
  },
  methods: {
    async login() {
      try {
        const basicAuth = 'Basic ' + btoa(`${this.username}:${this.password}`)
        localStorage.setItem('authToken', basicAuth) // Store token for future requests

        // Optionally, test the login by fetching protected content
        await axios.get(`${process.env.VUE_APP_BACKEND_URL || 'https://textizer.duckdns.org'}/api/content`, {
          headers: { Authorization: basicAuth }
        })

        this.$router.push('/content') // Redirect to content page after successful login
      } catch (error) {
        console.error('Login failed:', error)
        this.errorMessage = 'Invalid username or password.'
      }
    }
  }
}
</script>

<style scoped>
.login-form {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
.error {
  color: red;
  margin-top: 10px;
}
button {
  margin-top: 20px;
}
</style>