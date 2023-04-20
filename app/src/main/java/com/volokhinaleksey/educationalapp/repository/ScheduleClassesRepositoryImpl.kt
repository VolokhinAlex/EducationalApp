package com.volokhinaleksey.educationalapp.repository

import com.volokhinaleksey.educationalapp.datasource.ScheduleClassesDataSource
import com.volokhinaleksey.educationalapp.models.ui.ScheduleUI

class ScheduleClassesRepositoryImpl(
    private val dataSource: ScheduleClassesDataSource
) : ScheduleClassesRepository {
    override suspend fun getScheduleClasses(): List<ScheduleUI> {
        return dataSource.getScheduleClasses().map {
            ScheduleUI(
                lesson = it.lesson.orEmpty(),
                lessonTime = it.lessonTime.orEmpty(),
                teacher = it.teacher.orEmpty(),
                description = it.description.orEmpty(),
                isAdditionalLesson = it.isAdditionalLesson ?: false,
                icon = it.icon ?: 0
            )
        }
    }
}