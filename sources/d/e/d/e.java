package d.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.service.TokenService;
import d.e.a.a;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: IronSourceNetwork.java */
/* loaded from: classes2.dex */
public class e {
    private static f a;
    private static d.e.d.n.d b;
    private static JSONObject c;

    public static synchronized void a(JSONObject jSONObject) {
        synchronized (e.class) {
            f fVar = a;
            if (fVar == null) {
                return;
            }
            if (jSONObject == null) {
                return;
            }
            fVar.b(jSONObject);
        }
    }

    public static synchronized ISNAdView b(Activity activity, b bVar) throws Exception {
        ISNAdView g2;
        synchronized (e.class) {
            s();
            g2 = a.g(activity, bVar);
        }
        return g2;
    }

    public static d.e.d.n.d c() {
        return b;
    }

    public static synchronized void d(d.e.d.n.e eVar) throws Exception {
        synchronized (e.class) {
            s();
            a.r(eVar);
        }
    }

    public static synchronized JSONObject e(Context context) {
        JSONObject l2;
        synchronized (e.class) {
            l2 = TokenService.getInstance().l(context);
        }
        return l2;
    }

    public static synchronized String f(Context context) {
        String m;
        synchronized (e.class) {
            m = TokenService.getInstance().m(context);
        }
        return m;
    }

    public static synchronized void g(String str, Map<String, String> map, d.e.d.n.b bVar) throws Exception {
        synchronized (e.class) {
            s();
            a.w(str, map, bVar);
        }
    }

    public static synchronized void h(Map<String, String> map, d.e.d.n.e eVar) throws Exception {
        synchronized (e.class) {
            s();
            a.J(map, eVar);
        }
    }

    public static synchronized void i(Context context, String str, String str2, Map<String, String> map) {
        synchronized (e.class) {
            if (TextUtils.isEmpty(str)) {
                com.ironsource.sdk.utils.d.b("IronSourceNetwork", "applicationKey is NULL");
                return;
            }
            if (a == null) {
                com.ironsource.sdk.utils.f.H(map);
                try {
                    JSONObject optJSONObject = com.ironsource.sdk.utils.f.q().optJSONObject("events");
                    if (optJSONObject != null) {
                        j(context, optJSONObject, str2, str, map);
                    }
                } catch (Exception e2) {
                    com.ironsource.sdk.utils.d.b("IronSourceNetwork", "Failed to init event tracker: " + e2.getMessage());
                }
                a = d.e.d.k.b.R(context, str, str2);
                a(c);
            }
        }
    }

    private static void j(Context context, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        a a2 = d.e.d.a.e.a(jSONObject);
        if (a2.a()) {
            d.e.d.a.d.b(a2, d.e.d.a.e.b(context, str, str2, map));
        }
    }

    public static synchronized boolean k(c cVar) {
        synchronized (e.class) {
            f fVar = a;
            if (fVar == null) {
                return false;
            }
            return fVar.n(cVar);
        }
    }

    public static synchronized void l(Activity activity, c cVar, Map<String, String> map) throws Exception {
        synchronized (e.class) {
            s();
            a.i(activity, cVar, map);
        }
    }

    public static synchronized void m(Activity activity) {
        synchronized (e.class) {
            f fVar = a;
            if (fVar == null) {
                return;
            }
            fVar.c(activity);
        }
    }

    public static synchronized void n(Activity activity) {
        synchronized (e.class) {
            f fVar = a;
            if (fVar == null) {
                return;
            }
            fVar.a(activity);
        }
    }

    public static synchronized void o(d.e.d.n.d dVar) {
        synchronized (e.class) {
            b = dVar;
        }
    }

    public static synchronized void p(c cVar, Map<String, String> map) throws Exception {
        synchronized (e.class) {
            s();
            a.k(cVar, map);
        }
    }

    public static synchronized void q(Activity activity, Map<String, String> map) throws Exception {
        synchronized (e.class) {
            s();
            a.f(activity, map);
        }
    }

    public static synchronized void r(JSONObject jSONObject) {
        synchronized (e.class) {
            TokenService.getInstance().p(jSONObject);
        }
    }

    private static synchronized void s() throws Exception {
        synchronized (e.class) {
            if (a == null) {
                throw new NullPointerException("Call initSDK first");
            }
        }
    }
}
