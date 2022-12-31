package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzaei extends zzgy implements zzaej {
    public zzaei() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzaej zzm(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (queryLocalInterface instanceof zzaej) {
            return (zzaej) queryLocalInterface;
        }
        return new zzael(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 2) {
            String text = getText();
            parcel2.writeNoException();
            parcel2.writeString(text);
            return true;
        } else if (i2 != 3) {
            return false;
        } else {
            List<zzaer> zztd = zztd();
            parcel2.writeNoException();
            parcel2.writeList(zztd);
            return true;
        }
    }
}
