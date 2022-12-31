package us.pinguo.edit2020.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: CircleView.kt */
/* loaded from: classes4.dex */
public final class CircleView extends AppCompatImageView {
    private final AttributeSet a;
    private final int b;
    private Paint c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f10640d;

    /* renamed from: e  reason: collision with root package name */
    private int f10641e;

    /* renamed from: f  reason: collision with root package name */
    private float f10642f;

    /* renamed from: g  reason: collision with root package name */
    private float f10643g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10644h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ CircleView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void a(Context context) {
        Paint paint = new Paint(1);
        this.c = paint;
        if (paint != null) {
            paint.setDither(true);
            Paint paint2 = new Paint(1);
            this.f10640d = paint2;
            if (paint2 != null) {
                paint2.setStyle(Paint.Style.STROKE);
                Paint paint3 = this.f10640d;
                if (paint3 != null) {
                    paint3.setDither(true);
                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.a, R.styleable.CircleView, this.b, 0);
                    kotlin.jvm.internal.s.g(obtainStyledAttributes, "context.obtainStyledAttr….CircleView, defStyle, 0)");
                    setStrokeColor(obtainStyledAttributes.getColor(R.styleable.CircleView_selectedStrokeColor, ViewCompat.MEASURED_STATE_MASK));
                    this.f10642f = obtainStyledAttributes.getDimension(R.styleable.CircleView_selectedStrokeWidth, 6.0f);
                    this.f10643g = obtainStyledAttributes.getDimension(R.styleable.CircleView_strokeDistance, 6.0f);
                    obtainStyledAttributes.recycle();
                    Paint paint4 = this.f10640d;
                    if (paint4 != null) {
                        paint4.setStrokeWidth(this.f10642f);
                        return;
                    } else {
                        kotlin.jvm.internal.s.z("strokePaint");
                        throw null;
                    }
                }
                kotlin.jvm.internal.s.z("strokePaint");
                throw null;
            }
            kotlin.jvm.internal.s.z("strokePaint");
            throw null;
        }
        kotlin.jvm.internal.s.z("circlePaint");
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f10644h) {
            super.onDraw(canvas);
        } else if (canvas != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            float f2 = paddingLeft + (width / 2.0f);
            float f3 = paddingTop + (height / 2.0f);
            float min = Math.min(width, height) / 2.0f;
            if (isSelected()) {
                float f4 = min - (this.f10642f / 2);
                Paint paint = this.f10640d;
                if (paint != null) {
                    canvas.drawCircle(f2, f3, f4, paint);
                    Paint paint2 = this.c;
                    if (paint2 != null) {
                        paint2.setColor(this.f10641e);
                        float f5 = (min - this.f10643g) - this.f10642f;
                        Paint paint3 = this.c;
                        if (paint3 != null) {
                            canvas.drawCircle(f2, f3, f5, paint3);
                            return;
                        } else {
                            kotlin.jvm.internal.s.z("circlePaint");
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.s.z("circlePaint");
                    throw null;
                }
                kotlin.jvm.internal.s.z("strokePaint");
                throw null;
            }
            Paint paint4 = this.c;
            if (paint4 != null) {
                canvas.drawCircle(f2, f3, min, paint4);
            } else {
                kotlin.jvm.internal.s.z("circlePaint");
                throw null;
            }
        }
    }

    public final void setCircleColor(int i2) {
        this.f10641e = i2;
        Paint paint = this.c;
        if (paint != null) {
            paint.setColor(i2);
        } else {
            kotlin.jvm.internal.s.z("circlePaint");
            throw null;
        }
    }

    public final void setCustomDraw(boolean z) {
        this.f10644h = z;
    }

    public final void setStrokeColor(int i2) {
        Paint paint = this.f10640d;
        if (paint != null) {
            paint.setColor(i2);
        } else {
            kotlin.jvm.internal.s.z("strokePaint");
            throw null;
        }
    }

    public final void setStrokeWidth(float f2) {
        this.f10642f = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = attributeSet;
        this.b = i2;
        this.f10641e = SupportMenu.CATEGORY_MASK;
        this.f10642f = 6.0f;
        this.f10643g = 6.0f;
        this.f10644h = true;
        a(context);
    }
}
