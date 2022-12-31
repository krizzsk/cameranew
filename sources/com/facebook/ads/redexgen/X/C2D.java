package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.2D  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2D implements Serializable {
    public static final long serialVersionUID = -3209129042070173126L;
    public C2D A00;
    public final int A01;
    public final String A02;
    @Nullable
    public final String A03;
    public final List<C2D> A04;

    public C2D(int i2, @Nullable String str, String str2) {
        this.A04 = new ArrayList();
        this.A01 = i2;
        this.A03 = str;
        this.A02 = str2;
    }

    public C2D(String str) {
        this(0, null, str);
    }

    private void A00(C2D c2d) {
        this.A00 = c2d;
    }

    public final int A01() {
        return this.A01;
    }

    public final C2D A02() {
        return this.A00;
    }

    @Nullable
    public final String A03() {
        return this.A02;
    }

    public final String A04() {
        return this.A03;
    }

    public final List<C2D> A05() {
        return this.A04;
    }

    public final void A06(C2D c2d) {
        c2d.A00(this);
        this.A04.add(c2d);
    }
}
