package us.pinguo.edit2020.controller;

import kotlin.jvm.internal.Lambda;
import us.pinguo.u3dengine.edit.BasicBrushMode;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
public final class BackgroundBlurController$initBackgroundBlurAdjustView$2 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.c0, kotlin.u> {
    final /* synthetic */ BackgroundBlurController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundBlurController$initBackgroundBlurAdjustView$2(BackgroundBlurController backgroundBlurController) {
        super(2);
        this.this$0 = backgroundBlurController;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.c0 c0Var) {
        invoke(num.intValue(), c0Var);
        return kotlin.u.a;
    }

    public final void invoke(int i2, us.pinguo.edit2020.bean.c0 function) {
        kotlin.jvm.internal.s.h(function, "function");
        if (i2 == 0) {
            this.this$0.c.e0();
        } else if (i2 == 1) {
            this.this$0.W0(BasicBrushMode.Erasing, function);
        } else if (i2 == 2) {
            this.this$0.W0(BasicBrushMode.Brush, function);
        } else if (i2 != 3) {
        } else {
            this.this$0.c.Y();
        }
    }
}
