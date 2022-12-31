package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterInstallManager", f = "FilterInstallManager.kt", i = {0, 0, 0}, l = {348}, m = "createEffectTable", n = {"this", "filterId", "effectTable"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class FilterInstallManager$createEffectTable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInstallManager$createEffectTable$1(FilterInstallManager filterInstallManager, Continuation<? super FilterInstallManager$createEffectTable$1> continuation) {
        super(continuation);
        this.this$0 = filterInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        l2 = this.this$0.l(0, null, null, null, null, this);
        return l2;
    }
}
