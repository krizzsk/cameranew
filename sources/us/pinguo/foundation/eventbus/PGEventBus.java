package us.pinguo.foundation.eventbus;
/* loaded from: classes4.dex */
public class PGEventBus {
    private static PGEventBus a;

    private PGEventBus() {
        de.greenrobot.event.c.d();
    }

    public static PGEventBus getInstance() {
        if (a == null) {
            a = new PGEventBus();
        }
        return a;
    }

    public void a(a aVar) {
        de.greenrobot.event.c.d().g(aVar);
    }

    public void b(Object obj) {
        de.greenrobot.event.c.d().j(obj);
    }

    public void c(Object obj) {
        de.greenrobot.event.c.d().m(obj);
    }
}
