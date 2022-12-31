package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.DefaultMediaViewVideoRenderer;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.b8  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1438b8 extends AnonymousClass57 implements MediaViewApi, Repairable, C8H {
    public static byte[] A0D;
    public static String[] A0E = {"5egxRyJvv3hsImr6xVPVZGZzS", "S92E58UIdGCmPOb4LYA51SRur0tU5vPU", "gB2LJBWgacco1yi3dwEv6yCRJyLib4yq", "IRYDxixZynQ1VjnPzR0JfxvjieAE", "Yx6PPUM30uHFy3rHO75LIsUaVykI", "YSQgGTlHzzB", "fqdcFq1cD4m6uZ0nLvDLKOa7nCA9CaYH", "MqJIv4BM2hfR6AMSoGkEEGT8SPZgcE8o"};
    public static final String A0F;
    public View A00;
    public View A01;
    public ImageView A02;
    public MediaView A03;
    @Nullable
    public MediaViewListener A04;
    public MediaViewVideoRenderer A05;
    public AdComponentViewParentApi A06;
    public XT A07;
    public AnonymousClass18 A08;
    public C1052Nr A09;
    @Nullable
    public PM A0A;
    public boolean A0B;
    public boolean A0C;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 47);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0D = new byte[]{56, 26, 9, 20, 14, 8, 30, 23, 91, 9, 30, 21, 31, 30, 9, 30, 9, 91, 22, 14, 8, 15, 91, 25, 30, 91, 8, 30, 15, 91, 25, 30, 29, 20, 9, 30, 91, 21, 26, 15, 18, Draft_75.CR, 30, 58, 31, 85, 26, 30, 29, 41, 56, 53, 57, 50, 63, 57, 18, 57, 40, 43, 51, 46, 55, 64, 100, 104, 110, 108, 41, 123, 108, 103, 109, 108, 123, 108, 123, 41, 100, 124, 122, 125, 41, 107, 108, 41, 122, 108, 125, 41, 107, 108, 111, 102, 123, 108, 41, 103, 104, 125, 96, Byte.MAX_VALUE, 108, 72, 109, 39, 96, 68, 72, 78, 76, 9, 91, 76, 71, 77, 76, 91, 76, 91, 9, 68, 92, 90, 93, 9, 75, 76, 9, 90, 76, 93, 9, 75, 76, 79, 70, 91, 76, 9, 71, 72, 93, 64, 95, 76, 107, 72, 71, 71, 76, 91, 104, 77, 7, 18, 53, 45, 58, 55, 50, 63, 123, Draft_75.CR, 50, 62, 44, 123, 56, 52, 53, 40, 47, 41, 46, 56, 47, 52, 41, 123, 43, 58, 41, 58, 54, 40, 123, 47, 34, 43, 62, 117, 1, 46, 59, 38, 57, 42, 111, 14, 43, 111, 6, 44, 32, 33, 111, 38, 60, 111, 33, 58, 35, 35, 97, 11, 52, 57, 56, 50, 125, 47, 56, 51, 57, 56, 47, 56, 47, 125, 48, 40, 46, 41, 125, 63, 56, 125, 46, 56, 41, 125, 63, 56, 59, 50, 47, 56, 125, 51, 60, 41, 52, 43, 56, 28, 57, 115, 26, 11, 18, 117, 106, 103, 102, 108, 86, 113, 111, 62};
    }

    static {
        A05();
        A0F = MediaView.class.getSimpleName();
    }

    private void A03() {
        if (!this.A0C) {
            View view = this.A01;
            String[] strArr = A0E;
            if (strArr[4].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[5] = "HiqmuX4YAHl";
            strArr2[0] = "JtgDxExoVYEb5OmxUIRsQ7gjV";
            if (view != null) {
                M5.A0J(this.A08);
            }
            float f2 = LY.A00;
            int round = Math.round(4.0f * f2);
            int round2 = Math.round(12.0f * f2);
            this.A08.setChildSpacing(round);
            this.A08.setPadding(0, round2, 0, round2);
            this.A08.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A01 = this.A08;
            this.A03.addView(this.A01, layoutParams);
            return;
        }
        throw new IllegalStateException(A02(0, 46, 84));
    }

    private void A04() {
        Ld.A04(this.A03, Ld.A0A);
        Ld.A04(this.A09, Ld.A0A);
        Ld.A04(this.A05, Ld.A0A);
        Ld.A04(this.A01, Ld.A0A);
    }

    private final void A06(View view, ViewGroup.LayoutParams layoutParams) {
        A01(false);
        this.A03.addView(view, layoutParams);
        A01(true);
    }

    private void A07(View view, C1198Tj c1198Tj) {
        PM pm = this.A0A;
        if (pm != null) {
            MediaView mediaView = this.A03;
            String[] strArr = A0E;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[6] = "tYahJlzELN2bWoIKGOvNb4V2q4om3tal";
            strArr2[2] = "knO8IZUpKtredd0Q2IkvjJrJQGpJW1Qq";
            mediaView.removeView(pm);
        }
        if (!c1198Tj.A1b()) {
            return;
        }
        String A1A = c1198Tj.A1A();
        Context context = this.A03.getContext();
        String[] strArr3 = A0E;
        if (strArr3[5].length() != strArr3[0].length()) {
            String[] strArr4 = A0E;
            strArr4[4] = "LedcnhOkj71a4gNr9a9uwwPVwkpS";
            strArr4[3] = "bOPNktfa058vxRDYU7HJ2aiUk3a2";
            if (context == null) {
                return;
            }
        } else if (context == null) {
            return;
        }
        PM A01 = PL.A01(this.A07, A1A);
        if (A0E[7].charAt(21) != 'L') {
            A0E[1] = "IBU68ioTGuVBWJ1dkmCJ7UK76Osi7EVF";
            this.A0A = A01;
            if (this.A0A == null) {
                return;
            }
        } else {
            this.A0A = A01;
            if (this.A0A == null) {
                return;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(5, view.getId());
        layoutParams.addRule(7, view.getId());
        layoutParams.addRule(6, view.getId());
        layoutParams.addRule(8, view.getId());
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.addRule(16, view.getId());
            layoutParams.addRule(17, view.getId());
        }
        A06(this.A0A, layoutParams);
        this.A06.bringChildToFront(this.A0A);
    }

    private void A08(ImageView imageView) {
        if (!this.A0C) {
            ImageView imageView2 = this.A02;
            String[] strArr = A0E;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[6] = "9onWrVOda1qlu0pAvyXYf5LKITz29A5r";
            strArr2[2] = "G6pev0JETY7bhqmEZOziJsmCoQM1bBBX";
            if (imageView2 != null) {
                M5.A0J(imageView2);
            }
            imageView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A03.addView(imageView, layoutParams);
            imageView.setId(M5.A00());
            this.A02 = imageView;
            return;
        }
        throw new IllegalStateException(A02(106, 49, 6));
    }

    @TargetApi(21)
    private final void A09(XT xt, AttributeSet attributeSet, int i2, int i3, MediaView mediaView) {
        this.A03 = mediaView;
        A08(new ImageView(xt, attributeSet, i2, i3));
        A0E(new C1052Nr(xt, attributeSet, i2, i3));
        this.A08 = new AnonymousClass18(xt, attributeSet, i2);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(xt, attributeSet, i2, i3));
        A04();
    }

    private final void A0A(XT xt, AttributeSet attributeSet, int i2, MediaView mediaView) {
        this.A03 = mediaView;
        A08(new ImageView(xt, attributeSet, i2));
        A0E(new C1052Nr(xt, attributeSet, i2));
        this.A08 = new AnonymousClass18(xt, attributeSet, i2);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(xt, attributeSet, i2));
        A04();
    }

    private final void A0B(XT xt, AttributeSet attributeSet, MediaView mediaView) {
        this.A03 = mediaView;
        A08(new ImageView(xt, attributeSet));
        A0E(new C1052Nr(xt, attributeSet));
        this.A08 = new AnonymousClass18(xt, attributeSet);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(xt, attributeSet));
        A04();
    }

    private final void A0C(XT xt, MediaView mediaView) {
        this.A03 = mediaView;
        A08(new ImageView(xt));
        A0E(new C1052Nr(xt));
        this.A08 = new AnonymousClass18(xt);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(xt));
        A04();
    }

    private void A0D(C1198Tj c1198Tj, boolean z, C0953Jr c0953Jr) {
        AsyncTaskC1164Sb A04 = new AsyncTaskC1164Sb(this.A02, this.A07).A04();
        if (z) {
            A04.A06(new C1443bD(this, c1198Tj));
        }
        A04.A07(c0953Jr.getUrl());
    }

    private void A0E(C1052Nr c1052Nr) {
        if (!this.A0C) {
            C1052Nr c1052Nr2 = this.A09;
            if (c1052Nr2 != null) {
                this.A03.removeView(c1052Nr2);
            }
            c1052Nr.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A03.addView(c1052Nr, layoutParams);
            this.A09 = c1052Nr;
            return;
        }
        throw new IllegalStateException(A02(63, 43, 38));
    }

    private boolean A0F(NativeAd nativeAd) {
        List<NativeAd> A03 = ((C5F) nativeAd.getNativeAdApi()).A03();
        if (A03 == null) {
            return false;
        }
        for (NativeAd childNativeAd : A03) {
            if (childNativeAd.getAdCoverImage() == null) {
                return false;
            }
        }
        return true;
    }

    private boolean A0G(NativeAd nativeAd) {
        return Build.VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(((C5F) nativeAd.getNativeAdApi()).A02());
    }

    public final void A0H(NativeAd nativeAd) {
        AbstractC1530cl f9;
        XT A10 = ((C1198Tj) nativeAd.getInternalNativeAd()).A10();
        A10.A0G(this);
        this.A07.A0F(A10);
        this.A07.A0E(A10.A0D());
        this.A0C = true;
        C1198Tj A0J = C1198Tj.A0J(nativeAd.getInternalNativeAd());
        A0J.A1P(this.A03);
        this.A02.setVisibility(8);
        this.A02.setImageDrawable(null);
        if (!A0F(nativeAd)) {
            if (A0G(nativeAd)) {
                A0J.A10().A0D().AEX(EnumC04740c.A09);
                A0J.A1Z(this.A0B);
                this.A00 = this.A05.getMediaViewVideoRendererApi().getVideoView();
                this.A09.setVisibility(8);
                this.A09.setImage(null, null);
                View view = this.A01;
                if (view != null) {
                    view.setVisibility(8);
                    View view2 = this.A01;
                    if (view2 instanceof C1043Ni) {
                        ((C1043Ni) view2).A04();
                    } else {
                        C0828Eq c0828Eq = (C0828Eq) view2;
                        String[] strArr = A0E;
                        if (strArr[5].length() != strArr[0].length()) {
                            String[] strArr2 = A0E;
                            strArr2[6] = "aOStoZQ6HlGjIfWvjowDgm0JyWXySbfC";
                            strArr2[2] = "db16XoSedMN3NVp1QVj7WgZqidqfP4Wc";
                            c0828Eq.setAdapter(null);
                        } else {
                            c0828Eq.setAdapter(null);
                        }
                    }
                }
                bringChildToFront(this.A05);
                this.A05.setNativeAd(nativeAd);
                ((C5E) this.A05.getMediaViewVideoRendererApi()).A04(nativeAd);
                this.A05.setVisibility(0);
                if (A0J.getAdCoverImage() != null) {
                    new AsyncTaskC1164Sb(this.A03, this.A07).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C1441bB(this, A0J)).A07(A0J.getAdCoverImage().getUrl());
                }
                if (BuildConfigApi.isDebug()) {
                    String str = A0F;
                    Log.i(str, A02(261, 9, 44) + ((C5F) nativeAd.getNativeAdApi()).A02());
                }
                A07(this.A05, A0J);
                return;
            } else if (nativeAd.getAdCoverImage() == null) {
                return;
            } else {
                A0J.A10().A0D().AEX(EnumC04740c.A07);
                this.A00 = this.A09.getBodyImageView();
                this.A05.setVisibility(8);
                this.A05.unsetNativeAd();
                ((C5E) this.A05.getMediaViewVideoRendererApi()).A03();
                View view3 = this.A01;
                if (view3 != null) {
                    view3.setVisibility(8);
                    View view4 = this.A01;
                    if (view4 instanceof C1043Ni) {
                        ((C1043Ni) view4).A04();
                    } else {
                        ((C0828Eq) view4).setAdapter(null);
                    }
                }
                bringChildToFront(this.A09);
                this.A09.setVisibility(0);
                new AsyncTaskC1164Sb(this.A09, this.A07).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C1440bA(this, A0J)).A07(A0J.getAdCoverImage().getUrl());
                A07(this.A09, A0J);
                return;
            }
        }
        A0J.A10().A0D().AEX(EnumC04740c.A03);
        EnumC0956Ju A15 = A0J.A15();
        if (A0E[7].charAt(21) == 'L') {
            throw new RuntimeException();
        }
        String[] strArr3 = A0E;
        strArr3[4] = "CvXrj9TTP1W52m7bIbynzmDbx8Ql";
        strArr3[3] = "OGerX4RrBYJpkLXwbXTHIjvyoHPN";
        boolean z = A15 == EnumC0956Ju.A0B;
        boolean enableTextInNativeCarousel = JD.A1t(this.A07);
        if (enableTextInNativeCarousel && !z) {
            A01(false);
            int width = this.A03.getWidth();
            ViewGroup viewGroup = (ViewGroup) this.A03.getParent();
            while (width == 0 && viewGroup != null) {
                width = viewGroup.getWidth();
                ViewParent parent = viewGroup.getParent();
                String[] strArr4 = A0E;
                String str2 = strArr4[4];
                String str3 = strArr4[3];
                int length = str2.length();
                int width2 = str3.length();
                if (length != width2) {
                    String[] strArr5 = A0E;
                    strArr5[4] = "ZQRbya12lyykx5Eq2uFJ3JGH4lXR";
                    strArr5[3] = "SLHysRpGcYp4QaXPRJ4K4uNDdgkD";
                    viewGroup = (ViewGroup) parent;
                } else {
                    String[] strArr6 = A0E;
                    strArr6[6] = "txzvXhatra49UDlp2BXEovPdWlOkx37e";
                    strArr6[2] = "zmD0GPDFfrMRBXxeFyYC2vHynCiCjpaN";
                    viewGroup = (ViewGroup) parent;
                }
            }
            M5.A0J(this.A01);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A01 = new C1043Ni(this.A07);
            this.A03.addView(this.A01, layoutParams);
            ((C1043Ni) this.A01).A05(A0J, width);
            M5.A0K(this.A01);
            A01(true);
        } else {
            this.A01 = this.A08;
            ((AnonymousClass18) this.A01).setCurrentPosition(0);
            ((AnonymousClass18) this.A01).setShowTextInCarousel(z);
            if (z) {
                f9 = new FA(this.A07, (AnonymousClass18) this.A01, A0J.A1G(), A0J.A14());
            } else {
                f9 = new F9((AnonymousClass18) this.A01, A0J.A1G(), this.A07);
            }
            f9.A0G(new C1442bC(this, A0J));
            ((C0828Eq) this.A01).setAdapter(f9);
        }
        View view5 = this.A01;
        String[] strArr7 = A0E;
        if (strArr7[4].length() != strArr7[3].length()) {
            throw new RuntimeException();
        }
        A0E[1] = "92EI1RENbPFosgt8QuPbmuyLYPUfPd8U";
        this.A00 = view5;
        this.A09.setVisibility(8);
        this.A09.setImage(null, null);
        this.A05.setVisibility(8);
        this.A05.unsetNativeAd();
        ((C5E) this.A05.getMediaViewVideoRendererApi()).A03();
        bringChildToFront(this.A01);
        this.A01.setVisibility(0);
        A07(this.A01, A0J);
    }

    public final void A0I(NativeAdBaseApi nativeAdBaseApi, boolean z) {
        XT A10 = ((C1198Tj) nativeAdBaseApi).A10();
        this.A07.A0F(A10);
        A10.A0G(this);
        this.A0C = true;
        C1198Tj A0J = C1198Tj.A0J(nativeAdBaseApi);
        A0J.A1O(this.A03);
        this.A09.setVisibility(8);
        this.A09.setImage(null, null);
        this.A05.setVisibility(8);
        this.A05.unsetNativeAd();
        ((C5E) this.A05.getMediaViewVideoRendererApi()).A03();
        View view = this.A01;
        if (view != null) {
            view.setVisibility(8);
            View view2 = this.A01;
            if (view2 instanceof C1043Ni) {
                ((C1043Ni) view2).A04();
            } else {
                ((C0828Eq) view2).setAdapter(null);
            }
        }
        this.A02.setVisibility(0);
        bringChildToFront(this.A02);
        this.A00 = this.A02;
        C0953Jr adIcon = A0J.getAdIcon();
        if (adIcon != null) {
            Bitmap A0K = A0J.A0z().A0K(adIcon.getUrl());
            if (A0K != null) {
                this.A02.setImageBitmap(A0K);
                if (z) {
                    this.A03.post(new C1444bE(this, A0J));
                }
            } else {
                A0D(A0J, z, adIcon);
            }
        } else {
            InterfaceC1197Ti A13 = A0J.A13();
            AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
            A10.A0D().A2a(A0J.A0w(), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            if (A13 != null) {
                A13.AAW(K3.A00(adErrorType));
            }
            Log.e(A02(46, 17, 115), adErrorType.getDefaultErrorMessage());
            if (nativeAdBaseApi.isAdLoaded()) {
                this.A07.A06().A8q(A02(258, 3, 84), C06808m.A0O, new C06818n(A02(192, 23, 96)));
            }
        }
        A07(this.A02, A0J);
    }

    public final boolean A0J() {
        View view = this.A01;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.facebook.ads.redexgen.X.C8H
    public final XT A5Y() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void bringChildToFront(View view) {
        if (view == this.A01 || view == this.A05 || view == this.A09 || view == this.A02) {
            this.A06.bringChildToFront(view);
            PM pm = this.A0A;
            if (pm != null) {
                this.A06.bringChildToFront(pm);
            }
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void destroy() {
        this.A05.pause(false);
        this.A05.getMediaViewVideoRendererApi().destroy();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final View getAdContentsView() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaHeight() {
        if (this.A09.getVisibility() == 0) {
            return this.A09.getImageHeight();
        }
        if (this.A05.getVisibility() == 0) {
            return this.A05.getMediaViewVideoRendererApi().getVideoView().getHeight();
        }
        if (this.A03.getVisibility() == 0) {
            return this.A03.getHeight();
        }
        if (A0E[1].charAt(24) != 't') {
            A0E[7] = "3C5Zne3gt6SFfa7y1AnuQltffgpI3Oh8";
            return 0;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaWidth() {
        if (this.A09.getVisibility() == 0) {
            return this.A09.getImageWidth();
        }
        if (this.A05.getVisibility() == 0) {
            return this.A05.getMediaViewVideoRendererApi().getVideoView().getWidth();
        }
        if (this.A03.getVisibility() == 0) {
            return this.A03.getWidth();
        }
        String[] strArr = A0E;
        if (strArr[6].charAt(12) != strArr[2].charAt(12)) {
            String[] strArr2 = A0E;
            strArr2[5] = "pFreRfYdfw1";
            strArr2[0] = "pVUprXCJsnglf8IlGtX2XFBaJ";
            return 0;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaView mediaView) {
        Context context = adViewConstructorParams.getContext();
        if (context instanceof XT) {
            this.A07 = (XT) context;
        } else {
            this.A07 = AnonymousClass59.A02(context);
        }
        this.A07.A0G(this);
        int initializationType = adViewConstructorParams.getInitializationType();
        if (initializationType == 0) {
            A0C(this.A07, mediaView);
        } else if (initializationType == 1) {
            A0B(this.A07, adViewConstructorParams.getAttributeSet(), mediaView);
        } else if (initializationType == 2) {
            A0A(this.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), mediaView);
        } else if (initializationType == 3) {
            A09(this.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), adViewConstructorParams.getDefStyleRes(), mediaView);
        } else {
            throw new IllegalArgumentException(A02(155, 37, 116));
        }
        A01(true);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentViewApi
    public final void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        super.onAttachedToView(adComponentView, adComponentViewParentApi);
        this.A06 = adComponentViewParentApi;
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        int width = this.A03.getWidth();
        int height = this.A03.getHeight();
        if (width > 0 && height > 0) {
            this.A03.repair(th);
            this.A03.getLayoutParams().width = width;
            MediaView mediaView = this.A03;
            if (A0E[1].charAt(24) == 't') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[5] = "Mgb6bOJjyiN";
            strArr[0] = "MTEeDXbdwkPsq4eW7ABfM3WBi";
            mediaView.getLayoutParams().height = height;
            this.A03.setBackgroundColor(-3355444);
            return;
        }
        this.A03.repair(th);
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setListener(MediaViewListener mediaViewListener) {
        this.A04 = mediaViewListener;
        if (mediaViewListener == null) {
            ((C5E) this.A05.getMediaViewVideoRendererApi()).A07(null);
        } else {
            ((C5E) this.A05.getMediaViewVideoRendererApi()).A07(new C1439b9(this, mediaViewListener));
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        if (!this.A0C) {
            MediaViewVideoRenderer mediaViewVideoRenderer2 = this.A05;
            if (A0E[7].charAt(21) == 'L') {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[6] = "ifAS5bhxfK6Gg4eu5Yemnhg9EBEfp9jT";
            strArr[2] = "R5YDbsM1msNnvJcIFydw3DY2O0brJ9d9";
            if (mediaViewVideoRenderer2 != null) {
                this.A03.removeView(mediaViewVideoRenderer2);
                this.A05.getMediaViewVideoRendererApi().destroy();
            }
            ((C5E) mediaViewVideoRenderer.getMediaViewVideoRendererApi()).A05(this.A07.A08());
            mediaViewVideoRenderer.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((C1438b8) this.A03.getMediaViewApi()).A06(mediaViewVideoRenderer, layoutParams);
            this.A05 = mediaViewVideoRenderer;
            this.A0B = !(this.A05 instanceof DefaultMediaViewVideoRenderer);
            mediaViewVideoRenderer.setId(M5.A00());
            return;
        }
        throw new IllegalStateException(A02(215, 43, 114));
    }
}
