package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Arrays;
import java.util.UUID;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: assets/audience_network.dex */
public final class AA extends C1099Po {
    public static byte[] A0E;
    public static final String A0F;
    @Nullable
    public Uri A00;
    @Nullable
    public NativeAd A01;
    public JT A02;
    @Nullable
    public InterfaceC1012Mc A03;
    @Nullable
    public C7x A04;
    @Nullable
    public String A05;
    @Nullable
    public String A06;
    @Nullable
    public String A07;
    public final AnonymousClass14 A08;
    public final XT A09;
    public final AbstractC1018Mi A0A;
    public final L3 A0B;
    public final AbstractC0976Kq A0C;
    public final String A0D;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0E = new byte[]{122, -104, -91, 94, -85, 87, -86, -85, -104, -87, -85, 87, 120, -84, -101, -96, -100, -91, -102, -100, -123, -100, -85, -82, -90, -87, -94, 120, -102, -85, -96, -83, -96, -85, -80, 101, 87, -124, -104, -94, -100, 87, -86, -84, -87, -100, 87, -85, -97, -104, -85, 87, -96, -85, 94, -86, 87, -96, -91, 87, -80, -90, -84, -87, 87, 120, -91, -101, -87, -90, -96, -101, -124, -104, -91, -96, -99, -100, -86, -85, 101, -81, -92, -93, 87, -99, -96, -93, -100, 101, -77, -32, -32, -35, -32, -88, -114, 109, 105, 104, -100, -117, -112, -116, -107, -118, -116, 117, -116, -101, -98, -106, -103, -110, 113, -103, -105, -104, 68, -105, -119, -104, 103, -112, -115, -119, -110, -104, 120, -109, -113, -119, -110, 68, -118, -115, -106, -105, -104, 113, -103, -105, -104, 68, -105, -119, -104, 122, -115, -120, -119, -109, 121, 118, 109, 68, -109, -106, 68, -105, -119, -104, 122, -115, -120, -119, -109, 113, 116, 104, 68, -118, -115, -106, -105, -104, -16, -3, -18, -16, -14, 3, -8, 5, -8, 3, 8, -80, -71, -74, -78, -69, -63, -95, -68, -72, -78, -69, -7, -22, -5, -4, -14, -9, -16, -107, -105, -118, -119, -118, -117, -114, -109, -118, -119, 116, -105, -114, -118, -109, -103, -122, -103, -114, -108, -109, 112, -118, -98, -48, -55, -60, -52, -48, -64, -92, -65, -39, -41, -55, -78, -59, -40, -51, -38, -55, -89, -40, -59, -90, -39, -40, -40, -45, -46, -41, -54, -59, -58, -48, -83, -48, -56, -56, -58, -45, -22, -35, -40, -39, -29, -63, -60, -72, -120, 123, 118, 119, -127, 101, 119, 119, 125, 102, 123, Byte.MAX_VALUE, 119, -40, -53, -58, -57, -47, -73, -76, -82, -3, -16, -21, -20, -10, -26, -5, -16, -12, -20, -26, -9, -10, -13, -13, -16, -11, -18, -26, -16, -11, -5, -20, -7, -3, -24, -13, -87, -100, -104, -86, -121, -84, -93, -104};
    }

    static {
        A03();
        A0F = AA.class.getSimpleName();
    }

    public AA(XT xt) {
        super(xt);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new AY(this);
        this.A0B = new AW(this);
        this.A0A = new AV(this);
        this.A08 = new AnonymousClass14(this, xt);
        this.A09 = xt;
        A02();
    }

    public AA(XT xt, AttributeSet attributeSet) {
        super(xt, attributeSet);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new AY(this);
        this.A0B = new AW(this);
        this.A0A = new AV(this);
        this.A08 = new AnonymousClass14(this, xt);
        this.A09 = xt;
        A02();
    }

    public AA(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A0D = UUID.randomUUID().toString();
        this.A0C = new AY(this);
        this.A0B = new AW(this);
        this.A0A = new AV(this);
        this.A08 = new AnonymousClass14(this, xt);
        this.A09 = xt;
        A02();
    }

    private void A02() {
        getEventBus().A03(this.A0C, this.A0B, this.A0A);
    }

    private void A04(Intent intent) {
        if (this.A04 == null) {
            A05(A01(114, 25, 19));
        } else if (this.A00 == null && this.A07 == null) {
            A05(A01(139, 37, 19));
        } else {
            intent.putExtra(A01(237, 18, 83), this.A06);
            intent.putExtra(A01(322, 8, 34), EnumC0965Kd.A05);
            intent.putExtra(A01(287, 8, 81), this.A00.toString());
            String str = this.A05;
            if (str == null) {
                str = A01(0, 0, 39);
            }
            intent.putExtra(A01(187, 11, 60), str);
            intent.putExtra(A01(266, 8, 99), this.A07);
            intent.putExtra(A01(205, 24, 20), 13);
            intent.putExtra(A01(274, 13, 1), getCurrentPositionInMillis());
            intent.putExtra(A01(229, 8, 74), this.A0D);
            intent.putExtra(A01(255, 11, 80), this.A04.A0V());
            intent.putExtra(A01(295, 27, 118), getVideoProgressReportIntervalMs());
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        }
    }

    private void A05(String str) {
        InterfaceC06798l A06 = this.A09.A06();
        int i2 = C06808m.A1v;
        String defaultErrorMessage = AdErrorType.PARSER_FAILURE.getDefaultErrorMessage();
        A06.A8q(A01(198, 7, 120), i2, new C06818n(defaultErrorMessage, A01(90, 7, 93) + str));
        if (AdInternalSettings.isDebugBuild()) {
            Log.w(A0F, str);
        }
    }

    public final void A0l() {
        NativeAd nativeAd = this.A01;
        if (nativeAd != null) {
            nativeAd.onCtaBroadcast();
        }
    }

    public final void A0m() {
        AdActivityIntent A04 = L9.A04(this.A09);
        A04(A04);
        try {
            A0e(false, 6);
            setVisibility(8);
            L9.A09(this.A09, A04);
        } catch (Exception e2) {
            this.A09.A06().A8q(A01(176, 11, 126), C06808m.A05, new C06818n(e2));
            Log.e(A01(97, 17, 22), A01(0, 90, 38), e2);
        }
    }

    @Nullable
    public InterfaceC1012Mc getListener() {
        return this.A03;
    }

    public String getUniqueId() {
        return this.A0D;
    }

    @Override // com.facebook.ads.redexgen.X.C1099Po, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A08.A02();
    }

    @Override // com.facebook.ads.redexgen.X.C1099Po, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.A08.A03();
        super.onDetachedFromWindow();
    }

    public void setAdEventManager(JT jt) {
        this.A02 = jt;
    }

    public void setClientToken(@Nullable String str) {
        C7x c7x;
        C7x c7x2 = this.A04;
        if (c7x2 != null) {
            c7x2.A0g();
        }
        this.A05 = str;
        if (str != null) {
            c7x = new C7x(this.A09, this.A02, this, str);
        } else {
            c7x = null;
        }
        this.A04 = c7x;
    }

    public void setEnableBackgroundVideo(boolean z) {
        super.A0C.setBackgroundPlaybackEnabled(z);
    }

    public void setListener(@Nullable InterfaceC1012Mc interfaceC1012Mc) {
        this.A03 = interfaceC1012Mc;
    }

    public void setNativeAd(@Nullable NativeAd nativeAd) {
        this.A01 = nativeAd;
    }

    public void setVideoCTA(@Nullable String str) {
        this.A06 = str;
    }

    @Override // com.facebook.ads.redexgen.X.C1099Po
    public void setVideoMPD(@Nullable String str) {
        if (str != null && this.A04 == null) {
            A05(A01(114, 25, 19));
            return;
        }
        this.A07 = str;
        super.setVideoMPD(str);
    }

    @Override // com.facebook.ads.redexgen.X.C1099Po
    public void setVideoURI(@Nullable Uri uri) {
        if (uri != null && this.A04 == null) {
            A05(A01(114, 25, 19));
            return;
        }
        this.A00 = uri;
        super.setVideoURI(uri);
    }
}
