package us.pinguo.edit2020.viewmodel.module;

import android.graphics.PointF;
import kotlin.jvm.b.s;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBodyShapeModule.kt */
/* loaded from: classes4.dex */
public final class EditBodyShapeModule$initFunctions$1 extends Lambda implements s<PointF, PointF, Float, Boolean, Float, u> {
    final /* synthetic */ EditBodyShapeModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBodyShapeModule$initFunctions$1(EditBodyShapeModule editBodyShapeModule) {
        super(5);
        this.this$0 = editBodyShapeModule;
    }

    @Override // kotlin.jvm.b.s
    public /* bridge */ /* synthetic */ u invoke(PointF pointF, PointF pointF2, Float f2, Boolean bool, Float f3) {
        invoke(pointF, pointF2, f2.floatValue(), bool.booleanValue(), f3);
        return u.a;
    }

    public final void invoke(PointF pointF, PointF pointF2, float f2, boolean z, Float f3) {
        float floatValue;
        if (pointF == null || pointF2 == null) {
            return;
        }
        if (f3 == null) {
            floatValue = this.this$0.i();
        } else {
            floatValue = f3.floatValue();
        }
        UnityEditCaller.ManualDeformation.forwardTransformContiguous(pointF, pointF2, floatValue, f2 * 1.75f, z);
    }
}
