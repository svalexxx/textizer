package co.textizer.textizer.controller


import co.textizer.textizer.model.User
import co.textizer.textizer.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController @Autowired constructor(private val userService: UserService) {

  @PostMapping("/create")
  fun createUser(
    @RequestParam username: String,
    @RequestParam password: String,
    @RequestParam email: String
  ): ResponseEntity<User> {
    val user = userService.createUser(username, password, email)
    return ResponseEntity.ok(user)
  }
}