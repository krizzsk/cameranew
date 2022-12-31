package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzzd extends IInterface {
    void onVideoEnd() throws RemoteException;

    void onVideoMute(boolean z) throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void onVideoStart() throws RemoteException;
}
