package com.pinguo.camera360.homepage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.pinguo.camera360.vip.VipManager;
import com.tapjoy.TJAdUnitConstants;
import kotlinx.coroutines.z0;
import us.pinguo.ad.b;
import us.pinguo.common.widget.adv.AdRewardView;
import vStudio.Android.Camera360.R;
/* compiled from: HomeRewardAdvDialogController.kt */
/* loaded from: classes3.dex */
public final class HomeRewardAdvDialogController implements b.InterfaceC0350b {
    private final ConstraintLayout a;
    private final FragmentActivity b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private int f6763d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6764e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6765f;

    /* renamed from: g  reason: collision with root package name */
    private AdRewardView f6766g;

    /* renamed from: h  reason: collision with root package name */
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> f6767h;

    /* renamed from: i  reason: collision with root package name */
    private final kotlinx.coroutines.m0 f6768i;

    /* renamed from: j  reason: collision with root package name */
    private final c f6769j;

    /* compiled from: Animator.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            HomeRewardAdvDialogController.this.l();
            kotlin.jvm.b.l<Boolean, kotlin.u> o = HomeRewardAdvDialogController.this.o();
            if (o == null) {
                return;
            }
            o.invoke(Boolean.FALSE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }
    }

    /* compiled from: HomeRewardAdvDialogController.kt */
    /* loaded from: classes3.dex */
    public static final class b implements b.a {
        b() {
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadFailed(int i2, String str) {
            us.pinguo.common.log.a.m("HomeRewardAdvDialogController", "onLoadFailed==>" + ((Object) str) + "===>" + i2, new Object[0]);
            kotlin.jvm.b.l<Boolean, kotlin.u> o = HomeRewardAdvDialogController.this.o();
            if (o != null) {
                o.invoke(Boolean.FALSE);
            }
            AdRewardView adRewardView = HomeRewardAdvDialogController.this.f6766g;
            if (adRewardView == null) {
                return;
            }
            adRewardView.B();
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadSuccess(us.pinguo.advsdk.a.b bVar) {
            us.pinguo.common.log.a.m("HomeRewardAdvDialogController", "onLoadSuccess", new Object[0]);
            AdRewardView adRewardView = HomeRewardAdvDialogController.this.f6766g;
            if (adRewardView != null) {
                adRewardView.l();
            }
            us.pinguo.ad.b.a.c(HomeRewardAdvDialogController.this.b, "Camera360_505", HomeRewardAdvDialogController.this);
        }
    }

    /* compiled from: HomeRewardAdvDialogController.kt */
    /* loaded from: classes3.dex */
    public static final class c extends OnBackPressedCallback {
        c() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            View m;
            boolean z = false;
            if (HomeRewardAdvDialogController.this.p()) {
                AdRewardView adRewardView = HomeRewardAdvDialogController.this.f6766g;
                if (adRewardView != null && (m = adRewardView.m()) != null && m.getVisibility() == 0) {
                    z = true;
                }
                if (z) {
                    us.pinguo.foundation.statistics.h.b.A0(HomeRewardAdvDialogController.this.c, "rewarded_ads", "exit");
                }
                HomeRewardAdvDialogController.this.l();
                return;
            }
            setEnabled(false);
        }
    }

    /* compiled from: HomeRewardAdvDialogController.kt */
    /* loaded from: classes3.dex */
    public static final class d implements b.a {
        d() {
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadFailed(int i2, String str) {
            us.pinguo.common.log.a.m("HomeRewardAdvDialogController", "preload onLoadFailed==>" + ((Object) str) + "===>" + i2, new Object[0]);
            HomeRewardAdvDialogController.this.f6763d = 2;
            if (HomeRewardAdvDialogController.this.f6765f) {
                kotlin.jvm.b.l<Boolean, kotlin.u> o = HomeRewardAdvDialogController.this.o();
                if (o != null) {
                    o.invoke(Boolean.FALSE);
                }
                AdRewardView adRewardView = HomeRewardAdvDialogController.this.f6766g;
                if (adRewardView == null) {
                    return;
                }
                adRewardView.B();
            }
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadSuccess(us.pinguo.advsdk.a.b bVar) {
            us.pinguo.common.log.a.m("HomeRewardAdvDialogController", "preload onLoadSuccess", new Object[0]);
            HomeRewardAdvDialogController.this.f6763d = 3;
            if (HomeRewardAdvDialogController.this.f6765f) {
                AdRewardView adRewardView = HomeRewardAdvDialogController.this.f6766g;
                if (adRewardView != null) {
                    adRewardView.l();
                }
                HomeRewardAdvDialogController.this.v();
            }
        }
    }

    public HomeRewardAdvDialogController(ConstraintLayout root, FragmentActivity activity) {
        kotlin.jvm.internal.s.h(root, "root");
        kotlin.jvm.internal.s.h(activity, "activity");
        this.a = root;
        this.b = activity;
        this.c = "home";
        this.f6768i = kotlinx.coroutines.n0.a(z0.c());
        this.f6769j = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        int i2 = this.f6763d;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f6765f = true;
                AdRewardView adRewardView = this.f6766g;
                if (adRewardView == null) {
                    return;
                }
                adRewardView.A();
                return;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                v();
                return;
            }
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        SimpleDraweeView simpleDraweeView;
        AdRewardView adRewardView = this.f6766g;
        final View m = adRewardView == null ? null : adRewardView.m();
        if (m == null || (simpleDraweeView = (SimpleDraweeView) this.a.findViewById(R.id.imgHomeVip)) == null) {
            return;
        }
        int[] iArr = new int[2];
        m.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = i2 + (m.getWidth() / 2);
        int height = i3 + (m.getHeight() / 2);
        int[] iArr2 = new int[2];
        simpleDraweeView.getLocationInWindow(iArr2);
        int i4 = iArr2[0];
        int i5 = iArr2[1];
        final int width2 = (i4 + (simpleDraweeView.getWidth() / 2)) - width;
        final int abs = Math.abs((i5 + (simpleDraweeView.getHeight() / 2)) - height);
        ValueAnimator animator = ValueAnimator.ofInt(100, 0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.pinguo.camera360.homepage.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeRewardAdvDialogController.n(m, abs, width2, valueAnimator);
            }
        });
        kotlin.jvm.internal.s.g(animator, "animator");
        animator.addListener(new a());
        animator.setDuration(400L);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(View adGuideView, int i2, int i3, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(adGuideView, "$adGuideView");
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f2 = 1 - animatedFraction;
        adGuideView.setTranslationY(-(i2 * animatedFraction));
        adGuideView.setTranslationX(i3 * animatedFraction);
        adGuideView.setScaleX(f2);
        adGuideView.setScaleY(f2);
    }

