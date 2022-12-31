package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdkj implements zzdvz<zzcoc, zzdkl> {
    private final /* synthetic */ zzdkh zzhhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdkj(zzdkh zzdkhVar) {
        this.zzhhr = zzdkhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdvz
    @NullableDecl
    public final /* synthetic */ zzdkl apply(@NullableDecl zzcoc zzcocVar) {
        zzdpl zzaut;
        zzdkl zzdklVar;
        zzazk.zzc("", zzcocVar);
        com.google.android.gms.ads.internal.util.zzd.zzeb("Failed to get a cache key, reverting to legacy flow.");
        zzdkh zzdkhVar = this.zzhhr;
        zzaut = zzdkhVar.zzaut();
        zzdkhVar.zzhhq = new zzdkl(null, zzaut, null);
        zzdklVar = this.zzhhr.zzhhq;
        return zzdklVar;
    }
}
