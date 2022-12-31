package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbu implements zzdfj<Bundle> {
    private final float zzdut;
    private final int zzdxv;
    private final boolean zzdxw;
    private final boolean zzdxx;
    private final int zzdxy;
    private final int zzdxz;
    private final int zzdya;
    private final boolean zzhbf;

    public zzdbu(int i2, boolean z, boolean z2, int i3, int i4, int i5, float f2, boolean z3) {
        this.zzdxv = i2;
        this.zzdxw = z;
        this.zzdxx = z2;
        this.zzdxy = i3;
        this.zzdxz = i4;
        this.zzdya = i5;
        this.zzdut = f2;
        this.zzhbf = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putInt("am", this.zzdxv);
        bundle2.putBoolean("ma", this.zzdxw);
        bundle2.putBoolean("sp", this.zzdxx);
        bundle2.putInt("muv", this.zzdxy);
        bundle2.putInt("rm", this.zzdxz);
        bundle2.putInt("riv", this.zzdya);
        bundle2.putFloat("android_app_volume", this.zzdut);
        bundle2.putBoolean("android_app_muted", this.zzhbf);
    }
}
