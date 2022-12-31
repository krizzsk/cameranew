package kotlinx.coroutines.sync;

import com.tencent.tauth.AuthActivity;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
@DebugMetadata(c = "kotlinx.coroutines.sync.SemaphoreKt", f = "Semaphore.kt", i = {0, 0}, l = {85}, m = "withPermit", n = {"$this$withPermit", AuthActivity.ACTION_KEY}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
public final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.i(null, null, this);
    }
}
