package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class PU {
    public final AnonymousClass17 A00;
    public final C1G A01;
    public final C1K A02;
    public final C1S A03;
    public final XT A04;
    public final C0937Jb A05;
    public static String[] A06 = {"67PC1vS7qkP", "IjFo3BG6VwtzNtFBLMxB3hm7uxcMitzp", "CicRHWg02u8tYTVNboa", "Lc1HqPOOGgkkm0o4iF185HVfJQb2Oy4J", "rfUiy7qGv2cTTJD", "veTQu7RBhk0w6DuY7Y8JViB1PkIKs", "nFnk8VxBkehLa6QhTm5QccOE2IAl", "l0nPd7gOfqjUiTZVoVDHfvPfOU4VPF8e"};
    public static final int A09 = (int) (LY.A00 * 4.0f);
    public static final int A07 = (int) (LY.A00 * 72.0f);
    public static final int A08 = (int) (LY.A00 * 8.0f);

    public PU(XT xt, JT jt, AnonymousClass16 anonymousClass16) {
        this.A04 = xt;
        this.A05 = new C0937Jb(anonymousClass16.A0Q(), jt);
        this.A00 = anonymousClass16.A0J();
        this.A01 = anonymousClass16.A0K().A0E();
        this.A03 = anonymousClass16.A0N();
        this.A02 = anonymousClass16.A0K().A0G();
    }

    private View A00() {
        C0828Eq c0828Eq = new C0828Eq(this.A04);
        c0828Eq.setLayoutManager(new C1469be(this.A04, 0, false));
        c0828Eq.setAdapter(new RS(this.A04, this.A02.A00(), A09));
        return c0828Eq;
    }

    private View A01(@Nullable SZ sz) {
        OG og = new OG(this.A04, this.A00.A01(), true, false, false);
        og.A01(this.A01.A06(), this.A01.A01(), null, false, true);
        og.setAlignment(17);
        OA oa = new OA(this.A04);
        M5.A0M(oa, 0);
        oa.setRadius(50);
        new AsyncTaskC1164Sb(oa, this.A04).A04().A07(this.A03.A01());
        LinearLayout linearLayout = new LinearLayout(this.A04);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i2 = A07;
        linearLayout.addView(oa, new LinearLayout.LayoutParams(i2, i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i3 = A08;
        layoutParams.setMargins(0, i3, 0, i3);
        linearLayout.addView(og, layoutParams);
        if (sz != null) {
            M5.A0J(sz);
            linearLayout.addView(sz, layoutParams);
            if (TextUtils.isEmpty(sz.getText())) {
                M5.A0H(sz);
            }
        }
        return linearLayout;
    }

    private final PT A02() {
        if (!this.A02.A00().isEmpty()) {
            return PT.A04;
        }
        PT pt = PT.A03;
        String[] strArr = A06;
        if (strArr[3].charAt(8) != strArr[7].charAt(8)) {
            A06[4] = "qwlEjiYhEcV8j1J";
            return pt;
        }
        throw new RuntimeException();
    }

    public final Pair<PT, View> A03(@Nullable SZ sz) {
        View A00;
        PT A02 = A02();
        if (PS.A00[A02.ordinal()] != 1) {
            A00 = A01(sz);
        } else {
            A00 = A00();
        }
        C0939Jd.A04(A00, this.A05, EnumC0936Ja.A0S);
        return new Pair<>(A02, A00);
    }
}
