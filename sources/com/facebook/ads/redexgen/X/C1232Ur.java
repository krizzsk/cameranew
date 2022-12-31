package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Ur  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1232Ur implements GL {
    public final C0868Gi A00;
    public final Map<String, C0874Go> A01;
    public final Map<String, C0869Gj> A02;
    public final long[] A03;

    public C1232Ur(C0868Gi c0868Gi, Map<String, C0874Go> map, Map<String, C0869Gj> map2) {
        Map<String, C0874Go> emptyMap;
        this.A00 = c0868Gi;
        this.A02 = map2;
        if (map != null) {
            emptyMap = Collections.unmodifiableMap(map);
        } else {
            emptyMap = Collections.emptyMap();
        }
        this.A01 = emptyMap;
        this.A03 = c0868Gi.A0F();
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final List<GK> A67(long j2) {
        return this.A00.A0D(j2, this.A01, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final long A6X(int i2) {
        return this.A03[i2];
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6Y() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6v(long j2) {
        int A0A = C0923Il.A0A(this.A03, j2, false, false);
        if (A0A < this.A03.length) {
            return A0A;
        }
        return -1;
    }
}
