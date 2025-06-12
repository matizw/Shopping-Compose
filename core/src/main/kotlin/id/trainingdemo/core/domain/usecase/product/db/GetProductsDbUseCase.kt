package id.trainingdemo.core.domain.usecase.product.db

import id.trainingdemo.core.data.datasource.local.db.entity.ProductEntity
import id.trainingdemo.core.domain.repository.product.DbProductRepository
import id.trainingdemo.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

 

class GetProductsDbUseCase @Inject constructor(
    private val dbProductRepository: DbProductRepository
) : BaseUseCase<Unit, Flow<MutableList<ProductEntity>>>() {
    override fun execute(params: Unit): Flow<MutableList<ProductEntity>> {
        return dbProductRepository.getProductsDb()
    }
}