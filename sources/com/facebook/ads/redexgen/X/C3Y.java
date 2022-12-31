package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import java.util.List;
@RequiresApi(19)
/* renamed from: com.facebook.ads.redexgen.X.3Y  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3Y {
    public static Object A00(final C3X c3x) {
        return new AccessibilityNodeProvider() { // from class: com.facebook.ads.redexgen.X.3W
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
                return (AccessibilityNodeInfo) C3X.this.A4B(i2);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
                return C3X.this.A5L(str, i2);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final AccessibilityNodeInfo findFocus(int i2) {
                return (AccessibilityNodeInfo) C3X.this.A5M(i2);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public final boolean performAction(int i2, int i3, Bundle bundle) {
                return C3X.this.ACr(i2, i3, bundle);
            }
        };
    }
}
