package com.musa.popularrepo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.musa.popularrepo.database.RepoDatabase
import com.musa.popularrepo.di.RepoService
import com.musa.popularrepo.model.DomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class RepoRepository @Inject constructor(
    private val service: RepoService,
    private val repoDatabase: RepoDatabase
) {
    val repos: LiveData<List<DomainModel>> = Transformations.map(
        repoDatabase.database.getRepo()
    ) {
        it.asDomainModel()
    }


    suspend fun refreshRepo() {
        withContext(Dispatchers.IO) {
            val repos = service.getTrendingReposAsync().await()
            repoDatabase.database.dropTable()
            repoDatabase.database.insertRepo(*repos.items.asDatabaseModel())

        }
    }
}