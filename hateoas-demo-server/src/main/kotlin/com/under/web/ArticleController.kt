package com.under.web

import com.under.domain.Article
import com.under.dto.ArticleResource
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/articles")
class ArticleController {

    private var articles: ArrayList<Article> = arrayListOf()

    init {
        val apple = Article(name = "Apple", price = 2.5.toBigDecimal())
        val orange = Article(name = "Orange", price = 1.5.toBigDecimal())
        val usbKey = Article(name = "UsbKey", price = 25.toBigDecimal())

        apple.relatedArticles.add(orange)
        orange.relatedArticles.add(apple)

        articles.addAll(listOf(apple, orange, usbKey))
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ArticleResource>> {
        val resources = articles.map { article -> ArticleResource(article) }

        return ok(resources)
    }

    @GetMapping("/{articleId}")
    fun getArticle(@PathVariable("articleId") id: String): ResponseEntity<ArticleResource> {
        return articles
                .filter { id == it.uuid.toString() }
                .firstOrNull()
                ?.let { ArticleResource(it) }
                ?.toResponse()
                ?: notFound().build()
    }
}