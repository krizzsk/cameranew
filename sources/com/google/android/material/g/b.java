package com.google.android.material.g;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
/* compiled from: RippleUtils.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b {
    public static final boolean a;
    private static final int[] b;
    private static final int[] c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f4308d;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f4309e;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f4310f;

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f4311g;

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f4312h;

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f4313i;

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f4314j;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f4315k;
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    static final String f4316l;

    static {
        a = Build.VERSION.SDK_INT >= 21;
        b = new int[]{16842919};
        c = new int[]{16843623, 16842908};
        f4308d = new int[]{16842908};
        f4309e = new int[]{16843623};
        f4310f = new int[]{16842913, 16842919};
        f4311g = new int[]{16842913, 16843623, 16842908};
        f4312h = new int[]{16842913, 16842908};
        f4313i = new int[]{16842913, 16843623};
        f4314j = new int[]{16842913};
        f4315k = new int[]{16842910, 16842919};
        f4316l = b.class.getSimpleName();
    }

    private b() {
    }

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList colorStateList) {
        if (a) {
            return new ColorStateList(new int[][]{f4314j, StateSet.NOTHING}, new int[]{c(colorStateList, f4310f), c(colorStateList, b)});
        }
        int[] iArr = f4310f;
        int[] iArr2 = f4311g;
        int[] iArr3 = f4312h;
        int[] iArr4 = f4313i;
        int[] iArr5 = b;
        int[] iArr6 = c;
        int[] iArr7 = f4308d;
        int[] iArr8 = f4309e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f4314j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @ColorInt
    @TargetApi(21)
    private static int b(@ColorInt int i2) {
        return ColorUtils.setAlphaComponent(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    @ColorInt
    private static int c(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a ? b(colorForState) : colorForState;
    }

    @NonNull
    public static ColorStateList d(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f4315k, 0)) != 0) {
                Log.w(f4316l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean e(@NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
