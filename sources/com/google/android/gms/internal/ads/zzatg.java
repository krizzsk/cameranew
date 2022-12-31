package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzatg extends zzgy implements zzath {
    public zzatg() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            zzati zzatiVar = null;
            zzatk zzatkVar = null;
            zzatk zzatkVar2 = null;
            zzatk zzatkVar3 = null;
            zzatk zzatkVar4 = null;
            if (i2 == 2) {
                zzatb zzatbVar = (zzatb) zzgx.zza(parcel, zzatb.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzati) {
                        zzatiVar = (zzati) queryLocalInterface;
                    } else {
                        zzatiVar = new zzatl(readStrongBinder);
                    }
                }
                zza(zzatbVar, zzatiVar);
                parcel2.writeNoException();
            } else if (i2 == 4) {
                zzatq zzatqVar = (zzatq) zzgx.zza(parcel, zzatq.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzatk) {
                        zzatkVar4 = (zzatk) queryLocalInterface2;
                    } else {
                        zzatkVar4 = new zzatm(readStrongBinder2);
                    }
                }
                zza(zzatqVar, zzatkVar4);
                parcel2.writeNoException();
            } else if (i2 == 5) {
                zzatq zzatqVar2 = (zzatq) zzgx.zza(parcel, zzatq.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzatk) {
                        zzatkVar3 = (zzatk) queryLocalInterface3;
                    } else {
                        zzatkVar3 = new zzatm(readStrongBinder3);
                    }
                }
                zzb(zzatqVar2, zzatkVar3);
                parcel2.writeNoException();
            } else if (i2 == 6) {
                zzatq zzatqVar3 = (zzatq) zzgx.zza(parcel, zzatq.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface4 instanceof zzatk) {
                        zzatkVar2 = (zzatk) queryLocalInterface4;
                    } else {
                        zzatkVar2 = new zzatm(readStrongBinder4);
                    }
                }
                zzc(zzatqVar3, zzatkVar2);
                parcel2.writeNoException();
            } else if (i2 != 7) {
                return false;
            } else {
                String readString = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface5 instanceof zzatk) {
                        zzatkVar = (zzatk) queryLocalInterface5;
                    } else {
                        zzatkVar = new zzatm(readStrongBinder5);
                    }
                }
                zza(readString, zzatkVar);
                parcel2.writeNoException();
            }
        } else {
            zzatd zza = zza((zzatb) zzgx.zza(parcel, zzatb.CREATOR));
            parcel2.writeNoException();
            zzgx.zzb(parcel2, zza);
        }
        return true;
    }
}
