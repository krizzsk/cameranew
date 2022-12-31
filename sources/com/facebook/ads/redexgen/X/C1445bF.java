package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bF  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1445bF extends AbstractC04850o {
    public static byte[] A03;
    @Nullable
    public View A00;
    public final C05974x A01;
    public final C0803Dr A02;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-23, 7, 20, 20, 21, 26, -58, 22, 24, 11, 25, 11, 20, 26, -58, 20, 27, 18, 18, -58, 7, 10, -4, 15, 11, 29};
    }

    public C1445bF(C05974x c05974x) {
        this.A02 = c05974x.A09();
        this.A01 = c05974x;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0C() {
        this.A02.A0D().A3b();
        C0973Km.A00(new C1447bH(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0D() {
        this.A02.A0D().A3e();
        C0973Km.A00(new C1446bG(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0E(View view) {
        if (view != null) {
            this.A02.A0D().A3d();
            this.A00 = view;
            this.A01.A07().removeAllViews();
            this.A01.A07().addView(this.A00);
            if (this.A00 instanceof C1166Sd) {
                KB.A01(this.A01.A05(), this.A00, this.A01.A0A());
            }
            F8 A08 = this.A01.A08();
            if (A08 != null) {
                A08.A0F();
            }
            C0973Km.A00(new C1448bI(this));
            C05974x c05974x = this.A01;
            c05974x.A0B(c05974x.A07(), this.A00);
            if (Build.VERSION.SDK_INT >= 18 && JD.A0u(this.A01.A07().getContext())) {
                final C1053Ns c1053Ns = new C1053Ns();
                this.A01.A0D(c1053Ns);
                c1053Ns.A0C(this.A01.getPlacementId());
                c1053Ns.A0B(this.A01.A07().getContext().getPackageName());
                if (this.A01.A08() != null && this.A01.A08().A0D() != null) {
                    c1053Ns.A09(this.A01.A08().A0D().A0C());
                }
                View view2 = this.A00;
                if (view2 instanceof C1166Sd) {
                    c1053Ns.A0A(((C1166Sd) view2).getViewabilityChecker());
                }
                this.A00.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.ads.redexgen.X.56
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view3) {
                        View view4;
                        View view5;
                        View view6;
                        view4 = C1445bF.this.A00;
                        if (view4 != null) {
                            C1053Ns c1053Ns2 = c1053Ns;
                            view5 = C1445bF.this.A00;
                            int width = view5.getWidth();
                            view6 = C1445bF.this.A00;
                            c1053Ns2.setBounds(0, 0, width, view6.getHeight());
                            C1053Ns c1053Ns3 = c1053Ns;
                            c1053Ns3.A0D(!c1053Ns3.A0E());
                        }
                        return true;
                    }
                });
                this.A00.getOverlay().add(c1053Ns);
                return;
            }
            return;
        }
        throw new IllegalStateException(A02(0, 26, 113));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0F(InterfaceC04840n interfaceC04840n) {
        this.A02.A0D().A3c(this.A01.A08() != null);
        if (this.A01.A08() != null) {
            this.A01.A08().A0G();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0G(K3 k3) {
        this.A02.A0D().A2a(C1008Ly.A01(this.A01.A04()), k3.A03().getErrorCode(), k3.A04());
        C0973Km.A00(new C1449bJ(this, k3));
    }
}
