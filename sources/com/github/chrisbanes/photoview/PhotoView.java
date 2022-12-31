package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes9.dex */
public class PhotoView extends ImageView {
    private l a;
    private int b;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void a() {
        this.a = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.b >= 0) {
            setScaleType(getScaleType());
            this.b = -1;
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.H();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        ImageView.ScaleType c = n.c(this.a.O());
        return c == null ? ImageView.ScaleType.MATRIX : c;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.R(z);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.a.r0();
        }
        return frame;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.a;
        if (lVar != null) {
            lVar.r0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        l lVar = this.a;
        if (lVar != null) {
            lVar.r0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.a;
        if (lVar != null) {
            lVar.r0();
        }
    }

    public void setMaximumScale(float f2) {
        this.a.U(f2);
    }

    public void setMediumScale(float f2) {
        this.a.V(f2);
    }

    public void setMinimumScale(float f2) {
        this.a.W(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.X(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.Y(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.Z(onLongClickListener);
    }

    public void setOnMatrixChangeListener(e eVar) {
        this.a.a0(eVar);
    }

    public void setOnOutsidePhotoTapListener(f fVar) {
        this.a.b0(fVar);
    }

    public void setOnPhotoTapListener(g gVar) {
        this.a.c0(gVar);
    }

    public void setOnScaleChangeListener(h hVar) {
        this.a.d0(hVar);
    }

    public void setOnSingleFlingListener(i iVar) {
        this.a.e0(iVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.a.f0(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.a.g0(kVar);
    }

    public void setRotationBy(float f2) {
        this.a.h0(f2);
    }

    public void setRotationTo(float f2) {
        this.a.i0(f2);
    }

    public void setScale(float f2) {
        this.a.j0(f2);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        this.a.m0(f2, f3, f4);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            Log.e("PhotoView", "attacher not support ScaleType.MATRIX");
            return;
        }
        l lVar = this.a;
        if (lVar == null) {
            this.b = scaleType.ordinal();
        } else {
            lVar.n0(scaleType.ordinal());
        }
    }

    public void setZoomTransitionDuration(int i2) {
        this.a.p0(i2);
    }

    public void setZoomable(boolean z) {
        this.a.q0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setScale(float f2, boolean z) {
        this.a.l0(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = -1;
        a();
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.a.k0(f2, f3, f4, z);
    }
}
