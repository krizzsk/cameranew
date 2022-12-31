package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.9m  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC07069m extends SJ {
    public RelativeLayout A00;
    public C1022Mm A01;
    public OW A02;
    public C1144Rh A03;
    public PG A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final Paint A08;
    public final Path A09;
    public final RectF A0A;
    public final XT A0B;
    public final AbstractC1018Mi A0C;
    public final L3 A0D;
    public final AbstractC0976Kq A0E;
    public final AbstractC0971Kk A0F;
    public final KM A0G;
    public final String A0H;
    public static final int A0J = (int) (LY.A00 * 1.0f);
    public static final int A0K = (int) (LY.A00 * 4.0f);
    public static final int A0I = (int) (LY.A00 * 6.0f);

    public abstract void A0j(XT xt);

    public AbstractC07069m(ON on, boolean z, String str, C1144Rh c1144Rh) {
        super(on, z);
        this.A09 = new Path();
        this.A0A = new RectF();
        this.A0G = new KM() { // from class: com.facebook.ads.redexgen.X.9s
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(KN kn) {
                C1144Rh c1144Rh2;
                c1144Rh2 = AbstractC07069m.this.A03;
                c1144Rh2.A0P().setVolume(AbstractC07069m.this.getVideoView().getVolume());
            }
        };
        this.A0C = new AbstractC1018Mi() { // from class: com.facebook.ads.redexgen.X.9r
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06687v c06687v) {
                C1144Rh c1144Rh2;
                c1144Rh2 = AbstractC07069m.this.A03;
                c1144Rh2.A0N().ACO(((Integer) AbstractC07069m.this.getTag(-1593835536)).intValue());
            }
        };
        this.A0E = new AbstractC0976Kq() { // from class: com.facebook.ads.redexgen.X.9q
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0977Kr c0977Kr) {
                C1144Rh c1144Rh2;
                c1144Rh2 = AbstractC07069m.this.A03;
                c1144Rh2.A0O().ACX(AbstractC07069m.this);
            }
        };
        this.A0D = new L3() { // from class: com.facebook.ads.redexgen.X.9p
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C06677u c06677u) {
                C1144Rh c1144Rh2;
                c1144Rh2 = AbstractC07069m.this.A03;
                c1144Rh2.A0O().ACV(AbstractC07069m.this);
            }
        };
        this.A0F = new AbstractC0971Kk() { // from class: com.facebook.ads.redexgen.X.9o
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9P
            /* renamed from: A00 */
            public final void A03(C0975Ko c0975Ko) {
                AbstractC07069m.this.A07 = true;
                AbstractC07069m.this.A01();
            }
        };
        this.A03 = c1144Rh;
        this.A0H = str;
        this.A0B = on.A05();
        setGravity(17);
        int i2 = A0J;
        setPadding(i2, 0, i2, i2);
        M5.A0M(this, 0);
        setUpView(this.A0B);
        this.A08 = new Paint();
        this.A08.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.A08.setStyle(Paint.Style.FILL);
        this.A08.setAlpha(16);
        this.A08.setAntiAlias(true);
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (this.A02 == null) {
            return;
        }
        if ((A0i() && this.A07) || (!A0i() && this.A06)) {
            this.A02.A9r();
        }
    }

    private void A02(View view) {
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        M5.A0K(view);
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public boolean A0B() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0c() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final void A0e() {
        if (A0i()) {
            this.A04.A01();
        }
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final void A0f() {
        if (A0i()) {
            A0g();
            this.A04.A05(EnumC1094Pj.A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final void A0g() {
        float volume = this.A03.A0P().getVolume();
        if (A0i() && volume != this.A04.getVolume()) {
            this.A04.setVolume(volume);
        }
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final boolean A0h() {
        return A0i() && this.A04.A06();
    }

    @Override // com.facebook.ads.redexgen.X.SJ
    public final boolean A0i() {
        return this.A05;
    }

    public final void A0k(Map<String, String> map) {
        this.A04.A02();
        if (A0i()) {
            this.A04.A04(getAdEventManager(), this.A0H, map);
        }
    }

    public final RelativeLayout getMediaContainer() {
        return this.A00;
    }

    public final PG getVideoView() {
        return this.A04;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.A09.reset();
        this.A0A.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.A09;
        RectF rectF = this.A0A;
        int i2 = A0I;
        path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
        canvas.drawPath(this.A09, this.A08);
        this.A0A.set(A0J, 0.0f, getWidth() - A0J, getHeight() - A0J);
        Path path2 = this.A09;
        RectF rectF2 = this.A0A;
        int i3 = A0K;
        path2.addRoundRect(rectF2, i3, i3, Path.Direction.CW);
        canvas.clipPath(this.A09);
        super.onDraw(canvas);
    }

    public void setAdTitleAndDescription(String str, String str2) {
        getTitleDescContainer().A01(str, str2, null, true, false);
    }

    public void setCTAInfo(C1J c1j, Map<String, String> map) {
        getCtaButton().setCta(c1j, this.A0H, map);
    }

    public void setImageUrl(String str) {
        this.A01.setVisibility(0);
        this.A04.setVisibility(8);
        new AsyncTaskC1164Sb(this.A01, this.A0B).A04().A06(new SI(this)).A07(str);
    }

    public void setIsVideo(boolean z) {
        this.A05 = z;
    }

    public void setOnAssetsLoadedListener(OW ow) {
        this.A02 = ow;
    }

    public void setUpImageView(XT xt) {
        this.A01 = new C1022Mm(xt);
        A02(this.A01);
    }

    public void setUpMediaContainer(XT xt) {
        this.A00 = new RelativeLayout(xt);
        A02(this.A00);
    }

    public void setUpVideoView(XT xt) {
        this.A04 = new PG(xt, new C0937Jb(this.A0H, getAdEventManager()));
        A02(this.A04);
    }

    private void setUpView(XT xt) {
        setUpImageView(xt);
        setUpVideoView(xt);
        setUpMediaContainer(xt);
        this.A00.addView(this.A01);
        this.A00.addView(this.A04);
        A0j(xt);
    }

    public void setVideoPlaceholderUrl(String str) {
        this.A04.setPlaceholderUrl(str);
    }

    public void setVideoUrl(String str) {
        this.A01.setVisibility(8);
        this.A04.setVisibility(0);
        this.A04.setVideoURI(str);
        this.A04.A03(this.A0G);
        this.A04.A03(this.A0C);
        this.A04.A03(this.A0E);
        this.A04.A03(this.A0D);
        this.A04.A03(this.A0F);
    }
}
