package us.pinguo.edit2020.controller;

import android.graphics.PointF;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.SelectRectAdjustView;
import us.pinguo.edit2020.view.SelectRectFunctionView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
/* loaded from: classes4.dex */
public final class StaticStickerController$initSelectRectView$3 extends Lambda implements kotlin.jvm.b.r<PointF, PointF, PointF, PointF, kotlin.u> {
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$initSelectRectView$3(StaticStickerController staticStickerController) {
        super(4);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ kotlin.u invoke(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        invoke2(pointF, pointF2, pointF3, pointF4);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PointF leftTop, PointF rightTop, PointF leftBottom, PointF rightBottom) {
        kotlin.jvm.internal.s.h(leftTop, "leftTop");
        kotlin.jvm.internal.s.h(rightTop, "rightTop");
        kotlin.jvm.internal.s.h(leftBottom, "leftBottom");
        kotlin.jvm.internal.s.h(rightBottom, "rightBottom");
        this.this$0.b.k0(((SelectRectAdjustView) this.this$0.f10427e.findViewById(R.id.selectRectAdjustView)).F());
        ((SelectRectFunctionView) this.this$0.f10427e.findViewById(R.id.selectRectFunctionView)).n(leftTop, rightTop, leftBottom, rightBottom);
    }
}
