package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: Blur.kt */
/* loaded from: classes6.dex */
public final class Adjustment {
    private Float corrosion;
    private Float halo;
    private Float highlight;
    private Float radial;
    private Float size;
    private Float swirly;
    private Float vivid;

    public Adjustment(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8) {
        this.size = f2;
        this.corrosion = f3;
        this.swirly = f4;
        this.radial = f5;
        this.highlight = f6;
        this.vivid = f7;
        this.halo = f8;
    }

    public static /* synthetic */ Adjustment copy$default(Adjustment adjustment, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = adjustment.size;
        }
        if ((i2 & 2) != 0) {
            f3 = adjustment.corrosion;
        }
        Float f9 = f3;
        if ((i2 & 4) != 0) {
            f4 = adjustment.swirly;
        }
        Float f10 = f4;
        if ((i2 & 8) != 0) {
            f5 = adjustment.radial;
        }
        Float f11 = f5;
        if ((i2 & 16) != 0) {
            f6 = adjustment.highlight;
        }
        Float f12 = f6;
        if ((i2 & 32) != 0) {
            f7 = adjustment.vivid;
        }
        Float f13 = f7;
        if ((i2 & 64) != 0) {
            f8 = adjustment.halo;
        }
        return adjustment.copy(f2, f9, f10, f11, f12, f13, f8);
    }

    public final Float component1() {
        return this.size;
    }

    public final Float component2() {
        return this.corrosion;
    }

    public final Float component3() {
        return this.swirly;
    }

    public final Float component4() {
        return this.radial;
    }

    public final Float component5() {
        return this.highlight;
    }

    public final Float component6() {
        return this.vivid;
    }

    public final Float component7() {
        return this.halo;
    }

    public final Adjustment copy(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8) {
        return new Adjustment(f2, f3, f4, f5, f6, f7, f8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Adjustment) {
            Adjustment adjustment = (Adjustment) obj;
            return s.c(this.size, adjustment.size) && s.c(this.corrosion, adjustment.corrosion) && s.c(this.swirly, adjustment.swirly) && s.c(this.radial, adjustment.radial) && s.c(this.highlight, adjustment.highlight) && s.c(this.vivid, adjustment.vivid) && s.c(this.halo, adjustment.halo);
        }
        return false;
    }

    public final Float getCorrosion() {
        return this.corrosion;
    }

    public final Float getHalo() {
        return this.halo;
    }

    public final Float getHighlight() {
        return this.highlight;
    }

    public final Float getRadial() {
        return this.radial;
    }

    public final Float getSize() {
        return this.size;
    }

    public final Float getSwirly() {
        return this.swirly;
    }

    public final Float getVivid() {
        return this.vivid;
    }

    public int hashCode() {
        Float f2 = this.size;
        int hashCode = (f2 == null ? 0 : f2.hashCode()) * 31;
        Float f3 = this.corrosion;
        int hashCode2 = (hashCode + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.swirly;
        int hashCode3 = (hashCode2 + (f4 == null ? 0 : f4.hashCode())) * 31;
        Float f5 = this.radial;
        int hashCode4 = (hashCode3 + (f5 == null ? 0 : f5.hashCode())) * 31;
        Float f6 = this.highlight;
        int hashCode5 = (hashCode4 + (f6 == null ? 0 : f6.hashCode())) * 31;
        Float f7 = this.vivid;
        int hashCode6 = (hashCode5 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Float f8 = this.halo;
        return hashCode6 + (f8 != null ? f8.hashCode() : 0);
    }

    public final void setCorrosion(Float f2) {
        this.corrosion = f2;
    }

    public final void setHalo(Float f2) {
        this.halo = f2;
    }

    public final void setHighlight(Float f2) {
        this.highlight = f2;
    }

    public final void setRadial(Float f2) {
        this.radial = f2;
    }

    public final void setSize(Float f2) {
        this.size = f2;
    }

    public final void setSwirly(Float f2) {
        this.swirly = f2;
    }

    public final void setVivid(Float f2) {
        this.vivid = f2;
    }

    public String toString() {
        return "Adjustment(size=" + this.size + ", corrosion=" + this.corrosion + ", swirly=" + this.swirly + ", radial=" + this.radial + ", highlight=" + this.highlight + ", vivid=" + this.vivid + ", halo=" + this.halo + ')';
    }
}
