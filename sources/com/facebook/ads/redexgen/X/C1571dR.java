package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.Nullsafe$Mode;
@Nullsafe(Nullsafe$Mode.LOCAL)
/* renamed from: com.facebook.ads.redexgen.X.dR  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1571dR {
    public final C1582dc A00;
    public final C1580da A01;

    public C1571dR(AbstractC1587dh abstractC1587dh, C1580da c1580da, C1582dc c1582dc) {
        this.A00 = c1582dc;
        this.A01 = c1580da;
        abstractC1587dh.A02(new G2(c1580da));
    }

    public static C1571dR A00(AbstractC1587dh abstractC1587dh, InterfaceC1591dl interfaceC1591dl, G3 g3) {
        C1582dc c1582dc = new C1582dc();
        return new C1571dR(abstractC1587dh, new C1580da(interfaceC1591dl, new G6(), g3, c1582dc, new Handler()), c1582dc);
    }

    public final void A01(View view) {
        this.A00.A01(view);
    }

    public final void A02(View view, C1589dj c1589dj) {
        this.A00.A02(view, c1589dj);
    }

    public final void A03(@Nullable InterfaceC1586dg interfaceC1586dg) {
        this.A01.A0B(interfaceC1586dg);
    }

    public final void A04(@Nullable InterfaceC1584de interfaceC1584de) {
        this.A01.A0C(interfaceC1584de);
    }
}
