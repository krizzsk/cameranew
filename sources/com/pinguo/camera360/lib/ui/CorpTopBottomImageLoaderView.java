package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
/* loaded from: classes3.dex */
public class CorpTopBottomImageLoaderView extends ImageLoaderView {

    /* renamed from: d  reason: collision with root package name */
    private CorpType f6828d;

    /* renamed from: e  reason: collision with root package name */
    private FitType f6829e;

    /* loaded from: classes3.dex */
    public enum CorpType {
        TOP_CROP,
        BOTTOM_CROP
    }

    /* loaded from: classes3.dex */
    public enum FitType {
        TOP_FIT,
        BOTTOM_FIT
    }

    public CorpTopBottomImageLoaderView(Context context) {
        this(context, null);
    }

    public void setFillType(CorpType corpType, FitType fitType) {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f6828d = corpType;
        this.f6829e = fitType;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float measuredWidth = getMeasuredWidth() / width;
        float measuredHeight = getMeasuredHeight() - (height * measuredWidth);
        Matrix matrix = new Matrix();
        matrix.setScale(measuredWidth, measuredWidth);
        if (measuredHeight > 0.0f) {
            if (this.f6829e == FitType.BOTTOM_FIT) {
                matrix.postTranslate(0.0f, (int) (measuredHeight + 0.5f));
            }
        } else if (this.f6828d == CorpType.TOP_CROP) {
            matrix.postTranslate(0.0f, (int) (measuredHeight + 0.5f));
        }
        setImageMatrix(matrix);
        super.setImageBitmap(bitmap);
    }

    public void setRate(float f2) {
    }

    public CorpTopBottomImageLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6828d = CorpType.TOP_CROP;
        this.f6829e = FitType.TOP_FIT;
    }
}
