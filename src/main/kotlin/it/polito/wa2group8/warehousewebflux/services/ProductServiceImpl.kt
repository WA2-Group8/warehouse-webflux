package it.polito.wa2group8.warehousewebflux.services

import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@Transactional
class ProductServiceImpl: ProductService {
    override fun createProduct(product: ProductDTO): Mono<ProductDTO> {
        TODO("Not yet implemented")
    }

    override fun updateProduct(product: ProductDTO): Mono<ProductDTO> {
        TODO("Not yet implemented")
    }

    override fun retrieveProduct(id: Long): Mono<ProductDTO> {
        TODO("Not yet implemented")
    }

    override fun retrieveAllProducts(): Flux<ProductDTO> {
        TODO("Not yet implemented")
    }

    override fun retrieveProductsByCategory(category: String): Flux<ProductDTO> {
        TODO("Not yet implemented")
    }
}