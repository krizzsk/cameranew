package com.pinguo.camera360.gallery.ui.personal;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.ArrayDeque;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
/* loaded from: classes3.dex */
public class MatrixCenterCropImageView extends ImageLoaderView {

    /* loaded from: classes3.dex */
    public enum AnimType {
        ALPHA_0_TO_1_ANIM,
        ALPHA_1_TO_0_ANIM,
        SCALE_ANIM,
        TRANS_X_ANIM
    }

    /* loaded from: classes3.dex */
    public interface a {
    }

    public MatrixCenterCropImageView(Context context) {
        super(context);
        new ArrayDeque();
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void b() {
        float f2;
        float f3;
        if (getDrawable() == null) {
            return;
        }
        Matrix imageMatrix = getImageMatrix();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        us.pinguo.common.log.a.k("drawableHeight = " + intrinsicHeight + " drawableWidth  = " + intrinsicWidth, new Object[0]);
        if (intrinsicWidth * height > intrinsicHeight * width) {
            f2 = height;
            f3 = intrinsicHeight;
        } else {
            f2 = width;
            f3 = intrinsicWidth;
        }
        float f4 = f2 / f3;
        imageMatrix.setScale(f4, f4);
        float f5 = intrinsicWidth * f4;
        float f6 = width;
        float f7 = f5 > f6 ? -((f5 - f6) / 2.0f) : 0.0f;
        float f8 = intrinsicHeight * f4;
        float f9 = height;
        imageMatrix.postTranslate(f7, f8 > f9 ? -((f8 - f9) / 2.0f) : 0.0f);
        setImageMatrix(imageMatrix);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b();
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        b();
        return super.setFrame(i2, i3, i4, i5);
    }

    public void setListener(a aVar) {
    }

    public MatrixCenterCropImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new ArrayDeque();
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public MatrixCenterCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new ArrayDeque();
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
