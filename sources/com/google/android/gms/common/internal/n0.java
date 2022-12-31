package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.common.zzb;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class n0 extends zzb implements m0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.m0
    public final com.google.android.gms.dynamic.b zzb() throws RemoteException {
        Parcel zza = zza(1, a_());
        com.google.android.gms.dynamic.b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.common.internal.m0
    public final int zzc() throws RemoteException {
        Parcel zza = zza(2, a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
