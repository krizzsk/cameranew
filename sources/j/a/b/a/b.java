package j.a.b.a;

import us.pinguo.librouter.application.BaseApplication;
/* compiled from: HawkeyePreference.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final boolean a() {
        return BaseApplication.d().getSharedPreferences("hawkeye_pref_file", 0).getBoolean("hawkeye_fps", false);
    }

    public final boolean b() {
        return BaseApplication.d().getSharedPreferences("hawkeye_pref_file", 0).getBoolean("hawkeye_gl_fps", true);
    }

    public final void c(boolean z) {
        BaseApplication.d().getSharedPreferences("hawkeye_pref_file", 0).edit().putBoolean("hawkeye_fps", z).apply();
    }

    public final void d(boolean z) {
        BaseApplication.d().getSharedPreferences("hawkeye_pref_file", 0).edit().putBoolean("hawkeye_gl_fps", z).apply();
    }
}
