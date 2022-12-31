package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.ShapeDirectionView;
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
final class BackgroundBlurController$setPaintOrEraser$1 extends Lambda implements kotlin.jvm.b.l<ShapeDirectionView, kotlin.u> {
    public static final BackgroundBlurController$setPaintOrEraser$1 INSTANCE = new BackgroundBlurController$setPaintOrEraser$1();

    BackgroundBlurController$setPaintOrEraser$1() {
        super(1);
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
    }
}
