package com.volokhinaleksey.educationalapp.models

data class Step(
    val title: String = "",
    val description: String = "",
    val isCurrent: Boolean = false,
    val isAdditionalLesson: Boolean = false
)