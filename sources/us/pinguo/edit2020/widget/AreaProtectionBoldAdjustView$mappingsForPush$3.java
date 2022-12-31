package us.pinguo.edit2020.widget;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
/* compiled from: AreaProtectionBoldAdjustView.kt */
/* loaded from: classes4.dex */
final class AreaProtectionBoldAdjustView$mappingsForPush$3 extends Lambda implements l<Float, Float> {
    public static final AreaProtectionBoldAdjustView$mappingsForPush$3 INSTANCE = new AreaProtectionBoldAdjustView$mappingsForPush$3();

    AreaProtectionBoldAdjustView$mappingsForPush$3() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Float invoke(Float f2) {
        return invoke(f2.floatValue());
    }

    public final Float invoke(float f2) {
        return Float.valueOf((f2 * 0.001925f) + 0.4701f);
    }
}
