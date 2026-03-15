package com.mgui.bifollow

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

enum class Screen(val label: String, val icon: ImageVector) {
    Add("Add", Icons.Default.Add),
    Day("Day", Icons.Default.DateRange),
    Overview("Overview", Icons.AutoMirrored.Filled.List)
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        var selectedScreen by remember { mutableStateOf(Screen.Day) }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    Screen.entries.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = screen.label) },
                            label = { Text(screen.label) },
                            selected = selectedScreen == screen,
                            onClick = { selectedScreen = screen }
                        )
                    }
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                when (selectedScreen) {
                    Screen.Add -> AddScreen()
                    Screen.Day -> DayScreen()
                    Screen.Overview -> OverviewScreen()
                }
            }
        }
    }
}
