package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.EnumSet;
/* renamed from: com.facebook.ads.redexgen.X.6h  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06326h {
    public final int A00;
    public final InterfaceC06356k A01;
    public final EnumSet<EnumC06396o> A02;

    public C06326h(int i2, EnumSet<EnumC06396o> enumSet, InterfaceC06356k interfaceC06356k) {
        this.A00 = i2;
        this.A02 = enumSet;
        this.A01 = interfaceC06356k;
    }

    public final int A00() {
        return this.A00;
    }

    @Nullable
    public final InterfaceC06356k A01() {
        if (this.A02.contains(EnumC06396o.A07)) {
            return this.A01;
        }
        return null;
    }

    @Nullable
    public final InterfaceC06356k A02(EnumC06366l enumC06366l) {
        if (A04(enumC06366l)) {
            return this.A01;
        }
        return null;
    }

    public final EnumSet<EnumC06396o> A03() {
        return this.A02;
    }

    public final boolean A04(EnumC06366l enumC06366l) {
        return AnonymousClass78.A0E(enumC06366l) && this.A02.contains(EnumC06396o.A00(enumC06366l.A03()));
    }
}
