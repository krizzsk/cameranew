package com.facebook.ads.redexgen.X;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
/* renamed from: com.facebook.ads.redexgen.X.7b  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06527b extends AbstractC1020Mk {
    public static String[] A04 = {"t7nWMgaAgPrF08nCpsue0KJ0bXYxildh", "6KdtKMmtzfHYFwbGu3Z1Ir1zVfPvm0mZ", "4a3tRJ2Sc2HJRD7iGLBoGFg5dIAFXATk", "UpueiF5Mlf4qFrRwKkN0oaj1wZcm2sVE", "2I2trXzlQyfCpDc0SWIB9I9l1xDqUCt2", "pVCp6f81Bxfp7pGgyLuO3QWY2ZOI1Rz7", "JWrnXr9CYPwxDsxVPLOhiB9OxQPOAEin", "O346HS8RGmqKBjl58VTWQBGWIRLrpgc9"};
    public final ImageView A00;
    public final XT A01;
    public final C9P<C06687v> A02;
    public final C9P<C0977Kr> A03;

    public C06527b(XT xt) {
        super(xt);
        this.A03 = new C0913Ib(this);
        this.A02 = new C0912Ia(this);
        this.A01 = xt;
        this.A00 = new ImageView(xt);
        this.A00.setScaleType(ImageView.ScaleType.FIT_CENTER);
        M5.A0M(this.A00, ViewCompat.MEASURED_STATE_MASK);
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A03, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1020Mk
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A03);
        }
        super.A08();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.A00.layout(0, 0, i4 - i2, i5 - i3);
    }

    public void setImage(@Nullable String str) {
        setImage(str, null);
    }

    public void setImage(@Nullable String str, @Nullable InterfaceC1054Nt interfaceC1054Nt) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        AsyncTaskC1164Sb A042 = new AsyncTaskC1164Sb(this.A00, this.A01).A04();
        if (interfaceC1054Nt != null) {
            A042.A06(interfaceC1054Nt);
        }
        A042.A07(str);
        String[] strArr = A04;
        if (strArr[0].charAt(21) == strArr[6].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "kA5c9xFlh2VnhKEqDnwhhyQ6vC8xp51l";
        strArr2[6] = "v6NK46wFN1tyoiPUrV3jpTAezqYTXUDI";
    }
}
