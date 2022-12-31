package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.VideoAutoplayBehavior;
import com.facebook.ads.VideoStartReason;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5E  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5E implements MediaViewVideoRendererApi {
    public static byte[] A0G;
    public static String[] A0H = {"Ds1OlE9QLNwB", "aoTFD1mdY9qS2iG1b6xBMIzf9BXXSrYm", "osndMvDCAJCV1YpU", "nBivoQhUG9UhcV9idWewaYAmGQw5UcJS", "JB025Vwse6xgHKaH4PdlPsgjNbTaZijW", "Rr8Hg5ZtJOltbAd8rryGswWrdJNm13cq", "EfdUYpEvlCzoAxPYZB8PQhxNy", "DXUiKhR"};
    public static final String A0I;
    public MediaViewVideoRenderer A00;
    public VideoAutoplayBehavior A01;
    public XT A03;
    @Nullable
    public InterfaceC0948Jm A04;
    public AA A05;
    public boolean A06;
    public boolean A07;
    @Nullable
    public NativeAd A08;
    public final AbstractC0971Kk A0D = new C0821Ej(this);
    public final AbstractC0976Kq A0C = new C0813Eb(this);
    public final L3 A0B = new C0812Ea(this);
    public final AbstractC0964Kc A0E = new EZ(this);
    public final AbstractC1018Mi A09 = new EY(this);
    public final KM A0F = new EX(this);
    public final M3 A0A = new E8(this);
    public AnonymousClass57 A02 = new AnonymousClass57();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0G = new byte[]{-30, 7, 15, -6, 5, 2, -3, -71, -17, 2, -2, 16, -71, -4, 8, 7, 12, Draft_75.CR, 11, 14, -4, Draft_75.CR, 8, 11, -71, 9, -6, 11, -6, 6, 12, -71, Draft_75.CR, 18, 9, -2, -57, -34, -16, -16, -10, -12, -7, -14, -85, -8, 0, -2, -1, -85, -19, -16, -85, -5, -3, -16, -18, -16, -17, -16, -17, -85, -19, 4, -85, -20, -85, -18, -20, -9, -9, -85, -1, -6, -85, -16, -7, -14, -20, -14, -16, -34, -16, -16, -10, -73, -85, -20, -7, -17, -85, -15, -6, -9, -9, -6, 2, -16, -17, -85, -19, 4, -85, -20, -85, -18, -20, -9, -9, -85, -1, -6, -85, -17, -12, -2, -16, -7, -14, -20, -14, -16, -34, -16, -16, -10, -71, -27, -22, -12, -26, -17, -24, -30, -24, -26, -44, -26, -26, -20, -95, -28, -30, -19, -19, -26, -27, -95, -8, -22, -11, -23, -16, -10, -11, -95, -26, -17, -24, -30, -24, -26, -44, -26, -26, -20, -81, 74, 83, 76, 70, 76, 74, 56, 74, 74, 80, 5, 72, 70, 81, 81, 74, 73, 5, 92, 78, 89, 77, 84, 90, 89, 5, 73, 78, 88, 74, 83, 76, 70, 76, 74, 56, 74, 74, 80, 19};
    }

    static {
        A02();
        A0I = MediaViewVideoRenderer.class.getSimpleName();
    }

    public final void A03() {
        this.A00.pause(false);
        this.A05.setClientToken(null);
        this.A05.setVideoMPD(null);
        this.A05.setVideoURI((Uri) null);
        this.A05.setVideoCTA(null);
        this.A05.setNativeAd(null);
        this.A01 = VideoAutoplayBehavior.DEFAULT;
        NativeAd nativeAd = this.A08;
        if (nativeAd != null) {
            C1198Tj.A0J(nativeAd.getInternalNativeAd()).A1a(false, false);
        }
        this.A08 = null;
        InterfaceC0948Jm interfaceC0948Jm = this.A04;
        if (interfaceC0948Jm != null) {
            interfaceC0948Jm.AF6();
        }
    }

    public final void A04(NativeAd nativeAd) {
        this.A08 = nativeAd;
        this.A03.A0F(((C1198Tj) nativeAd.getInternalNativeAd()).A10());
        C5F c5f = (C5F) nativeAd.getNativeAdApi();
        this.A05.setClientToken(C1198Tj.A0J(nativeAd.getInternalNativeAd()).A19());
        this.A05.setVideoMPD(c5f.A01());
        this.A05.setVideoURI(c5f.A02());
        C1543cy adapter = C1198Tj.A0J(nativeAd.getInternalNativeAd()).A0x();
        if (adapter != null) {
            this.A05.setVideoProgressReportIntervalMs(adapter.A0F());
        }
        this.A05.setVideoCTA(nativeAd.getAdCallToAction());
        this.A05.setNativeAd(nativeAd);
        this.A01 = c5f.getVideoAutoplayBehavior();
        InterfaceC0948Jm interfaceC0948Jm = this.A04;
        if (interfaceC0948Jm != null) {
            interfaceC0948Jm.AER(nativeAd);
        }
    }

    public final void A05(JT jt) {
        this.A05.setAdEventManager(jt);
    }

    public final void A06(@Nullable InterfaceC0948Jm interfaceC0948Jm) {
        this.A04 = interfaceC0948Jm;
    }

    public final void A07(@Nullable InterfaceC1012Mc interfaceC1012Mc) {
        this.A05.setListener(interfaceC1012Mc);
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void destroy() {
        this.A05.A0V();
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void disengageSeek(VideoStartReason videoStartReason) {
        if (!this.A06) {
            boolean isDebugBuild = AdInternalSettings.isDebugBuild();
            if (A0H[6].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[0] = "WtsbSHtQErqq";
            strArr[2] = "XLMSbaKAMNULMDv3";
            if (isDebugBuild) {
                Log.w(A0I, A01(127, 40, 5));
                return;
            }
            return;
        }
        this.A06 = false;
        if (this.A07) {
            this.A05.A0b(EnumC1094Pj.A00(videoStartReason), 3);
        }
        this.A00.onSeekDisengaged();
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void engageSeek() {
        if (this.A06) {
            if (AdInternalSettings.isDebugBuild()) {
                Log.w(A0I, A01(167, 40, 105));
                return;
            }
            return;
        }
        this.A06 = true;
        this.A07 = QW.A0A.equals(this.A05.getState());
        this.A05.A0e(false, 1);
        this.A00.onSeekEngaged();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this.A02;
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    @IntRange(from = 0)
    public final int getCurrentTimeMs() {
        return this.A05.getCurrentPositionInMillis();
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    @IntRange(from = 0)
    public final int getDuration() {
        return this.A05.getDuration();
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final View getVideoView() {
        return this.A05.getVideoView();
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public final float getVolume() {
        return this.A05.getVolume();
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaViewVideoRenderer mediaViewVideoRenderer) {
        XT A02;
        this.A00 = mediaViewVideoRenderer;
        Context context = adViewConstructorParams.getContext();
        if (context instanceof XT) {
            A02 = (XT) context;
        } else {
            A02 = AnonymousClass59.A02(context);
        }
        this.A03 = A02;
        int initializationType = adViewConstructorParams.getInitializationType();
        if (initializationType == 0) {
            this.A05 = new AA(A02);
        } else if (initializationType == 1) {
            this.A05 = new AA(A02, adViewConstructorParams.getAttributeSet());
        } else if (initializationType == 2) {
            this.A05 = new AA(A02, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr());
        } else if (initializationType == 3) {
            this.A05 = new AA(A02, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleRes());
        } else {
            throw new IllegalArgumentException(A01(0, 37, 29));
        }
        this.A05.setEnableBackgroundVideo(mediaViewVideoRenderer.shouldAllowBackgroundPlayback());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.A05.setLayoutParams(layoutParams);
        this.A02.addView(this.A05, -1, layoutParams);
        Ld.A04(this.A05, Ld.A0A);
        this.A05.getEventBus().A03(this.A0D, this.A0C, this.A0B, this.A0E, this.A09, this.A0F, this.A0A);
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void pause(boolean z) {
        this.A05.A0e(z, 2);
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void play(VideoStartReason videoStartReason) {
        this.A05.A0b(EnumC1094Pj.A00(videoStartReason), 2);
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void seekTo(@IntRange(from = 0) int i2) {
        if (!this.A06) {
            if (AdInternalSettings.isDebugBuild()) {
                Log.w(A0I, A01(37, 90, 15));
                return;
            }
            return;
        }
        this.A05.A0Y(i2);
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final void setVolume(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.A05.setVolume(f2);
    }

    @Override // com.facebook.ads.internal.api.MediaViewVideoRendererApi
    public final boolean shouldAutoplay() {
        AA aa = this.A05;
        if (aa == null || aa.getState() == QW.A06) {
            return false;
        }
        return this.A01 == VideoAutoplayBehavior.ON || this.A01 == VideoAutoplayBehavior.DEFAULT;
    }
}
