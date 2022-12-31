package us.pinguo.webview.f.h;

import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RspDownloadImage.java */
/* loaded from: classes6.dex */
public class g0 extends us.pinguo.webview.f.e {
    private String c;

    public g0(int i2, String str) {
        super(i2, str);
    }

    @Override // us.pinguo.webview.f.e
    public JSONObject a() throws JSONException {
        JSONObject a = super.a();
        String str = this.c;
        if (str == null) {
            str = "";
        }
        a.put("localId", str);
        return a;
    }

    public void b(String str) {
        this.c = str;
    }

    public g0() {
    }
}
