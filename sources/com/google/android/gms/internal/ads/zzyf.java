package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzyf extends zzgy implements zzyg {
    public zzyf() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                initialize();
                parcel2.writeNoException();
                return true;
            case 2:
                setAppVolume(parcel.readFloat());
                parcel2.writeNoException();
                return true;
            case 3:
                zzcd(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 4:
                setAppMuted(zzgx.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 5:
                zzb(b.a.x0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zza(parcel.readString(), b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 7:
                float zzra = zzra();
                parcel2.writeNoException();
                parcel2.writeFloat(zzra);
                return true;
            case 8:
                boolean zzrb = zzrb();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, zzrb);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzce(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                zza(zzanh.zzac(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zza(zzajn.zzaa(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                List<zzajh> zzrc = zzrc();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzrc);
                return true;
            case 14:
                zza((zzaao) zzgx.zza(parcel, zzaao.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzrd();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
