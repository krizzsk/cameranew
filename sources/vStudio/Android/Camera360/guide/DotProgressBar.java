package vStudio.Android.Camera360.guide;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* loaded from: classes7.dex */
public class DotProgressBar extends View {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private long f12600d;

    /* renamed from: e  reason: collision with root package name */
    private int f12601e;

    /* renamed from: f  reason: collision with root package name */
    private int f12602f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f12603g;

    /* renamed from: h  reason: collision with root package name */
    private Handler f12604h;

    /* renamed from: i  reason: collision with root package name */
    private Runnable f12605i;

    /* loaded from: classes7.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DotProgressBar dotProgressBar = DotProgressBar.this;
            dotProgressBar.f12602f = (dotProgressBar.f12602f + 1) % (DotProgressBar.this.f12601e + 1);
            DotProgressBar.this.invalidate();
            DotProgressBar.this.f12604h.postDelayed(DotProgressBar.this.f12605i, DotProgressBar.this.f12600d);
        }
    }

    public DotProgressBar(Context context) {
        this(context, null);
    }

    private void g(Context context, AttributeSet attributeSet) {
        this.f12604h = new Handler();
        Paint paint = new Paint();
        this.f12603g = paint;
        paint.setAntiAlias(true);
        this.f12603g.setStyle(Paint.Style.FILL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.a = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.b = (int) TypedValue.applyDimension(1, 3.0f, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DotProgressBar);
        this.c = obtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
        this.a = obtainStyledAttributes.getDimensionPixelSize(1, this.a);
        this.b = obtainStyledAttributes.getDimensionPixelSize(2, this.b);
        this.f12601e = obtainStyledAttributes.getInt(3, 3);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f12604h.removeCallbacks(this.f12605i);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        this.f12603g.setColor(this.c);
        for (int i2 = 0; i2 < this.f12602f; i2++) {
            int paddingLeft = getPaddingLeft();
            int i3 = this.b;
            int i4 = this.a;
            canvas.drawCircle(paddingLeft + ((i3 + i4) * i2) + (i4 / 2), getHeight() / 2, this.a / 2, this.f12603g);
        }
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        int i4 = this.f12601e;
        setMeasuredDimension(View.resolveSizeAndState((i4 * this.a) + ((i4 + (-1) < 0 ? 0 : i4 - 1) * this.b) + 0 + getPaddingLeft() + getPaddingRight(), i2, 0), View.resolveSizeAndState(this.a + 0 + getPaddingTop() + getPaddingBottom(), i3, 0));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        this.f12604h.removeCallbacks(this.f12605i);
        if (i2 == 0) {
            this.f12604h.post(this.f12605i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (getVisibility() != i2) {
            super.setVisibility(i2);
            VdsAgent.onSetViewVisibility(this, i2);
            this.f12604h.removeCallbacks(this.f12605i);
            if (i2 == 0) {
                this.f12604h.post(this.f12605i);
            }
        }
    }

    public DotProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12600d = 300L;
        this.f12601e = 3;
        this.f12605i = new a();
        g(context, attributeSet);
    }
}
