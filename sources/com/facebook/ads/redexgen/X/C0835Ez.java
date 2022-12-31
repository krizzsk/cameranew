package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RequiresApi;
@RequiresApi(19)
/* renamed from: com.facebook.ads.redexgen.X.Ez  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0835Ez extends C1477bm {
    @Override // com.facebook.ads.redexgen.X.C3J
    public final int A00(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    @Override // com.facebook.ads.redexgen.X.C3J
    public final void A01(AccessibilityEvent accessibilityEvent, int i2) {
        accessibilityEvent.setContentChangeTypes(i2);
    }
}
