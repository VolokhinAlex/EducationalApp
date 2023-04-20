package com.volokhinaleksey.educationalapp.repository

import com.volokhinaleksey.educationalapp.models.ui.HomeworkDataUI

interface HomeWorkRepository {

    suspend fun getHomeWorks(): List<HomeworkDataUI>

}