package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Dh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0793Dh {
    public final int A00;
    public final String A01;
    public final List<C0792Dg> A02;
    public final byte[] A03;

    public C0793Dh(int i2, String str, List<C0792Dg> list, byte[] bArr) {
        List<C0792Dg> unmodifiableList;
        this.A00 = i2;
        this.A01 = str;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.A02 = unmodifiableList;
        this.A03 = bArr;
    }
}
