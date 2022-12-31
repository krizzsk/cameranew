package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment", f = "EditFragment.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {641, 643, 648, 650, 656}, m = "renderFilter", n = {"this", "entry", "controller", "isOnlineFilter", "this", "entry", "controller", "isOnlineFilter", "currentOpacity", "this", "controller", "currentOpacity", "defaultOpacity", "this", "controller", "currentOpacity", "defaultOpacity", "isTemplateFilterAdjust"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "Z$0"})
/* loaded from: classes4.dex */
public final class EditFragment$renderFilter$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$renderFilter$1(EditFragment editFragment, Continuation<? super EditFragment$renderFilter$1> continuation) {
        super(continuation);
        this.this$0 = editFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object v2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        v2 = this.this$0.v2(null, this);
        return v2;
    }
}
