package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedHashMap;
/* compiled from: LongImageView.kt */
/* loaded from: classes8.dex */
final class LongLinearLayout extends LinearLayout {
    private final Point a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongLinearLayout(Context context, Point size) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(size, "size");
        new LinkedHashMap();
        this.a = size;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int b;
        int size = View.MeasureSpec.getSize(i2);
        Point point = this.a;
        b = kotlin.y.c.b(size / (point.x / point.y));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(b, 1073741824));
    }
}
