package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.progressindicator.b;
/* compiled from: DeterminateDrawable.java */
/* loaded from: classes2.dex */
public final class e<S extends b> extends f {
    private static final FloatPropertyCompat<e> u = new a("indicatorLevel");
    private g<S> p;
    private final SpringForce q;
    private final SpringAnimation r;
    private float s;
    private boolean t;

    /* compiled from: DeterminateDrawable.java */
    /* loaded from: classes2.dex */
    static class a extends FloatPropertyCompat<e> {
        a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: a */
        public float getValue(e eVar) {
            return eVar.v() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: b */
        public void setValue(e eVar, float f2) {
            eVar.x(f2 / 10000.0f);
        }
    }

    e(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar) {
        super(context, bVar);
        this.t = false;
        w(gVar);
        SpringForce springForce = new SpringForce();
        this.q = springForce;
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, u);
        this.r = springAnimation;
        springAnimation.setSpring(springForce);
        l(1.0f);
    }

    @NonNull
    public static e<CircularProgressIndicatorSpec> s(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new e<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec));
    }

    @NonNull
    public static e<LinearProgressIndicatorSpec> t(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new e<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float v() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(float f2) {
        this.s = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.p.g(canvas, g());
            this.p.c(canvas, this.m);
            this.p.b(canvas, this.m, 0.0f, v(), com.google.android.material.b.a.a(this.b.c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.p.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.p.e();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.r.cancel();
        x(getLevel() / 10000.0f);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        if (this.t) {
            this.r.cancel();
            x(i2 / 10000.0f);
            return true;
        }
        this.r.setStartValue(v() * 10000.0f);
        this.r.animateToFinalPosition(i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.f
    public boolean p(boolean z, boolean z2, boolean z3) {
        boolean p = super.p(z, z2, z3);
        float a2 = this.c.a(this.a.getContentResolver());
        if (a2 == 0.0f) {
            this.t = true;
        } else {
            this.t = false;
            this.q.setStiffness(50.0f / a2);
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public g<S> u() {
        return this.p;
    }

    void w(@NonNull g<S> gVar) {
        this.p = gVar;
        gVar.f(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(float f2) {
        setLevel((int) (f2 * 10000.0f));
    }
}
