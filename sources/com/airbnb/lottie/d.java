package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
/* compiled from: L.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class d {
    public static boolean a = false;
    private static boolean b = false;
    private static String[] c;

    /* renamed from: d  reason: collision with root package name */
    private static long[] f338d;

    /* renamed from: e  reason: collision with root package name */
    private static int f339e;

    /* renamed from: f  reason: collision with root package name */
    private static int f340f;

    public static void a(String str) {
        if (b) {
            int i2 = f339e;
            if (i2 == 20) {
                f340f++;
                return;
            }
            c[i2] = str;
            f338d[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            f339e++;
        }
    }

    public static float b(String str) {
        int i2 = f340f;
        if (i2 > 0) {
            f340f = i2 - 1;
            return 0.0f;
        } else if (b) {
            int i3 = f339e - 1;
            f339e = i3;
            if (i3 != -1) {
                if (str.equals(c[i3])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - f338d[f339e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[f339e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
