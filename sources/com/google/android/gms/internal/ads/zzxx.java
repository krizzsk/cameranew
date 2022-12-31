package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzxx extends zzgy implements zzxy {
    public zzxx() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                zzxl zza = zza(b.a.x0(parcel.readStrongBinder()), (zzvs) zzgx.zza(parcel, zzvs.CREATOR), parcel.readString(), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zza);
                return true;
            case 2:
                zzxl zzb = zzb(b.a.x0(parcel.readStrongBinder()), (zzvs) zzgx.zza(parcel, zzvs.CREATOR), parcel.readString(), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzb);
                return true;
            case 3:
                zzxi zza2 = zza(b.a.x0(parcel.readStrongBinder()), parcel.readString(), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zza2);
                return true;
            case 4:
                zzyg zzc = zzc(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzc);
                return true;
            case 5:
                zzaev zza3 = zza(b.a.x0(parcel.readStrongBinder()), b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, zza3);
                return true;
            case 6:
                zzaur zza4 = zza(b.a.x0(parcel.readStrongBinder()), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zza4);
                return true;
            case 7:
                zzasd zzd = zzd(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzd);
                return true;
            case 8:
                zzaro zzb2 = zzb(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzb2);
                return true;
            case 9:
                zzyg zza5 = zza(b.a.x0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zza5);
                return true;
            case 10:
                zzxl zza6 = zza(b.a.x0(parcel.readStrongBinder()), (zzvs) zzgx.zza(parcel, zzvs.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zza6);
                return true;
            case 11:
                zzaey zza7 = zza(b.a.x0(parcel.readStrongBinder()), b.a.x0(parcel.readStrongBinder()), b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgx.zza(parcel2, zza7);
                return true;
            case 12:
                zzavm zzb3 = zzb(b.a.x0(parcel.readStrongBinder()), parcel.readString(), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzb3);
                return true;
            case 13:
                zzxl zzc2 = zzc(b.a.x0(parcel.readStrongBinder()), (zzvs) zzgx.zza(parcel, zzvs.CREATOR), parcel.readString(), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzc2);
                return true;
            case 14:
                zzaxy zzb4 = zzb(b.a.x0(parcel.readStrongBinder()), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzb4);
                return true;
            case 15:
                zzarf zzc3 = zzc(b.a.x0(parcel.readStrongBinder()), zzanh.zzac(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgx.zza(parcel2, zzc3);
                return true;
            default:
                return false;
        }
    }
}
