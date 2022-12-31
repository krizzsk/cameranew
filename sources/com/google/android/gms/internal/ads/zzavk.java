package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzavk extends zzgy implements zzavl {
    public zzavk() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public static zzavl zzaq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
        if (queryLocalInterface instanceof zzavl) {
            return (zzavl) queryLocalInterface;
        }
        return new zzavn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String type = getType();
            parcel2.writeNoException();
            parcel2.writeString(type);
        } else if (i2 != 2) {
            return false;
        } else {
            int amount = getAmount();
            parcel2.writeNoException();
            parcel2.writeInt(amount);
        }
        return true;
    }
}
