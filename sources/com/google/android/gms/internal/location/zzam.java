package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface zzam extends IInterface {
    void zza(int i2, PendingIntent pendingIntent) throws RemoteException;

    void zza(int i2, String[] strArr) throws RemoteException;

    void zzb(int i2, String[] strArr) throws RemoteException;
}
