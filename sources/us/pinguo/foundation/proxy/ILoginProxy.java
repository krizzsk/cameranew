package us.pinguo.foundation.proxy;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
/* loaded from: classes4.dex */
public interface ILoginProxy {
    void a(Activity activity, int i2, String str);

    int b();

    String[] c();

    String d();

    boolean e();

    Map<String, String> f(Context context);

    String g();

    String getUserId();

    String h();

    String i(Map<String, String> map);

    String j();

    void k();

    void onLogin();

    void onLogout();
}
