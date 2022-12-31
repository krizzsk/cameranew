package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
/* compiled from: FilterEntry.kt */
/* loaded from: classes6.dex */
public final class SkyParamsRecord {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_MIX = 50;
    public static final int DEFAULT_TEMPERATURE = 50;
    public static final int DEFAULT_TEXTURE = 80;
    public static final int DEFAULT_TRANSPARENT = 50;
    private boolean mirrored;
    private volatile int mix;
    private volatile int temperature;
    private volatile int texture;
    private volatile int transparent;
    private int defaultTransparent = 50;
    private int defaultMix = 50;
    private int defaultTemperature = 50;
    private int defaultTexture = 80;

    /* compiled from: FilterEntry.kt */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public SkyParamsRecord(int i2, int i3, int i4, int i5) {
        this.transparent = i2;
        this.mix = i3;
        this.temperature = i4;
        this.texture = i5;
    }

    public static /* synthetic */ SkyParamsRecord copy$default(SkyParamsRecord skyParamsRecord, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = skyParamsRecord.transparent;
        }
        if ((i6 & 2) != 0) {
            i3 = skyParamsRecord.mix;
        }
        if ((i6 & 4) != 0) {
            i4 = skyParamsRecord.temperature;
        }
        if ((i6 & 8) != 0) {
            i5 = skyParamsRecord.texture;
        }
        return skyParamsRecord.copy(i2, i3, i4, i5);
    }

    public final int component1() {
        return this.transparent;
    }

    public final int component2() {
        return this.mix;
    }

    public final int component3() {
        return this.temperature;
    }

    public final int component4() {
        return this.texture;
    }

    public final SkyParamsRecord copy(int i2, int i3, int i4, int i5) {
        return new SkyParamsRecord(i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkyParamsRecord) {
            SkyParamsRecord skyParamsRecord = (SkyParamsRecord) obj;
            return this.transparent == skyParamsRecord.transparent && this.mix == skyParamsRecord.mix && this.temperature == skyParamsRecord.temperature && this.texture == skyParamsRecord.texture;
        }
        return false;
    }

    public final int getDefaultMix() {
        return this.defaultMix;
    }

    public final int getDefaultTemperature() {
        return this.defaultTemperature;
    }

    public final int getDefaultTexture() {
        return this.defaultTexture;
    }

    public final int getDefaultTransparent() {
        return this.defaultTransparent;
    }

    public final boolean getMirrored() {
        return this.mirrored;
    }

    public final int getMix() {
        return this.mix;
    }

    public final int getTemperature() {
        return this.temperature;
    }

    public final int getTexture() {
        return this.texture;
    }

    public final int getTransparent() {
        return this.transparent;
    }

    public int hashCode() {
        return (((((this.transparent * 31) + this.mix) * 31) + this.temperature) * 31) + this.texture;
    }

    public final boolean isDefault() {
        return this.transparent == this.defaultTransparent && this.mix == this.defaultMix && this.temperature == this.defaultTemperature && this.texture == this.defaultTexture && !this.mirrored;
    }

    public final void setDefaultMix(int i2) {
        this.defaultMix = i2;
    }

    public final void setDefaultTemperature(int i2) {
        this.defaultTemperature = i2;
    }

    public final void setDefaultTexture(int i2) {
        this.defaultTexture = i2;
    }

    public final void setDefaultTransparent(int i2) {
        this.defaultTransparent = i2;
    }

    public final void setMirrored(boolean z) {
        this.mirrored = z;
    }

    public final void setMix(int i2) {
        this.mix = i2;
    }

    public final void setTemperature(int i2) {
        this.temperature = i2;
    }

    public final void setTexture(int i2) {
        this.texture = i2;
    }

    public final void setTransparent(int i2) {
        this.transparent = i2;
    }

    public String toString() {
        return "SkyParamsRecord(transparent=" + this.transparent + ", mix=" + this.mix + ", temperature=" + this.temperature + ", texture=" + this.texture + ')';
    }
}
