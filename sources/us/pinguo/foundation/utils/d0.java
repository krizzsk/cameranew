package us.pinguo.foundation.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* compiled from: ScreenAdaptationUtil.kt */
/* loaded from: classes4.dex */
public final class d0 {
    public static final void a(Context context) {
        kotlin.jvm.internal.s.h(context, "<this>");
        int i2 = (context.getResources().getDisplayMetrics().widthPixels * 160) / BaseBlurEffect.ROTATION_360;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.densityDpi = i2;
        float f2 = i2 / 160.0f;
        displayMetrics2.density = f2;
        displayMetrics2.scaledDensity = (displayMetrics.scaledDensity * f2) / displayMetrics.density;
        DisplayMetrics displayMetrics3 = context.getApplicationContext().getResources().getDisplayMetrics();
        displayMetrics3.densityDpi = i2;
        displayMetrics3.density = f2;
        displayMetrics3.scaledDensity = (f2 * displayMetrics.scaledDensity) / displayMetrics.density;
    }

    public static final void b(Context context) {
        kotlin.jvm.internal.s.h(context, "<this>");
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
        displayMetrics2.densityDpi = displayMetrics.densityDpi;
        displayMetrics2.density = displayMetrics.density;
        displayMetrics2.scaledDensity = displayMetrics.scaledDensity;
        DisplayMetrics displayMetrics3 = context.getApplicationContext().getResources().getDisplayMetrics();
        displayMetrics3.densityDpi = displayMetrics.densityDpi;
        displayMetrics3.density = displayMetrics.density;
        displayMetrics3.scaledDensity = displayMetrics.scaledDensity;
    }
}
