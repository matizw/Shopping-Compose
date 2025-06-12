package id.trainingdemo.core.data.datasource.remote

import id.trainingdemo.core.data.model.Product
import id.trainingdemo.core.data.model.ProductResponse
import retrofit2.http.*

 

interface ApiService {

    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Product

    @GET("products/search")
    suspend fun searchProduct(
        @Query("q") query: String
    ): ProductResponse
}