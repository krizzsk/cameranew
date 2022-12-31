package com.facebook.ads.redexgen.X;

import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.view.View;
import androidx.annotation.Nullable;
@TargetApi(12)
/* loaded from: assets/audience_network.dex */
public final class JX implements InterfaceC1095Pk {
    public static String[] A0B = {"82Zz8oCZg8zkkbzw8opl2Yz4CtrF2SDp", "9Qv", "sj5N5SmrmBRQmWue5o8rJw6ys3alFtJa", "lBA7odrZYL425", "CSSBUKaIJSWMhqfJuWGnuyX4cipoTk5I", "IDQP5gLMbSSnC18VVbdsGZXvkzghwpNg", "Yf1MSxzKxHs57zUlY7hI2xykX4pHUq1P", "T3bn0lMwtbok5v0PvXD6574OGDOrX6LS"};
    public View A00;
    @Nullable
    public C1099Po A01;
    @Nullable
    public EnumC1107Pw A02;
    public boolean A03;
    public final Handler A04;
    public final AbstractC1018Mi A05;
    public final L3 A06;
    public final AbstractC0976Kq A07;
    public final KO A08;
    public final boolean A09;
    public final boolean A0A;

    public JX(View view, EnumC1107Pw enumC1107Pw, boolean z) {
        this(view, enumC1107Pw, z, false);
    }

    public JX(View view, @Nullable EnumC1107Pw enumC1107Pw, boolean z, boolean z2) {
        this.A06 = new L3() { // from class: com.facebook.ads.redexgen.X.7g
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06677u c06677u) {
                JX.this.A06(1, 0);
            }
        };
        this.A07 = new AbstractC0976Kq() { // from class: com.facebook.ads.redexgen.X.7f
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0977Kr c0977Kr) {
                boolean z3;
                EnumC1107Pw enumC1107Pw2;
                boolean z4;
                z3 = JX.this.A03;
                if (!z3) {
                    return;
                }
                enumC1107Pw2 = JX.this.A02;
                if (enumC1107Pw2 != EnumC1107Pw.A03) {
                    z4 = JX.this.A09;
                    if (!z4) {
                        JX.this.A06(0, 8);
                        return;
                    }
                }
                JX.this.A02 = null;
                JX.this.A05();
            }
        };
        this.A05 = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.7e
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06687v c06687v) {
                EnumC1107Pw enumC1107Pw2;
                View view2;
                View view3;
                enumC1107Pw2 = JX.this.A02;
                if (enumC1107Pw2 == EnumC1107Pw.A04) {
                    return;
                }
                view2 = JX.this.A00;
                view2.setAlpha(1.0f);
                view3 = JX.this.A00;
                view3.setVisibility(0);
            }
        };
        this.A08 = new C06547d(this);
        this.A03 = true;
        this.A04 = new Handler();
        this.A09 = z;
        this.A0A = z2;
        A08(view, enumC1107Pw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        this.A00.animate().alpha(0.0f).setDuration(500L).setListener(new C1106Pv(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(int i2, int i3) {
        this.A04.removeCallbacksAndMessages(null);
        this.A00.clearAnimation();
        this.A00.setAlpha(i2);
        this.A00.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(AnimatorListenerAdapter animatorListenerAdapter) {
        this.A00.setVisibility(0);
        this.A00.animate().alpha(1.0f).setDuration(500L).setListener(animatorListenerAdapter);
    }

    private final void A08(View view, EnumC1107Pw enumC1107Pw) {
        this.A02 = enumC1107Pw;
        this.A00 = view;
        this.A00.clearAnimation();
        if (enumC1107Pw == EnumC1107Pw.A04) {
            this.A00.setAlpha(0.0f);
            String[] strArr = A0B;
            if (strArr[5].charAt(26) == strArr[0].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[5] = "3OWa54Sl5zOXBo6RskK22JrE4LW5JWKj";
            strArr2[0] = "lt7hksMEFpJVhV2333OBcIopOVPW9bfy";
            this.A00.setVisibility(8);
            return;
        }
        this.A00.setAlpha(1.0f);
        this.A00.setVisibility(0);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void A8f(C1099Po c1099Po) {
        this.A01 = c1099Po;
        c1099Po.getEventBus().A03(this.A06, this.A07, this.A08, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1095Pk
    public final void AF4(C1099Po c1099Po) {
        A06(1, 0);
        c1099Po.getEventBus().A04(this.A05, this.A08, this.A07, this.A06);
        this.A01 = null;
    }
}
