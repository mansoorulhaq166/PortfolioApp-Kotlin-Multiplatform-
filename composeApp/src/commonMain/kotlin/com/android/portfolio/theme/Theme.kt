package com.android.portfolio.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF1DB954),
    primaryVariant = Color(0xFF1ED760),
    secondary = Color(0xFFBB86FC),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@Composable
fun PortfolioTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography(
            h4 = Typography().h4.copy(color = Color.White),
            h5 = Typography().h5.copy(color = Color(0xFF1DB954)),
            h6 = Typography().h6.copy(color = Color(0xFFCCCCCC)),
            body1 = Typography().body1.copy(color = Color(0xFFBBBBBB))
        ),
        shapes = Shapes(),
        content = content
    )
}