package com.volokhinaleksey.educationalapp.datasource

import com.volokhinaleksey.educationalapp.models.remote.HomeWorkDTO

interface HomeWorkDataSource {

    suspend fun getHomeworksData(): List<HomeWorkDTO>

}