package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.f.a;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
/* compiled from: CollapsingTextHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a {
    private static final boolean j0;
    @NonNull
    private static final Paint k0;
    private com.google.android.material.f.a A;
    @Nullable
    private CharSequence B;
    @Nullable
    private CharSequence C;
    private boolean D;
    private boolean F;
    @Nullable
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;
    @NonNull
    private final TextPaint M;
    @NonNull
    private final TextPaint N;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private float Y;
    private float Z;
    private final View a;
    private StaticLayout a0;
    private boolean b;
    private float b0;
    private float c;
    private float c0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4359d;
    private float d0;

    /* renamed from: e  reason: collision with root package name */
    private float f4360e;
    private CharSequence e0;

    /* renamed from: f  reason: collision with root package name */
    private float f4361f;

    /* renamed from: g  reason: collision with root package name */
    private int f4362g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final Rect f4363h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final Rect f4364i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final RectF f4365j;
    private ColorStateList o;
    private ColorStateList p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private Typeface w;
    private Typeface x;
    private Typeface y;
    private com.google.android.material.f.a z;

    /* renamed from: k  reason: collision with root package name */
    private int f4366k = 16;

    /* renamed from: l  reason: collision with root package name */
    private int f4367l = 16;
    private float m = 15.0f;
    private float n = 15.0f;
    private boolean E = true;
    private int f0 = 1;
    private float g0 = 0.0f;
    private float h0 = 1.0f;
    private int i0 = StaticLayoutBuilderCompat.n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CollapsingTextHelper.java */
    /* renamed from: com.google.android.material.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0175a implements a.InterfaceC0171a {
        C0175a() {
        }

        @Override // com.google.android.material.f.a.InterfaceC0171a
        public void a(Typeface typeface) {
            a.this.W(typeface);
        }
    }

    /* compiled from: CollapsingTextHelper.java */
    /* loaded from: classes2.dex */
    class b implements a.InterfaceC0171a {
        b() {
        }

        @Override // com.google.android.material.f.a.InterfaceC0171a
        public void a(Typeface typeface) {
            a.this.g0(typeface);
        }
    }

    static {
        j0 = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        k0 = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            paint.setColor(-65281);
        }
    }

    public a(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.M = textPaint;
        this.N = new TextPaint(textPaint);
        this.f4364i = new Rect();
        this.f4363h = new Rect();
        this.f4365j = new RectF();
        this.f4361f = f();
    }

    private void E(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.n);
        textPaint.setTypeface(this.w);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Y);
        }
    }

    private void F(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.m);
        textPaint.setTypeface(this.x);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Z);
        }
    }

    private void G(float f2) {
        if (this.f4359d) {
            this.f4365j.set(f2 < this.f4361f ? this.f4363h : this.f4364i);
            return;
        }
        this.f4365j.left = L(this.f4363h.left, this.f4364i.left, f2, this.O);
        this.f4365j.top = L(this.q, this.r, f2, this.O);
        this.f4365j.right = L(this.f4363h.right, this.f4364i.right, f2, this.O);
        this.f4365j.bottom = L(this.f4363h.bottom, this.f4364i.bottom, f2, this.O);
    }

    private static boolean H(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private boolean I() {
        return ViewCompat.getLayoutDirection(this.a) == 1;
    }

    private boolean K(@NonNull CharSequence charSequence, boolean z) {
        return (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private static float L(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return com.google.android.material.animation.a.a(f2, f3, f4);
    }

    private static boolean P(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void T(float f2) {
        this.b0 = f2;
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private boolean X(Typeface typeface) {
        com.google.android.material.f.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        if (this.w != typeface) {
            this.w = typeface;
            return true;
        }
        return false;
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    private void b(boolean z) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        float f2 = this.J;
        j(this.n, z);
        CharSequence charSequence = this.C;
        if (charSequence != null && (staticLayout2 = this.a0) != null) {
            this.e0 = TextUtils.ellipsize(charSequence, this.M, staticLayout2.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.e0;
        float f3 = 0.0f;
        float measureText = charSequence2 != null ? this.M.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f4367l, this.D ? 1 : 0);
        int i2 = absoluteGravity & 112;
        if (i2 == 48) {
            this.r = this.f4364i.top;
        } else if (i2 != 80) {
            this.r = this.f4364i.centerY() - ((this.M.descent() - this.M.ascent()) / 2.0f);
        } else {
            this.r = this.f4364i.bottom + this.M.ascent();
        }
        int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i3 == 1) {
            this.t = this.f4364i.centerX() - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.t = this.f4364i.left;
        } else {
            this.t = this.f4364i.right - measureText;
        }
        j(this.m, z);
        float height = this.a0 != null ? staticLayout.getHeight() : 0.0f;
        CharSequence charSequence3 = this.C;
        float measureText2 = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.a0;
        if (staticLayout3 != null && this.f0 > 1) {
            measureText2 = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.a0;
        if (staticLayout4 != null) {
            f3 = this.f0 > 1 ? staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0);
        }
        this.d0 = f3;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f4366k, this.D ? 1 : 0);
        int i4 = absoluteGravity2 & 112;
        if (i4 == 48) {
            this.q = this.f4363h.top;
        } else if (i4 != 80) {
            this.q = this.f4363h.centerY() - (height / 2.0f);
        } else {
            this.q = (this.f4363h.bottom - height) + this.M.descent();
        }
        int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i5 == 1) {
            this.s = this.f4363h.centerX() - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.s = this.f4363h.left;
        } else {
            this.s = this.f4363h.right - measureText2;
        }
        k();
        m0(f2);
    }

    private void c0(float f2) {
        this.c0 = f2;
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private void d() {
        h(this.c);
    }

    private float e(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        float f3 = this.f4361f;
        if (f2 <= f3) {
            return com.google.android.material.animation.a.b(1.0f, 0.0f, this.f4360e, f3, f2);
        }
        return com.google.android.material.animation.a.b(0.0f, 1.0f, f3, 1.0f, f2);
    }

    private float f() {
        float f2 = this.f4360e;
        return f2 + ((1.0f - f2) * 0.5f);
    }

    private boolean g(@NonNull CharSequence charSequence) {
        boolean I = I();
        return this.E ? K(charSequence, I) : I;
    }

    private void h(float f2) {
        float f3;
        G(f2);
        if (this.f4359d) {
            if (f2 < this.f4361f) {
                this.u = this.s;
                this.v = this.q;
                m0(this.m);
                f3 = 0.0f;
            } else {
                this.u = this.t;
                this.v = this.r - Math.max(0, this.f4362g);
                m0(this.n);
                f3 = 1.0f;
            }
        } else {
            this.u = L(this.s, this.t, f2, this.O);
            this.v = L(this.q, this.r, f2, this.O);
            m0(L(this.m, this.n, f2, this.P));
            f3 = f2;
        }
        TimeInterpolator timeInterpolator = com.google.android.material.animation.a.b;
        T(1.0f - L(0.0f, 1.0f, 1.0f - f2, timeInterpolator));
        c0(L(1.0f, 0.0f, f2, timeInterpolator));
        if (this.p != this.o) {
            this.M.setColor(a(w(), u(), f3));
        } else {
            this.M.setColor(u());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f4 = this.Y;
            float f5 = this.Z;
            if (f4 != f5) {
                this.M.setLetterSpacing(L(f5, f4, f2, timeInterpolator));
            } else {
                this.M.setLetterSpacing(f4);
            }
        }
        this.M.setShadowLayer(L(this.U, this.Q, f2, null), L(this.V, this.R, f2, null), L(this.W, this.S, f2, null), a(v(this.X), v(this.T), f2));
        if (this.f4359d) {
            this.M.setAlpha((int) (e(f2) * 255.0f));
        }
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private boolean h0(Typeface typeface) {
        com.google.android.material.f.a aVar = this.z;
        if (aVar != null) {
            aVar.c();
        }
        if (this.x != typeface) {
            this.x = typeface;
            return true;
        }
        return false;
    }

    private void i(float f2) {
        j(f2, false);
    }

    private void j(float f2, boolean z) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.B == null) {
            return;
        }
        float width = this.f4364i.width();
        float width2 = this.f4363h.width();
        if (H(f2, this.n)) {
            f3 = this.n;
            this.I = 1.0f;
            Typeface typeface = this.y;
            Typeface typeface2 = this.w;
            if (typeface != typeface2) {
                this.y = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f4 = this.m;
            Typeface typeface3 = this.y;
            Typeface typeface4 = this.x;
            if (typeface3 != typeface4) {
                this.y = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (H(f2, f4)) {
                this.I = 1.0f;
            } else {
                this.I = f2 / this.m;
            }
            float f5 = this.n / this.m;
            width = (!z && width2 * f5 > width) ? Math.min(width / f5, width2) : width2;
            f3 = f4;
            z3 = z2;
        }
        if (width > 0.0f) {
            z3 = this.J != f3 || this.L || z3;
            this.J = f3;
            this.L = false;
        }
        if (this.C == null || z3) {
            this.M.setTextSize(this.J);
            this.M.setTypeface(this.y);
            this.M.setLinearText(this.I != 1.0f);
            this.D = g(this.B);
            StaticLayout l2 = l(w0() ? this.f0 : 1, width, this.D);
            this.a0 = l2;
            this.C = l2.getText();
        }
    }

    private void k() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private StaticLayout l(int i2, float f2, boolean z) {
        StaticLayout staticLayout;
        try {
            StaticLayoutBuilderCompat c = StaticLayoutBuilderCompat.c(this.B, this.M, (int) f2);
            c.e(TextUtils.TruncateAt.END);
            c.h(z);
            c.d(Layout.Alignment.ALIGN_NORMAL);
            c.g(false);
            c.j(i2);
            c.i(this.g0, this.h0);
            c.f(this.i0);
            staticLayout = c.a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
            Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void m0(float f2) {
        i(f2);
        boolean z = j0 && this.I != 1.0f;
        this.F = z;
        if (z) {
            o();
        }
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private void n(@NonNull Canvas canvas, float f2, float f3) {
        int alpha = this.M.getAlpha();
        canvas.translate(f2, f3);
        float f4 = alpha;
        this.M.setAlpha((int) (this.c0 * f4));
        this.a0.draw(canvas);
        this.M.setAlpha((int) (this.b0 * f4));
        int lineBaseline = this.a0.getLineBaseline(0);
        CharSequence charSequence = this.e0;
        float f5 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.M);
        if (this.f4359d) {
            return;
        }
        String trim = this.e0.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.M.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.a0.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.M);
    }

    private void o() {
        if (this.G != null || this.f4363h.isEmpty() || TextUtils.isEmpty(this.C)) {
            return;
        }
        h(0.0f);
        int width = this.a0.getWidth();
        int height = this.a0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.a0.draw(new Canvas(this.G));
        if (this.H == null) {
            this.H = new Paint(3);
        }
    }

    private float s(int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) - (c() / 2.0f);
        }
        return ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) ? this.D ? this.f4364i.left : this.f4364i.right - c() : this.D ? this.f4364i.right - c() : this.f4364i.left;
    }

    private float t(@NonNull RectF rectF, int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) + (c() / 2.0f);
        }
        return ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) ? this.D ? rectF.left + c() : this.f4364i.right : this.D ? this.f4364i.right : rectF.left + c();
    }

    @ColorInt
    private int v(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    @ColorInt
    private int w() {
        return v(this.o);
    }

    private boolean w0() {
        return this.f0 > 1 && (!this.D || this.f4359d) && !this.F;
    }

    public float A() {
        return this.f4361f;
    }

    public int B() {
        StaticLayout staticLayout = this.a0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public int C() {
        return this.f0;
    }

    @Nullable
    public CharSequence D() {
        return this.B;
    }

    public final boolean J() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.o) != null && colorStateList.isStateful());
    }

    void M() {
        this.b = this.f4364i.width() > 0 && this.f4364i.height() > 0 && this.f4363h.width() > 0 && this.f4363h.height() > 0;
    }

    public void N() {
        O(false);
    }

    public void O(boolean z) {
        if ((this.a.getHeight() <= 0 || this.a.getWidth() <= 0) && !z) {
            return;
        }
        b(z);
        d();
    }

    public void Q(int i2, int i3, int i4, int i5) {
        if (P(this.f4364i, i2, i3, i4, i5)) {
            return;
        }
        this.f4364i.set(i2, i3, i4, i5);
        this.L = true;
        M();
    }

    public void R(@NonNull Rect rect) {
        Q(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void S(int i2) {
        com.google.android.material.f.d dVar = new com.google.android.material.f.d(this.a.getContext(), i2);
        ColorStateList colorStateList = dVar.a;
        if (colorStateList != null) {
            this.p = colorStateList;
        }
        float f2 = dVar.f4262k;
        if (f2 != 0.0f) {
            this.n = f2;
        }
        ColorStateList colorStateList2 = dVar.b;
        if (colorStateList2 != null) {
            this.T = colorStateList2;
        }
        this.R = dVar.f4257f;
        this.S = dVar.f4258g;
        this.Q = dVar.f4259h;
        this.Y = dVar.f4261j;
        com.google.android.material.f.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        this.A = new com.google.android.material.f.a(new C0175a(), dVar.e());
        dVar.h(this.a.getContext(), this.A);
        N();
    }

    public void U(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            N();
        }
    }

    public void V(int i2) {
        if (this.f4367l != i2) {
            this.f4367l = i2;
            N();
        }
    }

    public void W(Typeface typeface) {
        if (X(typeface)) {
            N();
        }
    }

    public void Y(int i2) {
        this.f4362g = i2;
    }

    public void Z(int i2, int i3, int i4, int i5) {
        if (P(this.f4363h, i2, i3, i4, i5)) {
            return;
        }
        this.f4363h.set(i2, i3, i4, i5);
        this.L = true;
        M();
    }

    public void a0(@NonNull Rect rect) {
        Z(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void b0(int i2) {
        com.google.android.material.f.d dVar = new com.google.android.material.f.d(this.a.getContext(), i2);
        ColorStateList colorStateList = dVar.a;
        if (colorStateList != null) {
            this.o = colorStateList;
        }
        float f2 = dVar.f4262k;
        if (f2 != 0.0f) {
            this.m = f2;
        }
        ColorStateList colorStateList2 = dVar.b;
        if (colorStateList2 != null) {
            this.X = colorStateList2;
        }
        this.V = dVar.f4257f;
        this.W = dVar.f4258g;
        this.U = dVar.f4259h;
        this.Z = dVar.f4261j;
        com.google.android.material.f.a aVar = this.z;
        if (aVar != null) {
            aVar.c();
        }
        this.z = new com.google.android.material.f.a(new b(), dVar.e());
        dVar.h(this.a.getContext(), this.z);
        N();
    }

    public float c() {
        if (this.B == null) {
            return 0.0f;
        }
        E(this.N);
        TextPaint textPaint = this.N;
        CharSequence charSequence = this.B;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void d0(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            N();
        }
    }

    public void e0(int i2) {
        if (this.f4366k != i2) {
            this.f4366k = i2;
            N();
        }
    }

    public void f0(float f2) {
        if (this.m != f2) {
            this.m = f2;
            N();
        }
    }

    public void g0(Typeface typeface) {
        if (h0(typeface)) {
            N();
        }
    }

    public void i0(float f2) {
        float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (clamp != this.c) {
            this.c = clamp;
            d();
        }
    }

    public void j0(boolean z) {
        this.f4359d = z;
    }

    public void k0(float f2) {
        this.f4360e = f2;
        this.f4361f = f();
    }

    @RequiresApi(23)
    public void l0(int i2) {
        this.i0 = i2;
    }

    public void m(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.C == null || !this.b) {
            return;
        }
        boolean z = true;
        float lineStart = (this.u + (this.f0 > 1 ? this.a0.getLineStart(0) : this.a0.getLineLeft(0))) - (this.d0 * 2.0f);
        this.M.setTextSize(this.J);
        float f2 = this.u;
        float f3 = this.v;
        z = (!this.F || this.G == null) ? false : false;
        float f4 = this.I;
        if (f4 != 1.0f && !this.f4359d) {
            canvas.scale(f4, f4, f2, f3);
        }
        if (z) {
            canvas.drawBitmap(this.G, f2, f3, this.H);
            canvas.restoreToCount(save);
            return;
        }
        if (w0() && (!this.f4359d || this.c > this.f4361f)) {
            n(canvas, lineStart, f3);
        } else {
            canvas.translate(f2, f3);
            this.a0.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    @RequiresApi(23)
    public void n0(float f2) {
        this.g0 = f2;
    }

    @RequiresApi(23)
    public void o0(@FloatRange(from = 0.0d) float f2) {
        this.h0 = f2;
    }

    public void p(@NonNull RectF rectF, int i2, int i3) {
        this.D = g(this.B);
        rectF.left = s(i2, i3);
        rectF.top = this.f4364i.top;
        rectF.right = t(rectF, i2, i3);
        rectF.bottom = this.f4364i.top + r();
    }

    public void p0(int i2) {
        if (i2 != this.f0) {
            this.f0 = i2;
            k();
            N();
        }
    }

    public ColorStateList q() {
        return this.p;
    }

    public void q0(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        N();
    }

    public float r() {
        E(this.N);
        return -this.N.ascent();
    }

    public void r0(boolean z) {
        this.E = z;
    }

    public final boolean s0(int[] iArr) {
        this.K = iArr;
        if (J()) {
            N();
            return true;
        }
        return false;
    }

    public void t0(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.B, charSequence)) {
            this.B = charSequence;
            this.C = null;
            k();
            N();
        }
    }

    @ColorInt
    public int u() {
        return v(this.p);
    }

    public void u0(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        N();
    }

    public void v0(Typeface typeface) {
        boolean X = X(typeface);
        boolean h0 = h0(typeface);
        if (X || h0) {
            N();
        }
    }

    public float x() {
        F(this.N);
        return (-this.N.ascent()) + this.N.descent();
    }

    public float y() {
        F(this.N);
        return -this.N.ascent();
    }

    public float z() {
        return this.c;
    }
}
