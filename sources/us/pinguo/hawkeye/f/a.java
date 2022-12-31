package us.pinguo.hawkeye.f;

import android.util.Log;
/* compiled from: HLog.kt */
/* loaded from: classes4.dex */
public final class a {
    private static boolean a;
    public static final a b = new a();

    private a() {
    }

    public static final void a(String str) {
        if (!a || str == null) {
            return;
        }
        Log.d("HawkeyeD", str);
    }

    public static final void b(String str) {
        if (!a || str == null) {
            return;
        }
        Log.i("HawkeyeI", str);
    }

    public final void c(boolean z) {
        a = z;
    }
}
