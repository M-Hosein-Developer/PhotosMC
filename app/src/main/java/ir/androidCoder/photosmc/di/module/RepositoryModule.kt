package ir.androidCoder.photosmc.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidCoder.photosmc.domain.repositories.MainRepository
import ir.androidCoder.photosmc.domain.repositories.MainRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun mainRepository(repository: MainRepositoryImpl): MainRepository

}