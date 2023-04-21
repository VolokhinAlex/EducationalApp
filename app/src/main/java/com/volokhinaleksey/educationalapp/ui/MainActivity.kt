package com.volokhinaleksey.educationalapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.volokhinaleksey.educationalapp.ui.navigation.ScreenState
import com.volokhinaleksey.educationalapp.ui.screens.HomeScreen
import com.volokhinaleksey.educationalapp.ui.screens.HomeWorkScreen
import com.volokhinaleksey.educationalapp.ui.screens.ScheduleScreen
import com.volokhinaleksey.educationalapp.ui.theme.EducationalAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EducationalAppTheme {
                Navigation()
            }
        }
    }

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        val tabs = listOf(
            ScreenState.HomeScreen,
            ScreenState.ScheduleScreen,
            ScreenState.HomeWorkScreen
        )
        var currentTab by remember { mutableStateOf(0) }
        Tabs(tabs, currentTab, onClick = {
            currentTab = it
            navController.navigate(route = tabs[currentTab].route)
        }) {
            NavHost(
                navController = navController,
                startDestination = ScreenState.HomeScreen.route,
                modifier = Modifier.padding(it)
            ) {
                composable(route = ScreenState.HomeScreen.route) {
                    HomeScreen()
                }
                composable(route = ScreenState.ScheduleScreen.route) {
                    ScheduleScreen()
                }
                composable(route = ScreenState.HomeWorkScreen.route) {
                    HomeWorkScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Tabs(
        tabs: List<ScreenState>,
        currentTab: Int,
        onClick: (Int) -> Unit,
        content: @Composable (PaddingValues) -> Unit
    ) {
        Scaffold(containerColor = Color(0xFF1C1D21), bottomBar = {
            Column {
                TabRow(
                    modifier = Modifier.clip(RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)),
                    selectedTabIndex = currentTab,
                    containerColor = Color(0xFF252830),
                    contentColor = Color.White,
                    indicator = {},
                    divider = {}
                ) {
                    tabs.forEachIndexed { index, screen ->
                        Tab(modifier = Modifier
                            .padding(8.dp, 20.dp)
                            .clip(RoundedCornerShape(40))
                            .background(if (currentTab == index) Color(0xFF243834) else Color.Transparent)
                            .padding(8.dp, 14.dp),
                            selected = currentTab == index,
                            onClick = { onClick(index) },
                            icon = {
                                Icon(
                                    painter = painterResource(id = screen.icon),
                                    contentDescription = ""
                                )
                            },
                            text = {
                                if (currentTab == index) {
                                    Text(
                                        text = stringResource(id = screen.title),
                                        color = Color.White,
                                        modifier = Modifier.padding(start = 3.dp),
                                        fontSize = 14.sp
                                    )
                                }
                            })
                    }
                }
            }
        }) {
            content(it)
        }
    }

    @Composable
    fun Tab(
        modifier: Modifier = Modifier,
        selected: Boolean,
        text: @Composable() (() -> Unit)?,
        icon: @Composable() (() -> Unit)?,
        onClick: () -> Unit
    ) {
        Row(
            modifier = modifier
                .selectable(
                    selected = selected,
                    onClick = onClick,
                    role = Role.Tab,
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.invoke()
            text?.invoke()
        }

    }

}
