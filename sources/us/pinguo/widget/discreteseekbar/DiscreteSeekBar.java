package us.pinguo.widget.discreteseekbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
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
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.material.timepicker.TimeModel;
import java.util.Formatter;
import java.util.Locale;
import us.pinguo.widget.discreteseekbar.internal.PopupIndicator;
import us.pinguo.widget.discreteseekbar.internal.a.a;
import us.pinguo.widget.discreteseekbar.internal.b.b;
/* loaded from: classes6.dex */
public class DiscreteSeekBar extends View {
    private static final boolean S;
    private int A;
    private Rect B;
    private Rect C;
    private PopupIndicator D;
    private us.pinguo.widget.discreteseekbar.internal.a.a E;
    private float F;
    private int G;
    private float H;
    private float I;
    private boolean J;
    private float K;
    private float L;
    private int M;
    private Paint N;
    private Paint O;
    private Runnable P;
    private Runnable Q;
    private b.InterfaceC0469b R;
    private boolean a;
    private boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12538d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f12539e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.widget.discreteseekbar.internal.b.d f12540f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.widget.discreteseekbar.internal.b.h f12541g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.widget.discreteseekbar.internal.b.h f12542h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f12543i;

    /* renamed from: j  reason: collision with root package name */
    private int f12544j;

    /* renamed from: k  reason: collision with root package name */
    private int f12545k;

