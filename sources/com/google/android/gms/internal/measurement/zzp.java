package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public interface zzp extends IInterface {
    void beginAdUnitExposure(String str, long j2) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j2) throws RemoteException;

    void endAdUnitExposure(String str, long j2) throws RemoteException;

    void generateEventId(zzs zzsVar) throws RemoteException;

    void getAppInstanceId(zzs zzsVar) throws RemoteException;

    void getCachedAppInstanceId(zzs zzsVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzs zzsVar) throws RemoteException;

    void getCurrentScreenClass(zzs zzsVar) throws RemoteException;

    void getCurrentScreenName(zzs zzsVar) throws RemoteException;

    void getGmpAppId(zzs zzsVar) throws RemoteException;

    void getMaxUserProperties(String str, zzs zzsVar) throws RemoteException;

    void getTestFlag(zzs zzsVar, int i2) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z, zzs zzsVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(b bVar, zzy zzyVar, long j2) throws RemoteException;

    void isDataCollectionEnabled(zzs zzsVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzsVar, long j2) throws RemoteException;

    void logHealthData(int i2, String str, b bVar, b bVar2, b bVar3) throws RemoteException;

    void onActivityCreated(b bVar, Bundle bundle, long j2) throws RemoteException;

    void onActivityDestroyed(b bVar, long j2) throws RemoteException;

    void onActivityPaused(b bVar, long j2) throws RemoteException;

    void onActivityResumed(b bVar, long j2) throws RemoteException;

    void onActivitySaveInstanceState(b bVar, zzs zzsVar, long j2) throws RemoteException;

    void onActivityStarted(b bVar, long j2) throws RemoteException;

    void onActivityStopped(b bVar, long j2) throws RemoteException;

    void performAction(Bundle bundle, zzs zzsVar, long j2) throws RemoteException;

    void registerOnMeasurementEventListener(zzv zzvVar) throws RemoteException;

    void resetAnalyticsData(long j2) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException;

    void setConsent(Bundle bundle, long j2) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j2) throws RemoteException;

    void setCurrentScreen(b bVar, String str, String str2, long j2) throws RemoteException;

    void setDataCollectionEnabled(boolean z) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzv zzvVar) throws RemoteException;

    void setInstanceIdProvider(zzx zzxVar) throws RemoteException;

    void setMeasurementEnabled(boolean z, long j2) throws RemoteException;

    void setMinimumSessionDuration(long j2) throws RemoteException;

    void setSessionTimeoutDuration(long j2) throws RemoteException;

    void setUserId(String str, long j2) throws RemoteException;

    void setUserProperty(String str, String str2, b bVar, boolean z, long j2) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzv zzvVar) throws RemoteException;
}
