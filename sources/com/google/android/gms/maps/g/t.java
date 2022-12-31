package com.google.android.gms.maps.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zze;
import com.google.android.gms.internal.maps.zzf;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
/* loaded from: classes2.dex */
public final class t extends zza implements s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICreator");
    }

    @Override // com.google.android.gms.maps.g.s
    public final d O(com.google.android.gms.dynamic.b bVar, GoogleMapOptions googleMapOptions) throws RemoteException {
        d wVar;
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzc.zza(zza, googleMapOptions);
        Parcel zza2 = zza(3, zza);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            wVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            if (queryLocalInterface instanceof d) {
                wVar = (d) queryLocalInterface;
            } else {
                wVar = new w(readStrongBinder);
            }
        }
        zza2.recycle();
        return wVar;
    }

    @Override // com.google.android.gms.maps.g.s
    public final g g0(com.google.android.gms.dynamic.b bVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
        g pVar;
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzc.zza(zza, streetViewPanoramaOptions);
        Parcel zza2 = zza(7, zza);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            pVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
            if (queryLocalInterface instanceof g) {
                pVar = (g) queryLocalInterface;
            } else {
                pVar = new p(readStrongBinder);
            }
        }
        zza2.recycle();
        return pVar;
    }

    @Override // com.google.android.gms.maps.g.s
    public final void zza(com.google.android.gms.dynamic.b bVar, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zza.writeInt(i2);
        zzb(6, zza);
    }

    @Override // com.google.android.gms.maps.g.s
    public final c zzc(com.google.android.gms.dynamic.b bVar) throws RemoteException {
        c vVar;
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        Parcel zza2 = zza(2, zza);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            vVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            if (queryLocalInterface instanceof c) {
                vVar = (c) queryLocalInterface;
            } else {
                vVar = new v(readStrongBinder);
            }
        }
        zza2.recycle();
        return vVar;
    }

    @Override // com.google.android.gms.maps.g.s
    public final f zzd(com.google.android.gms.dynamic.b bVar) throws RemoteException {
        f oVar;
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        Parcel zza2 = zza(8, zza);
        IBinder readStrongBinder = zza2.readStrongBinder();
        if (readStrongBinder == null) {
            oVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
            if (queryLocalInterface instanceof f) {
                oVar = (f) queryLocalInterface;
            } else {
                oVar = new o(readStrongBinder);
            }
        }
        zza2.recycle();
        return oVar;
    }

    @Override // com.google.android.gms.maps.g.s
    public final a zze() throws RemoteException {
        a kVar;
        Parcel zza = zza(4, zza());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            kVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
            if (queryLocalInterface instanceof a) {
                kVar = (a) queryLocalInterface;
            } else {
                kVar = new k(readStrongBinder);
            }
        }
        zza.recycle();
        return kVar;
    }

    @Override // com.google.android.gms.maps.g.s
    public final zze zzf() throws RemoteException {
        Parcel zza = zza(5, zza());
        zze zzb = zzf.zzb(zza.readStrongBinder());
        zza.recycle();
        return zzb;
    }
}
