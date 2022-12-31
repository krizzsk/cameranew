package com.google.android.gms.maps.g;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
/* loaded from: classes2.dex */
public interface c extends IInterface {
    void P(com.google.android.gms.dynamic.b bVar, GoogleMapOptions googleMapOptions, Bundle bundle) throws RemoteException;

    void d() throws RemoteException;

    void f(i iVar) throws RemoteException;

    com.google.android.gms.dynamic.b h(com.google.android.gms.dynamic.b bVar, com.google.android.gms.dynamic.b bVar2, Bundle bundle) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;
}
