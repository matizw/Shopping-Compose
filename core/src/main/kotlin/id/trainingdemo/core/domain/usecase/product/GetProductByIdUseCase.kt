package id.trainingdemo.core.domain.usecase.product

import id.trainingdemo.core.data.model.Product
import id.trainingdemo.core.domain.repository.product.ProductRepository
import id.trainingdemo.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCase<Int, Flow<Product>>() {
    override fun execute(params: Int): Flow<Product> {
        return productRepository.getProductByIdApiCall(params)
    }
}