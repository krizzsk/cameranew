package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class V5 implements G9 {
    @Nullable
    public CS A02;
    @Nullable
    public Object A03;
    @Nullable
    public String A04;
    public boolean A05;
    public final HQ A06;
    public int A01 = -1;
    public int A00 = 1048576;

    public V5(HQ hq) {
        this.A06 = hq;
    }

    public final C0747Bc A00(Uri uri) {
        this.A05 = true;
        if (this.A02 == null) {
            this.A02 = new WQ();
        }
        return new C0747Bc(uri, this.A06, this.A02, this.A01, this.A04, this.A00, this.A03);
    }
}
