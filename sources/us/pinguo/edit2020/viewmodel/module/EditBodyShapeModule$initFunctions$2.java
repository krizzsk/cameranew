package us.pinguo.edit2020.viewmodel.module;

import android.graphics.PointF;
import kotlin.jvm.b.s;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditBodyShapeModule.kt */
/* loaded from: classes4.dex */
final class EditBodyShapeModule$initFunctions$2 extends Lambda implements s<PointF, PointF, Float, Boolean, Float, u> {
    public static final EditBodyShapeModule$initFunctions$2 INSTANCE = new EditBodyShapeModule$initFunctions$2();

    EditBodyShapeModule$initFunctions$2() {
        super(5);
    }

    @Override // kotlin.jvm.b.s
    public /* bridge */ /* synthetic */ u invoke(PointF pointF, PointF pointF2, Float f2, Boolean bool, Float f3) {
        invoke(pointF, pointF2, f2.floatValue(), bool.booleanValue(), f3);
        return u.a;
    }

    public final void invoke(PointF pointF, PointF pointF2, float f2, boolean z, Float f3) {
        if (pointF != null) {
            UnityEditCaller.ManualDeformation.scaleTransform(pointF, f3 == null ? 6.0f : f3.floatValue(), f2, false, z);
        }
    }
}
