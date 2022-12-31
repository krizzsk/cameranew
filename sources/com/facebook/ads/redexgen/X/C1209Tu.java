package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Tu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1209Tu extends AnonymousClass57 implements DefaultMediaViewVideoRendererApi {
    public static byte[] A0F;
    public static String[] A0G = {"mcYgxpLQMmIwsDd5yEmcOVEUvqtoI", "GHoJM0N9xHnxy27wJlEicj6316JJBG", "sAgmez8xlBVRjdgohc9cPNZKpCHjl", "UXd4O0RMEZeMz8rPKuZc9Jx8", "lkMSGOb1N9f2znZPpxO7v43dGPgWn", "ZJq7h5cFUWj9FCmvTSQNl6xA6rnC8", "yifDfgH7QVrqMR4w0vNHSMY9h4Ewh", "QZpfE8IVFABXRQwraZ"};
    public static final String A0H;
    public MediaViewVideoRenderer A00;
    public XT A01;
    @Nullable
    public InterfaceC0946Jk A02;
    @Nullable
    public AA A04;
    public C06527b A05;
    public C7T A06;
    @DoNotStrip
    public QY A07;
    public QZ A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final InterfaceC1091Pg A0C = new U0(this);
    public final AtomicBoolean A0D = new AtomicBoolean(false);
    public final AtomicBoolean A0E = new AtomicBoolean(false);
    public EnumC0958Jw A03 = EnumC0958Jw.A03;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 127);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        A0F = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, 60, 43, 32, 42, 43, 60, 43, 60, 110, 45, 38, 39, 34, 42, 110, 45, 33, 32, 40, 39, 41, 96, 14, 38, 39, 42, 34, 21, 42, 38, 52, 21, 42, 39, 38, 44, 99, 42, 48, 99, 45, 54, 47, 47, 120, 99, 54, 45, 34, 33, 47, 38, 99, 55, 44, 99, 37, 42, 45, 39, 99, 42, 55, 109, 16, 43, 36, 39, 41, 32, 101, 49, 42, 101, 35, 44, 43, 33, 101, 8, 32, 33, 44, 36, 19, 44, 32, 50, 19, 44, 33, 32, 42, 101, 38, 45, 44, 41, 33, 107};
    }

    static {
        A0E();
        A0H = C1209Tu.class.getSimpleName();
    }

    private InterfaceC0948Jm A01(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new C1214Tz(this, mediaViewVideoRendererApi);
    }

    private InterfaceC0948Jm A02(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new C1213Ty(this, mediaViewVideoRendererApi);
    }

    private QY A04() {
        return new C1211Tw(this);
    }

    private QZ A05() {
        return new QZ(this.A00, 50, true, new WeakReference(this.A07), this.A01);
    }

    private void A09() {
        AA aa = this.A04;
        if (aa != null) {
            C1092Ph c1092Ph = (C1092Ph) aa.getVideoView();
            if (A0G[3].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[2] = "uL1T6UePNJ7Kw1irCYcqiA1GlgiEZ";
            strArr[0] = "2BZHbySyGqLzqR4K5b7TQMpiAd64K";
            c1092Ph.setViewImplInflationListener(this.A0C);
        }
    }

    private void A0A() {
        AA aa = this.A04;
        if (aa != null) {
            aa.getVideoView().setOnTouchListener(new View$OnTouchListenerC0945Jj(this));
        }
    }

    private void A0B() {
        AA aa = this.A04;
        if (aa != null) {
            C1092Ph c1092Ph = (C1092Ph) aa.getVideoView();
            String[] strArr = A0G;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0G[7] = "MUEPyY1MJMWvhU3XHu";
            c1092Ph.setViewImplInflationListener(null);
        }
    }

    private void A0C() {
        if (this.A00.getVisibility() == 0 && this.A09) {
            MediaViewVideoRenderer mediaViewVideoRenderer = this.A00;
            String[] strArr = A0G;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[4] = "vtumVYeB8x7vkBeCNzRl37Vgwgf5m";
            strArr2[1] = "l5c2Nb35iHyego1JNAmcVzJY15xyfp";
            if (mediaViewVideoRenderer.hasWindowFocus()) {
                this.A08.A0U();
                return;
            }
        }
        AA aa = this.A04;
        if (aa != null && aa.getState() == QW.A05) {
            this.A0B = true;
        }
        this.A08.A0V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A03 = EnumC0958Jw.A03;
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(C1198Tj c1198Tj, @Nullable InterfaceC0946Jk interfaceC0946Jk) {
        String str;
        this.A0A = false;
        this.A0B = false;
        this.A02 = interfaceC0946Jk;
        A09();
        C06527b c06527b = this.A05;
        if (c1198Tj != null) {
            C0953Jr adCoverImage = c1198Tj.getAdCoverImage();
            String[] strArr = A0G;
            if (strArr[2].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A0G[3] = "zpp3cHPhluFOPvL30kkcY8af";
            if (adCoverImage != null) {
                str = c1198Tj.getAdCoverImage().getUrl();
                c06527b.setImage(str, new C1212Tx(this));
                this.A03 = c1198Tj.A16();
                this.A06.setPlayAccessibilityLabel(c1198Tj.A1C());
                this.A06.setPauseAccessibilityLabel(c1198Tj.A1B());
                this.A08.A0U();
            }
        }
        str = null;
        c06527b.setImage(str, new C1212Tx(this));
        this.A03 = c1198Tj.A16();
        this.A06.setPlayAccessibilityLabel(c1198Tj.A1C());
        this.A06.setPauseAccessibilityLabel(c1198Tj.A1B());
        this.A08.A0U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0J(EnumC1094Pj enumC1094Pj) {
        AA aa = this.A04;
        if (aa != null) {
            aa.A0b(enumC1094Pj, 24);
        } else if (!AdInternalSettings.isDebugBuild()) {
        } else {
            Log.e(A0H, A06(30, 42, 60));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0K() {
        AA aa = this.A04;
        if (aa == null || aa.getState() == QW.A06) {
            return false;
        }
        return this.A03 == EnumC0958Jw.A05 || this.A03 == EnumC0958Jw.A03;
    }

    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void initialize(Context context, MediaViewVideoRenderer mediaViewVideoRenderer, MediaViewVideoRendererApi mediaViewVideoRendererApi, int i2) {
        InterfaceC0948Jm A02;
        ((AnonymousClass57) mediaViewVideoRendererApi.getAdComponentViewApi()).A00(this);
        if (i2 == 0) {
            A02 = A02(mediaViewVideoRendererApi);
        } else if (i2 == 1) {
            A02 = A01(mediaViewVideoRendererApi);
        } else {
            throw new IllegalArgumentException(A06(0, 30, 49));
        }
        ((C5E) mediaViewVideoRendererApi).A06(A02);
        this.A01 = AnonymousClass59.A02(context);
        this.A00 = mediaViewVideoRenderer;
        this.A05 = new C06527b(this.A01);
        this.A07 = A04();
        this.A08 = A05();
        float f2 = LY.A00;
        int i3 = (int) (2.0f * f2);
        int i4 = (int) (25.0f * f2);
        this.A06 = new C7T(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        this.A06.setPadding(i3, i4, i4, i3);
        this.A06.setLayoutParams(layoutParams);
        int i5 = 0;
        while (true) {
            int childCount = this.A00.getChildCount();
            if (A0G[3].length() == 24) {
                String[] strArr = A0G;
                strArr[2] = "oEzbzrDqpY4LpZuK9aeaZZijHYv0V";
                strArr[0] = "65U2aK7TrzSKlLOXQMMYyslcv3rZK";
                if (i5 >= childCount) {
                    break;
                }
                View childAt = this.A00.getChildAt(0);
                if (childAt instanceof AA) {
                    this.A04 = (AA) childAt;
                    break;
                }
                i5++;
            } else {
                throw new RuntimeException();
            }
        }
        AA aa = this.A04;
        if (aa == null) {
            if (AdInternalSettings.isDebugBuild()) {
                Log.e(A0H, A06(72, 36, 58));
            }
        } else {
            aa.A0c(this.A05);
            this.A04.A0c(this.A06);
        }
        this.A08.A0W(0);
        this.A08.A0X(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        A02.AEO();
        String[] strArr2 = A0G;
        if (strArr2[4].length() != strArr2[1].length()) {
            String[] strArr3 = A0G;
            strArr3[4] = "NjD77g9sbns6FUonJskLzorZMVzfs";
            strArr3[1] = "sF6jyMJNRDvSJleY8k7g51skJQqlgl";
            return;
        }
        String[] strArr4 = A0G;
        strArr4[2] = "irNdkufru0tgAA9z3l7YlJhRv0dZK";
        strArr4[0] = "zN5wNlZvELtjdUjcESL7VUEU7ru13";
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A09 = true;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A09 = false;
        A0C();
    }

    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void onPrepared() {
        this.A00.setOnTouchListener(new View$OnTouchListenerC0944Ji(this));
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentView
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        A0C();
    }
}
