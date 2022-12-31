package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcmr implements zzeqb<PackageInfo> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<ApplicationInfo> zzgoa;

    private zzcmr(zzeqo<Context> zzeqoVar, zzeqo<ApplicationInfo> zzeqoVar2) {
        this.zzewk = zzeqoVar;
        this.zzgoa = zzeqoVar2;
    }

    public static zzcmr zzak(zzeqo<Context> zzeqoVar, zzeqo<ApplicationInfo> zzeqoVar2) {
        return new zzcmr(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    @Nullable
    public final /* synthetic */ Object get() {
        return zzcmh.zza(this.zzewk.get(), this.zzgoa.get());
    }
}
