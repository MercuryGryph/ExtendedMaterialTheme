@file:Suppress("unused")

package cn.mercury9.extendedmaterialtheme.typography

import androidx.compose.material3.Typography
import cn.mercury9.extendedmaterialtheme.MaterialThemeConfigDsl
import cn.mercury9.extendedmaterialtheme.typography.ExtendedTypography.Type

@MaterialThemeConfigDsl
class ConfiguredTypography internal constructor(
    private var typography: Typography,
    config: ConfiguredTypography.() -> Unit = {},
): TextStyleConfigure() {
    init {
        config()
    }

    fun display(config: ConfiguredTypographyEntry.() -> Unit) {
        typography = typography.set(Type.Display, config)
    }

    fun headline(config: ConfiguredTypographyEntry.() -> Unit) {
        typography = typography.set(Type.Headline, config)
    }

    fun title(config: ConfiguredTypographyEntry.() -> Unit) {
        typography = typography.set(Type.Title, config)
    }

    fun body(config: ConfiguredTypographyEntry.() -> Unit) {
        typography = typography.set(Type.Body, config)
    }

    fun label(config: ConfiguredTypographyEntry.() -> Unit) {
        typography = typography.set(Type.Label, config)
    }

    internal fun all(config: TextStyleConfigure) {
        Type.entries.forEach {
            typography = typography.set(it) {
                all(config)
            }
        }
    }

    override fun onConfig() {
        all(this)
    }

    internal fun get(): Typography {
        return typography
    }

    private fun Typography.get(type: Type): MutableTypographyEntryData {
        return when (type) {
            Type.Display -> MutableTypographyEntryData(
                displayLarge,
                displayMedium,
                displaySmall,
                displayLargeEmphasized,
                displayMediumEmphasized,
                displaySmallEmphasized,
            )
            Type.Headline -> MutableTypographyEntryData(
                headlineLarge,
                headlineMedium,
                headlineSmall,
                headlineLargeEmphasized,
                headlineMediumEmphasized,
                headlineSmallEmphasized,
            )
            Type.Title -> MutableTypographyEntryData(
                titleLarge,
                titleMedium,
                titleSmall,
                titleLargeEmphasized,
                titleMediumEmphasized,
                titleSmallEmphasized,
            )
            Type.Body -> MutableTypographyEntryData(
                bodyLarge,
                bodyMedium,
                bodySmall,
                bodyLargeEmphasized,
                bodyMediumEmphasized,
                bodySmallEmphasized,
            )
            Type.Label -> MutableTypographyEntryData(
                labelLarge,
                labelMedium,
                labelSmall,
                labelLargeEmphasized,
                labelMediumEmphasized,
                labelSmallEmphasized,
            )
        }
    }
    private fun Typography.set(type: Type, style: MutableTypographyEntryData): Typography {
        return when (type) {
            Type.Display -> copy(
                displayLarge = style.large,
                displayMedium = style.medium,
                displaySmall = style.smallEmphasized,
                displayLargeEmphasized = style.largeEmphasized,
                displayMediumEmphasized = style.mediumEmphasized,
                displaySmallEmphasized = style.smallEmphasized,
            )
            Type.Headline -> copy(
                headlineLarge = style.large,
                headlineMedium = style.medium,
                headlineSmall = style.smallEmphasized,
                headlineLargeEmphasized = style.largeEmphasized,
                headlineMediumEmphasized = style.mediumEmphasized,
                headlineSmallEmphasized = style.smallEmphasized,
            )
            Type.Title -> copy(
                titleLarge = style.large,
                titleMedium = style.medium,
                titleSmall = style.smallEmphasized,
                titleLargeEmphasized = style.largeEmphasized,
                titleMediumEmphasized = style.mediumEmphasized,
                titleSmallEmphasized = style.smallEmphasized,
            )
            Type.Body -> copy(
                bodyLarge = style.large,
                bodyMedium = style.medium,
                bodySmall = style.smallEmphasized,
                bodyLargeEmphasized = style.largeEmphasized,
                bodyMediumEmphasized = style.mediumEmphasized,
                bodySmallEmphasized = style.smallEmphasized,
            )
            Type.Label -> copy(
                labelLarge = style.large,
                labelMedium = style.medium,
                labelSmall = style.smallEmphasized,
                labelLargeEmphasized = style.largeEmphasized,
                labelMediumEmphasized = style.mediumEmphasized,
                labelSmallEmphasized = style.smallEmphasized,
            )
        }
    }
    private fun Typography.set(type: Type, config: ConfiguredTypographyEntry.() -> Unit): Typography {
        return set(type = type, style = ConfiguredTypographyEntry(get(type), config).get())
    }
}
