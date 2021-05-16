package it.polito.wa2group8.warehousewebflux.domain

import org.springframework.data.annotation.Id
import java.math.BigDecimal

data class Product(
    @Id
    val id: Long? = null,
    var name: String,
    var category: String,
    var price: BigDecimal,
    var quantity: Int
)
