package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.bS  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1458bS extends C05272f {
    public static String[] A01 = {"Aypyv0FACfsPQTq8B8UFxLSJIGYFzsCC", "O7nTze5knL3NcSr2rovnk7vqxWhLtUKF", "w8KDuB7m9FBYOy6hiJzio9ilRX5MSLSp", "Kqe5H6YPSeJrA9PRZ2BXFN4qonyjjTB9", "VPpNE9vsyh3HxU94PoFE47DnBqUfoC5Y", "VSW3ZMLcugYKNhiURlJ0g5uJ7Smp29SS", "AB", "JpT6Sbfy0irMNtnKFHDBnJ8tZotKHb"};
    public final C1457bR A00;

    public C1458bS(C1457bR c1457bR) {
        this.A00 = c1457bR;
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final void A08(View view, C3Q c3q) {
        super.A08(view, c3q);
        if (!this.A00.A0B() && this.A00.A01.getLayoutManager() != null) {
            this.A00.A01.getLayoutManager().A1C(view, c3q);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C05272f
    public final boolean A09(View view, int i2, Bundle bundle) {
        if (super.A09(view, i2, bundle)) {
            if (A01[2].charAt(3) != 'j') {
                A01[6] = "SRS22nAnXgHfwC2qheyHP9Kgc2YZ";
                return true;
            }
            throw new RuntimeException();
        } else if (!this.A00.A0B() && this.A00.A01.getLayoutManager() != null) {
            return this.A00.A01.getLayoutManager().A1b(view, i2, bundle);
        } else {
            return false;
        }
    }
}
