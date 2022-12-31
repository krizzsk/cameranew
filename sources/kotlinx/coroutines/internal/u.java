package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.g2;
/* compiled from: MainDispatchers.kt */
/* loaded from: classes3.dex */
public final class u {
    private static final boolean a = true;

    private static final v a(Throwable th, String str) {
        if (a) {
            return new v(th, str);
        }
        if (th == null) {
            c();
            throw null;
        }
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ v b(Throwable th, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final Void c() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final g2 d(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, mainDispatcherFactory.hintOnError());
        }
    }
}
