package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterInstallManager", f = "FilterInstallManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2}, l = {233, 247, 249}, m = "writeItemAndEffectTable", n = {"this", "filterDetail", "packageItem", "file", "this", "filterDetail", "packageItem", "file", "unityEngineFilter", "this", "filterDetail", "packageItem"}, s = {"L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4", "Z$0", "L$0", "L$1", "L$2"})
/* loaded from: classes6.dex */
public final class FilterInstallManager$writeItemAndEffectTable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInstallManager$writeItemAndEffectTable$1(FilterInstallManager filterInstallManager, Continuation<? super FilterInstallManager$writeItemAndEffectTable$1> continuation) {
        super(continuation);
        this.this$0 = filterInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object z;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        z = this.this$0.z(null, null, this);
        return z;
    }
}
