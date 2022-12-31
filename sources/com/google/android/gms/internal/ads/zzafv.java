package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzafv extends zzgy implements zzafs {
    public zzafv() {
        super("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public static zzafs zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        if (queryLocalInterface instanceof zzafs) {
            return (zzafs) queryLocalInterface;
        }
        return new zzafu(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzafj zzaflVar;
        if (i2 == 1) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzaflVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                if (queryLocalInterface instanceof zzafj) {
                    zzaflVar = (zzafj) queryLocalInterface;
                } else {
                    zzaflVar = new zzafl(readStrongBinder);
                }
            }
            zza(zzaflVar);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
