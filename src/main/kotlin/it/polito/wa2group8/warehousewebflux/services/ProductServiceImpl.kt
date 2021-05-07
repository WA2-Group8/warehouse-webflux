package it.polito.wa2group8.warehousewebflux.services

import it.polito.wa2group8.warehousewebflux.domain.Product
import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import it.polito.wa2group8.warehousewebflux.dto.toProductDTO
import it.polito.wa2group8.warehousewebflux.exceptions.BadRequestException
import it.polito.wa2group8.warehousewebflux.exceptions.NotFoundException
import it.polito.wa2group8.warehousewebflux.repositories.ProductRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.math.BigInteger

@Service
@Transactional
class ProductServiceImpl(
    val productRepository: ProductRepository
): ProductService {
    override suspend fun createProduct(productDTO: ProductDTO): ProductDTO {
        if(productDTO.quantity<0) throw BadRequestException("The quantity must be positive")
        val product = Product(null, productDTO.name, productDTO.category, productDTO.price, productDTO.quantity)
        val createdProduct = productRepository.save(product)
        return createdProduct.toProductDTO()
    }

    override suspend fun updateProduct(quantity: Int, productId: Long): ProductDTO {

        val product = productRepository.findById(productId) ?: throw NotFoundException("Product not found")
        val newQuantity = product.quantity + quantity
        if (newQuantity < 0) throw RuntimeException()
        productRepository.updateQuantity(newQuantity,productId)
        product.quantity=newQuantity
        return product.toProductDTO()
    }

    override suspend fun retrieveProduct(id: Long): ProductDTO {
        val product = productRepository.findById(id) ?: throw NotFoundException("Product not found")
        return product.toProductDTO()
    }

    override suspend fun retrieveAllProducts(): Flow<ProductDTO> {
        return productRepository.findAll().map { it.toProductDTO() } //?: throw NotFoundException("Product not found")
    }

    @FlowPreview
    override suspend fun retrieveProductsByCategory(category: String): Flow<ProductDTO> {
        return productRepository.getProductsByCategory(category).map { it.toProductDTO() }
    }
}