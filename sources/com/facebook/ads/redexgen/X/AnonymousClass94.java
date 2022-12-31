package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.94  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass94 {
    public static byte[] A05;
    public AnonymousClass95 A01;
    @Nullable
    public String A02;
    @Nullable
    public String A03;
    public int A00 = 0;
    public List<AnonymousClass92> A04 = new ArrayList();

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 109);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{79, 88};
    }

    public AnonymousClass94(AnonymousClass95 anonymousClass95, @Nullable String str, @Nullable String str2) {
        this.A01 = anonymousClass95;
        this.A03 = str;
        this.A02 = str2;
    }

    public final int A02() {
        return this.A04.size();
    }

    public final long A03() {
        AnonymousClass95 anonymousClass95 = this.A01;
        if (anonymousClass95 != null) {
            return anonymousClass95.A0C() + this.A01.A03();
        }
        return -1L;
    }

    public final AnonymousClass92 A04() {
        if (this.A00 < this.A04.size()) {
            this.A00++;
            return this.A04.get(this.A00 - 1);
        }
        return null;
    }

    public final AnonymousClass95 A05() {
        return this.A01;
    }

    @Nullable
    public final String A06() {
        return this.A02;
    }

    @Nullable
    public final String A07() {
        int i2 = this.A00;
        if (i2 > 0 && i2 <= this.A04.size()) {
            return this.A04.get(this.A00 - 1).A04().optString(A00(0, 2, 65));
        }
        return null;
    }

    @Nullable
    public final String A08() {
        return this.A03;
    }

    public final void A09(AnonymousClass92 anonymousClass92) {
        this.A04.add(anonymousClass92);
    }

    public final boolean A0A() {
        return this.A01 == null || C1008Ly.A00() > this.A01.A0C() + ((long) this.A01.A03());
    }
}
