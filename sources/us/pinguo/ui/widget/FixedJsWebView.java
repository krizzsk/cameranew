package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import us.pinguo.webview.PGJsWebView;
/* loaded from: classes6.dex */
public class FixedJsWebView extends PGJsWebView {
    public FixedJsWebView(Context context) {
        super(k(context));
    }

    public static Context k(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    public FixedJsWebView(Context context, AttributeSet attributeSet) {
        super(k(context), attributeSet);
    }

    public FixedJsWebView(Context context, AttributeSet attributeSet, int i2) {
        super(k(context), attributeSet, i2);
    }
}
