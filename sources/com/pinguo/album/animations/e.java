package com.pinguo.album.animations;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
/* compiled from: CaptureAnim.java */
/* loaded from: classes3.dex */
public class e {
    private static Interpolator a = new DecelerateInterpolator();
    private static Interpolator b = new AccelerateInterpolator();
    private static Interpolator c = new AccelerateDecelerateInterpolator();

    public static float a(float f2) {
        if (f2 <= 0.5f) {
            return 1.0f - (a.getInterpolation(f2 * 2.0f) * 0.2f);
        }
        return (b.getInterpolation((f2 - 0.5f) * 2.0f) * 0.2f) + 0.8f;
    }

    public static float b(float f2) {
        return c.getInterpolation(f2);
    }
}
