package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzaeu extends zzgy implements zzaev {
    public zzaeu() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzaev zzp(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        if (queryLocalInterface instanceof zzaev) {
            return (zzaev) queryLocalInterface;
        }
        return new zzaex(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzaem zzaeoVar;
        switch (i2) {
            case 1:
                zzb(parcel.readString(), b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 2:
                b zzco = zzco(parcel.readString());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzco);
                return true;
            case 3:
                zza(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                destroy();
                parcel2.writeNoException();
                return true;
            case 5:
                zzc(b.a.x0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 6:
                zzf(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                zzg(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaeoVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
                    if (queryLocalInterface instanceof zzaem) {
                        zzaeoVar = (zzaem) queryLocalInterface;
                    } else {
                        zzaeoVar = new zzaeo(readStrongBinder);
                    }
                }
                zza(zzaeoVar);
                parcel2.writeNoException();
                return true;
            case 9:
                zzh(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
