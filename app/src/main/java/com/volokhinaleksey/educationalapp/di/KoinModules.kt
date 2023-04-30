package com.volokhinaleksey.educationalapp.di

import com.volokhinaleksey.educationalapp.datasource.HomeWorkDataSource
import com.volokhinaleksey.educationalapp.datasource.RemoteHomeWorkDataSource
import com.volokhinaleksey.educationalapp.datasource.RemoteScheduleClassesDataSource
import com.volokhinaleksey.educationalapp.datasource.ScheduleClassesDataSource
import com.volokhinaleksey.educationalapp.repository.HomeWorkRepository
import com.volokhinaleksey.educationalapp.repository.HomeWorkRepositoryImpl
import com.volokhinaleksey.educationalapp.repository.ScheduleClassesRepository
import com.volokhinaleksey.educationalapp.repository.ScheduleClassesRepositoryImpl
import com.volokhinaleksey.educationalapp.viewmodel.HomeScreenViewModel
import com.volokhinaleksey.educationalapp.viewmodel.HomeWorkScreenViewModel
import com.volokhinaleksey.educationalapp.viewmodel.ScheduleScreenViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val datasource = module {
    factory<HomeWorkDataSource> { RemoteHomeWorkDataSource() }
    factory<ScheduleClassesDataSource> { RemoteScheduleClassesDataSource() }
}

val repositories = module {
    factory<HomeWorkRepository> { HomeWorkRepositoryImpl(get()) }
    factory<ScheduleClassesRepository> { ScheduleClassesRepositoryImpl(get()) }
}

val homeworkScreen = module {
    factory { Dispatchers.IO }
    viewModel { HomeWorkScreenViewModel(get(), get()) }
}

val scheduleClassesScreen = module {
    factory { Dispatchers.IO }
    viewModel { ScheduleScreenViewModel(get(), get()) }
}

val homeScreen = module {
    factory { Dispatchers.IO }
    viewModel { HomeScreenViewModel(get(), get(), get()) }
}