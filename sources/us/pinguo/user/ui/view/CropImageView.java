package us.pinguo.user.ui.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import us.pinguo.user.R;
import us.pinguo.util.j;
import us.pinguo.util.n;
/* loaded from: classes6.dex */
public class CropImageView extends View implements ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnGestureListener {
    private int A;
    private int B;
    private int C;
    private Bitmap D;
    private int E;
    private ScaleGestureDetector a;
    private GestureDetector b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    protected Matrix f12449d;

    /* renamed from: e  reason: collision with root package name */
    protected Bitmap f12450e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f12451f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f12452g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f12453h;

    /* renamed from: i  reason: collision with root package name */
    private RectF f12454i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12455j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12456k;

    /* renamed from: l  reason: collision with root package name */
    private float f12457l;
    private float m;
    private float n;
    private String o;
    private int p;
    private int q;
    private ValueAnimator r;
    private us.pinguo.user.ui.view.a s;
    private float t;
    private Paint u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private RectF z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CropImageView.this.f12449d.set((Matrix) valueAnimator.getAnimatedValue());
            CropImageView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CropImageView.this.f12456k = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12451f = new RectF();
        this.f12452g = new RectF();
        this.f12453h = new RectF();
        this.f12454i = new RectF();
        this.p = 1;
        this.s = new us.pinguo.user.ui.view.a();
        this.w = true;
        this.z = new RectF();
        this.C = 0;
        this.a = new ScaleGestureDetector(getContext(), this);
        this.b = new GestureDetector(getContext(), this);
        this.f12449d = new Matrix();
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
        this.v = us.pinguo.foundation.t.b.a.a(context, 3.0f);
    }

    private void c() {
        int i2;
        float f2;
        float f3;
        if (this.f12450e == null || this.f12449d == null) {
            return;
        }
        Matrix matrix = new Matrix();
        this.f12456k = true;
        this.f12451f.set(0.0f, 0.0f, this.f12450e.getWidth(), this.f12450e.getHeight());
        this.f12449d.mapRect(this.f12451f);
        float width = this.f12451f.width();
        float height = this.f12451f.height();
        boolean z = ((width > height ? 1 : (width == height ? 0 : -1)) < 0 ? width : height) < this.n * 2.0f;
        if (!this.w) {
            RectF rectF = this.f12453h;
            if (width < rectF.right - rectF.left || height < rectF.bottom - rectF.top) {
                z = true;
            }
        }
        RectF rectF2 = this.f12451f;
        float f4 = rectF2.left;
        float f5 = rectF2.top;
        float f6 = rectF2.right;
        float f7 = rectF2.bottom;
        if (z) {
            i(matrix, this.f12453h, true);
        } else {
            RectF rectF3 = new RectF(this.f12451f);
            if (this.w) {
                float f8 = this.f12457l;
                float f9 = this.n;
                f2 = f4 > f8 - f9 ? (f8 - f9) - f4 : f6 < f8 + f9 ? (f8 + f9) - f6 : 0.0f;
                float f10 = this.m;
                if (f5 > f10 - f9) {
                    r5 = (f10 - f9) - f5;
                } else if (f7 < f10 + f9) {
                    f3 = f10 + f9;
                    r5 = f3 - f7;
                }
                rectF3.offset(f2, r5);
                i(matrix, rectF3, false);
            } else {
                int i3 = this.B;
                float f11 = f4 > ((float) i3) ? i3 - f4 : 0.0f;
                f2 = f6 < ((float) (this.x - i3)) ? (i2 - i3) - f6 : f11;
                int i4 = this.y;
                r5 = f5 > ((float) i4) ? i4 - f5 : 0.0f;
                int i5 = this.E;
                if (f7 < i5) {
                    f3 = i5;
                    r5 = f3 - f7;
                }
                rectF3.offset(f2, r5);
                i(matrix, rectF3, false);
            }
        }
        if (this.r == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(this.s, new Matrix(this.f12449d), matrix);
            this.r = ofObject;
            ofObject.addUpdateListener(new a());
            this.r.addListener(new b());
            this.r.setDuration(300L);
        }
        this.r.setObjectValues(new Matrix(this.f12449d), matrix);
        this.r.start();
    }

    private void e(Canvas canvas) {
        this.u.setColor(Color.argb(170, 0, 0, 0));
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setStrokeWidth((this.t - this.n) + this.v);
        float f2 = this.t;
        float f3 = this.n;
        canvas.drawCircle(this.f12457l, this.m, ((f2 - f3) / 2.0f) + f3, this.u);
    }

    private void f(Canvas canvas) {
        this.u.setColor(Color.argb(170, 0, 0, 0));
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setStrokeWidth(this.A);
        canvas.drawRect(this.z, this.u);
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setColor(-1);
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f12452g, this.u);
            return;
        }
        this.u.setStrokeWidth(this.v);
        canvas.drawRect(this.f12452g, this.u);
    }

    private void g(Canvas canvas) {
        e(canvas);
        this.u.setStyle(Paint.Style.STROKE);
        this.u.setColor(-1);
        this.u.setStrokeWidth(this.v);
        canvas.drawCircle(this.f12457l, this.m, this.n, this.u);
    }

    private void i(Matrix matrix, RectF rectF, boolean z) {
        float height;
        float height2;
        Bitmap bitmap = this.f12450e;
        if (bitmap == null || matrix == null) {
            return;
        }
        this.f12451f.set(0.0f, 0.0f, bitmap.getWidth(), this.f12450e.getHeight());
        int i2 = this.q;
        if (i2 != 0) {
            matrix.setRotate(i2, this.f12451f.centerX(), this.f12451f.centerY());
            matrix.mapRect(this.f12451f);
        }
        this.f12454i.set(this.f12451f);
        matrix.setRectToRect(this.f12451f, rectF, Matrix.ScaleToFit.CENTER);
        int i3 = this.q;
        if (i3 != 0) {
            matrix.postRotate(i3, rectF.centerX(), rectF.centerY());
        }
        matrix.mapRect(this.f12454i);
        if (z) {
            float f2 = 1.0f;
            if (this.f12454i.width() < rectF.width()) {
                height = rectF.width();
                height2 = this.f12454i.width();
            } else {
                if (this.f12454i.height() < rectF.height()) {
                    height = rectF.height();
                    height2 = this.f12454i.height();
                }
                matrix.postScale(f2, f2, rectF.centerX(), rectF.centerY());
            }
            f2 = height / height2;
            matrix.postScale(f2, f2, rectF.centerX(), rectF.centerY());
        }
    }

    private Bitmap j(String str, int i2, boolean z) {
        Bitmap decodeResource;
        if (!z || (str != null && new File(str).exists())) {
            int d2 = n.d();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (z) {
                BitmapFactory.decodeFile(str, options);
            } else {
                BitmapFactory.decodeResource(getResources(), i2);
            }
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            options.inJustDecodeBounds = false;
            if (i4 > i3) {
                i3 = i4;
            }
            float f2 = i3 / d2;
            if (f2 < 1.0f) {
                f2 = ((options.outHeight * options.outWidth) * 4) / (((float) Runtime.getRuntime().maxMemory()) * 0.5f);
            }
            if (f2 <= 1.0f) {
                options.inSampleSize = 1;
            } else {
                int i5 = (int) (f2 + 1.0f);
                options.inSampleSize = i5;
                if (i5 % 2 != 0) {
                    options.inSampleSize = i5 - 1;
                }
            }
            this.p = options.inSampleSize;
            for (int i6 = 0; i6 < 5; i6++) {
                if (i6 != 0) {
                    try {
                        int i7 = this.p * 2;
                        this.p = i7;
                        options.inSampleSize = i7;
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
                if (z) {
                    decodeResource = BitmapFactory.decodeFile(str, options);
                } else {
                    decodeResource = BitmapFactory.decodeResource(getResources(), i2, options);
                }
                return decodeResource;
            }
            return null;
        }
        return null;
    }

    private Bitmap l(Bitmap bitmap, int i2) {
        if (bitmap == null || i2 == 0) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        Matrix matrix = new Matrix();
        matrix.setRotate(i2);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            this.q = i2;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    private void n() {
        if (this.f12450e == null) {
            return;
        }
        if (this.f12453h.width() <= 0.0f && this.f12453h.height() <= 0.0f) {
            this.f12455j = false;
            return;
        }
        this.f12455j = true;
        RectF rectF = new RectF(this.f12452g);
        if (this.f12450e.getWidth() <= this.f12450e.getHeight()) {
            float height = (this.f12450e.getHeight() / this.f12450e.getWidth()) * rectF.width();
            float centerY = rectF.centerY();
            float f2 = height / 2.0f;
            rectF.top = centerY - f2;
            rectF.bottom = centerY + f2;
            i(this.f12449d, rectF, true);
            return;
        }
        float centerY2 = this.f12452g.centerY();
        rectF.top = centerY2 - (this.f12452g.width() / 2.0f);
        rectF.bottom = centerY2 + (this.f12452g.width() / 2.0f);
        float width = (this.f12450e.getWidth() / this.f12450e.getHeight()) * rectF.height();
        float centerX = rectF.centerX();
        float f3 = width / 2.0f;
        rectF.left = centerX - f3;
        rectF.right = centerX + f3;
        i(this.f12449d, rectF, true);
    }

    public String d() {
        if (this.f12450e == null) {
            return null;
        }
        this.f12454i.set(this.f12453h);
        Matrix matrix = new Matrix();
        this.f12449d.invert(matrix);
        matrix.mapRect(this.f12454i);
        int i2 = this.p;
        matrix.setScale(i2, i2);
        matrix.mapRect(this.f12454i);
        Rect rect = new Rect();
        RectF rectF = this.f12454i;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(this.o, false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (this.w) {
                int i3 = rect.right;
                int i4 = rect.left;
                if (i3 - i4 > 512) {
                    int ceil = (int) Math.ceil((i3 - i4) / 512.0f);
                    if (ceil % 2 != 0) {
                        ceil++;
                    }
                    options.inSampleSize = ceil;
                }
            }
            us.pinguo.common.log.a.m("zhouwei", "top:" + rect.top + " left:" + rect.left + " right:" + rect.right + " bottom:" + rect.bottom, new Object[0]);
            Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
            int i5 = this.q;
            if (i5 != 0) {
                decodeRegion = l(decodeRegion, i5);
            }
            us.pinguo.common.log.a.m("zhouwei", "bitmapWidth:" + decodeRegion.getWidth() + " bitmapHeight:" + decodeRegion.getHeight(), new Object[0]);
            return m(decodeRegion);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void h() {
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.r.end();
    }

    public boolean k() {
        return this.f12456k;
    }

    public String m(Bitmap bitmap) throws IOException {
        String str = getContext().getExternalCacheDir() + File.separator + "crop_temp.png";
        File file = new File(str);
        try {
            file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (!file.exists()) {
            str = getContext().getCacheDir() + File.separator + "crop_temp.png";
            file = new File(str);
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        try {
            fileOutputStream.flush();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return str;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f12450e;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, this.f12449d, null);
        if (this.w) {
            g(canvas);
        } else {
            f(canvas);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            n();
            invalidate();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.w) {
            us.pinguo.common.log.a.m("zhouwei", "circle rect", new Object[0]);
            this.f12457l = getMeasuredWidth() / 2.0f;
            this.m = getMeasuredHeight() / 2.0f;
            if (!this.f12455j) {
                n();
            }
            this.f12452g.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            RectF rectF = this.f12453h;
            float f2 = this.f12457l;
            float f3 = this.n;
            float f4 = this.m;
            rectF.set(f2 - f3, f4 - f3, f2 + f3, f4 + f3);
            this.n = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) * 0.4f;
            this.t = Math.max(us.pinguo.foundation.t.b.a.j(getContext()), us.pinguo.foundation.t.b.a.h(getContext()));
            return;
        }
        us.pinguo.common.log.a.m("zhouwei", "retangle rect", new Object[0]);
        if (!this.f12455j) {
            n();
        }
        int a2 = us.pinguo.foundation.t.b.a.a(getContext(), 8.0f);
        this.B = a2;
        int j2 = us.pinguo.foundation.t.b.a.j(getContext());
        int a3 = (int) ((((j2 - (a2 * 2)) * 1.0d) * us.pinguo.foundation.t.b.a.a(getContext(), 244.0f)) / j2);
        int measuredHeight = getMeasuredHeight();
        this.x = j2;
        int i4 = measuredHeight - a3;
        int i5 = i4 / 2;
        this.y = i5;
        this.E = i5 + a3;
        float f5 = a2;
        float f6 = i5;
        float f7 = j2 - a2;
        float f8 = (measuredHeight + a3) / 2;
        this.f12452g.set(f5, f6, f7, f8);
        this.f12453h.set(f5, f6, f7, f8);
        this.A = i4;
        RectF rectF2 = this.z;
        rectF2.left = ((-i4) / 2) + a2;
        rectF2.top = 0.0f;
        rectF2.right = (j2 + (i4 / 2)) - a2;
        rectF2.bottom = i4 + a3;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        this.f12449d.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        invalidate();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f12449d.postTranslate(-f2, -f3);
        invalidate();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.c = false;
        }
        if (!this.c && motionEvent.getPointerCount() > 1) {
            this.c = true;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            c();
        }
        if (this.c) {
            return this.a.onTouchEvent(motionEvent);
        }
        return this.b.onTouchEvent(motionEvent);
    }

    public void setCircle(boolean z) {
        this.w = z;
        if (z) {
            return;
        }
        this.D = j(null, R.drawable.crop_cover_grid, false);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f12450e = bitmap;
        n();
        invalidate();
    }

    public void setImageFile(String str) {
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            setImageBitmap(null);
        }
        this.q = j.l(str);
        setImageBitmap(j(str, this.C, true));
    }
}
