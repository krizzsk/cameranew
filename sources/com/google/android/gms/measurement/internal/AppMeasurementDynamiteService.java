package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.RecentlyNonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
@DynamiteApi
/* loaded from: classes2.dex */
public class AppMeasurementDynamiteService extends zzo {
    o4 a = null;
    @GuardedBy("listenerMap")
    private final Map<Integer, q5> b = new ArrayMap();

    @EnsuresNonNull({"scion"})
    private final void x0() {
        if (this.a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void y0(zzs zzsVar, String str) {
        x0();
        this.a.E().P(zzsVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void beginAdUnitExposure(@RecentlyNonNull String str, long j2) throws RemoteException {
        x0();
        this.a.e().g(str, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void clearConditionalUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) throws RemoteException {
        x0();
        this.a.D().z(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void clearMeasurementEnabled(long j2) throws RemoteException {
        x0();
        this.a.D().R(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void endAdUnitExposure(@RecentlyNonNull String str, long j2) throws RemoteException {
        x0();
        this.a.e().h(str, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void generateEventId(zzs zzsVar) throws RemoteException {
        x0();
        long e0 = this.a.E().e0();
        x0();
        this.a.E().Q(zzsVar, e0);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getAppInstanceId(zzs zzsVar) throws RemoteException {
        x0();
        this.a.c().p(new d6(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getCachedAppInstanceId(zzs zzsVar) throws RemoteException {
        x0();
        y0(zzsVar, this.a.D().o());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getConditionalUserProperties(String str, String str2, zzs zzsVar) throws RemoteException {
        x0();
        this.a.c().p(new q9(this, zzsVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getCurrentScreenClass(zzs zzsVar) throws RemoteException {
        x0();
        y0(zzsVar, this.a.D().D());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getCurrentScreenName(zzs zzsVar) throws RemoteException {
        x0();
        y0(zzsVar, this.a.D().C());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getGmpAppId(zzs zzsVar) throws RemoteException {
        x0();
        y0(zzsVar, this.a.D().E());
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getMaxUserProperties(String str, zzs zzsVar) throws RemoteException {
        x0();
        this.a.D().w(str);
        x0();
        this.a.E().R(zzsVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getTestFlag(zzs zzsVar, int i2) throws RemoteException {
        x0();
        if (i2 == 0) {
            this.a.E().P(zzsVar, this.a.D().N());
        } else if (i2 == 1) {
            this.a.E().Q(zzsVar, this.a.D().O().longValue());
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.a.E().R(zzsVar, this.a.D().P().intValue());
            } else if (i2 != 4) {
            } else {
                this.a.E().T(zzsVar, this.a.D().M().booleanValue());
            }
        } else {
            n9 E = this.a.E();
            double doubleValue = this.a.D().Q().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzsVar.zzb(bundle);
            } catch (RemoteException e2) {
                E.a.a().p().b("Error returning double value to wrapper", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void getUserProperties(String str, String str2, boolean z, zzs zzsVar) throws RemoteException {
        x0();
        this.a.c().p(new e8(this, zzsVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void initForTests(@RecentlyNonNull Map map) throws RemoteException {
        x0();
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void initialize(com.google.android.gms.dynamic.b bVar, zzy zzyVar, long j2) throws RemoteException {
        o4 o4Var = this.a;
        if (o4Var == null) {
            Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
            com.google.android.gms.common.internal.q.j(context);
            this.a = o4.f(context, zzyVar, Long.valueOf(j2));
            return;
        }
        o4Var.a().p().a("Attempting to initialize multiple times");
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void isDataCollectionEnabled(zzs zzsVar) throws RemoteException {
        x0();
        this.a.c().p(new r9(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void logEvent(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        x0();
        this.a.D().Y(str, str2, bundle, z, z2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzsVar, long j2) throws RemoteException {
        Bundle bundle2;
        x0();
        com.google.android.gms.common.internal.q.f(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.a.c().p(new e7(this, zzsVar, new zzas(str2, new zzaq(bundle), "app", j2), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void logHealthData(int i2, @RecentlyNonNull String str, @RecentlyNonNull com.google.android.gms.dynamic.b bVar, @RecentlyNonNull com.google.android.gms.dynamic.b bVar2, @RecentlyNonNull com.google.android.gms.dynamic.b bVar3) throws RemoteException {
        x0();
        this.a.a().w(i2, true, false, str, bVar == null ? null : com.google.android.gms.dynamic.d.y0(bVar), bVar2 == null ? null : com.google.android.gms.dynamic.d.y0(bVar2), bVar3 != null ? com.google.android.gms.dynamic.d.y0(bVar3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityCreated(@RecentlyNonNull com.google.android.gms.dynamic.b bVar, @RecentlyNonNull Bundle bundle, long j2) throws RemoteException {
        x0();
        q6 q6Var = this.a.D().c;
        if (q6Var != null) {
            this.a.D().L();
            q6Var.onActivityCreated((Activity) com.google.android.gms.dynamic.d.y0(bVar), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityDestroyed(@RecentlyNonNull com.google.android.gms.dynamic.b bVar, long j2) throws RemoteException {
        x0();
        q6 q6Var = this.a.D().c;
        if (q6Var != null) {
            this.a.D().L();
            q6Var.onActivityDestroyed((Activity) com.google.android.gms.dynamic.d.y0(bVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityPaused(@RecentlyNonNull com.google.android.gms.dynamic.b bVar, long j2) throws RemoteException {
        x0();
        q6 q6Var = this.a.D().c;
        if (q6Var != null) {
            this.a.D().L();
            q6Var.onActivityPaused((Activity) com.google.android.gms.dynamic.d.y0(bVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityResumed(@RecentlyNonNull com.google.android.gms.dynamic.b bVar, long j2) throws RemoteException {
        x0();
        q6 q6Var = this.a.D().c;
        if (q6Var != null) {
            this.a.D().L();
            q6Var.onActivityResumed((Activity) com.google.android.gms.dynamic.d.y0(bVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivitySaveInstanceState(com.google.android.gms.dynamic.b bVar, zzs zzsVar, long j2) throws RemoteException {
        x0();
        q6 q6Var = this.a.D().c;
        Bundle bundle = new Bundle();
        if (q6Var != null) {
            this.a.D().L();
            q6Var.onActivitySaveInstanceState((Activity) com.google.android.gms.dynamic.d.y0(bVar), bundle);
        }
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning bundle value to wrapper", e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityStarted(@RecentlyNonNull com.google.android.gms.dynamic.b bVar, long j2) throws RemoteException {
        x0();
        if (this.a.D().c != null) {
            this.a.D().L();
            Activity activity = (Activity) com.google.android.gms.dynamic.d.y0(bVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void onActivityStopped(@RecentlyNonNull com.google.android.gms.dynamic.b bVar, long j2) throws RemoteException {
        x0();
        if (this.a.D().c != null) {
            this.a.D().L();
            Activity activity = (Activity) com.google.android.gms.dynamic.d.y0(bVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void performAction(Bundle bundle, zzs zzsVar, long j2) throws RemoteException {
        x0();
        zzsVar.zzb(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void registerOnMeasurementEventListener(zzv zzvVar) throws RemoteException {
        q5 q5Var;
        x0();
        synchronized (this.b) {
            q5Var = this.b.get(Integer.valueOf(zzvVar.zze()));
            if (q5Var == null) {
                q5Var = new t9(this, zzvVar);
                this.b.put(Integer.valueOf(zzvVar.zze()), q5Var);
            }
        }
        this.a.D().u(q5Var);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void resetAnalyticsData(long j2) throws RemoteException {
        x0();
        this.a.D().q(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setConditionalUserProperty(@RecentlyNonNull Bundle bundle, long j2) throws RemoteException {
        x0();
        if (bundle == null) {
            this.a.a().m().a("Conditional user property must not be null");
        } else {
            this.a.D().y(bundle, j2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setConsent(@RecentlyNonNull Bundle bundle, long j2) throws RemoteException {
        x0();
        r6 D = this.a.D();
        zzlc.zzb();
        if (D.a.x().u(null, x2.w0)) {
            D.S(bundle, 30, j2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setConsentThirdParty(@RecentlyNonNull Bundle bundle, long j2) throws RemoteException {
        x0();
        r6 D = this.a.D();
        zzlc.zzb();
        if (D.a.x().u(null, x2.x0)) {
            D.S(bundle, 10, j2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setCurrentScreen(@RecentlyNonNull com.google.android.gms.dynamic.b bVar, @RecentlyNonNull String str, @RecentlyNonNull String str2, long j2) throws RemoteException {
        x0();
        this.a.O().t((Activity) com.google.android.gms.dynamic.d.y0(bVar), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        x0();
        r6 D = this.a.D();
        D.h();
        D.a.c().p(new u5(D, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setDefaultEventParameters(@RecentlyNonNull Bundle bundle) {
        x0();
        final r6 D = this.a.D();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        D.a.c().p(new Runnable(D, bundle2) { // from class: com.google.android.gms.measurement.internal.s5
            private final r6 a;
            private final Bundle b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = D;
                this.b = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.F(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setEventInterceptor(zzv zzvVar) throws RemoteException {
        x0();
        s9 s9Var = new s9(this, zzvVar);
        if (this.a.c().m()) {
            this.a.D().t(s9Var);
        } else {
            this.a.c().p(new e9(this, s9Var));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setInstanceIdProvider(zzx zzxVar) throws RemoteException {
        x0();
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setMeasurementEnabled(boolean z, long j2) throws RemoteException {
        x0();
        this.a.D().R(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setMinimumSessionDuration(long j2) throws RemoteException {
        x0();
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setSessionTimeoutDuration(long j2) throws RemoteException {
        x0();
        r6 D = this.a.D();
        D.a.c().p(new w5(D, j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setUserId(@RecentlyNonNull String str, long j2) throws RemoteException {
        x0();
        this.a.D().b0(null, "_id", str, true, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void setUserProperty(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull com.google.android.gms.dynamic.b bVar, boolean z, long j2) throws RemoteException {
        x0();
        this.a.D().b0(str, str2, com.google.android.gms.dynamic.d.y0(bVar), z, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public void unregisterOnMeasurementEventListener(zzv zzvVar) throws RemoteException {
        q5 remove;
        x0();
        synchronized (this.b) {
            remove = this.b.remove(Integer.valueOf(zzvVar.zze()));
        }
        if (remove == null) {
            remove = new t9(this, zzvVar);
        }
        this.a.D().v(remove);
    }
}
