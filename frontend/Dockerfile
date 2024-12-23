# Use a Node.js image for Vue.js frontend
FROM node:18

# Set the working directory
WORKDIR /app

# Copy package.json and install dependencies
COPY package*.json ./
RUN npm install

# Copy the rest of the application
COPY . .

# Set environment variables during build time
ARG VUE_APP_BACKEND_URL
ENV VUE_APP_BACKEND_URL=${VUE_APP_BACKEND_URL}

# Build the Vue.js application
RUN npm run build

# Expose the port and serve the app
EXPOSE 8080
CMD ["npm", "run", "serve"]