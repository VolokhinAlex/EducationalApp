package com.volokhinaleksey.educationalapp.repository

import com.volokhinaleksey.educationalapp.models.ui.ScheduleUI

interface ScheduleClassesRepository {

    suspend fun getScheduleClasses(): List<ScheduleUI>

}