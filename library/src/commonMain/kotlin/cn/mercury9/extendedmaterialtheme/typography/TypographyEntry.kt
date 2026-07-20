@file:Suppress("unused")

package cn.mercury9.extendedmaterialtheme.typography

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle

interface TypographyEntry {
    val large           : TextStyle @Composable @ReadOnlyComposable get
    val medium          : TextStyle @Composable @ReadOnlyComposable get
    val small           : TextStyle @Composable @ReadOnlyComposable get
    val largeEmphasized : TextStyle @Composable @ReadOnlyComposable get
    val mediumEmphasized: TextStyle @Composable @ReadOnlyComposable get
    val smallEmphasized : TextStyle @Composable @ReadOnlyComposable get

    @Composable
    @ReadOnlyComposable
    fun large   (emphasized: Boolean = false): TextStyle {
        return if (emphasized) large else largeEmphasized
    }

    @Composable
    @ReadOnlyComposable
    fun medium  (emphasized: Boolean = false): TextStyle {
        return if (emphasized) medium else mediumEmphasized
    }

    @Composable
    @ReadOnlyComposable
    fun small   (emphasized: Boolean = false): TextStyle {
        return if (emphasized) small else smallEmphasized
    }

    @Composable
    @ReadOnlyComposable
    operator fun get(
        size: Size = LocalDefaultSize.current,
        emphasized: Boolean = false,
    ): TextStyle = when (size) {
        Size.Large  -> if (emphasized) large  else largeEmphasized
        Size.Medium -> if (emphasized) medium else mediumEmphasized
        Size.Small  -> if (emphasized) small  else smallEmphasized
    }

    @Composable
    @ReadOnlyComposable
    operator fun invoke(
        size: Size = LocalDefaultSize.current,
        emphasized: Boolean = false,
    ): TextStyle = get(size, emphasized)

    enum class Size {
        Large, Medium, Small;
    }

    companion object {
        val LocalDefaultSize = compositionLocalOf { Size.Large }
    }
}
