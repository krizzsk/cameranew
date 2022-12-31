package us.pinguo.common.filter.view;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterPanelView.kt */
@DebugMetadata(c = "us.pinguo.common.filter.view.FilterPanelView", f = "FilterPanelView.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {86, 87, 93}, m = "isTemplateFilterAdjust", n = {"itemId", "isTemplateFilterAdjust", "itemId", "isTemplateFilterAdjust", "filterPackagePath", "itemId", "isTemplateFilterAdjust", "filterPackagePath"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes4.dex */
public final class FilterPanelView$isTemplateFilterAdjust$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$isTemplateFilterAdjust$1(FilterPanelView filterPanelView, Continuation<? super FilterPanelView$isTemplateFilterAdjust$1> continuation) {
        super(continuation);
        this.this$0 = filterPanelView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object z;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        z = this.this$0.z(null, this);
        return z;
    }
}
