package com.under.domain

import java.math.BigDecimal
import java.util.*
import kotlin.collections.ArrayList

data class Article(
        val uuid: UUID = UUID.randomUUID(),
        val name: String,
        val price: BigDecimal,
        var relatedArticles: ArrayList<Article> = arrayListOf()
)