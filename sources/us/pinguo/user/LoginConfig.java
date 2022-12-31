package us.pinguo.user;

import android.content.Context;
import java.util.Map;
/* loaded from: classes6.dex */
public class LoginConfig {
    private static LoginConfig b;
    private String a = "";

    public static void b(Context context, Map<String, String> map) {
        map.put("appkey", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.d.f10986e));
        u0.c(context, map);
    }

    public static void c(Context context, Map<String, String> map) {
        map.put("appkey", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.d.f10986e));
        u0.e(context, map);
    }

    public static LoginConfig getInstance() {
        if (b == null) {
            b = new LoginConfig();
        }
        return b;
    }

    public String a() {
        return this.a;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(String str) {
    }

    public void f(us.pinguo.user.b1.a aVar) {
    }
}
