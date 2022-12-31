package com.facebook.ads.redexgen.X;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
/* renamed from: com.facebook.ads.redexgen.X.Nj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1044Nj extends WebViewClient {
    public final /* synthetic */ AbstractC1045Nk A00;

    public C1044Nj(AbstractC1045Nk abstractC1045Nk) {
        this.A00 = abstractC1045Nk;
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1045Nk.A02(C06808m.A2S);
        return true;
    }
}
