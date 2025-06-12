package id.trainingdemo.core.domain.usecase.product.db

import id.trainingdemo.core.data.datasource.local.db.entity.ProductEntity
import id.trainingdemo.core.domain.repository.product.DbProductRepository
import id.trainingdemo.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

 

class GetProductByIdDbUseCase @Inject constructor(
    private val dbProductRepository: DbProductRepository
) : BaseUseCase<Long, Flow<ProductEntity>>() {
    override fun execute(params: Long): Flow<ProductEntity> {
        return dbProductRepository.getProductByIdDb(params)
    }
}