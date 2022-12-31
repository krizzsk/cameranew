package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
/* compiled from: CropZoomImageView.kt */
/* loaded from: classes8.dex */
public final class CropZoomImageView extends View {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private final PointF f2114d;

    /* renamed from: e  reason: collision with root package name */
    private int f2115e;

    /* renamed from: f  reason: collision with root package name */
    private final PointF f2116f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f2117g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f2118h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f2119i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f2120j;

    /* renamed from: k  reason: collision with root package name */
    private SpliceScaleType f2121k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2122l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private float q;
    private float r;
    private float s;
    private float t;
    private boolean u;
    private final Runnable v;
    private boolean w;

    /* compiled from: CropZoomImageView.kt */
    /* loaded from: classes8.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SpliceScaleType.values().length];
            iArr[SpliceScaleType.FULL.ordinal()] = 1;
            iArr[SpliceScaleType.S1x1.ordinal()] = 2;
            iArr[SpliceScaleType.S3x4.ordinal()] = 3;
            iArr[SpliceScaleType.S9x16.ordinal()] = 4;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropZoomImageView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.b = -1;
        this.c = -1;
        this.f2114d = new PointF();
        this.f2115e = -1;
        this.f2116f = new PointF();
        this.f2118h = new Paint(1);
        Paint paint = new Paint(1);
        this.f2119i = paint;
        this.f2120j = new Matrix();
        this.f2121k = SpliceScaleType.FULL;
        this.m = true;
        this.o = true;
        this.p = true;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.v = new Runnable() { // from class: com.camera360.dynamic_feature_splice.a
            @Override // java.lang.Runnable
            public final void run() {
                CropZoomImageView.a(CropZoomImageView.this);
            }
        };
        this.w = true;
        paint.setColor(Color.parseColor("#FCCF2B"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(us.pinguo.foundation.t.b.a.c(getContext(), 5.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CropZoomImageView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.u = false;
    }

    public final void b(SpliceScaleType frame) {
        kotlin.jvm.internal.s.h(frame, "frame");
        this.f2121k = frame;
        this.w = true;
        this.f2120j.reset();
        requestLayout();
    }

    public final RectF c() {
        Bitmap bitmap = this.f2117g;
        if (bitmap == null || bitmap.isRecycled() || Float.isNaN(this.q) || Float.isNaN(this.r) || Float.isNaN(this.s) || Float.isNaN(this.t)) {
            return null;
        }
        float[] fArr = new float[9];
        for (int i2 = 0; i2 < 9; i2++) {
            fArr[i2] = 0.0f;
        }
        this.f2120j.getValues(fArr);
        float width = fArr[0] * bitmap.getWidth();
        float height = fArr[4] * bitmap.getHeight();
        RectF rectF = new RectF();
        float f2 = this.q;
        rectF.left = f2 <= 0.0f ? 0.0f : f2 / width;
        float f3 = this.r;
        rectF.top = f3 <= 0.0f ? 0.0f : f3 / height;
        rectF.right = this.s <= 0.0f ? 1.0f : (f2 + getMeasuredWidth()) / width;
        rectF.bottom = this.t > 0.0f ? (this.r + getMeasuredHeight()) / height : 1.0f;
        return rectF;
    }

    public final void e(Bitmap inBitmap) {
        kotlin.jvm.internal.s.h(inBitmap, "inBitmap");
        this.f2117g = inBitmap;
        this.w = true;
        this.f2120j.reset();
        requestLayout();
    }

    public final void f(boolean z) {
        if (this.f2122l == z) {
            return;
        }
        this.f2122l = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f2117g;
        if (bitmap != null && !bitmap.isRecycled() && canvas != null) {
            canvas.drawBitmap(bitmap, this.f2120j, this.f2118h);
        }
        if (!this.f2122l || canvas == null) {
            return;
        }
        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.f2119i);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        float size;
        int b;
        int b2;
        float f2;
        float f3;
        Bitmap bitmap = this.f2117g;
        if (bitmap != null && !bitmap.isRecycled()) {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            float size2 = View.MeasureSpec.getSize(i2);
            if (this.p) {
                int i4 = a.a[this.f2121k.ordinal()];
                if (i4 == 1) {
                    size = (height / width) * size2;
                } else if (i4 == 2) {
                    size = size2;
                } else if (i4 == 3) {
                    size = (3.0f * size2) / 4.0f;
                } else if (i4 != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    size = (9.0f * size2) / 16.0f;
                }
            } else {
                size = View.MeasureSpec.getSize(i3);
            }
            b = kotlin.y.c.b(size2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(b, 1073741824);
            b2 = kotlin.y.c.b(size);
            setMeasuredDimension(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(b2, 1073741824));
            if (this.w) {
                this.w = false;
                this.f2120j.reset();
                int i5 = (width > size2 ? 1 : (width == size2 ? 0 : -1));
                if (i5 > 0 && this.f2121k == SpliceScaleType.FULL) {
                    float f4 = size2 / width;
                    this.f2120j.setTranslate((size2 - width) / 2.0f, (size - height) / 2.0f);
                    this.f2120j.postScale(f4, f4, size2 / 2.0f, size / 2.0f);
                } else if (width >= size2 && height >= size) {
                    this.f2120j.setTranslate((size2 - width) / 2.0f, (size - height) / 2.0f);
                } else {
                    float f5 = size2 / width;
                    float f6 = size / height;
                    if (!(!this.o ? f5 >= f6 : f5 <= f6)) {
                        f5 = f6;
                    }
                    float f7 = f5 <= 4.0f ? f5 : 4.0f;
                    this.f2120j.setTranslate((size2 - width) / 2.0f, (size - height) / 2.0f);
                    this.f2120j.postScale(f7, f7, size2 / 2.0f, size / 2.0f);
                }
                float[] fArr = new float[9];
                int i6 = 0;
                while (true) {
                    f2 = 0.0f;
                    if (i6 >= 9) {
                        break;
                    }
                    fArr[i6] = 0.0f;
                    i6++;
                }
                this.f2120j.getValues(fArr);
                this.q = ((fArr[0] * width) - size2) / 2.0f;
                this.s = ((fArr[0] * width) - size2) / 2.0f;
                this.r = ((fArr[4] * height) - size) / 2.0f;
                this.t = ((fArr[4] * height) - size) / 2.0f;
                if (this.a == 1) {
                    this.f2120j.reset();
                    this.q = 0.0f;
                    this.r = 0.0f;
                    this.s = 0.0f;
                    this.t = 0.0f;
                    if (i5 >= 0 && height >= size) {
                        this.s = width - size2;
                        this.t = height - size;
                        return;
                    }
                    if (width < size2) {
                        f3 = (size2 - width) / 2.0f;
                        float f8 = -f3;
                        this.q = f8;
                        this.s = f8;
                    } else {
                        f3 = 0.0f;
                    }
                    if (height < size) {
                        f2 = (size - height) / 2;
                        float f9 = -f2;
                        this.r = f9;
                        this.t = f9;
                    }
                    this.f2120j.setTranslate(f3, f2);
                    return;
                }
                return;
            }
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Bitmap bitmap;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        if ((!this.n && !this.f2122l) || (bitmap = this.f2117g) == null || bitmap.isRecycled()) {
            return false;
        }
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getActionMasked());
        if (valueOf != null && valueOf.intValue() == 0) {
            if (this.n) {
                this.u = true;
                postDelayed(this.v, 650L);
            }
            this.b = 0;
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.c = pointerId;
            int findPointerIndex = motionEvent.findPointerIndex(pointerId);
            this.f2114d.x = motionEvent.getX(findPointerIndex);
            this.f2114d.y = motionEvent.getY(findPointerIndex);
            return true;
        } else if (valueOf != null && valueOf.intValue() == 5) {
            this.u = false;
            if (this.m) {
                this.b = 1;
            }
            int pointerId2 = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.f2115e = pointerId2;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId2);
            this.f2116f.x = motionEvent.getX(findPointerIndex2);
            this.f2116f.y = motionEvent.getY(findPointerIndex2);
            return true;
        } else if (valueOf != null && valueOf.intValue() == 2) {
            this.b = (!this.m || motionEvent.getPointerCount() < 2) ? 0 : 1;
            float[] fArr = new float[9];
            for (int i3 = 0; i3 < 9; i3++) {
                fArr[i3] = 0.0f;
            }
            this.f2120j.getValues(fArr);
            PointF pointF = this.f2114d;
            float f12 = pointF.x;
            float f13 = pointF.y;
            int i4 = this.b;
            if (i4 == 0) {
                float x = motionEvent.getX(motionEvent.getActionIndex());
                float y = motionEvent.getY(motionEvent.getActionIndex());
                float f14 = x - f12;
                float f15 = y - f13;
                if (Math.abs(f14) >= 1.0f || Math.abs(f15) >= 1.0f) {
                    this.u = false;
                    PointF pointF2 = this.f2114d;
                    pointF2.x = x;
                    pointF2.y = y;
                    if (f14 > 0.0f) {
                        float f16 = this.q;
                        if (f16 > 0.0f) {
                            if (f16 < f14) {
                                f14 = f16;
                            }
                        }
                        f14 = 0.0f;
                    } else {
                        float f17 = this.s;
                        if (f17 > 0.0f) {
                            if (f17 < (-f14)) {
                                f14 = -f17;
                            }
                        }
                        f14 = 0.0f;
                    }
                    if (f15 > 0.0f) {
                        float f18 = this.r;
                        if (f18 > 0.0f) {
                            if (f18 < f15) {
                                f15 = f18;
                            }
                        }
                        f15 = 0.0f;
                    } else {
                        float f19 = this.t;
                        if (f19 > 0.0f) {
                            if (f19 < (-f15)) {
                                f15 = -f19;
                            }
                        }
                        f15 = 0.0f;
                    }
                    if (Math.abs(f14) > 0.0f || Math.abs(f15) > 0.0f) {
                        this.q -= f14;
                        this.s += f14;
                        this.r -= f15;
                        this.t += f15;
                        this.f2120j.postTranslate(f14, f15);
                        invalidate();
                        return true;
                    }
                    return true;
                }
                return true;
            } else if (i4 == 1) {
                PointF pointF3 = this.f2116f;
                float f20 = pointF3.x;
                float f21 = pointF3.y;
                float f22 = (f12 + f20) / 2.0f;
                float f23 = (f13 + f21) / 2.0f;
                int i5 = this.c;
                if (i5 != -1) {
                    int findPointerIndex3 = motionEvent.findPointerIndex(i5);
                    float x2 = motionEvent.getX(findPointerIndex3);
                    f2 = motionEvent.getY(findPointerIndex3);
                    f3 = x2;
                } else {
                    f2 = f13;
                    f3 = f12;
                }
                int i6 = this.f2115e;
                if (i6 != -1) {
                    int findPointerIndex4 = motionEvent.findPointerIndex(i6);
                    f5 = motionEvent.getX(findPointerIndex4);
                    f4 = motionEvent.getY(findPointerIndex4);
                } else {
                    f4 = f21;
                    f5 = f20;
                }
                double d2 = f5 - f3;
                double d3 = f4 - f2;
                float f24 = f2;
                double d4 = f20 - f12;
                double d5 = f21 - f13;
                float f25 = f3;
                float f26 = f5;
                float hypot = ((float) Math.hypot(d2, d3)) / ((float) Math.hypot(d4, d5));
                float abs = Math.abs(((float) Math.hypot(d2, d3)) - ((float) Math.hypot(d4, d5)));
                if (hypot == 0.0f) {
                    return true;
                }
                int i7 = (hypot > 1.0f ? 1 : (hypot == 1.0f ? 0 : -1));
                if ((i7 == 0) || abs < 1.0f) {
                    return true;
                }
                if (i7 < 0) {
                    if (this.q <= 0.0f && this.s <= 0.0f) {
                        return true;
                    }
                    if (this.r <= 0.0f && this.t <= 0.0f) {
                        return true;
                    }
                }
                this.u = false;
                float width = bitmap.getWidth() * fArr[0];
                float height = bitmap.getHeight() * fArr[4];
                if (i7 < 0) {
                    float f27 = this.q;
                    f6 = f27 <= 0.0f ? -f27 : f22;
                    if (this.s <= 0.0f) {
                        f6 = getMeasuredWidth() + this.s;
                    }
                    float f28 = this.r;
                    f7 = f28 <= 0.0f ? -f28 : f23;
                    if (this.t <= 0.0f) {
                        f7 = getMeasuredHeight() + this.t;
                    }
                } else {
                    f6 = f22;
                    f7 = f23;
                }
                float f29 = this.q;
                float f30 = (f6 + f29) / width;
                if (f30 < 0.0f) {
                    f30 = 0.0f;
                }
                float f31 = this.r;
                float f32 = (f7 + f31) / height;
                if (f32 < 0.0f) {
                    f32 = 0.0f;
                }
                if (i7 < 0) {
                    if (f29 <= 0.0f) {
                        f30 = 0.0f;
                    } else if (this.s <= 0.0f) {
                        f30 = 1.0f;
                    }
                    if (f31 <= 0.0f) {
                        f32 = 0.0f;
                    } else if (this.t <= 0.0f) {
                        f32 = 1.0f;
                    }
                }
                float f33 = width * hypot;
                float f34 = height * hypot;
                float f35 = i7 < 0 ? width - f33 : f33 - width;
                float f36 = i7 < 0 ? height - f34 : f34 - height;
                float f37 = f35 * f30;
                float f38 = f35 - f37;
                float f39 = f36 * f32;
                float f40 = f36 - f39;
                if (i7 < 0) {
                    if (f29 <= 0.0f) {
                        f37 = 0.0f;
                    } else if (f29 < f37) {
                        f35 = f29 / f30;
                        f38 = f35 - f29;
                        f37 = f29;
                    }
                    float f41 = this.s;
                    if (f41 <= 0.0f) {
                        f9 = f36;
                        f38 = 0.0f;
                    } else {
                        f9 = f36;
                        if (f41 < f38) {
                            float f42 = f41 / (1 - f30);
                            if (f42 < f35) {
                                f37 = f42 * f30;
                                f38 = f41;
                            } else {
                                f38 = f35 - f37;
                            }
                        }
                    }
                    float f43 = (width - (f37 + f38)) / width;
                    if (f31 <= 0.0f) {
                        f10 = f9;
                        f39 = 0.0f;
                    } else if (f31 < f39) {
                        f10 = f31 / f32;
                        f39 = f31;
                        f40 = f10 - f31;
                    } else {
                        f10 = f9;
                    }
                    float f44 = this.t;
                    if (f44 <= 0.0f) {
                        f8 = f6;
                        f11 = 0.0f;
                    } else {
                        f8 = f6;
                        if (f44 < f40) {
                            float f45 = f44 / (1 - f32);
                            if (f45 < f10) {
                                f39 = f45 * f32;
                                f11 = f44;
                            } else {
                                f11 = f10 - f39;
                            }
                        } else {
                            f11 = f40;
                        }
                    }
                    float f46 = (height - (f39 + f11)) / height;
                    if (f43 > f46) {
                        f46 = f43;
                    }
                    float f47 = 1 - f46;
                    float f48 = width * f47;
                    float f49 = f30 * f48;
                    float f50 = f48 - f49;
                    float f51 = height * f47;
                    float f52 = f32 * f51;
                    float f53 = f51 - f52;
                    float f54 = f29 - f49;
                    this.q = f54;
                    if (f54 < 0.0f) {
                        this.q = 0.0f;
                    }
                    float f55 = f31 - f52;
                    this.r = f55;
                    if (f55 < 0.0f) {
                        this.r = 0.0f;
                    }
                    float f56 = f41 - f50;
                    this.s = f56;
                    if (f56 < 0.0f) {
                        this.s = 0.0f;
                    }
                    float f57 = f44 - f53;
                    this.t = f57;
                    if (f57 < 0.0f) {
                        this.t = 0.0f;
                    }
                    hypot = f46;
                } else {
                    f8 = f6;
                    this.q = f29 + f37;
                    this.r = f31 + f39;
                    this.s += f38;
                    this.t += f40;
                }
                PointF pointF4 = this.f2114d;
                pointF4.x = f25;
                pointF4.y = f24;
                PointF pointF5 = this.f2116f;
                pointF5.x = f26;
                pointF5.y = f4;
                this.f2120j.postScale(hypot, hypot, f8, f7);
                invalidate();
                return true;
            } else {
                return true;
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            this.b = -1;
            removeCallbacks(this.v);
            if (this.u) {
                performClick();
                return true;
            }
            return true;
        } else if (valueOf != null && valueOf.intValue() == 6) {
            this.b = -1;
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) != this.c || (i2 = this.f2115e) <= -1) {
                return true;
            }
            this.f2114d.x = motionEvent.getX(motionEvent.findPointerIndex(i2));
            this.f2114d.y = motionEvent.getY(motionEvent.findPointerIndex(this.f2115e));
            return true;
        } else if (valueOf != null && valueOf.intValue() == 3) {
            this.b = -1;
            return true;
        } else {
            return true;
        }
    }

    public final void setInitialDisplayMode(int i2) {
        this.a = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.b = -1;
        this.c = -1;
        this.f2114d = new PointF();
        this.f2115e = -1;
        this.f2116f = new PointF();
        this.f2118h = new Paint(1);
        Paint paint = new Paint(1);
        this.f2119i = paint;
        this.f2120j = new Matrix();
        this.f2121k = SpliceScaleType.FULL;
        this.m = true;
        this.o = true;
        this.p = true;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.v = new Runnable() { // from class: com.camera360.dynamic_feature_splice.a
            @Override // java.lang.Runnable
            public final void run() {
                CropZoomImageView.a(CropZoomImageView.this);
            }
        };
        this.w = true;
        paint.setColor(Color.parseColor("#FCCF2B"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(us.pinguo.foundation.t.b.a.c(getContext(), 5.0f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropZoomImageView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.b = -1;
        this.c = -1;
        this.f2114d = new PointF();
        this.f2115e = -1;
        this.f2116f = new PointF();
        this.f2118h = new Paint(1);
        Paint paint = new Paint(1);
        this.f2119i = paint;
        this.f2120j = new Matrix();
        this.f2121k = SpliceScaleType.FULL;
        this.m = true;
        this.o = true;
        this.p = true;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.v = new Runnable() { // from class: com.camera360.dynamic_feature_splice.a
            @Override // java.lang.Runnable
            public final void run() {
                CropZoomImageView.a(CropZoomImageView.this);
            }
        };
        this.w = true;
        paint.setColor(Color.parseColor("#FCCF2B"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(us.pinguo.foundation.t.b.a.c(getContext(), 5.0f));
    }
}
