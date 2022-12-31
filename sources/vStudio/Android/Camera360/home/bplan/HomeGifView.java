package vStudio.Android.Camera360.home.bplan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.adv.f.b;
import vStudio.Android.Camera360.R;
/* loaded from: classes7.dex */
public class HomeGifView extends View {
    private int a;
    private Movie b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private int f12643d;

    /* renamed from: e  reason: collision with root package name */
    private float f12644e;

    /* renamed from: f  reason: collision with root package name */
    private float f12645f;

    /* renamed from: g  reason: collision with root package name */
    private float f12646g;

    /* renamed from: h  reason: collision with root package name */
    private int f12647h;

    /* renamed from: i  reason: collision with root package name */
    private int f12648i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12649j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f12650k;

    /* renamed from: l  reason: collision with root package name */
    private int f12651l;
    public b m;
    public com.pinguo.camera360.adv.f.a n;
    int o;

    /* loaded from: classes7.dex */
    class a implements b {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // com.pinguo.camera360.adv.f.b
        public void a() {
            HomeGifView.b(HomeGifView.this);
            if (HomeGifView.this.f12651l == this.a) {
                HomeGifView.this.setPaused(true);
                HomeGifView homeGifView = HomeGifView.this;
                homeGifView.setVisibility(8);
                VdsAgent.onSetViewVisibility(homeGifView, 8);
                com.pinguo.camera360.adv.f.a aVar = HomeGifView.this.n;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }

    public HomeGifView(Context context) {
        this(context, null);
    }

    static /* synthetic */ int b(HomeGifView homeGifView) {
        int i2 = homeGifView.f12651l;
        homeGifView.f12651l = i2 + 1;
        return i2;
    }

    private void c(Canvas canvas) {
        this.b.setTime(this.f12643d);
        canvas.save();
        float f2 = this.f12646g;
        canvas.scale(f2, f2);
        Movie movie = this.b;
        float f3 = this.f12644e;
        float f4 = this.f12646g;
        movie.draw(canvas, f3 / f4, this.f12645f / f4);
        canvas.restore();
    }

    @SuppressLint({"NewApi"})
    private void d() {
        if (this.f12649j) {
            if (Build.VERSION.SDK_INT >= 16) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void e(Context context, AttributeSet attributeSet, int i2) {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GifView, i2, R.style.Widget_GifView);
        this.a = obtainStyledAttributes.getResourceId(1, -1);
        this.f12650k = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        if (this.a != -1) {
            this.b = Movie.decodeStream(getResources().openRawResource(this.a));
        }
    }

    private void f() {
        b bVar;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.o = this.f12643d;
        if (this.c == 0) {
            this.c = uptimeMillis;
        }
        int duration = this.b.duration();
        if (duration == 0) {
            duration = 1000;
        }
        int i2 = (int) ((uptimeMillis - this.c) % duration);
        this.f12643d = i2;
        if (i2 >= this.o || (bVar = this.m) == null) {
            return;
        }
        bVar.a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.b != null) {
            super.onDraw(canvas);
            Path path = new Path();
            RectF rectF = new RectF();
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = 0.0f + getWidth();
            rectF.bottom = rectF.top + getHeight();
            path.addRoundRect(rectF, getResources().getDimension(R.dimen.home_box_conner_radius), getResources().getDimension(R.dimen.home_box_conner_radius), Path.Direction.CCW);
            canvas.clipPath(path);
            if (!this.f12650k) {
                f();
                c(canvas);
                d();
                return;
            }
            c(canvas);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f12644e = (getWidth() - this.f12647h) / 2.0f;
        this.f12645f = (getHeight() - this.f12648i) / 2.0f;
        this.f12649j = getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        Movie movie = this.b;
        if (movie != null) {
            int width = movie.width();
            int height = this.b.height();
            int size = View.MeasureSpec.getSize(i2);
            float f2 = 1.0f / (width / size);
            this.f12646g = f2;
            this.f12647h = size;
            int i4 = (int) (height * f2);
            this.f12648i = i4;
            setMeasuredDimension(size, i4);
            return;
        }
        setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i2) {
        super.onScreenStateChanged(i2);
        this.f12649j = i2 == 1;
        d();
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        this.f12649j = i2 == 0;
        d();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f12649j = i2 == 0;
        d();
    }

    public void setMovie(Movie movie) {
        this.b = movie;
        requestLayout();
    }

    public void setMovieResource(int i2) {
        this.a = i2;
        this.b = Movie.decodeStream(getResources().openRawResource(this.a));
        requestLayout();
    }

    public void setMovieTime(int i2) {
        setOnPlayGifOverListener(new a(i2));
    }

    public void setOnPlayGifFinishListener(com.pinguo.camera360.adv.f.a aVar) {
        this.n = aVar;
    }

    public void setOnPlayGifOverListener(b bVar) {
        this.m = bVar;
    }

    public void setPaused(boolean z) {
        this.f12650k = z;
        if (!z) {
            this.c = SystemClock.uptimeMillis() - this.f12643d;
        }
        invalidate();
    }

    public HomeGifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomeGifView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12643d = 0;
        this.f12649j = true;
        this.f12650k = false;
        this.f12651l = 0;
        this.o = 0;
        e(context, attributeSet, i2);
    }

    public void setMovieResource(String str) {
        this.b = Movie.decodeFile(str);
        requestLayout();
    }
}
