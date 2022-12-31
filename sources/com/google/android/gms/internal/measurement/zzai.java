package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzai extends zzbg {
    final /* synthetic */ zzbr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzai(zzbr zzbrVar) {
        super(zzbrVar, true);
        this.zza = zzbrVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        zzp zzpVar;
        zzpVar = this.zza.zzk;
        zzpVar.resetAnalyticsData(this.zzh);
    }
}
