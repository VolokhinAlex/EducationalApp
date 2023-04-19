package com.volokhinaleksey.educationalapp.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.volokhinaleksey.educationalapp.R

sealed class ScreenState(@StringRes val title: Int, @DrawableRes val icon: Int, val route: String) {
    object HomeScreen :
        ScreenState(title = R.string.home_screen, icon = R.drawable.home, route = "home_screen")

    object ScheduleScreen :
        ScreenState(
            title = R.string.schedule_screen,
            icon = R.drawable.schedule,
            route = "schedule_screen"
        )

    object HomeWorkScreen :
        ScreenState(
            title = R.string.homework_screen,
            icon = R.drawable.homework,
            route = "homework_screen"
        )
}
