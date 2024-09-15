package kamiltomczyk.recruitment.exchangeratesapp.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kamiltomczyk.recruitment.exchangeratesapp.data.constants.DataConstants.NBPApi.baseUrl
import kamiltomczyk.recruitment.exchangeratesapp.data.network.NBPApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideNBPApiService(retrofit: Retrofit): NBPApiService =
        retrofit.create(NBPApiService::class.java)
}