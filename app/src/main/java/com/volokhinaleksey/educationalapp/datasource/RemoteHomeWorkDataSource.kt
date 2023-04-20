package com.volokhinaleksey.educationalapp.datasource

import com.volokhinaleksey.educationalapp.R
import com.volokhinaleksey.educationalapp.models.remote.HomeWorkDTO

class RemoteHomeWorkDataSource : HomeWorkDataSource {
    override suspend fun getHomeworksData(): List<HomeWorkDTO> {
        return listOf(
            HomeWorkDTO(
                lesson = "Literature",
                timeComplete = 2,
                description = "Read scenes 1.1-1.12 of The Master and Margarita",
                icon = R.drawable.book_148200
            ),
            HomeWorkDTO(
                lesson = "Literature",
                timeComplete = 5,
                description = "Read scenes 1.12-1.13 of The Master and Margarita",
                icon = R.drawable.book_148200
            ),
            HomeWorkDTO(
                lesson = "Literature",
                timeComplete = 6,
                description = "Read scenes 1.13-1.14 of The Master and Margarita",
                icon = R.drawable.book_148200
            ),
            HomeWorkDTO(
                lesson = "Literature",
                timeComplete = 1,
                description = "Read scenes 1.14-1.15 of The Master and Margarita",
                icon = R.drawable.book_148200
            ),
            HomeWorkDTO(
                lesson = "Literature",
                timeComplete = 2,
                description = "Read scenes 1.15-1.16 of The Master and Margarita",
                icon = R.drawable.book_148200
            )
        )
    }
}