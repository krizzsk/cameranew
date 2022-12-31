package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.g;
import com.pinguo.camera360.effect.model.entity.type.Frame;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMotionStrategy.java */
/* loaded from: classes2.dex */
public abstract class b implements f {
    private final Context a;
    @NonNull
    private final ExtendedFloatingActionButton b;
    private final ArrayList<Animator.AnimatorListener> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f4281d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private g f4282e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private g f4283f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseMotionStrategy.java */
    /* loaded from: classes2.dex */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(com.google.android.material.animation.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.D.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.D.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f2) {
            int colorForState = extendedFloatingActionButton.D.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.D.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (com.google.android.material.animation.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f2.floatValue() == 1.0f) {
                extendedFloatingActionButton.P(extendedFloatingActionButton.D);
            } else {
                extendedFloatingActionButton.P(valueOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.f4281d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void a() {
        this.f4281d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void d() {
        this.f4281d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void f(@Nullable g gVar) {
        this.f4283f = gVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet g() {
        return k(l());
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @NonNull
    public final List<Animator.AnimatorListener> h() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AnimatorSet k(@NonNull g gVar) {
        ArrayList arrayList = new ArrayList();
        if (gVar.j(Frame.PARAM_KEY_OPACITY)) {
            arrayList.add(gVar.f(Frame.PARAM_KEY_OPACITY, this.b, View.ALPHA));
        }
        if (gVar.j("scale")) {
            arrayList.add(gVar.f("scale", this.b, View.SCALE_Y));
            arrayList.add(gVar.f("scale", this.b, View.SCALE_X));
        }
        if (gVar.j("width")) {
            arrayList.add(gVar.f("width", this.b, ExtendedFloatingActionButton.F));
        }
        if (gVar.j("height")) {
            arrayList.add(gVar.f("height", this.b, ExtendedFloatingActionButton.G));
        }
        if (gVar.j("paddingStart")) {
            arrayList.add(gVar.f("paddingStart", this.b, ExtendedFloatingActionButton.H));
        }
        if (gVar.j("paddingEnd")) {
            arrayList.add(gVar.f("paddingEnd", this.b, ExtendedFloatingActionButton.I));
        }
        if (gVar.j("labelOpacity")) {
            arrayList.add(gVar.f("labelOpacity", this.b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final g l() {
        g gVar = this.f4283f;
        if (gVar != null) {
            return gVar;
        }
        if (this.f4282e == null) {
            this.f4282e = g.d(this.a, e());
        }
        return (g) Preconditions.checkNotNull(this.f4282e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.f4281d.c(animator);
    }
}
