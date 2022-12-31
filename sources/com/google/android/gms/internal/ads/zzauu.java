package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzauu extends IInterface {
    void onRewardedVideoAdClosed() throws RemoteException;

    void onRewardedVideoAdFailedToLoad(int i2) throws RemoteException;

    void onRewardedVideoAdLeftApplication() throws RemoteException;

    void onRewardedVideoAdLoaded() throws RemoteException;

    void onRewardedVideoAdOpened() throws RemoteException;

    void onRewardedVideoCompleted() throws RemoteException;

    void onRewardedVideoStarted() throws RemoteException;

    void zza(zzauk zzaukVar) throws RemoteException;
}
