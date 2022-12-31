package us.pinguo.common;

import android.animation.TimeInterpolator;
/* compiled from: DecelerateAccelerateInterpolator.kt */
/* loaded from: classes4.dex */
public final class c implements TimeInterpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float f3 = (f2 * 2.0f) - 1.0f;
        return ((f3 * f3 * f3) + 1.0f) * 0.5f;
    }
}
