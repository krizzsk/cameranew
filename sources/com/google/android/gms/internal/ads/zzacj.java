package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzacj extends zzgy implements zzacg {
    public zzacj() {
        super("com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String zzsq = zzsq();
            parcel2.writeNoException();
            parcel2.writeString(zzsq);
        } else if (i2 == 2) {
            String content = getContent();
            parcel2.writeNoException();
            parcel2.writeString(content);
        } else if (i2 == 3) {
            zzn(b.a.x0(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i2 == 4) {
            recordClick();
            parcel2.writeNoException();
        } else if (i2 != 5) {
            return false;
        } else {
            recordImpression();
            parcel2.writeNoException();
        }
        return true;
    }
}
