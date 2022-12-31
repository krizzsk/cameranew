package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;
import kotlin.Result;
import kotlin.j;
/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public final class b {
    private static volatile Choreographer choreographer;

    static {
        Object m41constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(new HandlerContext(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m41constructorimpl = Result.m41constructorimpl(j.a(th));
        }
        a aVar3 = Result.m47isFailureimpl(m41constructorimpl) ? null : m41constructorimpl;
    }

    @VisibleForTesting
    public static final Handler a(Looper looper, boolean z) {
        int i2;
        if (!z || (i2 = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i2 >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
