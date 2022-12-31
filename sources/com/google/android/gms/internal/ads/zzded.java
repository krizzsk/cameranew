package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzded implements zzeqb<zzdea> {
    private final zzeqo<PackageInfo> zzfyt;
    private final zzeqo<ApplicationInfo> zzgoa;

    private zzded(zzeqo<ApplicationInfo> zzeqoVar, zzeqo<PackageInfo> zzeqoVar2) {
        this.zzgoa = zzeqoVar;
        this.zzfyt = zzeqoVar2;
    }

    public static zzdea zza(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        return new zzdea(applicationInfo, packageInfo);
    }

    public static zzded zzax(zzeqo<ApplicationInfo> zzeqoVar, zzeqo<PackageInfo> zzeqoVar2) {
        return new zzded(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzgoa.get(), this.zzfyt.get());
    }
}
