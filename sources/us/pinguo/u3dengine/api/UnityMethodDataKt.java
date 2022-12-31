package us.pinguo.u3dengine.api;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import kotlin.jvm.internal.s;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public final class UnityMethodDataKt {
    public static final PGEditBlendMode makeMagicBgBlendMode(String mode) {
        s.h(mode, "mode");
        switch (mode.hashCode()) {
            case -2120744511:
                if (mode.equals("luminosity")) {
                    return PGEditBlendMode.Luminosity;
                }
                break;
            case -2089919732:
                if (mode.equals("softLight")) {
                    return PGEditBlendMode.SoftLight;
                }
                break;
            case -2060248300:
                if (mode.equals("subtract")) {
                    return PGEditBlendMode.Subtract;
                }
                break;
            case -2054137934:
                if (mode.equals("linearDodge")) {
                    return PGEditBlendMode.LinearDodge;
                }
                break;
            case -2046925583:
                if (mode.equals("linearLight")) {
                    return PGEditBlendMode.LinearLight;
                }
                break;
            case -1922884384:
                if (mode.equals("lighterColor")) {
                    return PGEditBlendMode.LighterColor;
                }
                break;
            case -1389786312:
                if (mode.equals("vividLight")) {
                    return PGEditBlendMode.VividLight;
                }
                break;
            case -1338968417:
                if (mode.equals("darken")) {
                    return PGEditBlendMode.Darken;
                }
                break;
            case -1331463047:
                if (mode.equals("divide")) {
                    return PGEditBlendMode.Divide;
                }
                break;
            case -1091287984:
                if (mode.equals("overlay")) {
                    return PGEditBlendMode.Overlay;
                }
                break;
            case -1039745817:
                if (mode.equals(Constants.NORMAL)) {
                    return PGEditBlendMode.Normal;
                }
                break;
            case -907689876:
                if (mode.equals("screen")) {
                    return PGEditBlendMode.Screen;
                }
                break;
            case -805112192:
                if (mode.equals("darkerColor")) {
                    return PGEditBlendMode.DarkerColor;
                }
                break;
            case -710254869:
                if (mode.equals("hardLight")) {
                    return PGEditBlendMode.HardLight;
                }
                break;
            case -452507519:
                if (mode.equals("pinLight")) {
                    return PGEditBlendMode.PinLight;
                }
                break;
            case -230491182:
                if (mode.equals("saturation")) {
                    return PGEditBlendMode.Saturation;
                }
                break;
            case 103672:
                if (mode.equals("hue")) {
                    return PGEditBlendMode.Hue;
                }
                break;
            case 94842723:
                if (mode.equals(TypedValues.Custom.S_COLOR)) {
                    return PGEditBlendMode.Color;
                }
                break;
            case 170546239:
                if (mode.equals("lighten")) {
                    return PGEditBlendMode.Lighten;
                }
                break;
            case 210778772:
                if (mode.equals("linearBurn")) {
                    return PGEditBlendMode.LinearBurn;
                }
                break;
            case 287951985:
                if (mode.equals("dissolve")) {
                    return PGEditBlendMode.Dissolve;
                }
                break;
            case 653829668:
                if (mode.equals("multiply")) {
                    return PGEditBlendMode.Multiply;
                }
                break;
            case 696467825:
                if (mode.equals("hardMix")) {
                    return PGEditBlendMode.HardMix;
                }
                break;
            case 1264594484:
                if (mode.equals("colorDodge")) {
                    return PGEditBlendMode.ColorDodge;
                }
                break;
            case 1686617550:
                if (mode.equals("exclusion")) {
                    return PGEditBlendMode.Exclusion;
                }
                break;
            case 1728361789:
                if (mode.equals("difference")) {
                    return PGEditBlendMode.Difference;
                }
                break;
            case 1980402642:
                if (mode.equals("colorBurn")) {
                    return PGEditBlendMode.ColorBurn;
                }
                break;
        }
        return PGEditBlendMode.Normal;
    }

    public static final MagicBgType makeMagicBgType(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return MagicBgType.Background;
                    }
                    return MagicBgType.Person;
                }
                return MagicBgType.Sticker;
            }
            return MagicBgType.Foreground;
        }
        return MagicBgType.Background;
    }

    public static final MagicBackgroundStrokeType makeStrokeType(int i2) {
        switch (i2) {
            case 0:
                return MagicBackgroundStrokeType.None;
            case 1:
                return MagicBackgroundStrokeType.Line;
            case 2:
                return MagicBackgroundStrokeType.DashLine;
            case 3:
                return MagicBackgroundStrokeType.SolidColorBlock;
            case 4:
                return MagicBackgroundStrokeType.SourceTextureBlock;
            case 5:
                return MagicBackgroundStrokeType.DotLine;
            case 6:
                return MagicBackgroundStrokeType.CrayonLine;
            case 7:
                return MagicBackgroundStrokeType.VerticalLine;
            default:
                return MagicBackgroundStrokeType.None;
        }
    }
}
