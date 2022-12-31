package com.google.android.gms.maps.g;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
/* loaded from: classes2.dex */
public final class o extends zza implements f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
    }

    @Override // com.google.android.gms.maps.g.f
    public final void Z(com.google.android.gms.dynamic.b bVar, StreetViewPanoramaOptions streetViewPanoramaOptions, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzc.zza(zza, streetViewPanoramaOptions);
        zzc.zza(zza, bundle);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.maps.g.f
    public final void d() throws RemoteException {
        zzb(7, zza());
    }

    @Override // com.google.android.gms.maps.g.f
    public final void g(l lVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, lVar);
        zzb(12, zza);
    }

    @Override // com.google.android.gms.maps.g.f
    public final com.google.android.gms.dynamic.b h(com.google.android.gms.dynamic.b bVar, com.google.android.gms.dynamic.b bVar2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzc.zza(zza, bVar2);
        zzc.zza(zza, bundle);
        Parcel zza2 = zza(4, zza);
        com.google.android.gms.dynamic.b x0 = b.a.x0(zza2.readStrongBinder());
        zza2.recycle();
        return x0;
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bundle);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onDestroy() throws RemoteException {
        zzb(8, zza());
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onLowMemory() throws RemoteException {
        zzb(9, zza());
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onPause() throws RemoteException {
        zzb(6, zza());
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onResume() throws RemoteException {
        zzb(5, zza());
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bundle);
        Parcel zza2 = zza(10, zza);
        if (zza2.readInt() != 0) {
            bundle.readFromParcel(zza2);
        }
        zza2.recycle();
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onStart() throws RemoteException {
        zzb(13, zza());
    }

    @Override // com.google.android.gms.maps.g.f
    public final void onStop() throws RemoteException {
        zzb(14, zza());
    }
}