    /* renamed from: l  reason: collision with root package name */
    private int f12546l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    Formatter t;
    private String u;
    private f v;
    private StringBuilder w;
    private g x;
    private h y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DiscreteSeekBar.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements a.InterfaceC0467a {
        b() {
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.a.a.InterfaceC0467a
        public void a(float f2) {
            DiscreteSeekBar.this.y(f2);
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DiscreteSeekBar.this.C();
        }
    }

    /* loaded from: classes6.dex */
    class d implements b.InterfaceC0469b {
        d() {
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
        public void a() {
            DiscreteSeekBar.this.f12540f.h();
        }

        @Override // us.pinguo.widget.discreteseekbar.internal.b.b.InterfaceC0469b
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e extends f {
        private e() {
        }

        @Override // us.pinguo.widget.discreteseekbar.DiscreteSeekBar.f
        public int a(int i2) {
            return i2;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class f {
        public abstract int a(int i2);

        public String b(int i2) {
            return String.valueOf(i2);
        }

        public boolean c() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    public interface g {
        void onProgressChanged(DiscreteSeekBar discreteSeekBar, int i2, boolean z);

        void onStartTrackingTouch(DiscreteSeekBar discreteSeekBar);

        void onStopTrackingTouch(DiscreteSeekBar discreteSeekBar);
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(DiscreteSeekBar discreteSeekBar, int i2);
    }

    static {
        S = Build.VERSION.SDK_INT >= 21;
    }

    public DiscreteSeekBar(Context context) {
        this(context, null);
    }

    private void A(int i2, boolean z) {
        int max = Math.max(this.n, Math.min(this.m, i2));
        if (p()) {
            this.E.a();
        }
        if (this.o != max) {
            this.o = max;
            u(max, z);
            K(max);
            if (z) {
                return;
            }
            M();
        }
    }

    private void B(int i2) {
        A(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (isInEditMode()) {
            return;
        }
        this.D.n(this, this.f12540f.getBounds());
        t(true);
    }

    private boolean D(MotionEvent motionEvent, boolean z) {
        Rect rect = this.C;
        this.f12540f.copyBounds(rect);
        int i2 = this.f12546l;
        rect.inset(-i2, -i2);
        boolean contains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        this.z = contains;
        if (!contains && this.r && !z) {
            this.z = true;
            this.A = (rect.width() / 2) - this.f12546l;
            C();
            F(motionEvent);
            this.f12540f.copyBounds(rect);
            int i3 = this.f12546l;
            rect.inset(-i3, -i3);
        }
        if (this.z) {
            setPressed(true);
            e();
            z(motionEvent.getX(), motionEvent.getY());
            this.A = (int) ((motionEvent.getX() - rect.left) - this.f12546l);
            g gVar = this.x;
            if (gVar != null) {
                gVar.onStartTrackingTouch(this);
            }
        }
        return this.z;
    }

    private void E() {
        g gVar = this.x;
        if (gVar != null) {
            gVar.onStopTrackingTouch(this);
        }
        this.z = false;
        setPressed(false);
    }

    private void F(MotionEvent motionEvent) {
        z(motionEvent.getX(), motionEvent.getY());
        int width = this.f12540f.getBounds().width() / 2;
        int i2 = this.f12546l;
        int x = ((int) motionEvent.getX()) - this.A;
        int paddingLeft = getPaddingLeft() + width + i2;
        int width2 = getWidth() - ((getPaddingRight() + width) + i2);
        int s = s();
        if (x < 0) {
            x = 0;
        } else if (x > s) {
            x = s();
        }
        float f2 = x / (width2 - paddingLeft);
        if (r()) {
            f2 = 1.0f - f2;
        }
        int i3 = this.m;
        int i4 = this.n;
        int round = Math.round((f2 * (i3 - i4)) + i4);
        L(x);
        A(round, true);
    }

    private void G() {
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
        if (isEnabled() && ((z || z2) && this.s)) {
            removeCallbacks(this.Q);
            postDelayed(this.Q, 150L);
        } else {
            o();
        }
        this.f12540f.setState(drawableState);
        this.f12541g.setState(drawableState);
        this.f12542h.setState(drawableState);
        this.f12543i.setState(drawableState);
    }

    private void H() {
        if (isInEditMode()) {
            return;
        }
        if (this.v.c()) {
            this.D.q(this.v.b(this.m));
            return;
        }
        PopupIndicator popupIndicator = this.D;
        f fVar = this.v;
        int i2 = this.m;
        fVar.a(i2);
        popupIndicator.q(g(i2));
    }

    private void I() {
        int i2 = this.m - this.n;
        int i3 = this.p;
        if (i3 == 0 || i2 / i3 > 20) {
            this.p = Math.max(1, Math.round(i2 / 20.0f));
        }
    }

    private void J(float f2) {
        int width = this.f12540f.getBounds().width() / 2;
        int i2 = this.f12546l;
        int width2 = (getWidth() - ((getPaddingRight() + width) + i2)) - ((getPaddingLeft() + width) + i2);
        int i3 = this.m;
        int i4 = this.n;
        int round = Math.round(((i3 - i4) * f2) + i4);
        if (round != n()) {
            this.o = round;
            u(round, true);
            K(round);
        }
        L((int) ((f2 * width2) + 0.5f));
    }

    private void K(int i2) {
        if (isInEditMode()) {
            return;
        }
        if (this.v.c()) {
            this.D.m(this.v.b(i2));
            return;
        }
        PopupIndicator popupIndicator = this.D;
        this.v.a(i2);
        popupIndicator.m(g(i2));
    }

    private void L(int i2) {
        int paddingLeft;
        int i3;
        int intrinsicWidth = this.f12540f.getIntrinsicWidth();
        int i4 = intrinsicWidth / 2;
        if (r()) {
            paddingLeft = (getWidth() - getPaddingRight()) - this.f12546l;
            i3 = (paddingLeft - i2) - intrinsicWidth;
        } else {
            paddingLeft = getPaddingLeft() + this.f12546l;
            i3 = i2 + paddingLeft;
        }
        this.f12540f.copyBounds(this.B);
        us.pinguo.widget.discreteseekbar.internal.b.d dVar = this.f12540f;
        Rect rect = this.B;
        dVar.setBounds(i3, rect.top, intrinsicWidth + i3, rect.bottom);
        if (r()) {
            this.f12542h.getBounds().right = paddingLeft - i4;
            this.f12542h.getBounds().left = i3 + i4;
        } else {
            this.f12542h.getBounds().left = paddingLeft + i4;
            this.f12542h.getBounds().right = i3 + i4;
        }
        Rect rect2 = this.C;
        this.f12540f.copyBounds(rect2);
        if (!isInEditMode()) {
            this.D.j(rect2.centerX());
        }
        Rect rect3 = this.B;
        int i5 = this.f12546l;
        rect3.inset(-i5, -i5);
        int i6 = this.f12546l;
        rect2.inset(-i6, -i6);
        this.B.union(rect2);
        us.pinguo.widget.discreteseekbar.internal.a.c.e(this.f12543i, 0, 0, 0, 0);
        invalidate(this.B);
    }

    private void M() {
        int intrinsicWidth = this.f12540f.getIntrinsicWidth();
        int i2 = this.f12546l;
        int i3 = intrinsicWidth / 2;
        int i4 = this.o;
        int i5 = this.n;
        L((int) ((((i4 - i5) / (this.m - i5)) * ((getWidth() - ((getPaddingRight() + i3) + i2)) - ((getPaddingLeft() + i3) + i2))) + 0.5f));
    }

    private void e() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void f() {
        if (this.H > m()) {
            B(this.o + 1);
        } else {
            B(this.o - 1);
        }
        h hVar = this.y;
        if (hVar != null) {
            hVar.a(this, this.o);
        }
        removeCallbacks(this.P);
        C();
        postDelayed(this.P, 500L);
    }

    private String g(int i2) {
        String str = this.u;
        if (str == null) {
            str = TimeModel.NUMBER_FORMAT;
        }
        Formatter formatter = this.t;
        if (formatter != null && formatter.locale().equals(Locale.getDefault())) {
            this.w.setLength(0);
        } else {
            int length = str.length() + String.valueOf(this.m).length();
            StringBuilder sb = this.w;
            if (sb == null) {
                this.w = new StringBuilder(length);
            } else {
                sb.ensureCapacity(length);
            }
            this.t = new Formatter(this.w, Locale.getDefault());
        }
        return this.t.format(str, Integer.valueOf(i2)).toString();
    }

    private void h(Canvas canvas) {
        if (this.b) {
            int i2 = this.f12538d;
            if (i2 != 0) {
                this.O.setColor(i2);
            } else {
                this.O.setColor(this.f12540f.b());
            }
            int intrinsicWidth = this.f12540f.getIntrinsicWidth();
            int i3 = this.f12546l;
            int i4 = intrinsicWidth / 2;
            float paddingTop = getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2);
            float paddingLeft = getPaddingLeft() + this.f12546l + ((int) ((((this.c * 1.0f) / (this.m - this.n)) * ((getWidth() - ((getPaddingRight() + i4) + i3)) - ((getPaddingLeft() + i4) + i3))) + 0.5f)) + i4;
            RectF rectF = this.f12539e;
            float f2 = this.L;
            rectF.set(paddingLeft - (f2 / 2.0f), paddingTop - f2, paddingLeft + (f2 / 2.0f), paddingTop + f2);
            RectF rectF2 = this.f12539e;
            float f3 = this.L;
            canvas.drawRoundRect(rectF2, f3 / 2.0f, f3 / 2.0f, this.O);
        }
    }

    private void i(Canvas canvas) {
        int paddingLeft;
        if (this.J) {
            this.N.setColor(this.M);
            float paddingTop = getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2);
            for (int i2 = this.n; i2 <= this.m; i2++) {
                int intrinsicWidth = this.f12540f.getIntrinsicWidth();
                int i3 = this.f12546l;
                int i4 = intrinsicWidth / 2;
                int i5 = this.n;
                int width = (int) ((((i2 - i5) / (this.m - i5)) * ((getWidth() - ((getPaddingRight() + i4) + i3)) - ((getPaddingLeft() + i4) + i3))) + 0.5f);
                if (r()) {
                    paddingLeft = (((getWidth() - getPaddingRight()) - this.f12546l) - width) - intrinsicWidth;
                } else {
                    paddingLeft = getPaddingLeft() + this.f12546l + width;
                }
                canvas.drawCircle(paddingLeft + i4, paddingTop, this.K, this.N);
            }
        }
    }

    private int j() {
        return p() ? l() : this.o;
    }

    private int l() {
        return this.G;
    }

    private int m() {
        int intrinsicWidth = this.f12540f.getIntrinsicWidth();
        int i2 = this.f12546l;
        int i3 = intrinsicWidth / 2;
        int i4 = this.o;
        int i5 = this.n;
        float f2 = (i4 - i5) / (this.m - i5);
        int paddingLeft = getPaddingLeft() + i3 + i2;
        return ((int) ((f2 * ((getWidth() - ((getPaddingRight() + i3) + i2)) - paddingLeft)) + 0.5f)) + paddingLeft;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        removeCallbacks(this.Q);
        if (isInEditMode()) {
            return;
        }
        this.D.e();
        t(false);
    }

    private boolean q() {
        return this.z;
    }

    private int s() {
        int intrinsicWidth = this.f12540f.getIntrinsicWidth();
        int i2 = this.f12546l;
        int i3 = intrinsicWidth / 2;
        return (getWidth() - ((getPaddingRight() + i3) + i2)) - ((getPaddingLeft() + i3) + i2);
    }

    private void t(boolean z) {
        if (z) {
            w();
        } else {
            v();
        }
    }

    private void u(int i2, boolean z) {
        g gVar = this.x;
        if (gVar != null) {
            gVar.onProgressChanged(this, i2, z);
        }
        x(i2);
    }

    private void z(float f2, float f3) {
        DrawableCompat.setHotspot(this.f12543i, f2, f3);
    }

    void d(int i2) {
        float k2 = p() ? k() : n();
        int i3 = this.n;
        if (i2 < i3 || i2 > (i3 = this.m)) {
            i2 = i3;
        }
        us.pinguo.widget.discreteseekbar.internal.a.a aVar = this.E;
        if (aVar != null) {
            aVar.a();
        }
        this.G = i2;
        us.pinguo.widget.discreteseekbar.internal.a.a b2 = us.pinguo.widget.discreteseekbar.internal.a.a.b(k2, i2, new b());
        this.E = b2;
        b2.d(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        this.E.e();
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        G();
    }

    float k() {
        return this.F;
    }

    public int n() {
        return this.o;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Q);
        if (isInEditMode()) {
            return;
        }
        this.D.f();
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        if (!S) {
            this.f12543i.draw(canvas);
        }
        super.onDraw(canvas);
        this.f12541g.draw(canvas);
        this.f12542h.draw(canvas);
        i(canvas);
        h(canvas);
        this.f12540f.draw(canvas);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z;
        if (isEnabled()) {
            int j2 = j();
            if (i2 != 21) {
                if (i2 == 22) {
                    if (j2 < this.m) {
                        d(j2 + this.p);
                    }
                }
            } else if (j2 > this.n) {
                d(j2 - this.p);
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
            removeCallbacks(this.Q);
            if (!isInEditMode()) {
                this.D.f();
            }
            G();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(View.MeasureSpec.getSize(i2), this.f12540f.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom() + (this.f12546l * 2));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(CustomState.class)) {
            CustomState customState = (CustomState) parcelable;
            setMin(customState.min);
            setMax(customState.max);
            A(customState.progress, false);
            super.onRestoreInstanceState(customState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        CustomState customState = new CustomState(super.onSaveInstanceState());
        customState.progress = n();
        customState.max = this.m;
        customState.min = this.n;
        return customState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int intrinsicWidth = this.f12540f.getIntrinsicWidth();
        int intrinsicHeight = this.f12540f.getIntrinsicHeight();
        int i6 = this.f12546l;
        int i7 = intrinsicWidth / 2;
        int paddingLeft = getPaddingLeft() + i6;
        int paddingRight = getPaddingRight();
        int height = (getHeight() - getPaddingBottom()) - i6;
        this.f12540f.setBounds(paddingLeft, height - intrinsicHeight, intrinsicWidth + paddingLeft, height);
        int max = Math.max(this.f12544j / 2, 1);
        int i8 = paddingLeft + i7;
        int i9 = height - i7;
        this.f12541g.setBounds(i8, i9 - max, ((getWidth() - i7) - paddingRight) - i6, max + i9);
        int max2 = Math.max(this.f12545k / 2, 2);
        this.f12542h.setBounds(i8, i9 - max2, i8, i9 + max2);
        M();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                this.a = false;
                this.H = motionEvent.getX();
            } else if (actionMasked == 1) {
                if (!this.a) {
                    f();
                } else if (!q() && this.r) {
                    D(motionEvent, false);
                    F(motionEvent);
                }
                M();
                E();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    E();
                }
            } else if (this.a || Math.abs(motionEvent.getX() - this.H) > this.I) {
                this.a = true;
                if (q()) {
                    F(motionEvent);
                } else if (Math.abs(motionEvent.getX() - this.H) > this.I) {
                    D(motionEvent, false);
                }
            }
            return true;
        }
        return false;
    }

    boolean p() {
        us.pinguo.widget.discreteseekbar.internal.a.a aVar = this.E;
        return aVar != null && aVar.c();
    }

    public boolean r() {
        return ViewCompat.getLayoutDirection(this) == 1 && this.q;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        super.scheduleDrawable(drawable, runnable, j2);
    }

    public void setDotColor(int i2) {
        this.f12538d = i2;
    }

    public void setDotEnable(boolean z) {
        this.b = z;
    }

    public void setDotPosition(int i2) {
        this.c = i2;
    }

    public void setIndicatorFormatter(@Nullable String str) {
        this.u = str;
        K(this.o);
    }

    public void setIndicatorPopupEnabled(boolean z) {
        this.s = z;
    }

    public void setMax(int i2) {
        this.m = i2;
        if (i2 < this.n) {
            setMin(i2 - 1);
        }
        I();
        int i3 = this.o;
        int i4 = this.n;
        if (i3 < i4 || i3 > this.m) {
            setProgress(i4);
        }
        H();
    }

    public void setMin(int i2) {
        this.n = i2;
        if (i2 > this.m) {
            setMax(i2 + 1);
        }
        I();
        int i3 = this.o;
        int i4 = this.n;
        if (i3 < i4 || i3 > this.m) {
            setProgress(i4);
        }
    }

    public void setNumericTransformer(@Nullable f fVar) {
        if (fVar == null) {
            fVar = new e(null);
        }
        this.v = fVar;
        H();
        K(this.o);
    }

    public void setOnProgressChangeListener(@Nullable g gVar) {
        this.x = gVar;
    }

    public void setOnProgressChangedByClickListener(@Nullable h hVar) {
        this.y = hVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        PopupIndicator popupIndicator;
        if (isShown() || ((popupIndicator = this.D) != null && popupIndicator.h())) {
            super.setPressed(z);
        }
    }

    public void setProgress(int i2) {
        A(i2, false);
    }

    public void setRippleColor(int i2) {
        setRippleColor(new ColorStateList(new int[][]{new int[0]}, new int[]{i2}));
    }

    public void setScrubberColor(int i2) {
        this.f12542h.d(ColorStateList.valueOf(i2));
    }

    public void setShowSpot(boolean z) {
        this.J = z;
    }

    public void setSpotColor(int i2) {
        this.M = i2;
    }

    public void setSpotRadius(float f2) {
        this.K = f2;
    }

    public void setThumbColor(int i2, int i3) {
        this.f12540f.d(ColorStateList.valueOf(i2));
        this.D.k(i3, i2);
    }

    public void setTrackColor(int i2) {
        this.f12541g.d(ColorStateList.valueOf(i2));
    }

    protected void v() {
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f12540f || drawable == this.f12541g || drawable == this.f12542h || drawable == this.f12543i || super.verifyDrawable(drawable);
    }

    protected void w() {
    }

    protected void x(int i2) {
    }

    void y(float f2) {
        this.F = f2;
        int i2 = this.n;
        J((f2 - i2) / (this.m - i2));
    }

    public DiscreteSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.discreteSeekBarStyle);
    }

    public void setRippleColor(@NonNull ColorStateList colorStateList) {
        us.pinguo.widget.discreteseekbar.internal.a.c.g(this.f12543i, colorStateList);
    }

    public void setScrubberColor(@NonNull ColorStateList colorStateList) {
        this.f12542h.d(colorStateList);
    }

    public void setTrackColor(@NonNull ColorStateList colorStateList) {
        this.f12541g.d(colorStateList);
    }

    public DiscreteSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int integer;
        this.b = true;
        this.c = 0;
        this.f12538d = 0;
        this.f12539e = new RectF();
        this.p = 1;
        this.q = false;
        this.r = true;
        this.s = true;
        this.B = new Rect();
        this.C = new Rect();
        this.P = new a();
        this.Q = new c();
        this.R = new d();
        setFocusable(true);
        setWillNotDraw(false);
        this.I = ViewConfiguration.get(context).getScaledTouchSlop();
        float f2 = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DiscreteSeekBar, i2, R.style.Widget_DiscreteSeekBar);
        this.q = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_mirrorForRtl, this.q);
        this.r = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_allowTrackClickToDrag, this.r);
        this.s = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_indicatorPopupEnabled, this.s);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_trackHeight, (int) (1.0f * f2));
        this.f12544j = dimensionPixelSize;
        this.f12545k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_scrubberHeight, dimensionPixelSize);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_thumbSize, (int) (12.0f * f2));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_indicatorSeparation, (int) (5.0f * f2));
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_markerEnable, true);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_indicatorTextColor);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_indicatorTextSize, -1);
        this.f12546l = Math.max(0, (((int) (f2 * 32.0f)) - dimensionPixelSize2) / 2);
        int i8 = R.styleable.DiscreteSeekBar_dsb_max;
        int i9 = R.styleable.DiscreteSeekBar_dsb_min;
        int i10 = R.styleable.DiscreteSeekBar_dsb_value;
        TypedValue typedValue = new TypedValue();
        int i11 = 100;
        if (obtainStyledAttributes.getValue(i8, typedValue)) {
            if (typedValue.type == 5) {
                i11 = obtainStyledAttributes.getDimensionPixelSize(i8, 100);
            } else {
                i11 = obtainStyledAttributes.getInteger(i8, 100);
            }
        }
        if (obtainStyledAttributes.getValue(i9, typedValue)) {
            if (typedValue.type == 5) {
                i3 = 0;
                integer = obtainStyledAttributes.getDimensionPixelSize(i9, 0);
            } else {
                i3 = 0;
                integer = obtainStyledAttributes.getInteger(i9, 0);
            }
            i4 = integer;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (!obtainStyledAttributes.getValue(i10, typedValue)) {
            i5 = 0;
        } else if (typedValue.type == 5) {
            i5 = obtainStyledAttributes.getDimensionPixelSize(i10, i3);
        } else {
            i5 = obtainStyledAttributes.getInteger(i10, i3);
        }
        this.n = i4;
        this.m = Math.max(i4 + 1, i11);
        this.o = Math.max(i4, Math.min(i11, i5));
        I();
        this.u = obtainStyledAttributes.getString(R.styleable.DiscreteSeekBar_dsb_indicatorFormatter);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_trackColor);
        ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_scrubberColor);
        ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(R.styleable.DiscreteSeekBar_dsb_rippleColor);
        boolean isInEditMode = isInEditMode();
        if (isInEditMode || colorStateList4 == null) {
            i6 = 1;
            i7 = 0;
            colorStateList4 = new ColorStateList(new int[][]{new int[0]}, new int[]{-12303292});
        } else {
            i6 = 1;
            i7 = 0;
        }
        if (isInEditMode || colorStateList2 == null) {
            int[][] iArr = new int[i6];
            iArr[i7] = new int[i7];
            int[] iArr2 = new int[i6];
            iArr2[i7] = -7829368;
            colorStateList2 = new ColorStateList(iArr, iArr2);
        }
        if (isInEditMode || colorStateList3 == null) {
            int[][] iArr3 = new int[i6];
            iArr3[i7] = new int[i7];
            int[] iArr4 = new int[i6];
            iArr4[i7] = -16738680;
            colorStateList3 = new ColorStateList(iArr3, iArr4);
        }
        Drawable a2 = us.pinguo.widget.discreteseekbar.internal.a.c.a(colorStateList4);
        this.f12543i = a2;
        if (S) {
            us.pinguo.widget.discreteseekbar.internal.a.c.d(this, a2);
        } else {
            a2.setCallback(this);
        }
        us.pinguo.widget.discreteseekbar.internal.b.h hVar = new us.pinguo.widget.discreteseekbar.internal.b.h(colorStateList2);
        this.f12541g = hVar;
        hVar.setCallback(this);
        us.pinguo.widget.discreteseekbar.internal.b.h hVar2 = new us.pinguo.widget.discreteseekbar.internal.b.h(colorStateList3);
        this.f12542h = hVar2;
        hVar2.setCallback(this);
        us.pinguo.widget.discreteseekbar.internal.b.d dVar = new us.pinguo.widget.discreteseekbar.internal.b.d(colorStateList3, dimensionPixelSize2, -3355444);
        this.f12540f = dVar;
        dVar.setCallback(this);
        us.pinguo.widget.discreteseekbar.internal.b.d dVar2 = this.f12540f;
        dVar2.setBounds(0, 0, dVar2.getIntrinsicWidth(), this.f12540f.getIntrinsicHeight());
        if (!isInEditMode) {
            PopupIndicator popupIndicator = new PopupIndicator(context, attributeSet, i2, g(this.m), dimensionPixelSize2, this.f12546l + dimensionPixelSize2 + dimensionPixelSize3, z, colorStateList, dimensionPixelSize4);
            this.D = popupIndicator;
            popupIndicator.l(this.R);
        }
        this.K = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_spotRadius, (int) (getContext().getResources().getDisplayMetrics().density * 2.0f));
        this.J = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_spotEnable, false);
        this.M = obtainStyledAttributes.getColor(R.styleable.DiscreteSeekBar_dsb_spotColor, Color.parseColor("#99ffffff"));
        this.b = obtainStyledAttributes.getBoolean(R.styleable.DiscreteSeekBar_dsb_dotEnable, false);
        this.L = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DiscreteSeekBar_dsb_dotRadius, (int) (getContext().getResources().getDisplayMetrics().density * 3.0f));
        this.c = obtainStyledAttributes.getInt(R.styleable.DiscreteSeekBar_dsb_dotValue, 0);
        this.f12538d = obtainStyledAttributes.getColor(R.styleable.DiscreteSeekBar_dsb_dotColor, 0);
        obtainStyledAttributes.recycle();
        setNumericTransformer(new e(null));
        Paint paint = new Paint();
        this.N = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.O = paint2;
        paint2.setColor(colorStateList3.getDefaultColor());
    }

    public void setThumbColor(@NonNull ColorStateList colorStateList, int i2) {
        this.f12540f.d(colorStateList);
        this.D.k(i2, colorStateList.getColorForState(new int[]{16842919}, colorStateList.getDefaultColor()));
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
