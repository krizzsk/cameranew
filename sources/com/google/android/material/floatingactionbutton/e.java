package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.shape.h;
import com.google.android.material.shape.m;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImplLollipop.java */
@RequiresApi(21)
/* loaded from: classes2.dex */
public class e extends d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImplLollipop.java */
    /* loaded from: classes2.dex */
    public static class a extends h {
        a(m mVar) {
            super(mVar);
        }

        @Override // com.google.android.material.shape.h, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FloatingActionButton floatingActionButton, com.google.android.material.h.b bVar) {
        super(floatingActionButton, bVar);
    }

    @NonNull
    private Animator e0(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(d.F);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void A(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.y.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.G, e0(f2, f4));
            stateListAnimator.addState(d.H, e0(f2, f3));
            stateListAnimator.addState(d.I, e0(f2, f3));
            stateListAnimator.addState(d.J, e0(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.y;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.F);
            stateListAnimator.addState(d.K, animatorSet);
            stateListAnimator.addState(d.L, e0(0.0f, 0.0f));
            this.y.setStateListAnimator(stateListAnimator);
        }
        if (U()) {
            a0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean F() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void Q(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(com.google.android.material.g.b.d(colorStateList));
        } else {
            super.Q(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean U() {
        return this.z.a() || !W();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void Y() {
    }

    @NonNull
    c d0(int i2, ColorStateList colorStateList) {
        Context context = this.y.getContext();
        c cVar = new c((m) Preconditions.checkNotNull(this.a));
        cVar.e(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        cVar.d(i2);
        cVar.c(colorStateList);
        return cVar;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    @NonNull
    h j() {
        return new a((m) Preconditions.checkNotNull(this.a));
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float m() {
        return this.y.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void p(@NonNull Rect rect) {
        if (this.z.a()) {
            super.p(rect);
        } else if (!W()) {
            int o = (this.f4300k - this.y.o()) / 2;
            rect.set(o, o, o, o);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void s(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        h j2 = j();
        this.b = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.L(this.y.getContext());
        if (i2 > 0) {
            this.f4293d = d0(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f4293d), (Drawable) Preconditions.checkNotNull(this.b)});
        } else {
            this.f4293d = null;
            drawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(com.google.android.material.g.b.d(colorStateList2), drawable, null);
        this.c = rippleDrawable;
        this.f4294e = rippleDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void v() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void x() {
        a0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.floatingactionbutton.d
    public void z(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.y.isEnabled()) {
                this.y.setElevation(this.f4297h);
                if (this.y.isPressed()) {
                    this.y.setTranslationZ(this.f4299j);
                    return;
                } else if (!this.y.isFocused() && !this.y.isHovered()) {
                    this.y.setTranslationZ(0.0f);
                    return;
                } else {
                    this.y.setTranslationZ(this.f4298i);
                    return;
                }
            }
            this.y.setElevation(0.0f);
            this.y.setTranslationZ(0.0f);
        }
    }
}
