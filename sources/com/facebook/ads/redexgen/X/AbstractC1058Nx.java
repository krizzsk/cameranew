package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.Nx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1058Nx extends LinearLayout {
    public static final LinearLayout.LayoutParams A05 = new LinearLayout.LayoutParams(-2, -2);
    public final int A00;
    public final RelativeLayout A01;
    public final XT A02;
    public final SZ A03;
    public final OA A04;

    public abstract void A0A(int i2);

    public AbstractC1058Nx(XT xt, int i2, C1I c1i, boolean z, String str, JT jt, MU mu, QZ qz, C1009Lz c1009Lz) {
        super(xt);
        M5.A0K(this);
        this.A02 = xt;
        this.A00 = i2;
        this.A04 = new OA(xt);
        M5.A0M(this.A04, 0);
        M5.A0K(this.A04);
        this.A03 = new SZ(xt, str, c1i, z, jt, mu, qz, c1009Lz);
        M5.A0G(1001, this.A03);
        this.A01 = new RelativeLayout(xt);
        this.A01.setLayoutParams(A05);
        M5.A0K(this.A01);
    }

    public void A08() {
    }

    public void A09() {
    }

    public final SZ getCTAButton() {
        return this.A03;
    }

    public View getExpandableLayout() {
        return null;
    }

    @VisibleForTesting
    public final ImageView getIconView() {
        return this.A04;
    }

    public void setInfo(C1G c1g, C1J c1j, String str, String str2, @Nullable O0 o0) {
        this.A03.setCta(c1j, str, new HashMap(), o0);
        AsyncTaskC1164Sb asyncTaskC1164Sb = new AsyncTaskC1164Sb(this.A04, this.A02);
        int i2 = this.A00;
        asyncTaskC1164Sb.A05(i2, i2).A07(str2);
    }

    public void setTitleMaxLines(int i2) {
    }
}
