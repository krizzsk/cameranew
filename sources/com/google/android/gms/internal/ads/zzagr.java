package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzagr extends IInterface {
    void cancelUnconfirmedClick() throws RemoteException;

    void destroy() throws RemoteException;

    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    List getMuteThisAdReasons() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzzc getVideoController() throws RemoteException;

    boolean isCustomClickGestureEnabled() throws RemoteException;

    boolean isCustomMuteThisAdEnabled() throws RemoteException;

    void performClick(Bundle bundle) throws RemoteException;

    void recordCustomClickGesture() throws RemoteException;

    boolean recordImpression(Bundle bundle) throws RemoteException;

    void reportTouchEvent(Bundle bundle) throws RemoteException;

    void zza(zzagm zzagmVar) throws RemoteException;

    void zza(zzyj zzyjVar) throws RemoteException;

    void zza(zzyn zzynVar) throws RemoteException;

    void zza(zzyw zzywVar) throws RemoteException;

    zzyx zzki() throws RemoteException;

    b zztm() throws RemoteException;

    zzaer zztn() throws RemoteException;

    zzaej zzto() throws RemoteException;

    b zztp() throws RemoteException;

    void zztx() throws RemoteException;

    zzaem zzty() throws RemoteException;
}
