package com.google.android.gms.maps.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
/* loaded from: classes2.dex */
public abstract class j extends zzb implements i {
    public j() {
        super("com.google.android.gms.maps.internal.IOnMapReadyCallback");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        b uVar;
        if (i2 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                uVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                if (queryLocalInterface instanceof b) {
                    uVar = (b) queryLocalInterface;
                } else {
                    uVar = new u(readStrongBinder);
                }
            }
            r0(uVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
