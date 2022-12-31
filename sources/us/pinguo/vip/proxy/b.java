package us.pinguo.vip.proxy;

import kotlin.jvm.internal.s;
/* compiled from: VipProxy.kt */
/* loaded from: classes6.dex */
public final class b {
    public static final b a = new b();
    public static a b;

    private b() {
    }

    public static /* synthetic */ boolean b(b bVar, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return bVar.a(z);
    }

    public final boolean a(boolean z) {
        return c().c(z);
    }

    public final a c() {
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        s.z("vipManagerProxy");
        throw null;
    }

    public final boolean d() {
        return c().b();
    }

    public final boolean e(String str) {
        if (str == null) {
            return false;
        }
        return c().d(str);
    }

    public final boolean f() {
        return c().a();
    }

    public final void g(a aVar) {
        s.h(aVar, "<set-?>");
        b = aVar;
    }
}
