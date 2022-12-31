package us.pinguo.hawkeye.debug;

import java.util.Set;
import kotlin.jvm.internal.s;
import us.pinguo.hawkeye.InternalPref;
/* compiled from: DebugSettings.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final String d(String str) {
        return str + "_DebugHelper";
    }

    private final String e(String str) {
        return str + "_MethodTracing";
    }

    public final Set<String> a() {
        Set<String> b = InternalPref.getInstance().b("key_hawkeye_saved_pages_set");
        s.d(b, "InternalPref.getInstance…_HAWKEYE_SAVED_PAGES_SET)");
        return b;
    }

    public final boolean b(String key) {
        s.i(key, "key");
        return InternalPref.getInstance().a(d(key), false);
    }

    public final boolean c(String key) {
        s.i(key, "key");
        return InternalPref.getInstance().a(e(key), false);
    }

    public final void f(String key, boolean z) {
        s.i(key, "key");
        InternalPref.getInstance().c(d(key), z);
    }

    public final void g(String key, boolean z) {
        s.i(key, "key");
        InternalPref.getInstance().c(e(key), z);
    }
}
