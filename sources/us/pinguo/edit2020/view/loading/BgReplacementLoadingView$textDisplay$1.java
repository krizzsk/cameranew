package us.pinguo.edit2020.view.loading;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BgReplacementLoadingView.kt */
@DebugMetadata(c = "us.pinguo.edit2020.view.loading.BgReplacementLoadingView", f = "BgReplacementLoadingView.kt", i = {0}, l = {136, 137}, m = "textDisplay", n = {"this"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class BgReplacementLoadingView$textDisplay$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BgReplacementLoadingView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoadingView$textDisplay$1(BgReplacementLoadingView bgReplacementLoadingView, Continuation<? super BgReplacementLoadingView$textDisplay$1> continuation) {
        super(continuation);
        this.this$0 = bgReplacementLoadingView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object v;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        v = this.this$0.v(this);
        return v;
    }
}
