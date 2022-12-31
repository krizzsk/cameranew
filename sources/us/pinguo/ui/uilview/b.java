package us.pinguo.ui.uilview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.ui.a;
import us.pinguo.ui.uilview.d;
/* compiled from: PhotoImgDrawable.java */
/* loaded from: classes6.dex */
public class b extends d {
    protected Paint mBgPaint;
    private boolean mDrawLoadingColor;
    protected int mLoadingColor;
    protected String mUri;

    /* compiled from: PhotoImgDrawable.java */
    /* loaded from: classes6.dex */
    protected class a extends us.pinguo.foundation.t.a.a implements Animator.AnimatorListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PhotoImgDrawable.java */
        /* renamed from: us.pinguo.ui.uilview.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0455a implements ValueAnimator.AnimatorUpdateListener {
            C0455a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public a(int i2, boolean z, boolean z2, boolean z3) {
            super(i2, z, z2, z3);
        }

        private void animate(int i2) {
            if (b.this.isVisible()) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
                ofInt.addUpdateListener(new C0455a());
                ofInt.setDuration(i2);
                ofInt.setInterpolator(new DecelerateInterpolator());
                ofInt.addListener(this);
                ofInt.start();
            }
        }

        @Override // us.pinguo.foundation.t.a.a, com.nostra13.universalimageloader.core.i.a
        public void display(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
            if (aVar instanceof d.a) {
                if (aVar.setImageBitmap(bitmap)) {
                    if ((this.animateFromNetwork && loadedFrom == LoadedFrom.NETWORK) || ((this.animateFromDisk && loadedFrom == LoadedFrom.DISC_CACHE) || (this.animateFromMemory && loadedFrom == LoadedFrom.MEMORY_CACHE))) {
                        animate(this.durationMillis);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("ImageAware should be UilDrawableAware.");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.mDrawLoadingColor = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public b() {
        this.mDrawLoadingColor = true;
    }

    private void initBgPaint() {
        Paint paint = new Paint();
        this.mBgPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mBgPaint.setColor(this.mLoadingColor);
    }

    @Override // us.pinguo.foundation.t.a.b, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDrawLoadingColor && this.mLoadingColor != 0) {
            if (this.mBgPaint == null) {
                initBgPaint();
            }
            RectF rectF = this.mRect;
            float f2 = this.mCornerRadius;
            canvas.drawRoundRect(rectF, f2, f2, this.mBgPaint);
        }
        super.draw(canvas);
    }

    public String getUri() {
        return this.mUri;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.d
    public void init() {
        this.mImageAware = new d.a();
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.A(ImageScaleType.EXACTLY);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(false);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.y(new a(400, true, true, false));
        bVar.D(true);
        this.mDisplayImageOptions = bVar.t();
    }

    @Override // us.pinguo.ui.uilview.d, com.nostra13.universalimageloader.core.k.a
    public void onLoadingStarted(String str, View view) {
        boolean z = !this.mDrawLoadingColor;
        this.mDrawLoadingColor = true;
        if (z) {
            invalidateSelf();
        }
        super.onLoadingStarted(str, view);
    }

    public void resetDisplayImageOptions() {
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.A(ImageScaleType.EXACTLY);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(false);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.y(new a(400, true, true, false));
        bVar.D(true);
        this.mDisplayImageOptions = bVar.t();
    }

    @Override // us.pinguo.ui.uilview.d
    public void setImageUri(String str) {
        setImageUri(str, false);
    }

    public void setLoadingColor(int i2) {
        this.mLoadingColor = i2;
        if (this.mBgPaint == null) {
            initBgPaint();
        }
        this.mBgPaint.setColor(this.mLoadingColor);
    }

    public void setImageUri(String str, boolean z) {
        String addQiNiuSuffix = PhotoImageView.addQiNiuSuffix(str, this.mWidth, this.mHeight, z);
        super.setImageUri(addQiNiuSuffix);
        this.mUri = addQiNiuSuffix;
    }

    public b(Bitmap bitmap, int i2, int i3) {
        super(bitmap, i2, i3);
        this.mDrawLoadingColor = true;
    }

    public void setImageUri(String str, int i2, int i3, boolean z) {
        String addQiNiuSuffix = PhotoImageView.addQiNiuSuffix(str, i2, i3, z);
        super.setImageUri(addQiNiuSuffix);
        this.mUri = addQiNiuSuffix;
    }
}
