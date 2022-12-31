package us.pinguo.edit2020.view.cropindicator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Rational;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.LinkedHashMap;
import kotlin.jvm.b.s;
import kotlin.u;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: CropDragView.kt */
/* loaded from: classes4.dex */
public final class CropDragView extends View {
    private Scroller A;
    private int a;
    private int b;
    private final RectF c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f10748d;

    /* renamed from: e  reason: collision with root package name */
    private final a f10749e;

    /* renamed from: f  reason: collision with root package name */
    private final float f10750f;

    /* renamed from: g  reason: collision with root package name */
    private float f10751g;

    /* renamed from: h  reason: collision with root package name */
    private float f10752h;

    /* renamed from: i  reason: collision with root package name */
    private Rational f10753i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f10754j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f10755k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f10756l;
    private final Paint m;
    private final Path n;
    private final float o;
    private final Scroller p;
    private final Scroller q;
    private Position r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private s<? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> y;
    private b z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CropDragView.kt */
    /* loaded from: classes4.dex */
    public enum Position {
        None,
        LeftBottom,
        LeftTop,
        RightTop,
        RightBottom,
        Left,
        Top,
        Right,
        Bottom
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CropDragView.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private final Paint a;
        private final Region b;
        private final Region c;

        /* renamed from: d  reason: collision with root package name */
        private final Region f10757d;

        /* renamed from: e  reason: collision with root package name */
        private final Region f10758e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10759f;

        /* renamed from: g  reason: collision with root package name */
        private final Region f10760g;

        /* renamed from: h  reason: collision with root package name */
        private final Region f10761h;

        /* renamed from: i  reason: collision with root package name */
        private final Region f10762i;

        /* renamed from: j  reason: collision with root package name */
        private final Region f10763j;

        /* renamed from: k  reason: collision with root package name */
        private final float f10764k;

        /* renamed from: l  reason: collision with root package name */
        private final float f10765l;

        public a() {
            Paint paint = new Paint();
            this.a = paint;
            this.b = new Region();
            this.c = new Region();
            this.f10757d = new Region();
            this.f10758e = new Region();
            this.f10759f = true;
            this.f10760g = new Region();
            this.f10761h = new Region();
            this.f10762i = new Region();
            this.f10763j = new Region();
            this.f10764k = 50.0f;
            this.f10765l = 60.0f;
            paint.setColor(-2130771968);
        }

        public final Position a(float f2, float f3) {
            int b;
            int b2;
            b = kotlin.y.c.b(f2);
            b2 = kotlin.y.c.b(f3);
            return this.b.contains(b, b2) ? Position.LeftBottom : this.c.contains(b, b2) ? Position.LeftTop : this.f10757d.contains(b, b2) ? Position.RightTop : this.f10758e.contains(b, b2) ? Position.RightBottom : this.f10760g.contains(b, b2) ? Position.Left : this.f10761h.contains(b, b2) ? Position.Top : this.f10762i.contains(b, b2) ? Position.Right : this.f10763j.contains(b, b2) ? Position.Bottom : Position.None;
        }

        public final void b(boolean z) {
            this.f10759f = z;
        }

