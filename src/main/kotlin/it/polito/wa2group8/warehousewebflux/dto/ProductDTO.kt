package it.polito.wa2group8.warehousewebflux.dto

import java.math.BigDecimal
import java.math.BigInteger
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.NotNull

data class ProductDTO (
    val id: Long?,

    @get:NotNull
    val name: String,

    @get:NotNull
    val category: String,

    @get:DecimalMin(value="0.0", inclusive=true)
    val price: BigDecimal,

    val quantity: BigInteger
)