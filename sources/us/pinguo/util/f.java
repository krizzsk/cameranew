package us.pinguo.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
/* compiled from: CloseUtils.kt */
/* loaded from: classes6.dex */
public final class f {
    public static final void a(Closeable... closeables) {
        List<Closeable> n;
        kotlin.jvm.internal.s.h(closeables, "closeables");
        n = kotlin.collections.n.n(closeables);
        for (Closeable closeable : n) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
