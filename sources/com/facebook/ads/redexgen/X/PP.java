package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"ViewConstructor"})
/* loaded from: assets/audience_network.dex */
public final class PP extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"2LrpfYyae0azpeRldXrTpIs5j5WolZYJ", "aTWFoH17M5HvBaS06GyoTMgY8LK09kB1", "ZT9jJV1ne", "vwbwskwEgIVHj6V8wHV", "a8UIfMhCahgZVDol7QIaAFMNjSR7v8Rm", "pauq9xVSe1TSbn6Nh8iDWIypG", "tig0s2h3zWgeN1kA13N6tuAlrnUP1dby", "gu60Pcp0oAdbO9RcUpkXMIBgrMh0CW0V"};
    public static final float A0E;
    public static final RelativeLayout.LayoutParams A0F;
    public int A00;
    public long A01;
    public Map<String, String> A02;
    public final AnonymousClass16 A03;
    public final C1U A04;
    public final XT A05;
    public final JT A06;
    public final InterfaceC1048Nn A07;
    public final C1166Sd A08;
    public final PN A09;
    public final AtomicBoolean A0A;
    public final AtomicBoolean A0B;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] ^ i4;
            if (A0D[5].length() != 25) {
                throw new RuntimeException();
            }
            A0D[4] = "2xsSJQdmJTzWNKbVkLPVv70adF3crTtp";
            copyOfRange[i5] = (byte) (i6 ^ 37);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0C = new byte[]{11, 47, 29, 33, 44, 52, 44, 47, 33, 40, 12, 41, 52, 5, 22, 23, Draft_75.CR, 10, 3, 68, 1, 22, 22, 11, 22, 52, 8, 5, 29, 5, 6, 8, 1, 68, 0, 11, 39, 16, 5, 39, 8, Draft_75.CR, 7, 15, 68, 16, 22, Draft_75.CR, 3, 3, 1, 22, 1, 0, 68, 19, Draft_75.CR, 16, 12, 68, 20, 22, 1, 73, 1, 18, 1, 10, 16, 68, 7, 8, Draft_75.CR, 7, 15, 23, 68, 7, 11, 17, 10, 16, 68, 5, 10, 0, 68, 32, 1, 8, 5, 29, 106, 86, 91, 67, 91, 88, 86, 95, 123, 94, 73, 108, 83, 95, 77, 102, 97, 99, 109, 106, 36, 104, 107, 101, 96, 109, 106, 99, 36, 118, 97, 105, 107, 112, 97, 36, 116, 104, 101, 125, 101, 102, 104, 97, 61, 50, 55, 61, 53, 45, 112, 113, 120, 117, 109, 93, 65, 76, 84, 76, 79, 65, 72, 55, 43, 38, 62, 38, 37, 43, 34, 24, 53, 34, 42, 40, 51, 34, 21, 2, 10, 8, 19, 2, 56, 20, 2, 20, 20, 14, 8, 9, 56, 14, 3, 20, 15, 11, 5, 14, 107, 121, 126, 67, 106, 117, 121, 107};
    }

    static {
        A09();
        A0E = (int) (LY.A00 * 4.0f);
        A0F = new RelativeLayout.LayoutParams(-1, -1);
    }

    public PP(XT xt, AnonymousClass16 anonymousClass16, C1U c1u, JT jt, PN pn, Map<String, String> map) {
        super(xt);
        this.A0A = new AtomicBoolean(false);
        this.A0B = new AtomicBoolean(false);
        this.A01 = -1L;
        this.A00 = 0;
        this.A07 = new AbstractC1169Sg() { // from class: com.facebook.ads.redexgen.X.82
            @Override // com.facebook.ads.redexgen.X.InterfaceC1048Nn
            public final void A9r() {
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1169Sg, com.facebook.ads.redexgen.X.InterfaceC1048Nn
            public final void AAa(int i2, @Nullable String str) {
                AtomicBoolean atomicBoolean;
                PN pn2;
                atomicBoolean = PP.this.A0B;
                atomicBoolean.set(true);
                pn2 = PP.this.A09;
                pn2.AB5();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1169Sg, com.facebook.ads.redexgen.X.InterfaceC1048Nn
            public final void AAk() {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                PN pn2;
                atomicBoolean = PP.this.A0B;
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean2 = PP.this.A0A;
                if (!atomicBoolean2.compareAndSet(false, true)) {
                    return;
                }
                pn2 = PP.this.A09;
                pn2.AAk();
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC1048Nn
            public final void ACd() {
                PN pn2;
                pn2 = PP.this.A09;
                pn2.ACd();
            }
        };
        this.A05 = xt;
        this.A03 = anonymousClass16;
        this.A04 = c1u;
        this.A06 = jt;
        this.A09 = pn;
        this.A02 = map;
        this.A08 = A04();
        if (JD.A1D(this.A05)) {
            this.A05.A09().AFC(this.A08, this.A03.A0Q(), false);
        }
        addView(this.A08, A0F);
    }

    public static /* synthetic */ int A00(PP pp) {
        int i2 = pp.A00;
        pp.A00 = i2 + 1;
        return i2;
    }

    @SuppressLint({"AddJavascriptInterface", "ClickableViewAccessibility"})
    private C1166Sd A04() {
        C1166Sd c1166Sd = new C1166Sd(this.A05, new WeakReference(this.A07), 10, JD.A1J(this.A05));
        c1166Sd.setCornerRadius(A0E);
        c1166Sd.setLogMultipleImpressions(false);
        c1166Sd.setCheckAssetsByJavascriptBridge(false);
        c1166Sd.setWebViewTimeoutInMillis(this.A04.A08());
        c1166Sd.setRequestId(this.A03.A0V());
        c1166Sd.setOnTouchListener(new PO(this));
        WebSettings settings = c1166Sd.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT > 16) {
            c1166Sd.addJavascriptInterface(new PQ(this.A05, this, this.A06, this.A02, this.A03.A0Q()), A06(0, 12, 104));
        }
        return c1166Sd;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b4, code lost:
        if (r3 <= com.facebook.ads.redexgen.X.JD.A0F(r7)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b6, code lost:
        r3 = r9.A09;
        r2 = com.facebook.ads.redexgen.X.PP.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ca, code lost:
        if (r2[0].charAt(14) == r2[7].charAt(14)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00cc, code lost:
        r3.AAE();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00cf, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d0, code lost:
        r2 = com.facebook.ads.redexgen.X.PP.A0D;
        r2[0] = "1qrV4xG42mjJ5wR1PYF4mguO0xYm8sMw";
        r2[7] = "To2gWJFbGkwQ4PRGYAw3BZd3UXo54AHv";
        r3.AAE();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ee, code lost:
        if (r3 <= com.facebook.ads.redexgen.X.JD.A0F(r7)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f1, code lost:
        r9.A05.A06().A8q(r5, com.facebook.ads.redexgen.X.C06808m.A20, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0A() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PP.A0A():void");
    }

    public final void A0B() {
        String A0E2;
        if (this.A04.A0J()) {
            C06818n c06818n = new C06818n(A06(107, 29, 33));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A06(170, 17, 66), this.A04.A0F());
                jSONObject.put(A06(187, 5, 69), this.A03.A0Q());
            } catch (JSONException e2) {
                Log.e(A06(92, 15, 31), A06(12, 13, 65), e2);
            }
            c06818n.A05(jSONObject);
            c06818n.A03(1);
            InterfaceC06798l A06 = this.A05.A06();
            if (A0D[4].charAt(0) == 'P') {
                throw new RuntimeException();
            }
            A0D[1] = "TEDpWyR4sKSlO4xRZxixfnQAFgDgpHMF";
            int i2 = C06808m.A22;
            String A062 = A06(155, 15, 98);
            A06.A8r(A062, i2, c06818n);
            if (JD.A0l(this.A05) && C1006Lw.A00(this.A05) == EnumC1005Lv.A07) {
                this.A05.A06().A8r(A062, C06808m.A21, c06818n);
                this.A07.AAa(0, null);
                return;
            }
        }
        try {
            C1166Sd c1166Sd = this.A08;
            if (!TextUtils.isEmpty(this.A04.A0B())) {
                A0E2 = this.A04.A0B();
            } else {
                A0E2 = this.A04.A0E();
            }
            c1166Sd.loadUrl(A0E2);
        } catch (Exception e3) {
            this.A05.A06().A8q(A06(192, 8, 57), C06808m.A2Q, new C06818n(e3));
        }
    }

    public final void A0C() {
        if (JD.A1D(this.A05)) {
            XT xt = this.A05;
            if (A0D[2].length() == 31) {
                throw new RuntimeException();
            }
            A0D[1] = "2a9geg5CZy9bcTekyOeVTlcxLNQduX9G";
            xt.A09().AF3(this.A08);
        }
        this.A08.removeJavascriptInterface(A06(0, 12, 104));
        if (A0D[3].length() != 23) {
            A0D[6] = "33aduEcFLWt6pdjLdZ5sJJvVvr5WDkst";
            this.A08.destroy();
            return;
        }
        this.A08.destroy();
    }

    public C1009Lz getTouchDataRecorder() {
        return this.A08.getTouchDataRecorder();
    }

    @Nullable
    public QZ getViewabilityChecker() {
        return this.A08.getViewabilityChecker();
    }
}
