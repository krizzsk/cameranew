package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.84  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass84 extends T4 {
    public static byte[] A0E;
    public static String[] A0F = {"hEO5MspmmQwWZDjfO9hYkGtE8t8ljCUN", "895GOd6GqHS2SDNwtQvAqIE", "zBXblOu1CdgXx49mdyV8flA", "GxqIbNjcrUQMSJiuMkyJv1mwkudVYaGP", "be3ZgXhlaup3yXbKLr41yKjcTusIQNjx", "HLi8FTj59ZkYUe8FmXrpO0CEflvtIm0o", "7bereGXxKpIS6kk2UNHV0kt11i4QSfeP", "LRvrjmvhZNKPrr4qRukG9JYrfPQqD7wd"};
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public int A00;
    public int A01;
    @Nullable
    public LinearLayout A02;
    public C1528cj A03;
    public C7J A04;
    @Nullable
    public C2F A05;
    @Nullable
    public O9 A06;
    public C1144Rh A07;
    @DoNotStrip
    public QY A08;
    public QZ A09;
    public String A0A;
    public List<PE> A0B;
    public final XT A0C;
    public final C1009Lz A0D;

    public static String A07(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0F;
            if (strArr[0].charAt(22) != strArr[6].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[5] = "I427OJiZERIl1pgFYs7VIJxgJMuHqTWY";
            strArr2[4] = "m1VK8a3APoHjuOOKlTc7gi9yCeUy6Tbh";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 74);
            i5++;
        }
    }

    public static void A09() {
        A0E = new byte[]{118, 115, 72, 115, 118, 99, 118, 72, 117, 98, 121, 115, 123, 114};
    }

    static {
        A09();
        A0G = (int) (LY.A00 * 48.0f);
        A0H = (int) (LY.A00 * 8.0f);
        A0I = (int) (LY.A00 * 8.0f);
        A0K = (int) (LY.A00 * 56.0f);
        A0J = (int) (LY.A00 * 12.0f);
    }

    public AnonymousClass84(XT xt, JT jt, C7J c7j, MU mu, C1528cj c1528cj) {
        super(xt, jt, mu, c1528cj);
        this.A0D = new C1009Lz();
        this.A04 = c7j;
        this.A0C = xt;
    }

    private final void A0A() {
        LinearLayout linearLayout = this.A02;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.A02 = null;
        }
        C2F c2f = this.A05;
        if (c2f != null) {
            c2f.removeAllViews();
            this.A05 = null;
        }
        O9 o9 = this.A06;
        if (o9 != null) {
            o9.removeAllViews();
            this.A06 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x011f, code lost:
        if (r5 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0121, code lost:
        r4.A0C.A09().AFC(r4.A05, ((com.facebook.ads.redexgen.X.T4) r4).A08.A0Q(), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0132, code lost:
        r4.A0U(r4.A02, false, r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0137, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x013f, code lost:
        if (r5 != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A0B(int r18, @androidx.annotation.Nullable android.os.Bundle r19) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass84.A0B(int, android.os.Bundle):void");
    }

    private void A0C(C1528cj c1528cj) {
        this.A03 = c1528cj;
        this.A0A = this.A03.A0Q();
        this.A00 = this.A03.A0E();
        this.A01 = this.A03.A0F();
        List<AnonymousClass19> A0X = this.A03.A0X();
        this.A0B = new ArrayList(A0X.size());
        for (int i2 = 0; i2 < A0X.size(); i2++) {
            this.A0B.add(new PE(i2, A0X.size(), A0X.get(i2)));
        }
    }

    private void A0D(C1144Rh c1144Rh) {
        new C0831Et().A0G(this.A05);
        c1144Rh.A0Z(new RX(this));
        this.A06 = new O9(this.A0C, super.A05.A01(), this.A0B.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0I);
        layoutParams.setMargins(0, A0J, 0, 0);
        this.A06.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.T4
    public final boolean A0a() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void A8e(Intent intent, Bundle bundle, AnonymousClass52 anonymousClass52) {
        A0V(anonymousClass52);
        A0C((C1528cj) intent.getSerializableExtra(A07(0, 14, 93)));
        A0B(anonymousClass52.A0H().getResources().getConfiguration().orientation, bundle);
        anonymousClass52.A0K(new RW(this, anonymousClass52));
        int A03 = super.A08.A0K().A0D().A03();
        if (A03 > 0) {
            A0T(A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.T4, com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
        super.ABU(z);
        C1144Rh c1144Rh = this.A07;
        if (c1144Rh != null) {
            c1144Rh.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.X.T4, com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
        super.ABt(z);
        this.A07.A0R();
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void AE6(Bundle bundle) {
        C1144Rh c1144Rh = this.A07;
        if (c1144Rh != null) {
            c1144Rh.A0X(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.X.T4
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        AE6(bundle);
        A0A();
        A0B(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.redexgen.X.T4, com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        super.onDestroy();
        if (JD.A1D(this.A0C)) {
            this.A0C.A09().AF3(this.A05);
        }
        if (!TextUtils.isEmpty(this.A0A)) {
            super.A0A.A8n(this.A0A, new C1055Nu().A03(this.A09).A02(this.A0D).A05());
        }
        A0A();
        this.A09.A0V();
        this.A09 = null;
        this.A08 = null;
        this.A0B = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0D.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
