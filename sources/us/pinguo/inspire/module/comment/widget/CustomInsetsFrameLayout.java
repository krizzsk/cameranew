package us.pinguo.inspire.module.comment.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;
/* loaded from: classes9.dex */
public class CustomInsetsFrameLayout extends FrameLayout {
    private int[] mInsets;

    public CustomInsetsFrameLayout(Context context) {
        super(context);
        this.mInsets = new int[4];
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        if (Build.VERSION.SDK_INT >= 20) {
            this.mInsets[0] = windowInsets.getSystemWindowInsetLeft();
            this.mInsets[1] = windowInsets.getSystemWindowInsetTop();
            this.mInsets[2] = windowInsets.getSystemWindowInsetRight();
            return super.onApplyWindowInsets(windowInsets.replaceSystemWindowInsets(0, 0, 0, windowInsets.getSystemWindowInsetBottom()));
        }
        return windowInsets;
    }

    @Override // android.view.View
    protected final boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 19) {
            int[] iArr = this.mInsets;
            iArr[0] = rect.left;
            iArr[1] = rect.top;
            iArr[2] = rect.right;
            rect.left = 0;
            rect.top = 0;
            rect.right = 0;
        }
        return super.fitSystemWindows(rect);
    }

    public final int[] getInsets() {
        return this.mInsets;
    }

    public CustomInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new int[4];
    }

    public CustomInsetsFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mInsets = new int[4];
    }
}
