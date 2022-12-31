package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.monitor.BuildConfig;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Np  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1050Np extends WebViewClient {
    public static byte[] A0B;
    public static String[] A0C = {"dutFbLT0SJ7F8tp2omMpyLiOAYVHs", "eQZAVGISCoayl61p0XGnY6zF77MwgQ", "oGFUl4XXjxY0ysGh9uHTM5Bs0jmGzYfS", "nw1FzUJk4sGWtK2y2h7dLK31U1IoYOTN", "MQohGS04hBsrr", "rz5lEB2hDVgjaI0SM6Y5mQ12Lmz2ba", "Gakm8d7sZsS0Gn2hVSl3GYNL92Z8TRo6", "Ty7sQNcmLenaFb4R0BQbvtPuiVx7Fgst"};
    public Date A00;
    public boolean A01 = false;
    public final XT A02;
    public final WeakReference<C1166Sd> A03;
    public final WeakReference<InterfaceC1048Nn> A04;
    public final WeakReference<AtomicBoolean> A05;
    public final WeakReference<C1009Lz> A06;
    public final WeakReference<QZ> A07;
    public final AtomicInteger A08;
    public final AtomicReference<String> A09;
    public final boolean A0A;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 74);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0B = new byte[]{92, 126, 124, 119, 122, 50, 92, 112, 113, 107, 109, 112, 115, 83, 114, 121, 126, 114, 115, 55, 4, 19, 30, 7, 19, 6, 27, 28, 21, 82, 39, 32, 59, 82, 34, 19, 6, 26, 82, 20, 29, 0, 82, 52, 27, 30, 23, 82, 51, 17, 17, 23, 1, 1, 82, 71, 122, 118, 112, 99, 34, 102, 99, 118, 99, 56, 34, 53, 41, 41, 45, 93, 56, 15, 15, 18, 15, 53, 14, 19, 1, 6, 5, 64, 50, 5, 17, 21, 5, 19, 20, 64, 6, 15, 18, 64, 38, 9, 12, 5, 64, 33, 3, 3, 5, 19, 19, 64, 49, 10, 23, 5, 2, 1, 68, 54, 1, 21, 17, 1, 23, 16, 68, 2, 11, 22, 68, 34, Draft_75.CR, 8, 1, 68, 37, 7, 7, 1, 23, 23, 68, 0, 1, 10, Draft_75.CR, 1, 0, 98, 99, 104, 111, 99, 98, 89, 115, 116, 111, 89, 118, 103, 114, 110, 33, 54, 54, 43, 54, 27, 39, 43, 32, 33, 16, 7, 7, 26, 7, 42, 17, 16, 6, 22, 7, 28, 5, 1, 28, 26, 27, 40, 47, 56, 39, 45, 33, 32, 96, 39, 45, 33, 126, 113, 116, 125, 99, 121, 85, 125, 111, 104, 85, 120, 111, 121, 101, Byte.MAX_VALUE, 120, 105, 111, 85, 111, 120, 120, 101, 120, 102, 101, 107, 110, 99, 100, 109, 85, 126, 99, 103, 111, 85, 99, 100, 85, 103, 99, 102, 102, 99, 121, 18, 25, 8, 70, 70, 57, 46, 46, 35, 57, 49, 44, 40, 37, 35, 46, 57, 47, 44, 51, 50, 47, 57, 2, 3, 65, 31, 24, 3, 30, 9, 58, 45, 57, 61, 45, 59, 60, 23, 33, 44, 29, 12, 17, 29, 70, 25, 5, 8, 0, 7, 6, 17, 28, 25, 20, 47, 0, 17, 4, 24, 29, 15, 8, 53, 28, 3, 15, 29};
    }

    static {
        A02();
    }

    public C1050Np(XT xt, WeakReference<InterfaceC1048Nn> weakReference, WeakReference<QZ> weakReference2, WeakReference<C1009Lz> weakReference3, WeakReference<AtomicBoolean> weakReference4, WeakReference<C1166Sd> weakReference5, AtomicInteger atomicInteger, AtomicReference<String> atomicReference, boolean z) {
        this.A02 = xt;
        this.A04 = weakReference;
        this.A07 = weakReference2;
        this.A06 = weakReference3;
        this.A05 = weakReference4;
        this.A03 = weakReference5;
        this.A08 = atomicInteger;
        this.A09 = atomicReference;
        this.A0A = z;
    }

    @RequiresApi(api = 21)
    private WebResourceResponse A00() {
        return new WebResourceResponse(A01(286, 10, 35), StandardCharsets.UTF_8.name(), TypedValues.CycleType.TYPE_ALPHA, A01(13, 6, 93), Collections.singletonMap(A01(0, 13, 85), A01(268, 8, 38)), new ByteArrayInputStream(A01(13, 6, 93).getBytes()));
    }

    private void A03(int i2, CharSequence charSequence, long j2) {
        JSONObject jSONObject = new JSONObject();
        boolean z = charSequence != null;
        try {
            jSONObject.put(A01(160, 10, 14), i2);
            jSONObject.put(A01(170, 17, 63), charSequence);
            jSONObject.put(A01(202, 21, 64), z);
            jSONObject.put(A01(223, 22, 64), j2);
            jSONObject.put(A01(276, 10, 2), this.A09.get());
        } catch (JSONException unused) {
        }
        InterfaceC06798l A06 = this.A02.A06();
        int i3 = C06808m.A2Q;
        String defaultErrorMessage = AdErrorType.WEB_VIEW_FAILED_TO_LOAD.getDefaultErrorMessage();
        A06.A8q(A01(306, 8, 32), i3, new C06818n(defaultErrorMessage, A01(55, 12, 72) + jSONObject.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(int i2, @Nullable String str) {
        if (A01(245, 23, 54).equals(str)) {
            this.A02.A0D().AFM();
            return;
        }
        this.A02.A0D().AFN(i2, str);
        A03(i2, str, new Date().getTime() - this.A00.getTime());
        if (this.A04.get() != null) {
            this.A04.get().AAa(i2, str);
        }
    }

    @RequiresApi(api = 21)
    private final void A05(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (webResourceRequest.getUrl().toString().toLowerCase(Locale.US).contains(A01(187, 11, 4))) {
            return;
        }
        int statusCode = webResourceResponse.getStatusCode();
        this.A02.A0D().AFR(webResourceResponse.getStatusCode(), Lc.A01(statusCode, A01(67, 10, 55), A01(0, 0, 49) + webResourceRequest.getUrl()));
    }

    private void A07(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A01(BuildConfig.VERSION_CODE, 15, 76), str);
            jSONObject.put(A01(296, 10, 58), str2);
            jSONObject.put(A01(276, 10, 2), this.A09.get());
        } catch (JSONException unused) {
        }
        XT xt = this.A02;
        if (xt != null) {
            InterfaceC06798l A06 = xt.A06();
            int i2 = C06808m.A2N;
            String defaultErrorMessage = AdErrorType.WEB_VIEW_CACHE_FILE_WAS_DENIED.getDefaultErrorMessage();
            A06.A8q(A01(306, 8, 32), i2, new C06818n(defaultErrorMessage, A01(55, 12, 72) + jSONObject.toString()));
        }
    }

    private boolean A08(Uri uri) {
        String str;
        String path = uri.getPath();
        String scheme = uri.getScheme();
        if (path != null && scheme != null) {
            String A01 = A01(198, 4, 82);
            if (A0C[4].length() != 8) {
                A0C[6] = "e0NZ0IpncKNbspdHVbaE77hYKi1pXgCT";
                if (scheme.equals(A01)) {
                    if (BuildConfigApi.isDebug()) {
                        String str2 = A01(19, 36, 56) + path;
                    }
                    List<String> A09 = C7J.A09(this.A02);
                    boolean valid = A0A(path, A09);
                    if (!valid) {
                        if (BuildConfigApi.isDebug()) {
                            String str3 = A01(77, 31, 42) + path;
                        }
                        str = C1166Sd.A0H;
                        Log.w(str, A01(108, 37, 46));
                        A07(path, A09.toString());
                    }
                    return valid;
                }
            }
            throw new RuntimeException();
        }
        if (A0C[7].charAt(29) != 'S') {
            A0C[2] = "yXDUwGubOAV6buqiBYARa4GXiUTiAdtJ";
            return true;
        }
        throw new RuntimeException();
    }

    public static boolean A0A(String str, List<String> list) {
        String lowerPath = str.toLowerCase(Locale.getDefault());
        for (String cacheDir : list) {
            if (lowerPath.startsWith(cacheDir)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.A02.A0D().AFO(this.A03.get() != null);
        if (this.A03.get() != null && this.A05.get() != null && !this.A05.get().get()) {
            this.A03.get().A0F();
        }
        this.A01 = true;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.A02.A0D().AFP();
        this.A00 = new Date();
        new Handler().postDelayed(new C1167Se(this), this.A08.get());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        this.A01 = true;
        A04(i2, str);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        boolean A0q = JD.A0q(this.A02);
        String A01 = A01(0, 0, 49);
        if (A0q || webResourceRequest.isForMainFrame()) {
            this.A01 = true;
            A04(webResourceError.getErrorCode(), A01 + ((Object) webResourceError.getDescription()));
            return;
        }
        this.A02.A0D().AFQ(Lc.A01(webResourceError.getErrorCode(), A01 + ((Object) webResourceError.getDescription()), A01 + webResourceRequest.getUrl()));
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        A05(webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.A02.A0D().AFS();
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1045Nk.A02(C06808m.A2M);
        InterfaceC1048Nn interfaceC1048Nn = this.A04.get();
        if (interfaceC1048Nn != null) {
            interfaceC1048Nn.ACd();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @RequiresApi(api = 21)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (this.A0A && !A08(url)) {
            WebResourceResponse A00 = A00();
            A05(webResourceRequest, A00);
            return A00;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.A04.get() != null) {
            this.A04.get().AA7(str, new C1055Nu().A03(this.A07.get()).A02(this.A06.get()).A05());
            return true;
        }
        return true;
    }
}
