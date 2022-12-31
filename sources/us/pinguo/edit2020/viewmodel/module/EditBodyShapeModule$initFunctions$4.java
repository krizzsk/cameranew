package us.pinguo.edit2020.viewmodel.module;

import android.graphics.PointF;
import kotlin.jvm.b.s;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditBodyShapeModule.kt */
/* loaded from: classes4.dex */
final class EditBodyShapeModule$initFunctions$4 extends Lambda implements s<PointF, PointF, Float, Boolean, Float, u> {
    public static final EditBodyShapeModule$initFunctions$4 INSTANCE = new EditBodyShapeModule$initFunctions$4();

    EditBodyShapeModule$initFunctions$4() {
        super(5);
    }

    @Override // kotlin.jvm.b.s
    public /* bridge */ /* synthetic */ u invoke(PointF pointF, PointF pointF2, Float f2, Boolean bool, Float f3) {
        invoke(pointF, pointF2, f2.floatValue(), bool.booleanValue(), f3);
        return u.a;
    }

    public final void invoke(PointF pointF, PointF pointF2, float f2, boolean z, Float f3) {
        if (pointF2 == null) {
            UnityEditCaller.ManualDeformation.resetTransform(f3 == null ? 0.1f : f3.floatValue(), z);
            return;
        }
        if (pointF != null) {
            UnityEditCaller.ManualDeformation.restoreTransform(pointF2, f3 != null ? f3.floatValue() : 8.0f, 0.15f, z);
        } else {
            UnityEditCaller.ManualDeformation.restoreTransformNew(pointF2, f3 != null ? f3.floatValue() : 8.0f, 0.15f, z);
        }
    }
}
