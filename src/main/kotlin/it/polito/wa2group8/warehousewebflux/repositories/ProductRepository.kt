package it.polito.wa2group8.warehousewebflux.repositories

import it.polito.wa2group8.warehousewebflux.domain.Product
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository:CoroutineCrudRepository<Product,Long> {

}