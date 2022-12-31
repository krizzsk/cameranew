package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzt extends zza implements zzv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zzd(String str, String str2, Bundle bundle, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zza.writeLong(j2);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final int zze() throws RemoteException {
        Parcel zzz = zzz(2, zza());
        int readInt = zzz.readInt();
        zzz.recycle();
        return readInt;
    }
}
