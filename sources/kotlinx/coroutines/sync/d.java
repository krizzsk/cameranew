package kotlinx.coroutines.sync;

import kotlin.coroutines.Continuation;
import kotlin.u;
/* compiled from: Semaphore.kt */
/* loaded from: classes3.dex */
public interface d {
    Object a(Continuation<? super u> continuation);

    void release();
}
