package com.under.dto

import com.under.domain.Article
import com.under.web.ArticleController
import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import java.math.BigDecimal

class ArticleResource(
        val name: String,
        val price: BigDecimal
) : RepresentationModel<ArticleResource>() {

    constructor(article: Article): this(article.name, article.price) {
        article.relatedArticles.forEach { link(it) }
    }

    private fun link(article: Article) {
        add(linkTo(methodOn(ArticleController::class.java).getArticle(article.uuid.toString())).withRel("relatedArticles"))
    }

    fun toResponse() = ResponseEntity.ok(this)
}