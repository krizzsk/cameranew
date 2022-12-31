package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.b;
import com.google.android.material.animation.h;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    private final h c;

    /* renamed from: d  reason: collision with root package name */
    private final h f4692d;

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ View b;

        a(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
            this.a = z;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            View view = this.b;
            view.setVisibility(4);
            VdsAgent.onSetViewVisibility(view, 4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                View view = this.b;
                view.setVisibility(0);
                VdsAgent.onSetViewVisibility(view, 0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.c = new h(75L, 150L);
        this.f4692d = new h(0L, 150L);
    }

    private void g(@NonNull View view, boolean z, boolean z2, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        h hVar = z ? this.c : this.f4692d;
        if (z) {
            if (!z2) {
                view.setAlpha(0.0f);
            }
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f);
        }
        hVar.a(ofFloat);
        list.add(ofFloat);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet f(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        g(view2, z, z2, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2));
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view, motionEvent);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new h(75L, 150L);
        this.f4692d = new h(0L, 150L);
    }
}
