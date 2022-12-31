package vStudio.Android.Camera360.guide.view.morphingbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import us.pinguo.util.v;
import vStudio.Android.Camera360.R;
/* loaded from: classes7.dex */
public class IndeterminateProgressButton extends MorphingButton {

    /* renamed from: g  reason: collision with root package name */
    private int f12625g;

    /* renamed from: h  reason: collision with root package name */
    private int f12626h;

    /* renamed from: i  reason: collision with root package name */
    private int f12627i;

    /* renamed from: j  reason: collision with root package name */
    private int f12628j;

    /* renamed from: k  reason: collision with root package name */
    private int f12629k;

    /* renamed from: l  reason: collision with root package name */
    private a f12630l;
    private boolean m;

    /* loaded from: classes7.dex */
    public static class a {
        private static final int n = v.a().getResources().getColor(R.color.color_camera_theme_black);
        private static final int o = v.a().getResources().getColor(R.color.color_camera_theme_black);
        private static final int p = v.a().getResources().getColor(R.color.color_camera_theme_black);
        private static final int q = v.a().getResources().getColor(R.color.color_camera_theme_black);
        private static final Interpolator r = new AccelerateDecelerateInterpolator();
        private float c;

        /* renamed from: d  reason: collision with root package name */
        private long f12631d;

        /* renamed from: e  reason: collision with root package name */
        private long f12632e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12633f;

        /* renamed from: k  reason: collision with root package name */
        private int f12638k;

        /* renamed from: l  reason: collision with root package name */
        private View f12639l;
        private final Paint a = new Paint();
        private final RectF b = new RectF();
        private RectF m = new RectF();

        /* renamed from: g  reason: collision with root package name */
        private int f12634g = n;

        /* renamed from: h  reason: collision with root package name */
        private int f12635h = o;

        /* renamed from: i  reason: collision with root package name */
        private int f12636i = p;

        /* renamed from: j  reason: collision with root package name */
        private int f12637j = q;

        public a(View view) {
            this.f12639l = view;
        }

        private void b(Canvas canvas, float f2, float f3, int i2, float f4) {
            this.a.setColor(i2);
            canvas.save();
            canvas.translate(f2, f3);
            float interpolation = r.getInterpolation(f4);
            canvas.scale(interpolation, interpolation);
            canvas.drawRect(0.0f, 0.0f, f2, f3, this.a);
            canvas.restore();
        }

        private void c(Canvas canvas, int i2, int i3) {
            this.a.setColor(this.f12634g);
            float f2 = i2;
            canvas.drawCircle(f2, i3, this.c * f2, this.a);
        }

