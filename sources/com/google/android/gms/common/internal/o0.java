package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzd;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public abstract class o0 extends zza implements m0 {
    public o0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static m0 x0(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof m0) {
            return (m0) queryLocalInterface;
        }
        return new n0(iBinder);
    }

    @Override // com.google.android.gms.internal.common.zza
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            com.google.android.gms.dynamic.b zzb = zzb();
            parcel2.writeNoException();
            zzd.zza(parcel2, zzb);
        } else if (i2 != 2) {
            return false;
        } else {
            int zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(zzc);
        }
        return true;
    }
}
