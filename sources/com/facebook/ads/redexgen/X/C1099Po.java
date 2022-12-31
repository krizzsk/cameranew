package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Po  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1099Po extends RelativeLayout implements QX, InterfaceC1088Pd, QV {
    public static byte[] A0D;
    public static String[] A0E = {"bTF0mPynjITMPKd7AWnGFE0wjuUHqGk", "NLuteA0O4hImypGMVaagZ7KROvpQko", "vHIsSgA1dNPe0TxNLDw8T5r", "Tu3OEd7", "fTm", "FLX2LFKD3Z9kyRG7iyj3Ajj18EKg1", "ES7oyLysdjBWPeOJZDQ9P8Sn", "e8"};
    public static final C1017Mh A0F;
    public static final C0977Kr A0G;
    public static final C0975Ko A0H;
    public static final KR A0I;
    public static final KQ A0J;
    public static final KN A0K;
    public static final KL A0L;
    public static final KK A0M;
    public int A00;
    public C0937Jb A01;
    public C1092Ph A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final Handler A06;
    public final Handler A07;
    public final View.OnTouchListener A08;
    public final XT A09;
    public final C9O<C9P, C9N> A0A;
    public final List<InterfaceC1095Pk> A0B;
    public final QU A0C;

    public static String A0F(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 103);
        }
        return new String(copyOfRange);
    }

    public static void A0I() {
        byte[] bArr = {4, 87, 73, 71, 4, 88, 83, 88, 69, 80, 4, 91, 69, 88, 71, 76, 4, 88, 77, 81, 73, 38, 88, 85, 85, 72, 81, 87, 79, 92, 3, 68, 87, 3};
        if (A0E[6].length() != 24) {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[5] = "dnbQEbQJ0095hjHrUlDt4BBpkj0Wp";
        strArr[7] = "GI";
        A0D = bArr;
    }

    static {
        A0I();
        A0H = new C0975Ko();
        A0F = new C1017Mh();
        A0I = new KR();
        A0J = new KQ();
        A0G = new C0977Kr();
        A0K = new KN();
        A0M = new KK();
        A0L = new KL();
    }

    public C1099Po(XT xt) {
        super(xt);
        this.A0B = new ArrayList();
        this.A06 = new Handler();
        this.A07 = new Handler();
        this.A0A = new C9O<>();
        this.A05 = true;
        this.A00 = 200;
        this.A08 = new View$OnTouchListenerC1086Pb(this);
        this.A09 = xt;
        if (A0S(xt)) {
            this.A0C = new TextureView$SurfaceTextureListenerC0893Hh(xt);
        } else {
            this.A0C = new HZ(xt);
        }
        A0G();
    }

    public C1099Po(XT xt, AttributeSet attributeSet) {
        super(xt, attributeSet);
        this.A0B = new ArrayList();
        this.A06 = new Handler();
        this.A07 = new Handler();
        this.A0A = new C9O<>();
        this.A05 = true;
        this.A00 = 200;
        this.A08 = new View$OnTouchListenerC1086Pb(this);
        this.A09 = xt;
        if (A0S(xt)) {
            this.A0C = new TextureView$SurfaceTextureListenerC0893Hh(xt, attributeSet);
        } else {
            this.A0C = new HZ(xt, attributeSet);
        }
        A0G();
    }

    public C1099Po(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A0B = new ArrayList();
        this.A06 = new Handler();
        this.A07 = new Handler();
        this.A0A = new C9O<>();
        this.A05 = true;
        this.A00 = 200;
        this.A08 = new View$OnTouchListenerC1086Pb(this);
        this.A09 = xt;
        if (A0S(xt)) {
            this.A0C = new TextureView$SurfaceTextureListenerC0893Hh(xt, attributeSet, i2);
        } else {
            this.A0C = new HZ(xt, attributeSet, i2);
        }
        A0G();
    }

    public static /* synthetic */ C0975Ko A0C() {
        C0975Ko c0975Ko = A0H;
        if (A0E[0].length() != 31) {
            throw new RuntimeException();
        }
        A0E[6] = "XnBln0F0zo0j2g49JSScdoR2";
        return c0975Ko;
    }

    private void A0G() {
        this.A09.A0D().A2p();
        this.A0C.setRequestedVolume(1.0f);
        this.A0C.setVideoStateChangeListener(this);
        this.A02 = new C1092Ph(this.A09, this.A0C);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
        setOnTouchListener(this.A08);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H() {
        this.A06.postDelayed(new C1103Ps(this), this.A00);
    }

    private final void A0J() {
        for (InterfaceC1095Pk plugin : this.A0B) {
            if (plugin instanceof AbstractC1020Mk) {
                A0Q((AbstractC1020Mk) plugin);
            }
            plugin.A8f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0K(int i2) {
        if (JD.A0p(this.A09)) {
            XT xt = this.A09;
            Toast.makeText(xt, A0F(21, 13, 124) + (i2 / 1000.0f) + A0F(0, 21, 125), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(EnumC0936Ja enumC0936Ja) {
        C0937Jb c0937Jb = this.A01;
        if (c0937Jb == null) {
            return;
        }
        c0937Jb.A02(enumC0936Ja, null);
    }

    private void A0P(InterfaceC1095Pk interfaceC1095Pk) {
        if (interfaceC1095Pk instanceof AbstractC1020Mk) {
            A0R((AbstractC1020Mk) interfaceC1095Pk);
        }
        interfaceC1095Pk.AF4(this);
    }

    private void A0Q(AbstractC1020Mk abstractC1020Mk) {
        if (abstractC1020Mk.getParent() == null) {
            if (abstractC1020Mk instanceof C06527b) {
                this.A02.A00(abstractC1020Mk);
            } else {
                addView(abstractC1020Mk);
            }
        }
    }

    private void A0R(AbstractC1020Mk abstractC1020Mk) {
        if (abstractC1020Mk instanceof C06527b) {
            this.A02.A01(abstractC1020Mk);
        } else {
            M5.A0J(abstractC1020Mk);
        }
    }

    private boolean A0S(XT xt) {
        return JD.A1y(xt, QJ.A03());
    }

    public final void A0V() {
        this.A0C.setVideoStateChangeListener(null);
        this.A0C.destroy();
    }

    public final void A0W() {
        if (A0i()) {
            return;
        }
        this.A0C.A7l();
    }

    public final void A0X() {
        Iterator<InterfaceC1095Pk> it = this.A0B.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A0E[0].length() != 31) {
                throw new RuntimeException();
            }
            A0E[0] = "GYUlZXdJo7nruMh2UHaMalRUd7rYm0D";
            if (hasNext) {
                InterfaceC1095Pk plugin = it.next();
                A0P(plugin);
            } else {
                this.A0B.clear();
                String[] strArr = A0E;
                if (strArr[4].length() != strArr[3].length()) {
                    String[] strArr2 = A0E;
                    strArr2[4] = "dBG";
                    strArr2[3] = "pEPub8w";
                    return;
                }
                return;
            }
        }
    }

    public final void A0Y(int i2) {
        this.A06.removeCallbacksAndMessages(null);
        this.A0C.seekTo(i2);
    }

    public final void A0Z(int i2) {
        this.A0C.AEr(i2);
    }

    public final void A0a(EnumC1090Pf enumC1090Pf) {
        this.A07.post(new C1100Pp(this));
        this.A0C.AEf(enumC1090Pf.A02());
    }

    public final void A0b(EnumC1094Pj enumC1094Pj, int i2) {
        if (this.A03 && this.A0C.getState() == QW.A06) {
            this.A03 = false;
        }
        this.A0C.AEk(enumC1094Pj, i2);
    }

    public final void A0c(InterfaceC1095Pk interfaceC1095Pk) {
        this.A0B.add(interfaceC1095Pk);
    }

    public final void A0d(InterfaceC1095Pk interfaceC1095Pk) {
        this.A0B.remove(interfaceC1095Pk);
        A0P(interfaceC1095Pk);
    }

    public final void A0e(boolean z, int i2) {
        if (A0i()) {
            return;
        }
        this.A0C.ACn(z, i2);
    }

    public final void A0f(boolean z, boolean z2, int i2) {
        this.A05 = z2;
        A0e(z, i2);
    }

    public final boolean A0g() {
        return this.A0C.A7x();
    }

    public final boolean A0h() {
        return getVolume() == 0.0f;
    }

    public final boolean A0i() {
        return getState() == QW.A05;
    }

    public final boolean A0j() {
        return A0i() && this.A0C.A8T();
    }

    public final boolean A0k() {
        return getState() == QW.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1088Pd
    public final boolean A8L() {
        return A0S(this.A09);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1088Pd
    public final boolean A8O() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.QX
    public final void ABC() {
        A0e(true, 4);
    }

    @Override // com.facebook.ads.redexgen.X.QX
    public final void ABD() {
        A0b(EnumC1094Pj.A05, 6);
    }

    @Override // com.facebook.ads.redexgen.X.QX
    public final void AC1(int i2, int i3) {
        this.A07.post(new C1101Pq(this, i2, i3));
        A0H();
    }

    @Override // com.facebook.ads.redexgen.X.QX
    public final void ACb(QW qw) {
        this.A07.post(new C1102Pr(this, qw, getCurrentPositionInMillis(), getDuration()));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1088Pd
    public int getCurrentPositionInMillis() {
        return this.A0C.getCurrentPosition();
    }

    public int getDuration() {
        return this.A0C.getDuration();
    }

    @NonNull
    public C9O<C9P, C9N> getEventBus() {
        return this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1088Pd
    public long getInitialBufferTime() {
        return this.A0C.getInitialBufferTime();
    }

    public QW getState() {
        return this.A0C.getState();
    }

    public Handler getStateHandler() {
        return this.A07;
    }

    public TextureView getTextureView() {
        return (TextureView) this.A0C;
    }

    public int getVideoHeight() {
        return this.A0C.getVideoHeight();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1088Pd
    public EnumC1094Pj getVideoStartReason() {
        return this.A0C.getStartReason();
    }

    public View getVideoView() {
        return this.A02;
    }

    public int getVideoWidth() {
        return this.A0C.getVideoWidth();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1088Pd
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1088Pd
    public float getVolume() {
        return this.A0C.getVolume();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.A0A.A02(A0L);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.A0A.A02(A0M);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        QU qu = this.A0C;
        if (qu != null) {
            qu.setControlsAnchorView(view);
        }
    }

    public void setFunnelLoggingHandler(C0937Jb c0937Jb) {
        this.A01 = c0937Jb;
    }

    public void setIsFullScreen(boolean z) {
        this.A04 = z;
        this.A0C.setFullScreen(z);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(@Nullable String str) {
        this.A0C.setVideoMPD(str);
    }

    public void setVideoProgressReportIntervalMs(int i2) {
        this.A00 = i2;
    }

    public void setVideoURI(@Nullable Uri uri) {
        if (uri == null) {
            A0X();
        } else {
            A0J();
            this.A0C.setup(uri);
        }
        this.A03 = false;
    }

    public void setVideoURI(@Nullable String str) {
        this.A09.A0D().A2w(str);
        setVideoURI(str != null ? Uri.parse(str) : null);
    }

    public void setVolume(float f2) {
        if (f2 == 1.0f) {
            A0L(EnumC0936Ja.A0d);
            this.A09.A0D().A30();
        } else {
            A0L(EnumC0936Ja.A0c);
            this.A09.A0D().A2z();
        }
        this.A0C.setRequestedVolume(f2);
        C9O<C9P, C9N> eventBus = getEventBus();
        if (A0E[2].length() == 19) {
            throw new RuntimeException();
        }
        A0E[2] = "etD2zaPMct9y2wbR2YehsJmmTem";
        eventBus.A02(A0K);
    }
}
