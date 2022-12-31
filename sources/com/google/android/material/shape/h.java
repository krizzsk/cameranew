package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.m;
import com.google.android.material.shape.n;
import java.util.BitSet;
/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes2.dex */
public class h extends Drawable implements TintAwareDrawable, o {
    private static final String w = h.class.getSimpleName();
    private static final Paint x = new Paint(1);
    private c a;
    private final n.g[] b;
    private final n.g[] c;

    /* renamed from: d  reason: collision with root package name */
    private final BitSet f4485d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4486e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f4487f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f4488g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f4489h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f4490i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f4491j;

    /* renamed from: k  reason: collision with root package name */
    private final Region f4492k;

    /* renamed from: l  reason: collision with root package name */
    private final Region f4493l;
    private m m;
    private final Paint n;
    private final Paint o;
    private final com.google.android.material.h.a p;
    @NonNull
    private final ShapeAppearancePathProvider.b q;
    private final ShapeAppearancePathProvider r;
    @Nullable
    private PorterDuffColorFilter s;
    @Nullable
    private PorterDuffColorFilter t;
    @NonNull
    private final RectF u;
    private boolean v;

    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes2.dex */
    class a implements ShapeAppearancePathProvider.b {
        a() {
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.b
        public void a(@NonNull n nVar, Matrix matrix, int i2) {
            h.this.f4485d.set(i2, nVar.e());
            h.this.b[i2] = nVar.f(matrix);
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.b
        public void b(@NonNull n nVar, Matrix matrix, int i2) {
            h.this.f4485d.set(i2 + 4, nVar.e());
            h.this.c[i2] = nVar.f(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes2.dex */
    public class b implements m.c {
        final /* synthetic */ float a;

        b(h hVar, float f2) {
            this.a = f2;
        }

        @Override // com.google.android.material.shape.m.c
        @NonNull
        public com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c cVar) {
            return cVar instanceof k ? cVar : new com.google.android.material.shape.b(this.a, cVar);
        }
    }

    /* synthetic */ h(c cVar, a aVar) {
        this(cVar);
    }

    private float D() {
        if (K()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean I() {
        c cVar = this.a;
        int i2 = cVar.q;
        return i2 != 1 && cVar.r > 0 && (i2 == 2 || S());
    }

    private boolean J() {
        Paint.Style style = this.a.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean K() {
        Paint.Style style = this.a.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    private void M() {
        super.invalidateSelf();
    }

    private void P(@NonNull Canvas canvas) {
        if (I()) {
            canvas.save();
            R(canvas);
            if (!this.v) {
                n(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.u.width() - getBounds().width());
            int height = (int) (this.u.height() - getBounds().height());
            if (width >= 0 && height >= 0) {
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.u.width()) + (this.a.r * 2) + width, ((int) this.u.height()) + (this.a.r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f2 = (getBounds().left - this.a.r) - width;
                float f3 = (getBounds().top - this.a.r) - height;
                canvas2.translate(-f2, -f3);
                n(canvas2);
                canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
                createBitmap.recycle();
                canvas.restore();
                return;
            }
            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        }
    }

    private static int Q(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void R(@NonNull Canvas canvas) {
        int z = z();
        int A = A();
        if (Build.VERSION.SDK_INT < 21 && this.v) {
            Rect clipBounds = canvas.getClipBounds();
            int i2 = this.a.r;
            clipBounds.inset(-i2, -i2);
            clipBounds.offset(z, A);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(z, A);
    }

    @Nullable
    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z) {
        int color;
        int l2;
        if (!z || (l2 = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(l2, PorterDuff.Mode.SRC_IN);
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.a.f4500j != 1.0f) {
            this.f4487f.reset();
            Matrix matrix = this.f4487f;
            float f2 = this.a.f4500j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f4487f);
        }
        path.computeBounds(this.u, true);
    }

    private void i() {
        m y = C().y(new b(this, -D()));
        this.m = y;
        this.r.d(y, this.a.f4501k, v(), this.f4489h);
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private boolean j0(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.a.f4494d == null || color2 == (colorForState2 = this.a.f4494d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.a.f4495e == null || color == (colorForState = this.a.f4495e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }

    @NonNull
    private PorterDuffColorFilter k(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z) {
        if (colorStateList != null && mode != null) {
            return j(colorStateList, mode, z);
        }
        return f(paint, z);
    }

    private boolean k0() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        c cVar = this.a;
        this.s = k(cVar.f4497g, cVar.f4498h, this.n, true);
        c cVar2 = this.a;
        this.t = k(cVar2.f4496f, cVar2.f4498h, this.o, false);
        c cVar3 = this.a;
        if (cVar3.u) {
            this.p.d(cVar3.f4497g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.s) && ObjectsCompat.equals(porterDuffColorFilter2, this.t)) ? false : true;
    }

    private void l0() {
        float H = H();
        this.a.r = (int) Math.ceil(0.75f * H);
        this.a.s = (int) Math.ceil(H * 0.25f);
        k0();
        M();
    }

    @NonNull
    public static h m(Context context, float f2) {
        int c2 = com.google.android.material.b.a.c(context, R.attr.colorSurface, h.class.getSimpleName());
        h hVar = new h();
        hVar.L(context);
        hVar.W(ColorStateList.valueOf(c2));
        hVar.V(f2);
        return hVar;
    }

    private void n(@NonNull Canvas canvas) {
        if (this.f4485d.cardinality() > 0) {
            Log.w(w, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.a.s != 0) {
            canvas.drawPath(this.f4488g, this.p.c());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.b[i2].b(this.p, this.a.r, canvas);
            this.c[i2].b(this.p, this.a.r, canvas);
        }
        if (this.v) {
            int z = z();
            int A = A();
            canvas.translate(-z, -A);
            canvas.drawPath(this.f4488g, x);
            canvas.translate(z, A);
        }
    }

    private void o(@NonNull Canvas canvas) {
        q(canvas, this.n, this.f4488g, this.a.a, u());
    }

    private void q(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull m mVar, @NonNull RectF rectF) {
        if (mVar.u(rectF)) {
            float a2 = mVar.t().a(rectF) * this.a.f4501k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void r(@NonNull Canvas canvas) {
        q(canvas, this.o, this.f4489h, this.m, v());
    }

    @NonNull
    private RectF v() {
        this.f4491j.set(u());
        float D = D();
        this.f4491j.inset(D, D);
        return this.f4491j;
    }

    public int A() {
        c cVar = this.a;
        return (int) (cVar.s * Math.cos(Math.toRadians(cVar.t)));
    }

    public int B() {
        return this.a.r;
    }

    @NonNull
    public m C() {
        return this.a.a;
    }

    public float E() {
        return this.a.a.r().a(u());
    }

    public float F() {
        return this.a.a.t().a(u());
    }

    public float G() {
        return this.a.p;
    }

    public float H() {
        return w() + G();
    }

    public void L(Context context) {
        this.a.b = new ElevationOverlayProvider(context);
        l0();
    }

    public boolean N() {
        ElevationOverlayProvider elevationOverlayProvider = this.a.b;
        return elevationOverlayProvider != null && elevationOverlayProvider.e();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean O() {
        return this.a.a.u(u());
    }

    public boolean S() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 21 || !(O() || this.f4488g.isConvex() || i2 >= 29);
    }

    public void T(float f2) {
        setShapeAppearanceModel(this.a.a.w(f2));
    }

    public void U(@NonNull com.google.android.material.shape.c cVar) {
        setShapeAppearanceModel(this.a.a.x(cVar));
    }

    public void V(float f2) {
        c cVar = this.a;
        if (cVar.o != f2) {
            cVar.o = f2;
            l0();
        }
    }

    public void W(@Nullable ColorStateList colorStateList) {
        c cVar = this.a;
        if (cVar.f4494d != colorStateList) {
            cVar.f4494d = colorStateList;
            onStateChange(getState());
        }
    }

    public void X(float f2) {
        c cVar = this.a;
        if (cVar.f4501k != f2) {
            cVar.f4501k = f2;
            this.f4486e = true;
            invalidateSelf();
        }
    }

    public void Y(int i2, int i3, int i4, int i5) {
        c cVar = this.a;
        if (cVar.f4499i == null) {
            cVar.f4499i = new Rect();
        }
        this.a.f4499i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    public void Z(Paint.Style style) {
        this.a.v = style;
        M();
    }

    public void a0(float f2) {
        c cVar = this.a;
        if (cVar.n != f2) {
            cVar.n = f2;
            l0();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void b0(boolean z) {
        this.v = z;
    }

    public void c0(int i2) {
        this.p.d(i2);
        this.a.u = false;
        M();
    }

    public void d0(int i2) {
        c cVar = this.a;
        if (cVar.t != i2) {
            cVar.t = i2;
            M();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.n.setColorFilter(this.s);
        int alpha = this.n.getAlpha();
        this.n.setAlpha(Q(alpha, this.a.m));
        this.o.setColorFilter(this.t);
        this.o.setStrokeWidth(this.a.f4502l);
        int alpha2 = this.o.getAlpha();
        this.o.setAlpha(Q(alpha2, this.a.m));
        if (this.f4486e) {
            i();
            g(u(), this.f4488g);
            this.f4486e = false;
        }
        P(canvas);
        if (J()) {
            o(canvas);
        }
        if (K()) {
            r(canvas);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    public void e0(int i2) {
        c cVar = this.a;
        if (cVar.q != i2) {
            cVar.q = i2;
            M();
        }
    }

    public void f0(float f2, @ColorInt int i2) {
        i0(f2);
        h0(ColorStateList.valueOf(i2));
    }

    public void g0(float f2, @Nullable ColorStateList colorStateList) {
        i0(f2);
        h0(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.a.q == 2) {
            return;
        }
        if (O()) {
            outline.setRoundRect(getBounds(), E() * this.a.f4501k);
            return;
        }
        g(u(), this.f4488g);
        if (this.f4488g.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f4488g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.a.f4499i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f4492k.set(getBounds());
        g(u(), this.f4488g);
        this.f4493l.setPath(this.f4488g, this.f4492k);
        this.f4492k.op(this.f4493l, Region.Op.DIFFERENCE);
        return this.f4492k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void h(@NonNull RectF rectF, @NonNull Path path) {
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.r;
        c cVar = this.a;
        shapeAppearancePathProvider.e(cVar.a, cVar.f4501k, rectF, this.q, path);
    }

    public void h0(@Nullable ColorStateList colorStateList) {
        c cVar = this.a;
        if (cVar.f4495e != colorStateList) {
            cVar.f4495e = colorStateList;
            onStateChange(getState());
        }
    }

    public void i0(float f2) {
        this.a.f4502l = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f4486e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.a.f4497g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.a.f4496f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.a.f4495e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.a.f4494d) != null && colorStateList4.isStateful())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int l(@ColorInt int i2) {
        float H = H() + y();
        ElevationOverlayProvider elevationOverlayProvider = this.a.b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.c(i2, H) : i2;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.a = new c(this.a);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f4486e = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        boolean z = j0(iArr) || k0();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void p(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        q(canvas, paint, path, this.a.a, rectF);
    }

    public float s() {
        return this.a.a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        c cVar = this.a;
        if (cVar.m != i2) {
            cVar.m = i2;
            M();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.a.c = colorFilter;
        M();
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull m mVar) {
        this.a.a = mVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.a.f4497g = colorStateList;
        k0();
        M();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        c cVar = this.a;
        if (cVar.f4498h != mode) {
            cVar.f4498h = mode;
            k0();
            M();
        }
    }

    public float t() {
        return this.a.a.l().a(u());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public RectF u() {
        this.f4490i.set(getBounds());
        return this.f4490i;
    }

    public float w() {
        return this.a.o;
    }

    @Nullable
    public ColorStateList x() {
        return this.a.f4494d;
    }

    public float y() {
        return this.a.n;
    }

    public int z() {
        c cVar = this.a;
        return (int) (cVar.s * Math.sin(Math.toRadians(cVar.t)));
    }

    public h() {
        this(new m());
    }

    public h(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this(m.e(context, attributeSet, i2, i3).m());
    }

    public h(@NonNull m mVar) {
        this(new c(mVar, null));
    }

    private h(@NonNull c cVar) {
        this.b = new n.g[4];
        this.c = new n.g[4];
        this.f4485d = new BitSet(8);
        this.f4487f = new Matrix();
        this.f4488g = new Path();
        this.f4489h = new Path();
        this.f4490i = new RectF();
        this.f4491j = new RectF();
        this.f4492k = new Region();
        this.f4493l = new Region();
        Paint paint = new Paint(1);
        this.n = paint;
        Paint paint2 = new Paint(1);
        this.o = paint2;
        this.p = new com.google.android.material.h.a();
        this.r = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.getInstance() : new ShapeAppearancePathProvider();
        this.u = new RectF();
        this.v = true;
        this.a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = x;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        k0();
        j0(getState());
        this.q = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes2.dex */
    public static final class c extends Drawable.ConstantState {
        @NonNull
        public m a;
        @Nullable
        public ElevationOverlayProvider b;
        @Nullable
        public ColorFilter c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f4494d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f4495e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f4496f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f4497g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f4498h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public Rect f4499i;

        /* renamed from: j  reason: collision with root package name */
        public float f4500j;

        /* renamed from: k  reason: collision with root package name */
        public float f4501k;

        /* renamed from: l  reason: collision with root package name */
        public float f4502l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(m mVar, ElevationOverlayProvider elevationOverlayProvider) {
            this.f4494d = null;
            this.f4495e = null;
            this.f4496f = null;
            this.f4497g = null;
            this.f4498h = PorterDuff.Mode.SRC_IN;
            this.f4499i = null;
            this.f4500j = 1.0f;
            this.f4501k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = mVar;
            this.b = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            h hVar = new h(this, null);
            hVar.f4486e = true;
            return hVar;
        }

        public c(@NonNull c cVar) {
            this.f4494d = null;
            this.f4495e = null;
            this.f4496f = null;
            this.f4497g = null;
            this.f4498h = PorterDuff.Mode.SRC_IN;
            this.f4499i = null;
            this.f4500j = 1.0f;
            this.f4501k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.b = cVar.b;
            this.f4502l = cVar.f4502l;
            this.c = cVar.c;
            this.f4494d = cVar.f4494d;
            this.f4495e = cVar.f4495e;
            this.f4498h = cVar.f4498h;
            this.f4497g = cVar.f4497g;
            this.m = cVar.m;
            this.f4500j = cVar.f4500j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.f4501k = cVar.f4501k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f4496f = cVar.f4496f;
            this.v = cVar.v;
            if (cVar.f4499i != null) {
                this.f4499i = new Rect(cVar.f4499i);
            }
        }
    }
}
