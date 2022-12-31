package us.pinguo.camera2020.fragment;

import android.view.View;
import kotlin.jvm.internal.Lambda;
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
final class ViewFinderFragment$onViewCreated$12 extends Lambda implements kotlin.jvm.b.l<View, kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onViewCreated$12(ViewFinderFragment viewFinderFragment) {
        super(1);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(View view) {
        invoke2(view);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        kotlin.jvm.internal.s.h(it, "it");
        if (us.pinguo.foundation.utils.j.a(1000L)) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.A();
        this.this$0.n3();
    }
}
