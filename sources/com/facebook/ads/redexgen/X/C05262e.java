package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
/* renamed from: com.facebook.ads.redexgen.X.2e  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C05262e {
    public View.AccessibilityDelegate A00(final C05272f c05272f) {
        return new View.AccessibilityDelegate() { // from class: com.facebook.ads.redexgen.X.2d
            @Override // android.view.View.AccessibilityDelegate
            public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c05272f.A05(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c05272f.A07(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                c05272f.A08(view, C3Q.A01(accessibilityNodeInfo));
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c05272f.A03(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return c05272f.A06(viewGroup, view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void sendAccessibilityEvent(View view, int i2) {
                c05272f.A02(view, i2);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                c05272f.A04(view, accessibilityEvent);
            }
        };
    }

    public C3S A01(View.AccessibilityDelegate accessibilityDelegate, View view) {
        return null;
    }

    public boolean A02(View.AccessibilityDelegate accessibilityDelegate, View view, int i2, Bundle bundle) {
        return false;
    }
}
