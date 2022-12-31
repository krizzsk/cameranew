package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzaf extends zzbg {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzbr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaf(zzbr zzbrVar, Boolean bool) {
        super(zzbrVar, true);
        this.zzb = zzbrVar;
        this.zza = bool;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        zzp zzpVar;
        zzp zzpVar2;
        if (this.zza != null) {
            zzpVar2 = this.zzb.zzk;
            zzpVar2.setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
            return;
        }
        zzpVar = this.zzb.zzk;
        zzpVar.clearMeasurementEnabled(this.zzh);
    }
}
