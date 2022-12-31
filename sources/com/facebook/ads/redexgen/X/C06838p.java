package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.8p  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06838p extends AbstractC1158Rv {
    @Nullable
    public OJ A00;
    public final ImageView A01;
    public final AnonymousClass50 A02;
    public final AtomicBoolean A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;

    public C06838p(XT xt, InterfaceC1031Mw interfaceC1031Mw, JT jt, AnonymousClass16 anonymousClass16, C7J c7j, MU mu) {
        super(xt, interfaceC1031Mw, jt, anonymousClass16, c7j, mu);
        this.A02 = new C1157Ru(this);
        this.A04 = new AtomicBoolean(false);
        this.A03 = new AtomicBoolean(false);
        this.A05 = new AtomicBoolean(false);
        this.A01 = new ImageView(getContext());
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setAdjustViewBounds(true);
        new AsyncTaskC1164Sb(this.A01, super.A03).A05(super.A01.A0K().A0D().A00(), super.A01.A0K().A0D().A01()).A06(new C1156Rt(this)).A07(super.A01.A0K().A0D().A07());
    }

    private OJ A01(int i2) {
        if (this.A01.getParent() != null) {
            M5.A0J(this.A01);
        }
        return OK.A00(new OM(super.A03, super.A04, this.A08, super.A01, this.A01, this.A0A, this.A06).A0E(this.A07.getToolbarHeight()).A0H(this.A07).A0D(i2).A0J(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A04.get() && this.A03.get()) {
            A0P();
        }
    }

    private void A06(int i2) {
        M5.A0J(this.A00);
        this.A00 = A01(i2);
        C1I colors = this.A00.getColors();
        OJ oj = this.A00;
        boolean z = true;
        M5.A0M(this, colors.A07(oj != null && (oj.A0c() || (this.A00 instanceof SU))));
        this.A07.A04(colors, this.A00.A0c());
        addView(this.A00, 0, AbstractC1158Rv.A0D);
        OJ oj2 = this.A00;
        setUpFullscreenMode((oj2 == null || !oj2.A0c()) ? false : false);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv
    public final void A0Q() {
        M5.A0L(this.A00);
        M5.A0L(this.A07);
        this.A03.set(true);
        A05();
        int A03 = super.A01.A0K().A0D().A03();
        if (A03 > 0) {
            OJ oj = this.A00;
            if (oj != null) {
                oj.A0a();
            }
            A0R(A03, new C1155Rs(this));
            return;
        }
        this.A05.set(true);
        this.A07.setToolbarActionMode(getCloseButtonStyle());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv
    public final void A0S(AnonymousClass52 anonymousClass52) {
        anonymousClass52.A0K(this.A02);
        A06(anonymousClass52.A0H().getResources().getConfiguration().orientation);
        addView(this.A07, new FrameLayout.LayoutParams(-1, this.A07.getToolbarHeight()));
        M5.A0H(this.A00);
        M5.A0H(this.A07);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv
    public final boolean A0T() {
        OJ oj = this.A00;
        return oj != null && oj.A0d(false);
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        OJ oj = this.A00;
        if (oj != null) {
            return oj.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A01.A0K().A0M()) {
            A06(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1158Rv, com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        if (JD.A1D(super.A03)) {
            super.A03.A09().AF3(this.A01);
        }
        OJ oj = this.A00;
        if (oj != null) {
            oj.A0W();
        }
        super.onDestroy();
    }
}
