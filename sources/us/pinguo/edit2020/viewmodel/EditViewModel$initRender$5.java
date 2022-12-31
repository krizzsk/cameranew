package us.pinguo.edit2020.viewmodel;

import android.graphics.PointF;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditViewModel.kt */
/* loaded from: classes4.dex */
public final class EditViewModel$initRender$5 extends Lambda implements r<PointF, Float, PointF, Integer, u> {
    final /* synthetic */ EditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditViewModel$initRender$5(EditViewModel editViewModel) {
        super(4);
        this.this$0 = editViewModel;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ u invoke(PointF pointF, Float f2, PointF pointF2, Integer num) {
        invoke(pointF, f2.floatValue(), pointF2, num.intValue());
        return u.a;
    }

    public final void invoke(PointF normalizedFocusPoint, float f2, PointF normalizedOffset, int i2) {
        s.h(normalizedFocusPoint, "normalizedFocusPoint");
        s.h(normalizedOffset, "normalizedOffset");
        this.this$0.c(normalizedFocusPoint, f2, normalizedOffset, i2);
    }
}