        public final void c(RectF rect) {
            kotlin.jvm.internal.s.h(rect, "rect");
            Region region = this.b;
            float f2 = rect.left;
            float f3 = this.f10764k;
            float f4 = rect.bottom;
            float f5 = this.f10765l;
            region.set((int) (f2 - f3), (int) ((f4 - f3) - f5), (int) (f2 + f3 + f5), (int) (f4 + f3));
            Region region2 = this.c;
            float f6 = rect.left;
            float f7 = this.f10764k;
            float f8 = rect.top;
            float f9 = this.f10765l;
            region2.set((int) (f6 - f7), (int) (f8 - f7), (int) (f6 + f7 + f9), (int) (f8 + f7 + f9));
            Region region3 = this.f10757d;
            float f10 = rect.right;
            float f11 = this.f10764k;
            float f12 = this.f10765l;
            float f13 = rect.top;
            region3.set((int) ((f10 - f11) - f12), (int) (f13 - f11), (int) (f10 + f11), (int) (f13 + f11 + f12));
            Region region4 = this.f10758e;
            float f14 = rect.right;
            float f15 = this.f10764k;
            float f16 = this.f10765l;
            float f17 = rect.bottom;
            region4.set((int) ((f14 - f15) - f16), (int) ((f17 - f15) - f16), (int) (f14 + f15), (int) (f17 + f15));
            if (this.f10759f) {
                float f18 = this.f10765l / 2;
                float centerY = rect.centerY();
                float f19 = this.f10764k;
                this.f10760g.set((int) (rect.left - this.f10764k), (int) ((centerY - f19) - f18), (int) (rect.left + f19), (int) (rect.centerY() + this.f10764k + f18));
                Region region5 = this.f10761h;
                float centerX = rect.centerX();
                float f20 = this.f10764k;
                int i2 = (int) (rect.top - f20);
                float centerX2 = rect.centerX();
                float f21 = this.f10764k;
                region5.set((int) ((centerX - f20) - f18), i2, (int) (centerX2 + f21 + f18), (int) (rect.top + f21));
                float centerY2 = rect.centerY();
                float f22 = this.f10764k;
                this.f10762i.set((int) (rect.right - this.f10764k), (int) ((centerY2 - f22) - f18), (int) (rect.right + f22), (int) (rect.centerY() + this.f10764k + f18));
                Region region6 = this.f10763j;
                float centerX3 = rect.centerX();
                float f23 = this.f10764k;
                int i3 = (int) (rect.bottom - f23);
                float centerX4 = rect.centerX();
                float f24 = this.f10764k;
                region6.set((int) ((centerX3 - f23) - f18), i3, (int) (centerX4 + f24 + f18), (int) (rect.bottom + f24));
                return;
            }
            this.f10760g.setEmpty();
            this.f10761h.setEmpty();
            this.f10762i.setEmpty();
            this.f10763j.setEmpty();
        }
    }

