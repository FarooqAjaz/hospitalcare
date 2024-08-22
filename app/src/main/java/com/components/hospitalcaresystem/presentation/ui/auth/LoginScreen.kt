package com.components.hospitalcaresystem.presentation.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.presentation.common.AppBarState
import com.components.hospitalcaresystem.presentation.components.HideTopAppBar
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.components.ThemePreviews
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.LocalDimensions
import com.components.hospitalcaresystem.presentation.theme.StatusBarColor

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit,
    onSignUpClick: () -> Unit,
    showProgress: (Boolean) -> Unit,
    onForgetPinClick: (String) -> Unit,
    appBarState: AppBarState
    )
{
    StatusBarColor(MaterialTheme.colorScheme.onPrimary)
    appBarState.HideTopAppBar()

    LoginScreen(
        modifier = modifier.padding(LocalDimensions.current.defaultScreenPadding),
        onForgotPinClick = onForgetPinClick,
        onSignUpClick=onSignUpClick,
        onLoginButtonClick =
        { mobile, pin ->
            onLoginSuccess()
        }
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onForgotPinClick: ((String) -> Unit)? = null,
    onSignUpClick: (() -> Unit)? = null,
    //onShowPrompt: ((PromptType, PromptData) -> Int)? = null,
    onLoginButtonClick: ((String, String) -> Unit)? = null
) {
    ScreenContainer {
        Column(Modifier.fillMaxWidth()) {
            Text(modifier = Modifier.clickable { onLoginButtonClick?.invoke("034598622", "1234") }, text = "Welcome to Hospital Care", style = MaterialTheme.typography.displaySmall)
        }
    }

}


@ThemePreviews
@Composable
fun LoginScreenPreview() {
    HospitalCareAppTheme {
        Surface {
            LoginScreen(
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
