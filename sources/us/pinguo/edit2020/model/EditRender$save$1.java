package us.pinguo.edit2020.model;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditRender.kt */
@DebugMetadata(c = "us.pinguo.edit2020.model.EditRender", f = "EditRender.kt", i = {0, 0}, l = {515}, m = "save", n = {"this", "cachePath"}, s = {"L$0", "L$1"})
/* loaded from: classes4.dex */
public final class EditRender$save$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditRender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditRender$save$1(EditRender editRender, Continuation<? super EditRender$save$1> continuation) {
        super(continuation);
        this.this$0 = editRender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b0(this);
    }
}
