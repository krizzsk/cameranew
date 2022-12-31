package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.GraphRequest;
import com.facebook.internal.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class FetchedAppSettingsManager {
    private static final String a = "FetchedAppSettingsManager";
    private static final String[] b = {"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting"};
    private static final Map<String, l> c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicReference<FetchAppSettingState> f3026d = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentLinkedQueue<d> f3027e = new ConcurrentLinkedQueue<>();

    /* renamed from: f  reason: collision with root package name */
    private static boolean f3028f = false;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static JSONArray f3029g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        a(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject;
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                SharedPreferences sharedPreferences = this.a.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                l lVar = null;
                String string = sharedPreferences.getString(this.b, null);
                if (!x.S(string)) {
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException e2) {
                        x.X("FacebookSDK", e2);
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        lVar = FetchedAppSettingsManager.l(this.c, jSONObject);
                    }
                }
                JSONObject i2 = FetchedAppSettingsManager.i(this.c);
                if (i2 != null) {
                    FetchedAppSettingsManager.l(this.c, i2);
                    sharedPreferences.edit().putString(this.b, i2.toString()).apply();
                }
                if (lVar != null) {
                    String k2 = lVar.k();
                    if (!FetchedAppSettingsManager.f3028f && k2 != null && k2.length() > 0) {
                        boolean unused = FetchedAppSettingsManager.f3028f = true;
                        Log.w(FetchedAppSettingsManager.a, k2);
                    }
                }
                k.m(this.c, true);
                com.facebook.appevents.internal.c.d();
                com.facebook.appevents.internal.g.h();
                FetchedAppSettingsManager.f3026d.set(FetchedAppSettingsManager.c.containsKey(this.c) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR);
                FetchedAppSettingsManager.n();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                this.a.a();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        final /* synthetic */ d a;
        final /* synthetic */ l b;

        c(d dVar, l lVar) {
            this.a = dVar;
            this.b = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                this.a.b(this.b);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b(l lVar);
    }

    public static void h(d dVar) {
        f3027e.add(dVar);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject i(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(b))));
        GraphRequest J = GraphRequest.J(null, str, null);
        J.a0(true);
        J.Z(bundle);
        return J.g().h();
    }

    @Nullable
    public static l j(String str) {
        if (str != null) {
            return c.get(str);
        }
        return null;
    }

    public static void k() {
        Context f2 = com.facebook.f.f();
        String g2 = com.facebook.f.g();
        if (x.S(g2)) {
            f3026d.set(FetchAppSettingState.ERROR);
            n();
        } else if (c.containsKey(g2)) {
            f3026d.set(FetchAppSettingState.SUCCESS);
            n();
        } else {
            AtomicReference<FetchAppSettingState> atomicReference = f3026d;
            FetchAppSettingState fetchAppSettingState = FetchAppSettingState.NOT_LOADED;
            FetchAppSettingState fetchAppSettingState2 = FetchAppSettingState.LOADING;
            if (!(atomicReference.compareAndSet(fetchAppSettingState, fetchAppSettingState2) || atomicReference.compareAndSet(FetchAppSettingState.ERROR, fetchAppSettingState2))) {
                n();
            } else {
                com.facebook.f.p().execute(new a(f2, String.format("com.facebook.internal.APP_SETTINGS.%s", g2), g2));
            }
        }
    }

    protected static l l(String str, JSONObject jSONObject) {
        FacebookRequestErrorClassification b2;
        JSONArray optJSONArray = jSONObject.optJSONArray("android_sdk_error_categories");
        if (optJSONArray == null) {
            b2 = FacebookRequestErrorClassification.c();
        } else {
            b2 = FacebookRequestErrorClassification.b(optJSONArray);
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = b2;
        int optInt = jSONObject.optInt("app_events_feature_bitmask", 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean z5 = (optInt & 16384) != 0;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("auto_event_mapping_android");
        f3029g = optJSONArray2;
        if (optJSONArray2 != null && p.b()) {
            com.facebook.appevents.codeless.internal.c.b(optJSONArray2.toString());
        }
        l lVar = new l(jSONObject.optBoolean("supports_implicit_sdk_logging", false), jSONObject.optString("gdpv4_nux_content", ""), jSONObject.optBoolean("gdpv4_nux_enabled", false), jSONObject.optInt("app_events_session_timeout", com.facebook.appevents.internal.d.a()), SmartLoginOption.parseOptions(jSONObject.optLong("seamless_login")), m(jSONObject.optJSONObject("android_dialog_configs")), z, facebookRequestErrorClassification, jSONObject.optString("smart_login_bookmark_icon_url"), jSONObject.optString("smart_login_menu_icon_url"), z2, z3, optJSONArray2, jSONObject.optString("sdk_update_message"), z4, z5, jSONObject.optString("aam_rules"), jSONObject.optString("suggested_events_setting"), jSONObject.optString("restrictive_data_filter_params"));
        c.put(str, lVar);
        return lVar;
    }

    private static Map<String, Map<String, l.a>> m(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                l.a e2 = l.a.e(optJSONArray.optJSONObject(i2));
                if (e2 != null) {
                    String a2 = e2.a();
                    Map map = (Map) hashMap.get(a2);
                    if (map == null) {
                        map = new HashMap();
                        hashMap.put(a2, map);
                    }
                    map.put(e2.c(), e2);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void n() {
        synchronized (FetchedAppSettingsManager.class) {
            FetchAppSettingState fetchAppSettingState = f3026d.get();
            if (!FetchAppSettingState.NOT_LOADED.equals(fetchAppSettingState) && !FetchAppSettingState.LOADING.equals(fetchAppSettingState)) {
                l lVar = c.get(com.facebook.f.g());
                Handler handler = new Handler(Looper.getMainLooper());
                if (FetchAppSettingState.ERROR.equals(fetchAppSettingState)) {
                    while (true) {
                        ConcurrentLinkedQueue<d> concurrentLinkedQueue = f3027e;
                        if (concurrentLinkedQueue.isEmpty()) {
                            return;
                        }
                        handler.post(new b(concurrentLinkedQueue.poll()));
                    }
                } else {
                    while (true) {
                        ConcurrentLinkedQueue<d> concurrentLinkedQueue2 = f3027e;
                        if (concurrentLinkedQueue2.isEmpty()) {
                            return;
                        }
                        handler.post(new c(concurrentLinkedQueue2.poll(), lVar));
                    }
                }
            }
        }
    }

    @Nullable
    public static l o(String str, boolean z) {
        if (!z) {
            Map<String, l> map = c;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        JSONObject i2 = i(str);
        if (i2 == null) {
            return null;
        }
        l l2 = l(str, i2);
        if (str.equals(com.facebook.f.g())) {
            f3026d.set(FetchAppSettingState.SUCCESS);
            n();
        }
        return l2;
    }
}
