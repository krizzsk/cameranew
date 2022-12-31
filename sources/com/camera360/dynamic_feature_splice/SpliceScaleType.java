package com.camera360.dynamic_feature_splice;
/* compiled from: Splices.kt */
/* loaded from: classes8.dex */
public enum SpliceScaleType {
    FULL(null, "full"),
    S1x1(Float.valueOf(1.0f), "1:1"),
    S3x4(Float.valueOf(0.75f), "3:4"),
    S9x16(Float.valueOf(0.5625f), "9:16");
    
    private final Float scale;
    private final String str;

    SpliceScaleType(Float f2, String str) {
        this.scale = f2;
        this.str = str;
    }

    public final Float getScale() {
        return this.scale;
    }

    public final String getStr() {
        return this.str;
    }
}
