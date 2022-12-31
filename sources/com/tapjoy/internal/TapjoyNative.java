package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;
@ft
/* loaded from: classes3.dex */
public class TapjoyNative {
    @ft
    public static Object createPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        return gc.a().a(context, str, tJPlacementListener);
    }

    @ft
    public static Object getPrivacyPolicy() {
        return gc.a().b();
    }
}
