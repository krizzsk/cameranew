package com.google.android.gms.maps.g;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface g extends IInterface {
    void g(l lVar) throws RemoteException;

    com.google.android.gms.dynamic.b getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;
}
