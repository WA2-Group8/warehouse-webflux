package it.polito.wa2group8.warehousewebflux.controllers

import it.polito.wa2group8.warehousewebflux.services.ProductService
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController (
    val productService: ProductService
        ){


}