package com.huawei.hianalytics.v2.a.a;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5134d;

    /* renamed from: e  reason: collision with root package name */
    private String f5135e;

    /* renamed from: f  reason: collision with root package name */
    private String f5136f;

    /* renamed from: g  reason: collision with root package name */
    private String f5137g;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_rom_ver", Build.DISPLAY);
            jSONObject.put("_emui_ver", this.a);
            jSONObject.put("_lib_name", "hianalytics");
            jSONObject.put("_model", Build.MODEL);
            jSONObject.put("_mcc", this.f5136f);
            jSONObject.put("_mnc", this.f5137g);
            jSONObject.put("_package_name", this.b);
            jSONObject.put("_app_ver", this.c);
            jSONObject.put("_lib_ver", "2.0.0.309");
            jSONObject.put("_channel", this.f5134d);
            jSONObject.put("_oaid_tracking_flag", this.f5135e);
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("RomInfoData", "toJsonObj(): JSONException: room info toJsonObj exception");
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f5134d = str;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.f5135e = str;
    }

    public void f(String str) {
        this.f5136f = str;
    }

    public void g(String str) {
        this.f5137g = str;
    }
}