        void a(Canvas canvas) {
            long j2;
            boolean z;
            Path path = new Path();
            RectF rectF = this.m;
            int i2 = this.f12638k;
            path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
            int height = (int) this.m.height();
            int width = ((int) this.m.width()) / 2;
            int i3 = height / 2;
            int save = canvas.save();
            canvas.clipPath(path);
            if (!this.f12633f && this.f12632e <= 0) {
                float f2 = this.c;
                if (f2 > 0.0f && f2 <= 1.0d) {
                    c(canvas, width, i3);
                }
            } else {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j3 = this.f12631d;
                long j4 = (currentAnimationTimeMillis - j3) / 2000;
                float f3 = ((float) ((currentAnimationTimeMillis - j3) % 2000)) / 20.0f;
                if (this.f12633f) {
                    j2 = j4;
                    z = false;
                } else {
                    long j5 = this.f12632e;
                    if (currentAnimationTimeMillis - j5 >= 1000) {
                        this.f12632e = 0L;
                        return;
                    }
                    j2 = j4;
                    float f4 = width;
                    float interpolation = r.getInterpolation((((float) ((currentAnimationTimeMillis - j5) % 1000)) / 10.0f) / 100.0f) * f4;
                    this.b.set(f4 - interpolation, 0.0f, f4 + interpolation, height);
                    if (Build.VERSION.SDK_INT >= 28) {
                        canvas.saveLayerAlpha(this.b, 0, 31);
                    } else {
                        canvas.saveLayerAlpha(this.b, 0, 0);
                    }
                    z = true;
                }
                if (j2 == 0) {
                    canvas.drawColor(this.f12634g);
                } else if (f3 >= 0.0f && f3 < 25.0f) {
                    canvas.drawColor(this.f12637j);
                } else if (f3 >= 25.0f && f3 < 50.0f) {
                    canvas.drawColor(this.f12634g);
                } else if (f3 >= 50.0f && f3 < 75.0f) {
                    canvas.drawColor(this.f12635h);
                } else {
                    canvas.drawColor(this.f12636i);
                }
                int i4 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                if (i4 >= 0 && f3 <= 25.0f) {
                    b(canvas, width, i3, this.f12634g, ((f3 + 25.0f) * 2.0f) / 100.0f);
                }
                if (i4 >= 0 && f3 <= 50.0f) {
                    b(canvas, width, i3, this.f12635h, (f3 * 2.0f) / 100.0f);
                }
                if (f3 >= 25.0f && f3 <= 75.0f) {
                    b(canvas, width, i3, this.f12636i, ((f3 - 25.0f) * 2.0f) / 100.0f);
                }
                if (f3 >= 50.0f && f3 <= 100.0f) {
                    b(canvas, width, i3, this.f12637j, ((f3 - 50.0f) * 2.0f) / 100.0f);
                }
                if (f3 >= 75.0f && f3 <= 100.0f) {
                    b(canvas, width, i3, this.f12634g, ((f3 - 75.0f) * 2.0f) / 100.0f);
                }
                if (this.c > 0.0f && z) {
                    canvas.restoreToCount(save);
                    int save2 = canvas.save();
                    canvas.clipPath(path);
                    c(canvas, width, i3);
                    save = save2;
                }
                ViewCompat.postInvalidateOnAnimation(this.f12639l);
            }
            canvas.restoreToCount(save);
        }

        void d(int i2, int i3, int i4, int i5, int i6) {
            RectF rectF = this.m;
            rectF.left = i2;
            rectF.top = i3;
            rectF.right = i4;
            rectF.bottom = i5;
            this.f12638k = i6;
        }

        void e(int i2, int i3, int i4, int i5) {
            this.f12634g = i2;
            this.f12635h = i3;
            this.f12636i = i4;
            this.f12637j = i5;
        }

        void f() {
            if (this.f12633f) {
                return;
            }
            this.c = 0.0f;
            this.f12631d = AnimationUtils.currentAnimationTimeMillis();
            this.f12633f = true;
            this.f12639l.postInvalidate();
        }
    }

    public IndeterminateProgressButton(Context context) {
        super(context);
        d(context);
    }

    private void d(Context context) {
        Resources resources = context.getResources();
        this.f12625g = resources.getColor(R.color.mb_gray);
        this.f12626h = resources.getColor(R.color.mb_blue);
        this.f12627i = resources.getColor(R.color.mb_gray);
        this.f12628j = resources.getColor(R.color.mb_blue);
        if (Build.VERSION.SDK_INT <= 18) {
            setLayerType(1, null);
        }
    }

    private void e() {
        this.f12630l.d(0, (int) (getMeasuredHeight() - getHeight()), getMeasuredWidth(), getMeasuredHeight(), this.f12629k);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (this.f12640d || !this.m) {
            return;
        }
        if (this.f12630l == null) {
            this.f12630l = new a(this);
            e();
            this.f12630l.e(this.f12625g, this.f12626h, this.f12627i, this.f12628j);
            this.f12630l.f();
        }
        this.f12630l.a(canvas);
    }

    public IndeterminateProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }

    public IndeterminateProgressButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context);
    }
}
