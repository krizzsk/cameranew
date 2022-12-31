package com.google.android.gms.maps.g;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
/* loaded from: classes2.dex */
public final class p extends zza implements g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.maps.g.g
    public final void g(l lVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, lVar);
        zzb(9, zza);
    }

    @Override // com.google.android.gms.maps.g.g
    public final com.google.android.gms.dynamic.b getView() throws RemoteException {
        Parcel zza = zza(8, zza());
        com.google.android.gms.dynamic.b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bundle);
        zzb(2, zza);
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onDestroy() throws RemoteException {
        zzb(5, zza());
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onLowMemory() throws RemoteException {
        zzb(6, zza());
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onPause() throws RemoteException {
        zzb(4, zza());
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onResume() throws RemoteException {
        zzb(3, zza());
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bundle);
        Parcel zza2 = zza(7, zza);
        if (zza2.readInt() != 0) {
            bundle.readFromParcel(zza2);
        }
        zza2.recycle();
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onStart() throws RemoteException {
        zzb(10, zza());
    }

    @Override // com.google.android.gms.maps.g.g
    public final void onStop() throws RemoteException {
        zzb(11, zza());
    }
}
