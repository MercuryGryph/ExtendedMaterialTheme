package cn.mercury9.extendedmaterialtheme.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cn.mercury9.extendedmaterialtheme.ExtendedMaterialTheme
import cn.mercury9.extendedmaterialtheme.typography.ExtendedTypography
import cn.mercury9.extendedmaterialtheme.typography.TypographyEntry

fun main() = application {
    val isDark = true
    Window(onCloseRequest = ::exitApplication) {
        ExtendedMaterialTheme({
            colorScheme = if (isDark) darkColorScheme() else lightColorScheme()
        }) {
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ExtendedMaterialTheme({
                        typography {
                            color = Color.Red
                            title {
                                color = Color.Cyan
                                large {
                                    color = Color.Green
                                }
                            }
                            headline {
                                fontStyle = FontStyle.Italic
                            }
                        }
                    }) {
                        ColOfAllTextStyle()
                    }
                    ExtendedMaterialTheme({
                        typography {
                            fontFamily = FontFamily.Serif
                        }
                    }) {
                        ColOfAllTextStyle()
                    }
                }
            }
        }
    }
}

@Composable
fun ColOfAllTextStyle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ExtendedTypography.Type.entries.forEach { entry ->
            TypographyEntry.Size.entries.forEach { size ->
                Text(
                    text = "$entry $size",
                    style = entry(size)
                )
            }
        }
    }
}
