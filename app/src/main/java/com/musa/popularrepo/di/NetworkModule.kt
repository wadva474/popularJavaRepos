package com.musa.popularrepo.di

import com.musa.popularrepo.model.NetworkRepo
import com.musa.popularrepo.repository.Items
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Named

@Module
class NetworkModule {
    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String = "https://api.github.com"
}

interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    fun getTrendingReposAsync(): Deferred<NetworkRepo>

}
