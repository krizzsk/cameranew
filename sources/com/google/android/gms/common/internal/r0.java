package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzj;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class r0 extends zzb implements q0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.q0
    public final boolean v0(zzj zzjVar, com.google.android.gms.dynamic.b bVar) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, zzjVar);
        zzd.zza(a_, bVar);
        Parcel zza = zza(5, a_);
        boolean zza2 = zzd.zza(zza);
        zza.recycle();
        return zza2;
    }
}
