package co.textizer.textizer.service

import co.textizer.textizer.model.User
import co.textizer.textizer.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

  private val passwordEncoder = BCryptPasswordEncoder()

  fun createUser(username: String, password: String, email: String): User {
    val encryptedPassword = passwordEncoder.encode(password)
    val user = User(username = username, password = encryptedPassword, email = email)
    return userRepository.save(user)
  }

  fun findByUsername(username: String): User? {
    return userRepository.findByUsername(username).orElse(null)
  }
}