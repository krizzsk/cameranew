package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.EnumSet;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* renamed from: com.facebook.ads.redexgen.X.cB  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1496cB implements InterfaceC05191w {
    public static byte[] A0A;
    public static final String A0B;
    @Nullable
    public AnonymousClass16 A01;
    @Nullable
    public F7 A02;
    @Nullable
    public C1453bN A03;
    public boolean A05;
    public boolean A06;
    public final XT A07;
    public final InterstitialAdExtendedListener A08;
    public final C05201x A09;
    public long A00 = -1;
    public C1009Lz A04 = new C1009Lz();

    public static String A07(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) + IMediaPlayer.MEDIA_ERROR_TIMED_OUT);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0A = new byte[]{-59, -14, -92, -27, -24, -92, -16, -13, -27, -24, -92, -19, -9, -92, -27, -16, -10, -23, -27, -24, -3, -92, -19, -14, -92, -12, -10, -13, -21, -10, -23, -9, -9, -78, -92, -35, -13, -7, -92, -9, -20, -13, -7, -16, -24, -92, -5, -27, -19, -8, -92, -22, -13, -10, -92, -27, -24, -48, -13, -27, -24, -23, -24, -84, -83, -92, -8, -13, -92, -26, -23, -92, -25, -27, -16, -16, -23, -24, -4, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -45, 31, 34, 20, 23, -45, 22, 20, 31, 31, 24, 23, -45, 42, 27, 28, 31, 24, -45, 38, 27, 34, 42, 28, 33, 26, -45, 28, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -31, Draft_75.CR, 28, 21};
    }

    static {
        A08();
        A0B = C1496cB.class.getSimpleName();
    }

    public C1496cB(C05201x c05201x, AnonymousClass24 anonymousClass24, String str) {
        this.A09 = c05201x;
        this.A07 = c05201x.A05();
        this.A08 = new C1490c2(str, anonymousClass24, this);
    }

    public final long A0B() {
        F7 f7 = this.A02;
        if (f7 != null) {
            return f7.A0B();
        }
        return -1L;
    }

    public final void A0C() {
        F7 f7 = this.A02;
        if (f7 != null) {
            f7.A0M(new cC(this));
            this.A02.A0R(true);
            this.A02 = null;
            this.A06 = false;
            this.A05 = false;
        }
    }

    public final void A0D() {
        C1453bN c1453bN = this.A03;
        if (c1453bN != null) {
            c1453bN.A02();
        }
    }

    public final void A0E(AdCompanionView adCompanionView) {
        AnonymousClass16 anonymousClass16;
        this.A03 = (C1453bN) adCompanionView.getAdCompanionViewApi();
        XT xt = this.A07;
        if (xt != null && (anonymousClass16 = this.A01) != null) {
            this.A03.A03(xt, anonymousClass16);
        }
    }

    public final void A0F(@Nullable EnumSet<CacheFlag> enumSet, @Nullable String str) {
        this.A00 = System.currentTimeMillis();
        if (!this.A06 && this.A02 != null) {
            Log.w(A0B, A07(0, 78, 22));
        }
        this.A06 = false;
        if (this.A05 && !JD.A0f(this.A07)) {
            this.A07.A06().A8q(A07(130, 3, 62), C06808m.A0D, new C06818n(A07(78, 52, 69)));
            AdErrorType adErrorType = AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD;
            this.A07.A0D().A2a(C1008Ly.A01(this.A00), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            this.A08.onError(this.A09.A01(), new AdError(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage()));
            return;
        }
        F7 f7 = this.A02;
        if (f7 != null) {
            f7.A0M(new C1499cF(this));
            this.A02.A0H();
            this.A02 = null;
        }
        C05111o c05111o = new C05111o(this.A09.A09(), KB.A00(this.A07.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, K8.A07, 1, enumSet);
        c05111o.A05(this.A09.A07());
        c05111o.A06(this.A09.A08());
        c05111o.A03(this.A09.A03());
        this.A02 = new F7(this.A07, c05111o);
        this.A02.A0M(new C1497cD(this));
        this.A02.A0P(str);
    }

    public final boolean A0G() {
        F7 f7 = this.A02;
        return f7 == null || f7.A0S();
    }

    public final boolean A0H() {
        return this.A06;
    }

    public final boolean A0I() {
        AdError adError = AdError.SHOW_CALLED_BEFORE_LOAD_ERROR;
        if (!this.A06) {
            this.A07.A0D().A2a(C1008Ly.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A08.onError(this.A09.A01(), adError);
            return false;
        }
        F7 f7 = this.A02;
        if (f7 == null) {
            this.A07.A06().A8q(A07(130, 3, 62), C06808m.A0K, new C06818n(AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL.getDefaultErrorMessage()));
            this.A07.A0D().A2a(C1008Ly.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A08.onError(this.A09.A01(), adError);
            return false;
        }
        f7.A0G();
        this.A05 = true;
        this.A06 = false;
        return true;
    }
}
