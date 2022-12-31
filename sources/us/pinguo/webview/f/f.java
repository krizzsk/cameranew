package us.pinguo.webview.f;

import android.text.TextUtils;
import org.json.JSONObject;
import us.pinguo.webview.PGJsWebView;
import us.pinguo.webview.f.g;
/* compiled from: RspFactory.java */
/* loaded from: classes6.dex */
public final class f {
    public static void a(PGJsWebView pGJsWebView, String str, g.b... bVarArr) {
        String sb;
        if (pGJsWebView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (bVarArr.length <= 0) {
            sb = "";
        } else if (bVarArr.length == 1) {
            sb = bVarArr[0].getValue();
        } else {
            StringBuilder sb2 = new StringBuilder();
            int i2 = 0;
            while (i2 < bVarArr.length - 1) {
                sb2.append(bVarArr[i2].getValue());
                sb2.append(',');
                i2++;
            }
            sb2.append(bVarArr[i2].getValue());
            sb = sb2.toString();
        }
        us.pinguo.common.log.a.e("rsp function:" + str + "/" + sb, new Object[0]);
        pGJsWebView.j("try{" + str + "(" + sb + ")}catch(e){}");
    }

    public static void b(PGJsWebView pGJsWebView, String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("responseId", str);
            jSONObject2.put("responseData", jSONObject);
            a(pGJsWebView, "WebViewJavascriptBridge._handleMessageFromObjC", g.a(jSONObject2.toString()));
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    public static void c(PGJsWebView pGJsWebView, String str) {
        if (pGJsWebView == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("channel", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            } else {
                jSONObject.put("channel", str);
            }
            a(pGJsWebView, "WebViewJavascriptBridge._handleWebShare", g.a(jSONObject.toString()));
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }
}
