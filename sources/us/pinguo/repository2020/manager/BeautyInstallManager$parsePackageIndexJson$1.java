package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyInstallManager", f = "BeautyInstallManager.kt", i = {0}, l = {134, 135}, m = "parsePackageIndexJson", n = {"indexFileDir"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class BeautyInstallManager$parsePackageIndexJson$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BeautyInstallManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyInstallManager$parsePackageIndexJson$1(BeautyInstallManager beautyInstallManager, Continuation<? super BeautyInstallManager$parsePackageIndexJson$1> continuation) {
        super(continuation);
        this.this$0 = beautyInstallManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
