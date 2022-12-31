package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzye extends zzgy implements zzyb {
    public zzye() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzb((zzvg) zzgx.zza(parcel, zzvg.CREATOR));
        } else if (i2 == 2) {
            onAdShowedFullScreenContent();
        } else if (i2 != 3) {
            return false;
        } else {
            onAdDismissedFullScreenContent();
        }
        parcel2.writeNoException();
        return true;
    }
}
