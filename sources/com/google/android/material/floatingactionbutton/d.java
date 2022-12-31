package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;
import com.pinguo.camera360.effect.model.entity.type.Frame;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes2.dex */
public class d {
    static final TimeInterpolator F = com.google.android.material.animation.a.c;
    static final int[] G = {16842919, 16842910};
    static final int[] H = {16843623, 16842908, 16842910};
    static final int[] I = {16842908, 16842910};
    static final int[] J = {16843623, 16842910};
    static final int[] K = {16842910};
    static final int[] L = new int[0];
    @Nullable
    private ViewTreeObserver.OnPreDrawListener E;
    @Nullable
    m a;
    @Nullable
    com.google.android.material.shape.h b;
    @Nullable
    Drawable c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    com.google.android.material.floatingactionbutton.c f4293d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    Drawable f4294e;

    /* renamed from: f  reason: collision with root package name */
    boolean f4295f;

    /* renamed from: h  reason: collision with root package name */
    float f4297h;

    /* renamed from: i  reason: collision with root package name */
    float f4298i;

    /* renamed from: j  reason: collision with root package name */
    float f4299j;

    /* renamed from: k  reason: collision with root package name */
    int f4300k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.material.internal.g f4301l;
    @Nullable
    private com.google.android.material.animation.g m;
    @Nullable
    private com.google.android.material.animation.g n;
    @Nullable
    private Animator o;
    @Nullable
    private com.google.android.material.animation.g p;
    @Nullable
    private com.google.android.material.animation.g q;
    private float r;
    private int t;
    private ArrayList<Animator.AnimatorListener> v;
    private ArrayList<Animator.AnimatorListener> w;
    private ArrayList<i> x;
    final FloatingActionButton y;
    final com.google.android.material.h.b z;

    /* renamed from: g  reason: collision with root package name */
    boolean f4296g = true;
    private float s = 1.0f;
    private int u = 0;
    private final Rect A = new Rect();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ j c;

