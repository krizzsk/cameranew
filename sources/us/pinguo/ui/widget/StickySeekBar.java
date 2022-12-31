package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.h0;
import kotlin.jvm.internal.s;
import us.pinguo.ui.R;
/* compiled from: StickySeekBar.kt */
/* loaded from: classes6.dex */
public final class StickySeekBar extends View {
    private static final int L = Color.parseColor("#4DD8D8D8");
    private static final int M = Color.parseColor("#FFE6E6E6");
    private boolean A;
    private float B;
    private DefaultDotStyle C;
    private boolean D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private final RectF J;
    private LinearGradient K;
    private h a;
    private final Paint b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final float f12234d;

    /* renamed from: e  reason: collision with root package name */
    private final float f12235e;

    /* renamed from: f  reason: collision with root package name */
    private final float f12236f;

    /* renamed from: g  reason: collision with root package name */
    private final float f12237g;

    /* renamed from: h  reason: collision with root package name */
    private l f12238h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f12239i;

    /* renamed from: j  reason: collision with root package name */
    private final int f12240j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f12241k;

    /* renamed from: l  reason: collision with root package name */
    private final int f12242l;
    private float m;
    private Float n;
    private Float o;
    private int p;
    private float q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private float w;
    private float x;
    private float y;
    private TouchType z;

    /* compiled from: StickySeekBar.kt */
    /* loaded from: classes6.dex */
    public enum DefaultDotStyle {
        RECT,
        CIRCLE,
        NONE
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickySeekBar(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.b = new Paint(1);
        Context context2 = getContext();
        s.g(context2, "context");
        this.c = us.pinguo.util.g.b(context2, 2.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f12234d = us.pinguo.util.g.b(context3, 3.0f);
        Context context4 = getContext();
        s.g(context4, "context");
        this.f12235e = us.pinguo.util.g.b(context4, 2.0f);
        Context context5 = getContext();
        s.g(context5, "context");
        this.f12236f = us.pinguo.util.g.b(context5, 10.0f);
        Context context6 = getContext();
        s.g(context6, "context");
        this.f12237g = us.pinguo.util.g.b(context6, 8.0f);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_bubble);
        s.e(drawable);
        s.g(drawable, "getDrawable(context, R.drawable.ic_bubble)!!");
        this.f12238h = new l(drawable);
        this.f12239i = new int[]{L};
        int color = getResources().getColor(R.color.color_camera_theme_black);
        this.f12240j = color;
        this.f12241k = new int[2];
        this.f12242l = 4;
        Context context7 = getContext();
        s.g(context7, "context");
        this.m = us.pinguo.util.g.b(context7, 12.0f);
        this.p = -1;
        Context context8 = getContext();
        s.g(context8, "context");
        this.q = us.pinguo.util.g.b(context8, 12.0f);
        this.r = color;
        this.s = M;
        this.t = color;
        this.u = true;
        Context context9 = getContext();
        s.g(context9, "context");
        this.y = us.pinguo.util.g.b(context9, 8.0f);
        this.z = TouchType.CONTINUOUS;
        this.A = true;
        this.B = Float.NaN;
        this.C = DefaultDotStyle.CIRCLE;
        this.D = true;
        this.F = 100;
        this.G = true;
        this.J = new RectF();
        f(null, 0);
    }

    private final float a(float f2) {
        float measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0.0f) {
            measuredWidth = getLayoutParams().width;
        }
        if (measuredWidth <= 0.0f) {
            return 0.0f;
        }
        int i2 = this.E;
        if (i2 >= 0) {
            float f3 = this.y;
            return (((f2 - f3) / (measuredWidth - (f3 * 2.0f))) * (this.F - i2)) + i2;
        }
        return ((f2 - this.w) / (measuredWidth - (this.y * 2.0f))) * (this.F - i2);
    }

    private final float b(int i2) {
        int i3;
        float measuredWidth = getMeasuredWidth();
        if (measuredWidth <= 0.0f) {
            measuredWidth = getLayoutParams().width;
        }
        if (measuredWidth <= 0.0f) {
            return this.y;
        }
        if (this.E >= 0) {
            float f2 = this.y;
            return f2 + (((i2 - i3) / (this.F - i3)) * (measuredWidth - (2.0f * f2)));
        }
        return this.w + ((i2 / (this.F - i3)) * (measuredWidth - (this.y * 2.0f)));
    }

