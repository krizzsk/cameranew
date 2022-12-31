package kotlin.x;

import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: Thread.kt */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: Thread.kt */
    /* renamed from: kotlin.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0320a extends Thread {
        final /* synthetic */ kotlin.jvm.b.a<u> a;

        C0320a(kotlin.jvm.b.a<u> aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.a.invoke();
        }
    }

    public static final Thread a(boolean z, boolean z2, ClassLoader classLoader, String str, int i2, kotlin.jvm.b.a<u> block) {
        s.h(block, "block");
        C0320a c0320a = new C0320a(block);
        if (z2) {
            c0320a.setDaemon(true);
        }
        if (i2 > 0) {
            c0320a.setPriority(i2);
        }
        if (str != null) {
            c0320a.setName(str);
        }
        if (classLoader != null) {
            c0320a.setContextClassLoader(classLoader);
        }
        if (z) {
            c0320a.start();
        }
        return c0320a;
    }
}
