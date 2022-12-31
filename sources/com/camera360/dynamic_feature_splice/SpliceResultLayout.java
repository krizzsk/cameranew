package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* compiled from: SpliceResultLayout.kt */
/* loaded from: classes8.dex */
public final class SpliceResultLayout extends ViewGroup {

    /* renamed from: d  reason: collision with root package name */
    private static final int f2180d = 2114191389;

    /* renamed from: e  reason: collision with root package name */
    private static final int f2181e = 2114191388;
    private int a;
    private Point b;
    private Point c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceResultLayout(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_result_image_min_width);
    }

    private final Point a(int i2, int i3) {
        Point point;
        if (this.b == null) {
            return null;
        }
        float f2 = i2;
        float f3 = i3;
        float f4 = point.x / point.y;
        if (f4 > f2 / f3) {
            i3 = kotlin.y.c.b(f2 / f4);
            int i4 = this.a;
            if (i3 < i4) {
                i3 = i4;
            }
        } else {
            i2 = kotlin.y.c.b(f3 * f4);
            int i5 = this.a;
            if (i2 < i5) {
                i2 = i5;
            }
        }
        return new Point(i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        kotlin.z.d h2;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        Point point = this.c;
        if (point == null) {
            return;
        }
        int paddingLeft = getPaddingLeft() + ((i6 - point.x) / 2);
        int paddingTop = getPaddingTop();
        int i8 = point.y;
        int i9 = paddingTop + ((i7 - i8) / 2);
        int i10 = point.x + paddingLeft;
        int i11 = i8 + i9;
        h2 = kotlin.z.j.h(0, getChildCount());
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            View childAt = getChildAt(((kotlin.collections.h0) it).nextInt());
            int id = childAt.getId();
            if (id == f2180d) {
                childAt.layout(paddingLeft, i9, i10, i11);
            } else if (id == f2181e) {
                int i12 = this.a;
                childAt.layout(i10 - i12, i11 - i12, i10, i11);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        kotlin.z.d h2;
        super.onMeasure(i2, i3);
        Point a = a(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3));
        this.c = a;
        if (a == null) {
            return;
        }
        h2 = kotlin.z.j.h(0, getChildCount());
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            View childAt = getChildAt(((kotlin.collections.h0) it).nextInt());
            int id = childAt.getId();
            if (id == f2180d) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(a.x, 1073741824), View.MeasureSpec.makeMeasureSpec(a.y, 1073741824));
            } else if (id == f2181e) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.a, 1073741824), View.MeasureSpec.makeMeasureSpec(this.a, 1073741824));
            }
        }
    }

    public final void setImageBitmap(Bitmap bitmap) {
        Point point = null;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                point = new Point(width, height);
            }
        }
        if (kotlin.jvm.internal.s.c(point, this.b)) {
            return;
        }
        this.b = point;
        requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceResultLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_result_image_min_width);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpliceResultLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.splcie_result_image_min_width);
    }
}
