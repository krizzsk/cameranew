package us.pinguo.edit2020.view.loading;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.foundation.e;
/* compiled from: BgReplacementLoadingView.kt */
/* loaded from: classes4.dex */
public final class BgReplacementLoadingView extends ConstraintLayout {
    public Map<Integer, View> a;
    private final ArrayList<String> b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private v1 f10777d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f10778e;

    /* renamed from: f  reason: collision with root package name */
    private ValueAnimator f10779f;

    /* renamed from: g  reason: collision with root package name */
    private ObjectAnimator f10780g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10781h;

    /* renamed from: i  reason: collision with root package name */
    private AccelerateDecelerateInterpolator f10782i;

    /* renamed from: j  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f10783j;

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            v1 d2;
            s.h(animator, "animator");
            v1 v1Var = BgReplacementLoadingView.this.f10777d;
            if (v1Var != null) {
                v1.a.a(v1Var, null, 1, null);
            }
            BgReplacementLoadingView bgReplacementLoadingView = BgReplacementLoadingView.this;
            d2 = l.d(n0.a(z0.c()), null, null, new BgReplacementLoadingView$showProgressAnim$1$1$1(BgReplacementLoadingView.this, null), 3, null);
            bgReplacementLoadingView.f10777d = d2;
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
    public BgReplacementLoadingView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ BgReplacementLoadingView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void l() {
        int i2 = R.id.ivLoadingEnd;
        ((WebPAnimDraweeView) _$_findCachedViewById(i2)).setOnAnimFinished(new BgReplacementLoadingView$doFinishAnimation$1(this));
        ((WebPAnimDraweeView) _$_findCachedViewById(i2)).setOnResourceLoaded(new BgReplacementLoadingView$doFinishAnimation$2(this));
    }

    private final void q(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.cancel();
    }

    private final void r() {
        ((WebPAnimDraweeView) _$_findCachedViewById(R.id.ivLoadingEnd)).setImagePath(Integer.valueOf(R.drawable.loading_anim_03), 1);
        int i2 = R.id.ivLoadingMiddle;
        WebPAnimDraweeView ivLoadingMiddle = (WebPAnimDraweeView) _$_findCachedViewById(i2);
        s.g(ivLoadingMiddle, "ivLoadingMiddle");
        WebPAnimDraweeView.setImagePath$default(ivLoadingMiddle, Integer.valueOf(R.drawable.loading_anim_02), 0, 2, null);
        int i3 = R.id.ivLoadingStart;
        ((WebPAnimDraweeView) _$_findCachedViewById(i3)).setImagePath(Integer.valueOf(R.drawable.loading_anim_01), 1);
        ((WebPAnimDraweeView) _$_findCachedViewById(i3)).setOnAnimFinished(new BgReplacementLoadingView$setupView$1(this));
        ((WebPAnimDraweeView) _$_findCachedViewById(i3)).setOnResourceLoaded(new BgReplacementLoadingView$setupView$2(this));
        ((WebPAnimDraweeView) _$_findCachedViewById(i2)).setOnResourceLoaded(new BgReplacementLoadingView$setupView$3(this));
        ((WebPAnimDraweeView) _$_findCachedViewById(i2)).setOnFirstFrame(new BgReplacementLoadingView$setupView$4(this));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(R.id.tvHandling), "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setInterpolator(this.f10782i);
        ofFloat.start();
        this.f10778e = ofFloat;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        ofInt.setDuration(800L);
        ofInt.setInterpolator(this.f10782i);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.view.loading.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BgReplacementLoadingView.s(BgReplacementLoadingView.this, valueAnimator);
            }
        });
        ofInt.start();
        this.f10779f = ofInt;
        _$_findCachedViewById(R.id.spacer).setOnClickListener(b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(BgReplacementLoadingView this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        ((LineProgressView) this$0._$_findCachedViewById(R.id.lineProgressView)).a(animatedFraction);
        if (animatedFraction == 1.0f) {
            this$0.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    private final void u() {
        int i2 = R.id.tvProgress;
        ((TextView) _$_findCachedViewById(i2)).setText(this.b.get(this.c));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((TextView) _$_findCachedViewById(i2), "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        s.g(ofFloat, "");
        ofFloat.addListener(new a());
        ofFloat.start();
        this.f10780g = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(kotlin.coroutines.Continuation<? super kotlin.u> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof us.pinguo.edit2020.view.loading.BgReplacementLoadingView$textDisplay$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.edit2020.view.loading.BgReplacementLoadingView$textDisplay$1 r0 = (us.pinguo.edit2020.view.loading.BgReplacementLoadingView$textDisplay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.edit2020.view.loading.BgReplacementLoadingView$textDisplay$1 r0 = new us.pinguo.edit2020.view.loading.BgReplacementLoadingView$textDisplay$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r8)
            goto L86
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            java.lang.Object r2 = r0.L$0
            us.pinguo.edit2020.view.loading.BgReplacementLoadingView r2 = (us.pinguo.edit2020.view.loading.BgReplacementLoadingView) r2
            kotlin.j.b(r8)
            goto L7a
        L3c:
            kotlin.j.b(r8)
            int r8 = r7.c
            int r8 = r8 + r4
            r7.c = r8
            java.util.ArrayList<java.lang.String> r2 = r7.b
            int r2 = r2.size()
            int r8 = r8 % r2
            int r2 = us.pinguo.edit2020.R.id.tvProgress
            android.view.View r2 = r7._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.util.ArrayList<java.lang.String> r5 = r7.b
            java.lang.Object r8 = r5.get(r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
            kotlin.z.d r8 = new kotlin.z.d
            r2 = 200(0xc8, float:2.8E-43)
            r5 = 500(0x1f4, float:7.0E-43)
            r8.<init>(r2, r5)
            kotlin.random.Random$Default r2 = kotlin.random.Random.Default
            int r8 = kotlin.z.h.g(r8, r2)
            long r5 = (long) r8
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r8 != r1) goto L79
            return r1
        L79:
            r2 = r7
        L7a:
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r8 = r2.v(r0)
            if (r8 != r1) goto L86
            return r1
        L86:
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.loading.BgReplacementLoadingView.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void k() {
        int i2 = R.id.ivLoadingStart;
        boolean s = ((WebPAnimDraweeView) _$_findCachedViewById(i2)).s();
        this.f10781h = s;
        if (s) {
            ((WebPAnimDraweeView) _$_findCachedViewById(i2)).u();
            WebPAnimDraweeView ivLoadingEnd = (WebPAnimDraweeView) _$_findCachedViewById(R.id.ivLoadingEnd);
            s.g(ivLoadingEnd, "ivLoadingEnd");
            ivLoadingEnd.setVisibility(0);
            VdsAgent.onSetViewVisibility(ivLoadingEnd, 0);
            WebPAnimDraweeView ivLoadingMiddle = (WebPAnimDraweeView) _$_findCachedViewById(R.id.ivLoadingMiddle);
            s.g(ivLoadingMiddle, "ivLoadingMiddle");
            ivLoadingMiddle.setVisibility(4);
            VdsAgent.onSetViewVisibility(ivLoadingMiddle, 4);
            WebPAnimDraweeView ivLoadingStart = (WebPAnimDraweeView) _$_findCachedViewById(i2);
            s.g(ivLoadingStart, "ivLoadingStart");
            ivLoadingStart.setVisibility(4);
            VdsAgent.onSetViewVisibility(ivLoadingStart, 4);
            l();
            return;
        }
        int i3 = R.id.ivLoadingMiddle;
        ((WebPAnimDraweeView) _$_findCachedViewById(i3)).u();
        WebPAnimDraweeView ivLoadingEnd2 = (WebPAnimDraweeView) _$_findCachedViewById(R.id.ivLoadingEnd);
        s.g(ivLoadingEnd2, "ivLoadingEnd");
        ivLoadingEnd2.setVisibility(0);
        VdsAgent.onSetViewVisibility(ivLoadingEnd2, 0);
        WebPAnimDraweeView ivLoadingMiddle2 = (WebPAnimDraweeView) _$_findCachedViewById(i3);
        s.g(ivLoadingMiddle2, "ivLoadingMiddle");
        ivLoadingMiddle2.setVisibility(4);
        VdsAgent.onSetViewVisibility(ivLoadingMiddle2, 4);
        l();
    }

    public final kotlin.jvm.b.a<u> m() {
        return this.f10783j;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        r();
    }

    public final void p() {
        v1 v1Var = this.f10777d;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        q(this.f10778e);
        q(this.f10780g);
        q(this.f10779f);
        this.f10778e = null;
        this.f10780g = null;
        this.f10779f = null;
    }

    public final void setFullScreen(boolean z) {
        View spacer = _$_findCachedViewById(R.id.spacer);
        s.g(spacer, "spacer");
        ViewGroup.LayoutParams layoutParams = spacer.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = us.pinguo.common.widget.i.a.a(Integer.valueOf(z ? 76 : 44));
        spacer.setLayoutParams(layoutParams2);
        if (z) {
            return;
        }
        View spacer1 = _$_findCachedViewById(R.id.spacer1);
        s.g(spacer1, "spacer1");
        ViewGroup.LayoutParams layoutParams3 = spacer1.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = us.pinguo.common.widget.i.a.a(32);
        spacer1.setLayoutParams(layoutParams4);
    }

    public final void setOnFinish(kotlin.jvm.b.a<u> aVar) {
        this.f10783j = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgReplacementLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ArrayList<String> f2;
        s.h(context, "context");
        this.a = new LinkedHashMap();
        Context b = e.b();
        int i3 = R.string.bg_loading_resolving;
        f2 = kotlin.collections.u.f(e.b().getString(R.string.bg_loading_person_processing), e.b().getString(R.string.bg_loading_detecting), b.getString(i3), e.b().getString(R.string.bg_loading_resolving_finished), e.b().getString(R.string.bg_loading_foreground_processing), e.b().getString(R.string.bg_loading_detect_foreground), e.b().getString(i3), e.b().getString(R.string.bg_loading_foreground_finished), e.b().getString(R.string.bg_loading_background_processing), e.b().getString(R.string.bg_loading_detect_background), e.b().getString(R.string.bg_loading_background_finished), e.b().getString(R.string.bg_loading_separate_layer), e.b().getString(R.string.bg_loading_foreground_matting), e.b().getString(R.string.bg_loading_background_removed));
        this.b = f2;
        this.c = 1;
        this.f10782i = new AccelerateDecelerateInterpolator();
    }
}
