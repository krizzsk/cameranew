package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BackgroundBlurDataManager", f = "BackgroundBlurDataManager.kt", i = {}, l = {519}, m = "parseConfigJson", n = {}, s = {})
/* loaded from: classes6.dex */
public final class BackgroundBlurDataManager$parseConfigJson$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackgroundBlurDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurDataManager$parseConfigJson$1(BackgroundBlurDataManager backgroundBlurDataManager, Continuation<? super BackgroundBlurDataManager$parseConfigJson$1> continuation) {
        super(continuation);
        this.this$0 = backgroundBlurDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        q = this.this$0.q(null, this);
        return q;
    }
}
