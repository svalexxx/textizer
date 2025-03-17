package co.textizer.textizer.controller

import co.textizer.textizer.service.HealthService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController(
    private val healthService: HealthService
) {
    private val logger = LoggerFactory.getLogger(HealthController::class.java)

    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<Map<String, Any>> {
        logger.info("Health check endpoint called")
        return ResponseEntity.ok(healthService.getSystemHealth())
    }
} 