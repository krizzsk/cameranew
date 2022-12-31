package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyInstallManager", f = "BeautyInstallManager.kt", i = {}, l = {128}, m = "parseDisplayJson", n = {}, s = {})
/* loaded from: classes6.dex */
public final class BeautyInstallManager$parseDisplayJson$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BeautyInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyInstallManager$parseDisplayJson$1(BeautyInstallManager beautyInstallManager, Continuation<? super BeautyInstallManager$parseDisplayJson$1> continuation) {
        super(continuation);
        this.this$0 = beautyInstallManager;
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
