package com.zhy.android.percent.support;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.zhy.android.percent.support.PercentLayoutHelper;
/* loaded from: classes3.dex */
public class PercentRelativeLayout extends RelativeLayout {
    private final PercentLayoutHelper a;

    /* loaded from: classes3.dex */
    public static class LayoutParams extends RelativeLayout.LayoutParams implements PercentLayoutHelper.b {
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

    public PercentRelativeLayout(Context context) {
        super(context);
        this.a = new PercentLayoutHelper(this);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.a.l();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        this.a.b(i2, i3);
        super.onMeasure(i2, i3);
        if (this.a.j()) {
            super.onMeasure(i2, i3);
        }
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new PercentLayoutHelper(this);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new PercentLayoutHelper(this);
    }
}
