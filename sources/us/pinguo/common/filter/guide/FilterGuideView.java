package us.pinguo.common.filter.guide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewKt;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.j;
import us.pinguo.common.utils.k;
import us.pinguo.commonui.R;
/* compiled from: FilterGuideView.kt */
/* loaded from: classes4.dex */
public final class FilterGuideView extends FrameLayout {

    /* compiled from: View.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FilterGuideView b;
        final /* synthetic */ FrameLayout c;

        public a(View view, FilterGuideView filterGuideView, FrameLayout frameLayout) {
            this.a = view;
            this.b = filterGuideView;
            this.c = frameLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.h(this.a, this.c);
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ View a;
        final /* synthetic */ FrameLayout b;
        final /* synthetic */ FilterGuideView c;

        public b(View view, FrameLayout frameLayout, FilterGuideView filterGuideView) {
            this.a = view;
            this.b = frameLayout;
            this.c = filterGuideView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            LifecycleOwner findViewTreeLifecycleOwner = ViewKt.findViewTreeLifecycleOwner(this.a);
            LifecycleCoroutineScope lifecycleScope = findViewTreeLifecycleOwner == null ? null : LifecycleOwnerKt.getLifecycleScope(findViewTreeLifecycleOwner);
            if (lifecycleScope == null) {
                return;
            }
            j.d(lifecycleScope, null, null, new FilterGuideView$doAnimation$1$1(this.a, this.b, lifecycleScope, this.c, null), 3, null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilterGuideView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilterGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ FilterGuideView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final FrameLayout c(Rect rect) {
        int a2 = us.pinguo.common.widget.i.a.a(56);
        FrameLayout frameLayout = new FrameLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ic_filter_guide_bubble);
        imageView.setTag("bubble");
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        int a3 = us.pinguo.common.widget.i.a.a(32);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.icon_filter_package_collect_yellow);
        imageView2.setTag("star");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a3, a3);
        layoutParams.topMargin = us.pinguo.common.widget.i.a.a(10);
        layoutParams.gravity = 1;
        u uVar = u.a;
        frameLayout.addView(imageView2, layoutParams);
        frameLayout.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2, a2);
        layoutParams2.leftMargin = rect.left;
        layoutParams2.topMargin = (rect.top - a2) - us.pinguo.common.widget.i.a.a(8);
        addView(frameLayout, layoutParams2);
        return frameLayout;
    }

    private final CircleView d(int i2, Rect rect) {
        Context context = getContext();
        s.g(context, "context");
        CircleView circleView = new CircleView(context, null, 0, 6, null);
        circleView.setCircleColor(Color.parseColor("#B3000000"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
        layoutParams.leftMargin = rect.left;
        layoutParams.topMargin = rect.top;
        u uVar = u.a;
        addView(circleView, layoutParams);
        return circleView;
    }

    private final void e(Rect rect) {
        TextView textView = new TextView(getContext());
        textView.setText(k.c(R.string.str_fav_filter));
        textView.setPadding(us.pinguo.common.widget.i.a.a(12), 0, 0, 0);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = rect.top - us.pinguo.common.widget.i.a.a(120);
        u uVar = u.a;
        addView(textView, layoutParams);
    }

    private final void g(Rect rect) {
        Context context = getContext();
        s.g(context, "context");
        MuskView muskView = new MuskView(context, null, 0, 6, null);
        muskView.setBackgroundColor(k.b(R.color.black_70));
        muskView.setRect(rect);
        addView(muskView, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(View view, FrameLayout frameLayout) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.6f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.6f);
        ObjectAnimator alphaBubbleAnim = ObjectAnimator.ofFloat(frameLayout, "alpha", 0.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(300L);
        animatorSet.start();
        alphaBubbleAnim.setDuration(300L);
        alphaBubbleAnim.setStartDelay(180L);
        alphaBubbleAnim.start();
        s.g(alphaBubbleAnim, "alphaBubbleAnim");
        alphaBubbleAnim.addListener(new b(view, frameLayout, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, View view) {
        frameLayout.setScaleX(1.0f);
        frameLayout.setScaleY(1.0f);
        frameLayout.setTranslationY(0.0f);
        frameLayout.setAlpha(0.0f);
        d.a(imageView, k.b(R.color.filter_bubble_grey));
        d.a(imageView2, k.b(R.color.filter_star_grey));
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setTranslationY(0.0f);
    }

    public final void f(View decorView, View guideView, f fVar) {
        int c;
        int b2;
        int a2;
        s.h(decorView, "decorView");
        s.h(guideView, "guideView");
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        decorView.getGlobalVisibleRect(rect);
        guideView.getGlobalVisibleRect(rect2);
        int i2 = 0;
        if (fVar == null) {
            c = 0;
            a2 = 0;
            b2 = 0;
        } else {
            i2 = fVar.d();
            c = fVar.c();
            b2 = fVar.b();
            a2 = fVar.a();
        }
        rect2.top -= rect.top + i2;
        rect2.bottom -= rect.top + a2;
        int i3 = rect2.right - b2;
        rect2.right = i3;
        int i4 = rect2.left + c;
        rect2.left = i4;
        g(rect2);
        FrameLayout c2 = c(rect2);
        CircleView d2 = d(i3 - i4, rect2);
        e(rect2);
        s.g(OneShotPreDrawListener.add(d2, new a(d2, this, c2)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterGuideView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
    }
}
