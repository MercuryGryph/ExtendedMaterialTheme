@file:Suppress("unused")

package cn.mercury9.extendedmaterialtheme.typography

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import cn.mercury9.extendedmaterialtheme.MaterialThemeConfigDsl
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

object ExtendedTypography {
    val display  : TypographyEntry = Type.Display
    val headline : TypographyEntry = Type.Headline
    val title    : TypographyEntry = Type.Title
    val body     : TypographyEntry = Type.Body
    val label    : TypographyEntry = Type.Label

    enum class Type: TypographyEntry {
        Display {
            override val large: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.displayLarge
            override val medium: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.displayMedium
            override val small: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.displaySmall
            override val largeEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.displayLargeEmphasized
            override val mediumEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.displayMediumEmphasized
            override val smallEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.displaySmallEmphasized
        },

        Headline {
            override val large: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.headlineLarge
            override val medium: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.headlineMedium
            override val small: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.headlineSmall
            override val largeEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.headlineLargeEmphasized
            override val mediumEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.headlineMediumEmphasized
            override val smallEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.headlineSmallEmphasized
        },

        Title {
            override val large: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.titleLarge
            override val medium: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.titleMedium
            override val small: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.titleSmall
            override val largeEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.titleLargeEmphasized
            override val mediumEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.titleMediumEmphasized
            override val smallEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.titleSmallEmphasized
        },

        Body {
            override val large: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.bodyLarge
            override val medium: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.bodyMedium
            override val small: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.bodySmall
            override val largeEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.bodyLargeEmphasized
            override val mediumEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.bodyMediumEmphasized
            override val smallEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.bodySmallEmphasized
        },

        Label {
            override val large: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelLarge
            override val medium: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelMedium
            override val small: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelSmall
            override val largeEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelLargeEmphasized
            override val mediumEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelMediumEmphasized
            override val smallEmphasized: TextStyle
                @Composable @ReadOnlyComposable get() = MaterialTheme.typography.labelSmallEmphasized
        },
    }

    operator fun invoke(type: Type, emphasized: Boolean) = type
}
