package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzans extends IInterface {
    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    boolean getOverrideClickHandling() throws RemoteException;

    boolean getOverrideImpressionRecording() throws RemoteException;

    zzzc getVideoController() throws RemoteException;

    void recordImpression() throws RemoteException;

    void zzc(b bVar, b bVar2, b bVar3) throws RemoteException;

    zzaej zzto() throws RemoteException;

    b zztp() throws RemoteException;

    zzaer zztq() throws RemoteException;

    void zzu(b bVar) throws RemoteException;

    void zzv(b bVar) throws RemoteException;

    b zzvg() throws RemoteException;

    b zzvh() throws RemoteException;

    void zzw(b bVar) throws RemoteException;
}
