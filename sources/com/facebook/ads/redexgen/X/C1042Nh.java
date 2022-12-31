package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Nh  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1042Nh extends WebViewClient {
    public static byte[] A03;
    @Nullable
    public WeakReference<InterfaceC1040Nf> A00;
    public final WeakReference<XT> A01;
    public final WeakReference<InterfaceC1039Ne> A02;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{54, 55, 68, 74, 73, 15, 55, 65, 54, 67, 64, 39, 52, 42, 56, 53, 47, 42, -12, 47, 52, 58, 43, 52, 58, -12, 39, 41, 58, 47, 53, 52, -12, 28, 15, 11, 29, 51, 64, 54, 68, 65, 59, 54, 0, 59, 64, 70, 55, 64, 70, 0, 53, 51, 70, 55, 57, 65, 68, 75, 0, 20, 36, 33, 41, 37, 19, 20, 30, 23, 17, 22, 28, Draft_75.CR, 22, 28, 28, 10, 7, 4, 27, 14, 10, 28};
    }

    public C1042Nh(WeakReference<InterfaceC1039Ne> weakReference, WeakReference<XT> weakReference2) {
        this.A02 = weakReference;
        this.A01 = weakReference2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
        if (r0.contains(r5) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean A02(android.webkit.WebView r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.XT> r0 = r8.A01
            java.lang.Object r0 = r0.get()
            r7 = 0
            if (r0 != 0) goto La
            return r7
        La:
            boolean r0 = com.facebook.ads.redexgen.X.C1175Sm.A0B()
            r3 = 1
            if (r0 == 0) goto L27
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L26
            r2 = 0
            r1 = 11
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L27
        L26:
            return r3
        L27:
            android.net.Uri r4 = android.net.Uri.parse(r10)
            java.lang.String r5 = r4.getScheme()
            boolean r0 = com.facebook.ads.redexgen.X.C1175Sm.A0B()     // Catch: java.lang.Exception -> Lb4
            if (r0 == 0) goto L82
            r2 = 70
            r1 = 6
            r0 = 71
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: java.lang.Exception -> Lb4
            boolean r0 = r0.equalsIgnoreCase(r5)     // Catch: java.lang.Exception -> Lb4
            if (r0 == 0) goto L82
            android.content.Intent r4 = android.content.Intent.parseUri(r10, r3)     // Catch: java.lang.Exception -> Lb4
            r2 = 37
            r1 = 33
            r0 = 113(0x71, float:1.58E-43)
            java.lang.String r0 = A00(r2, r1, r0)     // Catch: java.lang.Exception -> Lb4
            r4.addCategory(r0)     // Catch: java.lang.Exception -> Lb4
            r0 = 0
            r4.setComponent(r0)     // Catch: java.lang.Exception -> Lb4
            r4.setSelector(r0)     // Catch: java.lang.Exception -> Lb4
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.XT> r0 = r8.A01     // Catch: java.lang.Exception -> Lb4
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> Lb4
            com.facebook.ads.redexgen.X.XT r0 = (com.facebook.ads.redexgen.X.XT) r0     // Catch: java.lang.Exception -> Lb4
            android.content.pm.PackageManager r1 = r0.getPackageManager()     // Catch: java.lang.Exception -> Lb4
            r0 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r0 = r1.resolveActivity(r4, r0)     // Catch: java.lang.Exception -> Lb4
            if (r0 == 0) goto Le8
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.XT> r0 = r8.A01     // Catch: java.lang.Exception -> Lb4
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> Lb4
            com.facebook.ads.redexgen.X.XT r0 = (com.facebook.ads.redexgen.X.XT) r0     // Catch: java.lang.Exception -> Lb4
            boolean r0 = com.facebook.ads.redexgen.X.L9.A0B(r0, r4)     // Catch: java.lang.Exception -> Lb4
            if (r0 == 0) goto Le8
            r9.goBack()     // Catch: java.lang.Exception -> Lb4
            return r3
        L82:
            boolean r0 = com.facebook.ads.redexgen.X.C1175Sm.A0B()     // Catch: java.lang.Exception -> Lb4
            if (r0 == 0) goto L8e
            boolean r0 = com.facebook.ads.redexgen.X.Lc.A04(r10)     // Catch: java.lang.Exception -> Lb4
            if (r0 != 0) goto L98
        L8e:
            java.util.Set r0 = com.facebook.ads.redexgen.X.C1175Sm.A06()     // Catch: java.lang.Exception -> Lb4
            boolean r0 = r0.contains(r5)     // Catch: java.lang.Exception -> Lb4
            if (r0 != 0) goto Le8
        L98:
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.XT> r0 = r8.A01     // Catch: java.lang.Exception -> Lb4
            java.lang.Object r3 = r0.get()     // Catch: java.lang.Exception -> Lb4
            com.facebook.ads.redexgen.X.XT r3 = (com.facebook.ads.redexgen.X.XT) r3     // Catch: java.lang.Exception -> Lb4
            r2 = 11
            r1 = 26
            r0 = 101(0x65, float:1.42E-43)
            java.lang.String r1 = A00(r2, r1, r0)     // Catch: java.lang.Exception -> Lb4
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> Lb4
            r0.<init>(r1, r4)     // Catch: java.lang.Exception -> Lb4
            boolean r0 = com.facebook.ads.redexgen.X.L9.A0B(r3, r0)     // Catch: java.lang.Exception -> Lb4
            return r0
        Lb4:
            r6 = move-exception
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.XT> r0 = r8.A01
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.XT r0 = (com.facebook.ads.redexgen.X.XT) r0
            com.facebook.ads.redexgen.X.8l r5 = r0.A06()
            int r4 = com.facebook.ads.redexgen.X.C06808m.A2O
            com.facebook.ads.redexgen.X.8n r3 = new com.facebook.ads.redexgen.X.8n
            r3.<init>(r6)
            r2 = 76
            r1 = 8
            r0 = 68
            java.lang.String r0 = A00(r2, r1, r0)
            r5.A8r(r0, r4, r3)
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.XT> r0 = r8.A01
            java.lang.Object r0 = r0.get()
            com.facebook.ads.redexgen.X.XT r0 = (com.facebook.ads.redexgen.X.XT) r0
            com.facebook.ads.redexgen.X.0R r1 = r0.A0D()
            java.lang.String r0 = r6.toString()
            r1.A86(r0)
        Le8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1042Nh.A02(android.webkit.WebView, java.lang.String):boolean");
    }

    public final void A03(WeakReference<InterfaceC1040Nf> weakReference) {
        this.A00 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.A02.get() != null) {
            this.A02.get().ABR(str);
        }
        WeakReference<InterfaceC1040Nf> weakReference = this.A00;
        if (weakReference != null && weakReference.get() != null) {
            this.A00.get().A9y(webView.canGoBack());
            this.A00.get().AAc(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.A02.get() != null) {
            this.A02.get().ABT(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
        if (this.A01.get() != null) {
            StringBuilder sb = new StringBuilder();
            String A00 = A00(0, 0, 27);
            sb.append(A00);
            sb.append(str);
            String sb2 = sb.toString();
            this.A01.get().A0D().A83(Lc.A01(i2, sb2, A00 + str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.A01.get() != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String A00 = A00(0, 0, 27);
            sb.append(A00);
            sb.append((Object) webResourceError.getDescription());
            String sb2 = sb.toString();
            this.A01.get().A0D().A83(Lc.A01(errorCode, sb2, A00 + webResourceRequest.getUrl()));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.A01.get() != null) {
            this.A01.get().A0D().A84();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        if (this.A01.get() != null) {
            this.A01.get().A0D().A85();
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1045Nk.A02(C06808m.A2P);
        InterfaceC1039Ne interfaceC1039Ne = this.A02.get();
        if (interfaceC1039Ne != null) {
            interfaceC1039Ne.ABr();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A02(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A02(webView, str);
    }
}
