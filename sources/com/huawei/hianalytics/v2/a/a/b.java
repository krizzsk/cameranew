package com.huawei.hianalytics.v2.a.a;

import android.text.TextUtils;
import com.coremedia.iso.boxes.UserBox;
import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5125d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f5126e;

    /* renamed from: f  reason: collision with root package name */
    private String f5127f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("androidid", this.a);
            jSONObject.put("imei", this.b);
            jSONObject.put(UserBox.TYPE, this.c);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_ID_NAME, this.f5125d);
            jSONObject.put("oaid", this.f5126e);
            jSONObject.put("upid", this.f5127f);
        } catch (JSONException unused) {
            com.huawei.hianalytics.b.b.c("InfoData", "toJsonObj(): JSONException");
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f5125d = str;
    }

    public void b(String str) {
        this.f5126e = str;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.a = "";
        } else {
            this.a = str;
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b = "";
        } else {
            this.b = str;
        }
    }

    public void e(String str) {
        this.f5127f = str;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = "";
        } else {
            this.c = str;
        }
    }
}
