package co.textizer.textizer.service

import org.slf4j.LoggerFactory
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class HealthService(
    private val mongoTemplate: MongoTemplate
) {
    private val logger = LoggerFactory.getLogger(HealthService::class.java)

    fun checkMongoDBConnection(): Boolean {
        return try {
            mongoTemplate.executeCommand("{ ping: 1 }")
            true
        } catch (e: Exception) {
            logger.error("MongoDB health check failed", e)
            false
        }
    }

    fun getSystemHealth(): Map<String, Any> {
        val mongoStatus = checkMongoDBConnection()
        
        return mapOf(
            "status" to if (mongoStatus) "UP" else "DOWN",
            "timestamp" to System.currentTimeMillis(),
            "components" to mapOf(
                "mongodb" to mapOf(
                    "status" to if (mongoStatus) "UP" else "DOWN"
                ),
                "system" to mapOf(
                    "status" to "UP",
                    "memory" to Runtime.getRuntime().let {
                        mapOf(
                            "free" to it.freeMemory(),
                            "total" to it.totalMemory(),
                            "max" to it.maxMemory()
                        )
                    }
                )
            )
        )
    }
} 