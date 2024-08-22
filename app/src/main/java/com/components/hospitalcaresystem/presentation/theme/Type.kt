package com.components.hospitalcaresystem.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.textSdp

// Set of Material typography styles to start with

val ZindigiFontFamily = FontFamily(
    Font(R.font.font_family, FontWeight.Normal),
    Font(R.font.font_family_bold, FontWeight.Bold),
    Font(R.font.font_family_light, FontWeight.Light),
    Font(R.font.font_family_regular, FontWeight.Medium),
)


val Typography: Typography
    @Composable
    get() = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 42.textSdp,
        lineHeight = 48.textSdp
    ),
    displayMedium = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 34.textSdp,
        lineHeight = 36.textSdp
    ),
    displaySmall = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 27.textSdp,
        lineHeight = 29.textSdp
    ),
    headlineLarge = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.textSdp,
        lineHeight = 25.textSdp
    ),
    headlineMedium = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 21.textSdp,
        lineHeight = 88.textSdp
    ),
    headlineSmall = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.textSdp,
        lineHeight = 19.textSdp
    ),
    titleLarge = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.textSdp,
        lineHeight = 17.textSdp
    ),
    titleMedium = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.primaryContainer,
        fontSize = 14.textSdp,
        lineHeight = 15.textSdp
    ),
    titleSmall = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.textSdp,
        lineHeight = 14.textSdp
    ),
    bodyMedium = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.textSdp,
        lineHeight = 12.textSdp
    ),
    bodySmall = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 9.textSdp,
        lineHeight = 10.textSdp,
    ),
    labelLarge = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.textSdp,
        lineHeight = 13.textSdp,
    ),
    labelMedium = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.textSdp,
        lineHeight = 12.textSdp,
    ),
    labelSmall = TextStyle(
        fontFamily = ZindigiFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 9.textSdp,
        lineHeight = 10.textSdp
    )
)