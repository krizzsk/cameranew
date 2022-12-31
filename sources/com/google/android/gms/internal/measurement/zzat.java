package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzat extends zzbg {
    final /* synthetic */ String zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzbr zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzat(zzbr zzbrVar, boolean z, int i2, String str, Object obj, Object obj2, Object obj3) {
        super(zzbrVar, false);
        this.zzc = zzbrVar;
        this.zza = str;
        this.zzb = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzbg
    final void zza() throws RemoteException {
        zzp zzpVar;
        zzpVar = this.zzc.zzk;
        zzpVar.logHealthData(5, this.zza, d.z0(this.zzb), d.z0(null), d.z0(null));
    }
}
