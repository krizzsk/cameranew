package com.pinguo.camera360.member;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentActivity;
import com.pinguo.camera360.vip.VipManager;
import com.tapjoy.TJAdUnitConstants;
import us.pinguo.ad.b;
import us.pinguo.common.widget.adv.AdRewardView;
/* compiled from: SubscriptionRewardAdvController.kt */
/* loaded from: classes3.dex */
public final class SubscriptionRewardAdvController implements b.InterfaceC0350b {
    private final ViewGroup a;
    private final FragmentActivity b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private int f6911d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6912e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6913f;

    /* renamed from: g  reason: collision with root package name */
    private AdRewardView f6914g;

    /* renamed from: h  reason: collision with root package name */
    private final kotlinx.coroutines.m0 f6915h;

    /* renamed from: i  reason: collision with root package name */
    private final b f6916i;

    /* compiled from: SubscriptionRewardAdvController.kt */
    /* loaded from: classes3.dex */
    public static final class a implements b.a {
        a() {
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadFailed(int i2, String str) {
            us.pinguo.common.log.a.m("SubscriptionRewardAdvController", "onLoadFailed==>" + ((Object) str) + "===>" + i2, new Object[0]);
            AdRewardView adRewardView = SubscriptionRewardAdvController.this.f6914g;
            if (adRewardView == null) {
                return;
            }
            adRewardView.B();
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadSuccess(us.pinguo.advsdk.a.b bVar) {
            us.pinguo.common.log.a.m("SubscriptionRewardAdvController", "onLoadSuccess", new Object[0]);
            AdRewardView adRewardView = SubscriptionRewardAdvController.this.f6914g;
            if (adRewardView != null) {
                adRewardView.l();
            }
            us.pinguo.ad.b.a.c(SubscriptionRewardAdvController.this.b, "Camera360_505", SubscriptionRewardAdvController.this);
        }
    }

    /* compiled from: SubscriptionRewardAdvController.kt */
    /* loaded from: classes3.dex */
    public static final class b extends OnBackPressedCallback {
        b() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            View m;
            boolean z = false;
            if (SubscriptionRewardAdvController.this.l()) {
                AdRewardView adRewardView = SubscriptionRewardAdvController.this.f6914g;
                if (adRewardView != null && (m = adRewardView.m()) != null && m.getVisibility() == 0) {
                    z = true;
                }
                if (z) {
                    us.pinguo.foundation.statistics.h.b.A0(SubscriptionRewardAdvController.this.c, "rewarded_ads", "exit");
                }
                SubscriptionRewardAdvController.this.k();
                return;
            }
            setEnabled(false);
        }
    }

    /* compiled from: SubscriptionRewardAdvController.kt */
    /* loaded from: classes3.dex */
    public static final class c implements b.a {
        c() {
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadFailed(int i2, String str) {
            AdRewardView adRewardView;
            us.pinguo.common.log.a.m("SubscriptionRewardAdvController", "preload onLoadFailed==>" + ((Object) str) + "===>" + i2, new Object[0]);
            SubscriptionRewardAdvController.this.f6911d = 2;
            if (!SubscriptionRewardAdvController.this.f6913f || (adRewardView = SubscriptionRewardAdvController.this.f6914g) == null) {
                return;
            }
            adRewardView.B();
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadSuccess(us.pinguo.advsdk.a.b bVar) {
            us.pinguo.common.log.a.m("SubscriptionRewardAdvController", "preload onLoadSuccess", new Object[0]);
            SubscriptionRewardAdvController.this.f6911d = 3;
            if (SubscriptionRewardAdvController.this.f6913f) {
                AdRewardView adRewardView = SubscriptionRewardAdvController.this.f6914g;
                if (adRewardView != null) {
                    adRewardView.l();
                }
                SubscriptionRewardAdvController.this.p();
            }
        }
    }

    public SubscriptionRewardAdvController(ViewGroup root, FragmentActivity activity) {
        kotlin.jvm.internal.s.h(root, "root");
        kotlin.jvm.internal.s.h(activity, "activity");
        this.a = root;
        this.b = activity;
        this.c = "";
        this.f6915h = kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c());
        this.f6916i = new b();
    }

    private final void m() {
        AdRewardView adRewardView = this.f6914g;
        if (adRewardView != null) {
            adRewardView.A();
        }
        us.pinguo.ad.b.a.b(this.b, "Camera360_505", new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        Context context = this.a.getContext();
        kotlin.jvm.internal.s.g(context, "root.context");
        this.f6914g = new AdRewardView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (us.pinguo.ad.b.a.c(this.b, "Camera360_505", this)) {
            return;
        }
        m();
    }

    private final void q() {
        VipManager vipManager = VipManager.a;
        vipManager.V(true);
        vipManager.R(System.currentTimeMillis(), false);
        AdRewardView adRewardView = this.f6914g;
        if (adRewardView == null) {
            return;
        }
        AdRewardView.D(adRewardView, 0, new SubscriptionRewardAdvController$showEarnedDialog$1$1(this, adRewardView), 1, null);
    }

    private final void r() {
        AdRewardView adRewardView = this.f6914g;
        if (adRewardView != null) {
            adRewardView.t(new SubscriptionRewardAdvController$showInterruptDialog$1(this), new SubscriptionRewardAdvController$showInterruptDialog$2(this));
        }
        us.pinguo.foundation.statistics.h.b.D0(this.c, "rewarded_ads", "show");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        int i2 = this.f6911d;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f6913f = true;
                AdRewardView adRewardView = this.f6914g;
                if (adRewardView == null) {
                    return;
                }
                adRewardView.A();
                return;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                p();
                return;
            }
        }
        m();
    }

    public final void k() {
        AdRewardView adRewardView = this.f6914g;
        if (adRewardView != null) {
            this.a.removeView(adRewardView);
        }
        this.f6916i.remove();
    }

    public final boolean l() {
        AdRewardView adRewardView = this.f6914g;
        return us.pinguo.edit2020.utils.d.d(adRewardView == null ? null : adRewardView.getParent());
    }

    public final void n() {
        this.f6911d = 1;
        us.pinguo.ad.b.a.b(this.b, "Camera360_505", new c());
    }

    @Override // us.pinguo.ad.b.InterfaceC0350b
    public void onPlayRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
        this.f6912e = false;
        us.pinguo.common.log.a.m("SubscriptionRewardAdvController", "onPlayRewardVideoFailed", new Object[0]);
        us.pinguo.foundation.statistics.h.b.f0("vip_page", "rewarded_ads", "exit");
    }

    @Override // us.pinguo.ad.b.InterfaceC0350b
    public void onPlayRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
        this.f6912e = true;
        us.pinguo.foundation.statistics.h.b.f0("vip_page", "rewarded_ads", TJAdUnitConstants.String.VIDEO_COMPLETE);
    }

    @Override // us.pinguo.ad.b.InterfaceC0350b
    public void onRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.common.log.a.m("SubscriptionRewardAdvController", "onRewardVideoClose", new Object[0]);
        us.pinguo.ad.b.a.b(this.b, "Camera360_505", null);
        if (this.f6912e) {
            q();
        } else {
            r();
        }
        this.f6912e = false;
        this.f6911d = 0;
        this.f6913f = false;
    }

    public final void s(String source) {
        kotlin.jvm.internal.s.h(source, "source");
        this.c = source;
        kotlinx.coroutines.l.d(this.f6915h, null, null, new SubscriptionRewardAdvController$showRewardAd$1(this, null), 3, null);
        us.pinguo.foundation.statistics.h.b.A0(source, "rewarded_ads", "show");
    }
}
