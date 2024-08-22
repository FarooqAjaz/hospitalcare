package com.components.hospitalcaresystem.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A class to model dimensions values.
 */
@Immutable
data class Dimensions(
    val hospitalInputFieldHeight: Dp = 50.dp, // OutlinedTextFieldDefaults.MinHeight,
    val defaultScreenPadding: Dp = 16.dp,
    val buttonHeight: Dp = 50.dp,
    val buttonBorderWidth: Dp = 1.dp,
    val pinFieldBoxSize: Dp = 50.dp,

    val tabHeight: Dp = 44.dp,
    val tabWidth: Dp = 178.dp,

    val cardDebitCardHeight: Dp = 53.dp,
    val cardCornerRadius: Dp = 8.dp,
)

data class ThemeMode(var isDarkTheme: Boolean = false)


/**
 * A composition local for [Dimensions].
 */
val LocalDimensions = staticCompositionLocalOf { Dimensions() }

val LocalThemeMode = staticCompositionLocalOf { ThemeMode() }