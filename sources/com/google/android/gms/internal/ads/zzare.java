package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzare extends zzgy implements zzarf {
    public zzare() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzarf zzag(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzarf) {
            return (zzarf) queryLocalInterface;
        }
        return new zzarh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzc((Intent) zzgx.zza(parcel, Intent.CREATOR));
        } else if (i2 == 2) {
            zzc(b.a.x0(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
        } else if (i2 != 3) {
            return false;
        } else {
            zzvt();
        }
        parcel2.writeNoException();
        return true;
    }
}
