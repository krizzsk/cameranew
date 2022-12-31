package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
final class zzbo extends zzbg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzm zzb;
    final /* synthetic */ zzbq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbo(zzbq zzbqVar, Activity activity, zzm zzmVar) {
        super(zzbqVar.zza, true);
        this.zzc = zzbqVar;
        this.zza = activity;
        this.zzb = zzmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        zzp zzpVar;
        zzpVar = this.zzc.zza.zzk;
        zzpVar.onActivitySaveInstanceState(d.z0(this.zza), this.zzb, this.zzi);
    }
}
