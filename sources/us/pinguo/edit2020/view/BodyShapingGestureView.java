package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: BodyShapingGestureView.kt */
/* loaded from: classes4.dex */
public final class BodyShapingGestureView extends View {
    private static final int r = Color.parseColor("#fccf2f");
    private final PointF a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f10615d;

    /* renamed from: e  reason: collision with root package name */
    private int f10616e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10617f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f10618g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f10619h;

    /* renamed from: i  reason: collision with root package name */
    private final float f10620i;

    /* renamed from: j  reason: collision with root package name */
    private final float f10621j;

    /* renamed from: k  reason: collision with root package name */
    private final float f10622k;

    /* renamed from: l  reason: collision with root package name */
    private final float f10623l;
    private final float m;
    private final float n;
    private PointF o;
    private float p;
    private int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodyShapingGestureView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new PointF();
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.b = us.pinguo.util.g.b(context2, 38.0f);
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.c = us.pinguo.util.g.b(context3, 20.0f);
        Context context4 = getContext();
        kotlin.jvm.internal.s.g(context4, "context");
        this.f10615d = us.pinguo.util.h.i(context4) * 0.5f;
        this.f10616e = 3;
        Paint paint = new Paint(1);
        this.f10618g = paint;
        this.f10619h = getResources().getDrawable(R.drawable.edit_body_shape_cirle_btn, null);
        Context context5 = getContext();
        kotlin.jvm.internal.s.g(context5, "context");
        this.f10620i = us.pinguo.util.g.b(context5, 12.0f);
        Context context6 = getContext();
        kotlin.jvm.internal.s.g(context6, "context");
        this.f10621j = us.pinguo.util.g.b(context6, 2.0f);
        Context context7 = getContext();
        kotlin.jvm.internal.s.g(context7, "context");
        this.f10622k = us.pinguo.util.g.b(context7, 1.0f);
        Context context8 = getContext();
        kotlin.jvm.internal.s.g(context8, "context");
        this.f10623l = us.pinguo.util.g.b(context8, 5.0f);
        Context context9 = getContext();
        kotlin.jvm.internal.s.g(context9, "context");
        this.m = us.pinguo.util.g.b(context9, 10.0f);
        Context context10 = getContext();
        kotlin.jvm.internal.s.g(context10, "context");
        this.n = us.pinguo.util.g.b(context10, 15.0f);
        this.o = new PointF();
        this.q = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        paint.setStyle(Paint.Style.STROKE);
    }

    public final PointF a() {
        return this.a;
    }

    public final int b() {
        return this.f10616e;
    }

    public final float c() {
        return this.b;
    }

    public final boolean d(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        float x = event.getX();
        float y = event.getY();
        PointF pointF = this.a;
        float f2 = x - pointF.x;
        float f3 = y - pointF.y;
        float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
        int action = event.getAction() & event.getActionMasked();
        if (action == 0) {
            PointF pointF2 = this.o;
            pointF2.x = x;
            pointF2.y = y;
            this.p = sqrt;
        } else if (action == 2) {
            int i2 = this.f10616e;
            boolean z = false;
            if (i2 == 2 || this.f10617f) {
                return false;
            }
            if (i2 == 3) {
                if (Math.abs(x - this.o.x) >= ((float) this.q) || Math.abs(y - this.o.y) >= ((float) this.q)) {
                    float f4 = this.b;
                    if (sqrt <= this.n + f4 && sqrt >= f4 - this.m) {
                        this.f10616e = 1;
                    } else if (sqrt < f4 - this.m) {
                        this.f10616e = 0;
                    }
                }
            }
            int i3 = this.f10616e;
            if (i3 == 1) {
                float f5 = this.b + (sqrt - this.p);
                float f6 = this.c;
                if (f5 <= this.f10615d && f6 <= f5) {
                    z = true;
                }
                if (z) {
                    this.b = f5;
                    this.p = sqrt;
                    invalidate();
                }
            } else if (i3 == 0) {
                float f7 = this.a.x + (x - this.o.x);
                if (f7 >= 0.0f && f7 <= getWidth()) {
                    this.a.x = f7;
                    this.o.x = x;
                }
                float f8 = this.a.y + (y - this.o.y);
                if (f8 >= 0.0f && f8 <= getHeight()) {
                    this.a.y = f8;
                    this.o.y = y;
                }
                invalidate();
            }
        }
        return super.onTouchEvent(event);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0280  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.BodyShapingGestureView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a.x = getMeasuredWidth() * 0.5f;
        this.a.y = getMeasuredHeight() * 0.5f;
    }

    public final void setDragMode(int i2) {
        this.f10616e = i2;
    }

    public final void setFreezed(boolean z) {
        this.f10617f = z;
    }

    public final void setMaxRadius(float f2) {
        this.f10615d = f2;
    }

    public final void setMinRadius(float f2) {
        this.c = f2;
    }

    public final void setRadius(float f2) {
        this.b = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodyShapingGestureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new PointF();
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.b = us.pinguo.util.g.b(context2, 38.0f);
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.c = us.pinguo.util.g.b(context3, 20.0f);
        Context context4 = getContext();
        kotlin.jvm.internal.s.g(context4, "context");
        this.f10615d = us.pinguo.util.h.i(context4) * 0.5f;
        this.f10616e = 3;
        Paint paint = new Paint(1);
        this.f10618g = paint;
        this.f10619h = getResources().getDrawable(R.drawable.edit_body_shape_cirle_btn, null);
        Context context5 = getContext();
        kotlin.jvm.internal.s.g(context5, "context");
        this.f10620i = us.pinguo.util.g.b(context5, 12.0f);
        Context context6 = getContext();
        kotlin.jvm.internal.s.g(context6, "context");
        this.f10621j = us.pinguo.util.g.b(context6, 2.0f);
        Context context7 = getContext();
        kotlin.jvm.internal.s.g(context7, "context");
        this.f10622k = us.pinguo.util.g.b(context7, 1.0f);
        Context context8 = getContext();
        kotlin.jvm.internal.s.g(context8, "context");
        this.f10623l = us.pinguo.util.g.b(context8, 5.0f);
        Context context9 = getContext();
        kotlin.jvm.internal.s.g(context9, "context");
        this.m = us.pinguo.util.g.b(context9, 10.0f);
        Context context10 = getContext();
        kotlin.jvm.internal.s.g(context10, "context");
        this.n = us.pinguo.util.g.b(context10, 15.0f);
        this.o = new PointF();
        this.q = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        paint.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodyShapingGestureView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new PointF();
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.b = us.pinguo.util.g.b(context2, 38.0f);
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.c = us.pinguo.util.g.b(context3, 20.0f);
        Context context4 = getContext();
        kotlin.jvm.internal.s.g(context4, "context");
        this.f10615d = us.pinguo.util.h.i(context4) * 0.5f;
        this.f10616e = 3;
        Paint paint = new Paint(1);
        this.f10618g = paint;
        this.f10619h = getResources().getDrawable(R.drawable.edit_body_shape_cirle_btn, null);
        Context context5 = getContext();
        kotlin.jvm.internal.s.g(context5, "context");
        this.f10620i = us.pinguo.util.g.b(context5, 12.0f);
        Context context6 = getContext();
        kotlin.jvm.internal.s.g(context6, "context");
        this.f10621j = us.pinguo.util.g.b(context6, 2.0f);
        Context context7 = getContext();
        kotlin.jvm.internal.s.g(context7, "context");
        this.f10622k = us.pinguo.util.g.b(context7, 1.0f);
        Context context8 = getContext();
        kotlin.jvm.internal.s.g(context8, "context");
        this.f10623l = us.pinguo.util.g.b(context8, 5.0f);
        Context context9 = getContext();
        kotlin.jvm.internal.s.g(context9, "context");
        this.m = us.pinguo.util.g.b(context9, 10.0f);
        Context context10 = getContext();
        kotlin.jvm.internal.s.g(context10, "context");
        this.n = us.pinguo.util.g.b(context10, 15.0f);
        this.o = new PointF();
        this.q = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        paint.setStyle(Paint.Style.STROKE);
    }
}
