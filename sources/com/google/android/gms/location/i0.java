package com.google.android.gms.location;

import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes2.dex */
public interface i0 extends IInterface {
    @Instrumented
    void onLocationChanged(Location location) throws RemoteException;
}
