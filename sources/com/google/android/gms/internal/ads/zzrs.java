package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzrs {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbtz;

    public zzrs(float f2, float f3, float f4, float f5, int i2) {
        this.left = f2;
        this.top = f3;
        this.right = f2 + f4;
        this.bottom = f3 + f5;
        this.zzbtz = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmn() {
        return this.left;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmo() {
        return this.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmp() {
        return this.right;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmq() {
        return this.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzmr() {
        return this.zzbtz;
    }
}
