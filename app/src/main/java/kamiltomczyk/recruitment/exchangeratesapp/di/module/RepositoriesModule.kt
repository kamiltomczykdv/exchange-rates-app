package kamiltomczyk.recruitment.exchangeratesapp.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kamiltomczyk.recruitment.exchangeratesapp.data.network.NBPApiService
import kamiltomczyk.recruitment.exchangeratesapp.data.repositories.CurrencyRepository
import kamiltomczyk.recruitment.exchangeratesapp.data.repositories.CurrencyRepositoryInterface
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideCurrencyRepository(nbpApiService: NBPApiService): CurrencyRepositoryInterface =
        CurrencyRepository(nbpApiService)
}