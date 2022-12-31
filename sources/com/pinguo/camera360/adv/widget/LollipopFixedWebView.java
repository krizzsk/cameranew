package com.pinguo.camera360.adv.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public class LollipopFixedWebView extends WebView {
    public LollipopFixedWebView(Context context) {
        super(a(context));
    }

    public static Context a(Context context) {
        return context.createConfigurationContext(new Configuration());
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
    }

    public LollipopFixedWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(context), attributeSet, i2);
    }
}
