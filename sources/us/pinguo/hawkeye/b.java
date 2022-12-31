package us.pinguo.hawkeye;

import android.os.Build;
import android.os.Debug;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.s;
import us.pinguo.hawkeye.g.e;
import us.pinguo.hawkeye.model.HawkeyeModel;
/* compiled from: HawkeyeSDK.kt */
/* loaded from: classes4.dex */
public final class b {
    private static a a;
    private static c c;

    /* renamed from: d  reason: collision with root package name */
    private static us.pinguo.hawkeye.model.b f11143d;

    /* renamed from: f  reason: collision with root package name */
    public static final b f11145f = new b();
    private static final HawkeyeModel b = new HawkeyeModel();

    /* renamed from: e  reason: collision with root package name */
    private static final ArrayList<us.pinguo.hawkeye.e.a> f11144e = new ArrayList<>();

    private b() {
    }

    public final void a(us.pinguo.hawkeye.e.a listener) {
        s.i(listener, "listener");
        f11144e.add(listener);
    }

    public final void b(long j2) {
        int a2;
        us.pinguo.hawkeye.model.b bVar = f11143d;
        if (bVar == null || (a2 = bVar.a(j2)) == -1) {
            return;
        }
        for (us.pinguo.hawkeye.e.a aVar : f11144e) {
            aVar.a(bVar.d(), a2);
        }
    }

    public final a c() {
        a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        s.z("config");
        throw null;
    }

    public final void d(a config) {
        s.i(config, "config");
        a = config;
        us.pinguo.hawkeye.f.a.b.c(config.b());
        us.pinguo.hawkeye.f.a.a("init sdk with config " + config);
        if (!config.c() || Build.VERSION.SDK_INT < 16) {
            return;
        }
        c cVar = new c();
        c = cVar;
        if (cVar != null) {
            cVar.a();
        } else {
            s.t();
            throw null;
        }
    }

    public final void e(String str) {
        us.pinguo.hawkeye.model.b bVar = b.b().get(str);
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (bVar.e() == null) {
            Iterator<T> it = f11144e.iterator();
            if (it.hasNext()) {
                us.pinguo.hawkeye.e.a aVar = (us.pinguo.hawkeye.e.a) it.next();
                bVar.d();
                us.pinguo.hawkeye.d.c c2 = bVar.c();
                if (c2 == null) {
                    s.t();
                    throw null;
                } else {
                    c2.a();
                    throw null;
                }
            }
        } else {
            Iterator<T> it2 = f11144e.iterator();
            if (it2.hasNext()) {
                us.pinguo.hawkeye.e.a aVar2 = (us.pinguo.hawkeye.e.a) it2.next();
                bVar.d();
                us.pinguo.hawkeye.d.c e2 = bVar.e();
                if (e2 == null) {
                    s.t();
                    throw null;
                } else {
                    e2.a();
                    throw null;
                }
            }
        }
        a aVar3 = a;
        if (aVar3 == null) {
            s.z("config");
            throw null;
        } else if (aVar3.a()) {
            us.pinguo.hawkeye.debug.b bVar2 = us.pinguo.hawkeye.debug.b.a;
            if (bVar2.c(bVar.d())) {
                us.pinguo.hawkeye.f.a.a("stopMethodTracing");
                Debug.stopMethodTracing();
            }
            if (bVar2.b(bVar.d())) {
                us.pinguo.hawkeye.debug.c.b(str).f("pageDrawn");
            }
        }
    }

    public final void f() {
        e.b.a().c(b);
    }
}
