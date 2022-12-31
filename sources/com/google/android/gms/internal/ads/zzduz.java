package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzduz extends Exception {
    private final int zzhus;

    public zzduz(int i2, String str) {
        super(str);
        this.zzhus = i2;
    }

    public final int zzayu() {
        return this.zzhus;
    }

    public zzduz(int i2, Throwable th) {
        super(th);
        this.zzhus = i2;
    }
}
