package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaja implements zzdyu<zzaiz, ParcelFileDescriptor> {
    private final /* synthetic */ zzait zzdiq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaja(zzajb zzajbVar, zzait zzaitVar) {
        this.zzdiq = zzaitVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final /* synthetic */ zzdzw<ParcelFileDescriptor> zzf(zzaiz zzaizVar) throws Exception {
        zzbaa zzbaaVar = new zzbaa();
        zzaizVar.zza(this.zzdiq, new zzajd(this, zzbaaVar));
        return zzbaaVar;
    }
}
