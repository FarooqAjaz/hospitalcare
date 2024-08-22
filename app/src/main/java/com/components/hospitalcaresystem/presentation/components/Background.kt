package com.components.hospitalcaresystem.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme

/**
 * Multi preview annotation that represents light and dark themes. Add this annotation to a
 * composable to render the both themes.
 */
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme")
annotation class ThemePreviews

@Preview(showBackground = true, locale = "ur")
annotation class LocalizationPreviews

@Preview(name = "phone", device = "spec:shape=Normal,width=360,height=640,unit=dp,dpi=480")
annotation class DevicePreviews

@Composable
fun HospitalCareBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
    ) {
        //Add any other composable here
        CompositionLocalProvider {
            content()
        }
    }
}


@ThemePreviews
@Composable
fun HospitalBackgroundPreview() {
    HospitalCareAppTheme {
        HospitalCareBackground(modifier = Modifier.size(50.dp)) {

        }
    }
}