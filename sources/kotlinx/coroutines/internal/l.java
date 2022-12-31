package kotlinx.coroutines.internal;

import kotlin.Result;
/* compiled from: FastServiceLoader.kt */
/* loaded from: classes3.dex */
public final class l {
    private static final boolean a;

    static {
        Object m41constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(kotlin.j.a(th));
        }
        a = Result.m48isSuccessimpl(m41constructorimpl);
    }

    public static final boolean a() {
        return a;
    }
}
