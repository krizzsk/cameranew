package com.pinguo.camera360.homepage.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import vStudio.Android.Camera360.R;
/* compiled from: RatioImageView.kt */
/* loaded from: classes3.dex */
public final class RatioImageView extends AppCompatImageView {
    private float a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
        init(context, attributeSet);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatioImageView);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…styleable.RatioImageView)");
        this.a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.a > 0.0f) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) ((size / this.a) + 0.5f), 1073741824);
            }
        }
        super.onMeasure(i2, i3);
    }
}
