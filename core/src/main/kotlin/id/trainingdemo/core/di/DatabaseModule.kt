package id.trainingdemo.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.trainingdemo.core.data.datasource.local.db.AppDatabase
import id.trainingdemo.core.util.UtilConstants.DB_JET_SHOPEE
import javax.inject.Singleton

 

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_JET_SHOPEE).build()
    }
}