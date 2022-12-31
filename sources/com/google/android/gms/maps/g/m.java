package com.google.android.gms.maps.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
/* loaded from: classes2.dex */
public abstract class m extends zzb implements l {
    public m() {
        super("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        e nVar;
        if (i2 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                nVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                if (queryLocalInterface instanceof e) {
                    nVar = (e) queryLocalInterface;
                } else {
                    nVar = new n(readStrongBinder);
                }
            }
            b0(nVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
