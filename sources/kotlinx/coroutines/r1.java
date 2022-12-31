package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
/* compiled from: Interruptible.kt */
/* loaded from: classes3.dex */
public final class r1 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T b(CoroutineContext coroutineContext, kotlin.jvm.b.a<? extends T> aVar) {
        try {
            w2 w2Var = new w2(y1.i(coroutineContext));
            w2Var.d();
            T invoke = aVar.invoke();
            w2Var.a();
            return invoke;
        } catch (InterruptedException e2) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
        }
    }
}
