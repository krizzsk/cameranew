package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Nk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1045Nk extends WebView {
    public static byte[] A01;
    public static String[] A02 = {"wCfyxoFTZ1jJ20JoleL2PfrggSS6BF65", "Rc2rUHoB5tN3gwl7phNiRTFEm74RUGaD", "k3E8g92vqjz0P264LqfNkGJlcmiFj3XN", "5IFC", "4VKGug1amLvDa4cy8fz1MnlZuIkeI9i2", "ilhy", "oZlIL0UAu4uBBRacqgrbUbhUTaUcQiCc", "IlF4AsfZVSat8w0D1JV7TLHsmvDiF9Hf"};
    public static final String A03;
    public boolean A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 105);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{87, 112, 120, 125, 116, 117, 49, 101, 126, 49, 120, Byte.MAX_VALUE, 120, 101, 120, 112, 125, 120, 107, 116, 49, 82, 126, 126, 122, 120, 116, 92, 112, Byte.MAX_VALUE, 112, 118, 116, 99, 63, 92, 93, 43, 104, 121, 106, 120, 99, 110, 111, 27, 16, 7, 16, 2, 18, 3, 24, 1, 5, 75, 82, 64, 71, 122, 83, 76, 64, 82};
    }

    static {
        A01();
        A03 = AbstractC1045Nk.class.getSimpleName();
    }

    public AbstractC1045Nk(Activity activity, XT xt) {
        super(activity);
        A03(xt);
    }

    public AbstractC1045Nk(XT xt) {
        super(xt);
        A03(xt);
    }

    public static void A02(int i2) {
        XS A00 = C8I.A00();
        if (A00 != null) {
            A00.A06().A8q(A00(56, 8, 76), i2, new C06818n(A00(35, 10, 98)));
        }
    }

    private void A03(C8J c8j) {
        setWebChromeClient(A0D());
        setWebViewClient(A0E());
        C1051Nq.A04(this);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 17) {
            WebSettings settings = getSettings();
            String[] strArr = A02;
            if (strArr[5].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "3VK0";
            strArr2[3] = "3PNm";
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (c8j.A03().A8H() && Build.VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            } catch (Exception unused) {
                Log.w(A03, A00(0, 35, 120));
            }
        }
    }

    private void A04(String str) {
        loadUrl(A00(45, 11, 24) + str);
    }

    public final void A05(String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(str, null);
            } else {
                A04(str);
            }
        } catch (IllegalStateException unused) {
            A04(str);
        }
    }

    public final boolean A06() {
        return this.A00;
    }

    public WebChromeClient A0D() {
        return new WebChromeClient();
    }

    public WebViewClient A0E() {
        return new C1044Nj(this);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.A00 = true;
        super.destroy();
    }
}
