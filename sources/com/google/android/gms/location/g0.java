package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;
/* loaded from: classes2.dex */
public abstract class g0 extends zzb implements f0 {
    public g0() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static f0 zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof f0 ? (f0) queryLocalInterface : new h0(iBinder);
    }

    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            onLocationResult((LocationResult) zzc.zza(parcel, LocationResult.CREATOR));
        } else if (i2 != 2) {
            return false;
        } else {
            onLocationAvailability((LocationAvailability) zzc.zza(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
