package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;
/* loaded from: classes3.dex */
public enum ViewScaleType {
    FIT_INSIDE,
    CROP;

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static ViewScaleType fromImageView(ImageView imageView) {
        int i2 = a.a[imageView.getScaleType().ordinal()];
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5) {
            return CROP;
        }
        return FIT_INSIDE;
    }
}