    /* compiled from: CropDragView.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b(float f2);

        void c(float f2);
    }

    /* compiled from: CropDragView.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Position.values().length];
            iArr[Position.LeftBottom.ordinal()] = 1;
            iArr[Position.LeftTop.ordinal()] = 2;
            iArr[Position.RightTop.ordinal()] = 3;
            iArr[Position.RightBottom.ordinal()] = 4;
            iArr[Position.Left.ordinal()] = 5;
            iArr[Position.Top.ordinal()] = 6;
            iArr[Position.Right.ordinal()] = 7;
            iArr[Position.Bottom.ordinal()] = 8;
            a = iArr;
        }
    }

    public CropDragView(Context context) {
        super(context);
        new LinkedHashMap();
        this.c = new RectF();
        this.f10748d = new RectF();
        this.f10749e = new a();
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        this.f10750f = f2;
        float f3 = 24;
        this.f10751g = f3 * f2;
        this.f10752h = 44 * f2;
        this.f10754j = new Paint();
        this.f10755k = new Paint();
        this.f10756l = new Paint();
        this.m = new Paint();
        this.n = new Path();
        this.o = f3 * f2;
        this.p = new Scroller(getContext(), new FastOutSlowInInterpolator());
        this.q = new Scroller(getContext(), new FastOutSlowInInterpolator());
        this.r = Position.None;
        this.w = true;
        this.A = new Scroller(getContext());
        o();
    }

    private final void a(RectF rectF, RectF rectF2, float f2, boolean z, boolean z2) {
        if (z) {
            float f3 = rectF.right;
            float f4 = rectF.left;
            if (f3 - f4 < f2) {
                f4 = f3 - f2;
            } else {
                float f5 = rectF2.left;
                if (f4 < f5) {
                    f4 = f5;
                }
            }
            rectF.left = f4;
        } else {
            float f6 = rectF.right;
            float f7 = rectF.left;
            if (f6 - f7 < f2) {
                f6 = f7 + f2;
            } else {
                float f8 = rectF2.right;
                if (f6 > f8) {
                    f6 = f8;
                }
            }
            rectF.right = f6;
        }
        if (z2) {
            float f9 = rectF.bottom;
            float f10 = rectF.top;
            if (f9 - f10 < f2) {
                f10 = f9 - f2;
            } else {
                float f11 = rectF2.top;
                if (f10 < f11) {
                    f10 = f11;
                }
            }
            rectF.top = f10;
            return;
        }
        float f12 = rectF.bottom;
        float f13 = rectF.top;
        if (f12 - f13 < f2) {
            f12 = f13 + f2;
        } else {
            float f14 = rectF2.bottom;
            if (f12 > f14) {
                f12 = f14;
            }
        }
        rectF.bottom = f12;
    }

    private final void b(RectF rectF, float f2, boolean z, boolean z2) {
        if (rectF.width() / rectF.height() < f2) {
            float width = rectF.width() / f2;
            if (z2) {
                rectF.top = rectF.bottom - width;
                return;
            } else {
                rectF.bottom = rectF.top + width;
                return;
            }
        }
        float height = rectF.height() * f2;
        if (z) {
            rectF.left = rectF.right - height;
        } else {
            rectF.right = rectF.left + height;
        }
    }

    private final boolean c(Rational rational) {
        if (rational == null) {
            return true;
        }
        return rational.isFinite() && rational.floatValue() > 0.0f;
    }

    private final void d(Canvas canvas, RectF rectF, Paint paint) {
        if (canvas != null) {
            canvas.save();
        }
        if (canvas != null) {
            canvas.drawRect(0.0f, 0.0f, this.a, rectF.top, paint);
        }
        if (canvas != null) {
            canvas.drawRect(0.0f, rectF.top, rectF.left, rectF.bottom, paint);
        }
        if (canvas != null) {
            canvas.drawRect(rectF.right, rectF.top, this.a, rectF.bottom, paint);
        }
        if (canvas != null) {
            canvas.drawRect(0.0f, rectF.bottom, this.a, this.b, paint);
        }
        if (canvas == null) {
            return;
        }
        canvas.restore();
    }

    private final void e(Canvas canvas, RectF rectF, Paint paint) {
        float f2 = rectF.bottom;
        float f3 = rectF.top;
        float f4 = 3;
        float f5 = (f2 - f3) / f4;
        float f6 = f3 + f5;
        float f7 = 2;
        float f8 = f3 + (f5 * f7);
        if (canvas != null) {
            canvas.drawLine(rectF.left, f6, rectF.right, f6, paint);
        }
        if (canvas != null) {
            canvas.drawLine(rectF.left, f8, rectF.right, f8, paint);
        }
        float f9 = rectF.right;
        float f10 = rectF.left;
        float f11 = (f9 - f10) / f4;
        float f12 = f10 + f11;
        float f13 = f10 + (f11 * f7);
        if (canvas != null) {
            canvas.drawLine(f12, rectF.top, f12, rectF.bottom, paint);
        }
        if (canvas == null) {
            return;
        }
        canvas.drawLine(f13, rectF.top, f13, rectF.bottom, paint);
    }

    private final void f(Canvas canvas, RectF rectF, Paint paint) {
        if (canvas != null) {
            float f2 = rectF.left;
            canvas.drawLine(f2, rectF.bottom, f2, rectF.top, paint);
        }
        if (canvas != null) {
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.drawLine(f3, f4, rectF.right, f4, paint);
        }
        if (canvas != null) {
            float f5 = rectF.right;
            canvas.drawLine(f5, rectF.top, f5, rectF.bottom, paint);
        }
        if (canvas == null) {
            return;
        }
        float f6 = rectF.right;
        float f7 = rectF.bottom;
        canvas.drawLine(f6, f7, rectF.left, f7, paint);
    }

    private final void g(Canvas canvas, RectF rectF, Paint paint, float f2) {
        this.n.reset();
        this.n.moveTo(rectF.left + f2, rectF.bottom);
        this.n.lineTo(rectF.left, rectF.bottom);
        this.n.lineTo(rectF.left, rectF.bottom - f2);
        this.n.moveTo(rectF.left, rectF.top + f2);
        this.n.lineTo(rectF.left, rectF.top);
        this.n.lineTo(rectF.left + f2, rectF.top);
        this.n.moveTo(rectF.right - f2, rectF.top);
        this.n.lineTo(rectF.right, rectF.top);
        this.n.lineTo(rectF.right, rectF.top + f2);
        this.n.moveTo(rectF.right, rectF.bottom - f2);
        this.n.lineTo(rectF.right, rectF.bottom);
        this.n.lineTo(rectF.right - f2, rectF.bottom);
        if (p()) {
            float f3 = f2 / 2;
            this.n.moveTo(rectF.left, rectF.centerY() - f3);
            this.n.lineTo(rectF.left, rectF.centerY() + f3);
            this.n.moveTo(rectF.centerX() - f3, rectF.top);
            this.n.lineTo(rectF.centerX() + f3, rectF.top);
            this.n.moveTo(rectF.right, rectF.centerY() - f3);
            this.n.lineTo(rectF.right, rectF.centerY() + f3);
            this.n.moveTo(rectF.centerX() - f3, rectF.bottom);
            this.n.lineTo(rectF.centerX() + f3, rectF.bottom);
        }
        if (canvas == null) {
            return;
        }
        canvas.drawPath(this.n, paint);
    }

    public static /* synthetic */ void i(CropDragView cropDragView, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        cropDragView.h(z);
    }

