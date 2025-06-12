package id.trainingdemo.core.data.model.mapper

import id.trainingdemo.core.data.datasource.local.db.entity.ProductEntity
import id.trainingdemo.core.data.model.Product

object ProductMapper {
    fun mapFromProductToEntity(product: Product) = ProductEntity(product.id, product.description, product.price, product.thumbnail, product.title)
}