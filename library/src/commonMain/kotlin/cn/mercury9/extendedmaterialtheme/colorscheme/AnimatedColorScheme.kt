@file:Suppress("unused")

package cn.mercury9.extendedmaterialtheme.colorscheme

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

/**
 * Warp every color with [animateColorAsState]
 */
@Composable
fun animatedColorScheme(colorScheme: ColorScheme): ColorScheme {

    // region define animate color state
    val primary = animateColorAsState(colorScheme.primary)
    val onPrimary = animateColorAsState(colorScheme.onPrimary)
    val primaryContainer = animateColorAsState(colorScheme.primaryContainer)
    val onPrimaryContainer = animateColorAsState(colorScheme.onPrimaryContainer)
    val inversePrimary = animateColorAsState(colorScheme.inversePrimary)

    val secondary = animateColorAsState(colorScheme.secondary)
    val onSecondary = animateColorAsState(colorScheme.onSecondary)
    val secondaryContainer = animateColorAsState(colorScheme.secondaryContainer)
    val onSecondaryContainer = animateColorAsState(colorScheme.onSecondaryContainer)

    val tertiary = animateColorAsState(colorScheme.tertiary)
    val onTertiary = animateColorAsState(colorScheme.onTertiary)
    val tertiaryContainer = animateColorAsState(colorScheme.tertiaryContainer)
    val onTertiaryContainer = animateColorAsState(colorScheme.onTertiaryContainer)

    val background = animateColorAsState(colorScheme.background)
    val onBackground = animateColorAsState(colorScheme.onBackground)

    val surface = animateColorAsState(colorScheme.surface)
    val onSurface = animateColorAsState(colorScheme.onSurface)
    val surfaceVariant = animateColorAsState(colorScheme.surfaceVariant)
    val onSurfaceVariant = animateColorAsState(colorScheme.onSurfaceVariant)
    val surfaceTint = animateColorAsState(colorScheme.surfaceTint)
    val inverseSurface = animateColorAsState(colorScheme.inverseSurface)
    val inverseOnSurface = animateColorAsState(colorScheme.inverseOnSurface)

    val error = animateColorAsState(colorScheme.error)
    val onError = animateColorAsState(colorScheme.onError)
    val errorContainer = animateColorAsState(colorScheme.errorContainer)
    val onErrorContainer = animateColorAsState(colorScheme.onErrorContainer)

    val outline = animateColorAsState(colorScheme.outline)
    val outlineVariant = animateColorAsState(colorScheme.outlineVariant)
    val scrim = animateColorAsState(colorScheme.scrim)

    val surfaceBright = animateColorAsState(colorScheme.surfaceVariant)
    val surfaceDim = animateColorAsState(colorScheme.surfaceDim)
    val surfaceContainer = animateColorAsState(colorScheme.surfaceContainer)
    val surfaceContainerHigh = animateColorAsState(colorScheme.surfaceContainerHigh)
    val surfaceContainerHighest = animateColorAsState(colorScheme.surfaceContainerHighest)
    val surfaceContainerLow = animateColorAsState(colorScheme.surfaceContainerLow)
    val surfaceContainerLowest = animateColorAsState(colorScheme.surfaceContainerLowest)

    val primaryFixed = animateColorAsState(colorScheme.primaryFixed)
    val primaryFixedDim = animateColorAsState(colorScheme.primaryFixedDim)
    val onPrimaryFixed = animateColorAsState(colorScheme.onPrimaryFixed)
    val onPrimaryFixedVariant = animateColorAsState(colorScheme.onPrimaryFixedVariant)

    val secondaryFixed = animateColorAsState(colorScheme.secondaryFixed)
    val secondaryFixedDim = animateColorAsState(colorScheme.secondaryFixedDim)
    val onSecondaryFixed = animateColorAsState(colorScheme.onSecondaryFixed)
    val onSecondaryFixedVariant = animateColorAsState(colorScheme.onSecondaryFixedVariant)

    val tertiaryFixed = animateColorAsState(colorScheme.tertiaryFixed)
    val tertiaryFixedDim = animateColorAsState(colorScheme.tertiaryFixedDim)
    val onTertiaryFixed = animateColorAsState(colorScheme.onTertiaryFixed)
    val onTertiaryFixedVariant = animateColorAsState(colorScheme.onTertiaryFixedVariant)
    // endregion

    return ColorScheme(
        // region pass color value
        primary = primary.value,
        onPrimary = onPrimary.value,
        primaryContainer = primaryContainer.value,
        onPrimaryContainer = onPrimaryContainer.value,
        inversePrimary = inversePrimary.value,

        secondary = secondary.value,
        onSecondary = onSecondary.value,
        secondaryContainer = secondaryContainer.value,
        onSecondaryContainer = onSecondaryContainer.value,

        tertiary = tertiary.value,
        onTertiary = onTertiary.value,
        tertiaryContainer = tertiaryContainer.value,
        onTertiaryContainer = onTertiaryContainer.value,

        background = background.value,
        onBackground = onBackground.value,

        surface = surface.value,
        onSurface = onSurface.value,
        surfaceVariant = surfaceVariant.value,
        onSurfaceVariant = onSurfaceVariant.value,
        surfaceTint = surfaceTint.value,
        inverseSurface = inverseSurface.value,
        inverseOnSurface = inverseOnSurface.value,

        error = error.value,
        onError = onError.value,
        errorContainer = errorContainer.value,
        onErrorContainer = onErrorContainer.value,

        outline = outline.value,
        outlineVariant = outlineVariant.value,

        scrim = scrim.value,

        surfaceBright = surfaceBright.value,
        surfaceDim = surfaceDim.value,
        surfaceContainer = surfaceContainer.value,
        surfaceContainerHigh = surfaceContainerHigh.value,
        surfaceContainerHighest = surfaceContainerHighest.value,
        surfaceContainerLow = surfaceContainerLow.value,
        surfaceContainerLowest = surfaceContainerLowest.value,

        primaryFixed = primaryFixed.value,
        primaryFixedDim = primaryFixedDim.value,
        onPrimaryFixed = onPrimaryFixed.value,
        onPrimaryFixedVariant = onPrimaryFixedVariant.value,

        secondaryFixed = secondaryFixed.value,
        secondaryFixedDim = secondaryFixedDim.value,
        onSecondaryFixed = onSecondaryFixed.value,
        onSecondaryFixedVariant = onSecondaryFixedVariant.value,

        tertiaryFixed = tertiaryFixed.value,
        tertiaryFixedDim = tertiaryFixedDim.value,
        onTertiaryFixed = onTertiaryFixed.value,
        onTertiaryFixedVariant = onTertiaryFixedVariant.value,
        // endregion
    )
}
