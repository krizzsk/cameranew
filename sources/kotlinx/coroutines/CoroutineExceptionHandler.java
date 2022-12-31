package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final a a0 = a.a;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* loaded from: classes3.dex */
    public static final class a implements CoroutineContext.Key<CoroutineExceptionHandler> {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
