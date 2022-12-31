package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzavp extends zzgy implements zzavm {
    public zzavp() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzavm zzar(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        if (queryLocalInterface instanceof zzavm) {
            return (zzavm) queryLocalInterface;
        }
        return new zzavo(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzavu zzavuVar = null;
        zzavu zzavuVar2 = null;
        zzavz zzavzVar = null;
        zzavr zzavrVar = null;
        switch (i2) {
            case 1:
                zzvl zzvlVar = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface instanceof zzavu) {
                        zzavuVar = (zzavu) queryLocalInterface;
                    } else {
                        zzavuVar = new zzavw(readStrongBinder);
                    }
                }
                zza(zzvlVar, zzavuVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    if (queryLocalInterface2 instanceof zzavr) {
                        zzavrVar = (zzavr) queryLocalInterface2;
                    } else {
                        zzavrVar = new zzavt(readStrongBinder2);
                    }
                }
                zza(zzavrVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean isLoaded = isLoaded();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, isLoaded);
                return true;
            case 4:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 5:
                zze(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    if (queryLocalInterface3 instanceof zzavz) {
                        zzavzVar = (zzavz) queryLocalInterface3;
                    } else {
                        zzavzVar = new zzavy(readStrongBinder3);
                    }
                }
                zza(zzavzVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzawh) zzgx.zza(parcel, zzawh.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                zza(zzyu.zzh(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle adMetadata = getAdMetadata();
                parcel2.writeNoException();
                zzgx.zzb(parcel2, adMetadata);
                return true;
            case 10:
                zza(b.a.x0(parcel.readStrongBinder()), zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                zzavl zzrv = zzrv();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzrv);
                return true;
            case 12:
                zzyx zzki = zzki();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzki);
                return true;
            case 13:
                zza(zzyv.zzi(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 14:
                zzvl zzvlVar2 = (zzvl) zzgx.zza(parcel, zzvl.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    if (queryLocalInterface4 instanceof zzavu) {
                        zzavuVar2 = (zzavu) queryLocalInterface4;
                    } else {
                        zzavuVar2 = new zzavw(readStrongBinder4);
                    }
                }
                zzb(zzvlVar2, zzavuVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                setImmersiveMode(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
