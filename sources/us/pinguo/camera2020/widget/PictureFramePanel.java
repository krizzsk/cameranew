package us.pinguo.camera2020.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
/* compiled from: PictureFramePanel.kt */
/* loaded from: classes3.dex */
public final class PictureFramePanel extends View {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9490d;

    /* renamed from: e  reason: collision with root package name */
    private int f9491e;

    /* renamed from: f  reason: collision with root package name */
    private int f9492f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f9493g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f9494h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9495i;

    /* renamed from: j  reason: collision with root package name */
    private int f9496j;

    /* renamed from: k  reason: collision with root package name */
    private int f9497k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f9498l;
    private boolean m;
    private f n;
    private int o;
    private int p;
    private boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureFramePanel(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = -1;
        this.f9493g = new Paint(1);
        this.f9494h = new Paint(1);
        this.f9495i = 200;
        this.f9498l = new Paint(1);
        a(null, 0);
    }

    private final void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PictureFramePanel, i2, 0);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…eFramePanel, defStyle, 0)");
        this.f9493g.setStyle(Paint.Style.FILL);
        int color = obtainStyledAttributes.getColor(R.styleable.PictureFramePanel_color, -1);
        this.a = color;
        this.f9493g.setColor(color);
        this.f9494h.setColor(ViewCompat.MEASURED_STATE_MASK);
        obtainStyledAttributes.recycle();
        setBackground(null);
        this.f9498l.setColor(getContext().getResources().getColor(R.color.color_view_finder_grid));
        this.f9498l.setStrokeWidth(getContext().getResources().getDimension(R.dimen.view_finder_grid_line_width));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PictureFramePanel this$0) {
        s.h(this$0, "this$0");
        f fVar = this$0.n;
        if (fVar == null) {
            return;
        }
        fVar.a();
    }

    public final boolean b(float f2) {
        return f2 > ((float) this.c) && f2 < ((float) (getMeasuredHeight() - this.f9491e));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        Paint paint = this.f9493g;
        Paint paint2 = this.f9494h;
        float measuredHeight = getMeasuredHeight();
        float measuredWidth = getMeasuredWidth();
        float f2 = this.f9490d;
        float f3 = this.b;
        int i2 = this.f9496j;
        float f4 = i2;
        if (f3 > 0.0f) {
            if (i2 > 0) {
                if (this.f9491e > this.f9497k) {
                    canvas.drawRect(0.0f, 0.0f, measuredWidth, f4, paint);
                } else {
                    canvas.drawRect(0.0f, 0.0f, measuredWidth, f4, paint2);
                }
            }
            if (f3 > this.f9496j) {
                if (this.f9491e > this.f9497k) {
                    canvas.drawRect(0.0f, f4, measuredWidth, f3, paint);
                } else {
                    canvas.drawRect(0.0f, f4, measuredWidth, f3, paint2);
                }
            }
        }
        if (f2 > 0.0f) {
            int i3 = this.f9491e;
            int i4 = this.f9497k;
            if (i3 > i4) {
                canvas.drawRect(0.0f, measuredHeight - f2, measuredWidth, measuredHeight, paint);
            } else if (i3 > 0) {
                if (f2 > i4) {
                    canvas.drawRect(0.0f, measuredHeight - f2, measuredWidth, measuredHeight, paint);
                }
                int i5 = this.f9490d;
                int i6 = this.f9491e;
                if (i5 == i6) {
                    canvas.drawRect(0.0f, measuredHeight - i6, measuredWidth, measuredHeight, paint2);
                }
            } else {
                canvas.drawRect(0.0f, measuredHeight - f2, measuredWidth, measuredHeight, this.f9492f > i4 ? paint : paint2);
            }
        }
        if (this.m) {
            Paint paint3 = this.f9498l;
            float f5 = measuredWidth / 3.0f;
            float f6 = f5 * 2.0f;
            float f7 = measuredHeight - f2;
            canvas.drawLine(f5, f3, f5, f7, paint3);
            canvas.drawLine(f6, f3, f6, f7, paint3);
            float f8 = ((measuredHeight - f3) - f2) / 3.0f;
            float f9 = f3 + f8;
            float f10 = f9 + f8;
            canvas.drawLine(0.0f, f9, measuredWidth, f9, paint3);
            canvas.drawLine(0.0f, f10, measuredWidth, f10, paint3);
        }
        if (this.f9490d == this.f9491e && this.b == this.c) {
            if (this.o != 0) {
                this.o = 0;
            }
            if (this.p != 0) {
                this.p = 0;
            }
            if (this.q) {
                this.q = false;
                post(new Runnable() { // from class: us.pinguo.camera2020.widget.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        PictureFramePanel.d(PictureFramePanel.this);
                    }
                });
                return;
            }
            return;
        }
        int i7 = this.b;
        int i8 = this.c;
        if (i7 != i8) {
            if (Math.abs(i8 - i7) <= Math.abs(this.o)) {
                this.b = this.c;
            } else {
                this.b += this.o;
            }
        }
        int i9 = this.f9490d;
        int i10 = this.f9491e;
        if (i9 != i10) {
            if (Math.abs(i10 - i9) <= Math.abs(this.p)) {
                this.f9490d = this.f9491e;
            } else {
                this.f9490d += this.p;
            }
        }
        invalidate();
    }

    public final void setBottomBlackHeight(int i2) {
        this.f9497k = i2;
    }

    public final void setEnableGrid(boolean z) {
        if (z != this.m) {
            this.m = z;
            invalidate();
        }
    }

    public final void setHaircutHeight(int i2) {
        this.f9496j = i2;
    }

    public final void setOnRatioAnimatorListener(f l2) {
        s.h(l2, "l");
        this.n = l2;
    }

    public final void setUpperAndLowerHeight(int i2, int i3, boolean z) {
        int i4;
        this.c = i2;
        this.f9492f = this.f9491e;
        this.f9491e = i3;
        if (z) {
            int i5 = this.b;
            float f2 = this.f9495i / 16;
            this.o = (int) (((i2 - i5) / f2) + (i2 >= i5 ? 1 : -1));
            this.p = (int) (((i3 - i4) / f2) + (i3 >= this.f9490d ? 1 : -1));
            f fVar = this.n;
            if (fVar != null) {
                fVar.onStart();
            }
            this.q = true;
            invalidate();
            return;
        }
        this.b = i2;
        this.f9490d = i3;
        this.q = false;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureFramePanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = -1;
        this.f9493g = new Paint(1);
        this.f9494h = new Paint(1);
        this.f9495i = 200;
        this.f9498l = new Paint(1);
        a(attrs, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureFramePanel(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = -1;
        this.f9493g = new Paint(1);
        this.f9494h = new Paint(1);
        this.f9495i = 200;
        this.f9498l = new Paint(1);
        a(attrs, i2);
    }
}
