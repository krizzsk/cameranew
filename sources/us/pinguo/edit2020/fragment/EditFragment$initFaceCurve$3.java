package us.pinguo.edit2020.fragment;

import android.graphics.PointF;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.viewmodel.EditViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$initFaceCurve$3 extends Lambda implements kotlin.jvm.b.r<PointF, Float, PointF, Integer, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$initFaceCurve$3(EditFragment editFragment) {
        super(4);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ kotlin.u invoke(PointF pointF, Float f2, PointF pointF2, Integer num) {
        invoke(pointF, f2.floatValue(), pointF2, num.intValue());
        return kotlin.u.a;
    }

    public final void invoke(PointF normalizedFocusPoint, float f2, PointF normalizedOffset, int i2) {
        EditViewModel j1;
        kotlin.jvm.internal.s.h(normalizedFocusPoint, "normalizedFocusPoint");
        kotlin.jvm.internal.s.h(normalizedOffset, "normalizedOffset");
        j1 = this.this$0.j1();
        j1.c(normalizedFocusPoint, f2, normalizedOffset, i2);
    }
}
