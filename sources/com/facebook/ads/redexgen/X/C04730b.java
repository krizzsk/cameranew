package com.facebook.ads.redexgen.X;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* renamed from: com.facebook.ads.redexgen.X.0b  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C04730b extends C05001d {
    @Override // com.facebook.ads.redexgen.X.C05001d, com.facebook.ads.redexgen.X.C3M
    public final Object A00(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2);
    }

    @Override // com.facebook.ads.redexgen.X.C05001d, com.facebook.ads.redexgen.X.C3M
    public final Object A01(int i2, int i3, boolean z, int i4) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4);
    }
}