    private final void j(int i2) {
        us.pinguo.common.log.a.c("expand to max", new Object[0]);
        this.t = true;
        RectF rectF = new RectF();
        float width = this.c.width() / this.c.height();
        float width2 = this.f10748d.width() / this.f10748d.height();
        if (width < width2) {
            RectF rectF2 = this.f10748d;
            rectF.top = rectF2.top;
            rectF.bottom = rectF2.bottom;
            float height = (rectF.height() * width) / 2;
            rectF.left = this.f10748d.centerX() - height;
            rectF.right = this.f10748d.centerX() + height;
        } else if (width > width2) {
            RectF rectF3 = this.f10748d;
            rectF.left = rectF3.left;
            rectF.right = rectF3.right;
            float width3 = (rectF.width() / width) / 2;
            rectF.top = this.f10748d.centerY() - width3;
            rectF.bottom = this.f10748d.centerY() + width3;
        } else {
            rectF.set(this.f10748d);
        }
        s<? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> sVar = this.y;
        if (sVar != null) {
            sVar.invoke(Float.valueOf(rectF.left / getWidth()), Float.valueOf(rectF.top / getHeight()), Float.valueOf(rectF.right / getWidth()), Float.valueOf(rectF.bottom / getHeight()), Boolean.TRUE);
        }
        RectF rectF4 = this.c;
        Rect rect = new Rect();
        rectF4.roundOut(rect);
        Rect rect2 = new Rect();
        rectF.roundOut(rect2);
        u(rect, rect2);
    }

    static /* synthetic */ void k(CropDragView cropDragView, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        cropDragView.j(i2);
    }

    private final void l() {
        this.A.forceFinished(true);
        this.A.startScroll(255, 0, -255, 0, IjkMediaCodecInfo.RANK_SECURE);
        invalidate();
    }

