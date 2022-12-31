package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzaw extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ zzm zzb;
    final /* synthetic */ zzbr zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaw(zzbr zzbrVar, String str, zzm zzmVar) {
        super(zzbrVar, true);
        this.zzc = zzbrVar;
        this.zza = str;
        this.zzb = zzmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        zzp zzpVar;
        zzpVar = this.zzc.zzk;
        zzpVar.getMaxUserProperties(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    protected final void zzb() {
        this.zzb.zzb(null);
    }
}
