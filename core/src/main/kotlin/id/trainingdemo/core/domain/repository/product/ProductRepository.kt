package id.trainingdemo.core.domain.repository.product

import id.trainingdemo.core.data.model.Product
import id.trainingdemo.core.data.model.ProductResponse
import kotlinx.coroutines.flow.Flow

 

interface ProductRepository {
    fun getProductsApiCall(): Flow<ProductResponse> // this is sample not using `suspend`
    fun getProductByIdApiCall(id: Int): Flow<Product>
    suspend fun searchProductApiCall(query: String): Flow<ProductResponse> // this is sample using `suspend`
}