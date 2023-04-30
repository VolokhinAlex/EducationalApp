package com.volokhinaleksey.educationalapp.models.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeworkDataUI(
    val lesson: String = "",
    val timeComplete: Int = 0,
    val description: String = "",
    val icon: Int = 0
) : Parcelable
