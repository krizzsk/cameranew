package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzavq extends zzgy implements zzavr {
    public zzavq() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzavl zzavnVar;
        if (i2 == 1) {
            onRewardedAdOpened();
        } else if (i2 == 2) {
            onRewardedAdClosed();
        } else if (i2 == 3) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzavnVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                if (queryLocalInterface instanceof zzavl) {
                    zzavnVar = (zzavl) queryLocalInterface;
                } else {
                    zzavnVar = new zzavn(readStrongBinder);
                }
            }
            zza(zzavnVar);
        } else if (i2 == 4) {
            onRewardedAdFailedToShow(parcel.readInt());
        } else if (i2 != 5) {
            return false;
        } else {
            zzi((zzvg) zzgx.zza(parcel, zzvg.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
