package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.tapjoy.TapjoyConstants;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class z3 extends j5 {
    static final Pair<String, Long> C = new Pair<>("", 0L);
    public final w3 A;
    public final v3 B;
    private SharedPreferences c;

    /* renamed from: d  reason: collision with root package name */
    public x3 f4001d;

    /* renamed from: e  reason: collision with root package name */
    public final w3 f4002e;

    /* renamed from: f  reason: collision with root package name */
    public final w3 f4003f;

    /* renamed from: g  reason: collision with root package name */
    public final w3 f4004g;

    /* renamed from: h  reason: collision with root package name */
    public final w3 f4005h;

    /* renamed from: i  reason: collision with root package name */
    public final w3 f4006i;

    /* renamed from: j  reason: collision with root package name */
    public final w3 f4007j;

    /* renamed from: k  reason: collision with root package name */
    public final w3 f4008k;

    /* renamed from: l  reason: collision with root package name */
    public final y3 f4009l;
    private String m;
    private boolean n;
    private long o;
    public final w3 p;
    public final u3 q;
    public final y3 r;
    public final u3 s;
    public final w3 t;
    public boolean u;
    public final u3 v;
    public final u3 w;
    public final w3 x;
    public final y3 y;
    public final y3 z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z3(o4 o4Var) {
        super(o4Var);
        this.f4002e = new w3(this, "last_upload", 0L);
        this.f4003f = new w3(this, "last_upload_attempt", 0L);
        this.f4004g = new w3(this, "backoff", 0L);
        this.f4005h = new w3(this, "last_delete_stale", 0L);
        this.p = new w3(this, "session_timeout", TapjoyConstants.SESSION_ID_INACTIVITY_TIME);
        this.q = new u3(this, "start_new_session", true);
        this.t = new w3(this, "last_pause_time", 0L);
        this.r = new y3(this, "non_personalized_ads", null);
        this.s = new u3(this, "allow_remote_dynamite", false);
        this.f4006i = new w3(this, "midnight_offset", 0L);
        this.f4007j = new w3(this, "first_open_time", 0L);
        this.f4008k = new w3(this, "app_install_time", 0L);
        this.f4009l = new y3(this, "app_instance_id", null);
        this.v = new u3(this, "app_backgrounded", false);
        this.w = new u3(this, "deep_link_retrieval_complete", false);
        this.x = new w3(this, "deep_link_retrieval_attempts", 0L);
        this.y = new y3(this, "firebase_feature_rollouts", null);
        this.z = new y3(this, "deferred_attribution_cache", null);
        this.A = new w3(this, "deferred_attribution_cache_timestamp", 0L);
        this.B = new v3(this, "default_event_parameters", null);
    }

    @Override // com.google.android.gms.measurement.internal.j5
    protected final boolean g() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.j5
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    @WorkerThread
    protected final void h() {
        SharedPreferences sharedPreferences = this.a.zzaw().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.c = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.u = z;
        if (!z) {
            SharedPreferences.Editor edit = this.c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.a.x();
        this.f4001d = new x3(this, "health_monitor", Math.max(0L, x2.c.b(null).longValue()), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Pair<String, Boolean> m(String str) {
        f();
        long a = this.a.zzax().a();
        String str2 = this.m;
        if (str2 != null && a < this.o) {
            return new Pair<>(str2, Boolean.valueOf(this.n));
        }
        this.o = a + this.a.x().q(str, x2.b);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a.zzaw());
            if (advertisingIdInfo != null) {
                this.m = advertisingIdInfo.getId();
                this.n = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.m == null) {
                this.m = "";
            }
        } catch (Exception e2) {
            this.a.a().t().b("Unable to get advertising id", e2);
            this.m = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.m, Boolean.valueOf(this.n));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final SharedPreferences n() {
        f();
        j();
        com.google.android.gms.common.internal.q.j(this.c);
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void o(Boolean bool) {
        f();
        SharedPreferences.Editor edit = n().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean p() {
        f();
        if (n().contains("measurement_enabled")) {
            return Boolean.valueOf(n().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean q(int i2) {
        return f.m(i2, n().getInt("consent_source", 100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final f r() {
        f();
        return f.c(n().getString("consent_settings", "G1"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void s(boolean z) {
        f();
        this.a.a().u().b("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = n().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean t() {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean u(long j2) {
        return j2 - this.p.a() > this.t.a();
    }
}