    private final void o() {
        this.f10754j.setColor(-2144522963);
        this.f10755k.setAntiAlias(true);
        this.f10755k.setColor(-1);
        this.f10755k.setStrokeWidth(2.0f);
        this.f10755k.setAlpha(BaseBlurEffect.ROTATION_180);
        this.f10756l.setAntiAlias(true);
        this.f10756l.setColor(-1);
        this.f10756l.setStrokeWidth(2.0f);
        this.m.setAntiAlias(true);
        this.m.setColor(-1);
        this.m.setStrokeWidth(15.0f);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeCap(Paint.Cap.SQUARE);
    }

    private final boolean p() {
        return this.f10753i == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(CropDragView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        k(this$0, 0, 1, null);
        this$0.f10749e.c(this$0.c);
        this$0.invalidate();
    }

    public static /* synthetic */ void setFixedRate$default(CropDragView cropDragView, Rational rational, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        cropDragView.setFixedRate(rational, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(CropDragView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        k(this$0, 0, 1, null);
        this$0.f10749e.c(this$0.c);
        this$0.invalidate();
    }

    private final void u(Rect rect, Rect rect2) {
        this.p.forceFinished(true);
        this.q.forceFinished(true);
        Scroller scroller = this.p;
        int i2 = rect.left;
        int i3 = rect.top;
        scroller.startScroll(i2, i3, rect2.left - i2, rect2.top - i3, 200);
        Scroller scroller2 = this.q;
        int i4 = rect.right;
        int i5 = rect.bottom;
        scroller2.startScroll(i4, i5, rect2.right - i4, rect2.bottom - i5, 200);
        invalidate();
    }

    private final void w(float f2, float f3, Position position, float f4) {
        switch (c.a[position.ordinal()]) {
            case 1:
                RectF rectF = this.c;
                rectF.left = f2;
                rectF.bottom = f3;
                a(rectF, this.f10748d, f4, true, false);
                Rational rational = this.f10753i;
                if (rational == null) {
                    return;
                }
                b(this.c, rational.floatValue(), true, false);
                return;
            case 2:
                RectF rectF2 = this.c;
                rectF2.left = f2;
                rectF2.top = f3;
                a(rectF2, this.f10748d, f4, true, true);
                Rational rational2 = this.f10753i;
                if (rational2 == null) {
                    return;
                }
                b(this.c, rational2.floatValue(), true, true);
                return;
            case 3:
                RectF rectF3 = this.c;
                rectF3.right = f2;
                rectF3.top = f3;
                a(rectF3, this.f10748d, f4, false, true);
                Rational rational3 = this.f10753i;
                if (rational3 == null) {
                    return;
                }
                b(this.c, rational3.floatValue(), false, true);
                return;
            case 4:
                RectF rectF4 = this.c;
                rectF4.right = f2;
                rectF4.bottom = f3;
                a(rectF4, this.f10748d, f4, false, false);
                Rational rational4 = this.f10753i;
                if (rational4 == null) {
                    return;
                }
                b(this.c, rational4.floatValue(), false, false);
                return;
            case 5:
                RectF rectF5 = this.c;
                rectF5.left = f2;
                a(rectF5, this.f10748d, f4, true, true);
                return;
            case 6:
                RectF rectF6 = this.c;
                rectF6.top = f3;
                a(rectF6, this.f10748d, f4, true, true);
                return;
            case 7:
                RectF rectF7 = this.c;
                rectF7.right = f2;
                a(rectF7, this.f10748d, f4, false, false);
                return;
            case 8:
                RectF rectF8 = this.c;
                rectF8.bottom = f3;
                a(rectF8, this.f10748d, f4, false, false);
                return;
            default:
                return;
        }
    }

    private final void x(Rational rational) {
        float floatValue;
        float f2;
        RectF rectF = this.f10748d;
        float f3 = rectF.right - rectF.left;
        float f4 = rectF.bottom - rectF.top;
        if (f3 / f4 <= rational.floatValue()) {
            f2 = f3 / rational.floatValue();
            floatValue = f3;
        } else {
            floatValue = rational.floatValue() * f4;
            f2 = f4;
        }
        RectF rectF2 = this.c;
        float f5 = 2;
        float f6 = (f3 - floatValue) / f5;
        float f7 = this.f10751g;
        float f8 = (f4 - f2) / f5;
        float f9 = this.f10752h;
        rectF2.set(f6 + f7, f8 + f9, f6 + floatValue + f7, f8 + f2 + f9);
    }

    public final void h(boolean z) {
        s<? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> sVar;
        x(new Rational((int) this.c.height(), (int) this.c.width()));
        this.f10749e.c(this.c);
        if (z && (sVar = this.y) != null) {
            sVar.invoke(Float.valueOf(this.c.left / getWidth()), Float.valueOf(this.c.top / getHeight()), Float.valueOf(this.c.right / getWidth()), Float.valueOf(this.c.bottom / getHeight()), Boolean.TRUE);
        }
        invalidate();
    }

    public final RectF m() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        RectF rectF = this.c;
        float f2 = measuredWidth;
        float f3 = measuredHeight;
        return new RectF(rectF.left / f2, rectF.top / f3, rectF.right / f2, rectF.bottom / f3);
    }

    public final float n() {
        return this.c.bottom;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.p.isFinished() && this.q.isFinished()) {
            this.f10749e.c(this.c);
            if (this.t) {
                this.t = false;
                this.u = false;
                b bVar = this.z;
                if (bVar != null) {
                    bVar.b(this.c.bottom);
                }
            }
        } else {
            float timePassed = this.p.timePassed() / this.p.getDuration();
            b bVar2 = this.z;
            if (bVar2 != null) {
                if (timePassed > 1.0f) {
                    timePassed = 1.0f;
                }
                bVar2.c(timePassed);
            }
            this.p.computeScrollOffset();
            this.q.computeScrollOffset();
            this.c.set(this.p.getCurrX(), this.p.getCurrY(), this.q.getCurrX(), this.q.getCurrY());
            invalidate();
        }
        if (this.u || this.v) {
            d(canvas, this.c, this.f10754j);
        }
        if (!this.s && !this.x) {
            if (this.A.computeScrollOffset()) {
                this.f10756l.setAlpha(this.A.getCurrX());
                e(canvas, this.c, this.f10756l);
                invalidate();
            }
        } else {
            this.f10756l.setAlpha(BaseBlurEffect.ROTATION_180);
            e(canvas, this.c, this.f10756l);
        }
        f(canvas, this.c, this.f10755k);
        if (this.w) {
            g(canvas, this.c, this.m, this.o);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!(this.a == getMeasuredWidth() && this.b == getMeasuredHeight()) && getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.a = getMeasuredWidth();
            this.b = getMeasuredHeight();
            us.pinguo.common.log.a.c("reset maxDrawArea fixedWidth=" + this.a + ", fixedHeight=" + this.b, new Object[0]);
            RectF rectF = this.f10748d;
            float f2 = this.f10751g;
            float f3 = this.f10752h;
            rectF.set(f2, f3, ((float) this.a) - f2, ((float) this.b) - f3);
            this.c.set(this.f10748d);
            this.f10749e.c(this.c);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && this.w) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                Position a2 = this.f10749e.a(x, y);
                this.r = a2;
                return a2 != Position.None;
            }
            if (action == 1) {
                this.s = false;
                l();
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                w(x, y, this.r, this.o * 3);
                s<? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> sVar = this.y;
                if (sVar != null) {
                    float f2 = measuredWidth;
                    float f3 = measuredHeight;
                    sVar.invoke(Float.valueOf(this.c.left / f2), Float.valueOf(this.c.top / f3), Float.valueOf(this.c.right / f2), Float.valueOf(this.c.bottom / f3), Boolean.FALSE);
                }
                postDelayed(new Runnable() { // from class: us.pinguo.edit2020.view.cropindicator.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        CropDragView.s(CropDragView.this);
                    }
                }, 500L);
            } else if (action == 2) {
                if (!this.s) {
                    this.s = true;
                    this.u = true;
                    b bVar = this.z;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
                w(x, y, this.r, this.o * 3);
                s<? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> sVar2 = this.y;
                if (sVar2 != null) {
                    sVar2.invoke(Float.valueOf(this.c.left / getWidth()), Float.valueOf(this.c.top / getHeight()), Float.valueOf(this.c.right / getWidth()), Float.valueOf(this.c.bottom / getHeight()), Boolean.FALSE);
                }
                invalidate();
            } else if (action == 3) {
                this.s = false;
                l();
                postDelayed(new Runnable() { // from class: us.pinguo.edit2020.view.cropindicator.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        CropDragView.t(CropDragView.this);
                    }
                }, 500L);
            }
            return true;
        }
        return false;
    }

    public final void setFixedRate(Rational rational, boolean z) {
        s<? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> sVar;
        if (c(rational)) {
            if (rational != null) {
                x(rational);
            }
            this.f10749e.c(this.c);
            this.f10753i = rational;
            this.f10749e.b(rational == null);
            if (z && (sVar = this.y) != null) {
                sVar.invoke(Float.valueOf(this.c.left / getWidth()), Float.valueOf(this.c.top / getHeight()), Float.valueOf(this.c.right / getWidth()), Float.valueOf(this.c.bottom / getHeight()), Boolean.TRUE);
            }
            b bVar = this.z;
            if (bVar != null) {
                bVar.b(this.c.bottom);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("rate can not be infinite or negative!");
    }

    public final void setIsDrawOutRect(boolean z) {
        this.v = z;
        invalidate();
    }

    public final void setRectUpdateListener(s<? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, u> listener) {
        kotlin.jvm.internal.s.h(listener, "listener");
        this.y = listener;
    }

    public final void setShowDividerLine(boolean z) {
        this.x = z;
    }

    public final void setShowTouchIndicator(boolean z) {
        this.w = z;
    }

    public final void setToFreeRate() {
        this.f10753i = null;
        this.f10749e.b(true);
        this.f10749e.c(this.c);
        invalidate();
    }

    public final void setViewUpdateListener(b listener) {
        kotlin.jvm.internal.s.h(listener, "listener");
        this.z = listener;
    }

    public final void v(float f2, float f3, float f4, float f5) {
        this.c.set(f2 * getWidth(), f3 * getHeight(), f4 * getWidth(), f5 * getHeight());
        invalidate();
    }

    public CropDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new LinkedHashMap();
        this.c = new RectF();
        this.f10748d = new RectF();
        this.f10749e = new a();
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        this.f10750f = f2;
        float f3 = 24;
        this.f10751g = f3 * f2;
        this.f10752h = 44 * f2;
        this.f10754j = new Paint();
        this.f10755k = new Paint();
        this.f10756l = new Paint();
        this.m = new Paint();
        this.n = new Path();
        this.o = f3 * f2;
        this.p = new Scroller(getContext(), new FastOutSlowInInterpolator());
        this.q = new Scroller(getContext(), new FastOutSlowInInterpolator());
        this.r = Position.None;
        this.w = true;
        this.A = new Scroller(getContext());
        o();
    }

    public CropDragView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new LinkedHashMap();
        this.c = new RectF();
        this.f10748d = new RectF();
        this.f10749e = new a();
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        this.f10750f = f2;
        float f3 = 24;
        this.f10751g = f3 * f2;
        this.f10752h = 44 * f2;
        this.f10754j = new Paint();
        this.f10755k = new Paint();
        this.f10756l = new Paint();
        this.m = new Paint();
        this.n = new Path();
        this.o = f3 * f2;
        this.p = new Scroller(getContext(), new FastOutSlowInInterpolator());
        this.q = new Scroller(getContext(), new FastOutSlowInInterpolator());
        this.r = Position.None;
        this.w = true;
        this.A = new Scroller(getContext());
        o();
    }
}
