package us.pinguo.camera360.shop.data.m;

import java.util.HashSet;
import kotlin.jvm.internal.s;
/* compiled from: UnityClearManager.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final d a = new d();
    private static final HashSet<String> b = new HashSet<>();
    private static final HashSet<String> c = new HashSet<>();

    static {
        new HashSet();
    }

    private d() {
    }

    public final void a(String id) {
        s.h(id, "id");
        b.remove(id);
        c.remove(id);
    }

    public final void b(String id) {
        s.h(id, "id");
        c.add(id);
    }

    public final void c(String id) {
        s.h(id, "id");
        b.add(id);
    }
}
