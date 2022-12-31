package com.ironsource.sdk.ISNAdView;

import android.webkit.JavascriptInterface;
/* compiled from: ISNAdViewWebViewJSInterface.java */
/* loaded from: classes2.dex */
public class d {
    private ISNAdView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ISNAdView iSNAdView) {
        this.a = iSNAdView;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.a.r(str);
    }
}
