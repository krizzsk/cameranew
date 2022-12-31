package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.api.a;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    final a zza;
    final Map<String, com.google.firebase.analytics.connector.internal.zza> zzb;

    AnalyticsConnectorImpl(a aVar) {
        q.j(aVar);
        this.zza = aVar;
        this.zzb = new ConcurrentHashMap();
    }

    @RecentlyNonNull
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            AnalyticsConnector analyticsConnector = zzc;
            q.j(analyticsConnector);
            ((AnalyticsConnectorImpl) analyticsConnector).zza.v(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc(@NonNull String str) {
        return (str.isEmpty() || !this.zzb.containsKey(str) || this.zzb.get(str) == null) ? false : true;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(@RecentlyNonNull @Size(max = 24, min = 1) String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        if (str2 == null || zzc.zzb(str2, bundle)) {
            this.zza.b(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @RecentlyNonNull
    @WorkerThread
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@RecentlyNonNull String str, @RecentlyNonNull @Size(max = 23, min = 1) String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.zza.g(str, str2)) {
            arrayList.add(zzc.zzh(bundle));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @WorkerThread
    public int getMaxUserProperties(@RecentlyNonNull @Size(min = 1) String str) {
        return this.zza.l(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @RecentlyNonNull
    @WorkerThread
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zza.m(null, null, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zza(str) && zzc.zzb(str2, bundle) && zzc.zzf(str, str2, bundle)) {
            zzc.zzm(str, str2, bundle);
            this.zza.n(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @RecentlyNonNull
    @WorkerThread
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@RecentlyNonNull final String str, @RecentlyNonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        com.google.firebase.analytics.connector.internal.zza zzgVar;
        q.j(analyticsConnectorListener);
        if (zzc.zza(str) && !zzc(str)) {
            a aVar = this.zza;
            if (FirebaseABTesting.OriginService.INAPP_MESSAGING.equals(str)) {
                zzgVar = new zze(aVar, analyticsConnectorListener);
            } else {
                zzgVar = ("crash".equals(str) || "clx".equals(str)) ? new zzg(aVar, analyticsConnectorListener) : null;
            }
            if (zzgVar != null) {
                this.zzb.put(str, zzgVar);
                return new AnalyticsConnector.AnalyticsConnectorHandle() { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public void registerEventNames(Set<String> set) {
                        if (!AnalyticsConnectorImpl.this.zzc(str) || !str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING) || set == null || set.isEmpty()) {
                            return;
                        }
                        AnalyticsConnectorImpl.this.zzb.get(str).zzb(set);
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public final void unregister() {
                        if (AnalyticsConnectorImpl.this.zzc(str)) {
                            AnalyticsConnector.AnalyticsConnectorListener zza = AnalyticsConnectorImpl.this.zzb.get(str).zza();
                            if (zza != null) {
                                zza.onMessageTriggered(0, null);
                            }
                            AnalyticsConnectorImpl.this.zzb.remove(str);
                        }
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public void unregisterEventNames() {
                        if (AnalyticsConnectorImpl.this.zzc(str) && str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING)) {
                            AnalyticsConnectorImpl.this.zzb.get(str).zzc();
                        }
                    }
                };
            }
            return null;
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(@RecentlyNonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzc.zze(conditionalUserProperty)) {
            this.zza.r(zzc.zzg(conditionalUserProperty));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Object obj) {
        if (zzc.zza(str) && zzc.zzd(str, str2)) {
            this.zza.u(str, str2, obj);
        }
    }

    @RecentlyNonNull
    public static AnalyticsConnector getInstance(@RecentlyNonNull FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @RecentlyNonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    public static AnalyticsConnector getInstance(@RecentlyNonNull FirebaseApp firebaseApp, @RecentlyNonNull Context context, @RecentlyNonNull Subscriber subscriber) {
        q.j(firebaseApp);
        q.j(context);
        q.j(subscriber);
        q.j(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzc == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzc = new AnalyticsConnectorImpl(zzbr.zza(context, null, null, null, bundle).zzb());
                }
            }
        }
        return zzc;
    }
}
