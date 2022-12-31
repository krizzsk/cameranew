package com.pinguo.camera360.lib.ui.js;

import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RespBindMobile.java */
/* loaded from: classes3.dex */
public class f extends us.pinguo.webview.f.e {
    private String c;

    public f(int i2, String str) {
        super(i2, str);
        this.c = null;
    }

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        String str = this.c;
        if (str == null) {
            str = "";
        }
        a.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, str);
        return a;
    }

    public void b(String str) {
        this.c = str;
    }

    public f() {
        this.c = null;
    }
}
