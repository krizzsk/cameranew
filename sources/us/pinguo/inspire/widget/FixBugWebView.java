package us.pinguo.inspire.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.webkit.WebView;
import us.pinguo.inspire.Inspire;
/* loaded from: classes9.dex */
public class FixBugWebView extends WebView {
    public FixBugWebView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        try {
            return super.startActionMode(callback);
        } catch (Throwable th) {
            Inspire.f(th);
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        try {
            return super.startActionModeForChild(view, callback);
        } catch (Throwable th) {
            Inspire.f(th);
            return null;
        }
    }

    public FixBugWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixBugWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
