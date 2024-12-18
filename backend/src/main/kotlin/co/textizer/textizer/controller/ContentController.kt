package co.textizer.textizer.controller

import co.textizer.textizer.service.ContentService
import co.textizer.textizer.service.PagedContentResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/content")
class ContentController @Autowired constructor(private val contentService: ContentService) {

  @GetMapping
  fun getPagedContent(
    @RequestParam("page", defaultValue = "1") page: Int,
    @RequestParam("size", defaultValue = "30") size: Int
  ): PagedContentResponse {
    return contentService.getPagedContent(page, size)
  }
}