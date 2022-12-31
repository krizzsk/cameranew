package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public interface c extends IInterface {
    void D(zam zamVar) throws RemoteException;

    void G(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void m0(zag zagVar) throws RemoteException;

    void s0(ConnectionResult connectionResult, zab zabVar) throws RemoteException;

    void t(Status status) throws RemoteException;

    void v(Status status) throws RemoteException;
}
