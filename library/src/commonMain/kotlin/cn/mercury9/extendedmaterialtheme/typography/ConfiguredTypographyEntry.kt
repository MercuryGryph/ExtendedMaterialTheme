package cn.mercury9.extendedmaterialtheme.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import cn.mercury9.extendedmaterialtheme.MaterialThemeConfigDsl
import cn.mercury9.extendedmaterialtheme.typography.TypographyEntry.Size
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
@MaterialThemeConfigDsl
class ConfiguredTypographyEntry: TextStyleConfigure {
    private val entry: MutableTypographyEntryData

    internal constructor(
        entry: MutableTypographyEntryData,
        config: ConfiguredTypographyEntry.() -> Unit
    ) {
        contract {
            callsInPlace(config, InvocationKind.EXACTLY_ONCE)
        }
        this.entry = entry
        config()
    }

    override fun onConfig() {
        all(this)
    }

    internal fun all(config: TextStyleConfigure) {
        Size.entries.forEach { size ->
            entry[size, false] = config
            entry[size, true] = config
        }
    }

    fun large(config: ConfiguredTextStyle.() -> Unit) {
        entry[Size.Large, false] = config
    }

    fun medium(config: ConfiguredTextStyle.() -> Unit) {
        entry[Size.Medium, false] = config
    }

    fun small(config: ConfiguredTextStyle.() -> Unit) {
        entry[Size.Small, false] = config
    }

    fun largeEmphasized(config: ConfiguredTextStyle.() -> Unit) {
        entry[Size.Large, true] = config
    }

    fun meduimEmphasized(config: ConfiguredTextStyle.() -> Unit) {
        entry[Size.Medium, true] = config
    }

    fun smallEmphasized(config: ConfiguredTextStyle.() -> Unit) {
        entry[Size.Small, true] = config
    }

    internal fun get(): MutableTypographyEntryData {
        return entry
    }
}


internal data class MutableTypographyEntryData(
    var large           : TextStyle,
    var medium          : TextStyle,
    var small           : TextStyle,
    var largeEmphasized : TextStyle,
    var mediumEmphasized: TextStyle,
    var smallEmphasized : TextStyle,
) {
    operator fun get(size: Size, emphasized: Boolean): TextStyle {
        return when (size) {
            Size.Large  -> if (emphasized) large  else largeEmphasized
            Size.Medium -> if (emphasized) medium else mediumEmphasized
            Size.Small  -> if (emphasized) small  else smallEmphasized
        }
    }

    operator fun set(size: Size, emphasized: Boolean, style: TextStyle) {
        when (size) {
            Size.Large  ->
                if (emphasized) {
                    large = style
                } else {
                    largeEmphasized = style
                }
            Size.Medium ->
                if (emphasized) {
                    medium = style
                } else {
                    mediumEmphasized = style
                }
            Size.Small  ->
                if (emphasized) {
                    small = style
                } else {
                    smallEmphasized = style
                }
        }
    }

    operator fun set(size: Size, emphasized: Boolean, style: TextStyleConfigure) {
        this[size, emphasized] = style.applyTo(this[size, emphasized])
    }

    operator fun set(size: Size, emphasized: Boolean, config: ConfiguredTextStyle.() -> Unit) {
        this[size, emphasized] = ConfiguredTextStyle(config)
    }

    companion object {
        @Composable
        fun of(entry: TypographyEntry): MutableTypographyEntryData = MutableTypographyEntryData(
            large = entry.large,
            medium = entry.medium,
            small = entry.small,
            largeEmphasized = entry.largeEmphasized,
            mediumEmphasized = entry.mediumEmphasized,
            smallEmphasized = entry.smallEmphasized,
        )

        @Composable
        fun TypographyEntry.toData() = of(this)
    }
}
