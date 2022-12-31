package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.1k  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C05071k extends WebViewClient {
    public boolean A00 = false;
    public final C1U A01;
    public final InterfaceC05061j A02;
    public final boolean A03;

    public C05071k(C1U c1u, InterfaceC05061j interfaceC05061j, boolean z) {
        this.A01 = c1u;
        this.A02 = interfaceC05061j;
        this.A03 = z;
    }

    private void A00() {
        if (this.A03) {
            this.A02.ABX(AdError.CACHE_ERROR);
        } else {
            A01();
        }
    }

    private void A01() {
        InterfaceC05061j interfaceC05061j = this.A02;
        if (interfaceC05061j != null) {
            interfaceC05061j.ABY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        A00();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.A00 = true;
        A01();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        new Handler().postDelayed(new C1516cX(this), this.A01.A08());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.A00 = true;
        A02();
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1045Nk.A02(C06808m.A2R);
        A00();
        return true;
    }
}
