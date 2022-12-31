package us.pinguo.common.widget.adv;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.commonui.R;
/* compiled from: TvLoadingView.kt */
/* loaded from: classes4.dex */
public final class TvLoadingView extends View {
    private int a;
    private Drawable b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9982d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f9983e;

    /* renamed from: f  reason: collision with root package name */
    private Path f9984f;

    /* renamed from: g  reason: collision with root package name */
    private final float f9985g;

    /* renamed from: h  reason: collision with root package name */
    private double f9986h;

    /* renamed from: i  reason: collision with root package name */
    private int f9987i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9988j;

    /* renamed from: k  reason: collision with root package name */
    private final int f9989k;

    /* renamed from: l  reason: collision with root package name */
    private final int f9990l;
    private final int m;

    /* compiled from: TvLoadingView.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TvLoadingView.this.f9982d) {
                TvLoadingView.this.f9987i++;
                if (TvLoadingView.this.f9987i == 4) {
                    TvLoadingView.this.f9987i = 0;
                }
                TvLoadingView.this.invalidate();
                us.pinguo.foundation.utils.f.d(this, 180L);
            }
        }
    }

    public TvLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new LinkedHashMap();
        this.a = 1;
        this.f9983e = new Paint(1);
        this.f9984f = new Path();
        float c = us.pinguo.foundation.t.b.a.c(getContext(), 50.0f);
        this.f9985g = c;
        this.f9988j = us.pinguo.foundation.t.b.a.a(getContext(), 11.0f);
        this.f9989k = us.pinguo.foundation.t.b.a.a(getContext(), 31.0f);
        this.f9990l = us.pinguo.foundation.t.b.a.a(getContext(), 58.0f);
        this.m = us.pinguo.foundation.t.b.a.a(getContext(), 36.0f);
        this.b = ContextCompat.getDrawable(getContext(), R.drawable.bg_tv_outline);
        this.f9983e.setColor(-1);
        this.f9983e.setStyle(Paint.Style.STROKE);
        this.f9983e.setStrokeWidth(us.pinguo.foundation.t.b.a.c(getContext(), 3.0f));
        this.f9984f.reset();
        this.f9984f.moveTo(10.0f, c);
    }

    public final void d(boolean z) {
        if (this.f9982d == z) {
            return;
        }
        this.f9982d = z;
        if (z) {
            us.pinguo.foundation.utils.f.d(new a(), 300L);
        }
    }

    public final void e(boolean z) {
        if (this.c == z) {
            return;
        }
        this.c = z;
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = this.b;
        s.e(drawable);
        s.e(canvas);
        drawable.draw(canvas);
        int i2 = this.a;
        if (i2 != 1) {
            if (i2 == 2) {
                TypedArray obtainTypedArray = getResources().obtainTypedArray(R.array.tv_snow_dot_anim_array);
                s.g(obtainTypedArray, "resources.obtainTypedArr…y.tv_snow_dot_anim_array)");
                Drawable drawable2 = ContextCompat.getDrawable(getContext(), obtainTypedArray.getResourceId(this.f9987i, 0));
                if (drawable2 == null) {
                    return;
                }
                int i3 = this.f9988j;
                int i4 = this.f9989k;
                drawable2.setBounds(i3, i4, this.f9990l + i3, this.m + i4);
                drawable2.draw(canvas);
                obtainTypedArray.recycle();
                return;
            }
            return;
        }
        this.f9984f.reset();
        float f2 = 10.0f;
        this.f9984f.moveTo(10.0f, this.f9985g);
        if (this.f9986h >= 1.5707963267948966d) {
            this.f9986h = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int measuredWidth = getMeasuredWidth() - 5;
        int i5 = 10;
        if (10 <= measuredWidth) {
            while (true) {
                int i6 = i5 + 1;
                this.f9984f.lineTo(i5, (float) (this.f9985g + (f2 * Math.sin(4 * ((((i5 / getMeasuredWidth()) * 2) * 3.141592653589793d) - this.f9986h)))));
                if (i5 == measuredWidth) {
                    break;
                }
                i5 = i6;
                f2 = 10.0f;
            }
        }
        canvas.drawPath(this.f9984f, this.f9983e);
        if (this.c) {
            this.f9986h += (1.0d / getMeasuredWidth()) * 2 * 3.141592653589793d;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Drawable drawable = this.b;
        s.e(drawable);
        drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public final void setType(int i2) {
        this.a = i2;
    }

    public TvLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new LinkedHashMap();
        this.a = 1;
        this.f9983e = new Paint(1);
        this.f9984f = new Path();
        float c = us.pinguo.foundation.t.b.a.c(getContext(), 50.0f);
        this.f9985g = c;
        this.f9988j = us.pinguo.foundation.t.b.a.a(getContext(), 11.0f);
        this.f9989k = us.pinguo.foundation.t.b.a.a(getContext(), 31.0f);
        this.f9990l = us.pinguo.foundation.t.b.a.a(getContext(), 58.0f);
        this.m = us.pinguo.foundation.t.b.a.a(getContext(), 36.0f);
        this.b = ContextCompat.getDrawable(getContext(), R.drawable.bg_tv_outline);
        this.f9983e.setColor(-1);
        this.f9983e.setStyle(Paint.Style.STROKE);
        this.f9983e.setStrokeWidth(us.pinguo.foundation.t.b.a.c(getContext(), 3.0f));
        this.f9984f.reset();
        this.f9984f.moveTo(10.0f, c);
    }

    public TvLoadingView(Context context) {
        super(context);
        new LinkedHashMap();
        this.a = 1;
        this.f9983e = new Paint(1);
        this.f9984f = new Path();
        float c = us.pinguo.foundation.t.b.a.c(getContext(), 50.0f);
        this.f9985g = c;
        this.f9988j = us.pinguo.foundation.t.b.a.a(getContext(), 11.0f);
        this.f9989k = us.pinguo.foundation.t.b.a.a(getContext(), 31.0f);
        this.f9990l = us.pinguo.foundation.t.b.a.a(getContext(), 58.0f);
        this.m = us.pinguo.foundation.t.b.a.a(getContext(), 36.0f);
        this.b = ContextCompat.getDrawable(getContext(), R.drawable.bg_tv_outline);
        this.f9983e.setColor(-1);
        this.f9983e.setStyle(Paint.Style.STROKE);
        this.f9983e.setStrokeWidth(us.pinguo.foundation.t.b.a.c(getContext(), 3.0f));
        this.f9984f.reset();
        this.f9984f.moveTo(10.0f, c);
    }
}
