package us.pinguo.edit2020.controller;

import android.graphics.PointF;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.view.ManualMattingView;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController$initSelectRectView$2 extends Lambda implements kotlin.jvm.b.r<String, Float, PointF, PointF, kotlin.u> {
    final /* synthetic */ BackgroundReplacementController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundReplacementController$initSelectRectView$2(BackgroundReplacementController backgroundReplacementController) {
        super(4);
        this.this$0 = backgroundReplacementController;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, PointF pointF, PointF pointF2) {
        invoke2(str, f2, pointF, pointF2);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String key, Float f2, PointF pointF, PointF pointF2) {
        PointF pointF3;
        PointF pointF4;
        kotlin.jvm.internal.s.h(key, "key");
        ManualMattingView manualMattingView = this.this$0.s;
        boolean z = false;
        if (manualMattingView != null) {
            if (manualMattingView.getVisibility() == 0) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        pointF3 = this.this$0.H;
        pointF3.set(pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        this.this$0.f10291l = true;
        BackgroundReplacementModule backgroundReplacementModule = this.this$0.c;
        pointF4 = this.this$0.H;
        backgroundReplacementModule.P0(key, pointF4, pointF, f2 == null ? null : Integer.valueOf((int) f2.floatValue()));
    }
}
