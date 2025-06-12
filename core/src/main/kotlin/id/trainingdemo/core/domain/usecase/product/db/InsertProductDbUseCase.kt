package id.trainingdemo.core.domain.usecase.product.db

import id.trainingdemo.core.data.datasource.local.db.entity.ProductEntity
import id.trainingdemo.core.domain.repository.product.DbProductRepository
import id.trainingdemo.core.domain.usecase.BaseUseCaseSuspend
import javax.inject.Inject

 

class InsertProductDbUseCase @Inject constructor(
    private val dbProductRepository: DbProductRepository
) : BaseUseCaseSuspend<ProductEntity, Long>() {
    override suspend fun execute(params: ProductEntity): Long {
        return dbProductRepository.insertProductDb(params)
    }
}