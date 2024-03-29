package com.musa.popularrepo.application

import android.app.Application
import com.musa.popularrepo.workManager.RefreshDataWork
import com.musa.popularrepo.di.ApiServiceModule
import com.musa.popularrepo.di.LocalDataModule
import com.musa.popularrepo.di.ViewModelModule
import com.musa.popularrepo.reposFragment.Repos
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,ApiServiceModule::class,LocalDataModule::class,ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: Application)

    fun inject(fragment:Repos)

    fun inject(workManager: RefreshDataWork)

}

