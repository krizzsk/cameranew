package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzauq extends zzgy implements zzaur {
    public zzauq() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzaur zzan(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        if (queryLocalInterface instanceof zzaur) {
            return (zzaur) queryLocalInterface;
        }
        return new zzaut(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zza((zzava) zzgx.zza(parcel, zzava.CREATOR));
            parcel2.writeNoException();
        } else if (i2 != 2) {
            zzauu zzauuVar = null;
            zzaup zzaupVar = null;
            if (i2 == 3) {
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    if (queryLocalInterface instanceof zzauu) {
                        zzauuVar = (zzauu) queryLocalInterface;
                    } else {
                        zzauuVar = new zzauw(readStrongBinder);
                    }
                }
                zza(zzauuVar);
                parcel2.writeNoException();
            } else if (i2 != 34) {
                switch (i2) {
                    case 5:
                        boolean isLoaded = isLoaded();
                        parcel2.writeNoException();
                        zzgx.writeBoolean(parcel2, isLoaded);
                        break;
                    case 6:
                        pause();
                        parcel2.writeNoException();
                        break;
                    case 7:
                        resume();
                        parcel2.writeNoException();
                        break;
                    case 8:
                        destroy();
                        parcel2.writeNoException();
                        break;
                    case 9:
                        zzj(b.a.x0(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 10:
                        zzk(b.a.x0(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 11:
                        zzl(b.a.x0(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 12:
                        String mediationAdapterClassName = getMediationAdapterClassName();
                        parcel2.writeNoException();
                        parcel2.writeString(mediationAdapterClassName);
                        break;
                    case 13:
                        setUserId(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 14:
                        zza(zzxr.zzd(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 15:
                        Bundle adMetadata = getAdMetadata();
                        parcel2.writeNoException();
                        zzgx.zzb(parcel2, adMetadata);
                        break;
                    case 16:
                        IBinder readStrongBinder2 = parcel.readStrongBinder();
                        if (readStrongBinder2 != null) {
                            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                            if (queryLocalInterface2 instanceof zzaup) {
                                zzaupVar = (zzaup) queryLocalInterface2;
                            } else {
                                zzaupVar = new zzauo(readStrongBinder2);
                            }
                        }
                        zza(zzaupVar);
                        parcel2.writeNoException();
                        break;
                    case 17:
                        setAppPackageName(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 18:
                        zzi(b.a.x0(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        break;
                    case 19:
                        setCustomData(parcel.readString());
                        parcel2.writeNoException();
                        break;
                    case 20:
                        boolean zzrw = zzrw();
                        parcel2.writeNoException();
                        zzgx.writeBoolean(parcel2, zzrw);
                        break;
                    case 21:
                        zzyx zzki = zzki();
                        parcel2.writeNoException();
                        zzgx.zza(parcel2, zzki);
                        break;
                    default:
                        return false;
                }
            } else {
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
            }
        } else {
            show();
            parcel2.writeNoException();
        }
        return true;
    }
}
