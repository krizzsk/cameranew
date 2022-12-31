package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.MaterialInstallManager", f = "MaterialInstallManager.kt", i = {}, l = {107}, m = "parseConfigJson", n = {}, s = {})
/* loaded from: classes6.dex */
public final class MaterialInstallManager$parseConfigJson$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MaterialInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialInstallManager$parseConfigJson$1(MaterialInstallManager materialInstallManager, Continuation<? super MaterialInstallManager$parseConfigJson$1> continuation) {
        super(continuation);
        this.this$0 = materialInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        d2 = this.this$0.d(null, this);
        return d2;
    }
}
