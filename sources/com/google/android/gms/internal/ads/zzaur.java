package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzaur extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setAppPackageName(String str) throws RemoteException;

    void setCustomData(String str) throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void show() throws RemoteException;

    void zza(zzaup zzaupVar) throws RemoteException;

    void zza(zzauu zzauuVar) throws RemoteException;

    void zza(zzava zzavaVar) throws RemoteException;

    void zza(zzxs zzxsVar) throws RemoteException;

    void zzi(b bVar) throws RemoteException;

    void zzj(b bVar) throws RemoteException;

    void zzk(b bVar) throws RemoteException;

    zzyx zzki() throws RemoteException;

    void zzl(b bVar) throws RemoteException;

    boolean zzrw() throws RemoteException;
}
