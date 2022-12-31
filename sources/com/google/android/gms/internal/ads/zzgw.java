package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-base@@19.7.0 */
/* loaded from: classes2.dex */
public class zzgw implements IInterface {
    private final IBinder zzacj;
    private final String zzack;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgw(IBinder iBinder, String str) {
        this.zzacj = iBinder;
        this.zzack = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzacj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel zza(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zzacj.transact(i2, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e2) {
                obtain.recycle();
                throw e2;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(int i2, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzacj.transact(i2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc(int i2, Parcel parcel) throws RemoteException {
        try {
            this.zzacj.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel zzdo() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzack);
        return obtain;
    }
}
