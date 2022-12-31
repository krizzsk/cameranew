package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class A1 extends C1144Rh {
    public static String[] A00 = {"4DJOkXe9rib7uWc4nLa4kcuSPdxs7gf4", "Dyxr4XzeXsq4jjw5BU630cyoQdL32ISv", "MScpZjpz", "3XC0FNsyX3k6WX9dbHhU9IwCEOagJZ1X", "JEKgPGdFYfe9RoD8dW0t8x0Mvi1GtEmi", "N5tdloXdcly7PUtxD1ZshZXdUDk2Lr2A", "5elKCHWntj6O1Wqi1faAvLWvEV4yzp2T", "JBMx9492vmjOwkRP6"};

    public A1(C2F c2f, int i2, @Nullable List<PE> list, @Nullable QZ qz, @Nullable Bundle bundle) {
        super(c2f, i2, list, qz, bundle);
        c2f.A1j(this);
        this.A03 = new C1174Sl(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        int A27 = this.A0C.A27();
        if (this.A05 != null && A27 != -1 && A27 < this.A05.size() - 1) {
            A0V(A27 + 1);
        }
    }

    private void A01(int lastVisibleItem) {
        int A28 = this.A0C.A28();
        int A29 = this.A0C.A29();
        int visibleItem = this.A0C.A27();
        if (visibleItem != A28) {
            A0S(A28);
        }
        if (visibleItem != A29) {
            A0S(A29);
        }
        A0T(visibleItem);
        A0W(A28, A29, lastVisibleItem);
    }

    @Override // com.facebook.ads.redexgen.X.C1144Rh, com.facebook.ads.redexgen.X.C4R
    public final void A0L(C0828Eq c0828Eq, int i2) {
    }

    @Override // com.facebook.ads.redexgen.X.C1144Rh, com.facebook.ads.redexgen.X.C4R
    public final void A0M(C0828Eq c0828Eq, int i2, int i3) {
        if (this.A0C.A27() != -1) {
            SJ sj = (SJ) this.A0C.A1q(this.A0C.A27());
            if (A00[2].length() == 4) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[3] = "IxYVUA16uQkbjXwNztolao4gyOA0tKzF";
            strArr[6] = "jcO9EzcXxFOxyF2BSjZiD0vteRj0mA5y";
            if (sj != null && sj.A0i() && !sj.A0h()) {
                sj.A0f();
            }
            A01(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1144Rh
    public final void A0Y(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.8f);
    }

    @Override // com.facebook.ads.redexgen.X.C1144Rh
    public final void A0a(SJ sj, boolean z) {
        A0Y(sj, z);
        if (!z && sj.A0h()) {
            sj.A0e();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1144Rh
    public final boolean A0b(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.75f;
    }

    public final QZ A0c() {
        return this.A04;
    }

    public final void A0d(QZ qz) {
        this.A04 = qz;
    }

    public final void A0e(List<PE> list) {
        this.A05 = list;
    }
}
