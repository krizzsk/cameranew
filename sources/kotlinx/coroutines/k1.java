package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class k1 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
