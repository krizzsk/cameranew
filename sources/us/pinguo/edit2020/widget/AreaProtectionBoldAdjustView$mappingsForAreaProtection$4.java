package us.pinguo.edit2020.widget;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
/* compiled from: AreaProtectionBoldAdjustView.kt */
/* loaded from: classes4.dex */
final class AreaProtectionBoldAdjustView$mappingsForAreaProtection$4 extends Lambda implements l<Float, Float> {
    public static final AreaProtectionBoldAdjustView$mappingsForAreaProtection$4 INSTANCE = new AreaProtectionBoldAdjustView$mappingsForAreaProtection$4();

    AreaProtectionBoldAdjustView$mappingsForAreaProtection$4() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Float invoke(Float f2) {
        return invoke(f2.floatValue());
    }

    public final Float invoke(float f2) {
        return Float.valueOf((f2 * 0.003779f) + 0.2858f);
    }
}
