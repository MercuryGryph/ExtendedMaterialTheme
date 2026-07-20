@file:Suppress("unused")

package cn.mercury9.extendedmaterialtheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import cn.mercury9.extendedmaterialtheme.typography.ConfiguredTypography
import cn.mercury9.extendedmaterialtheme.typography.ExtendedTypography

object ExtendedMaterialTheme {
    val colorScheme: ColorScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme

    val typography: ExtendedTypography = ExtendedTypography

    val shapes: Shapes
        @Composable @ReadOnlyComposable get() = MaterialTheme.shapes

    val motionScheme: MotionScheme
        @Composable @ReadOnlyComposable get() = MaterialTheme.motionScheme

}

/**
 * Warp of `MaterialTheme`, but have a config dsl.
 */
@Composable
fun ExtendedMaterialTheme(
    config: ConfiguredMaterialTheme.() -> Unit = {},
    content: @Composable () -> Unit
) {
    ConfiguredMaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        shapes = MaterialTheme.shapes,
        motionScheme = MaterialTheme.motionScheme,
        typographyConfig = ConfiguredTypography(MaterialTheme.typography),
        config = config,
    ) (content)
}
