package com.zhy.android.percent.support;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.zhy.android.percent.support.PercentLayoutHelper;
/* loaded from: classes3.dex */
public class PercentLinearLayout extends LinearLayout {
    private PercentLayoutHelper a;

    /* loaded from: classes3.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams implements PercentLayoutHelper.b {
        private PercentLayoutHelper.PercentLayoutInfo a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = PercentLayoutHelper.f(context, attributeSet);
        }

        @Override // com.zhy.android.percent.support.PercentLayoutHelper.b
        public PercentLayoutHelper.PercentLayoutInfo a() {
            return this.a;
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i2, int i3) {
            PercentLayoutHelper.d(this, typedArray, i2, i3);
        }
    }

    public PercentLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new PercentLayoutHelper(this);
    }

    private int b() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.a.l();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int b;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2));
        if (mode == 0 && getParent() != null && (getParent() instanceof ScrollView)) {
            Context context = getContext();
            if (context instanceof Activity) {
                b = ((Activity) context).findViewById(16908290).getMeasuredHeight();
            } else {
                b = b();
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(b, mode);
        }
        this.a.b(makeMeasureSpec2, makeMeasureSpec);
        super.onMeasure(i2, i3);
        if (this.a.j()) {
            super.onMeasure(i2, i3);
        }
    }
}
