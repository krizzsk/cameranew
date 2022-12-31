package us.pinguo.camera2020.i;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.i;
import us.pinguo.repository2020.u;
import us.pinguo.vip.proxy.b;
import us.pinguo.vip.proxy.c;
/* compiled from: VipGuidePurchaseManager.kt */
/* loaded from: classes3.dex */
public final class a {
    private static boolean b = false;
    private static boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f9181d = "";

    /* renamed from: e  reason: collision with root package name */
    private static boolean f9182e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f9183f;
    public static final a a = new a();

    /* renamed from: g  reason: collision with root package name */
    private static final u<Boolean> f9184g = new u<>(Boolean.FALSE);

    private a() {
    }

    private final void n(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle == null ? null : bundle.getStringArrayList("camera_stat_attr_subscription");
        if (stringArrayList != null && (stringArrayList.isEmpty() ^ true)) {
            i iVar = h.b;
            iVar.p(stringArrayList.get(0), "goto_free_trial", stringArrayList.get(1), stringArrayList.get(2), stringArrayList.get(3), stringArrayList.get(4), stringArrayList.get(5), stringArrayList.get(6), stringArrayList.get(7));
            iVar.p(stringArrayList.get(0), "camera_shot", stringArrayList.get(1), stringArrayList.get(2), stringArrayList.get(3), stringArrayList.get(4), stringArrayList.get(5), stringArrayList.get(6), stringArrayList.get(7));
        }
    }

    public final boolean a() {
        return c;
    }

    public final boolean b() {
        return f9182e;
    }

    public final boolean c() {
        return b;
    }

    public final u<Boolean> d() {
        return f9184g;
    }

    public final boolean e() {
        return f9183f;
    }

    public final boolean f() {
        return b || (c && !b.a.e(f9181d)) || f9182e;
    }

    public final boolean g(Context context, Bundle bundle) {
        if (h()) {
            n(bundle);
            c.a.c(context, bundle, true);
            return true;
        }
        return false;
    }

    public final boolean h() {
        return f() && !b.b(b.a, false, 1, null);
    }

    public final void i(boolean z) {
        if (z != c) {
            c = z;
            f9184g.setValue(Boolean.valueOf(f()));
        }
    }

    public final void j(boolean z) {
        if (z != f9182e) {
            f9182e = z;
            f9184g.postValue(Boolean.valueOf(f()));
        }
    }

    public final void k(boolean z) {
        f9183f = z;
    }

    public final void l(boolean z) {
        if (z != b) {
            b = z;
            f9184g.setValue(Boolean.valueOf(f()));
        }
    }

    public final void m(String str) {
        s.h(str, "<set-?>");
        f9181d = str;
    }
}
