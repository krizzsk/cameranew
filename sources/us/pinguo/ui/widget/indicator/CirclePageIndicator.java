package us.pinguo.ui.widget.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class CirclePageIndicator extends View implements ViewPager.OnPageChangeListener {
    private float a;
    private final Paint b;
    private final Paint c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f12297d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager f12298e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager.OnPageChangeListener f12299f;

    /* renamed from: g  reason: collision with root package name */
    private int f12300g;

    /* renamed from: h  reason: collision with root package name */
    private int f12301h;

    /* renamed from: i  reason: collision with root package name */
    private float f12302i;

    /* renamed from: j  reason: collision with root package name */
    private int f12303j;

    /* renamed from: k  reason: collision with root package name */
    private int f12304k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12305l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private boolean q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;

        /* loaded from: classes6.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    private int a(int i2) {
        ViewPager viewPager;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || (viewPager = this.f12298e) == null) {
            return size;
        }
        int count = viewPager.getAdapter().getCount();
        float f2 = this.a;
        int paddingLeft = (int) (getPaddingLeft() + getPaddingRight() + (count * 2 * f2) + ((count - 1) * f2) + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingLeft, size) : paddingLeft;
    }

    private int b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.a * 2.0f) + getPaddingTop() + getPaddingBottom() + 1.0f);
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int count;
        int height;
        int paddingTop;
        int paddingBottom;
        int paddingLeft;
        float f2;
        float f3;
        super.onDraw(canvas);
        ViewPager viewPager = this.f12298e;
        if (viewPager == null || (count = viewPager.getAdapter().getCount()) == 0) {
            return;
        }
        if (this.f12300g >= count) {
            setCurrentItem(count - 1);
            return;
        }
        if (this.f12304k == 0) {
            height = getWidth();
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
            paddingLeft = getPaddingTop();
        } else {
            height = getHeight();
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
            paddingLeft = getPaddingLeft();
        }
        float f4 = this.a;
        float f5 = 3.0f * f4;
        float f6 = paddingLeft + f4;
        float f7 = paddingTop + f4;
        if (this.f12305l) {
            f7 += (((height - paddingTop) - paddingBottom) / 2.0f) - ((count * f5) / 2.0f);
        }
        if (this.c.getStrokeWidth() > 0.0f) {
            f4 -= this.c.getStrokeWidth() / 2.0f;
        }
        for (int i2 = 0; i2 < count; i2++) {
            float f8 = (i2 * f5) + f7;
            if (this.f12304k == 0) {
                f3 = f6;
            } else {
                f3 = f8;
                f8 = f6;
            }
            if (this.b.getAlpha() > 0) {
                canvas.drawCircle(f8, f3, f4, this.b);
            }
            float f9 = this.a;
            if (f4 != f9) {
                canvas.drawCircle(f8, f3, f9, this.c);
            }
        }
        boolean z = this.m;
        float f10 = (z ? this.f12301h : this.f12300g) * f5;
        if (!z) {
            f10 += this.f12302i * f5;
        }
        if (this.f12304k == 0) {
            float f11 = f7 + f10;
            f2 = f6;
            f6 = f11;
        } else {
            f2 = f7 + f10;
        }
        canvas.drawCircle(f6, f2, this.a, this.f12297d);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f12304k == 0) {
            setMeasuredDimension(a(i2), b(i3));
        } else {
            setMeasuredDimension(b(i2), a(i3));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        this.f12303j = i2;
        ViewPager.OnPageChangeListener onPageChangeListener = this.f12299f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        this.f12300g = i2;
        this.f12302i = f2;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.f12299f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (this.m || this.f12303j == 0) {
            this.f12300g = i2;
            this.f12301h = i2;
            invalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.f12299f;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i2 = savedState.a;
        this.f12300g = i2;
        this.f12301h = i2;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f12300g;
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        ViewPager viewPager = this.f12298e;
        if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.p));
                    float f2 = x - this.o;
                    if (!this.q && Math.abs(f2) > this.n) {
                        this.q = true;
                    }
                    if (this.q) {
                        this.o = x;
                        if (this.f12298e.isFakeDragging() || this.f12298e.beginFakeDrag()) {
                            this.f12298e.fakeDragBy(f2);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        this.o = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.p = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    } else if (action == 6) {
                        int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                        if (MotionEventCompat.getPointerId(motionEvent, actionIndex2) == this.p) {
                            this.p = MotionEventCompat.getPointerId(motionEvent, actionIndex2 == 0 ? 1 : 0);
                        }
                        this.o = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.p));
                    }
                }
            }
            if (!this.q) {
                int count = this.f12298e.getAdapter().getCount();
                float width = getWidth();
                float f3 = width / 2.0f;
                float f4 = width / 6.0f;
                if (this.f12300g > 0 && motionEvent.getX() < f3 - f4) {
                    if (action != 3) {
                        this.f12298e.setCurrentItem(this.f12300g - 1);
                    }
                    return true;
                } else if (this.f12300g < count - 1 && motionEvent.getX() > f3 + f4) {
                    if (action != 3) {
                        this.f12298e.setCurrentItem(this.f12300g + 1);
                    }
                    return true;
                }
            }
            this.q = false;
            this.p = -1;
            if (this.f12298e.isFakeDragging()) {
                this.f12298e.endFakeDrag();
            }
        } else {
            this.p = MotionEventCompat.getPointerId(motionEvent, 0);
            this.o = motionEvent.getX();
        }
        return true;
    }

    public void setCentered(boolean z) {
        this.f12305l = z;
        invalidate();
    }

    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f12298e;
        if (viewPager != null) {
            viewPager.setCurrentItem(i2);
            this.f12300g = i2;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setFillColor(int i2) {
        this.f12297d.setColor(i2);
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f12299f = onPageChangeListener;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
        this.f12304k = i2;
        requestLayout();
    }

    public void setPageColor(int i2) {
        this.b.setColor(i2);
        invalidate();
    }

    public void setRadius(float f2) {
        this.a = f2;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.m = z;
        invalidate();
    }

    public void setStrokeColor(int i2) {
        this.c.setColor(i2);
        invalidate();
    }

    public void setStrokeWidth(float f2) {
        this.c.setStrokeWidth(f2);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f12298e;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() != null) {
            this.f12298e = viewPager;
            viewPager.setOnPageChangeListener(this);
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint = new Paint(1);
        this.b = paint;
        Paint paint2 = new Paint(1);
        this.c = paint2;
        Paint paint3 = new Paint(1);
        this.f12297d = paint3;
        this.o = -1.0f;
        this.p = -1;
        if (isInEditMode()) {
            return;
        }
        Resources resources = getResources();
        int color = resources.getColor(R.color.default_circle_indicator_page_color);
        int color2 = resources.getColor(R.color.default_circle_indicator_fill_color);
        int integer = resources.getInteger(R.integer.default_circle_indicator_orientation);
        int color3 = resources.getColor(R.color.default_circle_indicator_stroke_color);
        float dimension = resources.getDimension(R.dimen.default_circle_indicator_stroke_width);
        float dimension2 = resources.getDimension(R.dimen.default_circle_indicator_radius);
        boolean z = resources.getBoolean(R.bool.default_circle_indicator_centered);
        boolean z2 = resources.getBoolean(R.bool.default_circle_indicator_snap);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CirclePageIndicator, i2, 0);
        this.f12305l = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_centered, z);
        this.f12304k = obtainStyledAttributes.getInt(R.styleable.CirclePageIndicator_android_orientation, integer);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_pageColor, color));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_strokeColor, color3));
        paint2.setStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_strokeWidth, dimension));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(obtainStyledAttributes.getColor(R.styleable.CirclePageIndicator_fillColor, color2));
        this.a = obtainStyledAttributes.getDimension(R.styleable.CirclePageIndicator_radius, dimension2);
        this.m = obtainStyledAttributes.getBoolean(R.styleable.CirclePageIndicator_snap, z2);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CirclePageIndicator_android_background);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.n = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    public void setViewPager(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }
}
