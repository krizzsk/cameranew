package com.tapjoy.internal;

import android.os.Build;
import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class ds {
    public dr a;
    public cr b;
    public dc c;

    /* renamed from: d  reason: collision with root package name */
    public int f7369d;

    /* renamed from: e  reason: collision with root package name */
    public long f7370e;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ int[] f7371d = {1, 2, 3};
    }

    public ds() {
        d();
        this.a = new dr(null);
    }

    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WebView webView) {
        this.a = new dr(webView);
    }

    public final void a(cz czVar, cu cuVar) {
        String str = czVar.f7355f;
        JSONObject jSONObject = new JSONObject();
        dm.a(jSONObject, JsonMarshaller.ENVIRONMENT, "app");
        dm.a(jSONObject, "adSessionType", cuVar.f7349f);
        JSONObject jSONObject2 = new JSONObject();
        dm.a(jSONObject2, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        dm.a(jSONObject2, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        dm.a(jSONObject2, "os", Constants.PLATFORM_ANDROID);
        dm.a(jSONObject, "deviceInfo", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        dm.a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        dm.a(jSONObject3, "partnerName", cuVar.a.a);
        dm.a(jSONObject3, "partnerVersion", cuVar.a.b);
        dm.a(jSONObject, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        dm.a(jSONObject4, "libraryVersion", "1.2.19-Tapjoy");
        dm.a(jSONObject4, RemoteConfigConstants.RequestFieldKey.APP_ID, df.a().a.getApplicationContext().getPackageName());
        dm.a(jSONObject, "app", jSONObject4);
        String str2 = cuVar.f7348e;
        if (str2 != null) {
            dm.a(jSONObject, "customReferenceData", str2);
        }
        JSONObject jSONObject5 = new JSONObject();
        for (cy cyVar : Collections.unmodifiableList(cuVar.c)) {
            dm.a(jSONObject5, cyVar.a, cyVar.c);
        }
        dg.a().a(c(), "startSession", str, jSONObject, jSONObject5);
    }

    public final void a(String str) {
        dg.a().a(c(), str, (JSONObject) null);
    }

    public final void a(String str, JSONObject jSONObject) {
        dg.a().a(c(), str, jSONObject);
    }

    public void b() {
        this.a.clear();
    }

    public final WebView c() {
        return (WebView) this.a.get();
    }

    public final void d() {
        this.f7370e = System.nanoTime();
        this.f7369d = a.a;
    }

    public final void a(float f2) {
        dg.a().a(c(), "setDeviceVolume", Float.valueOf(f2));
    }
}
