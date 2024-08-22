package com.components.hospitalcaresystem.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.components.hospitalcaresystem.R
import com.components.hospitalcaresystem.extensions.sdp
import com.components.hospitalcaresystem.presentation.theme.HospitalCareAppTheme
import com.components.hospitalcaresystem.presentation.theme.Transparent


@Composable
fun HospitalCareLogoWithTextLarge() {
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Ltr
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .wrapContentWidth()
                .padding(8.dp) // Adjust padding as needed
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_android),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 8.dp) // Space between icon and text
            )
            Text(
                text = "Hospital Care",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold
                )// Adjust the style as needed
            )
        }
    }
}

@Composable
fun HospitalCareClickableTextLabel(
    modifier: Modifier = Modifier,
    color: Color,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    onClick: (() -> Unit)? = null
) {
    Surface(
        modifier = modifier
            .clickable {
                onClick?.invoke()
            },
        color = Transparent
    ) {
        Text(
            text = text,
            color = color,
            style = style
        )
    }
}

@ThemePreviews
@Composable
fun HospitalLogoWithTextLargePreview() {
    HospitalCareLogoWithTextLarge()
}

@ThemePreviews
@Composable
fun HospitalClickableTextPreview() {
    HospitalCareAppTheme {
        Surface {
            Column(modifier = Modifier.padding(0.dp)) {
                HospitalCareClickableTextLabel(
                    color = Color.Red,
                    text = "Forgot Pin"
                )
            }
        }
    }
}


@Composable
fun SearchPlaceHolder(
    modifier: Modifier = Modifier,
    hint: String = "Search...",
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    color: Color = MaterialTheme.colorScheme.surfaceDim
) {
    Text(
        text = hint,
        style = textStyle,
        color = color,
        modifier = modifier
    )
}

@Composable
fun TextWithColoredLineThrough(
    text: String,
    modifier: Modifier = Modifier,
    lineColor: Color = Color.Red,
    textColor: Color,
    style: TextStyle,
   ) {
    Text(
        modifier = modifier
            .drawWithContent {
                drawContent()
                val strokeWidth = 1.dp.toPx()
                val verticalOffset = size.height / 2f
                drawLine(
                    color = lineColor,
                    strokeWidth = strokeWidth,
                    start = Offset(0f, verticalOffset),
                    end = Offset(size.width, verticalOffset)
                )
            },
        text = text,
        style = style,
        color = textColor
    )
}

@Composable
fun HospitalCareDashedLine(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    dashWidth: Dp = 5.dp,
    gapWidth: Dp = 5.dp,
    lineThickness: Dp = 2.dp
) {
    Canvas(modifier = modifier) {
        val paint = Paint().apply {
            this.color = color
            this.strokeWidth = lineThickness.toPx()
            this.pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashWidth.toPx(), gapWidth.toPx()), 0f)
        }
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            color = color,
            start = Offset(0f, canvasHeight / 2),
            end = Offset(canvasWidth, canvasHeight / 2),
            strokeWidth = lineThickness.toPx(),
            pathEffect = paint.pathEffect
        )
    }
}

@Composable
fun HorizontalLineDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = Color.LightGray
) {
    HorizontalDivider(
        modifier = modifier.padding(horizontal = 10.dp),
        thickness = thickness,
        color = color
    )
}


@Preview(name = "HorizontalLineDivider")
@Composable
private fun PreviewHorizontalLineDivider() {
    HorizontalLineDivider(
        thickness = 1.dp,
        color = Color.Red
    )
}
@Composable
fun HospitalCareLineHorizontal(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    lineThickness: Dp = 2.dp
) {
    Canvas(modifier = modifier) {
        val paint = Paint().apply {
            this.color = color
            this.strokeWidth = lineThickness.toPx()
            this.pathEffect = PathEffect.cornerPathEffect(5f)
        }
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawLine(
            color = color,
            start = Offset(0f, canvasHeight / 2),
            end = Offset(canvasWidth, canvasHeight / 2),
            strokeWidth = lineThickness.toPx(),
            pathEffect = paint.pathEffect
        )
    }
}

@Composable
fun HospitalCareLineVertical(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    lineThickness: Dp = 2.dp,
    cornerRadius: Float = 5f // Added for corner path effect
) {
    Canvas(modifier = modifier) {
        val paint = Paint().apply {
            this.color = color
            this.strokeWidth = lineThickness.toPx()
            this.pathEffect = PathEffect.cornerPathEffect(cornerRadius)
        }

        val canvasWidth = size.width
        val canvasHeight = size.height

        // Drawing a vertical line
        drawLine(
            color = color,
            start = Offset(canvasWidth / 2, 0f),
            end = Offset(canvasWidth / 2, canvasHeight),
            strokeWidth = lineThickness.toPx(),
            pathEffect = paint.pathEffect
        )
    }
}


@Preview(name = "SearchPlaceHolder")
@Composable
private fun LineThroughPreview() {
    TextWithColoredLineThrough(text = "Kamran", style = MaterialTheme.typography.labelSmall, textColor = MaterialTheme.colorScheme.onPrimary)
}

@Preview(name = "SearchPlaceHolder")
@Composable
private fun PreviewSearchPlaceHolder() {
    SearchPlaceHolder()
}

@Preview(name = "DashedLine")
@Composable
fun DashedLinePreview() {
    HospitalCareDashedLine(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp),
        color = MaterialTheme.colorScheme.error,
    )
}

@Preview(name = "HorizontalLine")
@Composable
fun HospitalLinePreview() {
    HospitalCareLineHorizontal(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp),
        color = MaterialTheme.colorScheme.error,
    )
}
@Preview(name = "VerticalLine")
@Composable
fun HospitalVerticalLinePreview() {
    HospitalCareLineVertical(
        modifier = Modifier.height(100.dp).width(5.sdp),
        color = MaterialTheme.colorScheme.error,
    )
}
@Composable
fun RoundedText(modifier:Modifier=Modifier,color: Color,  radius: Dp,content: @Composable () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color, shape = RoundedCornerShape(radius))
            .padding(horizontal = 4.dp)
    ) {
        content()
    }
}
@Preview(name = "RoundedText")
@Composable
fun RoundedTextPreview() {
    RoundedText(color = Color.Red, radius = 2.sdp){
        Text(
            text = "Test",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = TextUnit(8f, TextUnitType.Sp),
            textAlign = TextAlign.Center
        )
    }
}