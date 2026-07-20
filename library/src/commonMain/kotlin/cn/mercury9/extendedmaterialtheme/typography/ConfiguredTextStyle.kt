package cn.mercury9.extendedmaterialtheme.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.TextUnit
import cn.mercury9.extendedmaterialtheme.MaterialThemeConfigDsl
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

sealed class TextStyleConfigure {
    var color: Color? = null
        set(value) { field = value; onConfig() }
    var fontSize: TextUnit? = null
        set(value) { field = value; onConfig() }
    var fontWeight: FontWeight? = null
        set(value) { field = value; onConfig() }
    var fontStyle: FontStyle? = null
        set(value) { field = value; onConfig() }
    var fontSynthesis: FontSynthesis? = null
        set(value) { field = value; onConfig() }
    var fontFamily: FontFamily? = null
        set(value) { field = value; onConfig() }
    var fontFeatureSettings: String? = null
        set(value) { field = value; onConfig() }
    var letterSpacing: TextUnit? = null
        set(value) { field = value; onConfig() }
    var baselineShift: BaselineShift? = null
        set(value) { field = value; onConfig() }
    var textGeometricTransform: TextGeometricTransform? = null
        set(value) { field = value; onConfig() }
    var localeList: LocaleList? = null
        set(value) { field = value; onConfig() }
    var background: Color? = null
        set(value) { field = value; onConfig() }
    var textDecoration: TextDecoration? = null
        set(value) { field = value; onConfig() }
    var shadow: Shadow? = null
        set(value) { field = value; onConfig() }
    var textAlign: TextAlign? = null
        set(value) { field = value; onConfig() }
    var textDirection: TextDirection? = null
        set(value) { field = value; onConfig() }
    var lineHeight: TextUnit? = null
        set(value) { field = value; onConfig() }
    var textIndent: TextIndent? = null
        set(value) { field = value; onConfig() }
    var drawStyle: DrawStyle? = null
        set(value) { field = value; onConfig() }
    var platformStyle: PlatformTextStyle? = null
        set(value) { field = value; onConfig() }
    var lineHeightStyle: LineHeightStyle? = null
        set(value) { field = value; onConfig() }
    var lineBreak: LineBreak? = null
        set(value) { field = value; onConfig() }
    var hyphens: Hyphens? = null
        set(value) { field = value; onConfig() }
    var textMotion: TextMotion? = null
        set(value) { field = value; onConfig() }

    protected open fun onConfig() {}

    internal fun applyTo(it: TextStyle): TextStyle {
        return it.copy(
            color = this.color ?: it.color,
            fontSize = this.fontSize ?: it.fontSize,
            fontWeight = this.fontWeight ?: it.fontWeight,
            fontStyle = this.fontStyle ?: it.fontStyle,
            fontSynthesis = this.fontSynthesis ?: it.fontSynthesis,
            fontFamily = this.fontFamily ?: it.fontFamily,
            fontFeatureSettings = this.fontFeatureSettings ?: it.fontFeatureSettings,
            letterSpacing = this.letterSpacing ?: it.letterSpacing,
            baselineShift = this.baselineShift ?: it.baselineShift,
            textGeometricTransform = this.textGeometricTransform ?: it.textGeometricTransform,
            localeList = this.localeList ?: it.localeList,
            background = this.background ?: it.background,
            textDecoration = this.textDecoration ?: it.textDecoration,
            shadow = this.shadow ?: it.shadow,
            drawStyle = this.drawStyle ?: it.drawStyle,
            textAlign = this.textAlign ?: it.textAlign,
            textDirection = this.textDirection ?: it.textDirection,
            lineHeight = this.lineHeight ?: it.lineHeight,
            textIndent = this.textIndent ?: it.textIndent,
            platformStyle = this.platformStyle ?: it.platformStyle,
            lineHeightStyle = this.lineHeightStyle ?: it.lineHeightStyle,
            lineBreak = this.lineBreak ?: it.lineBreak,
            hyphens = this.hyphens ?: it.hyphens,
            textMotion = this.textMotion ?: it.textMotion,
        )
    }
}

@OptIn(ExperimentalContracts::class)
@MaterialThemeConfigDsl
class ConfiguredTextStyle: TextStyleConfigure {
    internal constructor(
        config: ConfiguredTextStyle.() -> Unit = {}
    ) {
        contract {
            callsInPlace(config, InvocationKind.EXACTLY_ONCE)
        }
        config()
    }
}
