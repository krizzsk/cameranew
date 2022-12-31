package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
/* renamed from: com.facebook.ads.redexgen.X.3K  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3K {
    public static final C3J A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A00 = new C0835Ez();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A00 = new C1477bm();
        } else {
            A00 = new C3J();
        }
    }

    public static int A00(AccessibilityEvent accessibilityEvent) {
        return A00.A00(accessibilityEvent);
    }

    public static void A01(AccessibilityEvent accessibilityEvent, int i2) {
        A00.A01(accessibilityEvent, i2);
    }
}
