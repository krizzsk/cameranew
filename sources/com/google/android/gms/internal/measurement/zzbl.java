package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
final class zzbl extends zzbg {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzbq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbl(zzbq zzbqVar, Activity activity) {
        super(zzbqVar.zza, true);
        this.zzb = zzbqVar;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        zzp zzpVar;
        zzpVar = this.zzb.zza.zzk;
        zzpVar.onActivityResumed(d.z0(this.zza), this.zzi);
    }
}
