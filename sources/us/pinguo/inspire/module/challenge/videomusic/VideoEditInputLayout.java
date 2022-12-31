package us.pinguo.inspire.module.challenge.videomusic;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: VideoEditInputFragment.kt */
/* loaded from: classes9.dex */
public final class VideoEditInputLayout extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private final int[] mInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditInputLayout(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mInsets = new int[4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onLayout$lambda-0  reason: not valid java name */
    public static final void m120onLayout$lambda0(VideoEditInputLayout this$0, int i2, int i3) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int[] iArr = new int[2];
        this$0.getLocationInWindow(iArr);
        us.pinguo.common.log.a.u("hwLog", "bottom:" + iArr[1] + " height" + (i2 - i3), new Object[0]);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        kotlin.jvm.internal.s.h(insets, "insets");
        if (Build.VERSION.SDK_INT >= 20) {
            this.mInsets[0] = insets.getSystemWindowInsetLeft();
            this.mInsets[1] = insets.getSystemWindowInsetTop();
            this.mInsets[2] = insets.getSystemWindowInsetRight();
            WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(insets.replaceSystemWindowInsets(0, 0, 0, insets.getSystemWindowInsetBottom()));
            kotlin.jvm.internal.s.g(onApplyWindowInsets, "super.onApplyWindowInset…systemWindowInsetBottom))");
            return onApplyWindowInsets;
        }
        return insets;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect insets) {
        kotlin.jvm.internal.s.h(insets, "insets");
        if (Build.VERSION.SDK_INT == 19) {
            int[] iArr = this.mInsets;
            iArr[0] = insets.left;
            iArr[1] = insets.top;
            iArr[2] = insets.right;
            insets.left = 0;
            insets.top = 0;
            insets.right = 0;
        }
        return super.fitSystemWindows(insets);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, final int i3, int i4, final int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        getLocationInWindow(new int[2]);
        post(new Runnable() { // from class: us.pinguo.inspire.module.challenge.videomusic.p0
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditInputLayout.m120onLayout$lambda0(VideoEditInputLayout.this, i5, i3);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.mInsets = new int[4];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditInputLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.mInsets = new int[4];
    }
}
