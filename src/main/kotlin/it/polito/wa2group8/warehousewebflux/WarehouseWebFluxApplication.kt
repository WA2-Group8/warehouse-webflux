package it.polito.wa2group8.warehousewebflux

import it.polito.wa2group8.warehousewebflux.domain.Product
import it.polito.wa2group8.warehousewebflux.repositories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import kotlin.random.Random

@SpringBootApplication
class WarehouseWebFluxApplication/*{
    @Bean
    fun test(productRepository: ProductRepository): CommandLineRunner{
        return CommandLineRunner{
            val categories = arrayOf<String>("Food","Electronic","Home","Sport")
            for (i in 1..10000){
                val category = categories[Random.nextInt(0,categories.size-1)]
                save(Product(null,"${category}_$i",category,Math.random()*1000, Random.nextInt(1,100)),productRepository)
            }
        }
    }
}*/

fun main(args: Array<String>) {
    runApplication<WarehouseWebFluxApplication>(*args)
}
/*
suspend fun save(product: Product, productRepository: ProductRepository){
    productRepository.save(product)
}*/