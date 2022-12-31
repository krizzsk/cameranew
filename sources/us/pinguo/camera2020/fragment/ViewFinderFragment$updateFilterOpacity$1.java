package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment", f = "ViewFinderFragment.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2056, 2058}, m = "updateFilterOpacity", n = {"this", "entry", "isNonePreviewFilter", "this", "entry", "isNonePreviewFilter", "currentOpacity"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0", "I$0"})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$updateFilterOpacity$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$updateFilterOpacity$1(ViewFinderFragment viewFinderFragment, Continuation<? super ViewFinderFragment$updateFilterOpacity$1> continuation) {
        super(continuation);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object y4;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        y4 = this.this$0.y4(null, false, this);
        return y4;
    }
}
