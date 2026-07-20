@file:Suppress("unused")

package cn.mercury9.extendedmaterialtheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import cn.mercury9.extendedmaterialtheme.typography.ConfiguredTypography

@MaterialThemeConfigDsl
class ConfiguredMaterialTheme internal constructor(
    var colorScheme: ColorScheme,
    var shapes: Shapes,
    var motionScheme: MotionScheme,
    private val typographyConfig: ConfiguredTypography,
    config: ConfiguredMaterialTheme.() -> Unit = {},
) {

    fun typography(config: ConfiguredTypography.() -> Unit) {
        typographyConfig.config()
    }

    @Composable
    internal operator fun invoke(
        content: @Composable () -> Unit
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            shapes = shapes,
            motionScheme = motionScheme,
            typography = this.typographyConfig.get(),
            content = content
        )
    }
}
