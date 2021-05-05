package it.polito.wa2group8.warehousewebflux.services

import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ProductService {

    fun createProduct(product: ProductDTO): Mono<ProductDTO>
    fun updateProduct(product: ProductDTO): Mono<ProductDTO>
    fun retrieveProduct(id: Long): Mono<ProductDTO>
    fun retrieveAllProducts(): Flux<ProductDTO>
    fun retrieveProductsByCategory(category: String): Flux<ProductDTO>

}