package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.login.LoginClient;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginLogger.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d  reason: collision with root package name */
    private static final ScheduledExecutorService f3130d = Executors.newSingleThreadScheduledExecutor();
    private final InternalAppEventsLogger a;
    private String b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoginLogger.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ Bundle a;

        a(Bundle bundle) {
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c.a(c.this).j("fb_mobile_login_heartbeat", this.a);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, String str) {
        PackageInfo packageInfo;
        this.b = str;
        this.a = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) == null) {
                return;
            }
            this.c = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static /* synthetic */ InternalAppEventsLogger a(c cVar) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return cVar.a;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    private void g(String str) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            f3130d.schedule(new a(k(str)), 5L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    static Bundle k(String str) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
            bundle.putString("0_auth_logger_id", str);
            bundle.putString("3_method", "");
            bundle.putString("2_result", "");
            bundle.putString("5_error_message", "");
            bundle.putString("4_error_code", "");
            bundle.putString("6_extras", "");
            return bundle;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    public String b() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return this.b;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    public void c(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            Bundle k2 = k(str);
            if (str3 != null) {
                k2.putString("2_result", str3);
            }
            if (str4 != null) {
                k2.putString("5_error_message", str4);
            }
            if (str5 != null) {
                k2.putString("4_error_code", str5);
            }
            if (map != null && !map.isEmpty()) {
                k2.putString("6_extras", new JSONObject(map).toString());
            }
            k2.putString("3_method", str2);
            this.a.j("fb_mobile_login_method_complete", k2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void d(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            Bundle k2 = k(str);
            k2.putString("3_method", str2);
            this.a.j("fb_mobile_login_method_not_tried", k2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void e(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            Bundle k2 = k(str);
            k2.putString("3_method", str2);
            this.a.j("fb_mobile_login_method_start", k2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void f(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            Bundle k2 = k(str);
            if (code != null) {
                k2.putString("2_result", code.getLoggingValue());
            }
            if (exc != null && exc.getMessage() != null) {
                k2.putString("5_error_message", exc.getMessage());
            }
            JSONObject jSONObject = map.isEmpty() ? null : new JSONObject(map);
            if (map2 != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            if (jSONObject != null) {
                k2.putString("6_extras", jSONObject.toString());
            }
            this.a.j("fb_mobile_login_complete", k2);
            if (code == LoginClient.Result.Code.SUCCESS) {
                g(str);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void h(LoginClient.Request request) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            Bundle k2 = k(request.b());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("login_behavior", request.j().toString());
                jSONObject.put("request_code", LoginClient.s());
                jSONObject.put("permissions", TextUtils.join(",", request.k()));
                jSONObject.put("default_audience", request.f().toString());
                jSONObject.put("isReauthorize", request.m());
                String str = this.c;
                if (str != null) {
                    jSONObject.put("facebookVersion", str);
                }
                k2.putString("6_extras", jSONObject.toString());
            } catch (JSONException unused) {
            }
            this.a.k("fb_mobile_login_start", null, k2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void i(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            j(str, str2, "");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void j(String str, String str2, String str3) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            Bundle k2 = k("");
            k2.putString("2_result", LoginClient.Result.Code.ERROR.getLoggingValue());
            k2.putString("5_error_message", str2);
            k2.putString("3_method", str3);
            this.a.j(str, k2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
