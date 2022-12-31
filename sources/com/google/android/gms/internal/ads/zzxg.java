package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzxg extends zzgy implements zzxd {
    public zzxg() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzb((zzvl) zzgx.zza(parcel, zzvl.CREATOR));
            parcel2.writeNoException();
        } else if (i2 == 2) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i2 == 3) {
            boolean isLoading = isLoading();
            parcel2.writeNoException();
            zzgx.writeBoolean(parcel2, isLoading);
        } else if (i2 == 4) {
            String zzkh = zzkh();
            parcel2.writeNoException();
            parcel2.writeString(zzkh);
        } else if (i2 != 5) {
            return false;
        } else {
            zza((zzvl) zzgx.zza(parcel, zzvl.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
