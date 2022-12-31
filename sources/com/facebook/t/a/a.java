package com.facebook.t.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: IReceiverService.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: IReceiverService.java */
    /* renamed from: com.facebook.t.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0124a extends Binder implements a {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IReceiverService.java */
        /* renamed from: com.facebook.t.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0125a implements a {
            public static a b;
            private IBinder a;

            C0125a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.facebook.t.a.a
            public int l(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.facebook.ppml.receiver.IReceiverService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, obtain2, 0) && AbstractBinderC0124a.y0() != null) {
                        return AbstractBinderC0124a.y0().l(bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a x0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0125a(iBinder);
        }

        public static a y0() {
            return C0125a.b;
        }
    }

    int l(Bundle bundle) throws RemoteException;
}
