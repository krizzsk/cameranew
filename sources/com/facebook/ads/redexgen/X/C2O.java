package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Trace;
/* renamed from: com.facebook.ads.redexgen.X.2O  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2O {
    public static void A00() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void A01(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
