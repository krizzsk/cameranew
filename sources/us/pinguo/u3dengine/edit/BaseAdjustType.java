package us.pinguo.u3dengine.edit;

import android.util.Range;
import androidx.exifinterface.media.ExifInterface;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum None uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public final class BaseAdjustType {
    private static final /* synthetic */ BaseAdjustType[] $VALUES;
    public static final BaseAdjustType Brightness;
    public static final BaseAdjustType CenterLight;
    public static final BaseAdjustType Chromatic;
    public static final BaseAdjustType ColorTemperature;
    public static final BaseAdjustType Contrast;
    public static final BaseAdjustType DarkCorner;
    public static final BaseAdjustType DarkCornerNew;
    public static final BaseAdjustType Exposure;
    public static final BaseAdjustType Fade;
    public static final BaseAdjustType Grain;
    public static final BaseAdjustType Highlight;
    public static final BaseAdjustType Level;
    public static final BaseAdjustType None;
    public static final BaseAdjustType Saturation;
    public static final BaseAdjustType Shadow;
    public static final BaseAdjustType Sharpen;
    public static final BaseAdjustType Tonal;
    public static final BaseAdjustType Vividness;
    private final String param;
    private final Range<Float> range;
    private final int type;

    private static final /* synthetic */ BaseAdjustType[] $values() {
        return new BaseAdjustType[]{None, Exposure, Brightness, Contrast, Highlight, Shadow, Tonal, ColorTemperature, Saturation, Vividness, Level, Sharpen, DarkCorner, CenterLight, Fade, Grain, DarkCornerNew, Chromatic};
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        None = new BaseAdjustType("None", 0, 0, "lut", new Range(valueOf, valueOf));
        Float valueOf2 = Float.valueOf(-1.0f);
        Float valueOf3 = Float.valueOf(1.0f);
        Exposure = new BaseAdjustType("Exposure", 1, 1, "exposure", new Range(valueOf2, valueOf3));
        Brightness = new BaseAdjustType("Brightness", 2, 2, "brightness", new Range(valueOf2, valueOf3));
        Contrast = new BaseAdjustType(ExifInterface.TAG_CONTRAST, 3, 3, "contrast", new Range(valueOf2, valueOf3));
        Highlight = new BaseAdjustType("Highlight", 4, 4, "highlight", new Range(valueOf2, valueOf3));
        Shadow = new BaseAdjustType("Shadow", 5, 5, "shadow", new Range(valueOf2, valueOf3));
        Tonal = new BaseAdjustType("Tonal", 6, 6, "hue", new Range(valueOf2, valueOf3));
        ColorTemperature = new BaseAdjustType("ColorTemperature", 7, 7, "whitebalance", new Range(valueOf2, valueOf3));
        Saturation = new BaseAdjustType(ExifInterface.TAG_SATURATION, 8, 8, "saturation", new Range(valueOf2, valueOf3));
        Vividness = new BaseAdjustType("Vividness", 9, 9, "vividness", new Range(valueOf2, valueOf3));
        Level = new BaseAdjustType("Level", 10, 10, "level", new Range(valueOf2, valueOf3));
        Sharpen = new BaseAdjustType("Sharpen", 11, 11, "distinct", new Range(valueOf, valueOf3));
        DarkCorner = new BaseAdjustType("DarkCorner", 12, 12, "", new Range(valueOf2, valueOf3));
        CenterLight = new BaseAdjustType("CenterLight", 13, 13, "center_intensity", new Range(valueOf, valueOf3));
        Fade = new BaseAdjustType("Fade", 14, 15, "fade", new Range(valueOf, valueOf3));
        Grain = new BaseAdjustType("Grain", 15, 16, "noise_intensity", new Range(valueOf, valueOf3));
        DarkCornerNew = new BaseAdjustType("DarkCornerNew", 16, 17, "vignette_intensity", new Range(valueOf2, valueOf3));
        Chromatic = new BaseAdjustType("Chromatic", 17, 18, "chromatic_offset", new Range(valueOf2, valueOf3));
        $VALUES = $values();
    }

    private BaseAdjustType(String str, int i2, int i3, String str2, Range range) {
        this.type = i3;
        this.param = str2;
        this.range = range;
    }

    public static BaseAdjustType valueOf(String str) {
        return (BaseAdjustType) Enum.valueOf(BaseAdjustType.class, str);
    }

    public static BaseAdjustType[] values() {
        return (BaseAdjustType[]) $VALUES.clone();
    }

    public final String getParam() {
        return this.param;
    }

    public final Range<Float> getRange() {
        return this.range;
    }

    public final int getType() {
        return this.type;
    }
}
