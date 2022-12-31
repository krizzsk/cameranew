package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Oj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1068Oj extends WebViewClient {
    public static byte[] A01;
    public static String[] A02 = {"hfMJ0frXuRQdVVGg5HhbkedMp84qvG2m", "353suYezQm1X4xGGmKd", "JSegO1TQToLz4SD5sG2", "wzs2neDsiDlXGMSMfb3", "O6PuLNBrYuNMqKQgURK12L6N", "9iUPqfJGnhoj94eJuJeS1Wm6njk1Rmvr", "BdwoSzPq3MvWa04biSMwYNzp8DFOBLqT", "enVVpEgx3aC4K8YdK2hdvlOQVko"};
    public final /* synthetic */ C1072On A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{3, 4, 18, 2, 17, 8, 15, 19, 8, 14, Draft_75.CR, -11, -6, -11, -44, 3, -14, 4, -7, Draft_75.CR, 26, 26, 23, 26, -21, 23, 12, Draft_75.CR, 48, 43, 64, 51, 45, 57, 56, -8, 51, 45, 57, 39, 51, 51, 47, 30, 36, 49, 49, 46, 49, 71, 73, 64, 70, 73, 64, 75, 80, -4, -7, -13};
    }

    static {
        A01();
    }

    public C1068Oj(C1072On c1072On) {
        this.A00 = c1072On;
    }

    public /* synthetic */ C1068Oj(C1072On c1072On, S5 s5) {
        this(c1072On);
    }

    private void A02(int i2, String str, String str2, boolean z) {
        C0937Jb c0937Jb;
        XT xt;
        C1062Ob c1062Ob;
        if (z) {
            this.A00.A0S();
        }
        c0937Jb = this.A00.A0A;
        c0937Jb.A02(EnumC0936Ja.A0Q, null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(19, 9, 44), i2);
            jSONObject.put(A00(0, 11, 35), str);
            jSONObject.put(A00(57, 3, 11), str2);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        xt = this.A00.A08;
        xt.A0D().A52(jSONObject2);
        c1062Ob = this.A00.A0C;
        c1062Ob.A04(C06808m.A0w, jSONObject2);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        C0937Jb c0937Jb;
        XT xt;
        long j2;
        InterfaceC1070Ol interfaceC1070Ol;
        InterfaceC1070Ol interfaceC1070Ol2;
        c0937Jb = this.A00.A0A;
        c0937Jb.A02(EnumC0936Ja.A0R, null);
        xt = this.A00.A08;
        C0R A0D = xt.A0D();
        j2 = this.A00.A00;
        A0D.A53(C1008Ly.A01(j2));
        this.A00.A0S();
        this.A00.A04 = true;
        this.A00.A0F();
        interfaceC1070Ol = this.A00.A01;
        if (interfaceC1070Ol == null) {
            return;
        }
        interfaceC1070Ol2 = this.A00.A01;
        interfaceC1070Ol2.ACe();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            A02(i2, str, str2, true);
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        int errorCode = webResourceError.getErrorCode();
        StringBuilder sb = new StringBuilder();
        String A00 = A00(0, 0, 48);
        sb.append(A00);
        sb.append((Object) webResourceError.getDescription());
        String sb2 = sb.toString();
        A02(errorCode, sb2, A00 + webResourceRequest.getUrl(), true);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        int i2;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.getUrl().toString().toLowerCase(Locale.US).contains(A00(28, 11, 78))) {
            return;
        }
        if (webResourceResponse != null) {
            i2 = webResourceResponse.getStatusCode();
        } else {
            i2 = -1;
        }
        A02(i2, A00(39, 10, 67), A00(0, 0, 48) + webResourceRequest.getUrl(), false);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        XT xt;
        AnonymousClass16 anonymousClass16;
        InterfaceC1071Om interfaceC1071Om;
        InterfaceC1071Om interfaceC1071Om2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(11, 8, 21), renderProcessGoneDetail.didCrash());
            jSONObject.put(A00(49, 8, 91), renderProcessGoneDetail.rendererPriorityAtExit());
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        xt = this.A00.A08;
        xt.A0D().A4y(jSONObject2);
        anonymousClass16 = this.A00.A06;
        C1073Oo.A03(anonymousClass16.A0V());
        interfaceC1071Om = this.A00.A02;
        if (interfaceC1071Om == null) {
            return true;
        }
        interfaceC1071Om2 = this.A00.A02;
        String[] strArr = A02;
        if (strArr[1].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        A02[0] = "kv0KfCNN1XAdbICEJBZwu3dTiw7XNBbg";
        interfaceC1071Om2.ABi();
        return true;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @RequiresApi(api = 21)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        XT xt;
        C7J c7j;
        C1084Oz c1084Oz;
        P1 p1;
        AnonymousClass16 anonymousClass16;
        xt = this.A00.A08;
        c7j = this.A00.A07;
        c1084Oz = this.A00.A0F;
        p1 = this.A00.A0G;
        anonymousClass16 = this.A00.A06;
        return P2.A00(xt, c7j, webResourceRequest, c1084Oz, p1, anonymousClass16.A0i());
    }
}
