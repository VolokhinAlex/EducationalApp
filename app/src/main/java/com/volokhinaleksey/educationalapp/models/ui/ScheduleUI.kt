package com.volokhinaleksey.educationalapp.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleUI(
    val lessonTime: String = "",
    val lesson: String = "",
    val teacher: String = "",
    val description: String = "",
    val isAdditionalLesson: Boolean = false,
    val icon: Int = 0,
    val isCurrentLesson: Boolean = false
) : Parcelable
