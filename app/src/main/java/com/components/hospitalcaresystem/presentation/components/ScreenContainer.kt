package com.components.hospitalcaresystem.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.components.hospitalcaresystem.extensions.sdp

@Composable
fun ScreenContainer(
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit),
) {
    Box(modifier.fillMaxSize().padding(horizontal = 12.sdp)) {
        content()
    }
}

@Preview(name = "ScreenContainer")
@Composable
private fun PreviewScreenContainer() {
    ScreenContainer{

    }
}