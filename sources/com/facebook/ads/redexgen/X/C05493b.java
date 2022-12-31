package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.widget.EdgeEffect;
/* renamed from: com.facebook.ads.redexgen.X.3b  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05493b {
    public static final C05483a A00;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            A00 = new C1472bh();
        } else {
            A00 = new C05483a();
        }
    }

    public static void A00(EdgeEffect edgeEffect, float f2, float f3) {
        A00.A00(edgeEffect, f2, f3);
    }
}
