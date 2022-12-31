package us.pinguo.widget.discreteseekbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.material.timepicker.TimeModel;
import java.util.Formatter;
import java.util.Locale;
import us.pinguo.widget.discreteseekbar.internal.PopupIndicator;
import us.pinguo.widget.discreteseekbar.internal.a.a;
import us.pinguo.widget.discreteseekbar.internal.b.b;
import us.pinguo.widget.discreteseekbar.internal.b.g;
import us.pinguo.widget.discreteseekbar.internal.b.h;
/* loaded from: classes6.dex */
public class DiscreteCenterSeekBar extends View {
    private static final boolean K;
    private Rect A;
    private PopupIndicator B;
    private us.pinguo.widget.discreteseekbar.internal.a.a C;
    private float D;
    private int E;
    private float F;
    private float G;
    private boolean H;
    private Runnable I;
    private b.InterfaceC0469b J;
    private boolean a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f12529d;

    /* renamed from: e  reason: collision with root package name */
    private float f12530e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f12531f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.widget.discreteseekbar.internal.b.d f12532g;

    /* renamed from: h  reason: collision with root package name */
    private h f12533h;

    /* renamed from: i  reason: collision with root package name */
    private h f12534i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f12535j;

    /* renamed from: k  reason: collision with root package name */
    private int f12536k;

