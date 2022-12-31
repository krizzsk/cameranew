package com.nostra13.universalimageloader.core.j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* compiled from: ViewAware.java */
/* loaded from: classes3.dex */
public abstract class d implements a {
    protected Reference<View> a;
    protected boolean b;

    public d(View view) {
        this(view, true);
    }

    protected abstract void a(Bitmap bitmap, View view);

    protected abstract void b(Drawable drawable, View view);

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getHeight() {
        View view = this.a.get();
        int i2 = 0;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (this.b && layoutParams != null && layoutParams.height != -2) {
                i2 = view.getHeight();
            }
            return (i2 > 0 || layoutParams == null) ? i2 : layoutParams.height;
        }
        return 0;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getId() {
        View view = this.a.get();
        return view == null ? super.hashCode() : view.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getWidth() {
        View view = this.a.get();
        int i2 = 0;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (this.b && layoutParams != null && layoutParams.width != -2) {
                i2 = view.getWidth();
            }
            return (i2 > 0 || layoutParams == null) ? i2 : layoutParams.width;
        }
        return 0;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public View getWrappedView() {
        return this.a.get();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean isCollected() {
        return this.a.get() == null;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.a.get();
            if (view != null) {
                a(bitmap, view);
                return true;
            }
        } else {
            d.f.a.b.d.f("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = this.a.get();
            if (view != null) {
                b(drawable, view);
                return true;
            }
        } else {
            d.f.a.b.d.f("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        }
        return false;
    }

    public d(View view, boolean z) {
        if (view != null) {
            this.a = new WeakReference(view);
            this.b = z;
            return;
        }
        throw new IllegalArgumentException("view must not be null");
    }
}
