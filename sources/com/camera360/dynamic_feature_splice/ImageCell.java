package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import java.util.LinkedHashMap;
/* compiled from: LongImageView.kt */
/* loaded from: classes8.dex */
final class ImageCell extends View {
    private final Bitmap a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCell(Context context, Bitmap bitmap) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(bitmap, "bitmap");
        new LinkedHashMap();
        this.a = bitmap;
        setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int b;
        int size = View.MeasureSpec.getSize(i2);
        b = kotlin.y.c.b(size / (this.a.getWidth() / this.a.getHeight()));
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(b, 1073741824));
    }
}
