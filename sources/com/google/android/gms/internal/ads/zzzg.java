package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzzg extends zzgy implements zzzd {
    public zzzg() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            onVideoStart();
        } else if (i2 == 2) {
            onVideoPlay();
        } else if (i2 == 3) {
            onVideoPause();
        } else if (i2 == 4) {
            onVideoEnd();
        } else if (i2 != 5) {
            return false;
        } else {
            onVideoMute(zzgx.zza(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
