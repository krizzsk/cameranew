package us.pinguo.edit2020.widget;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
/* compiled from: AreaProtectionBoldAdjustView.kt */
/* loaded from: classes4.dex */
final class AreaProtectionBoldAdjustView$mappingsForAreaProtection$3 extends Lambda implements l<Float, Float> {
    public static final AreaProtectionBoldAdjustView$mappingsForAreaProtection$3 INSTANCE = new AreaProtectionBoldAdjustView$mappingsForAreaProtection$3();

    AreaProtectionBoldAdjustView$mappingsForAreaProtection$3() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Float invoke(Float f2) {
        return invoke(f2.floatValue());
    }

    public final Float invoke(float f2) {
        return Float.valueOf((f2 * 0.00451f) + 0.1824f);
    }
}
