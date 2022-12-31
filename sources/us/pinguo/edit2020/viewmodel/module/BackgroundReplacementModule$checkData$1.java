package us.pinguo.edit2020.viewmodel.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule", f = "BackgroundReplacementModule.kt", i = {0}, l = {162}, m = "checkData", n = {"this"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class BackgroundReplacementModule$checkData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackgroundReplacementModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementModule$checkData$1(BackgroundReplacementModule backgroundReplacementModule, Continuation<? super BackgroundReplacementModule$checkData$1> continuation) {
        super(continuation);
        this.this$0 = backgroundReplacementModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.s(this);
    }
}
