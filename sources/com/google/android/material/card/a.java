package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.f.c;
import com.google.android.material.g.b;
import com.google.android.material.shape.d;
import com.google.android.material.shape.e;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialCardViewHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    private static final int[] t = {16842912};
    private static final double u = Math.cos(Math.toRadians(45.0d));
    @NonNull
    private final MaterialCardView a;
    @NonNull
    private final h c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final h f4165d;
    @Dimension

    /* renamed from: e  reason: collision with root package name */
    private int f4166e;
    @Dimension

    /* renamed from: f  reason: collision with root package name */
    private int f4167f;
    @Dimension

    /* renamed from: g  reason: collision with root package name */
    private int f4168g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Drawable f4169h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Drawable f4170i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f4171j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f4172k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private m f4173l;
    @Nullable
    private ColorStateList m;
    @Nullable
    private Drawable n;
    @Nullable
    private LayerDrawable o;
    @Nullable
    private h p;
    @Nullable
    private h q;
    private boolean s;
    @NonNull
    private final Rect b = new Rect();
    private boolean r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCardViewHelper.java */
    /* renamed from: com.google.android.material.card.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0167a extends InsetDrawable {
        C0167a(a aVar, Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i2, @StyleRes int i3) {
        this.a = materialCardView;
        h hVar = new h(materialCardView.getContext(), attributeSet, i2, i3);
        this.c = hVar;
        hVar.L(materialCardView.getContext());
        hVar.c0(-12303292);
        m.b v = hVar.C().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        int i4 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            v.o(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.f4165d = new h();
        G(v.m());
        obtainStyledAttributes.recycle();
    }

    private boolean K() {
        return this.a.getPreventCornerOverlap() && !e();
    }

    private boolean L() {
        return this.a.getPreventCornerOverlap() && e() && this.a.getUseCompatPadding();
    }

    private void P(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.a.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.a.getForeground()).setDrawable(drawable);
        } else {
            this.a.setForeground(q(drawable));
        }
    }

    private void R() {
        Drawable drawable;
        if (b.a && (drawable = this.n) != null) {
            ((RippleDrawable) drawable).setColor(this.f4171j);
            return;
        }
        h hVar = this.p;
        if (hVar != null) {
            hVar.W(this.f4171j);
        }
    }

    private float a() {
        return Math.max(Math.max(b(this.f4173l.q(), this.c.E()), b(this.f4173l.s(), this.c.F())), Math.max(b(this.f4173l.k(), this.c.t()), b(this.f4173l.i(), this.c.s())));
    }

    private float b(d dVar, float f2) {
        if (dVar instanceof l) {
            return (float) ((1.0d - u) * f2);
        }
        if (dVar instanceof e) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        return this.a.getMaxCardElevation() + (L() ? a() : 0.0f);
    }

    private float d() {
        return (this.a.getMaxCardElevation() * 1.5f) + (L() ? a() : 0.0f);
    }

    private boolean e() {
        return Build.VERSION.SDK_INT >= 21 && this.c.O();
    }

    @NonNull
    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f4170i;
        if (drawable != null) {
            stateListDrawable.addState(t, drawable);
        }
        return stateListDrawable;
    }

    @NonNull
    private Drawable g() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        h i2 = i();
        this.p = i2;
        i2.W(this.f4171j);
        stateListDrawable.addState(new int[]{16842919}, this.p);
        return stateListDrawable;
    }

    @NonNull
    private Drawable h() {
        if (b.a) {
            this.q = i();
            return new RippleDrawable(this.f4171j, null, this.q);
        }
        return g();
    }

    @NonNull
    private h i() {
        return new h(this.f4173l);
    }

    @NonNull
    private Drawable m() {
        if (this.n == null) {
            this.n = h();
        }
        if (this.o == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.f4165d, f()});
            this.o = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    private float o() {
        if (this.a.getPreventCornerOverlap()) {
            if (Build.VERSION.SDK_INT < 21 || this.a.getUseCompatPadding()) {
                return (float) ((1.0d - u) * this.a.j());
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @NonNull
    private Drawable q(Drawable drawable) {
        int ceil;
        int i2;
        if ((Build.VERSION.SDK_INT < 21) || this.a.getUseCompatPadding()) {
            int ceil2 = (int) Math.ceil(d());
            ceil = (int) Math.ceil(c());
            i2 = ceil2;
        } else {
            ceil = 0;
            i2 = 0;
        }
        return new C0167a(this, drawable, ceil, i2, ceil, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(@Dimension int i2) {
        this.f4166e = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(@Dimension int i2) {
        this.f4167f = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(@Nullable ColorStateList colorStateList) {
        this.f4172k = colorStateList;
        Drawable drawable = this.f4170i;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(float f2) {
        G(this.f4173l.w(f2));
        this.f4169h.invalidateSelf();
        if (L() || K()) {
            N();
        }
        if (L()) {
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.c.X(f2);
        h hVar = this.f4165d;
        if (hVar != null) {
            hVar.X(f2);
        }
        h hVar2 = this.q;
        if (hVar2 != null) {
            hVar2.X(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(@Nullable ColorStateList colorStateList) {
        this.f4171j = colorStateList;
        R();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(@NonNull m mVar) {
        this.f4173l = mVar;
        this.c.setShapeAppearanceModel(mVar);
        h hVar = this.c;
        hVar.b0(!hVar.O());
        h hVar2 = this.f4165d;
        if (hVar2 != null) {
            hVar2.setShapeAppearanceModel(mVar);
        }
        h hVar3 = this.q;
        if (hVar3 != null) {
            hVar3.setShapeAppearanceModel(mVar);
        }
        h hVar4 = this.p;
        if (hVar4 != null) {
            hVar4.setShapeAppearanceModel(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ColorStateList colorStateList) {
        if (this.m == colorStateList) {
            return;
        }
        this.m = colorStateList;
        S();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(@Dimension int i2) {
        if (i2 == this.f4168g) {
            return;
        }
        this.f4168g = i2;
        S();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i2, int i3, int i4, int i5) {
        this.b.set(i2, i3, i4, i5);
        N();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        Drawable drawable = this.f4169h;
        Drawable m = this.a.isClickable() ? m() : this.f4165d;
        this.f4169h = m;
        if (drawable != m) {
            P(m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        int a = (int) ((K() || L() ? a() : 0.0f) - o());
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.m(rect.left + a, rect.top + a, rect.right + a, rect.bottom + a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        this.c.V(this.a.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        if (!r()) {
            this.a.n(q(this.c));
        }
        this.a.setForeground(q(this.f4169h));
    }

    void S() {
        this.f4165d.g0(this.f4168g, this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(api = 23)
    public void j() {
        Drawable drawable = this.n;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public h k() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.c.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.c.E();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Rect p() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(@NonNull TypedArray typedArray) {
        ColorStateList a = c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.m = a;
        if (a == null) {
            this.m = ColorStateList.valueOf(-1);
        }
        this.f4168g = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.s = z;
        this.a.setLongClickable(z);
        this.f4172k = c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        z(c.d(this.a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        B(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        A(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList a2 = c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.f4171j = a2;
        if (a2 == null) {
            this.f4171j = ColorStateList.valueOf(com.google.android.material.b.a.d(this.a, R.attr.colorControlHighlight));
        }
        x(c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        R();
        O();
        S();
        this.a.n(q(this.c));
        Drawable m = this.a.isClickable() ? m() : this.f4165d;
        this.f4169h = m;
        this.a.setForeground(q(m));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i2, int i3) {
        int i4;
        int i5;
        if (this.o != null) {
            int i6 = this.f4166e;
            int i7 = this.f4167f;
            int i8 = (i2 - i6) - i7;
            int i9 = (i3 - i6) - i7;
            if ((Build.VERSION.SDK_INT < 21) || this.a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil(d() * 2.0f);
                i8 -= (int) Math.ceil(c() * 2.0f);
            }
            int i10 = i9;
            int i11 = this.f4166e;
            if (ViewCompat.getLayoutDirection(this.a) == 1) {
                i5 = i8;
                i4 = i11;
            } else {
                i4 = i8;
                i5 = i11;
            }
            this.o.setLayerInset(2, i4, this.f4166e, i5, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(boolean z) {
        this.r = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        this.c.W(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(@Nullable ColorStateList colorStateList) {
        h hVar = this.f4165d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        hVar.W(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(boolean z) {
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(@Nullable Drawable drawable) {
        this.f4170i = drawable;
        if (drawable != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.f4170i = wrap;
            DrawableCompat.setTintList(wrap, this.f4172k);
        }
        if (this.o != null) {
            this.o.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, f());
        }
    }
}
