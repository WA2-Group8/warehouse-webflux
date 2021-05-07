package it.polito.wa2group8.warehousewebflux.services

import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import kotlinx.coroutines.flow.Flow
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ProductService {

    suspend fun createProduct(productDTO: ProductDTO): ProductDTO
    suspend fun updateProduct(quantity: Int, productId: Long): ProductDTO
    suspend fun retrieveProduct(id: Long): ProductDTO
    suspend fun retrieveAllProducts(): Flow<ProductDTO>
    suspend fun retrieveProductsByCategory(category: String): Flow<ProductDTO>

}