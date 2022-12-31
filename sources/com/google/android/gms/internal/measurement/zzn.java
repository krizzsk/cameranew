package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzn extends zza implements zzp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void beginAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j2);
        zzc(23, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzc(9, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void clearMeasurementEnabled(long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j2);
        zzc(43, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void endAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j2);
        zzc(24, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void generateEventId(zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzsVar);
        zzc(22, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getAppInstanceId(zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzsVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getCachedAppInstanceId(zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzsVar);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getConditionalUserProperties(String str, String str2, zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, zzsVar);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getCurrentScreenClass(zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzsVar);
        zzc(17, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getCurrentScreenName(zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzsVar);
        zzc(16, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getGmpAppId(zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzsVar);
        zzc(21, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getMaxUserProperties(String str, zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zze(zza, zzsVar);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getTestFlag(zzs zzsVar, int i2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzsVar);
        zza.writeInt(i2);
        zzc(38, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getUserProperties(String str, String str2, boolean z, zzs zzsVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzb(zza, z);
        zzc.zze(zza, zzsVar);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void initialize(b bVar, zzy zzyVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zzc.zzd(zza, zzyVar);
        zza.writeLong(j2);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void isDataCollectionEnabled(zzs zzsVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, bundle);
        zzc.zzb(zza, z);
        zzc.zzb(zza, z2);
        zza.writeLong(j2);
        zzc(2, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzsVar, long j2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void logHealthData(int i2, String str, b bVar, b bVar2, b bVar3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zzc.zze(zza, bVar);
        zzc.zze(zza, bVar2);
        zzc.zze(zza, bVar3);
        zzc(33, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityCreated(b bVar, Bundle bundle, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zzc.zzd(zza, bundle);
        zza.writeLong(j2);
        zzc(27, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityDestroyed(b bVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeLong(j2);
        zzc(28, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityPaused(b bVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeLong(j2);
        zzc(29, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityResumed(b bVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeLong(j2);
        zzc(30, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivitySaveInstanceState(b bVar, zzs zzsVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zzc.zze(zza, zzsVar);
        zza.writeLong(j2);
        zzc(31, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityStarted(b bVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeLong(j2);
        zzc(25, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityStopped(b bVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeLong(j2);
        zzc(26, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void performAction(Bundle bundle, zzs zzsVar, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc.zze(zza, zzsVar);
        zza.writeLong(j2);
        zzc(32, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void registerOnMeasurementEventListener(zzv zzvVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzvVar);
        zzc(35, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void resetAnalyticsData(long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j2);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j2);
        zzc(8, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setConsent(Bundle bundle, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j2);
        zzc(44, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setConsentThirdParty(Bundle bundle, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zza.writeLong(j2);
        zzc(45, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setCurrentScreen(b bVar, String str, String str2, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, bVar);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j2);
        zzc(15, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zzc(39, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc(42, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setEventInterceptor(zzv zzvVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzvVar);
        zzc(34, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setInstanceIdProvider(zzx zzxVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setMeasurementEnabled(boolean z, long j2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, z);
        zza.writeLong(j2);
        zzc(11, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setMinimumSessionDuration(long j2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setSessionTimeoutDuration(long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j2);
        zzc(14, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setUserId(String str, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j2);
        zzc(7, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setUserProperty(String str, String str2, b bVar, boolean z, long j2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, bVar);
        zzc.zzb(zza, z);
        zza.writeLong(j2);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void unregisterOnMeasurementEventListener(zzv zzvVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzvVar);
        zzc(36, zza);
    }
}
