package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzyg extends IInterface {
    String getVersionString() throws RemoteException;

    void initialize() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f2) throws RemoteException;

    void zza(zzaao zzaaoVar) throws RemoteException;

    void zza(zzajk zzajkVar) throws RemoteException;

    void zza(zzane zzaneVar) throws RemoteException;

    void zza(String str, b bVar) throws RemoteException;

    void zzb(b bVar, String str) throws RemoteException;

    void zzcd(String str) throws RemoteException;

    void zzce(String str) throws RemoteException;

    float zzra() throws RemoteException;

    boolean zzrb() throws RemoteException;

    List<zzajh> zzrc() throws RemoteException;

    void zzrd() throws RemoteException;
}
