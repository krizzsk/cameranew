package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class z2 extends zzb implements a3 {
    public z2() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzb
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                C((zzas) zzc.zzc(parcel, zzas.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                x((zzkg) zzc.zzc(parcel, zzkg.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                t0((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                d0((zzas) zzc.zzc(parcel, zzas.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                k0((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkg> U = U((zzp) zzc.zzc(parcel, zzp.CREATOR), zzc.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(U);
                return true;
            case 9:
                byte[] e0 = e0((zzas) zzc.zzc(parcel, zzas.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(e0);
                return true;
            case 10:
                S(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String m = m((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(m);
                return true;
            case 12:
                n((zzaa) zzc.zzc(parcel, zzaa.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                s((zzaa) zzc.zzc(parcel, zzaa.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkg> o = o(parcel.readString(), parcel.readString(), zzc.zza(parcel), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(o);
                return true;
            case 15:
                List<zzkg> E = E(parcel.readString(), parcel.readString(), parcel.readString(), zzc.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(E);
                return true;
            case 16:
                List<zzaa> k2 = k(parcel.readString(), parcel.readString(), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(k2);
                return true;
            case 17:
                List<zzaa> p = p(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(p);
                return true;
            case 18:
                W((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 19:
                c0((Bundle) zzc.zzc(parcel, Bundle.CREATOR), (zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
            case 20:
                H((zzp) zzc.zzc(parcel, zzp.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
