package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzdst extends IInterface {
    String getVersion() throws RemoteException;

    b zza(String str, b bVar, String str2, String str3, String str4, String str5) throws RemoteException;

    b zza(String str, b bVar, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException;

    void zzab(b bVar) throws RemoteException;

    void zzac(b bVar) throws RemoteException;

    boolean zzav(b bVar) throws RemoteException;

    b zzb(String str, b bVar, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException;

    void zzc(b bVar, b bVar2) throws RemoteException;

    void zzd(b bVar, b bVar2) throws RemoteException;
}
