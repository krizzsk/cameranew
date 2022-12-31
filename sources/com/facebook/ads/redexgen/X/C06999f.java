package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.dynamiclayout.DynamicFullScreenAdView$AdFormatType;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.facebook.ads.redexgen.X.9f  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06999f extends FrameLayout implements MV, S3 {
    public static String[] A0I = {"Ky6zrcoV7NYtZpO3AnBVhERgUe61TP4A", "7", "MIS71VG0t7feKobdqgnq1TwubiJ1N09z", "nEwmQOfqxRkjYDAAu8TY0n89Pulsb82", "nm6mhrtocmSPL4qM7u9wOkkvqXPHcra", "ADTrDSFqqVysA22fSklmKPGMwsWvvDiN", "oNlgPu", "28CTXOUAXLtNi6XFaROwO0buCKC9QIVi"};
    public static final AtomicInteger A0J = new AtomicInteger();
    public AnonymousClass50 A00;
    @Nullable
    public AnonymousClass52 A01;
    @Nullable
    public InterfaceC1082Ox A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final AnonymousClass16 A06;
    public final XT A07;
    public final JT A08;
    public final C0937Jb A09;
    public final View$OnSystemUiVisibilityChangeListenerC1004Lu A0A;
    public final C1009Lz A0B;
    public final MU A0C;
    public final InterfaceC1031Mw A0D;
    @Nullable
    public final C1066Oh A0E;
    public final C1072On A0F;
    @DoNotStrip
    public final QY A0G;
    public final QZ A0H;

    public C06999f(XT xt, JT jt, MU mu, AnonymousClass16 anonymousClass16, InterfaceC1031Mw interfaceC1031Mw, @DynamicFullScreenAdView$AdFormatType int i2) {
        super(xt);
        this.A00 = new SH(this);
        this.A0G = new SG(this);
        this.A03 = true;
        this.A07 = xt;
        this.A08 = jt;
        this.A0C = mu;
        this.A06 = anonymousClass16;
        this.A0D = interfaceC1031Mw;
        C1072On A02 = C1073Oo.A02(anonymousClass16.A0V());
        if (A02 == null) {
            this.A0F = new C1072On(this.A07, anonymousClass16, jt, i2);
            this.A04 = false;
        } else {
            this.A0F = A02;
            this.A04 = true;
        }
        this.A09 = this.A0F.A0L();
        this.A0B = this.A0F.A0M();
        this.A0F.A0X(new SF(this));
        M5.A0G(1003, this.A0F.A0N());
        if (this.A06.A0j()) {
            XT xt2 = this.A07;
            this.A0E = new C1066Oh(xt2, this.A08, this.A06, new C7J(xt2), this.A09, this.A0C, this.A0D, new SE(this));
            this.A0E.A0N();
            this.A0F.A0N().setOnTouchListener(new View$OnTouchListenerC1063Oc(this));
            addView(this.A0E, new FrameLayout.LayoutParams(-1, -1));
        } else {
            this.A0E = null;
        }
        ViewGroup mediaView = getMediaView();
        this.A0H = new QZ(mediaView, 1, new WeakReference(this.A0G), this.A07);
        this.A0H.A0W(this.A06.A0E());
        this.A0H.A0X(this.A06.A0F());
        this.A0F.A0Z(this.A0H);
        this.A0A = new View$OnSystemUiVisibilityChangeListenerC1004Lu(this);
        this.A0A.A05(EnumC1003Lt.A03);
        setBackgroundColor(0);
        if (JD.A1D(xt)) {
            xt.A09().AFE(mediaView, anonymousClass16.A0Q(), false, false, true);
        }
    }

    private void A0B() {
        P5 A0B = new P3(this.A07, this.A06.A0K().A0E(), this.A06.A0N()).A08(this.A06.A0J().A01()).A0B();
        addView(A0B, new FrameLayout.LayoutParams(-1, -1));
        A0B.A04(new SC(this));
    }

    private final void A0C() {
        this.A0F.A0Y(this);
        if (!this.A04) {
            this.A07.A0D().A4u();
            this.A0F.A0e(true);
        } else {
            this.A07.A0D().A4v();
            if (this.A0F.A0f()) {
                AEq();
                XT xt = this.A07;
                if (A0I[6].length() != 6) {
                    throw new RuntimeException();
                }
                A0I[5] = "8j5uXfZ95rl8UwGJAIvPTgfy7qu4v9pG";
                if (JD.A1D(xt)) {
                    this.A07.A09().AAH();
                }
            }
        }
        addView(this.A0F.A0N(), new FrameLayout.LayoutParams(-1, -1));
        this.A0C.A3H(this, new RelativeLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 19 && this.A06.A0k()) {
            this.A0A.A05(EnumC1003Lt.A04);
        }
    }

    private void A0D(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new O1(this.A07, this.A0D.A60(), this.A0H, this.A0B, this.A08, this.A0C).A08(this.A06.A0Q(), str, new HashMap());
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A7n() {
        A0D(this.A06.A0K().A0F().A05());
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A7o(String str) {
        A0D(str);
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A7s() {
        this.A0C.A3q(this.A0D.A5X());
        new PV(this.A07, this.A0D, this.A06.A0W(), this.A0C).A05();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1082Ox
    public final void A7t(String str) {
        InterfaceC1082Ox interfaceC1082Ox = this.A02;
        if (interfaceC1082Ox != null) {
            interfaceC1082Ox.A7t(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A8Z() {
        new Handler(Looper.getMainLooper()).post(new SD(this));
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void A8e(Intent intent, @Nullable Bundle bundle, AnonymousClass52 anonymousClass52) {
        A0J.incrementAndGet();
        anonymousClass52.A0K(this.A00);
        this.A01 = anonymousClass52;
        A0C();
        if (this.A06.A0K().A0O()) {
            A0B();
        } else {
            this.A0F.A0U();
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void AAf() {
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void ABK(boolean z) {
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0R(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABU(boolean z) {
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0S(z);
        }
        if (z) {
            this.A0F.A0Q();
        } else {
            this.A0F.A0T();
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void ABt(boolean z) {
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0T(z);
        }
        boolean z2 = this.A03;
        if (A0I[1].length() == 11) {
            throw new RuntimeException();
        }
        A0I[5] = "5WCDyt3aDRAQqvSthuq2O6x8YHnGvtvN";
        if (z2) {
            this.A03 = false;
        } else if (z) {
            this.A0F.A0P();
        } else {
            this.A0F.A0V();
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void AC4() {
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void ACW(boolean z) {
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0U(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void ACY(boolean z) {
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0V(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void AE6(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void AEq() {
        if (!this.A05) {
            this.A0H.A0U();
            this.A05 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void close() {
        AnonymousClass52 anonymousClass52 = this.A01;
        if (anonymousClass52 == null) {
            return;
        }
        anonymousClass52.finish(4);
    }

    public static int getAttachedDynamicAdViews() {
        return A0J.get();
    }

    private ViewGroup getMediaView() {
        C1066Oh c1066Oh = this.A0E;
        return c1066Oh != null ? c1066Oh : this.A0F.A0N();
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void onDestroy() {
        if (JD.A1D(this.A07)) {
            this.A07.A09().AF3(getMediaView());
        }
        C1066Oh c1066Oh = this.A0E;
        if (c1066Oh != null) {
            c1066Oh.A0O();
        }
        this.A0A.A03();
        this.A08.A8n(this.A06.A0Q(), new C1055Nu().A02(this.A0B).A03(this.A0H).A05());
        this.A00 = null;
        this.A02 = null;
        this.A01 = null;
        C1073Oo.A03(this.A06.A0V());
        A0J.decrementAndGet();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(MU mu) {
    }

    public void setRtfActionsJavascriptListener(InterfaceC1082Ox interfaceC1082Ox) {
        this.A02 = interfaceC1082Ox;
    }
}
