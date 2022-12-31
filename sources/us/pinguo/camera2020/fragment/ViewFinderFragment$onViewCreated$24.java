package us.pinguo.camera2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.common.filter.controller.FilterController;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$24 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$24(ViewFinderFragment viewFinderFragment) {
        super(0);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FilterController filterController = this.this$0.u;
        if (filterController == null) {
            return;
        }
        FilterController.p0(filterController, false, 1, null);
    }
}
