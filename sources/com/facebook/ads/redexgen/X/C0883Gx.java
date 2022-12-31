package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
/* renamed from: com.facebook.ads.redexgen.X.Gx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0883Gx implements Comparable<C0883Gx> {
    public final int A00;
    public final C0879Gt A01;

    public C0883Gx(int i2, C0879Gt c0879Gt) {
        this.A00 = i2;
        this.A01 = c0879Gt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(@NonNull C0883Gx c0883Gx) {
        return this.A00 - c0883Gx.A00;
    }
}
