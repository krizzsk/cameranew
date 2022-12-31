package com.facebook.ads.redexgen.X;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.No  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1049No extends WebChromeClient {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-91, -47, -48, -43, -47, -50, -57, -126, -49, -57, -43, -43, -61, -55, -57, -100, -126, -102, -67, -81, -78, -73, -68, -75, 110, -66, -64, -67, -75, -64, -77, -63, -63, -120, 110};
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (BuildConfigApi.isDebug()) {
            String str = A00(0, 17, 30) + consoleMessage.message();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        if (BuildConfigApi.isDebug()) {
            String str = A00(17, 18, 10) + i2;
        }
    }
}
