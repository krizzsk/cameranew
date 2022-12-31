package us.pinguo.webview.f.h;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RespSign.java */
/* loaded from: classes6.dex */
public class d0 extends us.pinguo.webview.f.e {
    private String c;

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        if (TextUtils.isEmpty(this.c)) {
            a.put("sig", "[]");
        } else {
            a.put("sig", this.c);
        }
        return a;
    }

    public void b(String str) {
        this.c = str;
    }
}
