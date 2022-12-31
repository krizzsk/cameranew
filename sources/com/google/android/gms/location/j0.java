package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;
/* loaded from: classes2.dex */
public abstract class j0 extends zzb implements i0 {
    public j0() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static i0 zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof i0 ? (i0) queryLocalInterface : new k0(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            onLocationChanged((Location) zzc.zza(parcel, Location.CREATOR));
            return true;
        }
        return false;
    }
}
