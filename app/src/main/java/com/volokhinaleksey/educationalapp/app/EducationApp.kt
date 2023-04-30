package com.volokhinaleksey.educationalapp.app

import android.app.Application
import com.volokhinaleksey.educationalapp.di.datasource
import com.volokhinaleksey.educationalapp.di.homeScreen
import com.volokhinaleksey.educationalapp.di.homeworkScreen
import com.volokhinaleksey.educationalapp.di.repositories
import com.volokhinaleksey.educationalapp.di.scheduleClassesScreen
import org.koin.core.context.startKoin

class EducationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    datasource,
                    repositories,
                    homeScreen,
                    homeworkScreen,
                    scheduleClassesScreen
                )
            )
        }
    }

}