package co.textizer.textizer.config


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebConfig {

  @Bean
  fun corsConfigurer(): WebMvcConfigurer {
    return object : WebMvcConfigurer {
      override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
          .allowedHeaders("*") // Allow all headers
          .allowCredentials(true) // Allow credentials (for Basic Auth)
          .allowedOriginPatterns("*")
      }
    }
  }
}