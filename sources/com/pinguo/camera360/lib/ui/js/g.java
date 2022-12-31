package com.pinguo.camera360.lib.ui.js;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RespChooseC360Img.java */
/* loaded from: classes3.dex */
public class g extends us.pinguo.webview.f.e {
    private String c;

    public g(int i2, String str) {
        super(i2, str);
        this.c = null;
    }

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        if (TextUtils.isEmpty(this.c)) {
            a.put("localIds", "[]");
        } else {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.c);
            a.put("localIds", jSONArray);
        }
        return a;
    }

    public void b(String str) {
        this.c = str;
    }

    public g() {
        this.c = null;
    }
}
