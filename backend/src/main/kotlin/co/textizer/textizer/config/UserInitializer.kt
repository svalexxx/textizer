package co.textizer.textizer.config

import co.textizer.textizer.model.User
import co.textizer.textizer.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
class UserInitializer(
  private val userRepository: UserRepository,
  private val passwordEncoder: PasswordEncoder
) {

  @Bean
  fun initUser(): CommandLineRunner {
    return CommandLineRunner {
      val username = "admin"
      val password = "password"
      val email = "admin@example.com"

      // Check if the user already exists
      if (userRepository.findByUsername(username).isEmpty) {
        val encodedPassword = passwordEncoder.encode(password)
        val user = User(username = username, password = encodedPassword, email = email)
        userRepository.save(user)
        println("Default user created: $username")
      } else {
        println("Default user already exists: $username")
      }
    }
  }
}