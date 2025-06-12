package id.trainingdemo.core.data.repository.product

import id.trainingdemo.core.data.datasource.remote.ApiService
import id.trainingdemo.core.util.UtilTests
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
import org.mockito.kotlin.given
import org.mockito.kotlin.whenever

 
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ProductRepositoryImplTest {

    @Mock
    private lateinit var apiService: ApiService
    private lateinit var productRepositoryImpl: ProductRepositoryImpl

    @Before
    fun setUp() {
        productRepositoryImpl = ProductRepositoryImpl(apiService)
    }

    @Test
    fun `getProductsApiCall should return the correct data`() = runTest {
 
        val expectedResponse = UtilTests.dummyProductResponse
        whenever(apiService.getProducts()).thenReturn(expectedResponse)
 
        val actualResponse = productRepositoryImpl.getProductsApiCall().first()
 
        assertEquals(expectedResponse, actualResponse)
    }

    @Test
    fun `getProductsApiCall should return error flow when an exception occurs`() = runTest {
 
        val expectedException = RuntimeException("An error occurred")
        given(apiService.getProducts()).willThrow(expectedException)
 
        val actualException = runCatching { productRepositoryImpl.getProductsApiCall().first() }
 
        assertTrue(actualException.isFailure)
        assertEquals(expectedException, actualException.exceptionOrNull())
    }

    @Test
    fun `getProductByIdApiCall should return the correct data`() = runTest {
 
        val expectedResponse = UtilTests.dummyProduct
        val productId = 1
        whenever(apiService.getProductById(productId)).thenReturn(expectedResponse)
 
        val actualResponse = productRepositoryImpl.getProductByIdApiCall(productId).first()
 
        assertEquals(expectedResponse, actualResponse)
    }

    @Test
    fun `getProductByIdApiCall should return error flow when an exception occurs`() = runTest {
 
        val expectedException = RuntimeException("An error occurred")
        val productId = 1
        given(apiService.getProductById(productId)).willThrow(expectedException)
 
        val actualException = runCatching {
            productRepositoryImpl.getProductByIdApiCall(productId).first()
        }
 
        assertTrue(actualException.isFailure)
        assertEquals(expectedException, actualException.exceptionOrNull())
    }

    @Test
    fun `searchProductApiCall should return the correct data`() = runTest {
 
        val expectedResponse = UtilTests.dummyProductResponse
        val query = "test"
        whenever(apiService.searchProduct(query)).thenReturn(expectedResponse)
 
        productRepositoryImpl.searchProductApiCall(query).first()
    }

    @Test
    fun `searchProductApiCall should return error flow when an exception occurs`() = runTest {
 
        val expectedException = RuntimeException("An error occurred")
        val query = "test"
        given(apiService.searchProduct(query)).willThrow(expectedException)
 
        val actualException = runCatching {
            productRepositoryImpl.searchProductApiCall(query).first()
        }
 
        assertTrue(actualException.isFailure)
        assertEquals(expectedException, actualException.exceptionOrNull())
    }
}