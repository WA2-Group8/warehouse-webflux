package it.polito.wa2group8.warehousewebflux.controllers

import it.polito.wa2group8.warehousewebflux.dto.ProductDTO
import it.polito.wa2group8.warehousewebflux.services.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

@RestController
class ProductController (
    val productService: ProductService
        ){

    @PostMapping(value=["/warehouse/products"])
    @ResponseBody
    suspend fun createProduct(
        @RequestBody @Valid product: ProductDTO,
        bindingResult: BindingResult
    ) : ResponseEntity<Any>
    {
        if(bindingResult.hasErrors()) return ResponseEntity.badRequest().body(bindingResult.getFieldError("customerId")?.defaultMessage)
        return ResponseEntity.status(201).body(productService.createProduct(product))

    }
    @GetMapping("/warehouse/products/{productID}")//, produce = ["application/stream+json"])
    suspend fun getProductByID(@PathVariable productID: Long): ResponseEntity<Any>
    {
        //TODO aggiungere eccezione Not Found
        return ResponseEntity.ok().body(productService.retrieveProduct(productID))
    }
}