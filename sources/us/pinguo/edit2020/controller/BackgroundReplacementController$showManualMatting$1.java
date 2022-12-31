package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.ShapeDirectionView;
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
final class BackgroundReplacementController$showManualMatting$1 extends Lambda implements kotlin.jvm.b.l<ShapeDirectionView, kotlin.u> {
    final /* synthetic */ float $indicatorSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$showManualMatting$1(float f2) {
        super(1);
        this.$indicatorSize = f2;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(ShapeDirectionView shapeDirectionView) {
        invoke2(shapeDirectionView);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ShapeDirectionView it) {
        kotlin.jvm.internal.s.h(it, "it");
        it.setSinglePointMode(true);
        it.setIndicatorSize(this.$indicatorSize);
    }
}
