package it.polito.wa2group8.warehousewebflux.controllers

import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import it.polito.wa2group8.warehousewebflux.dto.QuantityDTO
import it.polito.wa2group8.warehousewebflux.services.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class ProductController (val productService: ProductService)
{
    @PostMapping(value=["/warehouse/products"])
    @ResponseBody
    suspend fun createProduct(@RequestBody @Valid product: ProductDTO): ResponseEntity<Any>
    {
        return ResponseEntity.status(201).body(productService.createProduct(product))
    }

    @PatchMapping(value=["/warehouse/products/{productID}"])
    @ResponseBody
    suspend fun updateProduct(
        @PathVariable productID: Long,
        @RequestBody quantityDTO: QuantityDTO
    ): ResponseEntity<Any>
    {
        return ResponseEntity.status(200).body(productService.updateProduct(quantityDTO.quantity, productID))
    }

    @GetMapping("/warehouse/products/{productID}")
    suspend fun getProductByID(@PathVariable productID: Long): ResponseEntity<Any>
    {
        return ResponseEntity.ok().body(productService.retrieveProduct(productID))
    }

    @GetMapping(value=["/warehouse/products"])
    suspend fun getAllProducts(): ResponseEntity<Any>
    {
        return ResponseEntity.ok().body(productService.retrieveAllProducts())
    }

    @GetMapping(value=["/warehouse/productsByCategory"])
    suspend fun getProductsByCategory(@RequestParam("category", required=true) category: String): ResponseEntity<Any>
    {
        return ResponseEntity.ok().body(productService.retrieveProductsByCategory(category))
    }
}
