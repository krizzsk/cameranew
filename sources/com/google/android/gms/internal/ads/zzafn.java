package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzafn extends IInterface {
    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzzc getVideoController() throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    String zzct(String str) throws RemoteException;

    zzaer zzcu(String str) throws RemoteException;

    boolean zzp(b bVar) throws RemoteException;

    void zzq(b bVar) throws RemoteException;

    b zztm() throws RemoteException;

    b zztr() throws RemoteException;

    boolean zzts() throws RemoteException;

    boolean zztt() throws RemoteException;

    void zztu() throws RemoteException;
}