    /* renamed from: l  reason: collision with root package name */
    private int f12537l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    Formatter s;
    private String t;
    private e u;
    private StringBuilder v;
    private f w;
    private boolean x;
    private int y;
    private Rect z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC0467a {
        a() {
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.a.a.InterfaceC0467a
        public void a(float f2) {
            DiscreteCenterSeekBar.this.x(f2);
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DiscreteCenterSeekBar.this.B();
        }
    }

    /* loaded from: classes6.dex */
    class c implements b.InterfaceC0469b {
        c(DiscreteCenterSeekBar discreteCenterSeekBar) {
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
        public void a() {
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class d extends e {
        private d() {
        }

        @Override // us.pinguo.widget.discreteseekbar.DiscreteCenterSeekBar.e
        public int a(int i2) {
            return i2;
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class e {
        public abstract int a(int i2);

        public String b(int i2) {
            return String.valueOf(i2);
        }

        public boolean c() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(DiscreteCenterSeekBar discreteCenterSeekBar);

        void b(DiscreteCenterSeekBar discreteCenterSeekBar, int i2, boolean z);

        void c(DiscreteCenterSeekBar discreteCenterSeekBar);
    }

    static {
        K = Build.VERSION.SDK_INT >= 21;
    }

    public DiscreteCenterSeekBar(Context context) {
        this(context, null);
    }

    private void A(int i2) {
        z(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (isInEditMode()) {
            return;
        }
        this.B.n(this, this.f12532g.getBounds());
        s(true);
    }

    private boolean C(MotionEvent motionEvent, boolean z) {
        Rect rect = this.A;
        this.f12532g.copyBounds(rect);
        int i2 = this.m;
        rect.inset(-i2, -i2);
        boolean contains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.x = contains;
        if (!contains && !z) {
            this.x = true;
            this.y = ((rect.width() / 2) - this.m) + (((int) motionEvent.getX()) - k());
            B();
            E(motionEvent);
            this.f12532g.copyBounds(rect);
            int i3 = this.m;
            rect.inset(-i3, -i3);
        }
        if (this.x) {
            setPressed(true);
            c();
            y(motionEvent.getX(), motionEvent.getY());
            this.y = (int) ((motionEvent.getX() - rect.left) - this.m);
            f fVar = this.w;
            if (fVar != null) {
                fVar.a(this);
            }
        }
        return this.x;
    }

    private void D() {
        f fVar = this.w;
        if (fVar != null) {
            fVar.c(this);
        }
        this.x = false;
        setPressed(false);
    }

    private void E(MotionEvent motionEvent) {
        y(motionEvent.getX(), motionEvent.getY());
        int width = this.f12532g.getBounds().width() / 2;
        int i2 = this.m;
        int x = (((int) motionEvent.getX()) - this.y) + width;
        int paddingLeft = getPaddingLeft() + width + i2;
        int width2 = getWidth() - ((getPaddingRight() + width) + i2);
        if (x < paddingLeft) {
            x = paddingLeft;
        } else if (x > width2) {
            x = width2;
        }
        int i3 = this.n;
        int i4 = this.o;
        z(Math.round((((x - paddingLeft) / (width2 - paddingLeft)) * (i3 - i4)) + i4), true);
    }

    private void F() {
        int[] drawableState = getDrawableState();
        boolean z = false;
        boolean z2 = false;
        for (int i2 : drawableState) {
            if (i2 == 16842908) {
                z = true;
            } else if (i2 == 16842919) {
                z2 = true;
            }
        }
        if (isEnabled() && ((z || z2) && this.r)) {
            removeCallbacks(this.I);
            postDelayed(this.I, 150L);
        } else {
            n();
        }
        this.f12532g.setState(drawableState);
        this.f12533h.setState(drawableState);
        this.f12534i.setState(drawableState);
        this.f12535j.setState(drawableState);
    }

    private void G() {
        if (isInEditMode()) {
            return;
        }
        if (this.u.c()) {
            this.B.q(this.u.b(this.n));
            return;
        }
        PopupIndicator popupIndicator = this.B;
        e eVar = this.u;
        int i2 = this.n;
        eVar.a(i2);
        popupIndicator.q(e(i2));
    }

    private void H() {
        int i2 = this.n - this.o;
        int i3 = this.q;
        if (i3 == 0 || i2 / i3 > 20) {
            this.q = Math.max(1, Math.round(i2 / 20.0f));
        }
    }

    private void I(float f2) {
        int width = this.f12532g.getBounds().width() / 2;
        int i2 = this.m;
        int width2 = (getWidth() - ((getPaddingRight() + width) + i2)) - ((getPaddingLeft() + width) + i2);
        int i3 = this.n;
        int i4 = this.o;
        int round = Math.round(((i3 - i4) * f2) + i4);
        if (round != l()) {
            this.p = round;
            t(round, true);
            J(round);
        }
        K((int) ((f2 * width2) + 0.5f));
    }

    private void J(int i2) {
        if (isInEditMode()) {
            return;
        }
        if (this.u.c()) {
            this.B.m(this.u.b(i2));
            return;
        }
        PopupIndicator popupIndicator = this.B;
        this.u.a(i2);
        popupIndicator.m(e(i2));
    }

    private void K(int i2) {
        int intrinsicWidth = this.f12532g.getIntrinsicWidth();
        int paddingLeft = getPaddingLeft() + this.m + i2;
        this.f12532g.copyBounds(this.z);
        us.pinguo.widget.discreteseekbar.internal.b.d dVar = this.f12532g;
        Rect rect = this.z;
        dVar.setBounds(paddingLeft, rect.top, intrinsicWidth + paddingLeft, rect.bottom);
        int j2 = j();
        int i3 = paddingLeft + (intrinsicWidth / 2);
        if (i3 >= j2) {
            this.f12534i.getBounds().right = i3;
            this.f12534i.getBounds().left = j2;
        } else {
            this.f12534i.getBounds().right = j2;
            this.f12534i.getBounds().left = i3;
        }
        Rect rect2 = this.A;
        this.f12532g.copyBounds(rect2);
        if (!isInEditMode()) {
            this.B.j(rect2.centerX());
        }
        Rect rect3 = this.z;
        int i4 = this.m;
        rect3.inset(-i4, -i4);
        int i5 = this.m;
        rect2.inset(-i5, -i5);
        this.z.union(rect2);
        us.pinguo.widget.discreteseekbar.internal.a.c.e(this.f12535j, 0, 0, 0, 0);
        invalidate(this.z);
    }

    private void L() {
        int intrinsicWidth = this.f12532g.getIntrinsicWidth();
        int i2 = this.m;
        int i3 = intrinsicWidth / 2;
        int i4 = this.p;
        int i5 = this.o;
        K((int) ((((i4 - i5) / (this.n - i5)) * ((getWidth() - ((getPaddingRight() + i3) + i2)) - ((getPaddingLeft() + i3) + i2))) + 0.5f));
        if (this.p == (this.n + this.o) / 2) {
            this.f12532g.i(true);
        } else {
            this.f12532g.i(false);
        }
    }

    private void c() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void d() {
        if (this.F > k()) {
            A(this.p + 1);
        } else {
            A(this.p - 1);
        }
    }

    private String e(int i2) {
        String str = this.t;
        if (str == null) {
            str = TimeModel.NUMBER_FORMAT;
        }
        Formatter formatter = this.s;
        if (formatter != null && formatter.locale().equals(Locale.getDefault())) {
            this.v.setLength(0);
        } else {
            int length = str.length() + String.valueOf(this.n).length();
            StringBuilder sb = this.v;
            if (sb == null) {
                this.v = new StringBuilder(length);
            } else {
                sb.ensureCapacity(length);
            }
            this.s = new Formatter(this.v, Locale.getDefault());
        }
        return this.s.format(str, Integer.valueOf(i2)).toString();
    }

    private void f(Canvas canvas) {
        if (this.a) {
            int i2 = this.c;
            if (i2 != 0) {
                this.f12529d.setColor(i2);
            } else {
                this.f12529d.setColor(this.f12532g.b());
            }
            int intrinsicWidth = this.f12532g.getIntrinsicWidth();
            int i3 = this.m;
            int i4 = intrinsicWidth / 2;
            float paddingTop = getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2);
            int width = (getWidth() - ((getPaddingRight() + i4) + i3)) - ((getPaddingLeft() + i4) + i3);
            int i5 = this.b;
            int i6 = this.o;
            float paddingLeft = getPaddingLeft() + this.m + ((int) (((((i5 - i6) * 1.0f) / (this.n - i6)) * width) + 0.5f)) + i4;
            RectF rectF = this.f12531f;
            float f2 = this.f12530e;
            rectF.set(paddingLeft - (f2 / 2.0f), paddingTop - f2, paddingLeft + (f2 / 2.0f), paddingTop + f2);
            RectF rectF2 = this.f12531f;
            float f3 = this.f12530e;
            canvas.drawRoundRect(rectF2, f3 / 2.0f, f3 / 2.0f, this.f12529d);
        }
    }

    private int g() {
        return o() ? i() : this.p;
    }

    private int i() {
        return this.E;
    }

    private int j() {
        int intrinsicWidth = this.f12532g.getIntrinsicWidth();
        int i2 = this.m;
        int i3 = intrinsicWidth / 2;
        int paddingLeft = getPaddingLeft() + i3 + i2;
        return ((int) ((((getWidth() - ((getPaddingRight() + i3) + i2)) - paddingLeft) * 0.5d) + 0.5d)) + paddingLeft;
    }

    private int k() {
        int intrinsicWidth = this.f12532g.getIntrinsicWidth();
        int i2 = this.m;
        int i3 = intrinsicWidth / 2;
        int i4 = this.p;
        int i5 = this.o;
        float f2 = (i4 - i5) / (this.n - i5);
        int paddingLeft = getPaddingLeft() + i3 + i2;
        return ((int) ((f2 * ((getWidth() - ((getPaddingRight() + i3) + i2)) - paddingLeft)) + 0.5f)) + paddingLeft;
    }

    private int m() {
        return ((int) getResources().getDisplayMetrics().density) * 3;
    }

    private void n() {
        removeCallbacks(this.I);
        if (isInEditMode()) {
            return;
        }
        this.B.e();
        s(false);
    }

    private boolean p() {
        return this.x;
    }

    private boolean q() {
        return us.pinguo.widget.discreteseekbar.internal.a.c.c(getParent());
    }

    private void r() {
        if (Math.abs(j() - k()) < getResources().getDisplayMetrics().density * 10.0f) {
            setProgress((this.n + this.o) / 2);
        }
    }

    private void s(boolean z) {
        if (z) {
            v();
        } else {
            u();
        }
    }

    private void t(int i2, boolean z) {
        f fVar = this.w;
        if (fVar != null) {
            fVar.b(this, i2, z);
        }
        w(i2);
    }

    private void y(float f2, float f3) {
        DrawableCompat.setHotspot(this.f12535j, f2, f3);
    }

    private void z(int i2, boolean z) {
        int max = Math.max(this.o, Math.min(this.n, i2));
        if (o()) {
            this.C.a();
        }
        if (this.p != max) {
            this.p = max;
            t(max, z);
            J(max);
            L();
        }
    }

    void b(int i2) {
        float h2 = o() ? h() : l();
        int i3 = this.o;
        if (i2 < i3 || i2 > (i3 = this.n)) {
            i2 = i3;
        }
        us.pinguo.widget.discreteseekbar.internal.a.a aVar = this.C;
        if (aVar != null) {
            aVar.a();
        }
        this.E = i2;
        us.pinguo.widget.discreteseekbar.internal.a.a b2 = us.pinguo.widget.discreteseekbar.internal.a.a.b(h2, i2, new a());
        this.C = b2;
        b2.d(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.C.e();
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        F();
    }

    float h() {
        return this.D;
    }

    public int l() {
        return this.p;
    }

    boolean o() {
        us.pinguo.widget.discreteseekbar.internal.a.a aVar = this.C;
        return aVar != null && aVar.c();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.I);
        if (isInEditMode()) {
            return;
        }
        this.B.f();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        if (!K) {
            this.f12535j.draw(canvas);
        }
        super.onDraw(canvas);
        this.f12533h.draw(canvas);
        f(canvas);
        this.f12534i.draw(canvas);
        this.f12532g.draw(canvas);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z;
        if (isEnabled()) {
            int g2 = g();
            if (i2 != 21) {
                if (i2 == 22) {
                    if (g2 < this.n) {
                        b(g2 + this.q);
                    }
                }
            } else if (g2 > this.o) {
                b(g2 - this.q);
            }
            z = true;
            return !z || super.onKeyDown(i2, keyEvent);
        }
        z = false;
        if (z) {
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            removeCallbacks(this.I);
            if (!isInEditMode()) {
                this.B.f();
            }
            F();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.MeasureSpec.getSize(i2), this.f12532g.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom() + (this.m * 2));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(CustomState.class)) {
            CustomState customState = (CustomState) parcelable;
            setMin(customState.min);
            setMax(customState.max);
            z(customState.progress, false);
            super.onRestoreInstanceState(customState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        CustomState customState = new CustomState(super.onSaveInstanceState());
        customState.progress = l();
        customState.max = this.n;
        customState.min = this.o;
        return customState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int intrinsicWidth = this.f12532g.getIntrinsicWidth();
        int intrinsicHeight = this.f12532g.getIntrinsicHeight();
        int i6 = this.m;
        int i7 = intrinsicWidth / 2;
        int paddingLeft = getPaddingLeft() + i6;
        int paddingRight = getPaddingRight();
        int height = (getHeight() - getPaddingBottom()) - i6;
        this.f12532g.setBounds(paddingLeft, height - intrinsicHeight, intrinsicWidth + paddingLeft, height);
        int max = Math.max(this.f12536k / 2, 1);
        int i8 = paddingLeft + i7;
        int i9 = height - i7;
        this.f12533h.setBounds(i8, i9 - max, ((getWidth() - i7) - paddingRight) - i6, max + i9);
        int max2 = Math.max(this.f12537l / 2, 2);
        this.f12534i.setBounds(i8, i9 - max2, i8, i9 + max2);
        Log.e("Frisky", "mScrubber:" + this.f12534i.getBounds() + "    /mTrack:" + this.f12533h.getBounds());
        L();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                this.H = false;
                this.F = motionEvent.getX();
                C(motionEvent, q());
            } else if (actionMasked == 1) {
                if (!p()) {
                    C(motionEvent, false);
                    E(motionEvent);
                }
                if (!this.H) {
                    d();
                } else {
                    r();
                }
                L();
                D();
            } else if (actionMasked == 2) {
                if (Math.abs(motionEvent.getX() - this.F) > this.G) {
                    this.H = true;
                }
                if (p()) {
                    E(motionEvent);
                } else if (Math.abs(motionEvent.getX() - this.F) > this.G) {
                    C(motionEvent, false);
                }
            } else if (actionMasked == 3) {
                D();
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    public void setDotColor(int i2) {
        this.c = i2;
    }

    public void setDotEnable(boolean z) {
        this.a = z;
    }

    public void setDotPosition(int i2) {
        this.b = i2;
    }

    public void setIndicatorFormatter(@Nullable String str) {
        this.t = str;
        J(this.p);
    }

    public void setIndicatorPopupEnabled(boolean z) {
        this.r = z;
    }

    public void setMax(int i2) {
        this.n = i2;
        if (i2 < this.o) {
            setMin(i2 - 1);
        }
        H();
        int i3 = this.p;
        int i4 = this.o;
        if (i3 < i4 || i3 > this.n) {
            setProgress(i4);
        }
        G();
    }

    public void setMin(int i2) {
        this.o = i2;
        if (i2 > this.n) {
            setMax(i2 + 1);
        }
        H();
        int i3 = this.p;
        int i4 = this.o;
        if (i3 < i4 || i3 > this.n) {
            setProgress(i4);
        }
    }

    public void setNumericTransformer(@Nullable e eVar) {
        if (eVar == null) {
            eVar = new d(null);
        }
        this.u = eVar;
        G();
        J(this.p);
    }

    public void setOnProgressChangeListener(@Nullable f fVar) {
        this.w = fVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (isShown()) {
            super.setPressed(z);
        }
    }

    public void setProgress(int i2) {
        z(i2, false);
    }

    public void setRippleColor(int i2) {
        setRippleColor(new ColorStateList(new int[][]{new int[0]}, new int[]{i2}));
    }

    public void setScrubberColor(int i2) {
        this.f12534i.d(ColorStateList.valueOf(i2));
    }

    public void setThumbColor(int i2, int i3) {
        this.f12532g.d(ColorStateList.valueOf(i2));
        this.B.k(i3, i2);
    }

    public void setTrackColor(int i2) {
        this.f12533h.d(ColorStateList.valueOf(i2));
    }

    protected void u() {
    }

    protected void v() {
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f12532g || drawable == this.f12533h || drawable == this.f12534i || drawable == this.f12535j || super.verifyDrawable(drawable);
    }

    protected void w(int i2) {
    }

    void x(float f2) {
        this.D = f2;
        int i2 = this.o;
        I((f2 - i2) / (this.n - i2));
    }

    public DiscreteCenterSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.discreteSeekBarStyle);
    }

    public void setRippleColor(@NonNull ColorStateList colorStateList) {
        us.pinguo.widget.discreteseekbar.internal.a.c.g(this.f12535j, colorStateList);
    }

    public void setScrubberColor(@NonNull ColorStateList colorStateList) {
        this.f12534i.d(colorStateList);
    }

    public void setTrackColor(@NonNull ColorStateList colorStateList) {
        this.f12533h.d(colorStateList);
    }

    public DiscreteCenterSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        ColorStateList colorStateList;
        this.a = true;
        this.b = 0;
        this.c = 0;
        this.f12531f = new RectF();
        this.q = 1;
        this.r = true;
        this.z = new Rect();
        this.A = new Rect();
        this.H = false;
        this.I = new b();
        this.J = new c(this);
        setFocusable(true);
        setWillNotDraw(false);
        this.G = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DiscreteSeekBar, i2, R.style.Widget_DiscreteSeekBar);
        this.r = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_indicatorPopupEnabled, this.r);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_trackHeight, (int) (1.0f * f2));
        this.f12536k = dimensionPixelSize;
        this.f12537l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_scrubberHeight, dimensionPixelSize);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_thumbSize, (int) (12.0f * f2));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_indicatorSeparation, (int) (5.0f * f2));
        this.m = Math.max(0, (((int) (f2 * 32.0f)) - dimensionPixelSize2) / 2);
        int i4 = R.styleable.DiscreteSeekBar_dsb_max;
        int i5 = R.styleable.DiscreteSeekBar_dsb_min;
        int i6 = R.styleable.DiscreteSeekBar_dsb_value;
        TypedValue typedValue = new TypedValue();
        int i7 = 50;
        if (obtainStyledAttributes.getValue(i4, typedValue)) {
            if (typedValue.type == 5) {
                i7 = obtainStyledAttributes.getDimensionPixelSize(i4, 50);
            } else {
                i7 = obtainStyledAttributes.getInteger(i4, 50);
            }
        }
        int i8 = -50;
        if (obtainStyledAttributes.getValue(i5, typedValue)) {
            if (typedValue.type == 5) {
                i8 = obtainStyledAttributes.getDimensionPixelSize(i5, -50);
            } else {
                i8 = obtainStyledAttributes.getInteger(i5, -50);
            }
        }
        if (!obtainStyledAttributes.getValue(i6, typedValue)) {
            i3 = 0;
        } else if (typedValue.type == 5) {
            i3 = obtainStyledAttributes.getDimensionPixelSize(i6, 0);
        } else {
            i3 = obtainStyledAttributes.getInteger(i6, 0);
        }
        this.o = i8;
        this.n = Math.max(i8 + 1, i7);
        this.p = Math.max(i8, Math.min(i7, i3));
        H();
        this.t = obtainStyledAttributes.getString(R.styleable.DiscreteSeekBar_dsb_indicatorFormatter);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_scrubberColor);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_rippleColor);
        ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_thumbCenterColor);
        ColorStateList colorStateList5 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_indicatorTextColor);
        ColorStateList colorStateList6 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_centerPointColor);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_markerEnable, true);
        boolean isInEditMode = isInEditMode();
        colorStateList3 = (isInEditMode || colorStateList3 == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-12303292}) : colorStateList3;
        colorStateList2 = (isInEditMode || colorStateList2 == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-16738680}) : colorStateList2;
        colorStateList4 = (isInEditMode || colorStateList4 == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-16738680}) : colorStateList4;
        colorStateList6 = (isInEditMode || colorStateList6 == null) ? colorStateList2 : colorStateList6;
        Drawable a2 = us.pinguo.widget.discreteseekbar.internal.a.c.a(colorStateList3);
        this.f12535j = a2;
        if (K) {
            us.pinguo.widget.discreteseekbar.internal.a.c.d(this, a2);
        } else {
            a2.setCallback(this);
        }
        int defaultColor = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_drawCenterPoint, true) ? colorStateList6.getDefaultColor() : 0;
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.DiscreteSeekBar_dsb_trackDrawable);
        if (drawable != null) {
            this.f12533h = new us.pinguo.widget.discreteseekbar.internal.b.f(colorStateList2, drawable, defaultColor);
        } else {
            this.f12533h = new g((isInEditMode || obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_trackColor) == null) ? new ColorStateList(new int[][]{new int[0]}, new int[]{-7829368}) : colorStateList, defaultColor, m());
        }
        this.f12533h.setCallback(this);
        h hVar = new h(colorStateList2);
        this.f12534i = hVar;
        hVar.setCallback(this);
        us.pinguo.widget.discreteseekbar.internal.b.d dVar = new us.pinguo.widget.discreteseekbar.internal.b.d(colorStateList4, dimensionPixelSize2, colorStateList4.getDefaultColor());
        this.f12532g = dVar;
        dVar.setCallback(this);
        us.pinguo.widget.discreteseekbar.internal.b.d dVar2 = this.f12532g;
        dVar2.setBounds(0, 0, dVar2.getIntrinsicWidth(), this.f12532g.getIntrinsicHeight());
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_indicatorTextSize, -1);
        if (!isInEditMode) {
            PopupIndicator popupIndicator = new PopupIndicator(context, attributeSet, i2, e(this.n), dimensionPixelSize2, this.m + dimensionPixelSize2 + dimensionPixelSize3, z, colorStateList5, dimensionPixelSize4);
            this.B = popupIndicator;
            popupIndicator.l(this.J);
        }
        this.a = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_dotEnable, false);
        this.f12530e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_dotRadius, (int) (getContext().getResources().getDisplayMetrics().density * 3.0f));
        this.b = obtainStyledAttributes.getInt(R.styleable.DiscreteSeekBar_dsb_dotValue, 0);
        this.c = obtainStyledAttributes.getColor(R.styleable.DiscreteSeekBar_dsb_dotColor, 0);
        obtainStyledAttributes.recycle();
        setNumericTransformer(new d(null));
        Paint paint = new Paint();
        this.f12529d = paint;
        paint.setColor(colorStateList2.getDefaultColor());
    }

    public void setThumbColor(@NonNull ColorStateList colorStateList, int i2) {
        this.f12532g.d(colorStateList);
        this.B.k(i2, colorStateList.getColorForState(new int[]{16842919}, colorStateList.getDefaultColor()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CustomState extends View.BaseSavedState {
        public static final Parcelable.Creator<CustomState> CREATOR = new a();
        private int max;
        private int min;
        private int progress;

        /* loaded from: classes6.dex */
        static class a implements Parcelable.Creator<CustomState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CustomState createFromParcel(Parcel parcel) {
                return new CustomState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public CustomState[] newArray(int i2) {
                return new CustomState[i2];
            }
        }

        public CustomState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            this.max = parcel.readInt();
            this.min = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.progress);
            parcel.writeInt(this.max);
            parcel.writeInt(this.min);
        }

        public CustomState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
