package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterLocalDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterLocalDataManager", f = "FilterLocalDataManager.kt", i = {0, 0, 0}, l = {235}, m = "getDefaultAdjustValue", n = {"this", "filterId", "cachedValue"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class FilterLocalDataManager$getDefaultAdjustValue$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterLocalDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterLocalDataManager$getDefaultAdjustValue$1(FilterLocalDataManager filterLocalDataManager, Continuation<? super FilterLocalDataManager$getDefaultAdjustValue$1> continuation) {
        super(continuation);
        this.this$0 = filterLocalDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, this);
    }
}
