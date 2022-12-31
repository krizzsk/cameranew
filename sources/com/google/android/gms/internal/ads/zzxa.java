package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzxa extends zzgy implements zzwx {
    public zzxa() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                onAdClosed();
                break;
            case 2:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 3:
                onAdLeftApplication();
                break;
            case 4:
                onAdLoaded();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdClicked();
                break;
            case 7:
                onAdImpression();
                break;
            case 8:
                zzd((zzvg) zzgx.zza(parcel, zzvg.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
