package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.g;
import com.google.android.material.animation.h;
import com.google.android.material.animation.i;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final Rect c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f4687d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f4688e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f4689f;

    /* renamed from: g  reason: collision with root package name */
    private float f4690g;

    /* renamed from: h  reason: collision with root package name */
    private float f4691h;

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.a = z;
            this.b = view;
            this.c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            View view = this.b;
            view.setVisibility(4);
            VdsAgent.onSetViewVisibility(view, 4);
            this.c.setAlpha(1.0f);
            View view2 = this.c;
            view2.setVisibility(0);
            VdsAgent.onSetViewVisibility(view2, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                View view = this.b;
                view.setVisibility(0);
                VdsAgent.onSetViewVisibility(view, 0);
                this.c.setAlpha(0.0f);
                View view2 = this.c;
                view2.setVisibility(4);
                VdsAgent.onSetViewVisibility(view2, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        b(FabTransformationBehavior fabTransformationBehavior, View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.c a;
        final /* synthetic */ Drawable b;

        c(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.a = cVar;
            this.b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.c a;

        d(FabTransformationBehavior fabTransformationBehavior, com.google.android.material.circularreveal.c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e a = this.a.a();
            a.c = Float.MAX_VALUE;
            this.a.setRevealInfo(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class e {
        @Nullable
        public g a;
        public i b;
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.f4687d = new RectF();
        this.f4688e = new RectF();
        this.f4689f = new int[2];
    }

    @Nullable
    private ViewGroup B(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Nullable
    private ViewGroup g(@NonNull View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (findViewById != null) {
            return B(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return B(view);
        }
        return B(((ViewGroup) view).getChildAt(0));
    }

    private void h(@NonNull View view, @NonNull e eVar, @NonNull h hVar, @NonNull h hVar2, float f2, float f3, float f4, float f5, @NonNull RectF rectF) {
        float o = o(eVar, hVar, f2, f4);
        float o2 = o(eVar, hVar2, f3, f5);
        Rect rect = this.c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f4687d;
        rectF2.set(rect);
        RectF rectF3 = this.f4688e;
        p(view, rectF3);
        rectF3.offset(o, o2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void i(@NonNull View view, @NonNull RectF rectF) {
        p(view, rectF);
        rectF.offset(this.f4690g, this.f4691h);
    }

    @NonNull
    private Pair<h, h> j(float f2, float f3, boolean z, @NonNull e eVar) {
        h h2;
        h h3;
        int i2;
        if (f2 == 0.0f || f3 == 0.0f) {
            h2 = eVar.a.h("translationXLinear");
            h3 = eVar.a.h("translationYLinear");
        } else if ((z && f3 < 0.0f) || (!z && i2 > 0)) {
            h2 = eVar.a.h("translationXCurveUpwards");
            h3 = eVar.a.h("translationYCurveUpwards");
        } else {
            h2 = eVar.a.h("translationXCurveDownwards");
            h3 = eVar.a.h("translationYCurveDownwards");
        }
        return new Pair<>(h2, h3);
    }

    private float k(@NonNull View view, @NonNull View view2, @NonNull i iVar) {
        RectF rectF = this.f4687d;
        RectF rectF2 = this.f4688e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(-m(view, view2, iVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float l(@NonNull View view, @NonNull View view2, @NonNull i iVar) {
        RectF rectF = this.f4687d;
        RectF rectF2 = this.f4688e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(0.0f, -n(view, view2, iVar));
        return rectF.centerY() - rectF2.top;
    }

    private float m(@NonNull View view, @NonNull View view2, @NonNull i iVar) {
        float centerX;
        float centerX2;
        float f2;
        RectF rectF = this.f4687d;
        RectF rectF2 = this.f4688e;
        i(view, rectF);
        p(view2, rectF2);
        int i2 = iVar.a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i2 == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f2 = 0.0f;
            return f2 + iVar.b;
        }
        f2 = centerX - centerX2;
        return f2 + iVar.b;
    }

    private float n(@NonNull View view, @NonNull View view2, @NonNull i iVar) {
        float centerY;
        float centerY2;
        float f2;
        RectF rectF = this.f4687d;
        RectF rectF2 = this.f4688e;
        i(view, rectF);
        p(view2, rectF2);
        int i2 = iVar.a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i2 == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f2 = 0.0f;
            return f2 + iVar.c;
        }
        f2 = centerY - centerY2;
        return f2 + iVar.c;
    }

    private float o(@NonNull e eVar, @NonNull h hVar, float f2, float f3) {
        long c2 = hVar.c();
        long d2 = hVar.d();
        h h2 = eVar.a.h("expansion");
        return com.google.android.material.animation.a.a(f2, f3, hVar.e().getInterpolation(((float) (((h2.c() + h2.d()) + 17) - c2)) / ((float) d2)));
    }

    private void p(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f4689f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void q(View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup g2;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.f4192j == 0) || (g2 = g(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    com.google.android.material.animation.c.a.set(g2, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(g2, com.google.android.material.animation.c.a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(g2, com.google.android.material.animation.c.a, 0.0f);
            }
            eVar.a.h("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    private void r(@NonNull View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            int z3 = z(view);
            int i2 = 16777215 & z3;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(z3);
                }
                ofInt = ObjectAnimator.ofInt(cVar, c.d.a, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(cVar, c.d.a, z3);
            }
            ofInt.setEvaluator(ArgbEvaluatorCompat.getInstance());
            eVar.a.h(TypedValues.Custom.S_COLOR).a(ofInt);
            list.add(ofInt);
        }
    }

    private void s(@NonNull View view, @NonNull View view2, boolean z, @NonNull e eVar, @NonNull List<Animator> list) {
        float m = m(view, view2, eVar.b);
        float n = n(view, view2, eVar.b);
        Pair<h, h> j2 = j(m, n, z, eVar);
        h hVar = (h) j2.first;
        h hVar2 = (h) j2.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            m = this.f4690g;
        }
        fArr[0] = m;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            n = this.f4691h;
        }
        fArr2[0] = n;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        hVar.a(ofFloat);
        hVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void t(View view, @NonNull View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        eVar.a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    private void u(@NonNull View view, View view2, boolean z, boolean z2, @NonNull e eVar, float f2, float f3, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            float k2 = k(view, view2, eVar.b);
            float l2 = l(view, view2, eVar.b);
            ((FloatingActionButton) view).j(this.c);
            float width = this.c.width() / 2.0f;
            h h2 = eVar.a.h("expansion");
            if (z) {
                if (!z2) {
                    cVar.setRevealInfo(new c.e(k2, l2, width));
                }
                if (z2) {
                    width = cVar.a().c;
                }
                animator = com.google.android.material.circularreveal.a.a(cVar, k2, l2, com.google.android.material.e.a.b(k2, l2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new d(this, cVar));
                x(view2, h2.c(), (int) k2, (int) l2, width, list);
            } else {
                float f4 = cVar.a().c;
                Animator a2 = com.google.android.material.circularreveal.a.a(cVar, k2, l2, width);
                int i2 = (int) k2;
                int i3 = (int) l2;
                x(view2, h2.c(), i2, i3, f4, list);
                w(view2, h2.c(), h2.d(), eVar.a.i(), i2, i3, width, list);
                animator = a2;
            }
            h2.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.circularreveal.a.b(cVar));
        }
    }

    private void v(View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, com.google.android.material.animation.d.b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, com.google.android.material.animation.d.b, 255);
            }
            ofInt.addUpdateListener(new b(this, view2));
            eVar.a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(this, cVar, drawable));
        }
    }

    private void w(View view, long j2, long j3, long j4, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }

    private void x(View view, long j2, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j2 <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j2);
        list.add(createCircularReveal);
    }

    private void y(@NonNull View view, @NonNull View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float m = m(view, view2, eVar.b);
        float n = n(view, view2, eVar.b);
        Pair<h, h> j2 = j(m, n, z, eVar);
        h hVar = (h) j2.first;
        h hVar2 = (h) j2.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-m);
                view2.setTranslationY(-n);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            h(view2, eVar, hVar, hVar2, -m, -n, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -m);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -n);
        }
        hVar.a(ofFloat);
        hVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int z(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    protected abstract e A(Context context, boolean z);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    protected AnimatorSet f(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        e A = A(view2.getContext(), z);
        if (z) {
            this.f4690g = view.getTranslationX();
            this.f4691h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            t(view, view2, z, z2, A, arrayList, arrayList2);
        }
        RectF rectF = this.f4687d;
        y(view, view2, z, z2, A, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        s(view, view2, z, A, arrayList);
        v(view, view2, z, z2, A, arrayList, arrayList2);
        u(view, view2, z, z2, A, width, height, arrayList, arrayList2);
        r(view, view2, z, z2, A, arrayList, arrayList2);
        q(view, view2, z, z2, A, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() != 8) {
            if (view2 instanceof FloatingActionButton) {
                int k2 = ((FloatingActionButton) view2).k();
                return k2 == 0 || k2 == view.getId();
            }
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.f4687d = new RectF();
        this.f4688e = new RectF();
        this.f4689f = new int[2];
    }
}
