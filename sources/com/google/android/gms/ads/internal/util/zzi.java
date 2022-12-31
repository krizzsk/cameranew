package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.adjust.sdk.AdjustConfig;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzadc;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzdzw;
import com.google.android.gms.internal.ads.zzrp;
import com.google.android.gms.internal.ads.zzwr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzi implements zzf {
    private boolean b;

    /* renamed from: d  reason: collision with root package name */
    private zzdzw<?> f3486d;
    @Nullable
    @GuardedBy("lock")

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f3488f;
    @Nullable
    @GuardedBy("lock")

    /* renamed from: g  reason: collision with root package name */
    private SharedPreferences.Editor f3489g;
    @Nullable
    @GuardedBy("lock")

    /* renamed from: i  reason: collision with root package name */
    private String f3491i;
    @Nullable
    @GuardedBy("lock")

    /* renamed from: j  reason: collision with root package name */
    private String f3492j;
    private final Object a = new Object();
    private final List<Runnable> c = new ArrayList();
    @Nullable
    @GuardedBy("lock")

    /* renamed from: e  reason: collision with root package name */
    private zzrp f3487e = null;
    @GuardedBy("lock")

    /* renamed from: h  reason: collision with root package name */
    private boolean f3490h = true;
    @GuardedBy("lock")

    /* renamed from: k  reason: collision with root package name */
    private boolean f3493k = true;
    @GuardedBy("lock")

    /* renamed from: l  reason: collision with root package name */
    private String f3494l = "";
    @GuardedBy("lock")
    private long m = 0;
    @GuardedBy("lock")
    private long n = 0;
    @GuardedBy("lock")
    private long o = 0;
    @GuardedBy("lock")
    private int p = -1;
    @GuardedBy("lock")
    private int q = 0;
    @GuardedBy("lock")
    private Set<String> r = Collections.emptySet();
    @GuardedBy("lock")
    private JSONObject s = new JSONObject();
    @GuardedBy("lock")
    private boolean t = true;
    @GuardedBy("lock")
    private boolean u = true;
    @GuardedBy("lock")
    private String v = null;
    @GuardedBy("lock")
    private int w = -1;

    private final void b() {
        zzdzw<?> zzdzwVar = this.f3486d;
        if (zzdzwVar == null || zzdzwVar.isDone()) {
            return;
        }
        try {
            this.f3486d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzazk.zzd("Interrupted while waiting for preferences loaded.", e2);
        } catch (CancellationException e3) {
            e = e3;
            zzazk.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e4) {
            e = e4;
            zzazk.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e5) {
            e = e5;
            zzazk.zzc("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final void c() {
        zzazp.zzeic.execute(new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.v
            private final zzi a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.zzyh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.a) {
            this.f3488f = sharedPreferences;
            this.f3489g = edit;
            if (com.google.android.gms.common.util.o.i()) {
                NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.f3490h = this.f3488f.getBoolean("use_https", this.f3490h);
            this.t = this.f3488f.getBoolean("content_url_opted_out", this.t);
            this.f3491i = this.f3488f.getString("content_url_hashes", this.f3491i);
            this.f3493k = this.f3488f.getBoolean("gad_idless", this.f3493k);
            this.u = this.f3488f.getBoolean("content_vertical_opted_out", this.u);
            this.f3492j = this.f3488f.getString("content_vertical_hashes", this.f3492j);
            this.q = this.f3488f.getInt("version_code", this.q);
            this.f3494l = this.f3488f.getString("app_settings_json", this.f3494l);
            this.m = this.f3488f.getLong("app_settings_last_update_ms", this.m);
            this.n = this.f3488f.getLong("app_last_background_time_ms", this.n);
            this.p = this.f3488f.getInt("request_in_session_count", this.p);
            this.o = this.f3488f.getLong("first_ad_req_time_ms", this.o);
            this.r = this.f3488f.getStringSet("never_pool_slots", this.r);
            this.v = this.f3488f.getString("display_cutout", this.v);
            this.w = this.f3488f.getInt("app_measurement_npa", this.w);
            try {
                this.s = new JSONObject(this.f3488f.getString("native_advanced_settings", "{}"));
            } catch (JSONException e2) {
                zzazk.zzd("Could not convert native advanced settings to json object", e2);
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void initialize(final Context context) {
        synchronized (this.a) {
            if (this.f3488f != null) {
                return;
            }
            this.f3486d = zzazp.zzeic.zzg(new Runnable(this, context, AdjustConfig.AD_REVENUE_ADMOB) { // from class: com.google.android.gms.ads.internal.util.u
                private final zzi a;
                private final Context b;
                private final String c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.b = context;
                    this.c = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(this.b, this.c);
                }
            });
            this.b = true;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zza(String str, String str2, boolean z) {
        b();
        synchronized (this.a) {
            JSONArray optJSONArray = this.s.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject == null) {
                    return;
                }
                if (str2.equals(optJSONObject.optString("template_id"))) {
                    if (z && optJSONObject.optBoolean("uses_media_view", false)) {
                        return;
                    } else {
                        length = i2;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.s.put(str, optJSONArray);
            } catch (JSONException e2) {
                zzazk.zzd("Could not update native advanced settings", e2);
            }
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.s.toString());
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzap(boolean z) {
        b();
        synchronized (this.a) {
            if (this.t == z) {
                return;
            }
            this.t = z;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putBoolean("content_url_opted_out", z);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzaq(boolean z) {
        b();
        synchronized (this.a) {
            if (this.u == z) {
                return;
            }
            this.u = z;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putBoolean("content_vertical_opted_out", z);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzar(boolean z) {
        b();
        synchronized (this.a) {
            if (z == this.f3493k) {
                return;
            }
            this.f3493k = z;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putBoolean("gad_idless", z);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzb(Runnable runnable) {
        this.c.add(runnable);
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzdd(int i2) {
        b();
        synchronized (this.a) {
            if (this.q == i2) {
                return;
            }
            this.q = i2;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putInt("version_code", i2);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzde(int i2) {
        b();
        synchronized (this.a) {
            if (this.p == i2) {
                return;
            }
            this.p = i2;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putInt("request_in_session_count", i2);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzec(@Nullable String str) {
        b();
        synchronized (this.a) {
            if (str != null) {
                if (!str.equals(this.f3491i)) {
                    this.f3491i = str;
                    SharedPreferences.Editor editor = this.f3489g;
                    if (editor != null) {
                        editor.putString("content_url_hashes", str);
                        this.f3489g.apply();
                    }
                    c();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzed(@Nullable String str) {
        b();
        synchronized (this.a) {
            if (str != null) {
                if (!str.equals(this.f3492j)) {
                    this.f3492j = str;
                    SharedPreferences.Editor editor = this.f3489g;
                    if (editor != null) {
                        editor.putString("content_vertical_hashes", str);
                        this.f3489g.apply();
                    }
                    c();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzee(String str) {
        b();
        synchronized (this.a) {
            long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
            this.m = currentTimeMillis;
            if (str != null && !str.equals(this.f3494l)) {
                this.f3494l = str;
                SharedPreferences.Editor editor = this.f3489g;
                if (editor != null) {
                    editor.putString("app_settings_json", str);
                    this.f3489g.putLong("app_settings_last_update_ms", currentTimeMillis);
                    this.f3489g.apply();
                }
                c();
                for (Runnable runnable : this.c) {
                    runnable.run();
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzef(String str) {
        b();
        synchronized (this.a) {
            if (TextUtils.equals(this.v, str)) {
                return;
            }
            this.v = str;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putString("display_cutout", str);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzez(long j2) {
        b();
        synchronized (this.a) {
            if (this.n == j2) {
                return;
            }
            this.n = j2;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putLong("app_last_background_time_ms", j2);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzfa(long j2) {
        b();
        synchronized (this.a) {
            if (this.o == j2) {
                return;
            }
            this.o = j2;
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.putLong("first_ad_req_time_ms", j2);
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    @Nullable
    public final zzrp zzyh() {
        if (this.b) {
            if (!(zzyi() && zzyk()) && zzadc.zzdct.get().booleanValue()) {
                synchronized (this.a) {
                    if (Looper.getMainLooper() == null) {
                        return null;
                    }
                    if (this.f3487e == null) {
                        this.f3487e = new zzrp();
                    }
                    this.f3487e.zzmi();
                    zzazk.zzew("start fetching content...");
                    return this.f3487e;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean zzyi() {
        boolean z;
        b();
        synchronized (this.a) {
            z = this.t;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    @Nullable
    public final String zzyj() {
        String str;
        b();
        synchronized (this.a) {
            str = this.f3491i;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean zzyk() {
        boolean z;
        b();
        synchronized (this.a) {
            z = this.u;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    @Nullable
    public final String zzyl() {
        String str;
        b();
        synchronized (this.a) {
            str = this.f3492j;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final int zzym() {
        int i2;
        b();
        synchronized (this.a) {
            i2 = this.q;
        }
        return i2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final zzayp zzyn() {
        zzayp zzaypVar;
        b();
        synchronized (this.a) {
            zzaypVar = new zzayp(this.f3494l, this.m);
        }
        return zzaypVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final long zzyo() {
        long j2;
        b();
        synchronized (this.a) {
            j2 = this.n;
        }
        return j2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final int zzyp() {
        int i2;
        b();
        synchronized (this.a) {
            i2 = this.p;
        }
        return i2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final long zzyq() {
        long j2;
        b();
        synchronized (this.a) {
            j2 = this.o;
        }
        return j2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final JSONObject zzyr() {
        JSONObject jSONObject;
        b();
        synchronized (this.a) {
            jSONObject = this.s;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final void zzys() {
        b();
        synchronized (this.a) {
            this.s = new JSONObject();
            SharedPreferences.Editor editor = this.f3489g;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.f3489g.apply();
            }
            c();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final String zzyt() {
        String str;
        b();
        synchronized (this.a) {
            str = this.v;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzf
    public final boolean zzyu() {
        boolean z;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcos)).booleanValue()) {
            b();
            synchronized (this.a) {
                z = this.f3493k;
            }
            return z;
        }
        return false;
    }
}
