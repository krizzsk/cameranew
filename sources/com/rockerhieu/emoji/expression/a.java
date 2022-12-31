package com.rockerhieu.emoji.expression;

import android.content.Context;
/* compiled from: DisplayUtil.java */
/* loaded from: classes9.dex */
class a {
    public static int a(Context context, float f2) {
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
