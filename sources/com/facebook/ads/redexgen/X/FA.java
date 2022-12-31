package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class FA extends AbstractC1530cl {
    public static byte[] A02;
    public final XT A00;
    public final C0955Jt A01;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 57);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-33, -35, -24, -24, -37, -16, -21, -37, -35, -33, -16, -27, -21, -22, 3, 0, -4, -1, 7, 4, 9, 0, -61, -64, -59, -62, -74, -69, -68, -54, -70, -55, -64, -57, -53, -64, -58, -59};
    }

    public FA(XT xt, AnonymousClass18 anonymousClass18, List<C1198Tj> list, @Nullable C0955Jt c0955Jt) {
        super(anonymousClass18, list, xt);
        this.A00 = xt;
        this.A01 = c0955Jt == null ? new C0955Jt() : c0955Jt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A01 */
    public final TA A0C(ViewGroup viewGroup, int i2) {
        return new TA(new MW(this.A00, this.A01));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1530cl, com.facebook.ads.redexgen.X.C4A
    /* renamed from: A0H */
    public final void A0E(TA ta, int i2) {
        super.A0E(ta, i2);
        MW mw = (MW) ta.A0l();
        A0F(mw.getImageCardView(), i2);
        mw.setTitle(((AbstractC1530cl) this).A01.get(i2).A1F(A02(14, 8, 98)));
        mw.setSubtitle(((AbstractC1530cl) this).A01.get(i2).A1F(A02(22, 16, 30)));
        mw.setButtonText(((AbstractC1530cl) this).A01.get(i2).A1F(A02(0, 14, 67)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(mw);
        ((AbstractC1530cl) this).A01.get(i2).A1N(mw, mw, arrayList);
    }
}
