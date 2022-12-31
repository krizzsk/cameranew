package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* renamed from: com.facebook.ads.redexgen.X.85  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass85 extends T4 implements PJ {
    public static byte[] A0N;
    public static String[] A0O = {"jpfQHsJU1lQWxp7CXlwdVdxcmzkEjD3g", "zEjz0M8mBGIlVid6uM60nN2wm9TWrUGD", "N1PpSZkKdQQSk7AxXPBdtL04F7CB9SRH", "NsCDsqdLjA318x1fHEY8u0Kcg9miAoAi", "WmIcjMDFfLwNDk", "", "Zb94j8IQkKLdVAKFmXIR3eGQpuAhW41l", "pxOHyfKHQ8aixQeNEjeruqZzDXsiYM9P"};
    public static final int A0P;
    public static final int A0Q;
    public static final int A0R;
    public static final int A0S;
    public int A00;
    public int A01;
    public int A02;
    @Nullable
    public RelativeLayout A03;
    public C1528cj A04;
    public C7J A05;
    @Nullable
    public C2F A06;
    @Nullable
    public AbstractC1058Nx A07;
    @Nullable
    public O9 A08;
    @Nullable
    public C1144Rh A09;
    @Nullable
    @DoNotStrip
    public QY A0A;
    public QZ A0B;
    @Nullable
    public String A0C;
    public List<PE> A0D;
    public final int A0E;
    public final C1I A0F;
    public final XT A0G;
    public final C1009Lz A0H;
    public final MU A0I;
    public final ON A0J;
    public final PK A0K;
    public final PK A0L;
    public final IS A0M;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0N, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = (copyOfRange[i5] - i4) - 14;
            if (A0O[0].charAt(17) == 'P') {
                throw new RuntimeException();
            }
            A0O[5] = "";
            copyOfRange[i5] = (byte) i6;
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        byte[] bArr = {94, -117, -117, -120, -117, 57, 124, -117, 126, 122, -115, -126, -121, Byte.MIN_VALUE, 57, 124, 122, -117, -120, -114, -116, 126, -123, 57, -113, -126, 126, -112, 89, -122, -122, -125, -122, 52, -117, 124, 125, Byte.MIN_VALUE, 121, 52, 119, 117, -122, -125, -119, -121, 121, Byte.MIN_VALUE, 52, 119, 117, -122, 120, 52, 119, 124, 117, -126, 123, 121, 66, 91, 87, 86, -118, 121, 126, 122, -125, 120, 122, 99, 122, -119, -116, -124, -121, Byte.MIN_VALUE, -97, -94, -99, -94, -97, -78, -97, -99, -96, -77, -84, -94, -86, -93, -33, -21, -23, -86, -30, -35, -33, -31, -34, -21, -21, -25, -86, -35, -32, -17, -86, -27, -22, -16, -31, -18, -17, -16, -27, -16, -27, -35, -24, -86, -33, -24, -27, -33, -25, -31, -32};
        if (A0O[0].charAt(17) == 'P') {
            throw new RuntimeException();
        }
        A0O[0] = "0pXVmbGKHAzIVbBBK7Eyv6Mrdc2f0VIY";
        A0N = bArr;
    }

    static {
        A0B();
        A0Q = (int) (LY.A00 * 8.0f);
        A0R = (int) (LY.A00 * 8.0f);
        A0S = (int) (LY.A00 * 12.0f);
        A0P = (int) (LY.A00 * 42.0f);
    }

    public AnonymousClass85(XT xt, JT jt, C7J c7j, MU mu, C1528cj c1528cj) {
        super(xt, jt, mu, c1528cj);
        this.A0H = new C1009Lz();
        this.A00 = -1;
        this.A05 = c7j;
        this.A0G = xt;
        this.A0I = mu;
        this.A0E = super.A08.A0X().size();
        this.A0M = new IS(this.A0G);
        this.A0L = new PK(this.A0G, PI.A04, this);
        this.A0K = new PK(this.A0G, PI.A03, this);
        this.A0J = new OM(this.A0G, jt, getAudienceNetworkListener(), this.A04, null, this.A0B, this.A0H).A0J();
        this.A0F = c1528cj.A0J().A01();
        if (JD.A1Q(this.A0G)) {
            super.A0C.setProgressSpinnerInvisible(true);
        }
    }

    private void A08() {
        if (this.A00 > 0) {
            this.A0K.setVisibility(0);
        } else {
            this.A0K.setVisibility(8);
        }
        if (this.A00 != this.A0E - 1) {
            PK pk = this.A0L;
            String[] strArr = A0O;
            if (strArr[7].charAt(14) == strArr[1].charAt(14)) {
                throw new RuntimeException();
            }
            A0O[0] = "6a52QfyEa3IWfhbHGHqjZ8J10HxaoQoC";
            pk.setVisibility(0);
            return;
        }
        this.A0L.setVisibility(8);
    }

    private void A09() {
        if (this.A08 != null && this.A06 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (getResources().getConfiguration().orientation == 1) {
                layoutParams.addRule(3, this.A06.getId());
                layoutParams.setMargins(0, A0Q, 0, 0);
            } else {
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, A0Q);
            }
            layoutParams.addRule(14);
            this.A08.setLayoutParams(layoutParams);
        }
    }

    private void A0A() {
        int min;
        int i2;
        int childWidth;
        int i3 = getResources().getConfiguration().orientation;
        int i4 = LY.A01.widthPixels;
        int i5 = LY.A01.heightPixels;
        if (i3 == 1) {
            int height = A0Q;
            int i6 = i4 - (height * 4);
            int height2 = i5 / 2;
            min = Math.min(i6, height2);
            i2 = (i4 - min) / 8;
            childWidth = i2 * 4;
            this.A0K.setVisibility(8);
            this.A0L.setVisibility(8);
        } else {
            min = Math.min(i5, i4);
            i2 = (i4 - min) / 2;
            childWidth = i2;
            A08();
        }
        C2F c2f = this.A06;
        if (c2f != null) {
            C1143Rg fullscreenCarouselRecyclerViewAdapter = c2f.getFullscreenCarouselRecyclerViewAdapter();
            if (fullscreenCarouselRecyclerViewAdapter != null) {
                fullscreenCarouselRecyclerViewAdapter.A0F(min, i2, childWidth);
                fullscreenCarouselRecyclerViewAdapter.A06();
                return;
            }
            return;
        }
        Log.e(A06(61, 17, 7), A06(0, 28, 11));
        onDestroy();
    }

    private final void A0C() {
        C2F c2f = this.A06;
        if (c2f != null) {
            c2f.removeAllViews();
            this.A06 = null;
        }
        O9 o9 = this.A08;
        if (o9 != null) {
            o9.removeAllViews();
            this.A08 = null;
        }
        RelativeLayout relativeLayout = this.A03;
        if (A0O[5].length() != 0) {
            throw new RuntimeException();
        }
        A0O[5] = "";
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    private final void A0D(int i2, @Nullable Bundle bundle) {
        boolean z = i2 == 1;
        this.A03 = new RelativeLayout(getContext());
        this.A07 = new SV(this.A0G, 0, this.A0D.get(0).A03().A0E().A00() == C1E.A05, this.A0F, super.A08.A0K().A0F().A06(), A06(92, 37, 110), getAdEventManager(), this.A0I, this.A0B, this.A0H);
        this.A07.A0A(z ? 1 : 0);
        this.A03.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A0A = new C1142Rf(this);
        this.A0B = new QZ(this, 1, new WeakReference(this.A0A), this.A0G);
        this.A0B.A0W(this.A01);
        this.A0B.A0X(this.A02);
        this.A06 = new C2F(this.A0G);
        M5.A0K(this.A06);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.A09 = new C1144Rh(this.A06, i2, this.A0D, this.A0B, bundle);
        if (this.A0C != null) {
            this.A06.setAdapter(new C1143Rg(this.A0G, this.A0D, this.A04, super.A0A, this.A05, this.A0B, this.A0H, getAudienceNetworkListener(), this.A0C, this.A09, this.A0M));
            A0A();
        } else if (A0O[0].charAt(17) == 'P') {
            throw new RuntimeException();
        } else {
            A0O[5] = "";
            Log.e(A06(61, 17, 7), A06(0, 28, 11));
            onDestroy();
        }
        A0F(this.A09);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        if (JD.A1D(this.A0G)) {
            InterfaceC0941Jf A09 = this.A0G.A09();
            C2F c2f = this.A06;
            String A0Q2 = super.A08.A0Q();
            if (A0O[4].length() == 17) {
                throw new RuntimeException();
            }
            A0O[5] = "";
            A09.AFC(c2f, A0Q2, false);
        }
        this.A03.addView(this.A06, layoutParams);
        A09();
        this.A03.addView(this.A08);
        this.A07.setTitleMaxLines(3);
        this.A07.A09();
        this.A07.A08();
        this.A03.addView(this.A07, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        int i3 = A0P;
        layoutParams3.width = i3;
        layoutParams3.height = i3;
        layoutParams3.setMargins(A0Q, 0, 0, 0);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        int i4 = A0P;
        layoutParams4.width = i4;
        layoutParams4.height = i4;
        layoutParams4.setMargins(0, 0, A0Q, 0);
        this.A03.addView(this.A0K, layoutParams3);
        this.A03.addView(this.A0L, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(12);
        this.A03.addView(this.A0M, layoutParams5);
        A0U(this.A03, true, i2);
        removeView(findViewById(OH.A00));
        boolean isPortrait = JD.A1s(this.A0G);
        if (isPortrait) {
            M5.A0M(this, -1);
        } else {
            OH.A00(this.A0J.A05(), this, this.A04.A0K().A0D().A07());
        }
        if (this.A0C != null) {
            this.A07.setInfo(this.A04.A0K().A0E(), this.A04.A0K().A0F(), this.A0C, super.A08.A0N().A01(), null);
        }
    }

    private void A0E(C1528cj c1528cj) {
        this.A04 = c1528cj;
        this.A0C = this.A04.A0Q();
        this.A01 = this.A04.A0E();
        this.A02 = this.A04.A0F();
        List<AnonymousClass19> A0X = this.A04.A0X();
        this.A0D = new ArrayList(A0X.size());
        for (int i2 = 0; i2 < A0X.size(); i2++) {
            this.A0D.add(new PE(i2, A0X.size(), A0X.get(i2)));
        }
    }

    private void A0F(C1144Rh c1144Rh) {
        new C0831Et().A0G(this.A06);
        c1144Rh.A0Z(new C1141Re(this));
        this.A08 = new O9(this.A0G, super.A05.A01(), this.A0D.size());
        M5.A0K(this.A08);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0R);
        layoutParams.setMargins(0, A0S, 0, 0);
        this.A08.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.T4
    public final boolean A0a() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void A8e(Intent intent, @Nullable Bundle bundle, AnonymousClass52 anonymousClass52) {
        C1528cj c1528cj = (C1528cj) intent.getSerializableExtra(A06(78, 14, 48));
        A0V(anonymousClass52);
        if (c1528cj != null) {
            A0E(c1528cj);
        }
        A0D(anonymousClass52.A0H().getResources().getConfiguration().orientation, bundle);
        anonymousClass52.A0K(new C1140Rd(this, anonymousClass52));
        int A03 = super.A08.A0K().A0D().A03();
        if (A03 > 0) {
            A0T(A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.T4, com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
        super.ABU(z);
        C1144Rh c1144Rh = this.A09;
        if (c1144Rh != null) {
            c1144Rh.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.X.T4, com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
        super.ABt(z);
        C1144Rh c1144Rh = this.A09;
        if (c1144Rh != null) {
            c1144Rh.A0R();
        }
    }

    @Override // com.facebook.ads.redexgen.X.PJ
    public final void ACD(PI pi) {
        int i2;
        C2F c2f = this.A06;
        if (c2f != null) {
            C1469be layoutManager = c2f.getLayoutManager();
            if (pi == PI.A03) {
                int i3 = this.A00;
                i2 = i3 <= 0 ? 0 : i3 - 1;
                layoutManager.A21(this.A06, new C05754b(), i2);
            } else {
                int i4 = this.A00;
                int i5 = this.A0E;
                i2 = i4 >= i5 + (-1) ? i5 - 1 : i4 + 1;
                layoutManager.A21(this.A06, new C05754b(), i2);
            }
            setUpLayoutForCardAtIndex(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void AE6(Bundle bundle) {
        C1144Rh c1144Rh = this.A09;
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
        AE6(new Bundle());
        super.onConfigurationChanged(configuration);
        A0A();
        C2F c2f = this.A06;
        if (c2f != null && this.A09 != null) {
            c2f.getLayoutManager().A1t(Math.max(this.A00, 0));
            this.A09.A0U(Math.max(this.A00, 0));
        }
        A09();
        AbstractC1058Nx abstractC1058Nx = this.A07;
        if (abstractC1058Nx != null) {
            abstractC1058Nx.A0A(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.X.T4, com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        super.onDestroy();
        if (JD.A1D(this.A0G)) {
            InterfaceC0941Jf A09 = this.A0G.A09();
            if (A0O[0].charAt(17) == 'P') {
                throw new RuntimeException();
            }
            A0O[4] = "nCvA44nJ0TVVJ";
            A09.AF3(this.A06);
        }
        if (!TextUtils.isEmpty(this.A0C)) {
            super.A0A.A8n(this.A0C, new C1055Nu().A03(this.A0B).A02(this.A0H).A05());
        }
        A0C();
        this.A0B.A0V();
        this.A0B = null;
        this.A0A = null;
        this.A0D = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0H.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setUpLayoutForCardAtIndex(int r12) {
        /*
            r11 = this;
            com.facebook.ads.redexgen.X.O9 r0 = r11.A08
            if (r0 == 0) goto L7
            r0.A00(r12)
        L7:
            com.facebook.ads.redexgen.X.cj r0 = r11.A04
            com.facebook.ads.redexgen.X.19 r4 = r0.A0L(r12)
            if (r4 == 0) goto L81
            int r0 = r11.A00
            if (r0 == r12) goto L81
            r11.A00 = r12
            android.content.res.Resources r0 = r11.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r1 = r0.orientation
            r0 = 2
            if (r1 != r0) goto L25
            r11.A08()
        L25:
            int r0 = com.facebook.ads.redexgen.X.OH.A00
            android.view.View r0 = r11.findViewById(r0)
            r11.removeView(r0)
            com.facebook.ads.redexgen.X.XT r0 = r11.A0G
            boolean r0 = com.facebook.ads.redexgen.X.JD.A1s(r0)
            if (r0 == 0) goto La3
            r0 = -1
            com.facebook.ads.redexgen.X.M5.A0M(r11, r0)
        L3a:
            java.lang.String r0 = r11.A0C
            if (r0 == 0) goto L58
            com.facebook.ads.redexgen.X.Nx r5 = r11.A07
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.AnonymousClass85.A0O
            r0 = 0
            r1 = r1[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            r0 = 80
            if (r1 == r0) goto Lb5
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.AnonymousClass85.A0O
            java.lang.String r1 = "kFih28rpO37RepskuaJrvvoNb65qRIkh"
            r0 = 6
            r2[r0] = r1
            if (r5 != 0) goto L8a
        L58:
            r2 = 61
            r1 = 17
            r0 = 7
            java.lang.String r3 = A06(r2, r1, r0)
            r2 = 28
            r1 = 33
            r0 = 6
            java.lang.String r0 = A06(r2, r1, r0)
            android.util.Log.e(r3, r0)
        L6d:
            com.facebook.ads.redexgen.X.1C r0 = r4.A0D()
            java.lang.String r0 = r0.A08()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L82
            com.facebook.ads.redexgen.X.IS r1 = r11.A0M
            r0 = 0
            r1.setVisibility(r0)
        L81:
            return
        L82:
            com.facebook.ads.redexgen.X.IS r1 = r11.A0M
            r0 = 8
            r1.setVisibility(r0)
            goto L81
        L8a:
            com.facebook.ads.redexgen.X.1G r6 = r4.A0E()
            com.facebook.ads.redexgen.X.1J r7 = r4.A0F()
            java.lang.String r8 = r11.A0C
            com.facebook.ads.redexgen.X.cj r0 = r11.A08
            com.facebook.ads.redexgen.X.1S r0 = r0.A0N()
            java.lang.String r9 = r0.A01()
            r10 = 0
            r5.setInfo(r6, r7, r8, r9, r10)
            goto L6d
        La3:
            com.facebook.ads.redexgen.X.ON r0 = r11.A0J
            com.facebook.ads.redexgen.X.XT r1 = r0.A05()
            com.facebook.ads.redexgen.X.1C r0 = r4.A0D()
            java.lang.String r0 = r0.A07()
            com.facebook.ads.redexgen.X.OH.A00(r1, r11, r0)
            goto L3a
        Lb5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass85.setUpLayoutForCardAtIndex(int):void");
    }
}
