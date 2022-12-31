package kotlin.io;

import java.io.Closeable;
/* compiled from: Closeable.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                kotlin.b.a(th, th2);
            }
        }
    }
}