        a(boolean z, j jVar) {
            this.b = z;
            this.c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.u = 0;
            d.this.o = null;
            if (this.a) {
                return;
            }
            FloatingActionButton floatingActionButton = d.this.y;
            boolean z = this.b;
            floatingActionButton.c(z ? 8 : 4, z);
            j jVar = this.c;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.y.c(0, this.b);
            d.this.u = 1;
            d.this.o = animator;
            this.a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ j b;

        b(boolean z, j jVar) {
            this.a = z;
            this.b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.u = 0;
            d.this.o = null;
            j jVar = this.b;
            if (jVar != null) {
                jVar.onShown();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.y.c(0, this.a);
            d.this.u = 2;
            d.this.o = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    public class c extends com.google.android.material.animation.f {
        c() {
        }

        @Override // com.google.android.material.animation.f
        public Matrix a(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            d.this.s = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: com.google.android.material.floatingactionbutton.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0172d implements TypeEvaluator<Float> {
        FloatEvaluator a = new FloatEvaluator();

        C0172d(d dVar) {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Float evaluate(float f2, Float f3, Float f4) {
            float floatValue = this.a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.C();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class f extends l {
        f(d dVar) {
            super(dVar, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class g extends l {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.f4297h + dVar.f4298i;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class h extends l {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            d dVar = d.this;
            return dVar.f4297h + dVar.f4299j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    public interface i {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    public interface j {
        void a();

        void onShown();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class k extends l {
        k() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.l
        protected float a() {
            return d.this.f4297h;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float b;
        private float c;

        private l() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.b0((int) this.c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.a) {
                com.google.android.material.shape.h hVar = d.this.b;
                this.b = hVar == null ? 0.0f : hVar.w();
                this.c = a();
                this.a = true;
            }
            d dVar = d.this;
            float f2 = this.b;
            dVar.b0((int) (f2 + ((this.c - f2) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ l(d dVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FloatingActionButton floatingActionButton, com.google.android.material.h.b bVar) {
        this.y = floatingActionButton;
        this.z = bVar;
        com.google.android.material.internal.g gVar = new com.google.android.material.internal.g();
        this.f4301l = gVar;
        gVar.a(G, i(new h()));
        gVar.a(H, i(new g()));
        gVar.a(I, i(new g()));
        gVar.a(J, i(new g()));
        gVar.a(K, i(new k()));
        gVar.a(L, i(new f(this)));
        this.r = floatingActionButton.getRotation();
    }

    private boolean V() {
        return ViewCompat.isLaidOut(this.y) && !this.y.isInEditMode();
    }

    private void c0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new C0172d(this));
    }

    private void g(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.y.getDrawable();
        if (drawable == null || this.t == 0) {
            return;
        }
        RectF rectF = this.B;
        RectF rectF2 = this.C;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i2 = this.t;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.t;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    @NonNull
    private AnimatorSet h(@NonNull com.google.android.material.animation.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, View.ALPHA, f2);
        gVar.h(Frame.PARAM_KEY_OPACITY).a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, View.SCALE_X, f3);
        gVar.h("scale").a(ofFloat2);
        c0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.y, View.SCALE_Y, f3);
        gVar.h("scale").a(ofFloat3);
        c0(ofFloat3);
        arrayList.add(ofFloat3);
        g(f4, this.D);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.y, new com.google.android.material.animation.e(), new c(), new Matrix(this.D));
        gVar.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    private ValueAnimator i(@NonNull l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private com.google.android.material.animation.g k() {
        if (this.n == null) {
            this.n = com.google.android.material.animation.g.d(this.y.getContext(), R.animator.design_fab_hide_motion_spec);
        }
        return (com.google.android.material.animation.g) Preconditions.checkNotNull(this.n);
    }

    private com.google.android.material.animation.g l() {
        if (this.m == null) {
            this.m = com.google.android.material.animation.g.d(this.y.getContext(), R.animator.design_fab_show_motion_spec);
        }
        return (com.google.android.material.animation.g) Preconditions.checkNotNull(this.m);
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener o() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    void A(float f2, float f3, float f4) {
        a0();
        b0(f2);
    }

    void B(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.f4294e, "Didn't initialize content background");
        if (U()) {
            this.z.setBackgroundDrawable(new InsetDrawable(this.f4294e, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.z.setBackgroundDrawable(this.f4294e);
    }

    void C() {
        float rotation = this.y.getRotation();
        if (this.r != rotation) {
            this.r = rotation;
            Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    boolean F() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(@Nullable ColorStateList colorStateList) {
        com.google.android.material.shape.h hVar = this.b;
        if (hVar != null) {
            hVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f4293d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(@Nullable PorterDuff.Mode mode) {
        com.google.android.material.shape.h hVar = this.b;
        if (hVar != null) {
            hVar.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void I(float f2) {
        if (this.f4297h != f2) {
            this.f4297h = f2;
            A(f2, this.f4298i, this.f4299j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(boolean z) {
        this.f4295f = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void K(@Nullable com.google.android.material.animation.g gVar) {
        this.q = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(float f2) {
        if (this.f4298i != f2) {
            this.f4298i = f2;
            A(this.f4297h, f2, this.f4299j);
        }
    }

    final void M(float f2) {
        this.s = f2;
        Matrix matrix = this.D;
        g(f2, matrix);
        this.y.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(int i2) {
        if (this.t != i2) {
            this.t = i2;
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(int i2) {
        this.f4300k = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(float f2) {
        if (this.f4299j != f2) {
            this.f4299j = f2;
            A(this.f4297h, this.f4298i, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, com.google.android.material.g.b.d(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(boolean z) {
        this.f4296g = z;
        a0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(@NonNull m mVar) {
        this.a = mVar;
        com.google.android.material.shape.h hVar = this.b;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        Drawable drawable = this.c;
        if (drawable instanceof o) {
            ((o) drawable).setShapeAppearanceModel(mVar);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f4293d;
        if (cVar != null) {
            cVar.f(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void T(@Nullable com.google.android.material.animation.g gVar) {
        this.p = gVar;
    }

    boolean U() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean W() {
        return !this.f4295f || this.y.o() >= this.f4300k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(@Nullable j jVar, boolean z) {
        if (u()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (V()) {
            if (this.y.getVisibility() != 0) {
                this.y.setAlpha(0.0f);
                this.y.setScaleY(0.0f);
                this.y.setScaleX(0.0f);
                M(0.0f);
            }
            com.google.android.material.animation.g gVar = this.p;
            if (gVar == null) {
                gVar = l();
            }
            AnimatorSet h2 = h(gVar, 1.0f, 1.0f, 1.0f);
            h2.addListener(new b(z, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.v;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    h2.addListener(it.next());
                }
            }
            h2.start();
            return;
        }
        this.y.c(0, z);
        this.y.setAlpha(1.0f);
        this.y.setScaleY(1.0f);
        this.y.setScaleX(1.0f);
        M(1.0f);
        if (jVar != null) {
            jVar.onShown();
        }
    }

    void Y() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.r % 90.0f != 0.0f) {
                if (this.y.getLayerType() != 1) {
                    this.y.setLayerType(1, null);
                }
            } else if (this.y.getLayerType() != 0) {
                this.y.setLayerType(0, null);
            }
        }
        com.google.android.material.shape.h hVar = this.b;
        if (hVar != null) {
            hVar.d0((int) this.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Z() {
        M(this.s);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a0() {
        Rect rect = this.A;
        p(rect);
        B(rect);
        this.z.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(float f2) {
        com.google.android.material.shape.h hVar = this.b;
        if (hVar != null) {
            hVar.V(f2);
        }
    }

    public void d(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(@NonNull i iVar) {
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.add(iVar);
    }

    com.google.android.material.shape.h j() {
        return new com.google.android.material.shape.h((m) Preconditions.checkNotNull(this.a));
    }

    float m() {
        return this.f4297h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f4295f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(@NonNull Rect rect) {
        int o = this.f4295f ? (this.f4300k - this.y.o()) / 2 : 0;
        float m = this.f4296g ? m() + this.f4299j : 0.0f;
        int max = Math.max(o, (int) Math.ceil(m));
        int max2 = Math.max(o, (int) Math.ceil(m * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final m q() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@Nullable j jVar, boolean z) {
        if (t()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (V()) {
            com.google.android.material.animation.g gVar = this.q;
            if (gVar == null) {
                gVar = k();
            }
            AnimatorSet h2 = h(gVar, 0.0f, 0.0f, 0.0f);
            h2.addListener(new a(z, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.w;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    h2.addListener(it.next());
                }
            }
            h2.start();
            return;
        }
        this.y.c(z ? 8 : 4, z);
        if (jVar != null) {
            jVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        com.google.android.material.shape.h j2 = j();
        this.b = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.c0(-12303292);
        this.b.L(this.y.getContext());
        com.google.android.material.g.a aVar = new com.google.android.material.g.a(this.b.C());
        aVar.setTintList(com.google.android.material.g.b.d(colorStateList2));
        this.c = aVar;
        this.f4294e = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.b), aVar});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.y.getVisibility() == 0 ? this.u == 1 : this.u != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return this.y.getVisibility() != 0 ? this.u == 2 : this.u != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.f4301l.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        com.google.android.material.shape.h hVar = this.b;
        if (hVar != null) {
            com.google.android.material.shape.i.f(this.y, hVar);
        }
        if (F()) {
            this.y.getViewTreeObserver().addOnPreDrawListener(o());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        ViewTreeObserver viewTreeObserver = this.y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int[] iArr) {
        this.f4301l.d(iArr);
    }
}
