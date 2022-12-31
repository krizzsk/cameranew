package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
/* loaded from: classes.dex */
public interface IListenerManager extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IListenerManager {

        /* loaded from: classes.dex */
        private static class a implements IListenerManager {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void broadcastDialogListener(String str, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void broadcastPermissionListener(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeFullVideoCallback(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void executeRewardVideoCallback(String str, String str2, boolean z, int i2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeString(str3);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iCommonDialogListener != null ? iCommonDialogListener.asBinder() : null);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iFullScreenVideoAdInteractionListener != null ? iFullScreenVideoAdInteractionListener.asBinder() : null);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iCommonPermissionListener != null ? iCommonPermissionListener.asBinder() : null);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IListenerManager
            public void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IListenerManager");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iRewardAdInteractionListener != null ? iRewardAdInteractionListener.asBinder() : null);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IListenerManager");
        }

        public static IListenerManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IListenerManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IListenerManager)) {
                return (IListenerManager) queryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerRewardVideoListener(parcel.readString(), IRewardAdInteractionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        executeRewardVideoCallback(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerFullVideoListener(parcel.readString(), IFullScreenVideoAdInteractionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        executeFullVideoCallback(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerDialogListener(parcel.readString(), ICommonDialogListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        broadcastDialogListener(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        registerPermissionListener(parcel.readString(), ICommonPermissionListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IListenerManager");
                        broadcastPermissionListener(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.IListenerManager");
            return true;
        }
    }

    void broadcastDialogListener(String str, int i2) throws RemoteException;

    void broadcastPermissionListener(String str, String str2) throws RemoteException;

    void executeFullVideoCallback(String str, String str2) throws RemoteException;

    void executeRewardVideoCallback(String str, String str2, boolean z, int i2, String str3) throws RemoteException;

    void registerDialogListener(String str, ICommonDialogListener iCommonDialogListener) throws RemoteException;

    void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException;

    void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException;

    void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException;
}
