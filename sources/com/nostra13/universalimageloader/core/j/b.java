package com.nostra13.universalimageloader.core.j;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;
/* compiled from: ImageViewAware.java */
/* loaded from: classes3.dex */
public class b extends d {
    public b(ImageView imageView) {
        super(imageView);
    }

    private static int c(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e2) {
            d.f.a.b.d.c(e2);
            return 0;
        }
    }

    @Override // com.nostra13.universalimageloader.core.j.d
    protected void a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // com.nostra13.universalimageloader.core.j.d
    protected void b(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    /* renamed from: d */
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        return (height > 0 || (imageView = (ImageView) this.a.get()) == null) ? height : c(imageView, "mMaxHeight");
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.a.get();
        if (imageView != null) {
            return ViewScaleType.fromImageView(imageView);
        }
        return super.getScaleType();
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        return (width > 0 || (imageView = (ImageView) this.a.get()) == null) ? width : c(imageView, "mMaxWidth");
    }
}
