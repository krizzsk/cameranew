package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Qb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1112Qb {
    public static boolean A00(View view) {
        return view.getBackground() == null || (Build.VERSION.SDK_INT >= 19 && view.getBackground().getAlpha() <= 0);
    }
}
