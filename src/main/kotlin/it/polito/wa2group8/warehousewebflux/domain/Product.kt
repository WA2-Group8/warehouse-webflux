package it.polito.wa2group8.warehousewebflux.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.math.BigInteger

@Table("product")
data class Product(
    @Id
    var id: Long?,
    var name: String,
    var category: String,
    var price: BigDecimal,
    var quantity: Int
)


