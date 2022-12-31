package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.f.c;
import com.google.android.material.g.b;
import com.google.android.material.internal.p;
import com.google.android.material.shape.h;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialButtonHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    private static final boolean t;
    private final MaterialButton a;
    @NonNull
    private m b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f4150d;

    /* renamed from: e  reason: collision with root package name */
    private int f4151e;

    /* renamed from: f  reason: collision with root package name */
    private int f4152f;

    /* renamed from: g  reason: collision with root package name */
    private int f4153g;

    /* renamed from: h  reason: collision with root package name */
    private int f4154h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f4155i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f4156j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f4157k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f4158l;
    @Nullable
    private Drawable m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;
    private int s;

    static {
        t = Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MaterialButton materialButton, @NonNull m mVar) {
        this.a = materialButton;
        this.b = mVar;
    }

    private void A() {
        this.a.q(a());
        h c = c();
        if (c != null) {
            c.V(this.s);
        }
    }

    private void B(@NonNull m mVar) {
        if (c() != null) {
            c().setShapeAppearanceModel(mVar);
        }
        if (i() != null) {
            i().setShapeAppearanceModel(mVar);
        }
        if (b() != null) {
            b().setShapeAppearanceModel(mVar);
        }
    }

    private void D() {
        h c = c();
        h i2 = i();
        if (c != null) {
            c.g0(this.f4154h, this.f4157k);
            if (i2 != null) {
                i2.f0(this.f4154h, this.n ? com.google.android.material.b.a.d(this.a, R.attr.colorSurface) : 0);
            }
        }
    }

    @NonNull
    private InsetDrawable E(Drawable drawable) {
        return new InsetDrawable(drawable, this.c, this.f4151e, this.f4150d, this.f4152f);
    }

    private Drawable a() {
        h hVar = new h(this.b);
        hVar.L(this.a.getContext());
        DrawableCompat.setTintList(hVar, this.f4156j);
        PorterDuff.Mode mode = this.f4155i;
        if (mode != null) {
            DrawableCompat.setTintMode(hVar, mode);
        }
        hVar.g0(this.f4154h, this.f4157k);
        h hVar2 = new h(this.b);
        hVar2.setTint(0);
        hVar2.f0(this.f4154h, this.n ? com.google.android.material.b.a.d(this.a, R.attr.colorSurface) : 0);
        if (t) {
            h hVar3 = new h(this.b);
            this.m = hVar3;
            DrawableCompat.setTint(hVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.f4158l), E(new LayerDrawable(new Drawable[]{hVar2, hVar})), this.m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        com.google.android.material.g.a aVar = new com.google.android.material.g.a(this.b);
        this.m = aVar;
        DrawableCompat.setTintList(aVar, b.d(this.f4158l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{hVar2, hVar, this.m});
        this.r = layerDrawable;
        return E(layerDrawable);
    }

    @Nullable
    private h d(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (t) {
            return (h) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
        }
        return (h) this.r.getDrawable(!z ? 1 : 0);
    }

    @Nullable
    private h i() {
        return d(true);
    }

    private void z(@Dimension int i2, @Dimension int i3) {
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i4 = this.f4151e;
        int i5 = this.f4152f;
        this.f4152f = i3;
        this.f4151e = i2;
        if (!this.o) {
            A();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i2, int i3) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(this.c, this.f4151e, i3 - this.f4150d, i2 - this.f4152f);
        }
    }

    @Nullable
    public o b() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.r.getNumberOfLayers() > 2) {
            return (o) this.r.getDrawable(2);
        }
        return (o) this.r.getDrawable(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public h c() {
        return d(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public m e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f4154h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList g() {
        return this.f4156j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode h() {
        return this.f4155i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull TypedArray typedArray) {
        this.c = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f4150d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f4151e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f4152f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i2 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i2)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            this.f4153g = dimensionPixelSize;
            t(this.b.w(dimensionPixelSize));
            this.p = true;
        }
        this.f4154h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f4155i = p.i(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f4156j = c.a(this.a.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f4157k = c.a(this.a.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f4158l = c.a(this.a.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.q = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.s = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            n();
        } else {
            A();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart + this.c, paddingTop + this.f4151e, paddingEnd + this.f4150d, paddingBottom + this.f4152f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i2) {
        if (c() != null) {
            c().setTint(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.o = true;
        this.a.setSupportBackgroundTintList(this.f4156j);
        this.a.setSupportBackgroundTintMode(this.f4155i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z) {
        this.q = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i2) {
        if (this.p && this.f4153g == i2) {
            return;
        }
        this.f4153g = i2;
        this.p = true;
        t(this.b.w(i2));
    }

    public void q(@Dimension int i2) {
        z(this.f4151e, i2);
    }

    public void r(@Dimension int i2) {
        z(i2, this.f4152f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(@Nullable ColorStateList colorStateList) {
        if (this.f4158l != colorStateList) {
            this.f4158l = colorStateList;
            boolean z = t;
            if (z && (this.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.a.getBackground()).setColor(b.d(colorStateList));
            } else if (z || !(this.a.getBackground() instanceof com.google.android.material.g.a)) {
            } else {
                ((com.google.android.material.g.a) this.a.getBackground()).setTintList(b.d(colorStateList));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(@NonNull m mVar) {
        this.b = mVar;
        B(mVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(boolean z) {
        this.n = z;
        D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(@Nullable ColorStateList colorStateList) {
        if (this.f4157k != colorStateList) {
            this.f4157k = colorStateList;
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int i2) {
        if (this.f4154h != i2) {
            this.f4154h = i2;
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(@Nullable ColorStateList colorStateList) {
        if (this.f4156j != colorStateList) {
            this.f4156j = colorStateList;
            if (c() != null) {
                DrawableCompat.setTintList(c(), this.f4156j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(@Nullable PorterDuff.Mode mode) {
        if (this.f4155i != mode) {
            this.f4155i = mode;
            if (c() == null || this.f4155i == null) {
                return;
            }
            DrawableCompat.setTintMode(c(), this.f4155i);
        }
    }
}
