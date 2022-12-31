package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterRepository.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterRepository", f = "FilterRepository.kt", i = {0, 0, 1, 1}, l = {456, 457, 461}, m = "isSkyChangeAdjustVisible", n = {"this", "itemId", "itemId", "filterPackagePath"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class FilterRepository$isSkyChangeAdjustVisible$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterRepository$isSkyChangeAdjustVisible$1(FilterRepository filterRepository, Continuation<? super FilterRepository$isSkyChangeAdjustVisible$1> continuation) {
        super(continuation);
        this.this$0 = filterRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.H(null, null, this);
    }
}
