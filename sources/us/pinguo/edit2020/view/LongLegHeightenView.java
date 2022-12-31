package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import java.util.Iterator;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.LongLegMode;
/* compiled from: LongLegHeightenView.kt */
/* loaded from: classes4.dex */
public final class LongLegHeightenView extends View {
    private h0 a;
    private g0 b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private LongLegMode f10690d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10691e;

    /* renamed from: f  reason: collision with root package name */
    private float f10692f;

    /* renamed from: g  reason: collision with root package name */
    private float f10693g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f10694h;

    /* renamed from: i  reason: collision with root package name */
    private final Drawable f10695i;

    /* renamed from: j  reason: collision with root package name */
    private final Drawable f10696j;

    /* renamed from: k  reason: collision with root package name */
    private float f10697k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f10698l;
    private final TextPaint m;
    private StaticLayout n;
    private final String o;
    private final float p;
    private final float q;
    private final int r;
    private final int s;
    private boolean t;
    private PointF u;
    private float v;
    private boolean w;
    private boolean x;

    /* compiled from: LongLegHeightenView.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LongLegMode.values().length];
            iArr[LongLegMode.Vertical.ordinal()] = 1;
            iArr[LongLegMode.Horizontal.ordinal()] = 2;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongLegHeightenView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_rotate);
        this.f10694h = drawable;
        this.f10695i = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_vertical);
        this.f10696j = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_horizontal);
        this.f10697k = drawable == null ? 0.0f : drawable.getIntrinsicWidth();
        this.f10698l = new Paint(1);
        TextPaint textPaint = new TextPaint(1);
        this.m = textPaint;
        String string = getContext().getString(R.string.long_leg_heighten_tip);
        kotlin.jvm.internal.s.g(string, "context.getString(R.string.long_leg_heighten_tip)");
        this.o = string;
        float b = us.pinguo.common.widget.i.a.b(12);
        this.p = b;
        this.r = 32;
        this.s = Color.parseColor("#2BFF0000");
        this.w = kotlin.jvm.internal.s.c(getContext().getString(R.string.vertical_character), "1");
        textPaint.setTextSize(b);
        textPaint.setColor(-1);
        this.q = textPaint.measureText(string);
    }

    private final void a(Canvas canvas) {
        String str;
        StaticLayout staticLayout = this.n;
        if (staticLayout == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                String str2 = this.o;
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(str2, 0, str2.length() - 1, this.m, getWidth() - (this.r * 2));
                kotlin.jvm.internal.s.g(obtain, "obtain(\n                …Padding\n                )");
                obtain.setBreakStrategy(1);
                obtain.setAlignment(Layout.Alignment.ALIGN_CENTER);
                obtain.setLineSpacing(0.0f, 1.0f);
                obtain.setMaxLines(2);
                obtain.setText(this.o);
                staticLayout = obtain.build();
            } else {
                staticLayout = new StaticLayout(this.o, 0, str.length() - 1, this.m, getWidth() - (this.r * 2), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true, null, 0);
            }
            this.n = staticLayout;
        }
        if (staticLayout.getHeight() <= Math.abs(this.f10692f - this.f10693g)) {
            this.m.setTextAlign(Paint.Align.LEFT);
            float f2 = this.r;
            int save = canvas.save();
            canvas.translate(f2, ((this.f10692f + this.f10693g) - staticLayout.getHeight()) * 0.5f);
            try {
                staticLayout.draw(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    private final void b(Canvas canvas) {
        if (Math.abs(this.f10692f - this.f10693g) > this.p + us.pinguo.common.widget.i.a.b(6)) {
            this.m.setTextAlign(Paint.Align.LEFT);
            float f2 = (this.f10692f + this.f10693g) * 0.5f;
            float height = getHeight() * 0.5f;
            int save = canvas.save();
            canvas.rotate(90.0f, f2, height);
            try {
                canvas.drawText(this.o, f2 - (this.q * 0.5f), (height + (this.p * 0.5f)) - (this.m.descent() * 0.5f), this.m);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    private final void c(Canvas canvas) {
        kotlin.z.d h2;
        if (Math.abs(this.f10692f - this.f10693g) > this.p + us.pinguo.common.widget.i.a.b(6)) {
            this.m.setTextAlign(Paint.Align.CENTER);
            float f2 = (this.f10692f + this.f10693g) * 0.5f;
            float height = ((getHeight() - this.q) * 0.5f) + this.p;
            h2 = kotlin.z.j.h(0, this.o.length());
            Iterator<Integer> it = h2.iterator();
            float f3 = height;
            while (it.hasNext()) {
                int nextInt = ((kotlin.collections.h0) it).nextInt();
                canvas.drawText(this.o, nextInt, nextInt + 1, f2, f3, (Paint) this.m);
                f3 += this.p;
            }
        }
    }

    private final boolean e(float f2, float f3, float f4, float f5, float f6, float f7) {
        if (f4 <= f2 && f2 <= f6) {
            if (f5 <= f3 && f3 <= f7) {
                return true;
            }
        }
        return false;
    }

    private final void f(boolean z) {
        LongLegMode longLegMode = this.f10690d;
        if (longLegMode == LongLegMode.Vertical) {
            float f2 = this.f10692f;
            float f3 = this.f10693g;
            if (f2 <= f3) {
                g0 g0Var = this.b;
                if (g0Var == null) {
                    return;
                }
                g0Var.a(0.0f, f2, getMeasuredWidth(), this.f10693g, z);
                return;
            }
            g0 g0Var2 = this.b;
            if (g0Var2 == null) {
                return;
            }
            g0Var2.a(0.0f, f3, getMeasuredWidth(), this.f10692f, z);
        } else if (longLegMode == LongLegMode.Horizontal) {
            float f4 = this.f10692f;
            float f5 = this.f10693g;
            if (f4 <= f5) {
                g0 g0Var3 = this.b;
                if (g0Var3 == null) {
                    return;
                }
                g0Var3.a(f4, 0.0f, f5, getMeasuredHeight(), z);
                return;
            }
            g0 g0Var4 = this.b;
            if (g0Var4 == null) {
                return;
            }
            g0Var4.a(f5, 0.0f, f4, getMeasuredHeight(), z);
        }
    }

    public final void d(boolean z) {
        if (z == this.x) {
            return;
        }
        this.x = z;
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x019f, code lost:
        if (r1 != 0) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0274, code lost:
        if (r1 != 0) goto L168;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.LongLegHeightenView.g(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        if (this.x) {
            return;
        }
        Drawable drawable = this.f10694h;
        float intrinsicWidth = (drawable == null ? 0.0f : drawable.getIntrinsicWidth()) * 0.5f;
        float f2 = this.f10692f;
        float f3 = this.f10693g;
        if (this.f10690d == LongLegMode.Vertical) {
            if (this.f10691e) {
                this.f10698l.setStyle(Paint.Style.FILL);
                this.f10698l.setColor(this.s);
                if (this.f10692f < this.f10693g) {
                    canvas.drawRect(0.0f, f2, getWidth(), f3, this.f10698l);
                } else {
                    canvas.drawRect(0.0f, f3, getWidth(), f2, this.f10698l);
                }
                a(canvas);
            }
            this.f10698l.setColor(-1);
            this.f10698l.setStrokeWidth(us.pinguo.common.widget.i.a.a(1));
            canvas.drawLine(0.0f, f2, getWidth(), f2, this.f10698l);
            canvas.drawLine(0.0f, f3, getWidth(), f3, this.f10698l);
            Drawable drawable2 = this.f10694h;
            if (drawable2 != null) {
                drawable2.setBounds(0, (int) (f2 - intrinsicWidth), drawable2.getIntrinsicWidth(), (int) (f2 + intrinsicWidth));
                drawable2.draw(canvas);
            }
            if (this.c == 1) {
                Drawable drawable3 = this.f10695i;
                if (drawable3 == null) {
                    return;
                }
                drawable3.setBounds(getWidth() - drawable3.getIntrinsicWidth(), (int) (f3 - intrinsicWidth), getWidth(), (int) (f3 + intrinsicWidth));
                drawable3.draw(canvas);
                drawable3.setBounds(getWidth() - drawable3.getIntrinsicWidth(), (int) (f2 - intrinsicWidth), getWidth(), (int) (f2 + intrinsicWidth));
                drawable3.draw(canvas);
                return;
            }
            Drawable drawable4 = this.f10695i;
            if (drawable4 == null) {
                return;
            }
            drawable4.setBounds(getWidth() - drawable4.getIntrinsicWidth(), (int) (f2 - intrinsicWidth), getWidth(), (int) (f2 + intrinsicWidth));
            drawable4.draw(canvas);
            drawable4.setBounds(getWidth() - drawable4.getIntrinsicWidth(), (int) (f3 - intrinsicWidth), getWidth(), (int) (f3 + intrinsicWidth));
            drawable4.draw(canvas);
            return;
        }
        if (this.f10691e) {
            this.f10698l.setStyle(Paint.Style.FILL);
            this.f10698l.setColor(this.s);
            float f4 = this.f10692f;
            float f5 = this.f10693g;
            if (f4 < f5) {
                canvas.drawRect(f4, 0.0f, f5, getHeight(), this.f10698l);
            } else {
                canvas.drawRect(f5, 0.0f, f4, getHeight(), this.f10698l);
            }
            if (this.w) {
                c(canvas);
            } else {
                b(canvas);
            }
        }
        this.f10698l.setColor(-1);
        this.f10698l.setStrokeWidth(us.pinguo.common.widget.i.a.a(1));
        canvas.drawLine(f2, 0.0f, f2, getHeight(), this.f10698l);
        canvas.drawLine(f3, 0.0f, f3, getHeight(), this.f10698l);
        Drawable drawable5 = this.f10694h;
        if (drawable5 != null) {
            drawable5.setBounds((int) (f3 - intrinsicWidth), 0, (int) (f3 + intrinsicWidth), drawable5.getIntrinsicHeight());
            drawable5.draw(canvas);
        }
        if (this.c == 1) {
            Drawable drawable6 = this.f10696j;
            if (drawable6 == null) {
                return;
            }
            drawable6.setBounds((int) (f3 - intrinsicWidth), getHeight() - drawable6.getIntrinsicHeight(), (int) (f3 + intrinsicWidth), getHeight());
            drawable6.draw(canvas);
            drawable6.setBounds((int) (f2 - intrinsicWidth), getHeight() - drawable6.getIntrinsicHeight(), (int) (f2 + intrinsicWidth), getHeight());
            drawable6.draw(canvas);
            return;
        }
        Drawable drawable7 = this.f10696j;
        if (drawable7 == null) {
            return;
        }
        drawable7.setBounds((int) (f2 - intrinsicWidth), getHeight() - drawable7.getIntrinsicHeight(), (int) (f2 + intrinsicWidth), getHeight());
        drawable7.draw(canvas);
        drawable7.setBounds((int) (f3 - intrinsicWidth), getHeight() - drawable7.getIntrinsicHeight(), (int) (f3 + intrinsicWidth), getHeight());
        drawable7.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        LongLegMode longLegMode = this.f10690d;
        if (longLegMode == LongLegMode.Vertical) {
            float f2 = this.v;
            float measuredHeight = (getMeasuredHeight() - f2) * 0.5f;
            this.f10692f = measuredHeight;
            this.f10693g = measuredHeight + f2;
        } else if (longLegMode == LongLegMode.Horizontal) {
            float f3 = this.v;
            float measuredWidth = (getMeasuredWidth() - f3) * 0.5f;
            this.f10692f = measuredWidth;
            this.f10693g = measuredWidth + f3;
        }
        f(false);
    }

    public final void setFrameSize(float f2) {
        float f3;
        float f4;
        int width;
        float abs = (f2 - Math.abs(this.f10693g - this.f10692f)) * 0.5f;
        float f5 = this.f10692f;
        float f6 = this.f10693g;
        if (f5 <= f6) {
            f3 = f5 - abs;
            f4 = f6 + abs;
        } else {
            f3 = f5 + abs;
            f4 = f6 - abs;
        }
        Drawable drawable = this.f10694h;
        float intrinsicWidth = (drawable == null ? 0.0f : drawable.getIntrinsicWidth()) * 0.5f;
        if (this.f10690d == LongLegMode.Vertical) {
            width = getHeight();
        } else {
            width = getWidth();
        }
        float f7 = width - intrinsicWidth;
        if (f3 < intrinsicWidth) {
            f3 = intrinsicWidth;
        } else if (f3 > f7) {
            f3 = f7;
        }
        this.f10692f = f3;
        if (f4 < intrinsicWidth) {
            f4 = intrinsicWidth;
        } else if (f4 > f7) {
            f4 = f7;
        }
        this.f10693g = f4;
        invalidate();
    }

    public final void setMode(LongLegMode mode, float f2) {
        kotlin.jvm.internal.s.h(mode, "mode");
        this.f10690d = mode;
        this.v = f2;
        if (mode == LongLegMode.Vertical) {
            float height = (getHeight() - f2) * 0.5f;
            this.f10692f = height;
            this.f10693g = height + f2;
        } else if (mode == LongLegMode.Horizontal) {
            float width = (getWidth() - f2) * 0.5f;
            this.f10692f = width;
            this.f10693g = width + f2;
        }
        f(false);
        invalidate();
    }

    public final void setOnAreaChangeListener(g0 g0Var) {
        if (kotlin.jvm.internal.s.c(g0Var, this.b)) {
            return;
        }
        this.b = g0Var;
        f(false);
    }

    public final void setOnRotateListener(h0 h0Var) {
        this.a = h0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongLegHeightenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_rotate);
        this.f10694h = drawable;
        this.f10695i = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_vertical);
        this.f10696j = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_horizontal);
        this.f10697k = drawable == null ? 0.0f : drawable.getIntrinsicWidth();
        this.f10698l = new Paint(1);
        TextPaint textPaint = new TextPaint(1);
        this.m = textPaint;
        String string = getContext().getString(R.string.long_leg_heighten_tip);
        kotlin.jvm.internal.s.g(string, "context.getString(R.string.long_leg_heighten_tip)");
        this.o = string;
        float b = us.pinguo.common.widget.i.a.b(12);
        this.p = b;
        this.r = 32;
        this.s = Color.parseColor("#2BFF0000");
        this.w = kotlin.jvm.internal.s.c(getContext().getString(R.string.vertical_character), "1");
        textPaint.setTextSize(b);
        textPaint.setColor(-1);
        this.q = textPaint.measureText(string);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongLegHeightenView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_rotate);
        this.f10694h = drawable;
        this.f10695i = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_vertical);
        this.f10696j = AppCompatResources.getDrawable(getContext(), R.drawable.ic_long_leg_heighten_horizontal);
        this.f10697k = drawable == null ? 0.0f : drawable.getIntrinsicWidth();
        this.f10698l = new Paint(1);
        TextPaint textPaint = new TextPaint(1);
        this.m = textPaint;
        String string = getContext().getString(R.string.long_leg_heighten_tip);
        kotlin.jvm.internal.s.g(string, "context.getString(R.string.long_leg_heighten_tip)");
        this.o = string;
        float b = us.pinguo.common.widget.i.a.b(12);
        this.p = b;
        this.r = 32;
        this.s = Color.parseColor("#2BFF0000");
        this.w = kotlin.jvm.internal.s.c(getContext().getString(R.string.vertical_character), "1");
        textPaint.setTextSize(b);
        textPaint.setColor(-1);
        this.q = textPaint.measureText(string);
    }
}
