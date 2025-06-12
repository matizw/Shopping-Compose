package id.trainingdemo.core.data.datasource.local.db.dao

import androidx.room.*
import id.trainingdemo.core.data.datasource.local.db.entity.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM table_shop")
    fun getProducts(): MutableList<ProductEntity>

    @Query("SELECT * FROM table_shop WHERE id=:id ")
    fun getProductById(id: Long): ProductEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity): Long

    @Delete
    suspend fun deleteProduct(product: ProductEntity): Int
}