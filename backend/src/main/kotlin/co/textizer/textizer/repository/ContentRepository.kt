package co.textizer.textizer.repository

import co.textizer.textizer.model.Content
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository


interface ContentRepository : MongoRepository<Content, String> {
  override fun findAll(pageable: Pageable): Page<Content>
}