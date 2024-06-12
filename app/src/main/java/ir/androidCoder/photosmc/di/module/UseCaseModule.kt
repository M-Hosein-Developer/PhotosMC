package ir.androidCoder.photosmc.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidCoder.photosmc.domain.usecases.MainUseCase
import ir.androidCoder.photosmc.domain.usecases.MainUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun mainUseCase(mainUseCase: MainUseCaseImpl): MainUseCase

}