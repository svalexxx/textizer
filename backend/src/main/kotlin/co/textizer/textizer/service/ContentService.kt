package co.textizer.textizer.service


import co.textizer.textizer.model.Content
import co.textizer.textizer.repository.ContentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

data class PagedContentResponse(
  val content: List<Content>,
  val totalElements: Long,
  val hasNext: Boolean
)

@Service
class ContentService @Autowired constructor(private val repository: ContentRepository) {

  fun getPagedContent(page: Int, size: Int): PagedContentResponse {
    val pageable = PageRequest.of(page, size)
    val contentPage = repository.findAll(pageable)

    return PagedContentResponse(
      content = contentPage.content,
      totalElements = contentPage.totalElements,
      hasNext = contentPage.hasNext()
    )
  }
}