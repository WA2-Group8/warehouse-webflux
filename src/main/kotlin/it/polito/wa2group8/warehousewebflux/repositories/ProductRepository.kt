package it.polito.wa2group8.warehousewebflux.repositories

import it.polito.wa2group8.warehousewebflux.domain.Product
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository : CoroutineCrudRepository<Product,Long> {

    @FlowPreview
    fun getProductsByCategory(category: String): Flow<Product>

    @Modifying
    @Query("UPDATE products SET quantity= ?1 WHERE id = ?2")
    suspend fun updateQuantity(quantity: Int, productId: Long): Product
}