package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
/* renamed from: com.facebook.ads.redexgen.X.Rv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1158Rv extends FrameLayout implements MV {
    public static final RelativeLayout.LayoutParams A0D = new RelativeLayout.LayoutParams(-1, -1);
    public boolean A00;
    public final AnonymousClass16 A01;
    public final C7J A02;
    public final XT A03;
    public final JT A04;
    public final C0937Jb A05;
    public final C1009Lz A06;
    public final MT A07;
    public final MU A08;
    public final InterfaceC1031Mw A09;
    public final QZ A0A;
    public final View$OnSystemUiVisibilityChangeListenerC1004Lu A0B;
    @DoNotStrip
    public final QY A0C;

    public abstract void A0Q();

    public abstract void A0S(AnonymousClass52 anonymousClass52);

    public abstract boolean A0T();

    public AbstractC1158Rv(XT xt, InterfaceC1031Mw interfaceC1031Mw, JT jt, AnonymousClass16 anonymousClass16, C7J c7j, MU mu) {
        super(xt);
        this.A0C = new C1162Rz(this);
        this.A06 = new C1009Lz();
        this.A00 = false;
        this.A03 = xt;
        this.A09 = interfaceC1031Mw;
        this.A04 = jt;
        this.A01 = anonymousClass16;
        this.A02 = c7j;
        this.A08 = mu;
        this.A05 = new C0937Jb(this.A01.A0Q(), this.A04);
        this.A0A = new QZ(this, 1, new WeakReference(this.A0C), this.A03);
        this.A0A.A0W(this.A01.A0E());
        this.A0A.A0X(this.A01.A0F());
        this.A07 = A0N();
        this.A0B = new View$OnSystemUiVisibilityChangeListenerC1004Lu(this);
        this.A0B.A05(EnumC1003Lt.A03);
    }

    private MT A0N() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A03, this.A08, this.A05, 1, this.A01.A0D());
        int A03 = this.A01.A0K().A0D().A03();
        fullScreenAdToolbar.setPageDetails(this.A01.A0N(), this.A01.A0Q(), A03, this.A01.A0O());
        fullScreenAdToolbar.A04(this.A01.A0J().A01(), true);
        if (A03 < 0 && this.A01.A0K().A0L()) {
            fullScreenAdToolbar.setToolbarActionMode(4);
        }
        fullScreenAdToolbar.setToolbarListener(new C1159Rw(this));
        return fullScreenAdToolbar;
    }

    private void A0O() {
        if (this.A01.A0K().A0O()) {
            P5 A0B = new P3(this.A03, this.A01.A0K().A0E(), this.A01.A0N()).A08(this.A01.A0J().A01()).A0B();
            C0939Jd.A04(A0B, this.A05, EnumC0936Ja.A0U);
            addView(A0B, A0D);
            A0B.A04(new C1160Rx(this));
            return;
        }
        A0Q();
    }

    public final void A0P() {
        if (!this.A00) {
            this.A0A.A0U();
            this.A00 = true;
        }
    }

    public final void A0R(int i2, AbstractRunnableC0981Kv abstractRunnableC0981Kv) {
        new LS(i2, new C1161Ry(this, i2, abstractRunnableC0981Kv)).A07();
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void A8e(Intent intent, @Nullable Bundle bundle, AnonymousClass52 anonymousClass52) {
        this.A08.A3H(this, A0D);
        A0S(anonymousClass52);
        A0O();
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final void AE6(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.MV
    public final boolean onActivityResult(int i2, int i3, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        this.A0B.A03();
        if (!TextUtils.isEmpty(this.A01.A0Q())) {
            this.A04.A8n(this.A01.A0Q(), new C1055Nu().A03(this.A0A).A02(this.A06).A05());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A06.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(MU mu) {
    }

    public void setUpFullscreenMode(boolean z) {
        EnumC1003Lt enumC1003Lt;
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (z) {
            enumC1003Lt = EnumC1003Lt.A04;
        } else {
            enumC1003Lt = EnumC1003Lt.A03;
        }
        this.A0B.A05(enumC1003Lt);
    }
}
