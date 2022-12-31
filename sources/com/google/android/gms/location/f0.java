package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface f0 extends IInterface {
    void onLocationAvailability(LocationAvailability locationAvailability) throws RemoteException;

    void onLocationResult(LocationResult locationResult) throws RemoteException;
}
