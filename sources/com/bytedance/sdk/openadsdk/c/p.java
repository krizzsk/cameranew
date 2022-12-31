package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.tencent.stat.DeviceInfo;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* compiled from: WebviewTimeTrack.java */
/* loaded from: classes.dex */
public class p {
    private String a;
    private com.bytedance.sdk.openadsdk.core.d.h b;
    private Boolean c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f1419d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f1420e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f1421f;

    public p(int i2, String str, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.c = bool;
        this.f1419d = bool;
        this.f1420e = bool;
        this.a = str;
        this.b = hVar;
        JSONObject jSONObject = new JSONObject();
        this.f1421f = jSONObject;
        a(jSONObject, "webview_source", Integer.valueOf(i2));
    }

    private boolean j() {
        return this.f1420e.booleanValue() || (this.f1419d.booleanValue() && this.c.booleanValue());
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(this.f1421f, "render_start", jSONObject);
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(this.f1421f, "render_success", jSONObject);
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(this.f1421f, "native_render_start", jSONObject);
    }

    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(this.f1421f, "native_render_end", jSONObject);
    }

    public void e() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(this.f1421f, "webview_load_start", jSONObject);
    }

    public void f() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(this.f1421f, "webview_load_success", jSONObject);
    }

    public void g() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(this.f1421f, "webview_load_error", jSONObject);
    }

    public void h() {
        this.c = Boolean.TRUE;
    }

    public void i() {
        if (j()) {
            HashMap hashMap = new HashMap();
            hashMap.put("webview_time_track", this.f1421f);
            d.e(com.bytedance.sdk.openadsdk.core.o.a(), this.b, this.a, "webview_time_track", hashMap);
        }
    }

    public void a(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(jSONObject, "code", Integer.valueOf(i2));
        a(this.f1421f, "render_error", jSONObject);
    }

    public void b(String str, long j2, long j3, int i2) {
        if (TextUtils.isEmpty(str) || j3 < j2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(j2));
        a(jSONObject, "url", str);
        a(jSONObject, "intercept_type", Integer.valueOf(i2));
        a(this.f1421f, "intercept_js_start", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(j3));
        a(jSONObject2, "url", str);
        a(jSONObject2, "intercept_type", Integer.valueOf(i2));
        a(this.f1421f, "intercept_js_end", jSONObject2);
    }

    public void a(String str, long j2, long j3, int i2) {
        if (TextUtils.isEmpty(str) || j3 < j2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(j2));
        a(jSONObject, "url", str);
        a(jSONObject, "intercept_type", Integer.valueOf(i2));
        a(this.f1421f, "intercept_html_start", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(j3));
        a(jSONObject2, "url", str);
        a(jSONObject2, "intercept_type", Integer.valueOf(i2));
        a(this.f1421f, "intercept_html_end", jSONObject2);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(jSONObject, "jsb", str);
        a(this.f1421f, "webview_jsb_end", jSONObject);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, DeviceInfo.TAG_TIMESTAMPS, Long.valueOf(currentTimeMillis));
        a(jSONObject, "jsb", str);
        a(this.f1421f, "webview_jsb_start", jSONObject);
    }

    public void a(JSONObject jSONObject) {
        if (this.f1421f == null || jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(this.f1421f, next, jSONObject.opt(next));
        }
        this.f1419d = Boolean.TRUE;
        i();
    }

    public void a(boolean z) {
        this.f1420e = Boolean.valueOf(z);
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                jSONObject.put(str, obj);
            } catch (Exception unused) {
            }
        }
    }
}
