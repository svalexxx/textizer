package co.textizer.textizer.config

import co.textizer.textizer.service.CustomUserDetailsService
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean

@Configuration
class AuthenticationConfig(
  private val customUserDetailsService: CustomUserDetailsService,
  private val passwordEncoder: PasswordEncoder
) {

  @Autowired
  fun configureAuthentication(auth: AuthenticationManagerBuilder) {
    auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder)
  }

  @Bean
  fun authenticationManager(authConfig: AuthenticationConfiguration): AuthenticationManager {
    return authConfig.authenticationManager
  }
}