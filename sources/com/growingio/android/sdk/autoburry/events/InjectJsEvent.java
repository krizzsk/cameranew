package com.growingio.android.sdk.autoburry.events;

import android.view.View;
/* loaded from: classes2.dex */
public class InjectJsEvent {
    private final View webView;

    public InjectJsEvent(View view) {
        this.webView = view;
    }

    public View getWebView() {
        return this.webView;
    }
}
