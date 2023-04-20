package com.volokhinaleksey.educationalapp.models.remote

data class ScheduleDTO(
    val lessonTime: String?,
    val lesson: String?,
    val teacher: String?,
    val description: String?,
    val isAdditionalLesson: Boolean?,
    val icon: Int?,
)