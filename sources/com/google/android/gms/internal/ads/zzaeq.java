package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzaeq extends zzgy implements zzaer {
    public zzaeq() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzaer zzo(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (queryLocalInterface instanceof zzaer) {
            return (zzaer) queryLocalInterface;
        }
        return new zzaet(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            b zzti = zzti();
            parcel2.writeNoException();
            zzgx.zza(parcel2, zzti);
        } else if (i2 == 2) {
            Uri uri = getUri();
            parcel2.writeNoException();
            zzgx.zzb(parcel2, uri);
        } else if (i2 == 3) {
            double scale = getScale();
            parcel2.writeNoException();
            parcel2.writeDouble(scale);
        } else if (i2 == 4) {
            int width = getWidth();
            parcel2.writeNoException();
            parcel2.writeInt(width);
        } else if (i2 != 5) {
            return false;
        } else {
            int height = getHeight();
            parcel2.writeNoException();
            parcel2.writeInt(height);
        }
        return true;
    }
}
