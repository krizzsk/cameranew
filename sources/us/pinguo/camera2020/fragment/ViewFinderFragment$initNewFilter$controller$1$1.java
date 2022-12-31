package us.pinguo.camera2020.fragment;

import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$initNewFilter$controller$1$1 extends Lambda implements kotlin.jvm.b.l<us.pinguo.common.filter.guide.c, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$initNewFilter$controller$1$1(ViewFinderFragment viewFinderFragment) {
        super(1);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.common.filter.guide.c cVar) {
        invoke2(cVar);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(us.pinguo.common.filter.guide.c guideControl) {
        us.pinguo.common.f fVar;
        kotlin.jvm.internal.s.h(guideControl, "guideControl");
        fVar = this.this$0.H;
        fVar.c(guideControl, 0);
    }
}
