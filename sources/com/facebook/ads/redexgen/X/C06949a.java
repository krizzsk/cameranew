package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.ads.internal.view.dynamiclayout.DynamicInlineAdView$AdFormatType;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
@SuppressLint({"ViewConstructor"})
/* renamed from: com.facebook.ads.redexgen.X.9a  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06949a extends FrameLayout implements S3 {
    public static final AtomicInteger A0A = new AtomicInteger();
    public boolean A00;
    public final AnonymousClass16 A01;
    public final XT A02;
    public final JT A03;
    @DoNotStrip
    public final C0937Jb A04;
    public final C1009Lz A05;
    public final C1072On A06;
    @DoNotStrip
    public final QY A07;
    public final QZ A08;
    public final String A09;

    public C06949a(XT xt, JT jt, AnonymousClass16 anonymousClass16, String str, @DynamicInlineAdView$AdFormatType int i2) {
        super(xt);
        this.A07 = new SB(this);
        this.A02 = xt;
        this.A03 = jt;
        this.A01 = anonymousClass16;
        this.A09 = str;
        C1073Oo.A02(anonymousClass16.A0V());
        this.A06 = new C1072On(this.A02, anonymousClass16, jt, i2);
        this.A04 = this.A06.A0L();
        this.A05 = this.A06.A0M();
        this.A06.A0X(new SA(this));
        M5.A0G(1003, this.A06.A0N());
        this.A08 = new QZ(this.A06.A0N(), 1, new WeakReference(this.A07), this.A02);
        this.A08.A0W(this.A01.A0E());
        this.A08.A0X(this.A01.A0F());
        this.A06.A0Z(this.A08);
        A02();
    }

    private final void A01() {
        this.A06.A0Y(this);
        this.A02.A0D().A4u();
        this.A06.A0e(false);
        addView(this.A06.A0N(), new FrameLayout.LayoutParams(-1, -1));
    }

    private final void A02() {
        A0A.incrementAndGet();
        A01();
        this.A06.A0U();
    }

    private void A03(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new O1(this.A02, this.A09, this.A08, this.A05, this.A03).A08(this.A01.A0Q(), str, new HashMap());
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A7n() {
        A03(this.A01.A0K().A0F().A05());
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A7o(String str) {
        A03(str);
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A7s() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1082Ox
    public final void A7t(String str) {
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void A8Z() {
        new Handler(Looper.getMainLooper()).post(new S9(this));
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void AAf() {
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void ABK(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void AC4() {
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void ACW(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void ACY(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void AEq() {
        if (!this.A00) {
            this.A08.A0U();
            this.A00 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.S3
    public final void close() {
    }

    public static int getAttachedDynamicAdViews() {
        return A0A.get();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }
}
