package id.trainingdemo.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.trainingdemo.core.data.datasource.local.db.AppDatabase
import id.trainingdemo.core.data.datasource.remote.ApiService
import id.trainingdemo.core.data.repository.product.DbProductRepositoryImpl
import id.trainingdemo.core.data.repository.product.ProductRepositoryImpl
import id.trainingdemo.core.domain.repository.product.DbProductRepository
import id.trainingdemo.core.domain.repository.product.ProductRepository
import javax.inject.Singleton

 

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService): ProductRepository {
        return ProductRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideDbProductRepository(db: AppDatabase): DbProductRepository {
        return DbProductRepositoryImpl(db)
    }
}