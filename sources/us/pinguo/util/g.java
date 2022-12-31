package us.pinguo.util;

import android.content.Context;
/* compiled from: DimensionUtils.kt */
/* loaded from: classes6.dex */
public final class g {
    public static final int a(Context context, float f2) {
        kotlin.jvm.internal.s.h(context, "context");
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    public static final float b(Context context, float f2) {
        kotlin.jvm.internal.s.h(context, "context");
        return (context.getResources().getDisplayMetrics().density * f2) + 0.5f;
    }

    public static final float c(Context context, float f2) {
        kotlin.jvm.internal.s.h(context, "context");
        return (f2 / context.getResources().getDisplayMetrics().density) + 0.5f;
    }
}
