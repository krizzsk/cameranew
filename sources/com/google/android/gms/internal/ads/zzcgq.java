package com.google.android.gms.internal.ads;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgq implements zzdzl<zzbeb> {
    private final /* synthetic */ String zzgjd;
    private final /* synthetic */ Map zzgje;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcgq(zzcgk zzcgkVar, String str, Map map) {
        this.zzgjd = str;
        this.zzgje = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(zzbeb zzbebVar) {
        zzbebVar.zza(this.zzgjd, this.zzgje);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
    }
}
