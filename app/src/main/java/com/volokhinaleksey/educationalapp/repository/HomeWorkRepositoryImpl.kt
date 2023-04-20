package com.volokhinaleksey.educationalapp.repository

import com.volokhinaleksey.educationalapp.datasource.HomeWorkDataSource
import com.volokhinaleksey.educationalapp.models.ui.HomeworkDataUI

class HomeWorkRepositoryImpl(
    private val dataSource: HomeWorkDataSource
) : HomeWorkRepository {
    override suspend fun getHomeWorks(): List<HomeworkDataUI> {
        return dataSource.getHomeworksData().map {
            HomeworkDataUI(
                lesson = it.lesson.orEmpty(),
                timeComplete = it.timeComplete ?: 0,
                description = it.description.orEmpty(),
                icon = it.icon ?: 0
            )
        }
    }
}