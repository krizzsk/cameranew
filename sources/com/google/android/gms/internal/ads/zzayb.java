package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzayb extends zzgy implements zzaxy {
    public zzayb() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzaxy zzas(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        if (queryLocalInterface instanceof zzaxy) {
            return (zzaxy) queryLocalInterface;
        }
        return new zzaya(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzaxx zzaxzVar;
        switch (i2) {
            case 1:
                b x0 = b.a.x0(parcel.readStrongBinder());
                zzaye zzayeVar = (zzaye) zzgx.zza(parcel, zzaye.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaxzVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    if (queryLocalInterface instanceof zzaxx) {
                        zzaxzVar = (zzaxx) queryLocalInterface;
                    } else {
                        zzaxzVar = new zzaxz(readStrongBinder);
                    }
                }
                zza(x0, zzayeVar, zzaxzVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzan(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                b zzb = zzb(b.a.x0(parcel.readStrongBinder()), b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzb);
                return true;
            case 4:
                b zzao = zzao(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzao);
                return true;
            case 5:
                zza(parcel.createTypedArrayList(Uri.CREATOR), b.a.x0(parcel.readStrongBinder()), zzasi.zzam(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                zzb(parcel.createTypedArrayList(Uri.CREATOR), b.a.x0(parcel.readStrongBinder()), zzasi.zzam(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                zza((zzasq) zzgx.zza(parcel, zzasq.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
