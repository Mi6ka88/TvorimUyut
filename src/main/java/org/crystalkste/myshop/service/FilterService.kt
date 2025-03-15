package org.crystalkste.myshop.service

import org.crystalkste.myshop.entity.Product
import org.crystalkste.myshop.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class FilterService(private val productRepository: ProductRepository){

    fun filterByMinPrice(categoryName:String): List<Product>{
        val products = productRepository.findProductByCategoryName(categoryName)
        return products.sortedBy { it.price }
    }

    fun filterByMaxPrice(categoryName:String): List<Product>{
        val products = productRepository.findProductByCategoryName(categoryName)
        return products.sortedByDescending { it.price }
    }
}