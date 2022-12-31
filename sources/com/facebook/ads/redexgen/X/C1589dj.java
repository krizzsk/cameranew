package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.dj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1589dj<ModelType, StateType> {
    public static byte[] A05;
    public static final C1589dj A06;
    public final C1589dj A00;
    public final ModelType A01;
    public final StateType A02;
    public final String A03;
    public final List<InterfaceC1592dm<ModelType, StateType>> A04;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 113);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{81, 89, 92, 96, 101};
    }

    static {
        A02();
        A06 = new C1589dj(null, null, A01(0, 5, 123), Collections.emptyList(), A06);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dj != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dk != com.instagram.common.viewpoint.core.ViewpointData$Builder<ModelType, StateType> */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1589dj(com.facebook.ads.redexgen.X.C1590dk<ModelType, StateType> r7) {
        /*
            r6 = this;
            java.lang.Object r1 = com.facebook.ads.redexgen.X.C1590dk.A01(r7)
            java.lang.Object r2 = com.facebook.ads.redexgen.X.C1590dk.A02(r7)
            java.lang.String r3 = com.facebook.ads.redexgen.X.C1590dk.A03(r7)
            java.util.List r0 = com.facebook.ads.redexgen.X.C1590dk.A04(r7)
            if (r0 != 0) goto L1f
            java.util.List r4 = java.util.Collections.emptyList()
        L16:
            com.facebook.ads.redexgen.X.dj r5 = com.facebook.ads.redexgen.X.C1590dk.A00(r7)
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return
        L1f:
            java.util.List r4 = com.facebook.ads.redexgen.X.C1590dk.A04(r7)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1589dj.<init>(com.facebook.ads.redexgen.X.dk):void");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dj != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    public C1589dj(ModelType model, StateType state, String str, List<InterfaceC1592dm<ModelType, StateType>> list, C1589dj c1589dj) {
        this.A01 = model;
        this.A02 = state;
        this.A03 = str;
        this.A00 = c1589dj;
        this.A04 = list;
    }

    public static <ModelType, StateType> C1590dk<ModelType, StateType> A00(ModelType modeltype, StateType statetype, String str) {
        return new C1590dk<>(modeltype, statetype, str);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dj != com.instagram.common.viewpoint.core.ViewpointData<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dm != com.instagram.common.viewpoint.core.ViewpointAction<ModelType, StateType> */
    public final void A03(InterfaceC1578dY interfaceC1578dY) {
        for (InterfaceC1592dm<ModelType, StateType> interfaceC1592dm : this.A04) {
            interfaceC1592dm.A5F(this, interfaceC1578dY);
        }
    }
}
