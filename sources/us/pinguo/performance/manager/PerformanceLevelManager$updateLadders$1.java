package us.pinguo.performance.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PerformanceLevelManager.kt */
@DebugMetadata(c = "us.pinguo.performance.manager.PerformanceLevelManager", f = "PerformanceLevelManager.kt", i = {0, 0, 0, 1}, l = {82, 83}, m = "updateLadders", n = {"this", "laddersJson", "file", "this"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* loaded from: classes5.dex */
public final class PerformanceLevelManager$updateLadders$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PerformanceLevelManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerformanceLevelManager$updateLadders$1(PerformanceLevelManager performanceLevelManager, Continuation<? super PerformanceLevelManager$updateLadders$1> continuation) {
        super(continuation);
        this.this$0 = performanceLevelManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(null, this);
    }
}
