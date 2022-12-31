package us.pinguo.webview.f;

import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.webview.PGJsWebView;
import us.pinguo.webview.f.a;
import us.pinguo.webview.f.e;
/* compiled from: PGBusiness.java */
/* loaded from: classes6.dex */
public abstract class b<T extends a, K extends e> {
    private String a;
    private String b;
    private T c;

    public String a() {
        return this.a;
    }

    public T b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T c(JSONObject jSONObject) throws JSONException;

    public void d(PGJsWebView pGJsWebView, K k2) {
        try {
            f.b(pGJsWebView, this.b, k2.a());
        } catch (JSONException e2) {
            try {
                f.b(pGJsWebView, this.b, new e(10700, "Json组合异常").a());
            } catch (JSONException e3) {
                us.pinguo.common.log.a.f(e3);
            }
            us.pinguo.common.log.a.f(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(T t) {
        this.c = t;
    }
}