    private final void r() {
        AdRewardView adRewardView = this.f6766g;
        if (adRewardView != null) {
            adRewardView.A();
        }
        us.pinguo.ad.b.a.b(this.b, "Camera360_505", new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        Context context = this.a.getContext();
        kotlin.jvm.internal.s.g(context, "root.context");
        this.f6766g = new AdRewardView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        if (us.pinguo.ad.b.a.c(this.b, "Camera360_505", this)) {
            return;
        }
        r();
    }

    private final void w() {
        VipManager vipManager = VipManager.a;
        vipManager.V(true);
        vipManager.R(System.currentTimeMillis(), false);
        us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, "first_reward", false, null, 4, null);
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.f6767h;
        if (lVar != null) {
            lVar.invoke(Boolean.TRUE);
        }
        AdRewardView adRewardView = this.f6766g;
        if (adRewardView == null) {
            return;
        }
        AdRewardView.D(adRewardView, 0, new HomeRewardAdvDialogController$showEarnedDialog$1$1(this, adRewardView), 1, null);
    }

    private final void x() {
        AdRewardView adRewardView = this.f6766g;
        if (adRewardView != null) {
            adRewardView.t(new HomeRewardAdvDialogController$showInterruptDialog$1(this), new HomeRewardAdvDialogController$showInterruptDialog$2(this));
        }
        us.pinguo.foundation.statistics.h.b.D0(this.c, "rewarded_ads", "show");
    }

    public static /* synthetic */ void z(HomeRewardAdvDialogController homeRewardAdvDialogController, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        homeRewardAdvDialogController.y(str, z);
    }

    public final void l() {
        AdRewardView adRewardView = this.f6766g;
        if (adRewardView != null) {
            this.a.removeView(adRewardView);
        }
    }

    public final kotlin.jvm.b.l<Boolean, kotlin.u> o() {
        return this.f6767h;
    }

    @Override // us.pinguo.ad.b.InterfaceC0350b
    public void onPlayRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
        this.f6764e = false;
        us.pinguo.common.log.a.m("HomeRewardAdvDialogController", "onPlayRewardVideoFailed", new Object[0]);
        us.pinguo.foundation.statistics.h.b.f0("vip_page", "rewarded_ads", "exit");
    }

    @Override // us.pinguo.ad.b.InterfaceC0350b
    public void onPlayRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
        this.f6764e = true;
        us.pinguo.foundation.statistics.h.b.f0("vip_page", "rewarded_ads", TJAdUnitConstants.String.VIDEO_COMPLETE);
    }

    @Override // us.pinguo.ad.b.InterfaceC0350b
    public void onRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.common.log.a.m("HomeRewardAdvDialogController", "onRewardVideoClose", new Object[0]);
        us.pinguo.ad.b.a.b(this.b, "Camera360_505", null);
        if (this.f6764e) {
            w();
        } else {
            x();
        }
        this.f6764e = false;
        this.f6763d = 0;
        this.f6765f = false;
    }

    public final boolean p() {
        AdRewardView adRewardView = this.f6766g;
        return us.pinguo.edit2020.utils.d.d(adRewardView == null ? null : adRewardView.getParent());
    }

    public final void s() {
        this.f6763d = 1;
        us.pinguo.ad.b.a.b(this.b, "Camera360_505", new d());
    }

    public final void t(kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        this.f6767h = lVar;
    }

    public final void y(String source, boolean z) {
        kotlin.jvm.internal.s.h(source, "source");
        this.c = source;
        kotlinx.coroutines.l.d(this.f6768i, null, null, new HomeRewardAdvDialogController$showRewardAdvTipDialog$1(z, this, source, null), 3, null);
        us.pinguo.foundation.statistics.h.b.A0(source, "rewarded_ads", "show");
    }
}
