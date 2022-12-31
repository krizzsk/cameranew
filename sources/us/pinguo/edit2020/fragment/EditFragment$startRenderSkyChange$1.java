package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment", f = "EditFragment.kt", i = {0, 0, 0, 0}, l = {594}, m = "startRenderSkyChange", n = {"this", "entry", "pkgId", "itemId"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes4.dex */
public final class EditFragment$startRenderSkyChange$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$startRenderSkyChange$1(EditFragment editFragment, Continuation<? super EditFragment$startRenderSkyChange$1> continuation) {
        super(continuation);
        this.this$0 = editFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object M2;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        M2 = this.this$0.M2(null, this);
        return M2;
    }
}
