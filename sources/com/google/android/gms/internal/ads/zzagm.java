package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzagm extends IInterface {
    void onUnconfirmedClickCancelled() throws RemoteException;

    void onUnconfirmedClickReceived(String str) throws RemoteException;
}
