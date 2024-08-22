package com.components.hospitalcaresystem.presentation.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.SpacerHeight
import com.components.hospitalcaresystem.extensions.hpr
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.common.AppBarState
import com.components.hospitalcaresystem.presentation.components.HideTopAppBar
import com.components.hospitalcaresystem.presentation.components.HospitalCareIconTextPrimaryButton
import com.components.hospitalcaresystem.presentation.components.HospitalCareTextInputField
import com.components.hospitalcaresystem.presentation.components.ResourceIcon
import com.components.hospitalcaresystem.presentation.components.ScreenContainer
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.LocalDimensions
import com.components.hospitalcaresystem.presentation.theme.Orange70
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
    var mobileNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ScreenContainer {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            SpacerHeight(height = 10.hpr)
            ResourceIcon(icon = R.drawable.img_splash, tint = MaterialTheme.colorScheme.primary)
            SpacerHeight(height = 5.sdp)
            Text(
                text = stringResource(R.string.sign_in),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            SpacerHeight(height = 5.sdp)
            Text(
                text = stringResource(R.string.hi_welcome_back_you_ve_been_missed),
                style = MaterialTheme.typography.labelSmall
            )
            HospitalCareTextInputField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                fieldLabel = stringResource(R.string.mobile_number),
                placeholder = stringResource(R.string.enter_mobile_number)
            )
            SpacerHeight(height = 5.sdp)
            HospitalCareTextInputField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                value = password,
                onValueChange = { password = it },
                fieldLabel = stringResource(R.string.password),
                placeholder = "************",
                trailing = { ResourceIcon(icon = R.drawable.ic_visibililty_off, tint = MaterialTheme.colorScheme.primary)}
            )
            SpacerHeight(height = 8.sdp)
            Text(
                modifier = Modifier.align(Alignment.End),
                text = "Forgot Password?",
                style = MaterialTheme.typography.labelSmall,
                color = Orange70
            )

            SpacerHeight(height = 5.hpr)
            HospitalCareIconTextPrimaryButton(
                modifier = Modifier,
                iconPainter = painterResource(id = R.drawable.ic_arrow_right),
                title = stringResource(id = R.string.login)
            ) {
                onLoginButtonClick?.invoke("0$mobileNumber", password)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Version 1.0.1",
                    style = MaterialTheme.typography.labelSmall
                )
                SpacerHeight(height = 10.sdp)
            }
        }

    }
}

@Preview
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
