package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
/* compiled from: ResourceHelp.java */
/* loaded from: classes.dex */
public final class t {
    private static String a;
    private static Resources b;

    private static String a(Context context) {
        if (a == null) {
            a = context.getPackageName();
        }
        return a;
    }

    public static int b(Context context, String str) {
        return a(context, str, TypedValues.Custom.S_STRING);
    }

    public static Drawable c(Context context, String str) {
        return context.getResources().getDrawable(d(context, str));
    }

    public static int d(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int e(Context context, String str) {
        return a(context, str, TapjoyAuctionFlags.AUCTION_ID);
    }

    public static int f(Context context, String str) {
        return a(context, str, "layout");
    }

    public static int g(Context context, String str) {
        return a(context, str, TJAdUnitConstants.String.STYLE);
    }

    public static int h(Context context, String str) {
        return a(context, str, "dimen");
    }

    public static int i(Context context, String str) {
        return context.getResources().getColor(j(context, str));
    }

    public static int j(Context context, String str) {
        return a(context, str, TypedValues.Custom.S_COLOR);
    }

    public static int k(Context context, String str) {
        return a(context, str, TypedValues.Custom.S_INT);
    }

    public static int l(Context context, String str) {
        return context.getResources().getInteger(k(context, str));
    }

    private static int a(Context context, String str, String str2) {
        if (b == null) {
            b = context.getResources();
        }
        return b.getIdentifier(str, str2, a(context));
    }

    public static String a(Context context, String str) {
        return context.getResources().getString(b(context, str));
    }
}
