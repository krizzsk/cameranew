package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.3S  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3S {
    public static final C3R A01;
    public final Object A00;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            A01 = new C0832Ew();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A01 = new C0833Ex();
        } else {
            A01 = new C1473bi();
        }
    }

    public C3S() {
        this.A00 = A01.A9W(this);
    }

    public C3S(Object obj) {
        this.A00 = obj;
    }

    @Nullable
    public final C3Q A00(int i2) {
        return null;
    }

    @Nullable
    public final C3Q A01(int i2) {
        return null;
    }

    public final Object A02() {
        return this.A00;
    }

    @Nullable
    public final List<C3Q> A03(String str, int i2) {
        return null;
    }

    public final boolean A04(int i2, int i3, Bundle bundle) {
        return false;
    }
}
