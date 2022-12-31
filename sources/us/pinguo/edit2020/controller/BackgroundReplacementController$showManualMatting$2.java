package us.pinguo.edit2020.controller;

import android.content.Context;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
final class BackgroundReplacementController$showManualMatting$2 extends Lambda implements kotlin.jvm.b.l<MagnifierLayout, kotlin.u> {
    final /* synthetic */ float $indicatorSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$showManualMatting$2(float f2) {
        super(1);
        this.$indicatorSize = f2;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(MagnifierLayout magnifierLayout) {
        invoke2(magnifierLayout);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MagnifierLayout it) {
        kotlin.jvm.internal.s.h(it, "it");
        int i2 = R.id.magnifierView;
        Context context = it.getContext();
        kotlin.jvm.internal.s.g(context, "it.context");
        ((MagnifierView) it.a(i2)).setStrokeWidth(us.pinguo.util.g.b(context, 1.0f));
        ((MagnifierView) it.a(i2)).setSize(this.$indicatorSize);
        MagnifierView magnifierView = (MagnifierView) it.a(i2);
        kotlin.jvm.internal.s.g(magnifierView, "it.magnifierView");
        magnifierView.setVisibility(0);
        VdsAgent.onSetViewVisibility(magnifierView, 0);
    }
}
