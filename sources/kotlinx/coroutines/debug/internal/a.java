package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.s;
import kotlinx.coroutines.internal.c0;
/* compiled from: ConcurrentWeakMap.kt */
/* loaded from: classes3.dex */
public final class a {
    private static final c0 a = new c0("REHASH");
    private static final e b = new e(null);
    private static final e c = new e(Boolean.TRUE);

    public static final /* synthetic */ Void c() {
        e();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e d(Object obj) {
        if (obj == null) {
            return b;
        }
        return s.c(obj, Boolean.TRUE) ? c : new e(obj);
    }

    private static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
