package com.volokhinaleksey.educationalapp.datasource

import com.volokhinaleksey.educationalapp.models.remote.ScheduleDTO

interface ScheduleClassesDataSource {

    suspend fun getScheduleClasses(): List<ScheduleDTO>

}