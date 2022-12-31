package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzaxw extends zzgy implements zzaxx {
    public zzaxw() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzj(parcel.readString(), parcel.readString());
        } else if (i2 == 2) {
            onError(parcel.readString());
        } else if (i2 != 3) {
            return false;
        } else {
            zza(parcel.readString(), parcel.readString(), (Bundle) zzgx.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
