package co.textizer.textizer.service

import co.textizer.textizer.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService @Autowired constructor(private val userService: UserService) : UserDetailsService {
  override fun loadUserByUsername(username: String): UserDetails {
    val user = userService.findByUsername(username)
      ?: throw UsernameNotFoundException("User not found with username: $username")

    return org.springframework.security.core.userdetails.User(
      user.username,
      user.password,
      emptyList()  // Configure roles or authorities as needed
    )
  }
}