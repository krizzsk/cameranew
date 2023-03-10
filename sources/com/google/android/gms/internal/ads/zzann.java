package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzann extends zzgy implements zzank {
    public zzann() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzank zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (queryLocalInterface instanceof zzank) {
            return (zzank) queryLocalInterface;
        }
        return new zzanm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzanp zzanoVar;
        switch (i2) {
            case 1:
                onAdClicked();
                break;
            case 2:
                onAdClosed();
                break;
            case 3:
                onAdFailedToLoad(parcel.readInt());
                break;
            case 4:
                onAdLeftApplication();
                break;
            case 5:
                onAdOpened();
                break;
            case 6:
                onAdLoaded();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzanoVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzanp) {
                        zzanoVar = (zzanp) queryLocalInterface;
                    } else {
                        zzanoVar = new zzano(readStrongBinder);
                    }
                }
                zza(zzanoVar);
                break;
            case 8:
                onAdImpression();
                break;
            case 9:
                onAppEvent(parcel.readString(), parcel.readString());
                break;
            case 10:
                zza(zzafm.zzr(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                onVideoEnd();
                break;
            case 12:
                zzdi(parcel.readString());
                break;
            case 13:
                zzve();
                break;
            case 14:
                zzb((zzavj) zzgx.zza(parcel, zzavj.CREATOR));
                break;
            case 15:
                onVideoPause();
                break;
            case 16:
                zza(zzavk.zzaq(parcel.readStrongBinder()));
                break;
            case 17:
                zzdb(parcel.readInt());
                break;
            case 18:
                zzvf();
                break;
            case 19:
                zzb((Bundle) zzgx.zza(parcel, Bundle.CREATOR));
                break;
            case 20:
                onVideoPlay();
                break;
            case 21:
                zzdj(parcel.readString());
                break;
            case 22:
                zzc(parcel.readInt(), parcel.readString());
                break;
            case 23:
                zzd((zzvg) zzgx.zza(parcel, zzvg.CREATOR));
                break;
            case 24:
                zzf((zzvg) zzgx.zza(parcel, zzvg.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
