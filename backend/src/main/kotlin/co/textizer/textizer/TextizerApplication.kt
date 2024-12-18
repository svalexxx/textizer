package co.textizer.textizer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TextizerApplication

fun main(args: Array<String>) {
  runApplication<TextizerApplication>(*args)
}
