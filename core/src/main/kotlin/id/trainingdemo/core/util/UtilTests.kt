package id.trainingdemo.core.util

import id.trainingdemo.core.data.model.Product
import id.trainingdemo.core.data.model.ProductResponse

object UtilTests {
    val dummyProduct = Product("Product", "Product 1")
    val dummyProductResponse = ProductResponse(0, mutableListOf(dummyProduct))
}