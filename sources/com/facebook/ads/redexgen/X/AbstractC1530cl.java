package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.cl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1530cl extends C4A<TA> {
    public static final int A05 = (int) (LY.A00 * 4.0f);
    @Nullable
    public AnonymousClass15 A00;
    public final List<C1198Tj> A01;
    public final int A02;
    public final XT A03;
    @DoNotStrip
    public final QY A04 = new C1532cn(this);

    public AbstractC1530cl(AnonymousClass18 anonymousClass18, List<C1198Tj> list, XT xt) {
        this.A03 = xt;
        this.A02 = anonymousClass18.getChildSpacing();
        this.A01 = list;
    }

    private ViewGroup.MarginLayoutParams A04(int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i3 = this.A02;
        if (i2 == 0) {
            i3 *= 2;
        }
        marginLayoutParams.setMargins(i3, 0, i2 >= this.A01.size() + (-1) ? this.A02 * 2 : this.A02, 0);
        return marginLayoutParams;
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final int A0D() {
        return this.A01.size();
    }

    public final void A0F(ImageView imageView, int i2) {
        C1198Tj c1198Tj = this.A01.get(i2);
        C0953Jr adCoverImage = c1198Tj.getAdCoverImage();
        if (adCoverImage != null) {
            AsyncTaskC1164Sb A04 = new AsyncTaskC1164Sb(imageView, this.A03).A04();
            A04.A06(new C1531cm(this, i2, c1198Tj));
            A04.A07(adCoverImage.getUrl());
        }
    }

    public final void A0G(AnonymousClass15 anonymousClass15) {
        this.A00 = anonymousClass15;
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A0H */
    public void A0E(TA ta, int i2) {
        ta.A0l().setLayoutParams(A04(i2));
    }
}
