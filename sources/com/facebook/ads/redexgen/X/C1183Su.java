package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Su  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1183Su implements MV {
    public static byte[] A0B;
    public int A00;
    public C7x A01;
    public final XT A02;
    public final JT A03;
    public final MU A04;
    public final InterfaceC1026Mr A05;
    public final C1099Po A06;
    public final AbstractC0976Kq A0A = new A7(this);
    public final L3 A09 = new A5(this);
    public final AbstractC1018Mi A07 = new A4(this);
    public final M3 A08 = new A2(this);

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 38);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0B = new byte[]{-49, -29, -30, -35, -34, -38, -49, -25, -17, -8, -11, -15, -6, 0, -32, -5, -9, -15, -6, -68, -70, -84, -107, -88, -69, -80, -67, -84, -118, -69, -88, -119, -68, -69, -69, -74, -75, -73, -86, -91, -90, -80, -118, -81, -75, -90, -77, -76, -75, -86, -75, -94, -83, -122, -73, -90, -81, -75, -99, -112, -117, -116, -106, 115, -106, -114, -114, -116, -103, -2, -15, -20, -19, -9, -43, -40, -52, 24, 11, 6, 7, 17, -11, 7, 7, Draft_75.CR, -10, 11, 15, 7, -66, -79, -84, -83, -73, -99, -102, -108};
    }

    public C1183Su(XT xt, InterfaceC1026Mr interfaceC1026Mr, JT jt, MU mu) {
        this.A02 = xt;
        this.A03 = jt;
        this.A05 = interfaceC1026Mr;
        this.A06 = new C1099Po(xt);
        this.A06.A0c(new C06587j(xt));
        this.A06.getEventBus().A03(this.A0A, this.A09, this.A07, this.A08);
        this.A04 = mu;
        this.A06.setIsFullScreen(true);
        this.A06.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        mu.A3H(this.A06, layoutParams);
        MX mx = new MX(xt);
        mx.setOnClickListener(new View$OnClickListenerC1024Mp(this));
        mu.A3H(mx, mx.getDefaultLayoutParams());
    }

    public final void A04(int i2) {
        this.A06.setVideoProgressReportIntervalMs(i2);
    }

    public final void A05(View view) {
        this.A06.setControlsAnchorView(view);
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void A8e(Intent intent, Bundle bundle, AnonymousClass52 anonymousClass52) {
        String stringExtra = intent.getStringExtra(A02(19, 18, 33));
        if (stringExtra != null && !stringExtra.isEmpty()) {
            PC pc = new PC(this.A02, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i2 = (int) (16.0f * LY.A00);
            layoutParams.setMargins(i2, i2, i2, i2);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            pc.setOnClickListener(new View$OnClickListenerC1025Mq(this));
            this.A04.A3H(pc, layoutParams);
        }
        this.A00 = intent.getIntExtra(A02(77, 13, 124), 0);
        this.A01 = new C7x(this.A02, this.A03, this.A06, intent.getStringExtra(A02(8, 11, 102)), intent.getBundleExtra(A02(58, 11, 1)));
        this.A06.setVideoMPD(intent.getStringExtra(A02(69, 8, 98)));
        this.A06.setVideoURI(intent.getStringExtra(A02(90, 8, 34)));
        int i3 = this.A00;
        if (i3 > 0) {
            this.A06.A0Y(i3);
        }
        if (intent.getBooleanExtra(A02(0, 8, 72), false)) {
            this.A06.A0b(EnumC1094Pj.A05, 17);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
        this.A04.A3r(A02(37, 21, 27), new M0());
        this.A06.A0W();
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
        this.A04.A3r(A02(37, 21, 27), new LQ());
        if (!this.A06.A0j()) {
            this.A06.A0b(EnumC1094Pj.A05, 18);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void AE6(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        this.A04.A3r(A02(37, 21, 27), new C0966Ke(this.A00, this.A06.getCurrentPositionInMillis()));
        this.A01.A0d(this.A06.getCurrentPositionInMillis());
        this.A06.A0Z(1);
        this.A06.A0V();
    }
}
