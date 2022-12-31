package us.pinguo.camera2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$onViewCreated$11", f = "ViewFinderFragment.kt", i = {0}, l = {944}, m = "sendRecordClick", n = {"this"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$onViewCreated$11$sendRecordClick$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ViewFinderFragment$onViewCreated$11 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$11$sendRecordClick$1(ViewFinderFragment$onViewCreated$11 viewFinderFragment$onViewCreated$11, Continuation<? super ViewFinderFragment$onViewCreated$11$sendRecordClick$1> continuation) {
        super(continuation);
        this.this$0 = viewFinderFragment$onViewCreated$11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(this);
    }
}
