package org.crystalkste.myshop.controller

import org.crystalkste.myshop.entity.Product
import org.crystalkste.myshop.service.FilterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FilterController(private val filterService: FilterService) {
    @GetMapping("/filter/min/{categoryName}")
    fun sortByMinPrice(@PathVariable("categoryName") categoryName:String): ResponseEntity<List<Product>> {
        val resultList:List<Product> =  filterService.filterByMinPrice(categoryName)
        return ResponseEntity.ok(resultList)
    }

    @GetMapping("/filter/max/{categoryName}")
    fun sortByMax(@PathVariable("categoryName") categoryName:String): ResponseEntity<List<Product>> {
        val resultList:List<Product> = filterService.filterByMaxPrice(categoryName)
        return ResponseEntity.ok(resultList)
    }
}