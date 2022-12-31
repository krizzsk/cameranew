package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import com.google.android.material.circularreveal.c;
/* compiled from: CircularRevealCompat.java */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: CircularRevealCompat.java */
    /* renamed from: com.google.android.material.circularreveal.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0169a extends AnimatorListenerAdapter {
        final /* synthetic */ c a;

        C0169a(c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.b();
        }
    }

    @NonNull
    public static Animator a(@NonNull c cVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, (Property<c, V>) c.C0170c.a, (TypeEvaluator) c.b.b, (Object[]) new c.e[]{new c.e(f2, f3, f4)});
        if (Build.VERSION.SDK_INT >= 21) {
            c.e a = cVar.a();
            if (a != null) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, a.c, f4);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofObject, createCircularReveal);
                return animatorSet;
            }
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        return ofObject;
    }

    @NonNull
    public static Animator.AnimatorListener b(@NonNull c cVar) {
        return new C0169a(cVar);
    }
}
