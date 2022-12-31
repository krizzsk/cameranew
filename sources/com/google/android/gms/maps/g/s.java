package com.google.android.gms.maps.g;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zze;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
/* loaded from: classes2.dex */
public interface s extends IInterface {
    d O(com.google.android.gms.dynamic.b bVar, GoogleMapOptions googleMapOptions) throws RemoteException;

    g g0(com.google.android.gms.dynamic.b bVar, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void zza(com.google.android.gms.dynamic.b bVar, int i2) throws RemoteException;

    c zzc(com.google.android.gms.dynamic.b bVar) throws RemoteException;

    f zzd(com.google.android.gms.dynamic.b bVar) throws RemoteException;

    a zze() throws RemoteException;

    zze zzf() throws RemoteException;
}
