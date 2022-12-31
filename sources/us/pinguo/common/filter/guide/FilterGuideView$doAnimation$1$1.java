package us.pinguo.common.filter.guide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.m0;
import us.pinguo.common.utils.k;
import us.pinguo.commonui.R;
/* compiled from: FilterGuideView.kt */
@DebugMetadata(c = "us.pinguo.common.filter.guide.FilterGuideView$doAnimation$1$1", f = "FilterGuideView.kt", i = {}, l = {BaseBlurEffect.ROTATION_180}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class FilterGuideView$doAnimation$1$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FrameLayout $flContainer;
    final /* synthetic */ LifecycleCoroutineScope $lifecycleScope;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ FilterGuideView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterGuideView.kt */
    /* renamed from: us.pinguo.common.filter.guide.FilterGuideView$doAnimation$1$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Float, u> {
        final /* synthetic */ FrameLayout $flContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FrameLayout frameLayout) {
            super(1);
            this.$flContainer = frameLayout;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ u invoke(Float f2) {
            invoke(f2.floatValue());
            return u.a;
        }

        public final void invoke(float f2) {
            if (f2 > 0.8f) {
                this.$flContainer.setAlpha(f2);
            }
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ View a;
        final /* synthetic */ LifecycleCoroutineScope b;
        final /* synthetic */ FilterGuideView c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FrameLayout f9868d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ImageView f9869e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ImageView f9870f;

        public a(View view, LifecycleCoroutineScope lifecycleCoroutineScope, FilterGuideView filterGuideView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2) {
            this.a = view;
            this.b = lifecycleCoroutineScope;
            this.c = filterGuideView;
            this.f9868d = frameLayout;
            this.f9869e = imageView;
            this.f9870f = imageView2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", 0.6f, 1.1f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, "scaleY", 0.6f, 1.1f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            animatorSet.setDuration(200L);
            animatorSet.start();
            animatorSet.addListener(new b(this.b, this.c, this.f9868d, this.f9869e, this.f9870f, this.a));
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

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ LifecycleCoroutineScope a;
        final /* synthetic */ FilterGuideView b;
        final /* synthetic */ FrameLayout c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ImageView f9871d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ImageView f9872e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ View f9873f;

        public b(LifecycleCoroutineScope lifecycleCoroutineScope, FilterGuideView filterGuideView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, View view) {
            this.a = lifecycleCoroutineScope;
            this.b = filterGuideView;
            this.c = frameLayout;
            this.f9871d = imageView;
            this.f9872e = imageView2;
            this.f9873f = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            kotlinx.coroutines.l.d(this.a, null, null, new FilterGuideView$doAnimation$1$1$1$1$1(this.b, this.c, this.f9871d, this.f9872e, this.f9873f, null), 3, null);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterGuideView$doAnimation$1$1(View view, FrameLayout frameLayout, LifecycleCoroutineScope lifecycleCoroutineScope, FilterGuideView filterGuideView, Continuation<? super FilterGuideView$doAnimation$1$1> continuation) {
        super(2, continuation);
        this.$view = view;
        this.$flContainer = frameLayout;
        this.$lifecycleScope = lifecycleCoroutineScope;
        this.this$0 = filterGuideView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterGuideView$doAnimation$1$1(this.$view, this.$flContainer, this.$lifecycleScope, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterGuideView$doAnimation$1$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            this.label = 1;
            if (DelayKt.b(800L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        float f2 = -us.pinguo.common.widget.i.a.a(Boxing.boxInt(12));
        ObjectAnimator translationYAnim = ObjectAnimator.ofFloat(this.$view, "translationY", 0.0f, (-(us.pinguo.common.widget.i.a.a(Boxing.boxInt(28)) + us.pinguo.common.widget.i.a.a(Boxing.boxInt(10)) + us.pinguo.common.widget.i.a.a(Boxing.boxInt(28)))) + f2);
        translationYAnim.setDuration(800L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.$flContainer, "scaleX", 1.0f, 1.4f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.$flContainer, "scaleY", 1.0f, 1.4f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.$flContainer, "translationY", 0.0f, f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setStartDelay(320L);
        animatorSet.setDuration(600L);
        animatorSet.start();
        ImageView bubbleView = (ImageView) this.$flContainer.findViewWithTag("bubble");
        ImageView starView = (ImageView) this.$flContainer.findViewWithTag("star");
        s.g(translationYAnim, "translationYAnim");
        translationYAnim.addListener(new a(this.$view, this.$lifecycleScope, this.this$0, this.$flContainer, bubbleView, starView));
        translationYAnim.start();
        s.g(bubbleView, "bubbleView");
        d.c(bubbleView, k.b(R.color.filter_bubble_grey), k.b(R.color.white), 600L, (r18 & 16) != 0 ? 0L : 400L, (r18 & 32) != 0 ? null : null);
        s.g(starView, "starView");
        d.c(starView, k.b(R.color.filter_star_grey), k.b(R.color.filter_star_yellow), 200L, 500L, new AnonymousClass2(this.$flContainer));
        return u.a;
    }
}
