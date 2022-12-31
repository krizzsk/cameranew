package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class Cutout implements NoProguard {
    private final int autocutout;
    private final CutoutFilter filter;
    private final String layer_effect_type;
    private final CutoutSketch sketch;

    public Cutout(int i2, String layer_effect_type, CutoutSketch sketch, CutoutFilter cutoutFilter) {
        s.h(layer_effect_type, "layer_effect_type");
        s.h(sketch, "sketch");
        this.autocutout = i2;
        this.layer_effect_type = layer_effect_type;
        this.sketch = sketch;
        this.filter = cutoutFilter;
    }

    public static /* synthetic */ Cutout copy$default(Cutout cutout, int i2, String str, CutoutSketch cutoutSketch, CutoutFilter cutoutFilter, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = cutout.autocutout;
        }
        if ((i3 & 2) != 0) {
            str = cutout.layer_effect_type;
        }
        if ((i3 & 4) != 0) {
            cutoutSketch = cutout.sketch;
        }
        if ((i3 & 8) != 0) {
            cutoutFilter = cutout.filter;
        }
        return cutout.copy(i2, str, cutoutSketch, cutoutFilter);
    }

    public final int component1() {
        return this.autocutout;
    }

    public final String component2() {
        return this.layer_effect_type;
    }

    public final CutoutSketch component3() {
        return this.sketch;
    }

    public final CutoutFilter component4() {
        return this.filter;
    }

    public final Cutout copy(int i2, String layer_effect_type, CutoutSketch sketch, CutoutFilter cutoutFilter) {
        s.h(layer_effect_type, "layer_effect_type");
        s.h(sketch, "sketch");
        return new Cutout(i2, layer_effect_type, sketch, cutoutFilter);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cutout) {
            Cutout cutout = (Cutout) obj;
            return this.autocutout == cutout.autocutout && s.c(this.layer_effect_type, cutout.layer_effect_type) && s.c(this.sketch, cutout.sketch) && s.c(this.filter, cutout.filter);
        }
        return false;
    }

    public final int getAutocutout() {
        return this.autocutout;
    }

    public final CutoutFilter getFilter() {
        return this.filter;
    }

    public final String getLayer_effect_type() {
        return this.layer_effect_type;
    }

    public final CutoutSketch getSketch() {
        return this.sketch;
    }

    public int hashCode() {
        int hashCode = ((((this.autocutout * 31) + this.layer_effect_type.hashCode()) * 31) + this.sketch.hashCode()) * 31;
        CutoutFilter cutoutFilter = this.filter;
        return hashCode + (cutoutFilter == null ? 0 : cutoutFilter.hashCode());
    }

    public String toString() {
        return "Cutout(autocutout=" + this.autocutout + ", layer_effect_type=" + this.layer_effect_type + ", sketch=" + this.sketch + ", filter=" + this.filter + ')';
    }
}
