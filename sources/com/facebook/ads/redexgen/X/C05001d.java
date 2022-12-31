package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
@RequiresApi(19)
/* renamed from: com.facebook.ads.redexgen.X.1d  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C05001d extends C3L {
    @Override // com.facebook.ads.redexgen.X.C3M
    public Object A00(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z);
    }

    @Override // com.facebook.ads.redexgen.X.C3M
    public Object A01(int i2, int i3, boolean z, int i4) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z);
    }

    @Override // com.facebook.ads.redexgen.X.C3M
    public final void A03(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj);
    }

    @Override // com.facebook.ads.redexgen.X.C3M
    public final void A04(AccessibilityNodeInfo accessibilityNodeInfo, Object obj) {
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj);
    }
}
