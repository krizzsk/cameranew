package us.pinguo.inspire.widget.photopager;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.e;
import com.github.chrisbanes.photoview.f;
import com.github.chrisbanes.photoview.g;
import com.github.chrisbanes.photoview.h;
import com.github.chrisbanes.photoview.i;
import com.github.chrisbanes.photoview.j;
import com.github.chrisbanes.photoview.k;
import com.github.chrisbanes.photoview.l;
import com.github.chrisbanes.photoview.m;
import us.pinguo.ui.uilview.PhotoNsImageView;
/* loaded from: classes9.dex */
public class InfoTouchImageView extends PhotoNsImageView implements m {
    private l a;
    private int b;
    private int c;

    public InfoTouchImageView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.a = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.a.n0(169);
        this.a.o0(this);
    }

    @Override // com.github.chrisbanes.photoview.m
    public void a(RectF rectF, RectF rectF2, Matrix matrix, int i2) {
        if (i2 != 169) {
            return;
        }
        if (rectF.width() < rectF.height()) {
            float width = rectF2.width() * (rectF.height() / rectF.width());
            float centerY = rectF2.centerY();
            float f2 = width / 2.0f;
            matrix.setRectToRect(rectF, new RectF(rectF2.left, centerY - f2, rectF2.right, centerY + f2), Matrix.ScaleToFit.FILL);
        } else if (rectF.width() / rectF.height() <= 1.7777778f) {
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        } else {
            float width2 = rectF2.width() * 0.5625f;
            float centerX = rectF2.centerX();
            float centerY2 = rectF2.centerY();
            float width3 = ((rectF.width() / rectF.height()) * width2) / 2.0f;
            float f3 = width2 / 2.0f;
            matrix.setRectToRect(rectF, new RectF(centerX - width3, centerY2 - f3, centerX + width3, centerY2 + f3), Matrix.ScaleToFit.FILL);
        }
    }

    public l b() {
        return this.a;
    }

    public float c() {
        return this.a.K();
    }

    public float d() {
        return this.a.M();
    }

    public float e() {
        return this.a.N();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.H();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.R(z);
    }

    @Override // us.pinguo.ui.uilview.PhotoImageView
    protected void setBgRect(RectF rectF) {
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        int i2 = this.b;
        int i3 = this.c;
        rectF.set(width - (i2 / 2), height - (i3 / 2), width + (i2 / 2), height + (i3 / 2));
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

    public void setLoadingBgSize(int i2, int i3) {
        this.b = i2;
        this.c = i3;
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
    }

    public void setZoomTransitionDuration(int i2) {
        this.a.p0(i2);
    }

    public void setZoomable(boolean z) {
        this.a.q0(z);
    }

    public void setScale(float f2, boolean z) {
        this.a.l0(f2, z);
    }

    public InfoTouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.a.k0(f2, f3, f4, z);
    }

    public InfoTouchImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
