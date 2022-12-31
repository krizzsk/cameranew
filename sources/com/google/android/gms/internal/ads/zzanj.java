package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzanj extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzzc getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(b bVar, zzajj zzajjVar, List<zzajr> list) throws RemoteException;

    void zza(b bVar, zzavf zzavfVar, List<String> list) throws RemoteException;

    void zza(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException;

    void zza(b bVar, zzvl zzvlVar, String str, zzavf zzavfVar, String str2) throws RemoteException;

    void zza(b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException;

    void zza(b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar, zzaeh zzaehVar, List<String> list) throws RemoteException;

    void zza(b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException;

    void zza(b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException;

    void zza(zzvl zzvlVar, String str) throws RemoteException;

    void zza(zzvl zzvlVar, String str, String str2) throws RemoteException;

    void zzb(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException;

    void zzc(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException;

    void zzs(b bVar) throws RemoteException;

    void zzt(b bVar) throws RemoteException;

    b zzuu() throws RemoteException;

    zzanr zzuv() throws RemoteException;

    zzans zzuw() throws RemoteException;

    Bundle zzux() throws RemoteException;

    Bundle zzuy() throws RemoteException;

    boolean zzuz() throws RemoteException;

    zzafn zzva() throws RemoteException;

    zzanx zzvb() throws RemoteException;

    zzapy zzvc() throws RemoteException;

    zzapy zzvd() throws RemoteException;
}
