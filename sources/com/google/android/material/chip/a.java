package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.g;
import com.google.android.material.f.c;
import com.google.android.material.f.d;
import com.google.android.material.g.b;
import com.google.android.material.internal.h;
import com.google.android.material.internal.k;
import com.google.android.material.internal.p;
import com.google.android.material.shape.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* compiled from: ChipDrawable.java */
/* loaded from: classes2.dex */
public class a extends h implements TintAwareDrawable, Drawable.Callback, h.b {
    private static final int[] J0 = {16842910};
    private static final ShapeDrawable K0 = new ShapeDrawable(new OvalShape());
    private float A;
    @Nullable
    private PorterDuff.Mode A0;
    private float B;
    private int[] B0;
    @Nullable
    private ColorStateList C;
    private boolean C0;
    private float D;
    @Nullable
    private ColorStateList D0;
    @Nullable
    private ColorStateList E;
    @NonNull
    private WeakReference<InterfaceC0168a> E0;
    @Nullable
    private CharSequence F;
    private TextUtils.TruncateAt F0;
    private boolean G;
    private boolean G0;
    @Nullable
    private Drawable H;
    private int H0;
    @Nullable
    private ColorStateList I;
    private boolean I0;
    private float J;
    private boolean K;
    private boolean L;
    @Nullable
    private Drawable M;
    @Nullable
    private Drawable N;
    @Nullable
    private ColorStateList O;
    private float P;
    @Nullable
    private CharSequence Q;
    private boolean R;
    private boolean S;
    @Nullable
    private Drawable T;
    @Nullable
    private ColorStateList U;
    private float V;
    private float W;
    private float X;
    private float Y;
    private float Z;
    private float d0;
    private float e0;
    private float f0;
    @NonNull
    private final Context g0;
    private final Paint h0;
    @Nullable
    private final Paint i0;
    private final Paint.FontMetrics j0;
    private final RectF k0;
    private final PointF l0;
    private final Path m0;
    @NonNull
    private final com.google.android.material.internal.h n0;
    @ColorInt
    private int o0;
    @ColorInt
    private int p0;
    @ColorInt
    private int q0;
    @ColorInt
    private int r0;
    @ColorInt
    private int s0;
    @ColorInt
    private int t0;
    private boolean u0;
    @ColorInt
    private int v0;
    private int w0;
    @Nullable
    private ColorFilter x0;
    @Nullable
    private ColorStateList y;
    @Nullable
    private PorterDuffColorFilter y0;
    @Nullable
    private ColorStateList z;
    @Nullable
    private ColorStateList z0;

    /* compiled from: ChipDrawable.java */
    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0168a {
        void a();
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.B = -1.0f;
        this.h0 = new Paint(1);
        this.j0 = new Paint.FontMetrics();
        this.k0 = new RectF();
        this.l0 = new PointF();
        this.m0 = new Path();
        this.w0 = 255;
        this.A0 = PorterDuff.Mode.SRC_IN;
        this.E0 = new WeakReference<>(null);
        L(context);
        this.g0 = context;
        com.google.android.material.internal.h hVar = new com.google.android.material.internal.h(this);
        this.n0 = hVar;
        this.F = "";
        hVar.e().density = context.getResources().getDisplayMetrics().density;
        this.i0 = null;
        int[] iArr = J0;
        setState(iArr);
        Y1(iArr);
        this.G0 = true;
        if (b.a) {
            K0.setTint(-1);
        }
    }

