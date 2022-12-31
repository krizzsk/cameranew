package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzatn extends zzgy implements zzatk {
    public zzatn() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzb((ParcelFileDescriptor) zzgx.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            zza((com.google.android.gms.ads.internal.util.zzaq) zzgx.zza(parcel, com.google.android.gms.ads.internal.util.zzaq.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
