package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.bk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1475bk implements C3U {
    public final /* synthetic */ C0833Ex A00;
    public final /* synthetic */ C3S A01;

    public C1475bk(C0833Ex c0833Ex, C3S c3s) {
        this.A00 = c0833Ex;
        this.A01 = c3s;
    }

    @Override // com.facebook.ads.redexgen.X.C3U
    public final Object A4B(int i2) {
        C3Q A00 = this.A01.A00(i2);
        if (A00 == null) {
            return null;
        }
        return A00.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.C3U
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

    @Override // com.facebook.ads.redexgen.X.C3U
    public final boolean ACr(int i2, int i3, Bundle bundle) {
        return this.A01.A04(i2, i3, bundle);
    }
}
