package it.polito.wa2group8.warehousewebflux.services

import it.polito.wa2group8.warehousewebflux.domain.Product
import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import it.polito.wa2group8.warehousewebflux.exceptions.NotFoundException
import it.polito.wa2group8.warehousewebflux.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@Transactional
class ProductServiceImpl(
    val productRepository: ProductRepository
): ProductService {
    override suspend fun createProduct(productDTO: ProductDTO): ProductDTO {
        val product = Product(null,productDTO.name,productDTO.category,productDTO.price,ProductDTO.quantity)
        TODO("checks")
        productRepository.save(product)
    }

    override suspend fun updateProduct(productDTO: ProductDTO): ProductDTO {
        TODO("checks")
        val product = productRepository.getProductById(productDTO.id)

        if(productDTO.quantity-product.quantity) throw RuntimeException()

        productRepository.updateQuantity(productDTO.quantity,productDTO.id)

    }

    override suspend fun retrieveProduct(id: Long): ProductDTO {
        val product = productRepository.findById(id) ?: throw NotFoundException("Product not found")
        return product.toProductDTO()
    }

    override suspend fun retrieveAllProducts(): Flow<ProductDTO> {
        return productRepository.findAll().map { t -> t.toTransactionDTO() } //?: throw NotFoundException("Product not found")
    }

    override fun retrieveProductsByCategory(category: String): Flux<ProductDTO> {
        TODO("Not yet implemented")
    }
}