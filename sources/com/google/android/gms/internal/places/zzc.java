package com.google.android.gms.internal.places;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public class zzc implements IInterface {
    private final IBinder zzc;
    private final String zzd;

    protected zzc(IBinder iBinder, String str) {
        this.zzc = iBinder;
        this.zzd = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzc;
    }

    protected final Parcel zzb() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzd);
        return obtain;
    }

    protected final void zzb(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzc.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
