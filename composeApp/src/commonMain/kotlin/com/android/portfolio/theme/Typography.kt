package com.android.portfolio.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

val AppTypography = Typography(
    h4 = TextStyle(fontSize = 32.sp, color = TextPrimary),
    h5 = TextStyle(fontSize = 24.sp, color = TextPrimary),
    h6 = TextStyle(fontSize = 20.sp, color = TextPrimary),
    body1 = TextStyle(fontSize = 16.sp, color = TextSecondary)
)