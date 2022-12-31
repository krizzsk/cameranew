package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzatm extends zzgw implements zzatk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zza(com.google.android.gms.ads.internal.util.zzaq zzaqVar) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, zzaqVar);
        zzb(2, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzatk
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, parcelFileDescriptor);
        zzb(1, zzdo);
    }
}
