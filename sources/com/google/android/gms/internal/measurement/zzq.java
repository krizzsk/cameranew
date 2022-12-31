package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzq extends zza implements zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc(1, zza);
    }
}
