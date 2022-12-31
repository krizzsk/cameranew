package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.LinkedHashMap;
import java.util.Map;
import vStudio.Android.Camera360.R;
/* compiled from: InterceptTouchEventMaskView.kt */
/* loaded from: classes3.dex */
public final class InterceptTouchEventMaskView extends FrameLayout {
    public Map<Integer, View> a;
    private boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptTouchEventMaskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ViewGroup.LayoutParams layoutParams, InterceptTouchEventMaskView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        layoutParams.height = ((ScrollView) this$0.a(R.id.sv_watermark_content)).getMeasuredHeight();
        this$0.requestLayout();
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
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

    public boolean b() {
        return this.b;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (b()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = R.id.mask_view;
        final ViewGroup.LayoutParams layoutParams = a(i4).getLayoutParams();
        if (a(i4).getMeasuredHeight() != ((ScrollView) a(R.id.sv_watermark_content)).getMeasuredHeight()) {
            us.pinguo.foundation.ui.c.c(this, new Runnable() { // from class: com.pinguo.camera360.lib.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    InterceptTouchEventMaskView.d(layoutParams, this);
                }
            }, false);
        }
    }

    public void setShouldIntercept(boolean z) {
        this.b = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptTouchEventMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptTouchEventMaskView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }
}
