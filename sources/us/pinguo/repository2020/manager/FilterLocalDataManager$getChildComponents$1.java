package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterLocalDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterLocalDataManager", f = "FilterLocalDataManager.kt", i = {}, l = {255}, m = "getChildComponents", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilterLocalDataManager$getChildComponents$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterLocalDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterLocalDataManager$getChildComponents$1(FilterLocalDataManager filterLocalDataManager, Continuation<? super FilterLocalDataManager$getChildComponents$1> continuation) {
        super(continuation);
        this.this$0 = filterLocalDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
