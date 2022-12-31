package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class CutoutSketch implements NoProguard {
    private final String overlayMode;
    private final String sketchcolor;
    private final Float sketchsize;
    private final String sketchstyle;

    public CutoutSketch(String str, String str2, Float f2, String overlayMode) {
        s.h(overlayMode, "overlayMode");
        this.sketchstyle = str;
        this.sketchcolor = str2;
        this.sketchsize = f2;
        this.overlayMode = overlayMode;
    }

    public static /* synthetic */ CutoutSketch copy$default(CutoutSketch cutoutSketch, String str, String str2, Float f2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cutoutSketch.sketchstyle;
        }
        if ((i2 & 2) != 0) {
            str2 = cutoutSketch.sketchcolor;
        }
        if ((i2 & 4) != 0) {
            f2 = cutoutSketch.sketchsize;
        }
        if ((i2 & 8) != 0) {
            str3 = cutoutSketch.overlayMode;
        }
        return cutoutSketch.copy(str, str2, f2, str3);
    }

    public final String component1() {
        return this.sketchstyle;
    }

    public final String component2() {
        return this.sketchcolor;
    }

    public final Float component3() {
        return this.sketchsize;
    }

    public final String component4() {
        return this.overlayMode;
    }

    public final CutoutSketch copy(String str, String str2, Float f2, String overlayMode) {
        s.h(overlayMode, "overlayMode");
        return new CutoutSketch(str, str2, f2, overlayMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CutoutSketch) {
            CutoutSketch cutoutSketch = (CutoutSketch) obj;
            return s.c(this.sketchstyle, cutoutSketch.sketchstyle) && s.c(this.sketchcolor, cutoutSketch.sketchcolor) && s.c(this.sketchsize, cutoutSketch.sketchsize) && s.c(this.overlayMode, cutoutSketch.overlayMode);
        }
        return false;
    }

    public final String getOverlayMode() {
        return this.overlayMode;
    }

    public final String getSketchcolor() {
        return this.sketchcolor;
    }

    public final Float getSketchsize() {
        return this.sketchsize;
    }

    public final String getSketchstyle() {
        return this.sketchstyle;
    }

    public int hashCode() {
        String str = this.sketchstyle;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sketchcolor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f2 = this.sketchsize;
        return ((hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 31) + this.overlayMode.hashCode();
    }

    public String toString() {
        return "CutoutSketch(sketchstyle=" + ((Object) this.sketchstyle) + ", sketchcolor=" + ((Object) this.sketchcolor) + ", sketchsize=" + this.sketchsize + ", overlayMode=" + this.overlayMode + ')';
    }
}
