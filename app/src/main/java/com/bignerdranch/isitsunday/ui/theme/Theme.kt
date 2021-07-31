package com.bignerdranch.isitsunday.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.bignerdranch.isitsunday.R

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val light = Font(R.font.apercu_regular, FontWeight.W300)
private val regular = Font(R.font.apercu_regular, FontWeight.W400)
private val medium = Font(R.font.apercu_regular, FontWeight.W500)
private val semibold = Font(R.font.apercu_regular, FontWeight.W600)

private val craneFontFamily = FontFamily(light, regular, medium, semibold)

val apercuTypography = Typography(
    defaultFontFamily = craneFontFamily,
    /* ... */
)

@Composable
fun SundayTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = apercuTypography,
        shapes = Shapes,
        content = content
    )
}