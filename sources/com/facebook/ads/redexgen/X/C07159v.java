package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.9v  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C07159v extends SJ {
    @Nullable
    public C1022Mm A00;
    @Nullable
    public OW A01;
    @Nullable
    public PG A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    @Nullable
    public RelativeLayout A06;
    public C1144Rh A07;
    public final XT A08;
    public final AbstractC1018Mi A09;
    public final L3 A0A;
    public final AbstractC0976Kq A0B;
    public final AbstractC0971Kk A0C;
    public final KM A0D;
    public final String A0E;
    public final Paint A0F;
    public final Path A0G;
    public final RectF A0H;
    public final ON A0I;
    public static String[] A0J = {"dJoea1DbFsfm9GTpKIzcXYdmCRfBe4FS", "N1xc2MysRccxXRgwDgHXZSQeh7bFq7uk", "3nDu3mubCrSGPsHb", "SUxuavEQD34fwSKO8hxc7w", "hmAyL1Y1BI3zOyZEMNvfuG", "1nycCDmAbpyAo4RWRzHJ2ixoeiRT", "fh6VcnyoMwgZMcb2oBIx6", "bmD"};
    public static final int A0L = (int) (LY.A00 * 0.0f);
    public static final int A0M = (int) (LY.A00 * 9.0f);
    public static final int A0K = (int) (LY.A00 * 9.0f);

    public C07159v(ON on, boolean z, String str, C1144Rh c1144Rh) {
        super(on, z);
        this.A0G = new Path();
        this.A0H = new RectF();
        this.A0D = new A0(this);
        this.A09 = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.9z
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06687v c06687v) {
                C07159v.this.A01();
                Object tag = C07159v.this.getTag(-1593835536);
                if (tag != null) {
                    C07159v.this.A07.A0N().ACO(((Integer) tag).intValue());
                }
            }
        };
        this.A0B = new AbstractC0976Kq() { // from class: com.facebook.ads.redexgen.X.9y
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0977Kr c0977Kr) {
                C07159v.this.A00();
                C07159v.this.A07.A0O().ACX(C07159v.this);
            }
        };
        this.A0A = new L3() { // from class: com.facebook.ads.redexgen.X.9x
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06677u c06677u) {
                C07159v.this.A01();
                C07159v.this.A07.A0O().ACV(C07159v.this);
            }
        };
        this.A0C = new AbstractC0971Kk() { // from class: com.facebook.ads.redexgen.X.9w
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0975Ko c0975Ko) {
                C07159v.this.A05 = true;
                C07159v.this.A02();
            }
        };
        this.A0I = on;
        this.A07 = c1144Rh;
        this.A0E = str;
        this.A08 = on.A05();
        setGravity(17);
        int i2 = A0L;
        setPadding(i2, 0, i2, i2);
        M5.A0M(this, 0);
        setUpView(this.A08);
        this.A0F = new Paint();
        this.A0F.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.A0F.setStyle(Paint.Style.FILL);
        this.A0F.setAlpha(16);
        this.A0F.setAntiAlias(true);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        if (this.A0I.A0A() != null && this.A02 != null) {
            this.A0I.A0A().A8f(this.A02.getSimpleVideoView());
            if (JD.A1R(getContext())) {
                this.A0I.A0A().A07(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (this.A0I.A0A() != null) {
            this.A0I.A0A().A05();
            if (this.A02 != null) {
                this.A0I.A0A().AF4(this.A02.getSimpleVideoView());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        if (this.A01 == null) {
            return;
        }
        if (!A0i() || !this.A05) {
            boolean A0i = A0i();
            String[] strArr = A0J;
            if (strArr[3].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0J;
            strArr2[3] = "whWH7G9NZGoicUCMK8TGye";
            strArr2[4] = "jQqQ2QRGHP0rmsCqitHuog";
            if (A0i || !this.A04) {
                return;
            }
        }
        this.A01.A9r();
    }

    private void A03(@Nullable View view) {
        RelativeLayout.LayoutParams layoutParams;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    public static void A04(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        M5.A0K(view);
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0B() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0c() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final void A0e() {
        PG pg;
        if (A0i() && (pg = this.A02) != null) {
            pg.A01();
        }
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final void A0f() {
        if (A0i()) {
            A0g();
            PG pg = this.A02;
            if (pg != null) {
                pg.A05(EnumC1094Pj.A03);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final void A0g() {
        PG pg;
        float volume = this.A07.A0P().getVolume();
        if (A0i() && (pg = this.A02) != null && volume != pg.getVolume()) {
            this.A02.setVolume(volume);
        }
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final boolean A0h() {
        PG pg;
        return A0i() && (pg = this.A02) != null && pg.A06();
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final boolean A0i() {
        return this.A03;
    }

    public final void A0j(Map<String, String> map) {
        PG pg = this.A02;
        if (pg != null) {
            pg.A02();
            if (A0i()) {
                this.A02.A04(getAdEventManager(), this.A0E, map);
            }
        }
    }

    @Nullable
    public final PG getVideoView() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.OJ, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.A0G.reset();
        this.A0H.set(0.0f, 0.0f, getWidth(), getHeight());
        int i2 = 0;
        boolean z = getResources().getConfiguration().orientation == 1;
        if (z) {
            i2 = A0K;
        }
        this.A0G.addRoundRect(this.A0H, i2, i2, Path.Direction.CW);
        canvas.drawPath(this.A0G, this.A0F);
        this.A0H.set(A0L, 0.0f, getWidth() - A0L, getHeight() - A0L);
        if (z) {
            i2 = A0M;
        }
        this.A0G.addRoundRect(this.A0H, i2, i2, Path.Direction.CW);
        canvas.clipPath(this.A0G);
        super.onDraw(canvas);
    }

    public void setImageUrl(String str) {
        C1022Mm c1022Mm = this.A00;
        if (c1022Mm != null) {
            c1022Mm.setVisibility(0);
            new AsyncTaskC1164Sb(this.A00, this.A08).A04().A06(new SW(this, null)).A07(str);
        }
        PG pg = this.A02;
        if (pg != null) {
            pg.setVisibility(8);
        }
    }

    public void setIsVideo(boolean z) {
        this.A03 = z;
    }

    public void setOnAssetsLoadedListener(OW ow) {
        this.A01 = ow;
    }

    public void setUpImageView(XT xt) {
        this.A00 = new C1022Mm(xt);
        A04(this.A00);
    }

    public void setUpMediaContainer(XT xt) {
        this.A06 = new RelativeLayout(xt);
        A04(this.A06);
        C1022Mm c1022Mm = this.A00;
        if (c1022Mm != null) {
            this.A06.addView(c1022Mm);
            A03(this.A00);
        }
        PG pg = this.A02;
        if (pg != null) {
            this.A06.addView(pg);
            A03(this.A02);
        }
        addView(this.A06);
    }

    public void setUpVideoView(XT xt) {
        this.A02 = new PG(xt, new C0937Jb(this.A0E, getAdEventManager()));
        A04(this.A02);
    }

    private void setUpView(XT xt) {
        setUpImageView(xt);
        setUpVideoView(xt);
        setUpMediaContainer(xt);
    }

    public void setVideoPlaceholderUrl(String str) {
        PG pg = this.A02;
        if (pg != null) {
            pg.setPlaceholderUrl(str);
        }
    }

    public void setVideoUrl(String str) {
        C1022Mm c1022Mm = this.A00;
        if (c1022Mm != null) {
            if (A0J[5].length() == 10) {
                throw new RuntimeException();
            }
            A0J[2] = "s54OOOYMcUndmM7F";
            c1022Mm.setVisibility(8);
        }
        PG pg = this.A02;
        if (pg != null) {
            pg.setVisibility(0);
            this.A02.setVideoURI(str);
            this.A02.A03(this.A0D);
            this.A02.A03(this.A09);
            this.A02.A03(this.A0B);
            this.A02.A03(this.A0A);
            this.A02.A03(this.A0C);
        }
    }
}
