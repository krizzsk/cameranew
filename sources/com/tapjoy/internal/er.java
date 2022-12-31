package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPrivacyPolicy;
import com.tapjoy.TJSetUserIDListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public abstract class er {
    private static final er c;

    /* renamed from: d  reason: collision with root package name */
    private static er f7418d;
    protected volatile boolean a = false;
    protected volatile boolean b = false;

    static {
        fx.a();
        fp.a();
        et etVar = new et();
        c = etVar;
        f7418d = etVar;
    }

    public static er a() {
        return f7418d;
    }

    public abstract TJPlacement a(String str, TJPlacementListener tJPlacementListener);

    public abstract void a(float f2);

    public abstract void a(int i2);

    public abstract void a(int i2, TJAwardCurrencyListener tJAwardCurrencyListener);

    public abstract void a(int i2, TJSpendCurrencyListener tJSpendCurrencyListener);

    public abstract void a(int i2, String str);

    public abstract void a(Activity activity);

    public abstract void a(Context context, Map map);

    public abstract void a(GLSurfaceView gLSurfaceView);

    public abstract void a(TJEarnedCurrencyListener tJEarnedCurrencyListener);

    public abstract void a(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener);

    public abstract void a(TJVideoListener tJVideoListener);

    public abstract void a(String str);

    public abstract void a(String str, long j2);

    public abstract void a(String str, TJSetUserIDListener tJSetUserIDListener);

    public abstract void a(String str, String str2);

    public abstract void a(String str, String str2, double d2, String str3);

    public abstract void a(String str, String str2, long j2);

    public abstract void a(String str, String str2, String str3, String str4);

    public abstract void a(String str, String str2, String str3, String str4, long j2);

    public abstract void a(String str, String str2, String str3, String str4, String str5, long j2);

    public abstract void a(String str, String str2, String str3, String str4, String str5, long j2, String str6, long j3);

    public abstract void a(String str, String str2, String str3, String str4, String str5, long j2, String str6, long j3, String str7, long j4);

    public abstract void a(String str, String str2, String str3, String str4, Map map);

    public abstract void a(Set set);

    public abstract void a(boolean z);

    public abstract boolean a(Context context, String str);

    public abstract boolean a(Context context, String str, TJConnectListener tJConnectListener);

    public abstract boolean a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener);

    public abstract TJPlacement b(String str, TJPlacementListener tJPlacementListener);

    public abstract String b();

    public abstract void b(int i2);

    public abstract void b(Activity activity);

    public abstract void b(String str);

    public abstract void b(String str, String str2, String str3, String str4);

    public abstract void b(boolean z);

    public abstract float c();

    public abstract void c(Activity activity);

    public abstract void c(String str);

    public abstract void c(boolean z);

    public abstract void d();

    public abstract void d(String str);

    public abstract void d(boolean z);

    public abstract void e();

    public abstract void e(String str);

    public abstract Set f();

    public abstract void f(String str);

    public abstract String g(String str);

    public abstract void g();

    public abstract void h(String str);

    public abstract boolean h();

    public abstract void i(String str);

    public abstract boolean i();

    public abstract void j(String str);

    public abstract boolean j();

    public abstract String k();

    public abstract String l();

    public abstract TJPrivacyPolicy m();
}
