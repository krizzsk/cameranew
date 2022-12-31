package us.pinguo.camera360.shop.manager;

import android.text.TextUtils;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.io.UnsupportedEncodingException;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.user.User;
/* loaded from: classes4.dex */
public class ExceptionStatManager {
    private static final String a = "ExceptionStatManager";
    private static final ExceptionStatManager b = new ExceptionStatManager();

    private ExceptionStatManager() {
    }

    private String a(Request request) {
        try {
            return new String(request.getBody(), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean b(Request request) {
        return request == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(String str) {
        String str2 = a;
        us.pinguo.common.log.a.m(str2, "report success:" + str, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(Throwable th) {
        String str = a;
        us.pinguo.common.log.a.g(str, "report failed:" + th.toString(), new Object[0]);
    }

    public static ExceptionStatManager getInstance() {
        return b;
    }

    public void e(int i2, String str, String str2, String str3, int i3) {
        PGRequest.Builder builder = new PGRequest.Builder(String.class);
        builder.withMethod(1).withDomain(us.pinguo.camera360.shop.download.a.f9707e).withUriPath("/api/exception");
        if (User.d().n()) {
            builder.withUid(User.d().h().userId);
        }
        builder.addParam("type", Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            builder.addParam("url", str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.addParam("params", str2.trim());
        }
        builder.addParam("message", TextUtils.isEmpty(str3) ? "" : str3.trim());
        builder.addParam("feedback", Integer.valueOf(i3));
        RxVolley.create(builder.build()).subscribe(g.a, h.a);
    }

    public void f(Request request, String str) {
        if (b(request)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "Parse Json failed";
        }
        String a2 = a(request);
        e(2, request.getUrl(), a2, str, 0);
    }

    public void g(Request request, Integer num) {
        String str;
        if (b(request)) {
            return;
        }
        if (num != null) {
            str = "error status:" + num;
        } else {
            str = "data is null";
        }
        getInstance().f(request, str);
    }

    public void h(Request request, Throwable th) {
        if (b(request) || (th instanceof NoConnectionError)) {
            return;
        }
        String message = th.getMessage();
        if (th instanceof VolleyError) {
            NetworkResponse networkResponse = ((VolleyError) th).networkResponse;
            if (networkResponse != null) {
                String str = "StatusCode: " + networkResponse.statusCode;
                byte[] bArr = networkResponse.data;
                if (bArr != null && bArr.length > 0) {
                    try {
                        str = str + ", Data: " + new String(networkResponse.data, "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
                message = str;
            } else {
                message = th.toString();
            }
        }
        if (TextUtils.isEmpty(message)) {
            message = "Network error";
        }
        e(3, request.getUrl(), a(request), message, 0);
    }
}
