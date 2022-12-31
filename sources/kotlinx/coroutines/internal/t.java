package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.g2;
/* compiled from: MainDispatchers.kt */
/* loaded from: classes3.dex */
public final class t {
    public static final t a;
    private static final boolean b;
    public static final g2 c;

    static {
        t tVar = new t();
        a = tVar;
        b = d0.e("kotlinx.coroutines.fast.service.loader", true);
        c = tVar.a();
    }

    private t() {
    }

    private final g2 a() {
        kotlin.sequences.e c2;
        List<MainDispatcherFactory> n;
        Object next;
        try {
            if (b) {
                n = k.a.c();
            } else {
                c2 = SequencesKt__SequencesKt.c(defpackage.a.b());
                n = SequencesKt___SequencesKt.n(c2);
            }
            Iterator<T> it = n.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            if (mainDispatcherFactory == null) {
                return u.b(null, null, 3, null);
            }
            return u.d(mainDispatcherFactory, n);
        } catch (Throwable th) {
            return u.b(th, null, 2, null);
        }
    }
}
