package us.pinguo.picker.image.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: PinchImageView.kt */
/* loaded from: classes5.dex */
public final class PinchImageView extends SimpleDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private View.OnClickListener f11733i;

    /* renamed from: j  reason: collision with root package name */
    private View.OnLongClickListener f11734j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f11735k;

    /* renamed from: l  reason: collision with root package name */
    private RectF f11736l;
    private int m;
    private List<f> n;
    private List<f> o;
    private int p;
    private b q;
    private final PointF r;
    private final PointF s;
    private float t;
    private h u;
    private a v;
    private final GestureDetector w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public final class a extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private final float[] a;
        final /* synthetic */ PinchImageView b;

        public a(PinchImageView this$0, float f2, float f3) {
            s.h(this$0, "this$0");
            this.b = this$0;
            setFloatValues(0.0f, 1.0f);
            setDuration(1000000L);
            addUpdateListener(this);
            this.a = new float[]{f2, f3};
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            s.h(animation, "animation");
            PinchImageView pinchImageView = this.b;
            float[] fArr = this.a;
            boolean L = pinchImageView.L(fArr[0], fArr[1]);
            float[] fArr2 = this.a;
            fArr2[0] = fArr2[0] * 0.9f;
            fArr2[1] = fArr2[1] * 0.9f;
            if (!L || c.a.b(0.0f, 0.0f, fArr2[0], fArr2[1]) < 1.0f) {
                animation.cancel();
            }
        }
    }

    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    private final class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
    }

    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public static final class c {
        public static final c a = new c();
        private static final d b = new d(16);
        private static final g c = new g(16);

        private c() {
        }

        public final float[] a(float f2, float f3, float f4, float f5) {
            return new float[]{(f2 + f4) / 2.0f, (f3 + f5) / 2.0f};
        }

        public final float b(float f2, float f3, float f4, float f5) {
            float f6 = f2 - f4;
            float f7 = f3 - f5;
            return (float) Math.sqrt((f6 * f6) + (f7 * f7));
        }

        public final float[] c(Matrix matrix) {
            if (matrix != null) {
                float[] fArr = new float[9];
                matrix.getValues(fArr);
                return new float[]{fArr[0], fArr[4]};
            }
            return new float[2];
        }

        public final float[] d(float[] fArr, Matrix matrix) {
            if (fArr == null || matrix == null) {
                return new float[2];
            }
            float[] fArr2 = new float[2];
            Matrix f2 = f();
            matrix.invert(f2);
            f2.mapPoints(fArr2, fArr);
            e(f2);
            return fArr2;
        }

        public final void e(Matrix matrix) {
            s.h(matrix, "matrix");
            b.a(matrix);
        }

        public final Matrix f() {
            return b.d();
        }

        public final Matrix g(Matrix matrix) {
            Matrix d2 = b.d();
            if (matrix != null) {
                d2.set(matrix);
            }
            return d2;
        }

        public final void h(RectF rectF) {
            s.h(rectF, "rectF");
            c.a(rectF);
        }

        public final RectF i() {
            return c.d();
        }

        public final RectF j(float f2, float f3, float f4, float f5) {
            RectF d2 = c.d();
            d2.set(f2, f3, f4, f5);
            return d2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public static final class d extends e<Matrix> {
        public d(int i2) {
            super(i2);
        }

        @Override // us.pinguo.picker.image.view.PinchImageView.e
        public /* bridge */ /* synthetic */ Matrix c(Matrix matrix) {
            Matrix matrix2 = matrix;
            f(matrix2);
            return matrix2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.picker.image.view.PinchImageView.e
        /* renamed from: e */
        public Matrix b() {
            return new Matrix();
        }

        protected Matrix f(Matrix obj) {
            s.h(obj, "obj");
            obj.reset();
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public static abstract class e<T> {
        private final int a;
        private final Queue<T> b = new LinkedList();

        public e(int i2) {
            this.a = i2;
        }

        public final void a(T t) {
            if (t == null || this.b.size() >= this.a) {
                return;
            }
            this.b.offer(t);
        }

        protected abstract T b();

        protected abstract T c(T t);

        public final T d() {
            if (this.b.size() == 0) {
                return b();
            }
            return c(this.b.poll());
        }
    }

    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public interface f {
        void a(PinchImageView pinchImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public static final class g extends e<RectF> {
        public g(int i2) {
            super(i2);
        }

        @Override // us.pinguo.picker.image.view.PinchImageView.e
        public /* bridge */ /* synthetic */ RectF c(RectF rectF) {
            RectF rectF2 = rectF;
            f(rectF2);
            return rectF2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.picker.image.view.PinchImageView.e
        /* renamed from: e */
        public RectF b() {
            return new RectF();
        }

        protected RectF f(RectF obj) {
            s.h(obj, "obj");
            obj.setEmpty();
            return obj;
        }
    }

    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public static final class i extends GestureDetector.SimpleOnGestureListener {
        i() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
            if (r0.isRunning() == false) goto L7;
         */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onDoubleTap(android.view.MotionEvent r4) {
            /*
                r3 = this;
                java.lang.String r0 = "e"
                kotlin.jvm.internal.s.h(r4, r0)
                us.pinguo.picker.image.view.PinchImageView r0 = us.pinguo.picker.image.view.PinchImageView.this
                int r0 = r0.E()
                r1 = 1
                if (r0 != r1) goto L32
                us.pinguo.picker.image.view.PinchImageView r0 = us.pinguo.picker.image.view.PinchImageView.this
                us.pinguo.picker.image.view.PinchImageView$h r0 = us.pinguo.picker.image.view.PinchImageView.t(r0)
                if (r0 == 0) goto L25
                us.pinguo.picker.image.view.PinchImageView r0 = us.pinguo.picker.image.view.PinchImageView.this
                us.pinguo.picker.image.view.PinchImageView$h r0 = us.pinguo.picker.image.view.PinchImageView.t(r0)
                kotlin.jvm.internal.s.e(r0)
                boolean r0 = r0.isRunning()
                if (r0 != 0) goto L32
            L25:
                us.pinguo.picker.image.view.PinchImageView r0 = us.pinguo.picker.image.view.PinchImageView.this
                float r2 = r4.getX()
                float r4 = r4.getY()
                us.pinguo.picker.image.view.PinchImageView.o(r0, r2, r4)
            L32:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.picker.image.view.PinchImageView.i.onDoubleTap(android.view.MotionEvent):boolean");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float f2, float f3) {
            s.h(e1, "e1");
            s.h(e2, "e2");
            if (PinchImageView.this.E() == 0) {
                if (PinchImageView.this.u != null) {
                    h hVar = PinchImageView.this.u;
                    s.e(hVar);
                    if (hVar.isRunning()) {
                        return true;
                    }
                }
                PinchImageView.this.z(f2, f3);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e2) {
            s.h(e2, "e");
            if (PinchImageView.this.f11734j != null) {
                View.OnLongClickListener onLongClickListener = PinchImageView.this.f11734j;
                s.e(onLongClickListener);
                onLongClickListener.onLongClick(PinchImageView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e2) {
            s.h(e2, "e");
            if (PinchImageView.this.f11733i != null) {
                View.OnClickListener onClickListener = PinchImageView.this.f11733i;
                s.e(onClickListener);
                onClickListener.onClick(PinchImageView.this);
                return true;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinchImageView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.f11735k = new Matrix();
        this.r = new PointF();
        this.s = new PointF();
        this.w = new GestureDetector(getContext(), new i());
        F();
    }

    private final void F() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    private final boolean G() {
        return getDrawable() != null && getDrawable().getIntrinsicWidth() > 0 && getDrawable().getIntrinsicHeight() > 0 && getWidth() > 0 && getHeight() > 0;
    }

    private final void I(float f2, float f3, float f4, float f5) {
        c cVar = c.a;
        this.t = cVar.c(this.f11735k)[0] / cVar.b(f2, f3, f4, f5);
        float[] d2 = cVar.d(cVar.a(f2, f3, f4, f5), this.f11735k);
        this.s.set(d2[0], d2[1]);
    }

    private final void J(PointF pointF, float f2, float f3, PointF pointF2) {
        if (G()) {
            float f4 = f2 * f3;
            c cVar = c.a;
            Matrix f5 = cVar.f();
            f5.postScale(f4, f4, pointF.x, pointF.y);
            f5.postTranslate(pointF2.x - pointF.x, pointF2.y - pointF.y);
            this.f11735k.set(f5);
            cVar.e(f5);
            x();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void K() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.picker.image.view.PinchImageView.K():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean L(float r10, float r11) {
        /*
            r9 = this;
            boolean r0 = r9.G()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            us.pinguo.picker.image.view.PinchImageView$c r0 = us.pinguo.picker.image.view.PinchImageView.c.a
            android.graphics.RectF r2 = r0.i()
            r9.B(r2)
            int r3 = r9.getWidth()
            float r3 = (float) r3
            int r4 = r9.getHeight()
            float r4 = (float) r4
            float r5 = r2.right
            float r6 = r2.left
            float r7 = r5 - r6
            r8 = 0
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 >= 0) goto L28
        L26:
            r10 = 0
            goto L40
        L28:
            float r7 = r6 + r10
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L34
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L26
            float r10 = -r6
            goto L40
        L34:
            float r6 = r5 + r10
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 >= 0) goto L40
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 <= 0) goto L26
            float r3 = r3 - r5
            r10 = r3
        L40:
            float r3 = r2.bottom
            float r5 = r2.top
            float r6 = r3 - r5
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 >= 0) goto L4c
        L4a:
            r11 = 0
            goto L64
        L4c:
            float r6 = r5 + r11
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L58
            int r11 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r11 >= 0) goto L4a
            float r11 = -r5
            goto L64
        L58:
            float r5 = r3 + r11
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 >= 0) goto L64
            int r11 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r11 <= 0) goto L4a
            float r4 = r4 - r3
            r11 = r4
        L64:
            r0.h(r2)
            android.graphics.Matrix r0 = r9.f11735k
            r0.postTranslate(r10, r11)
            r9.x()
            r9.invalidate()
            r0 = 1
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 != 0) goto L79
            r10 = 1
            goto L7a
        L79:
            r10 = 0
        L7a:
            if (r10 == 0) goto L85
            int r10 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r10 != 0) goto L82
            r10 = 1
            goto L83
        L82:
            r10 = 0
        L83:
            if (r10 != 0) goto L86
        L85:
            r1 = 1
        L86:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.picker.image.view.PinchImageView.L(float, float):boolean");
    }

    private final void w() {
        h hVar = this.u;
        if (hVar != null) {
            s.e(hVar);
            hVar.cancel();
            this.u = null;
        }
        a aVar = this.v;
        if (aVar != null) {
            s.e(aVar);
            aVar.cancel();
            this.v = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        List<f> list;
        List<f> list2 = this.n;
        if (list2 == null) {
            return;
        }
        this.p++;
        s.e(list2);
        for (f fVar : list2) {
            fVar.a(this);
        }
        int i2 = this.p - 1;
        this.p = i2;
        if (i2 != 0 || (list = this.o) == null) {
            return;
        }
        this.n = list;
        this.o = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(float f2, float f3) {
        if (G()) {
            c cVar = c.a;
            Matrix f4 = cVar.f();
            C(f4);
            float f5 = cVar.c(f4)[0];
            float f6 = cVar.c(this.f11735k)[0];
            float f7 = f5 * f6;
            float width = getWidth();
            float height = getHeight();
            float D = D();
            float v = v(f5, f6);
            if (v <= D) {
                D = v;
            }
            if (D >= f5) {
                f5 = D;
            }
            Matrix g2 = cVar.g(this.f11735k);
            float f8 = f5 / f7;
            g2.postScale(f8, f8, f2, f3);
            float f9 = width / 2.0f;
            float f10 = height / 2.0f;
            g2.postTranslate(f9 - f2, f10 - f3);
            Matrix g3 = cVar.g(f4);
            g3.postConcat(g2);
            float f11 = 0.0f;
            RectF j2 = cVar.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            g3.mapRect(j2);
            float f12 = j2.right;
            float f13 = j2.left;
            float f14 = f12 - f13 < width ? f9 - ((f12 + f13) / 2.0f) : f13 > 0.0f ? -f13 : f12 < width ? width - f12 : 0.0f;
            float f15 = j2.bottom;
            float f16 = j2.top;
            if (f15 - f16 < height) {
                f11 = f10 - ((f15 + f16) / 2.0f);
            } else if (f16 > 0.0f) {
                f11 = -f16;
            } else if (f15 < height) {
                f11 = height - f15;
            }
            g2.postTranslate(f14, f11);
            w();
            h hVar = new h(this.f11735k, g2, 0L, 4, null);
            this.u = hVar;
            s.e(hVar);
            hVar.start();
            cVar.h(j2);
            cVar.e(g3);
            cVar.e(g2);
            cVar.e(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(float f2, float f3) {
        if (G()) {
            w();
            a aVar = new a(this, f2 / 60.0f, f3 / 60.0f);
            this.v = aVar;
            s.e(aVar);
            aVar.start();
        }
    }

    public final Matrix A(Matrix matrix) {
        s.h(matrix, "matrix");
        Matrix C = C(matrix);
        C.postConcat(this.f11735k);
        return C;
    }

    public final RectF B(RectF rectF) {
        if (rectF == null) {
            rectF = new RectF();
        } else {
            rectF.setEmpty();
        }
        if (G()) {
            c cVar = c.a;
            Matrix f2 = cVar.f();
            A(f2);
            rectF.set(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            f2.mapRect(rectF);
            cVar.e(f2);
            return rectF;
        }
        return rectF;
    }

    public final Matrix C(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        } else {
            matrix.reset();
        }
        if (G()) {
            c cVar = c.a;
            RectF j2 = cVar.j(0.0f, 0.0f, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
            RectF j3 = cVar.j(0.0f, 0.0f, getWidth(), getHeight());
            matrix.setRectToRect(j2, j3, Matrix.ScaleToFit.CENTER);
            cVar.h(j3);
            cVar.h(j2);
        }
        return matrix;
    }

    protected final float D() {
        return 4.0f;
    }

    public final int E() {
        return this.m;
    }

    public final void H() {
        this.f11735k.reset();
        x();
        this.f11736l = null;
        this.m = 0;
        this.r.set(0.0f, 0.0f);
        this.s.set(0.0f, 0.0f);
        this.t = 0.0f;
        b bVar = this.q;
        if (bVar != null) {
            s.e(bVar);
            bVar.cancel();
        }
        w();
        invalidate();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.m == 2) {
            return true;
        }
        RectF B = B(null);
        if (B == null || B.isEmpty()) {
            return false;
        }
        if (i2 > 0) {
            if (B.right > getWidth()) {
                return true;
            }
        } else if (B.left < 0.0f) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        if (this.m == 2) {
            return true;
        }
        RectF B = B(null);
        if (B == null || B.isEmpty()) {
            return false;
        }
        if (i2 > 0) {
            if (B.bottom > getHeight()) {
                return true;
            }
        } else if (B.top < 0.0f) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        if (G()) {
            c cVar = c.a;
            Matrix f2 = cVar.f();
            setImageMatrix(A(f2));
            cVar.e(f2);
        }
        if (this.f11736l != null) {
            canvas.save();
            RectF rectF = this.f11736l;
            s.e(rectF);
            canvas.clipRect(rectF);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
        if (r0.isRunning() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010e, code lost:
        if (r0.isRunning() == false) goto L45;
     */
    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.picker.image.view.PinchImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11733i = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f11734j = onLongClickListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        s.h(scaleType, "scaleType");
    }

    protected final float v(float f2, float f3) {
        if (f3 * f2 < 4.0f) {
            return 4.0f;
        }
        return f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinchImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.f11735k = new Matrix();
        this.r = new PointF();
        this.s = new PointF();
        this.w = new GestureDetector(getContext(), new i());
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PinchImageView.kt */
    /* loaded from: classes5.dex */
    public final class h extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private final float[] a;
        private final float[] b;
        private final float[] c;

        public h(PinchImageView this$0, Matrix start, Matrix end, long j2) {
            s.h(this$0, "this$0");
            s.h(start, "start");
            s.h(end, "end");
            PinchImageView.this = this$0;
            float[] fArr = new float[9];
            this.a = fArr;
            float[] fArr2 = new float[9];
            this.b = fArr2;
            this.c = new float[9];
            setFloatValues(0.0f, 1.0f);
            setDuration(j2);
            addUpdateListener(this);
            start.getValues(fArr);
            end.getValues(fArr2);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            s.h(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.c;
                float[] fArr2 = this.a;
                fArr[i2] = fArr2[i2] + ((this.b[i2] - fArr2[i2]) * floatValue);
            }
            PinchImageView.this.f11735k.setValues(this.c);
            PinchImageView.this.x();
            PinchImageView.this.invalidate();
        }

        public /* synthetic */ h(Matrix matrix, Matrix matrix2, long j2, int i2, o oVar) {
            this(PinchImageView.this, matrix, matrix2, (i2 & 4) != 0 ? 200L : j2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinchImageView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.f11735k = new Matrix();
        this.r = new PointF();
        this.s = new PointF();
        this.w = new GestureDetector(getContext(), new i());
        F();
    }
}
