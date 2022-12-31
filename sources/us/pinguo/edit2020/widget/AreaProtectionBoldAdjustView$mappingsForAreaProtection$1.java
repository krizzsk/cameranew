package us.pinguo.edit2020.widget;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
/* compiled from: AreaProtectionBoldAdjustView.kt */
/* loaded from: classes4.dex */
final class AreaProtectionBoldAdjustView$mappingsForAreaProtection$1 extends Lambda implements l<Float, Float> {
    public static final AreaProtectionBoldAdjustView$mappingsForAreaProtection$1 INSTANCE = new AreaProtectionBoldAdjustView$mappingsForAreaProtection$1();

    AreaProtectionBoldAdjustView$mappingsForAreaProtection$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Float invoke(Float f2) {
        return invoke(f2.floatValue());
    }

    public final Float invoke(float f2) {
        return Float.valueOf((f2 * 0.003708f) + 0.2156f);
    }
}
