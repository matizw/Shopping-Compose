package id.trainingdemo.core.domain.usecase.product

import id.trainingdemo.core.data.model.ProductResponse
import id.trainingdemo.core.domain.repository.product.ProductRepository
import id.trainingdemo.core.domain.usecase.BaseUseCaseSuspend
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCaseSuspend<String, Flow<ProductResponse>>() {
    override suspend fun execute(params: String): Flow<ProductResponse> {
        return productRepository.searchProductApiCall(params)
    }
}