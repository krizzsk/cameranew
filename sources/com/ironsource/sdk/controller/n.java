package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
/* compiled from: SecureMessagingInterface.java */
/* loaded from: classes2.dex */
class n {
    private o a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar) {
        this.a = oVar;
    }

    @JavascriptInterface
    public String getTokenForMessaging() {
        if (this.b) {
            return "";
        }
        this.b = true;
        return this.a.c();
    }
}
