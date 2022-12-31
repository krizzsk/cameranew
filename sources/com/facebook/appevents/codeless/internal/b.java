package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
/* compiled from: SensitiveUserDataUtils.java */
/* loaded from: classes.dex */
public class b {
    private static boolean a(TextView textView) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            String replaceAll = d.k(textView).replaceAll("\\s", "");
            int length = replaceAll.length();
            if (length >= 12 && length <= 19) {
                int i2 = 0;
                boolean z = false;
                for (int i3 = length - 1; i3 >= 0; i3--) {
                    char charAt = replaceAll.charAt(i3);
                    if (charAt >= '0' && charAt <= '9') {
                        int i4 = charAt - '0';
                        if (z && (i4 = i4 * 2) > 9) {
                            i4 = (i4 % 10) + 1;
                        }
                        i2 += i4;
                        z = !z;
                    }
                    return false;
                }
                return i2 % 10 == 0;
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    private static boolean b(TextView textView) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            if (textView.getInputType() == 32) {
                return true;
            }
            String k2 = d.k(textView);
            if (k2 != null && k2.length() != 0) {
                return Patterns.EMAIL_ADDRESS.matcher(k2).matches();
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    private static boolean c(TextView textView) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            if (textView.getInputType() == 128) {
                return true;
            }
            return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    private static boolean d(TextView textView) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            return textView.getInputType() == 96;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    private static boolean e(TextView textView) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            return textView.getInputType() == 3;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    private static boolean f(TextView textView) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            return textView.getInputType() == 112;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    public static boolean g(View view) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (!c(textView) && !a(textView) && !d(textView) && !f(textView) && !e(textView)) {
                    if (!b(textView)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }
}
