package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzyq extends zzgy implements zzyn {
    public zzyq() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzyn zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (queryLocalInterface instanceof zzyn) {
            return (zzyn) queryLocalInterface;
        }
        return new zzyp(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String description = getDescription();
            parcel2.writeNoException();
            parcel2.writeString(description);
        } else if (i2 != 2) {
            return false;
        } else {
            String zzre = zzre();
            parcel2.writeNoException();
            parcel2.writeString(zzre);
        }
        return true;
    }
}
