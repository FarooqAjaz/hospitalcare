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


val HospitalFontFamily = FontFamily(
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
    headlineLarge = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.textSdp,
        lineHeight = 25.textSdp
    ),
    headlineMedium = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 21.textSdp,
        lineHeight = 88.textSdp
    ),
    headlineSmall = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.textSdp,
        lineHeight = 19.textSdp
    ),
    titleLarge = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.textSdp,
        lineHeight = 17.textSdp
    ),
    titleMedium = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Medium,
        color = MaterialTheme.colorScheme.primaryContainer,
        fontSize = 14.textSdp,
        lineHeight = 15.textSdp
    ),
    titleSmall = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 13.textSdp,
        lineHeight = 14.textSdp
    ),
    labelLarge = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.textSdp,
        lineHeight = 13.textSdp,
    ),
    labelMedium = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.textSdp,
        lineHeight = 12.textSdp,
    ),
    labelSmall = TextStyle(
        fontFamily = HospitalFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 9.textSdp,
        lineHeight = 10.textSdp
    )
)