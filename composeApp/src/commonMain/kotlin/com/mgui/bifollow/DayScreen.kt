package com.mgui.bifollow

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import bifollow.composeapp.generated.resources.Res
import bifollow.composeapp.generated.resources.day_screen_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun DayScreen() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(stringResource(Res.string.day_screen_title))
    }
}
