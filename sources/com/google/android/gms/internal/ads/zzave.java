package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzave extends zzgy implements zzavf {
    public zzave() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public static zzavf zzap(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (queryLocalInterface instanceof zzavf) {
            return (zzavf) queryLocalInterface;
        }
        return new zzavh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                zzaf(b.a.x0(parcel.readStrongBinder()));
                break;
            case 2:
                zzd(b.a.x0(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zzag(b.a.x0(parcel.readStrongBinder()));
                break;
            case 4:
                zzah(b.a.x0(parcel.readStrongBinder()));
                break;
            case 5:
                zzai(b.a.x0(parcel.readStrongBinder()));
                break;
            case 6:
                zzaj(b.a.x0(parcel.readStrongBinder()));
                break;
            case 7:
                zza(b.a.x0(parcel.readStrongBinder()), (zzavj) zzgx.zza(parcel, zzavj.CREATOR));
                break;
            case 8:
                zzak(b.a.x0(parcel.readStrongBinder()));
                break;
            case 9:
                zze(b.a.x0(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zzal(b.a.x0(parcel.readStrongBinder()));
                break;
            case 11:
                zzam(b.a.x0(parcel.readStrongBinder()));
                break;
            case 12:
                zzb((Bundle) zzgx.zza(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
