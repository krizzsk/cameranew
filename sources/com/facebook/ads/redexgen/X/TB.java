package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
@TargetApi(19)
/* loaded from: assets/audience_network.dex */
public final class TB implements MV {
    public static byte[] A0C;
    public static String[] A0D = {"VjNTozFJBHBTAbZvfj55MfAwGP9LBSf6", "Pq0aBOwFzXTv3d8c4kUbGJ29Dl7JaeBe", "6Jh9GB1FdSmhvo4jirjJmKwQUVM2B32M", "TGGBgusTs1FvyAgmLwAY3Gsc6eBuJSRW", "x90wDNv6CtBtNBa5WCDyDNAaFj8t5cCY", "GDNjvFSJPJLifqCEdIwxfegvvEeKItWd", "ZGbO0A4ZRQBBFZeQfXm02pkO19XETszh", "zRbEM6nv1u3uOOYe"};
    public static final String A0E;
    public long A00;
    public String A02;
    public String A03;
    public final AnonymousClass52 A07;
    public final JT A08;
    public final NW A09;
    public final NX A0A;
    public final C1175Sm A0B;
    public final AnonymousClass50 A06 = new TE(this);
    public boolean A05 = true;
    public long A01 = -1;
    public boolean A04 = true;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0D;
            if (strArr[1].charAt(18) == strArr[4].charAt(18)) {
                throw new RuntimeException();
            }
            A0D[7] = "WrA4t0RN";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 62);
            i5++;
        }
    }

    public static void A04() {
        A0C = new byte[]{114, -120, -120, -107, -120, -84, -41, -43, -120, -85, -41, -42, -36, -51, -42, -36, -120, -76, -41, -55, -52, -51, -52, -120, -68, -47, -43, -51, -94, -120, -70, -48, -48, -35, -48, -4, 31, 17, 20, -48, -10, 25, 30, 25, 35, 24, -48, 4, 25, 29, 21, -22, -48, -98, -76, -76, -63, -76, -32, 3, -11, -8, -76, -25, 8, -11, 6, 8, -76, -24, -3, 1, -7, -50, -76, -101, -79, -79, -66, -79, -29, -10, 4, 1, 0, -1, 4, -10, -79, -42, -1, -11, -79, -27, -6, -2, -10, -53, -79, -57, -35, -35, -22, -35, 16, 32, 47, 44, 41, 41, -35, 15, 34, 30, 33, 54, -35, 17, 38, 42, 34, -9, -35, -112, -90, -90, -77, -90, -39, -21, -7, -7, -17, -11, -12, -90, -52, -17, -12, -17, -7, -18, -90, -38, -17, -13, -21, -64, -90, -116, 92, 114, 114, Byte.MAX_VALUE, 114, -102, -77, -64, -74, -66, -73, -60, 114, -90, -69, -65, -73, -116, 114, -90, -42, -45, -37, -41, -55, -42, -124, -41, -55, -41, -41, -51, -45, -46, -124, -56, -59, -40, -59, -124, -48, -45, -53, -53, -55, -56, -124, -92, -124, -58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, 9, 25, 22, 30, 26, 12, 25, -4, -7, -13, 24, 33, 30, 26, 35, 41, 9, 36, 32, 26, 35, -54, -61, -48, -58, -50, -57, -44, -74, -53, -49, -57};
    }

    static {
        A04();
        A0E = TB.class.getSimpleName();
    }

    public TB(AnonymousClass52 anonymousClass52, XT xt, JT jt, MU mu) {
        C1175Sm c1175Sm;
        this.A07 = anonymousClass52;
        this.A08 = jt;
        int i2 = (int) (LY.A00 * 2.0f);
        TD td = new TD(this, mu);
        if (xt.A0C() == null) {
            xt.A0D().A80();
        }
        if (JE.A02(xt) || xt.A0C() == null) {
            c1175Sm = new C1175Sm(xt, td);
        } else {
            c1175Sm = new C1175Sm(xt, xt.A0C(), td);
        }
        this.A0B = c1175Sm;
        this.A09 = new NW(xt, this.A0B);
        this.A09.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.A09.setListener(new TC(this, anonymousClass52));
        mu.A3H(this.A09, layoutParams);
        this.A0B.setBrowserNavigationListener(this.A09.getBrowserNavigationListener());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, this.A09.getId());
        layoutParams2.addRule(12);
        mu.A3H(this.A0B, layoutParams2);
        this.A0A = new NX(xt, null, 16842872);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i2);
        layoutParams3.addRule(3, this.A09.getId());
        this.A0A.setProgress(0);
        mu.A3H(this.A0A, layoutParams3);
        anonymousClass52.A0K(this.A06);
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void A8e(Intent intent, Bundle bundle, AnonymousClass52 anonymousClass52) {
        if (this.A01 < 0) {
            this.A01 = System.currentTimeMillis();
        }
        String A03 = A03(231, 11, 36);
        String A032 = A03(220, 11, 119);
        String A033 = A03(210, 10, 105);
        if (bundle == null) {
            this.A02 = intent.getStringExtra(A033);
            this.A03 = intent.getStringExtra(A032);
            String[] strArr = A0D;
            if (strArr[0].charAt(28) != strArr[2].charAt(28)) {
                throw new RuntimeException();
            }
            A0D[5] = "h34ynCyxETZN0C4DuHOjqZ0ETc7IsjOt";
            this.A00 = intent.getLongExtra(A03, -1L);
        } else {
            this.A02 = bundle.getString(A033);
            this.A03 = bundle.getString(A032);
            this.A00 = bundle.getLong(A03, -1L);
        }
        String str = this.A02;
        if (str == null) {
            str = A03(199, 11, 39);
        }
        this.A09.setUrl(str);
        this.A0B.loadUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
        C1035Na A07;
        this.A0B.onPause();
        if (this.A04) {
            this.A04 = false;
            this.A08.A8l(this.A03, new NZ(this.A0B.getFirstUrl()).A01(this.A00).A03(this.A01).A04(this.A0B.getResponseEndMs()).A00(this.A0B.getDomContentLoadedMs()).A05(this.A0B.getScrollReadyMs()).A02(this.A0B.getLoadFinishMs()).A06(System.currentTimeMillis()).A07().A02());
            if (BuildConfigApi.isDebug()) {
                String str = A03(169, 30, 38) + System.currentTimeMillis() + A03(149, 20, 20) + A07.A01 + A03(53, 22, 86) + A07.A03 + A03(75, 24, 83) + A07.A04 + A03(0, 30, 42) + A07.A00 + A03(99, 24, 127) + A07.A05 + A03(30, 23, 114) + A07.A02 + A03(123, 26, 72) + A07.A06;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
        this.A0B.onResume();
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void AE6(Bundle bundle) {
        bundle.putString(A03(210, 10, 105), this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        this.A07.A0L(this.A06);
        C1051Nq.A03(this.A0B);
        this.A0B.destroy();
    }
}
