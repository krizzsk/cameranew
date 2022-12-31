package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
/* renamed from: com.facebook.ads.redexgen.X.2t  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05412t extends C0745Ba implements Comparable<C05412t> {
    public long A00;

    public C05412t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(@NonNull C05412t c05412t) {
        if (A04() != c05412t.A04()) {
            return A04() ? 1 : -1;
        }
        long j2 = ((WZ) this).A00 - ((WZ) c05412t).A00;
        if (j2 == 0) {
            j2 = this.A00 - c05412t.A00;
            if (j2 == 0) {
                return 0;
            }
        }
        return j2 > 0 ? 1 : -1;
    }
}