    private void A0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (A2()) {
            n0(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.H.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            this.H.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private boolean A2() {
        return this.G && this.H != null;
    }

    private void B0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.D <= 0.0f || this.I0) {
            return;
        }
        this.h0.setColor(this.r0);
        this.h0.setStyle(Paint.Style.STROKE);
        if (!this.I0) {
            this.h0.setColorFilter(Y0());
        }
        RectF rectF = this.k0;
        float f2 = this.D;
        rectF.set(rect.left + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.B - (this.D / 2.0f);
        canvas.drawRoundRect(this.k0, f3, f3, this.h0);
    }

    private boolean B2() {
        return this.L && this.M != null;
    }

    private void C0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.I0) {
            return;
        }
        this.h0.setColor(this.o0);
        this.h0.setStyle(Paint.Style.FILL);
        this.k0.set(rect);
        canvas.drawRoundRect(this.k0, H0(), H0(), this.h0);
    }

    private void C2(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void D0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (B2()) {
            q0(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.M.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            if (b.a) {
                this.N.setBounds(this.M.getBounds());
                this.N.jumpToCurrentState();
                this.N.draw(canvas);
            } else {
                this.M.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    private void D2() {
        this.D0 = this.C0 ? b.d(this.E) : null;
    }

    private void E0(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.h0.setColor(this.s0);
        this.h0.setStyle(Paint.Style.FILL);
        this.k0.set(rect);
        if (!this.I0) {
            canvas.drawRoundRect(this.k0, H0(), H0(), this.h0);
            return;
        }
        h(new RectF(rect), this.m0);
        super.p(canvas, this.h0, this.m0, u());
    }

    @TargetApi(21)
    private void E2() {
        this.N = new RippleDrawable(b.d(T0()), this.M, K0);
    }

    private void F0(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.i0;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.i0);
            if (A2() || z2()) {
                n0(rect, this.k0);
                canvas.drawRect(this.k0, this.i0);
            }
            if (this.F != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.i0);
            }
            if (B2()) {
                q0(rect, this.k0);
                canvas.drawRect(this.k0, this.i0);
            }
            this.i0.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            p0(rect, this.k0);
            canvas.drawRect(this.k0, this.i0);
            this.i0.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            r0(rect, this.k0);
            canvas.drawRect(this.k0, this.i0);
        }
    }

    private void G0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.F != null) {
            Paint.Align v0 = v0(rect, this.l0);
            t0(rect, this.k0);
            if (this.n0.d() != null) {
                this.n0.e().drawableState = getState();
                this.n0.j(this.g0);
            }
            this.n0.e().setTextAlign(v0);
            int i2 = 0;
            boolean z = Math.round(this.n0.f(U0().toString())) > Math.round(this.k0.width());
            if (z) {
                i2 = canvas.save();
                canvas.clipRect(this.k0);
            }
            CharSequence charSequence = this.F;
            if (z && this.F0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.n0.e(), this.k0.width(), this.F0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.l0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.n0.e());
            if (z) {
                canvas.restoreToCount(i2);
            }
        }
    }

    private void O1(@Nullable ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            onStateChange(getState());
        }
    }

    private float Q0() {
        Drawable drawable = this.u0 ? this.T : this.H;
        float f2 = this.J;
        if (f2 <= 0.0f && drawable != null) {
            f2 = (float) Math.ceil(p.c(this.g0, 24));
            if (drawable.getIntrinsicHeight() <= f2) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f2;
    }

    private float R0() {
        Drawable drawable = this.u0 ? this.T : this.H;
        float f2 = this.J;
        return (f2 > 0.0f || drawable == null) ? f2 : drawable.getIntrinsicWidth();
    }

    @Nullable
    private ColorFilter Y0() {
        ColorFilter colorFilter = this.x0;
        return colorFilter != null ? colorFilter : this.y0;
    }

    private static boolean a1(@Nullable int[] iArr, @AttrRes int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private static boolean e1(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean f1(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean g1(@Nullable d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.a) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void h1(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray h2 = k.h(this.g0, attributeSet, R.styleable.Chip, i2, i3, new int[0]);
        this.I0 = h2.hasValue(R.styleable.Chip_shapeAppearance);
        O1(c.a(this.g0, h2, R.styleable.Chip_chipSurfaceColor));
        s1(c.a(this.g0, h2, R.styleable.Chip_chipBackgroundColor));
        G1(h2.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
        int i4 = R.styleable.Chip_chipCornerRadius;
        if (h2.hasValue(i4)) {
            u1(h2.getDimension(i4, 0.0f));
        }
        K1(c.a(this.g0, h2, R.styleable.Chip_chipStrokeColor));
        M1(h2.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        l2(c.a(this.g0, h2, R.styleable.Chip_rippleColor));
        q2(h2.getText(R.styleable.Chip_android_text));
        d f2 = c.f(this.g0, h2, R.styleable.Chip_android_textAppearance);
        f2.f4262k = h2.getDimension(R.styleable.Chip_android_textSize, f2.f4262k);
        r2(f2);
        int i5 = h2.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i5 == 1) {
            d2(TextUtils.TruncateAt.START);
        } else if (i5 == 2) {
            d2(TextUtils.TruncateAt.MIDDLE);
        } else if (i5 == 3) {
            d2(TextUtils.TruncateAt.END);
        }
        F1(h2.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            F1(h2.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        y1(c.d(this.g0, h2, R.styleable.Chip_chipIcon));
        int i6 = R.styleable.Chip_chipIconTint;
        if (h2.hasValue(i6)) {
            C1(c.a(this.g0, h2, i6));
        }
        A1(h2.getDimension(R.styleable.Chip_chipIconSize, -1.0f));
        b2(h2.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            b2(h2.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        P1(c.d(this.g0, h2, R.styleable.Chip_closeIcon));
        Z1(c.a(this.g0, h2, R.styleable.Chip_closeIconTint));
        U1(h2.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        k1(h2.getBoolean(R.styleable.Chip_android_checkable, false));
        r1(h2.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            r1(h2.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        m1(c.d(this.g0, h2, R.styleable.Chip_checkedIcon));
        int i7 = R.styleable.Chip_checkedIconTint;
        if (h2.hasValue(i7)) {
            o1(c.a(this.g0, h2, i7));
        }
        o2(g.c(this.g0, h2, R.styleable.Chip_showMotionSpec));
        e2(g.c(this.g0, h2, R.styleable.Chip_hideMotionSpec));
        I1(h2.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
        i2(h2.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        g2(h2.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        v2(h2.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
        t2(h2.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
        W1(h2.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        R1(h2.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        w1(h2.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
        k2(h2.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        h2.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean j1(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.j1(int[], int[]):boolean");
    }

    private void m0(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.M) {
            if (drawable.isStateful()) {
                drawable.setState(O0());
            }
            DrawableCompat.setTintList(drawable, this.O);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.H;
        if (drawable == drawable2 && this.K) {
            DrawableCompat.setTintList(drawable2, this.I);
        }
    }

    private void n0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (A2() || z2()) {
            float f2 = this.V + this.W;
            float R0 = R0();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + R0;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - R0;
            }
            float Q0 = Q0();
            float exactCenterY = rect.exactCenterY() - (Q0 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + Q0;
        }
    }

    private void p0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (B2()) {
            float f2 = this.f0 + this.e0 + this.P + this.d0 + this.Z;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f2;
            } else {
                rectF.left = rect.left + f2;
            }
        }
    }

    private void q0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (B2()) {
            float f2 = this.f0 + this.e0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right - f2;
                rectF.right = f3;
                rectF.left = f3 - this.P;
            } else {
                float f4 = rect.left + f2;
                rectF.left = f4;
                rectF.right = f4 + this.P;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.P;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    private void r0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (B2()) {
            float f2 = this.f0 + this.e0 + this.P + this.d0 + this.Z;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = i2;
                rectF.right = i2 + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void t0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.F != null) {
            float o0 = this.V + o0() + this.Y;
            float s0 = this.f0 + s0() + this.Z;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + o0;
                rectF.right = rect.right - s0;
            } else {
                rectF.left = rect.left + s0;
                rectF.right = rect.right - o0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private float u0() {
        this.n0.e().getFontMetrics(this.j0);
        Paint.FontMetrics fontMetrics = this.j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean w0() {
        return this.S && this.T != null && this.R;
    }

    @NonNull
    public static a x0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.h1(attributeSet, i2, i3);
        return aVar;
    }

    private void y0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (z2()) {
            n0(rect, this.k0);
            RectF rectF = this.k0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.T.setBounds(0, 0, (int) this.k0.width(), (int) this.k0.height());
            this.T.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void z0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.I0) {
            return;
        }
        this.h0.setColor(this.p0);
        this.h0.setStyle(Paint.Style.FILL);
        this.h0.setColorFilter(Y0());
        this.k0.set(rect);
        canvas.drawRoundRect(this.k0, H0(), H0(), this.h0);
    }

    private boolean z2() {
        return this.S && this.T != null && this.u0;
    }

    public void A1(float f2) {
        if (this.J != f2) {
            float o0 = o0();
            this.J = f2;
            float o02 = o0();
            invalidateSelf();
            if (o0 != o02) {
                i1();
            }
        }
    }

    public void B1(@DimenRes int i2) {
        A1(this.g0.getResources().getDimension(i2));
    }

    public void C1(@Nullable ColorStateList colorStateList) {
        this.K = true;
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (A2()) {
                DrawableCompat.setTintList(this.H, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void D1(@ColorRes int i2) {
        C1(AppCompatResources.getColorStateList(this.g0, i2));
    }

    public void E1(@BoolRes int i2) {
        F1(this.g0.getResources().getBoolean(i2));
    }

    public void F1(boolean z) {
        if (this.G != z) {
            boolean A2 = A2();
            this.G = z;
            boolean A22 = A2();
            if (A2 != A22) {
                if (A22) {
                    m0(this.H);
                } else {
                    C2(this.H);
                }
                invalidateSelf();
                i1();
            }
        }
    }

    public void G1(float f2) {
        if (this.A != f2) {
            this.A = f2;
            invalidateSelf();
            i1();
        }
    }

    public float H0() {
        return this.I0 ? E() : this.B;
    }

    public void H1(@DimenRes int i2) {
        G1(this.g0.getResources().getDimension(i2));
    }

    public float I0() {
        return this.f0;
    }

    public void I1(float f2) {
        if (this.V != f2) {
            this.V = f2;
            invalidateSelf();
            i1();
        }
    }

    @Nullable
    public Drawable J0() {
        Drawable drawable = this.H;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void J1(@DimenRes int i2) {
        I1(this.g0.getResources().getDimension(i2));
    }

    public float K0() {
        return this.A;
    }

    public void K1(@Nullable ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (this.I0) {
                h0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float L0() {
        return this.V;
    }

    public void L1(@ColorRes int i2) {
        K1(AppCompatResources.getColorStateList(this.g0, i2));
    }

    @Nullable
    public Drawable M0() {
        Drawable drawable = this.M;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void M1(float f2) {
        if (this.D != f2) {
            this.D = f2;
            this.h0.setStrokeWidth(f2);
            if (this.I0) {
                super.i0(f2);
            }
            invalidateSelf();
        }
    }

    @Nullable
    public CharSequence N0() {
        return this.Q;
    }

    public void N1(@DimenRes int i2) {
        M1(this.g0.getResources().getDimension(i2));
    }

    @NonNull
    public int[] O0() {
        return this.B0;
    }

    public void P0(@NonNull RectF rectF) {
        r0(getBounds(), rectF);
    }

    public void P1(@Nullable Drawable drawable) {
        Drawable M0 = M0();
        if (M0 != drawable) {
            float s0 = s0();
            this.M = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (b.a) {
                E2();
            }
            float s02 = s0();
            C2(M0);
            if (B2()) {
                m0(this.M);
            }
            invalidateSelf();
            if (s0 != s02) {
                i1();
            }
        }
    }

    public void Q1(@Nullable CharSequence charSequence) {
        if (this.Q != charSequence) {
            this.Q = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public void R1(float f2) {
        if (this.e0 != f2) {
            this.e0 = f2;
            invalidateSelf();
            if (B2()) {
                i1();
            }
        }
    }

    public TextUtils.TruncateAt S0() {
        return this.F0;
    }

    public void S1(@DimenRes int i2) {
        R1(this.g0.getResources().getDimension(i2));
    }

    @Nullable
    public ColorStateList T0() {
        return this.E;
    }

    public void T1(@DrawableRes int i2) {
        P1(AppCompatResources.getDrawable(this.g0, i2));
    }

    @Nullable
    public CharSequence U0() {
        return this.F;
    }

    public void U1(float f2) {
        if (this.P != f2) {
            this.P = f2;
            invalidateSelf();
            if (B2()) {
                i1();
            }
        }
    }

    @Nullable
    public d V0() {
        return this.n0.d();
    }

    public void V1(@DimenRes int i2) {
        U1(this.g0.getResources().getDimension(i2));
    }

    public float W0() {
        return this.Z;
    }

    public void W1(float f2) {
        if (this.d0 != f2) {
            this.d0 = f2;
            invalidateSelf();
            if (B2()) {
                i1();
            }
        }
    }

    public float X0() {
        return this.Y;
    }

    public void X1(@DimenRes int i2) {
        W1(this.g0.getResources().getDimension(i2));
    }

    public boolean Y1(@NonNull int[] iArr) {
        if (Arrays.equals(this.B0, iArr)) {
            return false;
        }
        this.B0 = iArr;
        if (B2()) {
            return j1(getState(), iArr);
        }
        return false;
    }

    public boolean Z0() {
        return this.C0;
    }

    public void Z1(@Nullable ColorStateList colorStateList) {
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (B2()) {
                DrawableCompat.setTintList(this.M, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        i1();
        invalidateSelf();
    }

    public void a2(@ColorRes int i2) {
        Z1(AppCompatResources.getColorStateList(this.g0, i2));
    }

    public boolean b1() {
        return this.R;
    }

    public void b2(boolean z) {
        if (this.L != z) {
            boolean B2 = B2();
            this.L = z;
            boolean B22 = B2();
            if (B2 != B22) {
                if (B22) {
                    m0(this.M);
                } else {
                    C2(this.M);
                }
                invalidateSelf();
                i1();
            }
        }
    }

    public boolean c1() {
        return f1(this.M);
    }

    public void c2(@Nullable InterfaceC0168a interfaceC0168a) {
        this.E0 = new WeakReference<>(interfaceC0168a);
    }

    public boolean d1() {
        return this.L;
    }

    public void d2(@Nullable TextUtils.TruncateAt truncateAt) {
        this.F0 = truncateAt;
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i2 = this.w0;
        int a = i2 < 255 ? com.google.android.material.a.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2) : 0;
        C0(canvas, bounds);
        z0(canvas, bounds);
        if (this.I0) {
            super.draw(canvas);
        }
        B0(canvas, bounds);
        E0(canvas, bounds);
        A0(canvas, bounds);
        y0(canvas, bounds);
        if (this.G0) {
            G0(canvas, bounds);
        }
        D0(canvas, bounds);
        F0(canvas, bounds);
        if (this.w0 < 255) {
            canvas.restoreToCount(a);
        }
    }

    public void e2(@Nullable g gVar) {
    }

    public void f2(@AnimatorRes int i2) {
        e2(g.d(this.g0, i2));
    }

    public void g2(float f2) {
        if (this.X != f2) {
            float o0 = o0();
            this.X = f2;
            float o02 = o0();
            invalidateSelf();
            if (o0 != o02) {
                i1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.w0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.V + o0() + this.Y + this.n0.f(U0().toString()) + this.Z + s0() + this.f0), this.H0);
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.B);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.B);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public void h2(@DimenRes int i2) {
        g2(this.g0.getResources().getDimension(i2));
    }

    protected void i1() {
        InterfaceC0168a interfaceC0168a = this.E0.get();
        if (interfaceC0168a != null) {
            interfaceC0168a.a();
        }
    }

    public void i2(float f2) {
        if (this.W != f2) {
            float o0 = o0();
            this.W = f2;
            float o02 = o0();
            invalidateSelf();
            if (o0 != o02) {
                i1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return e1(this.y) || e1(this.z) || e1(this.C) || (this.C0 && e1(this.D0)) || g1(this.n0.d()) || w0() || f1(this.H) || f1(this.T) || e1(this.z0);
    }

    public void j2(@DimenRes int i2) {
        i2(this.g0.getResources().getDimension(i2));
    }

    public void k1(boolean z) {
        if (this.R != z) {
            this.R = z;
            float o0 = o0();
            if (!z && this.u0) {
                this.u0 = false;
            }
            float o02 = o0();
            invalidateSelf();
            if (o0 != o02) {
                i1();
            }
        }
    }

    public void k2(@Px int i2) {
        this.H0 = i2;
    }

    public void l1(@BoolRes int i2) {
        k1(this.g0.getResources().getBoolean(i2));
    }

    public void l2(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            D2();
            onStateChange(getState());
        }
    }

    public void m1(@Nullable Drawable drawable) {
        if (this.T != drawable) {
            float o0 = o0();
            this.T = drawable;
            float o02 = o0();
            C2(this.T);
            m0(this.T);
            invalidateSelf();
            if (o0 != o02) {
                i1();
            }
        }
    }

    public void m2(@ColorRes int i2) {
        l2(AppCompatResources.getColorStateList(this.g0, i2));
    }

    public void n1(@DrawableRes int i2) {
        m1(AppCompatResources.getDrawable(this.g0, i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n2(boolean z) {
        this.G0 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float o0() {
        if (A2() || z2()) {
            return this.W + R0() + this.X;
        }
        return 0.0f;
    }

    public void o1(@Nullable ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (w0()) {
                DrawableCompat.setTintList(this.T, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void o2(@Nullable g gVar) {
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (A2()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.H, i2);
        }
        if (z2()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.T, i2);
        }
        if (B2()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.M, i2);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (A2()) {
            onLevelChange |= this.H.setLevel(i2);
        }
        if (z2()) {
            onLevelChange |= this.T.setLevel(i2);
        }
        if (B2()) {
            onLevelChange |= this.M.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.I0) {
            super.onStateChange(iArr);
        }
        return j1(iArr, O0());
    }

    public void p1(@ColorRes int i2) {
        o1(AppCompatResources.getColorStateList(this.g0, i2));
    }

    public void p2(@AnimatorRes int i2) {
        o2(g.d(this.g0, i2));
    }

    public void q1(@BoolRes int i2) {
        r1(this.g0.getResources().getBoolean(i2));
    }

    public void q2(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.F, charSequence)) {
            return;
        }
        this.F = charSequence;
        this.n0.i(true);
        invalidateSelf();
        i1();
    }

    public void r1(boolean z) {
        if (this.S != z) {
            boolean z2 = z2();
            this.S = z;
            boolean z22 = z2();
            if (z2 != z22) {
                if (z22) {
                    m0(this.T);
                } else {
                    C2(this.T);
                }
                invalidateSelf();
                i1();
            }
        }
    }

    public void r2(@Nullable d dVar) {
        this.n0.h(dVar, this.g0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s0() {
        if (B2()) {
            return this.d0 + this.P + this.e0;
        }
        return 0.0f;
    }

    public void s1(@Nullable ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            onStateChange(getState());
        }
    }

    public void s2(@StyleRes int i2) {
        r2(new d(this.g0, i2));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.x0 != colorFilter) {
            this.x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.z0 != colorStateList) {
            this.z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.A0 != mode) {
            this.A0 = mode;
            this.y0 = com.google.android.material.c.a.b(this, this.z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (A2()) {
            visible |= this.H.setVisible(z, z2);
        }
        if (z2()) {
            visible |= this.T.setVisible(z, z2);
        }
        if (B2()) {
            visible |= this.M.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t1(@ColorRes int i2) {
        s1(AppCompatResources.getColorStateList(this.g0, i2));
    }

    public void t2(float f2) {
        if (this.Z != f2) {
            this.Z = f2;
            invalidateSelf();
            i1();
        }
    }

    @Deprecated
    public void u1(float f2) {
        if (this.B != f2) {
            this.B = f2;
            setShapeAppearanceModel(C().w(f2));
        }
    }

    public void u2(@DimenRes int i2) {
        t2(this.g0.getResources().getDimension(i2));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    @NonNull
    Paint.Align v0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.F != null) {
            float o0 = this.V + o0() + this.Y;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + o0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - o0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - u0();
        }
        return align;
    }

    @Deprecated
    public void v1(@DimenRes int i2) {
        u1(this.g0.getResources().getDimension(i2));
    }

    public void v2(float f2) {
        if (this.Y != f2) {
            this.Y = f2;
            invalidateSelf();
            i1();
        }
    }

    public void w1(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            i1();
        }
    }

    public void w2(@DimenRes int i2) {
        v2(this.g0.getResources().getDimension(i2));
    }

    public void x1(@DimenRes int i2) {
        w1(this.g0.getResources().getDimension(i2));
    }

    public void x2(boolean z) {
        if (this.C0 != z) {
            this.C0 = z;
            D2();
            onStateChange(getState());
        }
    }

    public void y1(@Nullable Drawable drawable) {
        Drawable J02 = J0();
        if (J02 != drawable) {
            float o0 = o0();
            this.H = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float o02 = o0();
            C2(J02);
            if (A2()) {
                m0(this.H);
            }
            invalidateSelf();
            if (o0 != o02) {
                i1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y2() {
        return this.G0;
    }

    public void z1(@DrawableRes int i2) {
        y1(AppCompatResources.getDrawable(this.g0, i2));
    }
}