    private final void f(AttributeSet attributeSet, int i2) {
        kotlin.z.d h2;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.StickySeekBar, i2, 0);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…ickySeekBar, defStyle, 0)");
        h2 = kotlin.z.j.h(0, obtainStyledAttributes.getIndexCount());
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            int index = obtainStyledAttributes.getIndex(((h0) it).nextInt());
            if (index == R.styleable.StickySeekBar_mainColor || index == d()) {
                setMainColor(obtainStyledAttributes.getColor(index, this.f12240j));
            } else if (index == R.styleable.StickySeekBar_enableBubble) {
                setEnableBubble(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == R.styleable.StickySeekBar_roundEnd) {
                this.A = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.StickySeekBar_enableDiscrete) {
                setEnableDiscrete(obtainStyledAttributes.getBoolean(index, true));
            } else if (index == R.styleable.StickySeekBar_bubble) {
                l lVar = this.f12238h;
                Drawable drawable = obtainStyledAttributes.getDrawable(index);
                if (drawable == null) {
                    drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_bubble);
                    s.e(drawable);
                    s.g(drawable, "getDrawable(context, R.drawable.ic_bubble)!!");
                }
                lVar.a(drawable);
            } else if (index == R.styleable.StickySeekBar_bubbleBottomGap) {
                Context context = getContext();
                s.g(context, "context");
                setBubbleBottomGap(obtainStyledAttributes.getDimension(index, us.pinguo.util.g.b(context, 12.0f)));
            } else {
                if (index == R.styleable.StickySeekBar_bubbleTextBottomGap) {
                    float dimension = obtainStyledAttributes.getDimension(index, Float.NaN);
                    setBubbleTextBottomGap(Float.isNaN(dimension) ? null : Float.valueOf(dimension));
                } else if (index == R.styleable.StickySeekBar_bubbleTextLeftGap) {
                    float dimension2 = obtainStyledAttributes.getDimension(index, Float.NaN);
                    setBubbleTextLeftGap(Float.isNaN(dimension2) ? null : Float.valueOf(dimension2));
                } else if (index == R.styleable.StickySeekBar_textColor) {
                    setTextColor(obtainStyledAttributes.getColor(index, -1));
                } else if (index == R.styleable.StickySeekBar_textSize) {
                    Context context2 = getContext();
                    s.g(context2, "context");
                    setTextSize(obtainStyledAttributes.getDimension(index, us.pinguo.util.g.b(context2, 12.0f)));
                } else if (index == R.styleable.StickySeekBar_dotColor) {
                    setDotColor(obtainStyledAttributes.getColor(index, Color.parseColor("#FFE6E6E6")));
                } else if (index == R.styleable.StickySeekBar_indicatorColor) {
                    setIndicatorColor(obtainStyledAttributes.getColor(index, d()));
                }
            }
        }
        obtainStyledAttributes.recycle();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: us.pinguo.ui.widget.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                StickySeekBar.g(StickySeekBar.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(StickySeekBar this$0) {
        s.h(this$0, "this$0");
        this$0.getLocationInWindow(this$0.f12241k);
    }

    public static /* synthetic */ void setValues$default(StickySeekBar stickySeekBar, int i2, int i3, int i4, Integer num, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            num = null;
        }
        stickySeekBar.setValues(i2, i3, i4, num);
    }

    public final float c() {
        return this.m;
    }

    public final int d() {
        return this.r;
    }

    public final int e() {
        return this.I;
    }

    public final void i() {
        getLocationInWindow(this.f12241k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00da, code lost:
        if ((r7 <= r0 && r0 < 1) != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0101  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.ui.widget.StickySeekBar.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.w = getMeasuredWidth() * 0.5f;
        this.x = getMeasuredHeight() * 0.5f;
        this.B = b(this.I);
        if (this.K != null || this.f12239i.length < 2) {
            return;
        }
        this.K = new LinearGradient(this.y, this.x, getMeasuredWidth() - this.y, this.x, this.f12239i, (float[]) null, Shader.TileMode.CLAMP);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r8 != 3) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.ui.widget.StickySeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setBubbleBottomGap(float f2) {
        if (f2 == this.m) {
            return;
        }
        this.m = f2;
        invalidate();
    }

    public final void setBubbleTextBottomGap(Float f2) {
        if (s.b(f2, this.n)) {
            return;
        }
        this.n = f2;
        this.f12238h.c(f2);
    }

    public final void setBubbleTextLeftGap(Float f2) {
        if (s.b(f2, this.o)) {
            return;
        }
        this.o = f2;
        this.f12238h.f(f2);
    }

    public final void setDefaultProgress(int i2) {
        if (i2 != this.H) {
            this.H = i2;
            invalidate();
        }
    }

    public final void setDotColor(int i2) {
        if (i2 != this.s) {
            this.s = i2;
            invalidate();
        }
    }

    public final void setDotStyle(DefaultDotStyle style) {
        s.h(style, "style");
        this.C = style;
        invalidate();
    }

    public final void setEnableBubble(boolean z) {
        this.u = z;
    }

    public final void setEnableDiscrete(boolean z) {
        this.D = z;
    }

    public final void setIndicatorColor(int i2) {
        if (i2 != this.t) {
            this.t = i2;
            invalidate();
        }
    }

    public final void setMainColor(int i2) {
        if (i2 != this.r) {
            this.r = i2;
            int i3 = this.f12240j;
            if (i2 == i3) {
                i3 = getResources().getColor(R.color.color_camera_theme_light);
            }
            setTextColor(i3);
            invalidate();
        }
    }

    public final void setProgress(int i2) {
        if (i2 != this.I) {
            this.I = i2;
            this.B = b(i2);
            invalidate();
        }
    }

    public final void setTextColor(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            this.f12238h.d(i2);
        }
    }

    public final void setTextSize(float f2) {
        if (f2 == this.q) {
            return;
        }
        this.q = f2;
        this.f12238h.e(f2);
    }

    public final void setTrackColor(int... colors) {
        s.h(colors, "colors");
        this.f12239i = colors;
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth > 0 && colors.length >= 2) {
            float f2 = this.y;
            float f3 = this.x;
            this.K = new LinearGradient(f2, f3, measuredWidth - f2, f3, colors, (float[]) null, Shader.TileMode.CLAMP);
        }
        invalidate();
    }

    public final void setTrackListener(h hVar) {
        this.a = hVar;
    }

    public final void setValues(int i2, int i3, int i4, Integer num) {
        boolean z = true;
        if (num != null && i2 != num.intValue()) {
            this.G = true;
            this.H = num.intValue();
        } else {
            this.G = false;
        }
        if (i2 == this.E && i3 == this.F) {
            z = false;
        }
        this.E = i2;
        this.F = i3;
        setProgress(i4);
        if (z) {
            this.B = b(e());
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.b = new Paint(1);
        Context context2 = getContext();
        s.g(context2, "context");
        this.c = us.pinguo.util.g.b(context2, 2.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f12234d = us.pinguo.util.g.b(context3, 3.0f);
        Context context4 = getContext();
        s.g(context4, "context");
        this.f12235e = us.pinguo.util.g.b(context4, 2.0f);
        Context context5 = getContext();
        s.g(context5, "context");
        this.f12236f = us.pinguo.util.g.b(context5, 10.0f);
        Context context6 = getContext();
        s.g(context6, "context");
        this.f12237g = us.pinguo.util.g.b(context6, 8.0f);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_bubble);
        s.e(drawable);
        s.g(drawable, "getDrawable(context, R.drawable.ic_bubble)!!");
        this.f12238h = new l(drawable);
        this.f12239i = new int[]{L};
        int color = getResources().getColor(R.color.color_camera_theme_black);
        this.f12240j = color;
        this.f12241k = new int[2];
        this.f12242l = 4;
        Context context7 = getContext();
        s.g(context7, "context");
        this.m = us.pinguo.util.g.b(context7, 12.0f);
        this.p = -1;
        Context context8 = getContext();
        s.g(context8, "context");
        this.q = us.pinguo.util.g.b(context8, 12.0f);
        this.r = color;
        this.s = M;
        this.t = color;
        this.u = true;
        Context context9 = getContext();
        s.g(context9, "context");
        this.y = us.pinguo.util.g.b(context9, 8.0f);
        this.z = TouchType.CONTINUOUS;
        this.A = true;
        this.B = Float.NaN;
        this.C = DefaultDotStyle.CIRCLE;
        this.D = true;
        this.F = 100;
        this.G = true;
        this.J = new RectF();
        f(attrs, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickySeekBar(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.b = new Paint(1);
        Context context2 = getContext();
        s.g(context2, "context");
        this.c = us.pinguo.util.g.b(context2, 2.0f);
        Context context3 = getContext();
        s.g(context3, "context");
        this.f12234d = us.pinguo.util.g.b(context3, 3.0f);
        Context context4 = getContext();
        s.g(context4, "context");
        this.f12235e = us.pinguo.util.g.b(context4, 2.0f);
        Context context5 = getContext();
        s.g(context5, "context");
        this.f12236f = us.pinguo.util.g.b(context5, 10.0f);
        Context context6 = getContext();
        s.g(context6, "context");
        this.f12237g = us.pinguo.util.g.b(context6, 8.0f);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_bubble);
        s.e(drawable);
        s.g(drawable, "getDrawable(context, R.drawable.ic_bubble)!!");
        this.f12238h = new l(drawable);
        this.f12239i = new int[]{L};
        int color = getResources().getColor(R.color.color_camera_theme_black);
        this.f12240j = color;
        this.f12241k = new int[2];
        this.f12242l = 4;
        Context context7 = getContext();
        s.g(context7, "context");
        this.m = us.pinguo.util.g.b(context7, 12.0f);
        this.p = -1;
        Context context8 = getContext();
        s.g(context8, "context");
        this.q = us.pinguo.util.g.b(context8, 12.0f);
        this.r = color;
        this.s = M;
        this.t = color;
        this.u = true;
        Context context9 = getContext();
        s.g(context9, "context");
        this.y = us.pinguo.util.g.b(context9, 8.0f);
        this.z = TouchType.CONTINUOUS;
        this.A = true;
        this.B = Float.NaN;
        this.C = DefaultDotStyle.CIRCLE;
        this.D = true;
        this.F = 100;
        this.G = true;
        this.J = new RectF();
        f(attrs, i2);
    }
}
