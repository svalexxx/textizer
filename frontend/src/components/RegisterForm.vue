<template>
  <div class="register-form">
    <h2>Register</h2>
    <form @submit.prevent="register">
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="form.username" required />
      </div>
      <div>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="form.email" required />
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="form.password" required />
      </div>
      <button type="submit">Register</button>
    </form>
    <p v-if="error">{{ error }}</p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      form: {
        username: "",
        email: "",
        password: "",
      },
      error: null,
    };
  },
  methods: {
    async register() {
      try {
        this.error = null;
        // Create URL-encoded payload
        const params = new URLSearchParams();
        params.append("username", this.form.username);
        params.append("password", this.form.password);
        params.append("email", this.form.email);

        const response = await axios.post(
            `${process.env.VUE_APP_BACKEND_URL || "http://localhost:8888"}/api/users/create`,
            params,
            {
              headers: {
                "Content-Type": "application/x-www-form-urlencoded",
              },
            }
        );
        // Use the response data (e.g., logging it or showing additional information)
        console.log("Server Response:", response.data);
        alert("Registration successful!");
        this.$router.push("/login");
      } catch (err) {
        this.error = err.response?.data?.message || "Registration failed.";
      }
    },
  },
};
</script>

<style>
.register-form {
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