package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;
/* compiled from: AspectRatioMeasure.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: AspectRatioMeasure.java */
    /* renamed from: com.facebook.drawee.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0095a {
        public int a;
        public int b;
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == -2;
    }

    public static void b(C0095a c0095a, float f2, @Nullable ViewGroup.LayoutParams layoutParams, int i2, int i3) {
        if (f2 <= 0.0f || layoutParams == null) {
            return;
        }
        if (a(layoutParams.height)) {
            c0095a.b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0095a.a) - i2) / f2) + i3), c0095a.b), 1073741824);
        } else if (a(layoutParams.width)) {
            c0095a.a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(c0095a.b) - i3) * f2) + i2), c0095a.a), 1073741824);
        }
    }
}
