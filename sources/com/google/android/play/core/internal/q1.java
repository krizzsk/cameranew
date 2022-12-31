package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public class q1 implements IInterface {
    private final IBinder a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public q1(IBinder iBinder, String str) {
        this.a = iBinder;
        this.b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel x0() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y0(int i2, Parcel parcel) throws RemoteException {
        try {
            this.a.transact(i2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
