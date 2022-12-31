package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDetail.kt */
/* loaded from: classes6.dex */
public final class CutoutFilter implements NoProguard {
    private final String adjustableLut;
    private final String fixedLut;

    public CutoutFilter(String str, String str2) {
        this.fixedLut = str;
        this.adjustableLut = str2;
    }

    public static /* synthetic */ CutoutFilter copy$default(CutoutFilter cutoutFilter, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cutoutFilter.fixedLut;
        }
        if ((i2 & 2) != 0) {
            str2 = cutoutFilter.adjustableLut;
        }
        return cutoutFilter.copy(str, str2);
    }

    public final String component1() {
        return this.fixedLut;
    }

    public final String component2() {
        return this.adjustableLut;
    }

    public final CutoutFilter copy(String str, String str2) {
        return new CutoutFilter(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CutoutFilter) {
            CutoutFilter cutoutFilter = (CutoutFilter) obj;
            return s.c(this.fixedLut, cutoutFilter.fixedLut) && s.c(this.adjustableLut, cutoutFilter.adjustableLut);
        }
        return false;
    }

    public final String getAdjustableLut() {
        return this.adjustableLut;
    }

    public final String getFixedLut() {
        return this.fixedLut;
    }

    public int hashCode() {
        String str = this.fixedLut;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.adjustableLut;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CutoutFilter(fixedLut=" + ((Object) this.fixedLut) + ", adjustableLut=" + ((Object) this.adjustableLut) + ')';
    }
}
