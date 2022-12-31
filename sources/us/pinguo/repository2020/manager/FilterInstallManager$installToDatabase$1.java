package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterInstallManager", f = "FilterInstallManager.kt", i = {0, 0, 0, 1, 1}, l = {120, 150}, m = "installToDatabase", n = {"this", "filterDetail", "listener", "this", "listener"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class FilterInstallManager$installToDatabase$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInstallManager$installToDatabase$1(FilterInstallManager filterInstallManager, Continuation<? super FilterInstallManager$installToDatabase$1> continuation) {
        super(continuation);
        this.this$0 = filterInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object r;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        r = this.this$0.r(null, null, this);
        return r;
    }
}
