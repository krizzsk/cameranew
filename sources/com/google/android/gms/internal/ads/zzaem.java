package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzaem extends IInterface {
    float getAspectRatio() throws RemoteException;

    float getCurrentTime() throws RemoteException;

    float getDuration() throws RemoteException;

    zzzc getVideoController() throws RemoteException;

    boolean hasVideoContent() throws RemoteException;

    void zza(zzagd zzagdVar) throws RemoteException;

    void zzo(b bVar) throws RemoteException;

    b zztl() throws RemoteException;
}
