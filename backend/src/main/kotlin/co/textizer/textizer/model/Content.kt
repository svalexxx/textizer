package co.textizer.textizer.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "content")
data class Content(
  @Id val id: String? = null,
  val title: String,
  val mainText: String,
  val author: String
)