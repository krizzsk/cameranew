package com.google.android.gms.ads.internal.util;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzap extends Exception {
    private final int errorCode;

    public zzap(String str, int i2) {
        super(str);
        this.errorCode = i2;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
