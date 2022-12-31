package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzd;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public interface l extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public static abstract class a extends zza implements l {
        public a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.google.android.gms.internal.common.zza
        protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                u(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
            } else if (i2 == 2) {
                X(parcel.readInt(), (Bundle) zzd.zza(parcel, Bundle.CREATOR));
            } else if (i2 != 3) {
                return false;
            } else {
                A(parcel.readInt(), parcel.readStrongBinder(), (zzc) zzd.zza(parcel, zzc.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void A(int i2, IBinder iBinder, zzc zzcVar) throws RemoteException;

    void X(int i2, Bundle bundle) throws RemoteException;

    void u(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;
}
