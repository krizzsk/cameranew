package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterInstallManager", f = "FilterInstallManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {313, 322}, m = "writeEffectTable", n = {"this", "filterDetail", "file", "effectTables", "this", "filterDetail", "file", "effectTables"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes6.dex */
public final class FilterInstallManager$writeEffectTable$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInstallManager$writeEffectTable$1(FilterInstallManager filterInstallManager, Continuation<? super FilterInstallManager$writeEffectTable$1> continuation) {
        super(continuation);
        this.this$0 = filterInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object x;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        x = this.this$0.x(null, null, this);
        return x;
    }
}
