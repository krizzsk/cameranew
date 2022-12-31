package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
interface a extends IInterface {

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    /* renamed from: com.google.android.gms.cloudmessaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0133a implements a {
        private final IBinder a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0133a(@NonNull IBinder iBinder) {
            this.a = iBinder;
        }

        @Override // com.google.android.gms.cloudmessaging.a
        public void K(@NonNull Message message) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.a.transact(1, obtain, null, 1);
            } finally {
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        @NonNull
        public IBinder asBinder() {
            return this.a;
        }
    }

    void K(@NonNull Message message) throws RemoteException;
}
