package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class ResizeLayout extends LinearLayout {
    private OnResizeListener a;

    /* loaded from: classes.dex */
    public interface OnResizeListener {
        void OnResize(int i2, int i3, int i4, int i5);
    }

    public ResizeLayout(Context context) {
        super(context);
    }

    public void a(OnResizeListener onResizeListener) {
        this.a = onResizeListener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        OnResizeListener onResizeListener = this.a;
        if (onResizeListener != null) {
            onResizeListener.OnResize(i2, i3, i4, i5);
        }
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
