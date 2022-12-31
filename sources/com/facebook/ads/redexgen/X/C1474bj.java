package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.bj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1474bj implements C3X {
    public final /* synthetic */ C0832Ew A00;
    public final /* synthetic */ C3S A01;

    public C1474bj(C0832Ew c0832Ew, C3S c3s) {
        this.A00 = c0832Ew;
        this.A01 = c3s;
    }

    @Override // com.facebook.ads.redexgen.X.C3X
    public final Object A4B(int i2) {
        C3Q A00 = this.A01.A00(i2);
        if (A00 == null) {
            return null;
        }
        return A00.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.C3X
    public final List<Object> A5L(String str, int i2) {
        List<C3Q> A03 = this.A01.A03(str, i2);
        if (A03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = A03.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(A03.get(i3).A0M());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.X.C3X
    public final Object A5M(int i2) {
        C3Q A01 = this.A01.A01(i2);
        if (A01 == null) {
            return null;
        }
        return A01.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.C3X
    public final boolean ACr(int i2, int i3, Bundle bundle) {
        return this.A01.A04(i2, i3, bundle);
    }
}
