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
import us.pinguo.inspire.widget.fresco.PhotoDraweeView;
/* loaded from: classes9.dex */
public class InfoTouchDraweeView extends PhotoDraweeView implements m {
    private l m;

    public InfoTouchDraweeView(Context context) {
        super(context);
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

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.m.H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.widget.fresco.PhotoDraweeView
    public void n() {
        super.n();
        this.m = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.m.n0(169);
        this.m.o0(this);
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.m.R(z);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i2, int i3, int i4, int i5) {
        boolean frame = super.setFrame(i2, i3, i4, i5);
        if (frame) {
            this.m.r0();
        }
        return frame;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.m;
        if (lVar != null) {
            lVar.r0();
        }
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView, com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int i2) {
        super.setImageResource(i2);
        l lVar = this.m;
        if (lVar != null) {
            lVar.r0();
        }
    }

    @Override // com.facebook.drawee.view.SimpleDraweeView, com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.m;
        if (lVar != null) {
            lVar.r0();
        }
    }

    public void setMaximumScale(float f2) {
        this.m.U(f2);
    }

    public void setMediumScale(float f2) {
        this.m.V(f2);
    }

    public void setMinimumScale(float f2) {
        this.m.W(f2);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.m.X(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.m.Y(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.m.Z(onLongClickListener);
    }

    public void setOnMatrixChangeListener(e eVar) {
        this.m.a0(eVar);
    }

    public void setOnOutsidePhotoTapListener(f fVar) {
        this.m.b0(fVar);
    }

    public void setOnPhotoTapListener(g gVar) {
        this.m.c0(gVar);
    }

    public void setOnScaleChangeListener(h hVar) {
        this.m.d0(hVar);
    }

    public void setOnSingleFlingListener(i iVar) {
        this.m.e0(iVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.m.f0(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.m.g0(kVar);
    }

    public void setRotationBy(float f2) {
        this.m.h0(f2);
    }

    public void setRotationTo(float f2) {
        this.m.i0(f2);
    }

    public void setScale(float f2) {
        this.m.j0(f2);
    }

    public void setScaleLevels(float f2, float f3, float f4) {
        this.m.m0(f2, f3, f4);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public void setZoomTransitionDuration(int i2) {
        this.m.p0(i2);
    }

    public void setZoomable(boolean z) {
        this.m.q0(z);
    }

    public InfoTouchDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScale(float f2, boolean z) {
        this.m.l0(f2, z);
    }

    public InfoTouchDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setScale(float f2, float f3, float f4, boolean z) {
        this.m.k0(f2, f3, f4, z);
    }
}
