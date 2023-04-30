package com.volokhinaleksey.educationalapp.datasource

import com.volokhinaleksey.educationalapp.R
import com.volokhinaleksey.educationalapp.models.remote.ScheduleDTO

class RemoteScheduleClassesDataSource : ScheduleClassesDataSource {

    override suspend fun getScheduleClasses(): List<ScheduleDTO> {
        return listOf(
            ScheduleDTO(
                lesson = "History",
                lessonTime = "8:00 - 8:45",
                teacher = "Mrs Thomas",
                description = "",
                isAdditionalLesson = false,
                icon = R.drawable.book_148200
            ),
            ScheduleDTO(
                lesson = "Literature",
                lessonTime = "9:00 - 9:45",
                teacher = "Mrs Barros",
                description = "",
                isAdditionalLesson = false,
                icon = R.drawable.book_148200
            ),
            ScheduleDTO(
                lesson = "Physical Education",
                lessonTime = "10:00 - 11:35",
                teacher = "Mrs Barros",
                description = "Intensive preparation for The Junior World Championship in Los Angeles",
                isAdditionalLesson = true,
                icon = R.drawable.book_148200
            )
        )
    }

}