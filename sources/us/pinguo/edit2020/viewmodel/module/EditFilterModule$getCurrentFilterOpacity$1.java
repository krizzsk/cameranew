package us.pinguo.edit2020.viewmodel.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFilterModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditFilterModule", f = "EditFilterModule.kt", i = {0}, l = {79}, m = "getCurrentFilterOpacity", n = {"baseFilter"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class EditFilterModule$getCurrentFilterOpacity$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditFilterModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFilterModule$getCurrentFilterOpacity$1(EditFilterModule editFilterModule, Continuation<? super EditFilterModule$getCurrentFilterOpacity$1> continuation) {
        super(continuation);
        this.this$0 = editFilterModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r(this);
    }
}
