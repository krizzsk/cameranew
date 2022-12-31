package com.ironsource.sdk.service;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.e;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TokenService {
    private static TokenService b;
    private JSONObject a = new JSONObject();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TokenService.this.o(c.a(this.a));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private TokenService() {
    }

    public static synchronized TokenService getInstance() {
        TokenService tokenService;
        synchronized (TokenService.class) {
            if (b == null) {
                b = new TokenService();
            }
            tokenService = b;
        }
        return tokenService;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            new Thread(new a(context)).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str) {
        if (str != null) {
            n("applicationKey", f.c(str));
        }
    }

    public void c(String str) {
        if (str != null) {
            n("applicationUserId", f.c(str));
        }
    }

    public void d(Activity activity) {
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            n(f.c("immersiveMode"), Boolean.valueOf(e.Q(activity)));
        }
        n("appOrientation", f.K(e.c(activity)));
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            n("chinaCDN", new JSONObject(str).opt("chinaCDN"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void f(Context context) {
        if (context == null) {
            return;
        }
        o(c.c(context));
        o(c.b(context));
    }

    public void g(Map<String, String> map) {
        if (map == null) {
            Log.d("TokenService", "collectDataFromExternalParams params=null");
            return;
        }
        for (String str : map.keySet()) {
            n(str, f.c(map.get(str)));
        }
    }

    public void h() {
        HashMap hashMap = new HashMap();
        hashMap.put("omidVersion", d.d.a.a.a.a.b());
        hashMap.put("omidPartnerVersion", "7");
        b.g(hashMap);
    }

    public void i() {
        if (IronSourceQaProperties.b()) {
            b.g(IronSourceQaProperties.getInstance().a());
        }
    }

    public void j(Context context, String str, String str2) {
        a(context);
        if (context instanceof Activity) {
            d((Activity) context);
        }
        f(context);
        c(str2);
        b(str);
    }

    public void k() {
        e(f.k());
        g(f.o());
        i();
        h();
    }

    public JSONObject l(Context context) {
        k();
        f(context);
        try {
            return new JSONObject(this.a.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    public String m(Context context) {
        try {
            return d.a(l(context).toString());
        } catch (Exception unused) {
            return d.a(new JSONObject().toString());
        }
    }

    synchronized void n(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void o(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            n(next, jSONObject.opt(next));
        }
    }

    public void p(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            n("metadata_" + next, jSONObject.opt(next));
        }
    }
}
