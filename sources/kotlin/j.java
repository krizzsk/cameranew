package kotlin;

import kotlin.Result;
/* compiled from: Result.kt */
/* loaded from: classes3.dex */
public final class j {
    public static final Object a(Throwable exception) {
        kotlin.jvm.internal.s.h(exception, "exception");
        return new Result.Failure(exception);
    }

    public static final void b(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
