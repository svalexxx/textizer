package co.textizer.textizer.config

import co.textizer.textizer.model.Content
import co.textizer.textizer.repository.ContentRepository
import io.github.serpro69.kfaker.Faker
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializer {

  @Bean
  fun initData(contentRepository: ContentRepository): CommandLineRunner {
    return CommandLineRunner {
      if (contentRepository.count() == 0L) {
        val faker = Faker()

        val sampleContent = (1..1000).map { // Adjust number as needed
          Content(
            title = faker.book.title(),
            mainText = generateParagraphs(faker, 3), // Generate 3 paragraphs
            author = "${faker.name.firstName()} ${faker.name.lastName()}"
          )
        }

        contentRepository.saveAll(sampleContent)
        println("Generated and saved ${sampleContent.size} fake content items.")
      }
    }
  }

  private fun generateParagraphs(faker: Faker, paragraphCount: Int): String {
    return (1..paragraphCount).joinToString("\n\n") { generateSentence(faker, 15) }
  }

  private fun generateSentence(faker: Faker, wordCount: Int): String {
    return (1..wordCount)
      .joinToString(" ") { faker.lorem.words() }
      .replaceFirstChar { it.uppercase() } + "."
  }
}