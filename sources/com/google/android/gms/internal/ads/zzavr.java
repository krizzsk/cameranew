package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzavr extends IInterface {
    void onRewardedAdClosed() throws RemoteException;

    void onRewardedAdFailedToShow(int i2) throws RemoteException;

    void onRewardedAdOpened() throws RemoteException;

    void zza(zzavl zzavlVar) throws RemoteException;

    void zzi(zzvg zzvgVar) throws RemoteException;
}
