package com.ironsource.sdk.WPAD;

import android.webkit.JavascriptInterface;
/* compiled from: ISNAdViewJSInterface.java */
/* loaded from: classes2.dex */
public class a {
    private c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.a = cVar;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.a.handleMessageFromAd(str);
    }
}
