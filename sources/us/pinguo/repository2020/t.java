package us.pinguo.repository2020;

import java.util.ArrayList;
/* compiled from: RedPointBridge.kt */
/* loaded from: classes6.dex */
public final class t {
    public static final t a = new t();
    private static final ArrayList<a> b = new ArrayList<>();

    /* compiled from: RedPointBridge.kt */
    /* loaded from: classes6.dex */
    public interface a {
        void a(String str);

        void b(String str);
    }

    private t() {
    }

    public final void a(a member) {
        kotlin.jvm.internal.s.h(member, "member");
        b.add(member);
    }

    public final void b(a self, String categoryId) {
        kotlin.jvm.internal.s.h(self, "self");
        kotlin.jvm.internal.s.h(categoryId, "categoryId");
        for (a aVar : b) {
            if (aVar != self) {
                aVar.a(categoryId);
            }
        }
    }

    public final void c(a self, String packageId) {
        kotlin.jvm.internal.s.h(self, "self");
        kotlin.jvm.internal.s.h(packageId, "packageId");
        for (a aVar : b) {
            if (aVar != self) {
                aVar.b(packageId);
            }
        }
    }
}
