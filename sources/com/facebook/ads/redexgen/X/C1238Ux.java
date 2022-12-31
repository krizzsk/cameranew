package com.facebook.ads.redexgen.X;

import android.text.Layout;
import androidx.annotation.NonNull;
/* renamed from: com.facebook.ads.redexgen.X.Ux  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1238Ux extends GK implements Comparable<C1238Ux> {
    public final int A00;

    public C1238Ux(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5, int i6) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4, z, i5);
        this.A00 = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(@NonNull C1238Ux c1238Ux) {
        int i2 = c1238Ux.A00;
        int i3 = this.A00;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        return 0;
    }
}
