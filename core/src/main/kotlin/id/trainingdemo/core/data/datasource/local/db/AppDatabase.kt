package id.trainingdemo.core.data.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import id.trainingdemo.core.data.datasource.local.db.dao.ProductDao
import id.trainingdemo.core.data.datasource.local.db.entity.ProductEntity

@Database(
    entities = [ProductEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}