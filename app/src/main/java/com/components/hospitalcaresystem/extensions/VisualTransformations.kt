package com.components.hospitalcaresystem.extensions

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

/**
 * Description:
 * This file contains the Visual transformations: [https://developer.android.com/reference/kotlin/androidx/compose/ui/text/input/VisualTransformation]
 * to be used in text fields and text labels used in the Hospital application. These visual transformations include:
 * - MSISDN Visual transformations
 * - TODO: Amount Visual transformations
 * - TODO: CNIC Visual transformations
 * - TODO: Date Visual transformations
 * - TODO: Person name Visual transformations
 * - TODO: Address Visual transformations
 *
 **/


/**
 * The class to access all visual transformations related to MSISDN Inputs
 */
class MSISDNVisualTransformations {
    companion object {
        /**
         * Transforms the text with 3 digit code followed by space and 7 digits i.e. 3XX XXXXXXX
         * Also ensures the text does not start with '0'.
         */
        val ThreeDigitCodeFollowedBySevenDigits: VisualTransformation
            get() = VisualTransformation { text ->
                // Format the text with a space after the first 3 digits
                val formattedText = buildString {
                    for (i in text.indices) {
                        append(text[i])
                        if (i == 2) append(" ") // Insert space after 3 digits
                    }
                }
                TransformedText(
                    text = AnnotatedString(formattedText),
                    offsetMapping = object : OffsetMapping {
                        override fun originalToTransformed(offset: Int): Int {
                            return if (offset <= 3) offset else offset + 1
                        }

                        override fun transformedToOriginal(offset: Int): Int {
                            return if (offset <= 3) offset else offset - 1
                        }
                    }
                )
            }


        val TransFormationForCnic: VisualTransformation
            get() = VisualTransformation { text ->
                // Format the text with dashes at the appropriate positions
                val formattedText = buildString {
                    for (i in text.indices) {
                        append(text[i])
                        if (i == 4 || i == 11) append("-")
                    }
                }
                TransformedText(
                    text = AnnotatedString(formattedText),
                    offsetMapping = object : OffsetMapping {
                        override fun originalToTransformed(offset: Int): Int {
                            return when {
                                offset <= 4 -> offset
                                offset in 5..11 -> offset + 1
                                offset in 12..13 -> offset + 2
                                else -> offset + 2
                            }
                        }

                        override fun transformedToOriginal(offset: Int): Int {
                            return when {
                                offset <= 4 -> offset
                                offset in 5..12 -> offset - 1
                                offset in 13..15 -> offset - 2
                                else -> offset - 2
                            }
                        }
                    }
                )
            }

        val CountryCodeTwoDigitsFollowedBySevenDigits: VisualTransformation
            get() = VisualTransformation {
                TODO()
            }
    }
}