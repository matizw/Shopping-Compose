package id.trainingdemo.core.domain.usecase.product

import id.trainingdemo.core.data.datasource.remote.ApiService
import id.trainingdemo.core.data.model.Product
import id.trainingdemo.core.data.model.ProductResponse
import id.trainingdemo.core.data.repository.product.ProductRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

 

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetProductsUseCaseTest {

    @Mock
    private lateinit var apiService: ApiService
    private lateinit var getProductsUseCase: GetProductsUseCase

    @Before
    fun setUp() {
        getProductsUseCase = GetProductsUseCase(ProductRepositoryImpl(apiService))
    }

    @Test
    fun `execute should return flow of product response`() = runTest {
 
        val productResponse = ProductResponse(0, mutableListOf(Product("Product", "Product 1")))
 
        val result = getProductsUseCase.execute(Unit).first()
 
        assertEquals(productResponse, result)
    }

    @Test
    fun `execute should return error flow when an exception occurs`() = runTest {
 
        val exception = Exception("An error occurred")
 
        val result = runCatching { getProductsUseCase.execute(Unit).first() }
 
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}