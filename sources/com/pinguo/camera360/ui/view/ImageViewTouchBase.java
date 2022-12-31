package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class ImageViewTouchBase extends ImageView {
    protected Matrix a;
    protected Matrix b;
    private final Matrix c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f7047d;

    /* renamed from: e  reason: collision with root package name */
    protected final com.pinguo.camera360.ui.view.b f7048e;

    /* renamed from: f  reason: collision with root package name */
    int f7049f;

    /* renamed from: g  reason: collision with root package name */
    int f7050g;

    /* renamed from: h  reason: collision with root package name */
    float f7051h;

    /* renamed from: i  reason: collision with root package name */
    private c f7052i;

    /* renamed from: j  reason: collision with root package name */
    protected Handler f7053j;

    /* renamed from: k  reason: collision with root package name */
    private Runnable f7054k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ com.pinguo.camera360.ui.view.b a;
        final /* synthetic */ boolean b;

        a(com.pinguo.camera360.ui.view.b bVar, boolean z) {
            this.a = bVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageViewTouchBase.this.setImageRotateBitmapResetBase(this.a, this.b);
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {
        final /* synthetic */ float a;
        final /* synthetic */ long b;
        final /* synthetic */ float c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f7055d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f7056e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ float f7057f;

        b(float f2, long j2, float f3, float f4, float f5, float f6) {
            this.a = f2;
            this.b = j2;
            this.c = f3;
            this.f7055d = f4;
            this.f7056e = f5;
            this.f7057f = f6;
        }

        @Override // java.lang.Runnable
        public void run() {
            float min = Math.min(this.a, (float) (System.currentTimeMillis() - this.b));
            ImageViewTouchBase.this.m(this.c + (this.f7055d * min), this.f7056e, this.f7057f);
            if (min < this.a) {
                ImageViewTouchBase.this.f7053j.post(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.f7047d = new float[9];
        this.f7048e = new com.pinguo.camera360.ui.view.b(null);
        this.f7049f = -1;
        this.f7050g = -1;
        this.f7053j = new Handler();
        this.f7054k = null;
        g();
    }

    private void c(com.pinguo.camera360.ui.view.b bVar, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float e2 = bVar.e();
        float b2 = bVar.b();
        matrix.reset();
        float min = Math.min(Math.min(width / e2, 2.0f), Math.min(height / b2, 2.0f));
        matrix.postConcat(bVar.c());
        matrix.postScale(min, min);
        matrix.postTranslate((width - (e2 * min)) / 2.0f, (height - (b2 * min)) / 2.0f);
    }

    private void g() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void k(Bitmap bitmap, int i2) {
        c cVar;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap a2 = this.f7048e.a();
        this.f7048e.g(bitmap);
        this.f7048e.h(i2);
        if (a2 == null || a2 == bitmap || (cVar = this.f7052i) == null) {
            return;
        }
        cVar.a(a2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
        if (r0 < r7) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.pinguo.camera360.ui.view.b r0 = r6.f7048e
            android.graphics.Bitmap r0 = r0.a()
            if (r0 != 0) goto L9
            return
        L9:
            android.graphics.Matrix r0 = r6.b()
            android.graphics.RectF r1 = new android.graphics.RectF
            com.pinguo.camera360.ui.view.b r2 = r6.f7048e
            android.graphics.Bitmap r2 = r2.a()
            int r2 = r2.getWidth()
            float r2 = (float) r2
            com.pinguo.camera360.ui.view.b r3 = r6.f7048e
            android.graphics.Bitmap r3 = r3.a()
            int r3 = r3.getHeight()
            float r3 = (float) r3
            r4 = 0
            r1.<init>(r4, r4, r2, r3)
            r0.mapRect(r1)
            float r0 = r1.height()
            float r2 = r1.width()
            r3 = 1073741824(0x40000000, float:2.0)
            if (r8 == 0) goto L5d
            int r8 = r6.getHeight()
            float r8 = (float) r8
            int r5 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r5 >= 0) goto L47
            float r8 = r8 - r0
            float r8 = r8 / r3
            float r0 = r1.top
        L45:
            float r8 = r8 - r0
            goto L5e
        L47:
            float r0 = r1.top
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 <= 0) goto L4f
            float r8 = -r0
            goto L5e
        L4f:
            float r0 = r1.bottom
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 >= 0) goto L5d
            int r8 = r6.getHeight()
            float r8 = (float) r8
            float r0 = r1.bottom
            goto L45
        L5d:
            r8 = 0
        L5e:
            if (r7 == 0) goto L7f
            int r7 = r6.getWidth()
            float r7 = (float) r7
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 >= 0) goto L70
            float r7 = r7 - r2
            float r7 = r7 / r3
            float r0 = r1.left
        L6d:
            float r4 = r7 - r0
            goto L7f
        L70:
            float r0 = r1.left
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L78
            float r4 = -r0
            goto L7f
        L78:
            float r0 = r1.right
            int r1 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r1 >= 0) goto L7f
            goto L6d
        L7f:
            r6.j(r4, r8)
            android.graphics.Matrix r7 = r6.b()
            r6.setImageMatrix(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.ui.view.ImageViewTouchBase.a(boolean, boolean):void");
    }

    protected Matrix b() {
        this.c.set(this.a);
        this.c.postConcat(this.b);
        return this.c;
    }

    public float d() {
        return e(this.b);
    }

    protected float e(Matrix matrix) {
        return f(matrix, 0);
    }

    protected float f(Matrix matrix, int i2) {
        matrix.getValues(this.f7047d);
        return this.f7047d[i2];
    }

    protected float h() {
        if (this.f7048e.a() == null) {
            return 1.0f;
        }
        return Math.max(this.f7048e.e() / this.f7049f, this.f7048e.b() / this.f7050g) * 4.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(float f2, float f3) {
        j(f2, f3);
        setImageMatrix(b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(float f2, float f3) {
        this.b.postTranslate(f2, f3);
    }

    protected void l(float f2) {
        m(f2, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(float f2, float f3, float f4) {
        float f5 = this.f7051h;
        if (f2 > f5) {
            f2 = f5;
        }
        float d2 = f2 / d();
        this.b.postScale(d2, d2, f3, f4);
        setImageMatrix(b());
        a(true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(float f2, float f3, float f4, float f5) {
        float d2 = (f2 - d()) / f5;
        float d3 = d();
        this.f7053j.post(new b(f5, System.currentTimeMillis(), d3, d2, f3, f4));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && d() > 1.0f) {
            l(1.0f);
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f7049f = i4 - i2;
        this.f7050g = i5 - i3;
        Runnable runnable = this.f7054k;
        if (runnable != null) {
            this.f7054k = null;
            runnable.run();
        }
        if (this.f7048e.a() != null) {
            c(this.f7048e, this.a);
            setImageMatrix(b());
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        k(bitmap, 0);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean z) {
        setImageRotateBitmapResetBase(new com.pinguo.camera360.ui.view.b(bitmap), z);
    }

    public void setImageRotateBitmapResetBase(com.pinguo.camera360.ui.view.b bVar, boolean z) {
        if (getWidth() <= 0) {
            this.f7054k = new a(bVar, z);
            return;
        }
        if (bVar.a() != null) {
            c(bVar, this.a);
            k(bVar.a(), bVar.d());
        } else {
            this.a.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.b.reset();
        }
        setImageMatrix(b());
        this.f7051h = h();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.f7047d = new float[9];
        this.f7048e = new com.pinguo.camera360.ui.view.b(null);
        this.f7049f = -1;
        this.f7050g = -1;
        this.f7053j = new Handler();
        this.f7054k = null;
        g();
    }
}
