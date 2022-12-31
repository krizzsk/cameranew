package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
@RequiresApi(16)
/* renamed from: com.facebook.ads.redexgen.X.bu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1484bu extends C05262e {
    @Override // com.facebook.ads.redexgen.X.C05262e
    public final View.AccessibilityDelegate A00(final C05272f c05272f) {
        return new View.AccessibilityDelegate() { // from class: com.facebook.ads.redexgen.X.2c
            public static String[] A02 = {"5TXwkxGOky4JO26BdMoLZorZ75Qh7TJ1", "TGpCIVKfg9q9VkptB3w2PfFUtUXuMPxH", "XWnogg3sW", "LoblWG2nky8IldTW7marNA4rqywTihhk", "", "za5KD6H2U", "Ka0OyPk3mlOgfUpq6xId3QQILfS23GTN", "DN7QTk2L5QCC7wBdOwuQ1Nom6iZb"};

            @Override // android.view.View.AccessibilityDelegate
            public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c05272f.A05(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                C3S A01 = c05272f.A01(view);
                if (A01 != null) {
                    Object A022 = A01.A02();
                    String[] strArr = A02;
                    if (strArr[0].charAt(14) != strArr[6].charAt(14)) {
                        A02[1] = "uCvPJ7NUfrK1Xmg35VTgFJzpSrozRbu2";
                        return (AccessibilityNodeProvider) A022;
                    }
                    throw new RuntimeException();
                }
                return null;
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
            public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                return c05272f.A09(view, i2, bundle);
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

    @Override // com.facebook.ads.redexgen.X.C05262e
    public final C3S A01(View.AccessibilityDelegate accessibilityDelegate, View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new C3S(accessibilityNodeProvider);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.C05262e
    public final boolean A02(View.AccessibilityDelegate accessibilityDelegate, View view, int i2, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i2, bundle);
    }
}
