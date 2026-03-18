package com.mgui.bifollow.commons

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD0BCFF),
    secondary = Color(0xFFCCC2DC),
    tertiary = Color(0xFFEFB8C8)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6750A4),
    secondary = Color(0xFF625B71),
    tertiary = Color(0xFF7D5260)
)

@Composable
fun BiFollowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    // Material 3 Expressive supporte des typographies plus larges et dynamiques.
    // Dans les versions récentes, on peut utiliser des tokens spécifiques.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(), // On pourra personnaliser ici pour l'aspect Expressive
        content = content
    )
}
