package it.polito.wa2group8.warehousewebflux.services

import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ProductService {

    suspend fun createProduct(productDTO: ProductDTO): ProductDTO
    suspend fun updateProduct(productDTO: ProductDTO): ProductDTO
    fun retrieveProduct(id: Long): ProductDTO
    fun retrieveAllProducts(): Flux<ProductDTO>
    fun retrieveProductsByCategory(category: String): Flux<ProductDTO>

}