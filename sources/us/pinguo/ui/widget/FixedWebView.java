package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;
/* loaded from: classes6.dex */
public class FixedWebView extends WebView {
    public FixedWebView(Context context) {
        super(a(context));
    }

    public static Context a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    public FixedWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
    }

    public FixedWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(context), attributeSet, i2);
    }
}
