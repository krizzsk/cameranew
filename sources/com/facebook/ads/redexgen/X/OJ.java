package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public abstract class OJ extends RelativeLayout {
    public static final int A08 = (int) (LY.A00 * 16.0f);
    public static final int A09 = (int) (LY.A00 * 28.0f);
    public C1I A00;
    public boolean A01;
    public boolean A02;
    public final XT A03;
    public final JT A04;
    public final SZ A05;
    public final OG A06;
    public final ON A07;

    public abstract boolean A0c();

    public OJ(ON on, boolean z) {
        super(on.A05());
        C1I A00;
        this.A01 = false;
        this.A07 = on;
        this.A03 = on.A05();
        this.A04 = on.A06();
        if (on.A00() == 1) {
            A00 = on.A04().A0J().A01();
        } else {
            A00 = on.A04().A0J().A00();
        }
        this.A00 = A00;
        this.A02 = z;
        this.A05 = new SZ(on.A05(), on.A04().A0P(), this.A00, on.A04().A0K().A0F().A06(), on.A06(), on.A09(), on.A0B(), on.A07());
        this.A05.setRoundedCornersEnabled(A00());
        this.A05.setViewShowsOverMedia(A0B());
        M5.A0G(1001, this.A05);
        this.A06 = new OG(this.A03, this.A00, this.A02, A01(), A02());
        M5.A0K(this.A06);
    }

    public boolean A00() {
        return true;
    }

    public boolean A01() {
        return true;
    }

    public boolean A02() {
        return true;
    }

    public void A09(C06687v c06687v) {
        this.A01 = true;
    }

    public void A0A(C06667t c06667t) {
    }

    public boolean A0B() {
        return true;
    }

    public void A0W() {
    }

    public void A0X() {
    }

    public void A0Y() {
    }

    public void A0Z() {
    }

    public void A0a() {
    }

    public void A0b(AnonymousClass19 anonymousClass19, String str, double d2, @Nullable Bundle bundle) {
        this.A06.A01(anonymousClass19.A0E().A05(), anonymousClass19.A0E().A01(), null, false, !A0c() && d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d2 < 1.0d);
        this.A05.setCta(anonymousClass19.A0F(), str, new HashMap());
    }

    public boolean A0d(boolean z) {
        return false;
    }

    public XT getAdContextWrapper() {
        return this.A03;
    }

    public JT getAdEventManager() {
        return this.A04;
    }

    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    public C1I getColors() {
        return this.A00;
    }

    public SZ getCtaButton() {
        return this.A05;
    }

    public OG getTitleDescContainer() {
        return this.A06;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C1I A00;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            A00 = this.A07.A04().A0J().A01();
        } else {
            A00 = this.A07.A04().A0J().A00();
        }
        this.A00 = A00;
        this.A05.setViewShowsOverMedia(A0B());
        this.A05.setUpButtonColors(this.A00);
        this.A06.A00(this.A00, this.A02);
    }
}
