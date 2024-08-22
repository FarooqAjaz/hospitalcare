package com.components.hospitalcaresystem.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberAsyncImagePainter

/**
 * @author: Muhammad Kamran
 *
 */
@Composable
fun rememberAsyncImagePainterWithPlaceholder(
    model: Any,
    placeholder: Painter,
    error: Painter
): Painter {
    return rememberAsyncImagePainter(
        model = model,
        placeholder = placeholder,
        error = error
    )
}